/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinalprogra3.modelo;

import java.io.Serializable;
import java.util.List;


/**
 *
 * @author mario
 */
public class Conversacion implements Serializable {
    
    List<Mensaje> mensajes;
    String tipoLLM;
    long fechaIni;
    long fechaFin;

    public Conversacion(long fechaIni) {
        this.fechaIni = fechaIni;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public String getTipoLLM() {
        return tipoLLM;
    }

    public void setTipoLLM(String tipoLLM) {
        this.tipoLLM = tipoLLM;
    }

    public long getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(long fechaIni) {
        this.fechaIni = fechaIni;
    }

    public long getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(long fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
}
