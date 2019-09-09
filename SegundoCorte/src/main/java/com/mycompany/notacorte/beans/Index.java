/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.notacorte.beans;

import com.mycompany.notacorte.modelos.UsuarioModelo;
import com.mycompany.notacorte.pojo.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

/**
 * @Hernan Hernandez
 * @author Camilo Alvarez
 */
@ManagedBean
@RequestScoped
public class Index implements Serializable {

    /**
     * Se instanic candidato
     */
    private Usuario candidato;

    /**
     * Etiqueta que isrve para traer los datos de otros bean
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
                notificarPUSH("Usuario: "+candidato.getNombre()+" Agregado");
                lista.getCandidatos().add(candidato);

            }

        } catch (Exception e) {
             notificarPUSH(e.getMessage());
            
        }
    }

    /**
     * Funcion para eliminar candidatos
     */
    public void eliminar() {
        notificarPUSH("Usuario: "+candidato.getNombre()+" Eliminado");
        System.out.println("hola");
        lista.getCandidatos().remove(candidato);
    
    }

    /**
     * metodo para notificar y refrescar el admin y ver todos los inscritos
     */
    public void notificarPUSH(String msg) {

        String CHANNEL = "/noti";

        EventBus eventbus = EventBusFactory.getDefault().eventBus();
        eventbus.publish(CHANNEL, new FacesMessage("Aviso", msg));
    }

    /**
     * metodo que sirve para editar dentro de una tabla
     *
     * @param event
     */
    public void onRowEdit(RowEditEvent event) {
        notificarPUSH("Usuario: "+((Usuario) event.getObject()).getNombre()+" Editado");

       
    }

    /**
     * metodo para cancelar la edicion
     *
     * @param event
     */
    public void onRowCancel(RowEditEvent event) {
        notificarPUSH("Cancelada Edicion");
       
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
