/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinalprogra3.vista;
import com.coti.tools.Esdia;
import java.io.IOException;
import java.util.ArrayList;
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
            System.out.printf("4. Importar Conversaciones %s\n", controlador.getRepositorio());
            System.out.printf("5. Exportar Conversaciones %s\n",controlador.getRepositorio());
            System.out.println("6. Salir del Programa");
  
            opcion = Esdia.readInt("Ingrese una opción: ",1 ,6);

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
                    importarConversaciones();
                    break;
                case 5:
                    exportarConversaciones();
                    break;
                case 6:
                    aplicacionFin("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }
    
    public void nuevaConversacion(){
        System.out.println("Iniciando nueva conversacion...");
        controlador.nuevaConversacion();
        System.out.println("Conversacion finalizada.");
        
    }
    
    public void mostrarConversaciones(){
        ArrayList<Conversacion> conversaciones;
        int i=0;
        int numCv;
        String opcion;
        String[] opciones = {"y", "Y", "n", "N"};
        
        System.out.println("Mostrando conversaciones...");
        conversaciones = controlador.getConversaciones();
        for(Conversacion c : conversaciones){
            
            System.out.printf("%d.- %s", i,controlador.formateaConversacion(c));
            i++;
        }
        opcion = Esdia.readString("Quieres ver alguna conversacion: Y/N", opciones);
        if(opcion.equalsIgnoreCase("y")){
            numCv=Esdia.readInt("Introduzca el numero de la conversacion.", 1, conversaciones.size());
            
            showConversacion(conversaciones.get(numCv));
        }
    }
    
    public void importarConversaciones(){
        ArrayList<Conversacion> conversaciones=new ArrayList<>();
        System.out.println("Importando conversaciones...");
        conversaciones = controlador.importarConversaciones();
    }
    
    public void exportarConversaciones(){
        System.out.println("Exportando conversaciones...");
        controlador.exportarConversaciones();
        //Si hubiese un error habria saltado en el proceso de exportacion
        System.out.println("Conversaciones exportadas");
    }
    
    public void eliminarConversacion(){
        ArrayList<Conversacion> conversaciones = null;
        boolean salir =false;
        String valor=null;
        String[] opciones = {"y", "Y", "n", "N"};
        
        conversaciones= controlador.getConversaciones();
        if(conversaciones.isEmpty()){
            System.out.println("No hay conversaciones guardadas.");
        }
        else{
            
            do{
                System.out.printf("Hay %d conversaciones, si desea verlas seleccione la opcion correspondiente en el menu anterior.\n\n", conversaciones.size());

                valor = Esdia.readString("Desea eliminar alguna conversacion? Y/N", opciones);
                if(valor.equalsIgnoreCase("y")){
                    int convAEliminar = Esdia.readInt("Indique el numero de la conversacion", 0, conversaciones.size());
                    try{
                        conversaciones.remove(convAEliminar);
                    }catch(Exception e){
                        System.out.println("No se ha podido eliminar conversacion. Error: "+e);
                    }
                }else{
                    salir=true;
                }
               
            }while(!salir);
        }
    }

    private void showConversacion(Conversacion c) {
        List<String> mensajes = controlador.formateaMensajes(c);
        System.out.println("INICIO CONVERSACION\n\n");
        for(String mensaje : mensajes){
            System.out.printf("%s", mensaje);
             
        }
        
        System.out.println("FIN CONVERSACION\n\n");
    }
        
}

