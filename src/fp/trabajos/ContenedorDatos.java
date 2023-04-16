package fp.trabajos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import fp.utiles.Checkers;

public class ContenedorDatos {
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
    	this.Trabajos.add(p);
    }

    //Añadir una coleccion de elementos
    public void incorporaTrabajos(List<Trabajo> totalTrabajos){
        this.Trabajos.addAll(totalTrabajos);
    }
        
    //Eliminar un elemento
    public void eliminaTrabajos(Trabajo c){
    	this.Trabajos.remove(c);
    }
    
    //Tratamientos secuenciales
    
    //Existe
    public Boolean existeOrganizacionConSiguienteNombre(String nombre) {
		Boolean res = false;
		for(Trabajo c: this.Trabajos) {
			String[] palabras = c.getNombre_organizacion().toUpperCase().split(" ");
			if(Arrays.asList(palabras).contains(nombre.toUpperCase())) {
				res = true;
				break;
			}
		}
		
		return res;	
    }
    
	//Contador
	public Integer getNumeroTrabajosMasDe6Horas() {
		Integer res = 0;
		for(Trabajo c: this.Trabajos) {
			if(c.getDuracion_horas()>6) {
				res++;
			}
		}
		return res;
	}
	
    //Filtro
  	public List<Trabajo> getTrabajosPorCategoria(CategoriaTrabajo Categoria){
		List<Trabajo> res = new LinkedList<Trabajo>();
		for(Trabajo c: this.Trabajos) {
			if(c.getCategoria().equals(Categoria)) {
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
  		for(Trabajo c:Trabajos) {
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
  	
	public Map<CategoriaTrabajo,Long> getNumeroTrabajosPorCategoria(){
		//Creamos un mapa
		Map<CategoriaTrabajo,Long> res = new HashMap<>();
		//Iteramos sobre los trabajos
		for(Trabajo c:Trabajos) {
			CategoriaTrabajo clave = c.getCategoria();
				if(res.containsKey(clave)) {
					res.put(clave,res.get(clave)+1);
				}else {
					res.put(clave,res.get(clave));
				}
		}
		return res;
	}
}




