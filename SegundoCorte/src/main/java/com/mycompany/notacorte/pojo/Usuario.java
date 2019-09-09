/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.notacorte.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 *@autor Hernan Hernandez
 * @author Camilo Alvarez
 */
public class Usuario  implements Serializable {
    
    /**
     * Variable que guarda la cedula
     */
    
    private Integer cedula;
    
    /**
     * Variable que muestra el nimebre 
     */
 
    private String nombre;
    
    /**
     * Variable que guarda el apellido 
     */
  
    private String apellido;
   
    public Usuario() {
    }
/**
 * Contructor dode e inicializan las variabes 
 * @param cedula
 * @param nombre
 * @param apellido
  
 */
    public Usuario(Integer cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        
    }

 /**
 * Metodo que vuelve publica la variable
 */
    public Integer getCedula() {
        return cedula;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public String getNombre() {
        return nombre;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public String getApellido() {
        return apellido;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
