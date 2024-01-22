@VenChat
Feature: Pantalla de chat en la App VenChat

  Background:
    Given Inicio sesion en app de venChat
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"

  @Chat
  @Chat_001
  Scenario: Abrir un nuevo chat P2P
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que se creo un nuevo chat

  @Chat
  @Chat_002
  Scenario: Ingresar a la pantalla de información de contacto desde chat P2P
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que visualizo la informacion del contacto: nro "+11234567890", nombre "Dominicana 1"

  @Chat
  @Chat_003
  Scenario: Enviar mensaje modo seguro
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda enviar mensajes modo seguro
    And Elimino el chat

  @Chat
  @Chat_004
  Scenario: Enviar mensaje modo confidencial
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda enviar mensajes modo confidencial
    And Elimino el chat

  @Chat
  @Chat_005
  Scenario: Citar un mensaje modo confidencial
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda citar un mensaje confidencial
    And Elimino el chat

  @Chat
  @Chat_006
  Scenario: Enviar mensaje modo borrado automatico
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda enviar mensajes modo borrado automatico
    And Elimino el chat

  @Chat
  @Chat_007
  Scenario: Citar un mensaje enviado
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda citar un mensaje
    And Elimino el chat

  @Chat
  @Chat_008
  Scenario: Enviar una nota de voz
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda enviar notas de voz
    And Elimino el chat

  @Chat
  @Chat_009
  Scenario: Citar una nota de voz
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda citar una nota de voz
    And Elimino el chat

  @Chat
  @Chat_010
  Scenario: Enviar una imagen desde galeria
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda enviar fotos desde la galeria
    And Elimino el chat

  @Chat
  @Chat_011
  Scenario: Enviar una imagen desde camara
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda enviar fotos desde la camara
    And Elimino el chat

  @Chat
  @Chat_012
  Scenario: Citar una imagen
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda citar una imagen
    And Elimino el chat

  @Chat
  @Chat_013
  Scenario: Enviar un video desde galeria
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda enviar videos desde galeria
    And Elimino el chat

  @Chat
  @Chat_014
  Scenario: Citar un video desde galeria
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda citar un video
    And Elimino el chat

  @Chat
  @Chat_015
  Scenario: Enviar un documento
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda enviar documentos
    And Elimino el chat

  @Chat
  @Chat_016
  Scenario: Citar un documento
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda citar un documento
    And Elimino el chat

  @Chat
  @Chat_017
  Scenario: Ingresar a la pantalla de archivos
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que se visualiza el archivo en la pantalla de archivos
    And Elimino el chat

  @Chat
  @Chat_018
  Scenario: Eliminar un mensaje para mi
    When Abro un nuevo chat "Dominicana 1"
    Then Elimino un mensaje enviado para mi
    And Elimino el chat

  @Chat
  @Chat_019
  Scenario: Eliminar un mensaje para todos
    When Abro un nuevo chat "Dominicana 1"
    Then Elimino un mensaje enviado para todos
    And Elimino el chat
  @Chat
  @Chat_020
  Scenario: Eliminar un chat
    When Abro un nuevo chat "Dominicana 1"
    And Envio un mensaje seguro
    Then Valido eliminar el chat

  @Chat
  @Chat_021
  Scenario: Bloquear y desbloquear contacto
    When Abro un nuevo chat "Dominicana 1"
    Then Bloqueo al contacto
    And Desbloqueo al contacto
    And Elimino el chat

  @Chat
  @Chat_022
  Scenario: Enviar un emoji
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda enviar un emoji
    And Elimino el chat

  @Chat
  @Chat_023
  Scenario: Citar emoji
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda citar un emoji
    And Elimino el chat

  @Chat
  @Chat_024
  Scenario: Envio de gif
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda enviar un gif
    And Elimino el chat

  @Chat
  @Chat_025
  Scenario: Citar gif
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda citar un gif
    And Elimino el chat

  @Chat
  @Chat_026
  Scenario: Envio de sticker
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda enviar un sticker
    And Elimino el chat

  @Chat
  @Chat_027
  Scenario: Citar sticker
    When Abro un nuevo chat "Dominicana 1"
    Then Valido que pueda citar un sticker
    And Elimino el chat
