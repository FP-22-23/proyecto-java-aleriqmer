package fp.trabajos.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import fp.trabajos.CategoriaTrabajo;
import fp.trabajos.ContenedorDatos;
import fp.trabajos.FactoriaTrabajo;
import fp.trabajos.Trabajo;

public class TestContenedor {
	
		public static void main(String[] args) {
			ContenedorDatos Trabajos = FactoriaTrabajo.leeTrabajo("./data/dataset_NY.csv");
			
			//Test operaciones
			testexisteTrabajoEnFecha(Trabajos, LocalDate.of(2022, 06, 02));
			testNumeroTrabajosMasDe6Horas(Trabajos);
			testTrabajosTerminadosPorCualidades(Trabajos, List.of("seriedad", "comprensividad","serenidad"));
			testagrupaTrabajosPorNumSol(Trabajos, 10);
			testNumeroTrabajosPorCategoria(Trabajos);
			
			testexisteTrabajoEnFechaStreams(Trabajos, LocalDate.of(2022, 06, 02));
			testNumeroTrabajosMasDe6HorasStreams(Trabajos);
			testTrabajosTerminadosPorCualidadesStreams(Trabajos, List.of("seriedad", "comprensividad","serenidad"));
			testobtenerTrabajoFinalizadoMejorPagado(Trabajos);
			testobtenerTrabajosDuracion8HorasOrdenadosPorCantidadPagada(Trabajos);
			
			testNumeroTrabajosPorCategoriaStreams(Trabajos);
			testobtenerCantidadPagadaPorSolicitudes(Trabajos);
			testobtenerTrabajosMejorPagadosPorTipo(Trabajos);
			testobtenerTrabajosMenosSolicitadosPorTipo(Trabajos);
			testobtenerTrabajoResumenMayorPorTipo(Trabajos);
			
			
			
		}
		private static void testexisteTrabajoEnFecha(ContenedorDatos Trabajos, LocalDate fecha) {
			System.out.println("=============================");
			System.out.println("Conjunto de pruebas sobre las funciones de ContenedorDatos");
			System.out.println("=============================");
			System.out.println("");	
			System.out.println("==========FUNCION 1==========");
			System.out.println("¿Existe algun trabajo realizado en la fecha " + fecha + "? : " + Trabajos.existeTrabajoEnFecha(fecha));
			System.out.println("=============================");
			System.out.println("");

			
		}
		
		private static void testNumeroTrabajosMasDe6Horas(ContenedorDatos Trabajos) {
			System.out.println("==========FUNCION 2==========");
			System.out.println("¿Cuantos trabajos tienen una duracion de mas de 6 horas? : " + Trabajos.NumeroTrabajosMasDe6Horas());
			System.out.println("=============================");
			System.out.println("");
		}
		
		private static void testTrabajosTerminadosPorCualidades(ContenedorDatos Trabajos, List<String> cualidades) {
			System.out.println("==========FUNCION 3==========");
			System.out.println("A continuacion se muestra un trabajo que precise de las cualidades introducidas como parametro con la condicion de que debe estar finalizado : " + Trabajos.TrabajosTerminadosPorCualidades(cualidades));
			System.out.println("=============================");
			System.out.println("");
		}
		
		private static void testagrupaTrabajosPorNumSol(ContenedorDatos Trabajos, Integer solicitud) {
			System.out.println("==========FUNCION 4==========");
			System.out.println("Diccionario donde se muestran todos los trabajos cuyo numero de solicitudes sea en introducido : " + Trabajos.agrupaTrabajosPorNumSol(solicitud));
			System.out.println("=============================");
			System.out.println("");
		}
		
		private static void testNumeroTrabajosPorCategoria(ContenedorDatos Trabajos) {
			System.out.println("==========FUNCION 5==========");
			System.out.println("Diccionario con los trabajos agrupados segun su categoria : " + Trabajos.NumeroTrabajosPorCategoria());
			System.out.println("=============================");
			System.out.println("");
		}

