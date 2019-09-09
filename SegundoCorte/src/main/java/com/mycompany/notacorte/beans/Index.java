/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.notacorte.beans;

import com.mycompany.notacorte.modelos.UsuarioModelo;
import com.mycompany.notacorte.pojo.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;
import org.atmosphere.util.StringEscapeUtils;

/**
 *@Hernan Hernandez
 * @author Camilo Alvarez
 */
@ManagedBean
@RequestScoped
public class Index implements Serializable {

    /**
     *Se instanic candidato
     */
    private Usuario candidato;

    /**
     *Etiqueta que isrve para traer los datos de otros bean 
     */
    @ManagedProperty("#{lista}")
    private Lista lista;

   
    /**
     * Creates a new instance of Index
     */
    public Index() {
        System.out.println("Constructor!!!");
        candidato = new Usuario();
        
    }
    /**
     * metodo que sirve para guardar en la lista los candidatos
     */
    public void agregarCandidato() {
        UsuarioModelo controlador = new UsuarioModelo();
        try {
            
            if (controlador.agregarCandidato(candidato, lista.getCandidatos())) {
                notificarPUSH();
                lista.getCandidatos().add(candidato);
                
                FacesMessage msg = new FacesMessage("Aviso", "Usuario Agregado!!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
            
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Aviso", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }   
    
    /**
     * Funcion para eliminar candidatos
     */
  
    public void eliminar(){
        lista.getCandidatos().remove(candidato);
        FacesMessage msg = new FacesMessage("Eliminado", "Usuario: "+candidato.getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    /**
     * metodo para notificar y refrescar el admin y ver todos los inscritos 
     */
    public void notificarPUSH(){
        
        String summary ="Nuevo Elemento";
        String detail = "Agregado";
        String CHANNEL = "/noti";
        
        EventBus eventbus = EventBusFactory.getDefault().eventBus();
   //     eventbus.publish(CHANNEL,new FacesMessage(StringEscapeUtils.escapeHtml3(summary),StringEscapeUtils.escapeHtml3(detail)));
    }
    /**
     * metodo que sirve para editar dentro de una tabla
     * @param event 
     */
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se Edito A:", ((Usuario) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     /**
      * metodo para cancelar la edicion 
      * @param event 
      */
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se Cancelo La Edicion A: ", ((Usuario) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public Lista getLista() {
        return lista;
    }
    /**
     * metodo que hace la variable publica 
     */
    public void setLista(Lista lista) {
        this.lista = lista;
    }
    /**
     * metodo que hace la variable publica 
     */
    public Usuario getCandidato() {
        return candidato;
    }
    /**
     * metodo que hace la variable publica 
     */
    public void setCandidato(Usuario candidato) {
        this.candidato = candidato;
    }
    
    
     

}
