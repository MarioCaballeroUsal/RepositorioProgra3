/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinalprogra3.controlador;

import java.util.ArrayList;
import java.util.List;
import practicafinalprogra3.modelo.Conversacion;
import practicafinalprogra3.modelo.Modelo;
import practicafinalprogra3.vista.Vista;

/**
 *
 * @author mario
 */
public class Controlador {
    Modelo modelo;
    Vista vista;
    String mensajeIni= "Bienvenido! Inicializando Aplicacion...";

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void finalizarApp() {
        modelo.finalizarApp();
    }

    public void nuevaConversacion() {
        modelo.nuevaConversacion();
    }

    public ArrayList<Conversacion> getConversaciones() {
        return modelo.getConversaciones();
    }
    
    public String formateaConversacion(Conversacion c){
       
        return modelo.formateaConversacion(c);
    }

    public void comenzarApp() {
        modelo.comenzarApp();
        
    }
}
