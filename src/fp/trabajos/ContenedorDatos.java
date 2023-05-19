package fp.trabajos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class ContenedorDatos {
	
	private List <Trabajo> trabajo;

	public ContenedorDatos() {
		this.trabajo = new ArrayList<> ();
	}
	public ContenedorDatos (Collection <Trabajo> jugador) {
		this.trabajo = new ArrayList <>(jugador);
	}
	public ContenedorDatos (Stream <Trabajo> stream) {
		this.trabajo = stream.collect(Collectors.toList());
	}
	
	//Atributos
	private Integer Numero_solicitud;
	private String Resumen;
	private String Nombre_organizacion;
	private Integer Duracion_horas;
	private List<String> Cualidades_buscadas;
	private Double Cantidad_pagada;
	private Boolean Trabajo_completado;
	private LocalDate Fecha_inicio;
	private LocalTime Hora_inicio;
	private CategoriaTrabajo Categoria;
	private List<Trabajo> Trabajos;
	
	//Constructor 1 sin coleccion
	public ContenedorDatos(Integer Numero_solicitud, String Resumen, String Nombre_organizacion, 
			Integer Duracion_horas, Double Cantidad_pagada, Boolean Trabajo_completado, 
			LocalDate Fecha_inicio, LocalTime Hora_inicio, CategoriaTrabajo Categoria, List<String> Cualidades_buscadas) {
		
		Checkers.check("La duracion no puede ser menor de 1", Duracion_horas > 0);
		Checkers.check("El cobro no puede ser negativo", Cantidad_pagada > 0);
		Checkers.check("La fecha de inicio debe ser posterior al año 1950",
				Fecha_inicio.isAfter(LocalDate.of(1950, 01, 01)));
		
		this.Numero_solicitud=Numero_solicitud;
		this.Resumen=Resumen;
		this.Nombre_organizacion=Nombre_organizacion;
		this.Duracion_horas=Duracion_horas;
		this.Cualidades_buscadas=Cualidades_buscadas;
		this.Cantidad_pagada=Cantidad_pagada;
		this.Trabajo_completado=Trabajo_completado;
		this.Fecha_inicio=Fecha_inicio;
		this.Hora_inicio=Hora_inicio;
		this.Categoria=Categoria;
	}
		
	//Constructor 2 con coleccion
	public ContenedorDatos(Integer Numero_solicitud, String Resumen, String Nombre_organizacion, 
			Integer Duracion_horas, Double Cantidad_pagada, Boolean Trabajo_completado, 
			LocalDate Fecha_inicio, LocalTime Hora_inicio, CategoriaTrabajo Categoria, List<String> Cualidades_buscadas,
			List<Trabajo> Trabajos) {
		
		Checkers.check("La duracion no puede ser menor de 1", Duracion_horas > 0);
		Checkers.check("El cobro no puede ser negativo", Cantidad_pagada > 0);
		Checkers.check("La fecha de inicio debe ser posterior al año 1950",
				Fecha_inicio.isAfter(LocalDate.of(1950, 01, 01)));
		
		this.Numero_solicitud=Numero_solicitud;
		this.Resumen=Resumen;
		this.Nombre_organizacion=Nombre_organizacion;
		this.Duracion_horas=Duracion_horas;
		this.Cualidades_buscadas=Cualidades_buscadas;
		this.Cantidad_pagada=Cantidad_pagada;
		this.Trabajo_completado=Trabajo_completado;
		this.Fecha_inicio=Fecha_inicio;
		this.Hora_inicio=Hora_inicio;
		this.Categoria=Categoria;
		this.Trabajos= new ArrayList<Trabajo>();
	}
	
	public Integer getNumero_solicitud() {
		return Numero_solicitud;
	}
	
	public String getResumen() {
		return Resumen;
	}
	
	public String getNombre_organizacion() {
		return Nombre_organizacion;
	}
	
	public Integer getDuracion_horas() {
		return Duracion_horas;
	}
	
	public List<String> getCualidades_buscadas() {
		return Cualidades_buscadas;
	}
	
	public Double getCantidad_pagada() {
		return Cantidad_pagada;
	}
	
	public Boolean getTrabajo_completado() {
		return Trabajo_completado;
	}
	
	public LocalDate getFecha_inicio() {
		return Fecha_inicio;
	}
	
	public LocalTime getHora_inicio() {
		return Hora_inicio;
	}

	public CategoriaTrabajo getCategoria() {
		return Categoria;
	}
	
	public List<Trabajo> getTrabajos() {
		return new ArrayList<Trabajo>(this.Trabajos);
	}
	
	//Criterio de igualdad
	@Override
	public int hashCode() {
		return Objects.hash(Numero_solicitud, Resumen, Nombre_organizacion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		ContenedorDatos other = (ContenedorDatos) obj;
		return Objects.equals(Numero_solicitud, other.Numero_solicitud) && Objects.equals(Resumen, other.Resumen) && Objects.equals(Nombre_organizacion, other.Nombre_organizacion); 
	}
	
	//Representacion como cadena
	@Override
	public String toString() {
		return "Trabajo [Numero_solicitud = " + Numero_solicitud + ", Resumen = " + Resumen + ", Nombre de la organizacion = " + Nombre_organizacion +
				", Horas de duracion = " + Duracion_horas + ", Cualidades_buscadas = " + Cualidades_buscadas + ", Cantidad pagada = " + Cantidad_pagada +
				", ¿Trabajo completado? = " + Trabajo_completado + ",  Fecha de inicio = " + Fecha_inicio + ", Hora de inicio = " + Hora_inicio +
				", Categoria del trabajo = " + Categoria + "]";
	}
	
	//Obtener numero de elementos
    public Integer NumTrabajos(){
        return Trabajos.size();
    }
    
    //Añadir un elemento
    public void incorporaTrabajo(Trabajo p){
    	this.trabajo.add(p);
    }

    //Añadir una coleccion de elementos
    public void incorporaTrabajos(List<Trabajo> totalTrabajos){
        this.trabajo.addAll(totalTrabajos);
    }
        
    //Eliminar un elemento
	public void eliminaTrabajos(Trabajo c) {
		if(!trabajo.contains(c)) {
			throw new IllegalArgumentException("El Trabajo buscado no existe");
		}else {
			trabajo.remove(c);
		}	
	}
    
    //Tratamientos secuenciales
    
    //Existe
	public boolean existeTrabajoEnFecha(LocalDate fecha) {
	    for (Trabajo c : trabajo) {
	        if (c.getFecha_inicio().equals(fecha)) {
	            return true;
	        }
	    }
	    return false;
	}
    
	//Contador
	public Integer NumeroTrabajosMasDe6Horas() {
		Integer res = 0;
		for(Trabajo c: trabajo) {
			if(c.getDuracion_horas()>6) {
				res++;
			}
		}
		return res;
	}
	
    //Filtro
	public List<Trabajo> TrabajosTerminadosPorCualidades(List<String> cualidades) {
	    List<Trabajo> res = new ArrayList<>();

	    for (Trabajo c : trabajo) {
	        if (cualidades.containsAll(c.getCualidades_buscadas()) && c.getTrabajo_completado()) {
	            res.add(c);
	        }
	    }

	    return res;
	}
  	
  	//Map 1
  	
  	public Map<Integer,List<Trabajo>> agrupaTrabajosPorNumSol(Integer solicitud){
  		//Creamos un mapa
  		Map<Integer,List<Trabajo>> res = new HashMap<>();
  		//Iteramos sobre los trabajos
  		for(Trabajo c:trabajo) {
  			if(c.getNumero_solicitud().equals(solicitud)) {
  				//Recuperamos/Calculamos la clave
  				Integer num = c.getNumero_solicitud();
  				if(res.containsKey(num)) {
  					res.get(num).add(c);
  				}else {
  					List<Trabajo> listaNombres = new LinkedList<>();
  					listaNombres.add(c);
  					res.put(num, listaNombres);
  				}
  			}
  		}
  		return res;
  	}
  	
  	//Map 2
  	
	public Map<CategoriaTrabajo,Integer> NumeroTrabajosPorCategoria(){
		//Creamos un mapa
		Map<CategoriaTrabajo,List<String>> res = new HashMap<>();
		//Segundo mapa pero con valores integer
		Map<CategoriaTrabajo,Integer> res2 = new HashMap<>();
		//Iteramos sobre los trabajos
		for(Trabajo c:trabajo) {
			if (!res.containsKey(c.getCategoria())) {
				List<String> nombres = new ArrayList<>();
				nombres.add(c.getResumen());
				res.put(c.getCategoria(), nombres);
			} else {
				res.get(c.getCategoria()).add(c.getResumen());
			}
			res2.put(c.getCategoria(),res.get(c.getCategoria()).size());
		}
		return res2;
	}
	
	//Existe con streams
	
	public boolean existeTrabajoEnFechaStreams(LocalDate fecha) {
	    return trabajo.stream()
	            .anyMatch(c -> c.getFecha_inicio().equals(fecha));
	}
	
	//Contador con streams
	
	public int numeroTrabajosMasDe6HorasStreams() {
	    return (int) trabajo.stream()
	        .filter(c -> c.getDuracion_horas() > 6)
	        .count();
	}
	
	//Filtro con streams
	
	public List<Trabajo> TrabajosTerminadosPorCualidadesStreams(List<String> cualidades) {
	    return trabajo.stream()
	            .filter(c -> cualidades.containsAll(c.getCualidades_buscadas()) && c.getTrabajo_completado())
	            .collect(Collectors.toList());
	}
	
	//Maximo minimo con filtrado
	
	public Trabajo obtenerTrabajoFinalizadoMejorPagado() {
	    List<Trabajo> res = new ArrayList<>();
	    for (Trabajo c : trabajo) {
	        if (c.getTrabajo_completado().equals(true)) {
	        	res.add(c);
	        }
	    }

	    if (res.isEmpty()) {
	        return null;
	    }

	    Trabajo res2 = Collections.max(res, Comparator.comparing(Trabajo::getCantidad_pagada));
	    return res2;
	}
	//Seleccion con filtrado y ordenacion
	
	public List<Trabajo> obtenerTrabajosDuracion8HorasOrdenadosPorCantidadPagada() {
	    List<Trabajo> res = new ArrayList<>();
	    for (Trabajo c : trabajo) {
	        if (c.getDuracion_horas() == 8) {
	            res.add(c);
	        }
	    }

	    res.sort(Comparator.comparing(Trabajo::getCantidad_pagada));

	    return res;
	}
	
	//Map 2 con streams
	
	public Map<CategoriaTrabajo, Integer> numeroTrabajosPorCategoriaStreams() {
	    return trabajo.stream()
	        .collect(Collectors.groupingBy(Trabajo::getCategoria, Collectors.summingInt(c -> 1)));
	}
	
	//Collector

	public Map<Integer, List<Double>> obtenerCantidadPagadaPorSolicitudes() {
	    return trabajo.stream()
	            .collect(Collectors.groupingBy(
	                    Trabajo::getNumero_solicitud,
	                    Collectors.mapping(Trabajo::getCantidad_pagada, Collectors.toList())
	            ));
	}
	
    //Map maximo
	
    public Map<CategoriaTrabajo, Double> obtenerTrabajosMejorPagadosPorTipo() {
        Map<CategoriaTrabajo, Double> res = new HashMap<>();

        for (Trabajo c : trabajo) {
            CategoriaTrabajo tipoTrabajo = c.getCategoria();
            double cantidadPagada = c.getCantidad_pagada();

            if (!res.containsKey(tipoTrabajo)) {
                res.put(tipoTrabajo, cantidadPagada);
            } else {
                double maxCantidadPagada = res.get(tipoTrabajo);
                if (cantidadPagada > maxCantidadPagada) {
                    res.put(tipoTrabajo, cantidadPagada);
                }
            }
        }

        return res;
    }
    
    //Map los trabajos de cada categoria que tengan menos de 10 solicitudes
    
    public SortedMap<CategoriaTrabajo, List<String>> obtenerTrabajosMenosSolicitadosPorTipo() {
        SortedMap<CategoriaTrabajo, List<String>> res = new TreeMap<>();

        for (Trabajo c : trabajo) {
            CategoriaTrabajo tipoTrabajo = c.getCategoria();
            int numSolicitudes = c.getNumero_solicitud();
            String resumen = c.getResumen();

            if (numSolicitudes < 10) {
                res.computeIfAbsent(tipoTrabajo, k -> new ArrayList<>()).add(resumen);
            }
        }

        return res;
    }
    
    //Map clave-valor maximo
    
    public Map<CategoriaTrabajo, Integer> obtenerTrabajoResumenMayorPorTipo() {
        Map<CategoriaTrabajo, Integer> res = new HashMap<>();

        for (Trabajo c : this.trabajo) {
            CategoriaTrabajo tipoTrabajo = c.getCategoria();
            int numLetras = c.getResumen().length();

            res.put(tipoTrabajo, Math.max(res.getOrDefault(tipoTrabajo, 0), numLetras));
        }
        
        Map.Entry<CategoriaTrabajo, Integer> maxEntry = null;
        for (Map.Entry<CategoriaTrabajo, Integer> entry : res.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        if (maxEntry != null) {
            Map<CategoriaTrabajo, Integer> result = new HashMap<>();
            result.put(maxEntry.getKey(), maxEntry.getValue());
            return result;
        } else {
            return Collections.emptyMap();
        }
    }
}




