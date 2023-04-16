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
			List<Trabajo> Trabajos = FactoriaTrabajo.leeTrabajo("./data/dataset_NY.csv");}
		ContenedorDatos T1 = new ContenedorDatos(5, "Help us set up a new training classroom to teach young adults personal finance!",
				"Cents Ability, Inc.", 7, 167.28, false, LocalDate.of(2021, 12, 23), LocalTime.of(9,28),
				CategoriaTrabajo.StrengtheningCommunities, List.of("seriedad, comprensividad, serenidad"));
		ContenedorDatos T2 = new ContenedorDatos(5, "Mentor homeless children between the ages of 2 to 12 at our weekend enrichment program.",
				"Cents Ability, Inc.", 7, 167.28, false, LocalDate.of(2021, 12, 23), LocalTime.of(9,28),
				CategoriaTrabajo.StrengtheningCommunities, List.of("seriedad, comprensividad, serenidad"));
		
		private static void testNumTrabajos(ContenedorDatos T1) {
		System.out.println("El numero de Trabajos es el siguiente: "+ T1.NumTrabajos());
		}
		
		private static void testincorporaTrabajo(ContenedorDatos T1) {
		System.out.println("Se ha añadido el elemento T2: "+ T1.incorporaTrabajo(T2));
		}
		
		private static void testeliminaTrabajos(ContenedorDatos T1) {
		System.out.println("Se ha eliminado el elemento T2: "+ T1.eliminaTrabajos(T2));
		}
		
		private static void testexisteOrganizacionConSiguienteNombre(ContenedorDatos Trabajos) {
			System.out.println("---- TEST de existeOrganizacionConSiguienteNombre ----\n");
			try {
				String nombre = "Cents Ability, Inc.";
				System.out.println("¿Existe una organizacion llamada " + nombre + "?: " + Trabajos.existeOrganizacionConSiguienteNombre(nombre));
			}catch(Exception e) {
				System.out.println("EXCEPCIÓN CAPTURADA!! " +e.getMessage());
			}
		}
		
		private static void testNumeroTrabajosMasDe6Horas(ContenedorDatos Trabajos) {
			System.out.println("---- TEST de getNumeroTrabajosMasDe6Horas ----\n");
			try {
				System.out.println("¿Cuantos Trabajos duran mas de 6 hora ?: " + Trabajos.getNumeroTrabajosMasDe6Horas());
			}catch(Exception e) {
				System.out.println("EXCEPCIÓN CAPTURADA!! " +e.getMessage());
			}
		}
		
		private static void testTrabajosPorCategoria(ContenedorDatos Trabajos) {
			System.out.println("---- TEST de getTrabajosPorCategoria ----\n");

			try {
				CategoriaTrabajo cat = CategoriaTrabajo.Education;
				System.out.println("¿Cuantos trabajos tienen la categoria " + cat + "?: " + Trabajos.getTrabajosPorCategoria(cat));
			}catch(Exception e) {
				System.out.println("EXCEPCIÓN CAPTURADA!! " +e.getMessage());
			}
		}
		
		private static void testagrupaTrabajosPorNumSol(ContenedorDatos Trabajos) {
			System.out.println("---- TEST de agrupaTrabajosPorNumSol ----\n");

			try {
				Integer sol = 5;
				System.out.println("Resumen de trabajos agrupados por numero de solicitudes: " + Trabajos.agrupaTrabajosPorNumSol(sol));
			}catch(Exception e) {
				System.out.println("EXCEPCIÓN CAPTURADA!! " +e.getMessage());
			}
		}
		
		private static void testgetNumeroTrabajosPorCategoria(ContenedorDatos Trabajos) {
			System.out.println("---- TEST de getNumeroTrabajosPorCategoria ----\n");

			try {
				System.out.println("La cantidad de Trabajos que tiene cada categoria es la siguiente: " + Trabajos.getNumeroTrabajosPorCategoria());
			}catch(Exception e) {
				System.out.println("EXCEPCIÓN CAPTURADA!! " +e.getMessage());
			}
			
		}
		
}