/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinalprogra3.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


/**
 *
 * @author mario
 */
public class Conversacion implements Serializable {
    
    List<Mensaje> mensajes;
    String tipoLLM;
    LocalDate fechaIni;
    LocalDate fechaFin;

    public Conversacion(LocalDate fechaIni) {
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

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
}
