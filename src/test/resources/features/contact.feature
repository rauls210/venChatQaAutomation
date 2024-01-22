@VenChat
Feature: Contacto en la App VenChat

  Background:
    Given Inicio sesion en app de venChat
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"

  @Contact
    @Contact_001
  Scenario: Buscar a un contacto
    When Busco al contacto "Dominicana 1" en contactos
    Then Valido que se encontro el contacto

  @Contact
    @Contact_002
  Scenario: Buscar a un contacto que no existe
    When Busco al contacto "no existe" en contactos
    Then Valido que no se encontro el contacto

  @Contact
    @Contact_003
  Scenario: Llamar a un contacto
    When Busco al contacto "Dominicana 1" en contactos
    And Realizo la llamada en contacto
    Then Valido que se realizo la llamada

  @Contact
    @Contact_004
  Scenario: Videollamada a un contacto
    When Busco al contacto "Dominicana 1" en contactos
    And Realizo la videollamada en contacto
    Then Valido que se realizo la videollamada

