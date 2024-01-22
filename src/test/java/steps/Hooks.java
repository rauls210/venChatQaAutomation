package steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

@Log4j2
public class Hooks {

	/**
	 * Declaración de variables estáticas y constantes.
	 */
	protected static AndroidDriver driver;
	protected static WebDriverWait wait;
	protected static Actions action;
	protected final static PointerInput FINGER = new PointerInput(TOUCH, "FINGER");
	public static String aux = null;
	public static String auxTwo = null;
	public static String userToken = null;
	public static String hubToken = null;
	private static final String PLATFORM_NAME = "Android";
	private static final String AUTOMATION_NAME = "UIAutomator2";
    private static final String APP_PACKAGE = "com.cybercapitalparnerscorp.venchat.develop";
    private static final String APP_ACTIVITY = "com.cybercapitalparnerscorp.venchat.develop.MainActivity";
	private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/";

	/**
	 * Configuración para escenarios con etiqueta @CC200.
	 * Crea las capacidades concediendo permisos automáticamente.
	 * Inicializa el driver de Appium y registra un mensaje informativo.
	 */
	@Before("@VenChat")
	public void setUpWithoutAutoPermissions() {
		DesiredCapabilities caps = createCapabilities(true);
		initializeDriver(caps);
		log.info("Iniciando la aplicación de VenChat con permisos automáticos");
	}

	/**
	 * Configuración para escenarios con etiqueta @autoPermissions.
	 * Crea las capacidades sin conceder permisos automáticamente.
	 * Inicializa el driver de Appium y registra un mensaje informativo.
	 */
	@Before("@autoPermissions")
	public void setUpWithAutoPermissions() {
		DesiredCapabilities caps = createCapabilities(false);
		initializeDriver(caps);
		log.info("Iniciando la aplicación de VenChat sin conceder permisos automáticamente");
	}

	/**
	 * Crea las capacidades de la aplicación según la configuración especificada.
	 * @param autoGrantPermissions Indica si se deben conceder permisos automáticamente.
	 * @return Las capacidades configuradas.
	 */
	private DesiredCapabilities createCapabilities(boolean autoGrantPermissions) {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
		caps.setCapability("appPackage", APP_PACKAGE);
		caps.setCapability("appActivity", APP_ACTIVITY);
		caps.setCapability("autoGrantPermissions", autoGrantPermissions);
		return caps;
	}

	/**
	 * Inicializa el driver de Appium con las capacidades proporcionadas.
	 * @param caps Las capacidades de la aplicación.
	 */
	private void initializeDriver(DesiredCapabilities caps) {
		try {
			URL androidDriver = new URL(APPIUM_SERVER_URL);
			driver = new AndroidDriver(androidDriver, caps);
			action = new Actions(driver);
		} catch (MalformedURLException e) {
			log.error("Error al iniciar la aplicación: " + e.getMessage());
			throw new RuntimeException("Error al iniciar la aplicación", e);
		}
	}

