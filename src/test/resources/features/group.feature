@VenChat
Feature: Manejo de grupos en VenChat

  Background:
    Given Inicio sesion en app de venChat
    When Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"

  @Group
  @Group_001
  Scenario: Crear un chat grupal con un administrador
    When Creo un grupo llamado "1 administrador" con el participante "Dominicana 1"
    And Valido se creo el grupo
    And Elimino el grupo llamado "1 administrador"

  @Group
  @Group_002
  Scenario: Crear un chat grupal con 2 administradores
    When Creo un grupo llamado "2 administradores" con el participante "Dominicana 1"
    And Abro informacion del grupo
    And Hago al integrante "Dominicana 1" administrador del grupo
    Then Valido hay 2 admministradores en el grupo
    And Elimino el grupo llamado "2 administradores"

  @Group
  @Group_003
  Scenario: Valido la informacion de un contacto desde chat grupal
    When Creo un grupo llamado "Verificar Informacion" con el participante "Dominicana 1"
    And Abro informacion del grupo
    Then Valido informacion de "Dominicana 1" que posee el numero "+11234567890" desde grupo
    And Elimino el grupo llamado "Verificar Informacion"

  @Group
  @Group_004
  Scenario: Cambiar nombre del chat grupal
    When Creo un grupo llamado "Cambiar nombre" con el participante "Dominicana 1"
    And Abro informacion del grupo
    And Cambio el nombre del grupo a "Nuevo nombre"
    Then Valido se cambio el nombre del grupo a "Nuevo nombre"
    And Elimino el grupo llamado "Nuevo nombre"

  @Group
  @Group_005
  Scenario: Agregar contacto a un grupo siendo administrador
    When Creo un grupo llamado "Agregar participante" con el participante "Dominicana 1"
    And Abro informacion del grupo
    Then Valido puedo agregar a "Dominicana 3" al grupo
    And Elimino el grupo llamado "Agregar participante"

  @Group
  @Group_006
  Scenario: Agregar contacto a un grupo sin ser administrador
    When Abro chat grupal llamado "Prueba manual"
    And Abro informacion del grupo
    Then Valido no puedo agregar una persona a un grupo sin ser administrador

  @Group
  @Group_007
  Scenario: Enviar mensaje en Modo seguro
    When Creo un grupo llamado "Modo seguro" con el participante "Dominicana 1"
    Then Valido que pueda enviar mensajes modo seguro
    And Elimino el grupo llamado "Modo seguro"

  @Group
  @Group_008
  Scenario: Enviar mensaje en Modo confidencial
    When Creo un grupo llamado "Modo confidencial" con el participante "Dominicana 1"
    Then Valido que pueda enviar mensajes modo confidencial
    And Elimino el grupo llamado "Modo confidencial"

  @Group
  @Group_009
  Scenario: Enviar mensaje en Modo borrado automatico
    When Creo un grupo llamado "Modo borrado automatico" con el participante "Dominicana 1"
    Then Valido que pueda enviar mensajes modo borrado automatico
    And Elimino el grupo llamado "Modo borrado automatico"

  @Group
  @Group_010
  Scenario: Enviar nota de voz
    When Creo un grupo llamado "Nota de voz" con el participante "Dominicana 1"
    Then Valido que pueda enviar notas de voz
    And Elimino el grupo llamado "Nota de voz"

  @Group
  @Group_011
  Scenario: Enviar foto desde la galeria
    When Creo un grupo llamado "Foto desde galeria" con el participante "Dominicana 1"
    Then Valido que pueda enviar fotos desde la galeria
    And Elimino el grupo llamado "Foto desde galeria"

  @Group
  @Group_012
  Scenario: Enviar foto desde la camara
    When Creo un grupo llamado "Foto desde camara" con el participante "Dominicana 1"
    Then Valido que pueda enviar fotos desde la camara
    And Elimino el grupo llamado "Foto desde camara"

  @Group
  @Group_013
  Scenario: Enviar documentos
    When Creo un grupo llamado "Enviar documentos" con el participante "Dominicana 1"
    Then Valido que pueda enviar documentos
    And Elimino el grupo llamado "Enviar documentos"

  @Group
  @Group_014
  Scenario: Abrir la pantalla de archivos del grupo
    When Creo un grupo llamado "abrir archivos" con el participante "Dominicana 1"
    Then Valido que se visualiza el archivo en la pantalla de archivos
    And Elimino el grupo llamado "abrir archivos"

  @Group
  @Group_015
  Scenario: Agregar a un nuevo integrante que este bloqueado
    When Abro chat grupal llamado "algo"
    And Abro informacion del grupo
    Then Valido que no puedo agregar a la persona "Mi Número" a un grupo si esta bloqueado

  @Group
  @Group_016
  Scenario: Abandonar un grupo donde hay dos administradores, sin agregar nuevo administrador
    When Creo un nuevo grupo llamado "Prueba Abandonar 3" con los integrantes "Dominicana 1" y "Dominicana 3"
    And Abro informacion del grupo
    And Hago al integrante "Dominicana 1" administrador del grupo
    Then Valido que puedo abandonar el grupo "Prueba Abandonar 3" que posee dos administradores
    And Elimino el grupo llamado "Prueba Abandonar 3"

  @Group
  @Group_017
  Scenario: Abandonar un grupo donde soy unico administrador, sin agregar nuevo administrador
    When Creo un nuevo grupo llamado "Prueba Abandonar 4" con los integrantes "Dominicana 1" y "Dominicana 3"
    Then Valido no puedo abandonar el grupo "Prueba Abandonar 4" donde soy unico administrador sin agregar otro administrador
    And Elimino el grupo llamado "Prueba Abandonar 4"

  @Group
  @Group_018
  Scenario: Elimino un integrante siendo administrador
    When Creo un grupo llamado "Eliminar integrante" con el participante "Dominicana 1"
    And Abro informacion del grupo
    And Elimino "Dominicana 1" del grupo
    Then Valido "Dominicana 1" no esta en el Grupo
    And Elimino el grupo llamado "Eliminar integrante"

  @Group
  @Group_019
  Scenario: Elimino integrante cuando no soy administrador
    When Abro chat grupal llamado "No Administrador"
    And Abro informacion del grupo
    Then Valido no puedo eliminar "Dominicana 1" del grupo no siendo administrador

  @Group
  @Group_020
  Scenario: Elimino un grupo
    When Creo un grupo llamado "Eliminar Grupo" con el participante "Dominicana 1"
    And Elimino el grupo llamado "Eliminar Grupo"
    Then Valido no existe un grupo llamado "Eliminar Grupo"

  @Group
  @Group_021
  Scenario: Envio de emoji
    When Creo un grupo llamado "enviar un emoji" con el participante "Dominicana 1"
    Then Valido que pueda enviar un emoji
    And Elimino el grupo llamado "enviar un emoji"

  @Group
  @Group_022
  Scenario: Envio de gif
    When Creo un grupo llamado "enviar un gif" con el participante "Dominicana 1"
    Then Valido que pueda enviar un gif
    And Elimino el grupo llamado "enviar un gif"

  @Group
  @Group_023
  Scenario: Envio de sticker
    When Creo un grupo llamado "enviar un sticker" con el participante "Dominicana 1"
    Then Valido que pueda enviar un sticker
    And Elimino el grupo llamado "enviar un sticker"

  @Group
  @Group_024
  Scenario: Eliminar mensaje para mi
    When Creo un grupo llamado "Eliminar mensaje" con el participante "Dominicana 1"
    Then Elimino un mensaje enviado para mi
    And Elimino el grupo llamado "Eliminar mensaje"

  @Group
  @Group_025
  Scenario: Eliminar mensaje para todos.
    When Creo un grupo llamado "Eliminar mensaje" con el participante "Dominicana 1"
    Then Elimino un mensaje enviado para todos
    And Elimino el grupo llamado "Eliminar mensaje"

  @Group
  @Group_026
  Scenario: Citar una imagen
    When Creo un grupo llamado "Citar imagen" con el participante "Dominicana 1"
    Then Valido que pueda citar una imagen
    And Elimino el grupo llamado "Citar imagen"

  @Group
  @Group_027
  Scenario: Citar un video
    When Creo un grupo llamado "Citar video" con el participante "Dominicana 1"
    Then Valido que pueda citar un video
    And Elimino el grupo llamado "Citar video"

  @Group
  @Group_028
  Scenario: Citar un documento
    When Creo un grupo llamado "Citar documento" con el participante "Dominicana 1"
    Then Valido que pueda citar un documento
    And Elimino el grupo llamado "Citar documento"

  @Group
  @Group_029
  Scenario: Citar una nota de voz
    When Creo un grupo llamado "Citar audio" con el participante "Dominicana 1"
    Then Valido que pueda citar una nota de voz
    And Elimino el grupo llamado "Citar audio"

  @Group
  @Group_030
  Scenario: Citar un mensaje confidencial
    When Creo un grupo llamado "Citar confidencial" con el participante "Dominicana 1"
    Then Valido que pueda citar un mensaje confidencial
    And Elimino el grupo llamado "Citar confidencial"

  @Group
  @Group_031
  Scenario: Citar un gif
    When Creo un grupo llamado "Citar gif" con el participante "Dominicana 1"
    Then Valido que pueda citar un gif
    And Elimino el grupo llamado "Citar gif"

  @Group
  @Group_032
  Scenario: Citar un emoji
    When Creo un grupo llamado "Citar emoji" con el participante "Dominicana 1"
    Then Valido que pueda citar un emoji
    And Elimino el grupo llamado "Citar emoji"

  @Group
  @Group_033
  Scenario: Citar un sticker
    When Creo un grupo llamado "Citar sticker" con el participante "Dominicana 1"
    Then Valido que pueda citar un sticker
    And Elimino el grupo llamado "Citar sticker"

  @Group
  @Group_034
  Scenario: Crear nuevo grupo sin asunto
    When Creo un nuevo grupo sin asunto
    Then Valido que no se ingreso el asunto

  @Group
  @Group_035
  Scenario: Salir y eliminar el grupo para mi
    When Creo un grupo llamado "Equipo de Calidad" con el participante "Dominicana 1"
    And Salir y eliminar el grupo para mi
    Then Valido que se elimino el grupo

  @Group
  @Group_036
  Scenario: Modificar la descripcion al grupo
    When Modifico la descripcion del grupo a "Grupo de prueba"
    Then Valido que se modifico la descripcion del grupo

  @Group
  @Group_037
  Scenario: Eliminar un grupo para todos - SWIPE
    When Creo un grupo llamado "Equipo de Calidad" con el participante "Dominicana 1"
    And Elimino el nuevo grupo para todos usando swipe
    Then Valido que se elimino el grupo