@VenChat
Feature: Perfil en la App VenChat

  Background:
    Given Inicio sesion en app de venChat
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"

  @MyProfile
    @MyProfile_001
  Scenario: Ingresar a mi perfil de usuario
    When Ingreso a mi perfil
    Then Valido que estoy en mi perfil

  @MyProfile
    @MyProfile_002
  Scenario: Modificar el nombre de mi perfil
    When Modifico el nombre de mi perfil "Cambio el nombre"
    Then Valido que se edito el nombre de mi perfil

  @MyProfile
    @MyProfile_003
  Scenario: Abrir foto de perfil
    When Ingreso a mi perfil
    Then Valido que se visualiza la foto de perfil