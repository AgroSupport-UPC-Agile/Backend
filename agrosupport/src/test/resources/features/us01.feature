Feature: US01 Visualización del catálogo de asesores
  Como granjero con poca experiencia,
  quiero explorar el catálogo de asesores
  para conocer quiénes me pueden apoyar con asesorías.

  Scenario Outline: Explorar el catálogo de asesores
    Given que <granjero> accede a la aplicación
    When selecciona la opción "Catálogo de asesores"
    Then el sistema muestra la lista de asesores disponibles: <lista de asesores>

    Examples:
      | granjero | lista de asesores              |
      | Martin   | Luis A., Marco S., Marta M.    |
      | Nadia    | Nicolás M., Luisa C., Óscar L. |

  Scenario Outline: Filtrar la búsqueda de asesores
    Given que <granjero> está en la sección de asesores
    When aplica el filtro por <criterio de filtro>
    Then el sistema muestra la lista filtrada de asesores: <asesores filtrados>

    Examples:
      | granjero | criterio de filtro | asesores filtrados         |
      | Martin   | Nombre            | Luis A., Marco S.          |
      | Nadia    | Reputación        | Nicolás M., Luisa C.       |