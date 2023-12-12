/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinalprogra3.modelo;

/**
 *
 * @author mario
 */
public class Mensaje {
    long momentoEnvio;
    String remitente;
    String texto;

    public Mensaje(long momentoEnvio, String remitente, String texto) {
        this.momentoEnvio = momentoEnvio;
        this.remitente = remitente;
        this.texto = texto;
    }

    public long getMomentoEnvio() {
        return momentoEnvio;
    }

    public void setMomentoEnvio(long momentoEnvio) {
        this.momentoEnvio = momentoEnvio;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
}
