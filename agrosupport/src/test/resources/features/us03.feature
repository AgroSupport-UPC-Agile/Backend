Feature: US03 Visualización de horarios de asesores
  Como granjero con poca experiencia,
  quiero ver los horarios disponibles de los asesores en mi móvil
  para seleccionar un horario que se ajuste a mi agenda.

  Scenario Outline: Visualizar horarios disponibles
    Given el <granjero> con poca experiencia desea visualizar los <horarios disponibles> de un <asesor elegido>.
    And se encuentra viendo la información del perfil de un asesor en su dispositivo móvil.
    When haga clic en el <boton> “Reservar Cita” en la interfaz móvil.
    Then el sistema le mostrará una interfaz con los <horarios disponibles del asesor>.

    Examples:
      | granjero | asesor elegido | horarios disponibles del asesor       |
      | Pedro    | Mario C.       | 8:00 am - 10:00 am, 2:00 pm - 4:00 pm |
      | Nadia    | Arturo M.      | 9:00 am - 11:00 am, 3:00 pm - 5:00 pm |

  Scenario Outline: Fallar al intentar visualizar horarios
    Given el <granjero> con poca experiencia desea visualizar los <horarios disponibles> del <asesor elegido>.
    And se encuentra viendo la información del perfil de un asesor en su dispositivo móvil.
    When haga clic en el <boton> “Reservar Cita” en la interfaz móvil.
    And el asesor no tenga horarios disponibles.
    Then el sistema le mostrará un <mensaje> de error “El asesor no tiene horarios disponibles” en la interfaz móvil.

    Examples:
      | granjero | asesor elegido | mensaje de error                         |
      | Pedro    | Mario C.       | El asesor no tiene horarios disponibles  |
      | Nadia    | Arturo M.      | El asesor no tiene horarios disponibles  |