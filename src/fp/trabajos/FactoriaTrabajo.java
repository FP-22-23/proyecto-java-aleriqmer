package fp.trabajos;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaTrabajo {
	
	private static Trabajo parsearTrabajo(String lineaCSV) {

		Checkers.checkNoNull(lineaCSV);
		
		String [] trozos = lineaCSV.split(";");
		
		System.out.println(trozos.length);
		Checkers.check("Formato incorrecto", trozos.length == 10);
		
		Integer Numero_solicitudes = Integer.parseInt(trozos[0].trim());
		String Resumen = trozos[1].trim();
		String Nombre_organizacion = trozos[2].trim();
		Integer Duracion_horas = Integer.parseInt(trozos[3].trim());
		Double Cantidad_pagada = Double.parseDouble(trozos[4].trim());
		Boolean Trabajo_completado = parseBool(trozos[5].trim());
		LocalDate Fecha_inicio = LocalDate.parse(trozos[6].trim(), 
				DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		LocalTime Hora_inicio = LocalTime.parse(trozos[7].trim(),
				DateTimeFormatter.ofPattern("HH:mm"));
		CategoriaTrabajo Categoria = CategoriaTrabajo.valueOf(trozos[8].trim());
		String Cualidades_buscadas = trozos[9].trim();
		
		return new Trabajo(Numero_solicitudes, Resumen, Nombre_organizacion, Duracion_horas, Cantidad_pagada,
				Trabajo_completado, Fecha_inicio, Hora_inicio, Categoria, Cualidades_buscadas);
	
	}
	
	private static Boolean parseBool(String dato) {
		Boolean res = null;
		dato = dato.toUpperCase();
		if (dato.equals("TRUE")) {
			res = true;
		}else {
			res = false;
		}
		return res;
	}
	
	//LecturaCSV
	//Dada la ruta de un fichero CSV devuelve lista de objetos de tipo base

	public static List<Trabajo> leeTrabajo(String fichero){
		Checkers.checkNoNull(fichero);

		List<String> lineas = Ficheros.leeFichero("Error leyendo fichero",
				fichero, StandardCharsets.UTF_8);
		lineas.remove(0); // Quitar cabecera del csv
		List<Trabajo> res = new ArrayList<Trabajo>();
		for(String linea: lineas) {
			Trabajo p = parsearTrabajo(linea);
			res.add(p);
		}
		return res;
	}
}