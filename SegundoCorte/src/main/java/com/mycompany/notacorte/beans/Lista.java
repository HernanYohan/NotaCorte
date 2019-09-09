/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.notacorte.beans;

import com.mycompany.notacorte.pojo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *@Hernan Hernandez
 * @author Camilo Alvarez
 */
@ManagedBean
@SessionScoped
public class Lista implements Serializable {

    /**
     * Se instancian las variables
     */
    private List<Usuario> candidatos;

    /**
     * Creates a new instance of Lista
     */
    public Lista() {
        candidatos = new ArrayList<>();
    }

    public List<Usuario> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Usuario> candidatos) {
        this.candidatos = candidatos;
    }
    


    
}
