/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.inali.helioxhelper.entidades.clases;

import mx.inali.helioxhelper.entidades.persistencia.BotonPersistencia;

/**
 *
 * @author Adolfo
 */
public class test {
    public static void main(String[] args) {
        try{
            BotonPersistencia p = new BotonPersistencia();
            p.agregarBoton("holaaaaaa", "holaxd", "holasdd", "holaprro", 1);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