		private static void testexisteTrabajoEnFechaStreams(ContenedorDatos Trabajos, LocalDate fecha ) {
			System.out.println("==========FUNCION 6==========");
			System.out.println("¿Existe algun trabajo realizado en la fecha " + fecha + "? : " + Trabajos.existeTrabajoEnFechaStreams(fecha));
			System.out.println("=============================");
			System.out.println("");
		}	
		
		private static void testNumeroTrabajosMasDe6HorasStreams(ContenedorDatos Trabajos) {
			System.out.println("==========FUNCION 7==========");
			System.out.println("¿Cuantos trabajos tienen una duracion de mas de 6 horas? : " + Trabajos.numeroTrabajosMasDe6HorasStreams());
			System.out.println("=============================");
			System.out.println("");
		}
		
		private static void testTrabajosTerminadosPorCualidadesStreams(ContenedorDatos Trabajos, List<String> cualidades) {
			System.out.println("==========FUNCION 8==========");
			System.out.println("A continuacion se muestra un trabajo que precise de las cualidades introducidas como parametro con la condicion de que debe estar finalizado : " + Trabajos.TrabajosTerminadosPorCualidadesStreams(cualidades));
			System.out.println("=============================");
			System.out.println("");
		}
		
		private static void testobtenerTrabajoFinalizadoMejorPagado(ContenedorDatos Trabajos) {
			System.out.println("==========FUNCION 9==========");
			System.out.println("Se muestra el trabajo finalizado que ha sido mejor pagado : " + Trabajos.obtenerTrabajoFinalizadoMejorPagado());
			System.out.println("=============================");
			System.out.println("");
		}
		
		private static void testobtenerTrabajosDuracion8HorasOrdenadosPorCantidadPagada(ContenedorDatos Trabajos) {
			System.out.println("==========FUNCION 10=========");
			System.out.println("Se muestran los trabajos que han durado al menos 8 horas ordenados de menor a mayor segun la cantidad pagada : " + Trabajos.obtenerTrabajosDuracion8HorasOrdenadosPorCantidadPagada());
			System.out.println("=============================");
			System.out.println("");
		}
		
		private static void testNumeroTrabajosPorCategoriaStreams(ContenedorDatos Trabajos) {
			System.out.println("==========FUNCION 11=========");
			System.out.println("Diccionario con los trabajos agrupados segun su categoria : " + Trabajos.numeroTrabajosPorCategoriaStreams());
			System.out.println("=============================");
			System.out.println("");
		}
		
		private static void testobtenerCantidadPagadaPorSolicitudes(ContenedorDatos Trabajos) {
			System.out.println("==========FUNCION 12=========");
			System.out.println("Diccionario con los trabajos agrupados por numero solicitudes donde las claves toman como valor las cantidades pagadas : " + Trabajos.obtenerCantidadPagadaPorSolicitudes());
			System.out.println("=============================");
			System.out.println("");
		}
		
		private static void testobtenerTrabajosMejorPagadosPorTipo(ContenedorDatos Trabajos) {
			System.out.println("==========FUNCION 13=========");
			System.out.println("Diccionario con la mayor cantidad pagada segun la categoria del trabajo : " + Trabajos.obtenerTrabajosMejorPagadosPorTipo());
			System.out.println("=============================");
			System.out.println("");
		}
		
		private static void testobtenerTrabajosMenosSolicitadosPorTipo(ContenedorDatos Trabajos) {
			System.out.println("==========FUNCION 14=========");
			System.out.println("Diccionario con los trabajos solicitados menos de 10 veces de cada tipo de trabajo : " + Trabajos.obtenerTrabajosMenosSolicitadosPorTipo());
			System.out.println("=============================");
			System.out.println("");
		}
		
		private static void testobtenerTrabajoResumenMayorPorTipo(ContenedorDatos Trabajos) {
			System.out.println("==========FUNCION 15=========");
			System.out.println("Tipo de trabajo que cuenta con el resumen más largo, se indican el numero de caracteres del resumen : " + Trabajos.obtenerTrabajoResumenMayorPorTipo());
			System.out.println("=============================");
			System.out.println("");
		}
		
}