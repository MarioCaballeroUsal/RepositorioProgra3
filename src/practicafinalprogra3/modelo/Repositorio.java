/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package practicafinalprogra3.modelo;

import java.util.ArrayList;

/**
 *
 * @author mario
 */
public interface Repositorio {
    public ArrayList<Conversacion> importarConversaciones();
    
    //El propio modelo tiene las conversaciones asi que no hace falta pasarlas
    public void exportarConversaciones ();
}
