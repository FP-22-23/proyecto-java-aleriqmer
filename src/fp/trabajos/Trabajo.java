package fp.trabajos;

import java.time.LocalDate;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class Trabajo implements Comparable<Trabajo> {
	// Atributos
	private Integer Numero_solicitud;
	private String Resumen;
	private String Nombre_organizacion;
	private Integer Duracion_horas;
	private List<String> Cualidades_buscadas;
	private Double Cantidad_pagada;
	private Boolean Trabajo_completado;
	private LocalDate Fecha_inicio;
	private Time Hora_inicio;
	private CategoriaTrabajo Categoria;
	
	//Constructores
	//Completo
	public Trabajo(Integer Numero_solicitud, String Resumen, String Nombre_organizacion, 
			Integer Duracion_horas, Double Cantidad_pagada, Boolean Trabajo_completado, 
			LocalDate Fecha_inicio, Time Hora_inicio, CategoriaTrabajo Categoria, List<String> Cualidades_buscadas) {
		
		//Restricciones 
		Checkers.check("La duracion no puede ser menor de 1", Duracion_horas > 0);
		Checkers.check("El cobro no puede ser negativo", Cantidad_pagada > 0);
		Checkers.check("La fecha de inicio debe ser posterior al año 1950",
				Fecha_inicio.isAfter(LocalDate.of(1950, 01, 01)));
		
		/**
		 * @param Numero_solicitud, numero de personas que solicitaron el trabajo
		 * @param Resumen, resumen de la tarea a realizar
		 * @param Nombre_organizacion, nombre de la organizacion que lanzo el anuncio del trabajo
		 * @param Duracion_horas, duracion en horas del trabajo realizado
		 * @param Cantidad_pagada, cantidad en euros que fue entregada a la persona que realizo el trabajo
		 * @param Trabajo_completado, valor true si fue completado satisfactoriamente, 
		 * 		  valor false si no lo fue
		 * @param Fecha_inicio, dia que se realizo el trabajo
		 * @param Hora_inicio, hora en la que se inicio el trabajo
		 * @param Categoria, categoria del trabajo que se realiza, puede ser StrengtheningCommunities,
		 * 		  Education, HelpingNeighborsinNeed, Environment o Health
		 * @param xxx, 
		 * @throws IllegalArgumentException si la duracion del trabajo es negativa
		 * @throws IllegalArgumentException si la cantidad cobrada es negativa
		 * @throws IllegalArgumentException si la fecha del trabajo es anterior al año 1950
		 */
		
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
	
	//Constructor resumen pago
	public Trabajo(String Resumen, CategoriaTrabajo Categoria, Double Cantidad_pagada, Integer Duracion_horas) {
		this.Resumen=Resumen;
		this.Categoria=Categoria;
		this.Cantidad_pagada=Cantidad_pagada;
		this.Duracion_horas=Duracion_horas;
	}
	
	//Getters y Setters
		public Integer getNumero_solicitud() {
			return Numero_solicitud;
		}
		
		public void setNumero_solicitud(Integer Numero_solicitud) {
			this.Numero_solicitud=Numero_solicitud;
		}

		public String getResumen() {
			return Resumen;
		}

		public void setResumen(String resumen) {
			Resumen = resumen;
		}

		public String getNombre_organizacion() {
			return Nombre_organizacion;
		}

		public void setNombre_organizacion(String nombre_organizacion) {
			Nombre_organizacion = nombre_organizacion;
		}

		public Integer getDuracion_horas() {
			return Duracion_horas;
		}

		public void setDuracion_horas(Integer duracion_horas) {
			Duracion_horas = duracion_horas;
		}

		public List<String> getCualidades_buscadas() {
			return Cualidades_buscadas;
		}

		public void setCualidades_buscadas(List<String> Cualidades_buscadas) {
			this.Cualidades_buscadas = Cualidades_buscadas;
		}

		public Double getCantidad_pagada() {
			return Cantidad_pagada;
		}

		public void setCantidad_pagada(Double cantidad_pagada) {
			Cantidad_pagada = cantidad_pagada;
		}

		public Boolean getTrabajo_completado() {
			return Trabajo_completado;
		}

		public void setTrabajo_completado(Boolean trabajo_completado) {
			Trabajo_completado = trabajo_completado;
		}

		public LocalDate getFecha_inicio() {
			return Fecha_inicio;
		}

		public void setFecha_inicio(LocalDate fecha_inicio) {
			Fecha_inicio = fecha_inicio;
		}

		public Time getHora_inicio() {
			return Hora_inicio;
		}

		public void setHora_inicio(Time hora_inicio) {
			Hora_inicio = hora_inicio;
		}

		public CategoriaTrabajo getCategoria() {
			return Categoria;
		}

		public void setCategoria(CategoriaTrabajo categoria) {
			Categoria = categoria;
		}
		
		//Construccion propiedad derivada
		public String getBien_pagado() {
			if(this.getCantidad_pagada() > 140) {
				String Bien_remunerado = "Bien remunerado";
						return Bien_remunerado;
			}else {
				String Mal_remunerado = "Mal remunerado";
						return Mal_remunerado; }
		}
		
		//Presentacion como cadena (segundo constructor)
		@Override
		public String toString() {
			return "Trabajo [Numero_solicitud = " + Numero_solicitud + ", Resumen = " + Resumen + ", Nombre de la organizacion = " + Nombre_organizacion +
					", Horas de duracion = " + Duracion_horas + ", Cualidades_buscadas = " + Cualidades_buscadas + ", Cantidad pagada = " + Cantidad_pagada +
					", ¿Trabajo completado? = " + Trabajo_completado + ",  Fecha de inicio = " + Fecha_inicio + ", Hora de inicio = " + Hora_inicio +
					", Categoria del trabajo = " + Categoria + "]";
		}
		
		//Presentacion como cadena (toString todas las propiedades)
		public String toString_constructor2() {
			return "Trabajo [Resumen = " + Resumen + ", Categoria del trabajo = " + Categoria + ", Cantidad pagada = " + Cantidad_pagada + 
					", Horas de duracion = " + Duracion_horas + "]";
		}
		
		//Criterio de igualdad
		@Override
		public int hashCode() {
			return Objects.hash(Resumen, Nombre_organizacion, Cantidad_pagada, Duracion_horas);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if(getClass() != obj.getClass())
				return false;
			Trabajo other = (Trabajo) obj;
			return Objects.equals(Resumen, other.Resumen) && Objects.equals(Nombre_organizacion, other.Nombre_organizacion)
					&& Objects.equals(Cantidad_pagada, other.Cantidad_pagada) && Objects.equals(Duracion_horas, other.Duracion_horas); 
		}
		
		//Criterio de orden natural
		public int CompareTo(Trabajo c) {
			//Resumen->Nombre_organizacion->Cantidad_pagada
			int res = this.Resumen.compareTo(c.getResumen());
			if (res == 0) {
				res = this.Nombre_organizacion.compareTo(c.getNombre_organizacion());
				if (res == 0) {
					res = this.Cantidad_pagada.compareTo(c.getCantidad_pagada());
				}
			}
			return res;
		}
		@Override
		public int compareTo(Trabajo o) {
			// TODO Auto-generated method stub
			return 0;
		}
}