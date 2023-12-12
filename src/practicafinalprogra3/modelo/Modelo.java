/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinalprogra3.modelo;

import java.util.List;

/**
 *
 * @author mario
 */
public class Modelo implements Repositorio, LLM {
    String modeloLLM;
    String repositorio;

    public Modelo(String modeloLLM, String repositorio) {
        this.modeloLLM = modeloLLM;
        this.repositorio = repositorio;
    }

    public String formateaConversacion(Conversacion c) {
        String convFormateada = null;
        
        Mensaje mensaje = c.mensajes.get(0);
        String fechaIni = String.valueOf(c.fechaIni);
        String numMensajes= String.valueOf(c.mensajes.size());
        String iniMensaje = mensaje.texto.substring(0, 20);
        
        convFormateada =fechaIni+"|"+numMensajes+"|"+iniMensaje;

        
        return convFormateada;
    }

    public List<Conversacion> getConversaciones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void nuevaConversacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void finalizarApp() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
