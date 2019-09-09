/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.notacorte.modelos;

import com.mycompany.notacorte.pojo.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *@author Hernan Hernandez
 * @author Camilo Alvarez
 */
public class UsuarioModelo {
    /**
     * Constructor vacio
     */
    public UsuarioModelo() {
    }

    
/**
 * meodo que verifica que el uduario no exista
 * @param candidato
 * @param candidatos
 * @return
 * @throws Exception 
 */
    public boolean agregarCandidato(Usuario candidato, List<Usuario> candidatos) throws Exception {
        for (Usuario c : (ArrayList<Usuario>) candidatos) {
            if (Objects.equals(c.getCedula(), candidato.getCedula())) {
                throw new Exception("El candidato que desea regiatrar ya existe");
                
            }
        }
        return true;
    }
}
