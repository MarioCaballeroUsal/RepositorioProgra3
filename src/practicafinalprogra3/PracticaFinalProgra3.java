/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicafinalprogra3;
import practicafinalprogra3.controlador.*;
import practicafinalprogra3.modelo.*;
import practicafinalprogra3.vista.*;
import java.util.List;


/**
 *
 * @author mario
 */
public class PracticaFinalProgra3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Variables donde se guardarán los argumentos de entrada, consola tiene valor por defecto
        String repositorio =null;
        String modeloLLM=null;
        String consola = "console";
        
        


        if((args.length!=3)||(args.length!=2)){
            //Como consola tiene un valor por defecto se puede dejar vacío.
            System.out.println("Numero incorrecto de argumentos, han de ser tres o dos si se deja la consola simple por defecto");
            System.exit(-1);
        }
        
        //si el numero de argumentos es correcto, se comprueba que su contenido es valido
        if(args[0].equalsIgnoreCase("xml")||args[0].equalsIgnoreCase("json")){
            repositorio=args[0].toLowerCase();
        }else{
            System.out.println("Valor de primer argumento incorrecto, ha de ser xml o json");
            System.exit(-1);
        }
        
        if(args[1].equalsIgnoreCase("fake")||args[1].equalsIgnoreCase("cvs")){
            modeloLLM=args[0].toLowerCase();
        }else{
            System.out.println("Valor de segundo argumento incorrecto, ha de ser fake o cvs");
            System.exit(-1);
        }
        
        if(args[2]==null||args[2].equalsIgnoreCase("console")){
            //ahora mismo solo puede tener este valor asi que lo dejo así, para poder modificarlo rapido si añado TTS
            consola="console";
        }else{
            System.out.println("Valor de tercer argumento incorrecto, ha de ser console o vacio");
            System.exit(-1);
        }
        
        Modelo modelo = new Modelo(modeloLLM, repositorio);
        
        VistaSimple vista = new VistaSimple();
        
        Controlador controlador = new Controlador(modelo, vista);
        
        vista.setControlador(controlador);
        
        controlador.comenzarApp();
        
    }
    
}
