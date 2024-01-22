@VenChat
Feature: Llamada en la App VenChat

  Background:
    Given Inicio sesion en app de venChat
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"

  @Call
  @Call_001
  Scenario: Llamo a un contacto
    When Busco al contacto "Dominicana 1" en nueva llamada
    And Realizo la llamada en nueva llamada
    Then Valido que se realizo la llamada

  @Call
  @Call_002
  Scenario: Videollamada con un contacto
    When Busco al contacto "Dominicana 1" en nueva llamada
    And Realizo la videollamada en nueva llamada
    Then Valido que se realizo la videollamada
