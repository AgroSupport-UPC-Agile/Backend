Feature: US05 Calificación del asesor luego de una cita
  Como granjero con poca experiencia,
  quiero calificar al asesor luego de la consulta
  para ayudar a otros granjeros a tomar una decisión informada antes de separar una cita.

  Scenario Outline: Calificar al asesor
    Given el "<granjero>" con poca experiencia desea hacer un feedback referente al servicio del asesor.
    And se encuentra en la vista de historial de asesorías.
    And selecciona una "<cita asesoría>" sin reseña.
    When haga clic en el botón "Calificar Servicio" en la interfaz.
    Then el sistema le permitirá asignarle un "<calificación>" y reseñar "<comentario>" del servicio del asesor.

    Examples:
      | granjero | cita asesoría  | calificación | comentario     |
      | Pedro    | 08/09 11:00 AM | 4            | Muy bueno      |
      | María    | 22/10 05:00 PM | 5            | Lo recomiendo! |

  Scenario Outline: Omitir Calificación
    Given el "<granjero>" con poca experiencia no desea dar feedback al asesor referente al servicio.
    And se encuentra en la vista de historial de asesorías.
    And selecciona una "<cita asesoría>" sin reseña.
    When haga clic en el botón "Omitir Calificación" en la interfaz.
    Then el sistema le permitirá omitir la reseña.

    Examples:
      | granjero | cita asesoría  | calificación |
      | Marco    | 11/10 09:00 AM | omitida      |