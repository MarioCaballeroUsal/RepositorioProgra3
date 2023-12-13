/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinalprogra3.modelo;

/**
 *
 * @author mario
 */
public class Frase {

    static Frase getFraseFormateada(String linea, String delimitador) {
        String[] particion = linea.split(delimitador);
        
        if(particion.length != 3){

            return null;
        }
        try{
            String tipoTexto = particion[0];
            int longitud = Integer.parseInt(particion[1]);
            String texto = particion[2];
            if(longitud!=texto.length()){
                return null;
            }else{
                Frase frase =  new Frase(tipoTexto, longitud, texto);
                return frase;
            }
            
        }
        catch(Exception e){
            System.out.println("Error: "+e);
            return null;
        }

    }
    
    String tipoTexto;
    int longitud;
    String texto;

    public Frase(String tipoTexto, int longitud, String texto) {
        this.tipoTexto = tipoTexto;
        this.longitud = longitud;
        this.texto = texto;
    }

    public String getTipoTexto() {
        return tipoTexto;
    }

    public void setTipoTexto(String tipoTexto) {
        this.tipoTexto = tipoTexto;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
        
}
