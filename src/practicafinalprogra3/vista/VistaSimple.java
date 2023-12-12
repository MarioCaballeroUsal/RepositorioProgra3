/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinalprogra3.vista;
import com.coti.tools.Esdia;
import java.util.List;
import practicafinalprogra3.modelo.Conversacion;

/**
 *
 * @author mario
 */
public class VistaSimple extends Vista {
    
    @Override
    public void aplicacionInicio(String initInfo){
        System.out.printf("%s", initInfo);
    }
    @Override
    public void aplicacionMenu(){
        muestraMenu();
    }
    @Override
    public void aplicacionFin(String finInfo){
        System.out.println("Guardando estado del programa...");
        controlador.finalizarApp();
        System.out.printf("%s", finInfo);
        
    }
    
    public void muestraMenu(){
        int opcion;
        do {
            System.out.println("\n--- MENU CONVERSACIONES ---");
            System.out.println("1. Nueva Conversacion");
            System.out.println("2. Mostrar Conversaciones");
            System.out.println("3. Eliminar Conversacion");
            System.out.println("4. Salir del Programa");
  
            opcion = Esdia.readInt("Ingrese una opción: ",1 ,4);

            switch (opcion) {
                case 1:
                    nuevaConversacion();
                    break;
                case 2:
                    mostrarConversaciones();
                    break;
                case 3:
                    eliminarConversacion();
                    break;
                case 4:
                    aplicacionFin("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
    
    public void nuevaConversacion(){
        System.out.println("Iniciando nueva conversacion...");
        controlador.nuevaConversacion();
        System.out.println("Conversacion finalizada.");
        
    }
    
    public void mostrarConversaciones(){
        List<Conversacion> conversaciones;
        
        System.out.println("Mostrando conversaciones...");
        conversaciones = controlador.getConversaciones();
        for(Conversacion c : conversaciones){
            System.out.printf("%s", controlador.formateaConversacion(c));
        }
    }
    
    public void eliminarConversacion(){
        
    }
}

