@autoPermissions
Feature: Manejo de acceso sin permisos en Venchat

  @Permission
  @Permission_001
  Scenario: Acceder a los contactos sin dar permisos
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When  Abro la lista de contactos
    Then Valido que se visualiza el mensaje pidiendo acceso

  @Permission
  @Permission_002
  Scenario: Enviar una foto de la galeria sin dar permisos
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Abro un chat reciente
    And Envio una foto desde la galeria
    Then Valido que se visualiza el mensaje pidiendo acceso

  @Permission
  @Permission_003
  Scenario: Acceder a la camara sin dar permisos
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Abro un chat reciente
    And Envio una foto desde la camara
    Then Valido que se visualiza el mensaje pidiendo acceso

  @Permission
  @Permission_004
  Scenario: Enviar un video de la galeria sin dar permisos
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Abro un chat reciente
    And Envio un video desde la galeria
    Then Valido que se visualiza el mensaje pidiendo acceso

  @Permission
  @Permission_005
  Scenario: Acceder a la camara en un grupo sin dar permiso
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Ingreso a un grupo
    Then Valido que se visualiza el mensaje pidiendo acceso a la camara

  @Permission
  @Permission_006
  Scenario: Compartir ubicacion en un chat sin dar permiso
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Abro un chat reciente
    And Comparto mi ubicacion por chat
    Then Valido que se visualiza el mensaje pidiendo acceso a la ubicacion

  @Permission
  @Permission_007
  Scenario: Enviar una nota de voz sin dar permisos
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Abro un chat reciente
    And Envio una nota de voz
    Then Valido que se visualiza el mensaje pidiendo acceso

  @Permission
  @Permission_008
  Scenario: Enviar un documento sin dar permisos
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Abro un chat reciente
    And Envio un documento
    Then Valido que se visualiza el mensaje pidiendo acceso

  @Permission
  @Permission_009
  Scenario: Acceder a la camara al modificar el perfil sin dar permiso
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Abro mi perfil
    And Cambio mi foto desde la camara
    Then Valido que se visualiza el mensaje pidiendo acceso

  @Permission
  @Permission_010
  Scenario: Acceder a la galeria al modificar el perfil sin dar permiso
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Abro mi perfil
    And Cambio mi foto desde la galeria
    Then Valido que se visualiza el mensaje pidiendo acceso

  @Permission
  @Permission_011
  Scenario: Acceder a la camara al registrar una cuenta sin dar permiso
    Given Registrar cuenta en app de venChat sin dar permisos
    And Ingreso el numero de telefono "3234567890"
    And Ingreso el codigo "333333"
    When Agrego al registro una foto desde la camara
    Then Valido que se visualiza el mensaje pidiendo acceso

  @Permission
  @Permission_012
  Scenario: Acceder a la galeria al registrar una cuenta sin dar permiso
    Given Registrar cuenta en app de venChat sin dar permisos
    And Ingreso el numero de telefono "3234567890"
    And Ingreso el codigo "333333"
    When Agrego al registro una foto desde la galeria
    Then Valido que se visualiza el mensaje pidiendo acceso

  @Permission
  @Permission_013
  Scenario: Agregar un contacto a un grupo sin dar permiso
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Ingreso a un grupo
    And Abro agregar participante
    Then Valido que se visualiza el mensaje pidiendo acceso a los contactos

  @Permission
  @Permission_014
  Scenario: Realizar una llamada sin dar permiso
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Abro un chat reciente
    And Realizo una llamada
    Then Valido que se visualiza el mensaje pidiendo acceso a las llamadas

  @Permission
  @Permission_015
  Scenario: Acceder a la camara en una videollamada sin dar permiso
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Abro un chat reciente
    And Realizo una llamada
    Then Valido que se visualiza el mensaje pidiendo acceso a las llamadas

  @Permission
  @Permission_016
  Scenario: Enviar un mensaje a un contacto sin dar permiso
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Abro un chat reciente
    And Envio un mensaje

  @Permission
  @Permission_017
  Scenario: Enviar un mensaje a un grupo sin dar permiso
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Ingreso a un grupo
    And Envio un mensaje

  @Permission
  @Permission_018
  Scenario: Crear un grupo con foto de perfil sin permiso
    Given Inicio sesion en app de venChat sin dar permisos
    And Ingreso el numero de telefono "2234567890"
    And Ingreso el codigo "222222"
    When Creo un grupo sin permisos
    Then Valido que se visualiza el mensaje pidiendo acceso a la camara
