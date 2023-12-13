/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinalprogra3.modelo;

import java.util.Arrays;

/**
 *
 * @author mario
 */
public class FraseFake {
    static String[] frases = {"Hola a ti tambien!", "Hasta la proxima!", "Mi color favorito es el rojo", "Mi animal preferido es el perro"};
    static String[] palabraClave ={"hola","adios","color","animal"};
    
    
    public static String getFraseFake(String mensaje){
        String fraseFake=null;
        boolean palabraClaveEncontrada=false;
        int numPalabrasClave=Arrays.asList(palabraClave).size();

        for(int i=0; i<numPalabrasClave; i++){
            if(!palabraClaveEncontrada){    
                if(mensaje.toLowerCase().contains(palabraClave[i])) {
                    palabraClaveEncontrada=true;
                    fraseFake=frases[i];
                }
            }
                
                
        }    
        if(!palabraClaveEncontrada){
            fraseFake="No entiendo que me quieres decir.";
        }
        return fraseFake;
    }
}
