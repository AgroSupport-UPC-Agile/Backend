Feature: US09 Registro de un usuario nuevo
  Como usuario,
  quiero registrarme
  para acceder a las funciones de usuario.

  Scenario Outline: Registro de cuenta por formulario
    Given el <usuario> desea registrarse en la aplicación.
    And se encuentra en el apartado de “Registrarse”.
    When complete el formulario de registro con su <informacion personal>.
    And seleccione su rol en la aplicación entre “Granjero” o “Asesor”.
    And los datos sean correctos según las validaciones establecidas.
    Then la cuenta se creará exitosamente.

    Examples:
      | usuario | informacion personal            |
      | Pablo   | nombre ciudad año de nacimiento |
      | Ana     | nombre ciudad año de nacimiento |


  Scenario Outline: Registro incorrecto de cuenta
    Given el <usuario> se encuentra en el apartado de “Registrarse”.
    When ingrese los datos solicitados de manera errónea.
    Then la cuenta no se creará.
    And recibirá un <mensaje indicando el error> en los datos ingresados.

    Examples:
      | usuario | mensaje indicando el error      |
      | Pablo   | Error en creacion de cuenta     |
      | Ana     | Error en creacion de cuenta     |