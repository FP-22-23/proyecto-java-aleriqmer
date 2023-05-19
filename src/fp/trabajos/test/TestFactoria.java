package fp.trabajos.test;

import fp.trabajos.ContenedorDatos;
import fp.trabajos.FactoriaTrabajo;
import fp.trabajos.Trabajo;

import java.util.List;

public class TestFactoria { 
		public static void main(String[] args) {
			
			testleeTrabajo("./data/dataset_NY.csv");
			
		}
		private static void testleeTrabajo (String fichero) {
			System.out.println("Test factoria trabajo: ");
			ContenedorDatos Trabajo = FactoriaTrabajo.leeTrabajo("./data/dataset_NY.csv");
			System.out.println(Trabajo);
		}
	}