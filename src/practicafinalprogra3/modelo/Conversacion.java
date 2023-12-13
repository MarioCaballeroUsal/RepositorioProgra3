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
}
