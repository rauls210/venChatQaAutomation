@VenChat
Feature: Loguin en la App VenChat

  Background:
    Given Inicio sesion en app de venChat

  @Login
    @Login_001
  Scenario: Loguearse de forma exitosa
    When Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    Then Valido que me logueo de forma exitosa

  @Login
    @Login_002
  Scenario: Ingresar un numero de telefono no registrado
    When Ingreso el numero de telefono "5522448899"
    Then Valido que el numero de telefono no esta registrado

  @Login
    @Login_003
  Scenario: No ingresar un numero de telefono
    When No ingreso el numero de telefono
    Then Valido que no se ingreso un numero de telefono

  @Login
    @Login_004
  Scenario: Ingresar un numero de telefono incompleto
    When Ingreso el numero de telefono "323456789"
    Then Valido que el numero de telefono esta incompleto

  @Login
    @Login_005
  Scenario: Ingresar el codigo incorrecto
    When Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "123456"
    Then Valido que el codigo es incorrecta

  @Login
    @Login_006
  Scenario: No ingresar el codigo
    When Ingreso el numero de telefono "2234567890"
    And No ingreso el codigo
    Then Valido que no se ingreso el codigo

  @Login
    @Login_007
  Scenario: Ingresar el codigo incompleto
    When Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222"
    Then Valido que el codigo esta incompleto

  @Login
    @Login_008
  Scenario: Cerrar sesion
    When Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    Then Valido que se cerro la sesion
