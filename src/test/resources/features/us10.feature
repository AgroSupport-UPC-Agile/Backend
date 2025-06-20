Feature: US10 Inicio de sesión
  Como usuario
  quiero acceder a mi cuenta registrada
  para acceder a las funciones de usuario.

  Scenario Outline: Inicio de sesión exitoso
    Given el <usuario> desea acceder a su cuenta registrada.
    And se encuentra en el apartado de “Iniciar Sesión”.
    When introduzca sus <credenciales> correctamente.
    Then será redireccionado a su vista de usuario.

    Examples:
      | usuario | credenciales          |
      | Pablo   | usuario...contraseña  |
      | Ana     | usuario...contraseña  |


  Scenario Outline: Inicio de sesión fallido
    Given el <usuario> desea acceder a su cuenta registrada.
    And se encuentra en el apartado de “Iniciar Sesión”.
    When introduzca sus <credenciales> incorrectamente.
    Then no se le permitirá acceso a su cuenta.
    And recibirá un <mensaje indicando el error>.


    Examples:
      | usuario | credenciales          | mensaje indicando el error        |
      | Pablo   | usuario...contraseña  | Usuario y/o contraseña incorrecta |
      | Ana     | usuario...contraseña  | Usuario y/o contraseña incorrecta |


  Scenario Outline: Bloqueo de sesión por exceso de intentos
    Given el <usuario> desea acceder a su cuenta registrada.
    And se encuentra en el apartado de “Iniciar sesión”.
    When introduzca sus <credenciales> incorrectamente.
    And siga errando hasta alcanzar el número máximo de intentos permitidos (tres intentos).
    Then recibirá un <mensaje que le informe que ha excedido el numero de intentos permitidos>.
    And su cuenta será bloqueada temporalmente.

    Examples:
      | usuario | credenciales          | mensaje que le informe que ha excedido el numero de intentos permitidos |
      | Pablo   | usuario...contraseña  | Cuenta bloqueada por multiples intentos fallidos                        |
      | Ana     | usuario...contraseña  | Cuenta bloqueada por multiples intentos fallidos                        |