	/**
	 * Después de las pruebas, realiza la limpieza y captura de pantalla en caso de fallo.
	 * @param scenario El escenario de prueba.
	 */
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			captureScreenshotAndAttachToReport(scenario);
		}
		closeApp();
	}

	/**
	 * Captura de pantalla en caso de fallo y adjunta al informe.
	 * @param scenario El escenario de prueba.
	 */
	private void captureScreenshotAndAttachToReport(Scenario scenario) {
		byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "files/png", "El escenario falló, consulte la imagen adjunta.");
	}

	/**
	 * Cierra la aplicación al finalizar las pruebas.
	 */
	public static void closeApp() {
		if (driver != null) {
			try {
				driver.quit();
				driver = null;
			} catch (WebDriverException e) {
				throw new RuntimeException("Error al cerrar la aplicación: " + e.getMessage(), e);
			}
		}
	}

	/**
	 * Encuentra un elemento en la página por su locator utilizando XPath.
	 * @param locator El locator utilizado para encontrar el elemento.
	 * @return El elemento encontrado.
	 * @throws NoSuchElementException Si el elemento no se encuentra o no es visible.
	 */
	private WebElement find(String locator) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		} catch (TimeoutException e) {
			throw new NoSuchElementException("Elemento no encontrado o no visible: " + locator);
		}
	}

	/**
	 * Encuentra varios elementos en la página por su locator utilizando XPath.
	 * @param locator El locator utilizado para encontrar los elementos.
	 * @return Una lista de elementos encontrados.
	 * @throws NoSuchElementException Si los elementos no se encuentran o no son visibles.
	 */
	private List<WebElement> finds(String locator) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
		} catch (TimeoutException e) {
			throw new NoSuchElementException("Elementos no encontrados o no visibles: " + locator);
		}
	}

	/**
	 * Realiza clic en un elemento identificado por su locator.
	 * @param locator El locator del elemento en el que se realizará clic.
	 */
	public void clickElement(String locator) {
		try {
			find(locator).click();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Elemento no encontrado: " + locator);
		} catch (ElementNotInteractableException e) {
			throw new ElementNotInteractableException("El elemento no es interactuable: " + locator);
		} catch (StaleElementReferenceException e) {
			throw new StaleElementReferenceException("El elemento se volvió obsoleto: " + locator);
		}
	}

	/**
	 * Realiza clic en un elemento utilizando acciones (por ejemplo, moverse antes de hacer clic).
	 * @param element El locator del elemento en el que se realizará clic.
	 */
	public void clickElementActions(String element) {
		try {
			WebElement targetElement = find(element);
			action.moveToElement(targetElement).click().perform();
		} catch (NoSuchElementException e) {
			System.err.println("Excepción: El elemento no fue encontrado. Detalles: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Excepción no esperada. Detalles: " + e.getMessage());
		}
	}

	/**
	 * Escribe texto en un elemento identificado por su locator.
	 * @param locator      El locator del elemento en el que se escribirá el texto.
	 * @param textToWrite  El texto que se escribirá en el elemento.
	 * @throws NoSuchElementException          Si el elemento no se encuentra.
	 * @throws ElementNotInteractableException Si el elemento no es interactuable.
	 */
	public void write(String locator, String textToWrite) {
		try {
			find(locator).clear();
			find(locator).sendKeys(textToWrite);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Elemento no encontrado: " + locator);
		} catch (ElementNotInteractableException e) {
			throw new ElementNotInteractableException("El elemento no es interactuable: " + locator);
		}
	}

	/**
	 * Escribe en el teclado sin especificar un locator específico.
	 * @param locator El texto que se escribirá en el teclado.
	 * @throws RuntimeException Si no se puede escribir en el teclado debido a que el elemento no es interactuable
	 *                        		o si ocurre un error inesperado al escribir en el teclado.
	 */
	public void writeKeyboard(String locator) {
		try {
			action.sendKeys(locator).perform();
		} catch (ElementNotInteractableException e) {
			throw new RuntimeException("No se pudo escribir en el teclado. Elemento no interactuable.", e);
		} catch (Exception e) {
			throw new RuntimeException("Ocurrió un error al escribir en el teclado.", e);
		}
	}

	/**
	 * Oculta el teclado en dispositivos móviles.
	 * @throws RuntimeException Si ocurre un error al intentar ocultar el teclado.
	 */
	public void hideKeyboard() {
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			throw new RuntimeException("Error al ocultar el teclado: " + e.getMessage(), e);
		}
	}

	/**
	 * Carga un archivo en el navegador móvil desde una ubicación local a una ubicación remota.
	 * @param localFileName Nombre del archivo en la ubicación local.
	 * @param remotePath    Ruta remota donde se debe almacenar el archivo en el navegador móvil.
	 * @throws RuntimeException Si ocurre un error durante la carga del archivo.
	 */
	public void loadFile(String localFileName, String remotePath) {
		try {
			File localFile = new File(localFileName);
			driver.pushFile(remotePath, localFile);
		} catch (IOException e) {
			log.error("Error al cargar el archivo: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/**
	 * Simula un toque en una ubicación específica en la pantalla táctil del dispositivo móvil.
	 * @param xPercent Coordenada X en porcentaje de la anchura de la pantalla donde se realizará el toque.
	 * @param yPercent Coordenada Y en porcentaje de la altura de la pantalla donde se realizará el toque.
	 */
	public void touch(double xPercent, double yPercent) {
		try {
			Dimension size = driver.manage().window().getSize();
			int x = (int) (size.width * xPercent);
			int y = (int) (size.height * yPercent);

			PointerInput finger = new PointerInput(TOUCH, "FINGER");
			Sequence tap = new Sequence(finger, 1);
			tap.addAction(finger.createPointerMove(ofMillis(0), viewport(), x, y));
			tap.addAction(finger.createPointerDown(LEFT.asArg()));
			tap.addAction(new Pause(FINGER, ofMillis(0)));
			tap.addAction(finger.createPointerUp(LEFT.asArg()));

			driver.perform(List.of(tap));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Realiza un desplazamiento en la pantalla táctil desde un punto inicial hasta un punto final.
	 * @param startXPerc Porcentaje de la anchura de la pantalla donde inicia el desplazamiento.
	 * @param startYPerc Porcentaje de la altura de la pantalla donde inicia el desplazamiento.
	 * @param endXPerc   Porcentaje de la anchura de la pantalla donde finaliza el desplazamiento.
	 * @param endYPerc   Porcentaje de la altura de la pantalla donde finaliza el desplazamiento.
	 */
	public void swipe(double startXPerc, double startYPerc, double endXPerc, double endYPerc) {
		try {
			Dimension size = driver.manage().window().getSize();
			int startX = (int) (size.width * startXPerc);
			int startY = (int) (size.height * startYPerc);
			int endX = (int) (size.width * endXPerc);
			int endY = (int) (size.height * endYPerc);

			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
			Sequence swipe = new Sequence(finger, 0);
			swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
			swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			swipe.addAction(new Pause(finger, Duration.ofMillis(400)));
			swipe.addAction(finger.createPointerMove(Duration.ofMillis(400), PointerInput.Origin.viewport(), endX, endY));
			swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			driver.perform(List.of(swipe));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Realiza un toque y mantiene presionado en una ubicación específica en la pantalla.
	 * @param xPercent Porcentaje de la anchura de la pantalla donde se realizará el toque.
	 * @param yPercent Porcentaje de la altura de la pantalla donde se realizará el toque.
	 */
	public void touchAndHold(double xPercent, double yPercent) {
		try {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
			Sequence tap = new Sequence(finger, 1);

			Dimension size = driver.manage().window().getSize();
			int x = (int) (size.width * xPercent);
			int y = (int) (size.height * yPercent);

			tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
			tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			tap.addAction(new Pause(finger, Duration.ofMillis(1000)));
			tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			driver.perform(List.of(tap));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Realiza un toque y mantiene presionado en un elemento específico.
	 * @param locator El locator del elemento en el que se realizará el toque y mantendrá presionado.
	 */
	public void touchAndHolElement(String locator) {
		try {
			Point location = find(locator).getLocation();

			int x = location.getX() + 50;
			int y = location.getY() + 50;

			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
			Sequence tap = new Sequence(finger, 1);

			tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
			tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			tap.addAction(new Pause(finger, Duration.ofMillis(1000)));
			tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			driver.perform(List.of(tap));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Realiza un toque en un elemento específico.
	 * @param locator El locator del elemento en el que se realizará el toque.
	 */
	public void touchElement(String locator) {
		try {
			Point location = find(locator).getLocation();

			int x = location.getX() + 50;
			int y = location.getY() + 50;

			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
			Sequence tap = new Sequence(finger, 1);

			tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
			tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			tap.addAction(new Pause(finger, Duration.ofMillis(0)));
			tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			driver.perform(List.of(tap));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Navega hacia atrás en la aplicación móvil.
	 */
	public void navigateBack() {
		driver.navigate().back();
	}

	/**
	 * Borra el contenido de un elemento identificado por su locator.
	 * @param locator El locator del elemento utilizando XPath.
	 */
	public void clearElement(String locator) {
		try {
			find(locator).clear();
		} catch (NoSuchElementException e) {
			System.out.println("Elemento no encontrado: " + locator);
			throw new RuntimeException(e);
		} catch (ElementNotInteractableException e) {
			System.out.println("El elemento no es interactuable: " + locator);
			throw new RuntimeException(e);
		}
	}

	/**
	 * Selecciona un elemento de un menú desplegable por su valor.
	 * @param locator El locator del elemento utilizando XPath.
	 * @param valueToSelect El valor del elemento que se desea seleccionar en el menú desplegable.
	 */
	public void selectFromDropdownByValue(String locator, String valueToSelect) {
		try {
			Select dropdown = new Select(find(locator));
			dropdown.selectByValue(valueToSelect);
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			System.out.println("Error al seleccionar el elemento del menú desplegable por valor: " + e.getMessage());
		}
	}

	/**
	 * Selecciona un elemento de un menú desplegable por su índice.
	 * @param locator El locator del elemento utilizando XPath.
	 * @param valueToSelect El índice del elemento que se desea seleccionar en el menú desplegable.
	 */
	public void selectFromDropdownByIndex(String locator, int valueToSelect) {
		try {
			Select dropdown = new Select(find(locator));
			dropdown.selectByIndex(valueToSelect);
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			System.out.println("Error al seleccionar el elemento del menú desplegable por índice: " + e.getMessage());
		}
	}

	/**
	 * Selecciona un elemento de un menú desplegable por su texto visible.
	 * @param locator El locator del elemento utilizando XPath.
	 * @param valueToSelect El texto visible del elemento que se desea seleccionar en el menú desplegable.
	 */
	public void selectFromDropdownByText(String locator, String valueToSelect) {
		try {
			Select dropdown = new Select(find(locator));
			dropdown.selectByVisibleText(valueToSelect);
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			System.out.println("Error al seleccionar el elemento del menú desplegable por texto visible: " + e.getMessage());
		}
	}

	/**
	 * Obtiene el texto de un elemento identificado por su locator.
	 * @param locator El locator del elemento utilizando XPath.
	 * @return El texto del elemento o una cadena vacía si el texto es nulo.
	 */
	public String textFromElement(String locator) {
		try {
			WebElement element = find(locator);
			if (element != null) {
				String text = element.getText();
				return (text != null) ? text : "";
			} else {
				return "";
			}
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			System.out.println("Error al leer el texto del elemento: " + e.getMessage());
			return "";
		}
	}

	/**
	 * Obtiene el valor del atributo 'content-desc' de un elemento.
	 * @param locator El localizador del elemento.
	 * @return El valor del atributo 'content-desc'.
	 * @throws NoSuchElementException Si el elemento no tiene un atributo 'content-desc' válido.
	 */
	public String textFromElementAttribute(String locator) throws NoSuchElementException {
		try {
			String contentDesc = find(locator).getAttribute("content-desc");
			if (contentDesc != null && !contentDesc.isEmpty()) {
				return contentDesc;
			} else {
				throw new NoSuchElementException("El elemento no tiene un atributo 'content-desc' válido.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Error al leer el atributo 'content-desc' del elemento: " + e.getMessage());
			throw new NoSuchElementException("El elemento no tiene un atributo 'content-desc' válido.");
		}
	}

	/**
	 * Verifica si un elemento está habilitado.
	 * @param locator El localizador del elemento.
	 * @return true si el elemento está habilitado, false en caso contrario.
	 */
	public boolean elementEnabled(String locator) {
		try {
			return find(locator).isEnabled();
		} catch (NoSuchElementException e) {
			System.out.println("Error al verificar si el elemento está habilitado: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Verifica si un elemento está visible en la página.
	 * @param locator El localizador del elemento.
	 * @return true si el elemento está visible, false en caso contrario.
	 */
	public boolean elementIsDisplayed(String locator) {
		try {
			return find(locator).isDisplayed();
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			System.out.println("Error al verificar si el elemento está visible: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Verifica si un elemento está seleccionado.
	 * @param locator El localizador del elemento.
	 * @return true si el elemento está seleccionado, false en caso contrario.
	 */
	public boolean elementIsSelected(String locator) {
		try {
			WebElement element = find(locator);
			return (element != null) && element.isSelected();
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			System.out.println("Error al verificar si el elemento está seleccionado: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Verifica si el texto de un elemento está vacío.
	 * @param locator El localizador del elemento.
	 * @return true si el texto del elemento está vacío, false en caso contrario.
	 */
	public boolean isTextEmpty(String locator) {
		return textFromElement(locator).isEmpty();
	}

	/**
	 * Obtiene una lista de todos los elementos que coinciden con el localizador.
	 * @param locator El localizador de los elementos.
	 * @return La lista de elementos.
	 */
	public List<WebElement> bringMeAllElements(String locator) {
		return finds(locator);
	}

	/**
	 * Lee el texto de una lista de elementos y lo devuelve como una lista de cadenas.
	 * @param locator El localizador de los elementos.
	 * @return La lista de textos de los elementos.
	 */
	public List<String> readFromElements(String locator) {
		try {
			List<WebElement> elements = bringMeAllElements(locator);
			List<String> textList = new ArrayList<>();

			for (WebElement element : elements) {
				textList.add(element.getText());
			}

			return textList;
		} catch (Exception e) {
			System.out.println("Error al leer el texto de los elementos: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Lee el valor del atributo 'content-desc' de una lista de elementos y lo devuelve como una lista de cadenas.
	 * @param locator El localizador de los elementos.
	 * @return La lista de valores del atributo 'content-desc'.
	 */
	public List<String> readFromElementsAttribute(String locator) {
		try {
			List<WebElement> elements = bringMeAllElements(locator);
			List<String> contentDescList = new ArrayList<>();

			for (WebElement element : elements) {
				contentDescList.add(element.getAttribute("content-desc"));
			}

			return contentDescList;
		} catch (Exception e) {
			System.out.println("Error al leer el atributo 'content-desc' de los elementos: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Realiza una acción de clic y mantenimiento sobre un elemento.
	 * @param locator El localizador del elemento.
	 */
	public void clickAndHold(String locator) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(find(locator));
			actions.clickAndHold().pause(1000).release().perform();
		} catch (Exception e) {
			System.out.println("Error al hacer clic y mantener presionado el elemento: " + e.getMessage());
		}
	}

	/**
	 * Elimina un registro enviando una solicitud DELETE a una URL específica con datos JSON.
	 */
	public void deleteRegister() {
		String baseUrl = "https://devel.ven.chat/api/dev/user";
		String json = "{ \"phoneNumber\": \"+13234567890\" }";

		RequestSpecification request = RestAssured.given();
		request.header("Authorization", getHubToken());
		request.contentType(ContentType.JSON);
		request.body(json);

		Response response = request.delete(baseUrl);
		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();

		System.out.println("Código de respuesta: " + statusCode);
		System.err.println("Cuerpo de respuesta: " + responseBody);
	}

	/**
	 * Obtiene el token de autenticación para realizar solicitudes en la aplicación.
	 * @return El token de autenticación.
	 */
	public String getHubToken() {
		String baseUrl = "https://devel.ven.chat/api/dev/token";
		String json = "{\"username\":\"rvelazquez@nolatech.ai\",\"password\":\"rvelazquez@nolatech.ai\"}";

		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "109E6z9wBTJM8A9icEe9GAjPssxydSGM889mhcpKUb1PfSHANEryy7");
		request.contentType(ContentType.JSON);
		request.body(json);

		Response response = request.post(baseUrl);
		int statusCode = response.getStatusCode();
		String cachedToken = null;

		if (statusCode == 200) {
			cachedToken = response.jsonPath().getString("data.token");
			System.err.println(cachedToken);
		}
		return cachedToken;
	}

	/**
	 * Busca un usuario en la aplicación y devuelve su identificador.
	 * @return El identificador del usuario.
	 * @throws IllegalStateException Si no se encuentran usuarios en la respuesta.
	 */
	public String searchUser() {
		String baseUrl = "https://devel.ven.chat/api/dev/user?criteria=3234567890";
		hubToken = getHubToken();

		RequestSpecification request = RestAssured.given();
		request.header("Authorization", hubToken);
		request.contentType(ContentType.JSON);

		Response response = request.get(baseUrl);
		List<String> userIds = response.jsonPath().getList("data.users._id");

		if (!userIds.isEmpty()) {
			return userIds.get(0);
		} else {
			throw new IllegalStateException("No se encontraron usuarios en la respuesta.");
		}
	}

	/**
	 * Obtiene el token de usuario para realizar solicitudes en nombre del usuario.
	 * @return El token de usuario.
	 */
	public String getUserToken() {
		String baseUrl = "https://devel.ven.chat/user/usertoken";
		String id = searchUser();
		String json = "{ \"id\": \"" + id + "\" }";

		RequestSpecification request = RestAssured.given();
		request.header("Authorization", hubToken);
		request.contentType(ContentType.JSON);
		request.body(json);

		Response response = request.post(baseUrl);
		int statusCode = response.getStatusCode();
		String cachedToken = null;

		if (statusCode == 200) {
			cachedToken = response.jsonPath().getString("data");
		}
		return cachedToken;
	}

	/**
	 * Lista todos los grupos y busca uno por su nombre, devolviendo el identificador del grupo.
	 * @param name El nombre del grupo a buscar.
	 * @return El identificador del grupo.
	 * @throws RuntimeException Si no se encuentra un grupo con el nombre proporcionado.
	 */
	public String listGroups(String name) {
		String baseUrl = "https://devel.ven.chat/api/chat/myrooms?type=GROUP";
		userToken = getUserToken();

		RequestSpecification request = RestAssured.given();
		request.header("Authorization", userToken);
		request.contentType(ContentType.JSON);

		Response response = request.get(baseUrl);
		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();

		System.out.println("Código de respuesta: " + statusCode);
		System.err.println("Cuerpo de respuesta: " + responseBody);

		JsonPath jsonPath = response.jsonPath();

		List<Map<String, Object>> rooms = jsonPath.getList("data.rooms");

		for (Map<String, Object> room : rooms) {
			if (name.equals(room.get("name"))) {
				return room.get("room").toString();
			}
		}
		throw new RuntimeException("No se encontró una habitación con el nombre 'Equipo de calida'");
	}

	/**
	 * Elimina un grupo en la aplicación utilizando su nombre.
	 * @param name El nombre del grupo.
	 */
	public void deleteGroup(String name) {
		String groupId = listGroups(name);
		String baseUrl = "https://devel.ven.chat/api/chat/group/" + groupId;

		RequestSpecification request = RestAssured.given();
		request.header("Authorization", userToken);
		request.contentType(ContentType.JSON);

		Response response = request.delete(baseUrl);
		int statusCode = response.getStatusCode();

		System.out.println("Código de respuesta: " + statusCode);
	}
}