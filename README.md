# Proyecto del Segundo Cuatrimestre Fundamentos de Programacion (Curso  22/23)
/// Autor: Alejandro Riquelme Merino  ///  uvus: aleriqmer  ///  Correo: aleriqmer@alum.us.es ///

Este proyecto tiene como objetivo analizar diversos datos sobre distintos trabajos realizados en la ciudad de Nueva York, estos datos han sido recogidos en una hoja de datos de 10 columnas.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto.
  * **fp.trabajos**: Paquete que contiene los tipos del proyecto.
  * **fp.trabajos.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **dataset_NY**: Contiene diversos datos sobre trabajos realizados en Nueva York , como la fecha y hora en la que fueron realizados, el numero de horas trabajadas,  etc.

    
## Estructura del *dataset* "dataset_NY"

El dataset esta compuesto de 10 columnas que contienen numerosos datos acerca de diversos empleos ofertados en Nueva York.

El dataset esta compuesto por 10 columnas, con la siguiente descripcion:

* **Numero_solicitudes**: de tipo Integer, representa el numero de solicitudes recibidas para aceptar el trabajo.
* **Resumen**: de tipo String, representa un pequeño resumen de la tarea a realizar.
* **Categoria**: de tipo CategoriaTrabajo, representa la categoria en la que está clasificada el trabajo, puede ser StrengtheningCommunities, Education, HelpingNeighborsinNeed, Environment o Health.
* **Nombre_organizacion**: de tipo String, representa el nombre de la organizacion que presenta la oferta de trabajo.
* **Fecha_inicio**: de tipo Localdate, representa la fecha en la que estaba prevista la realizacion del trabajo.
* **Hora_inicio**: de tipo Time, representa la hora a la que se dio comienzo el trabajo.
* **Cantidad_pagada**: de tipo Double, representa la cantidad de euros que fueron cobrados.
* **Duracion_horas**: de tipo Double, representa la duracion en horas del trabajo.
* **Trabajo_completado**: de tipo Boolean, se da el valor true si el trabajo fue completado satisfactoriamente y false si no lo fue.
* **Cualidades_buscadas**: de tipo List, representa una lista de las cualidades que la organizacion busca en la persona que vaya a realizar el trabajo.

## Tipos implementados

Los tipos que se han implementado hasta ahora en el proyecto son los siguientes:

### Tipo base
Representa el conjunto de datos de un trabajo determinado.

**Propiedades**:
- *Numero_solicitudes*, de tipo Integer, consultable. 
- *Resumen*, de tipo String, consultable. 
- *Categoria*, de tipo CategoriaTrabajo, consultable.
- *Nombre_organizacion*, de tipo String, consultable.
- *Fecha_inicio*, de tipo Localdate, consultable y modificable.
- *Hora_inicio*, de tipo Time, consultable y modificable.
- *Cantidad_pagada*, de tipo Double, consultable y modificable.
- *Duracion_horas*, de tipo Integer, consultable y modificable.
- *Trabajo_completado*, de tipo Boolean, consultable y modificable.
- *Cualidades_buscadas*, de tipo List, consultable y modificable.

**Constructores**: 
- C1: Tiene un parametro por cada propiedad basica del tipo.
- C2: crea un objeto de tipo `Trabajo` con los siguientes parametros, `String Resumen, CategoriaTrabajo Categoria, Double Cantidad_pagada, Integer Duracion_horas`.

**Restricciones**:
- R1: La duracion del trabajo no puede ser menor de 1.
- R2: El cobro no puede ser negativo.
- R3: La fecha de inicio debe ser posterior al año 1950.

**Criterio de igualdad**: Por el resumen del trabajo, el nombre de la organizacion, la cantidad pagada y la duracion de horas.

**Criterio de ordenacion**: Por el resumen del trabajo, el nombre de la organizacion y la cantidad pagada.

####**Tipos auxiliares**:
- **CategoriaTrabajo**: enumerado. Puede tomar los valores StrengtheningCommunities, Education, HelpingNeighborsinNeed, Environment, Health.
 
### Factoria - FactoriaEstrella
Clase de factoria para construir objetos de tipo Trabajo.
 
 * **leeTrabajo(String fichero)**: Crea un objeto de tipo Trabajo a partir de la informacion recogida en el archivo csv, cuya ruta se da como parametro.

### Tipo Contenedor - ContenedorDatos
Clase contenedora de los objetos de tipo Estrella.

**Propiedades**:
- *Numero_solicitudes*, de tipo Integer, consultable. 
- *Resumen*, de tipo String, consultable. 
- *Categoria*, de tipo CategoriaTrabajo, consultable.
- *Nombre_organizacion*, de tipo String, consultable.
- *Fecha_inicio*, de tipo Localdate, consultable y modificable.
- *Hora_inicio*, de tipo Time, consultable y modificable.
- *Cantidad_pagada*, de tipo Double, consultable y modificable.
- *Duracion_horas*, de tipo Integer, consultable y modificable.
- *Trabajo_completado*, de tipo Boolean, consultable y modificable.
- *Cualidades_buscadas*, de tipo List, consultable y modificable.
- *Trabajos*, de tipo List, consultable y modificable.

**Constructores**: 
- C1: Tiene un parametro por cada propiedad basica del tipo.
- C2: crea un objeto con los mismas propiedades que C1 añadiendo `List<String> Trabajos`.

**Criterio de igualdad**: Por el resumen del trabajo, el nombre de la organizacion y el numero de solicitudes presentadas.

**Otras operaciones**: 

- **void NumTrabajos**: Obtiene el numero de Trabajos del objeto.
- **void incorporaTrabajo(Trabajo p)**: Añade un Trabajo al objeto
- **void incorporaTrabajos(List<Trabajo> totalTrabajos):**  añade una lista de Trabajos al objeto.
- **void eliminaTrabajos(Trabajo c)**: Elimina el Trabajo del objeto.

- **Boolean existeOrganizacionConSiguienteNombre(String nombre)**: Devuelve true si existe alguna organizacion con el nombre indicado, false si no existe.
- **Integer getNumeroTrabajosMasDe6Horas()**: Devuelve una lista con el resumen de todos los trabajos que duran mas de 6 horas.
- **List<Trabajo> getTrabajosPorCategoria(CategoriaTrabajo Categoria)**: devuelve una lista con los datos de los trabajos recogidos en la lista inicial que sean de la categoria dada.
- **Map<Integer,List<Trabajo>> agrupaTrabajosPorNumSol(Integer solicitud)**: devuelve un map que agrupa los trabajos segun el numero de solicitudes presentadas.
- **Map<CategoriaTrabajo,Long> getNumeroTrabajosPorCategoria()**: devuelve un mapa en el que las claves son los distintos posibles valores del tipo Categoria y el valor de cada clave es el numero de Trabajos que corresponden a la misma.