/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinalprogra3.vista;

import practicafinalprogra3.controlador.Controlador;

/**
 *
 * @author mario
 */
abstract public class Vista {
    Controlador controlador;
    
    abstract public void aplicacionInicio(String initInfo);
    abstract public void aplicacionMenu();
    abstract public void aplicacionFin(String finInfo);
    


    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    
}

