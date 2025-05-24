Feature: US04 Programación de citas con asesores
  Como granjero con poca experiencia,
  quiero programar una cita con un asesor
  para recibir orientación personalizada en el sector agropecuario.

  Scenario Outline: Programar cita
    Given el <granjero> con poca experiencia desea programar una cita.
    And se encuentra en el apartado de “Horarios Disponibles” del perfil de un <asesor> en su dispositivo móvil.
    When seleccione un <horario disponible>.
    And complete los campos solicitados.
    And haga clic en el <boton> “Reservar Cita”.
    Then el sistema le mostrará un <mensaje> de confirmación.

    Examples:
      | granjero | Asesor     | horario disponible | mensaje de confirmacion |
      | Manuel   | Mario A.   | 8:00 am - 10:00 am | Cita programada con éxito |
      | María    | Sofía B.   | 9:00 am - 11:00 am | Cita programada con éxito |

  Scenario Outline: Fallar al programar cita
    Given el <granjero> con poca experiencia desea programar una cita.
    And se encuentra en el apartado de “Horarios Disponibles” del perfil de un asesor.
    When seleccione un <horario disponible>.
    And se encuentra un <error> técnico o de conexión que impide completar la programación.
    Then el sistema le mostrará un <mensaje> de error.

    Examples:
      | granjero | Asesor     | horario disponible | error | mensaje de error  |
      | Manuel   | Mario A.   | 8:00 am - 10:00 am | 404   | Error de conexión |
      | María    | Sofía B.   | 9:00 am - 11:00 am | 500   | Error interno     |