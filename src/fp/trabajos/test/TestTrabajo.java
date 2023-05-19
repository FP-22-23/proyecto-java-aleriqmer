package fp.trabajos.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import fp.trabajos.CategoriaTrabajo;

import fp.trabajos.Trabajo;

public class TestTrabajo {
	public static void main(String[] args) {
		Trabajo E1 = new Trabajo(5, "Help us set up a new training classroom to teach young adults personal finance!",
				"Cents Ability, Inc.", 7, 167.28, false, LocalDate.of(2021, 12, 23), LocalTime.of(9,28),
				CategoriaTrabajo.StrengtheningCommunities, List.of("seriedad, comprensividad, serenidad"));
		Trabajo E2 = new Trabajo(5, "Mentor homeless children between the ages of 2 to 12 at our weekend enrichment program.",
				"Metropolitan Council on Jewish Poverty", 5, 168.52, true, LocalDate.of(2021, 10, 02), LocalTime.of(8,8),
				CategoriaTrabajo.Education, List.of("seriedad, empatia, simpatia"));
		Trabajo E3 = new Trabajo(5, "Help us set up a new training classroom to teach young adults personal finance!",
				"Cents Ability, Inc.", 7, 167.28, false, LocalDate.of(2021, 12, 23), LocalTime.of(9,28),
				CategoriaTrabajo.StrengtheningCommunities, List.of("seriedad, comprensividad, serenidad"));
	
		Trabajo E4 = new Trabajo(5, "Help us set up a new training classroom to teach young adults personal finance!",
				"Cents Ability, Inc.", 7, 167.28, false, LocalDate.of(2021, 12, 23), LocalTime.of(9,28),
				CategoriaTrabajo.StrengtheningCommunities, List.of("seriedad, comprensividad, serenidad"));
		Trabajo E5 = new Trabajo(50, "Please volunteer for Earth Day events on April 21st, 22nd, or 23rd.",
				"Day", 7, 112.24, false, LocalDate.of(2021, 8, 06), LocalTime.of(8,12),
				CategoriaTrabajo.Environment, List.of("seriedad, tranquilidad, serenidad"));
		
		Trabajo E6 = new Trabajo(5, "Mentor homeless children between the ages of 2 to 12 at our weekend enrichment program.",
				"Metropolitan Council on Jewish Poverty", 5, 168.52, true, LocalDate.of(2021, 10, 02), LocalTime.of(8,8),
				CategoriaTrabajo.Education, List.of("seriedad, empatia, simpatia"));
		
		Trabajo e1 = new Trabajo("Help us set up a new training classroom to teach young adults personal finance!",
				CategoriaTrabajo.StrengtheningCommunities, 167.28, 7);
		
		System.out.println("Primera entrega proyecto java:");
		System.out.println("______________________________");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------");
		
		//Prueba constructores
		System.out.println("Prueba de los constructores:");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("Prueba primer constructor: " + E1.toString());
		System.out.println("Prueba segundo constructor: " + e1.toString_constructor2());
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println();
		
		//Prueba restricciones
		System.out.println("Prueba de las restricciones:");
		System.out.println("-------------------------------------------------------------------------------------------");
		E4.setDuracion_horas(0);
		System.out.println("Prueba duracion 0: " + E4);
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println();
		
		//Prueba getters y setters
		System.out.println("Prueba de getters y setters:");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("Prueba get resumen :" + E4.getResumen());
		E6.setNumero_solicitud(777);
		System.out.println("Numero solicitudes 777: " + E6);
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println();
		
		//Prueba propiedad derivada
		System.out.println("Prueba de propiedad derivada:");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println(E4.getBien_pagado());
		System.out.println(E5.getBien_pagado());
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println();
		
		//Prueba criterio de igualdad
		System.out.println("Prueba de criterio de igualdad:");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println(E1.equals(E2));
		System.out.println(E1.equals(E3));
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println();
		
		//Prueba criterio de orden natural
		System.out.println("Prueba de criterio de orden natural:");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println(E1.compareTo(E2));
		System.out.println(E1.compareTo(E3));
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println();
		
		//Prueba de representacion como cadena
		System.out.println("Prueba de representacion como cadena:");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println(E1.toString());
		System.out.println(e1.toString_constructor2());
		System.out.println("-------------------------------------------------------------------------------------------");
		
	}
}