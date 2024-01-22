@VenChat
Feature: Registro en la App VenChat

  Background:
    Given Registro en app de venChat

  @Register
  @Register_001
  Scenario: Registrarse de forma exitosa
    And Ingreso el numero de telefono "3234567890"
    And Ingreso el codigo "333333"
    And Completo mi perfil
    Then Valido que me registro de forma exitosa
    And Elimino el registro

  @Register
  @Register_002
  Scenario: Numero de telefono ya esta registrado
    When Ingreso el numero de telefono "2234567890" ya registrado
    Then Valido que ya esta registrado el numero de telefono

  @Register
  @Register_003
  Scenario: No ingresar un numero de telefono
    When No ingreso el numero de telefono
    Then Valido que no se ingreso un numero de telefono

  @Register
  @Register_004
  Scenario: Ingresar el codigo incorrecto
    When Ingreso el numero de telefono "3234567890"
    And Ingreso el codigo "000000"
    Then Valido que el codigo es incorrecta

  @Register
  @Register_005
  Scenario: No ingresar el codigo
    When Ingreso el numero de telefono "3234567890"
    And No ingreso el codigo
    Then Valido que no se ingreso el codigo

  @Register
  @Register_006
  Scenario: No acepta los termino y condiciones
    When Ingreso el numero de telefono "3234567890"
    And Ingreso el codigo "333333"
    Then Valido que me pida aceptar los terminos y condiciones

  @Register
  @Register_007
  Scenario: Registar sin nombre
    When Ingreso el numero de telefono "3234567890"
    And Ingreso el codigo "333333"
    And No ingreso el nombre
    Then Valido que no se ingreso el nombre

  @Register
  @Register_008
  Scenario: Registar sin descripcion
    When Ingreso el numero de telefono "3234567890"
    And Ingreso el codigo "333333"
    And No ingreso la descripcion
    Then Valido que no se ingreso la descripcion