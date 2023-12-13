/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinalprogra3.modelo;

import java.util.ArrayList;
import java.util.List;
import com.coti.tools.Rutas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mario
 */
public class Modelo implements Repositorio, LLM {
    String modeloLLM;
    String repositorio;
    ArrayList<Conversacion> conversaciones = new ArrayList<>();
    
    Path ruta = Rutas.pathToFileInFolderOnDesktop("jLLM", "jLLM.bin");

    
    public Modelo(String modeloLLM, String repositorio) {
        this.modeloLLM = modeloLLM;
        this.repositorio = repositorio;
    }

    public String formateaConversacion(Conversacion c) {
        String convFormateada = null;
        
        Mensaje mensaje = c.mensajes.get(0);
        String fechaIni = String.valueOf(c.fechaIni);
        String numMensajes= String.valueOf(c.mensajes.size());
        String iniMensaje = mensaje.texto.substring(0, 20);
        
        convFormateada =fechaIni+"|"+numMensajes+"|"+iniMensaje;

        
        return convFormateada;
    }

    public ArrayList<Conversacion> getConversaciones() {
        return this.conversaciones;
    }

    public void nuevaConversacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void finalizarApp() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void comenzarApp() {
 
            importarConversaciones();

    }
    
    @Override
    public ArrayList<Conversacion> importarConversaciones() {
        ArrayList<Conversacion> conversaciones = new ArrayList<>();
        if(!(ruta.toFile().exists())){
            System.out.println("No se ha detectado archivo, se asume que es la primera vez que inicias la aplicacion");
        }else if(this.repositorio.equalsIgnoreCase("xml")){
            conversaciones = importarXML();
        }else{
            conversaciones = importarJSON();
        }
        //devolverá vacía sin intentar importar si el fichero no existe
        return conversaciones;
    }

    @Override
    public void exportarConversaciones(ArrayList<Conversacion> conversaciones) {
        if(this.repositorio.equalsIgnoreCase("xml")){
            exportarXML(conversaciones);
        }else{
            exportarJSON(conversaciones);
        }
    }

    private ArrayList<Conversacion> importarXML() {
        
        XmlMapper xmlMapper = new XmlMapper(); 
        String xml = null;
        try{
            xml = new String(Files.readAllBytes(ruta), StandardCharsets.UTF_8);
        }catch(IOException e){
            System.out.println("Error al importar: "+e.getMessage());
        }
        try{
           conversaciones = xmlMapper.readValue(xml, xmlMapper.getTypeFactory().constructCollectionType(ArrayList.class, Conversacion.class));
        }catch(IOException e){
            System.out.println("Error al pasar los datos del archivo a conversaciones: "+e.getMessage());
        }
        return conversaciones;
        
    }

    private ArrayList<Conversacion> importarJSON() {
        Gson gson = new Gson();
        String json=null;
        
        try{
            json = new String(Files.readAllBytes(ruta), StandardCharsets.UTF_8);
        }catch(IOException e){
            System.out.println("Error al importar: "+e.getMessage());
        }
            Type tipoDeLista = new TypeToken<ArrayList<Conversacion>>() {}.getType();
        
        conversaciones = gson.fromJson(json, tipoDeLista);

        return conversaciones;
    }

    private void exportarXML(ArrayList<Conversacion> conversaciones) {
        XmlMapper xmlMapper = new XmlMapper();
        
        String xml=null;
        try {
            xml = xmlMapper.writeValueAsString(conversaciones);
        } catch (IOException e) {
            System.out.println("Error al pasar de conversacion a String: "+e);
        }
        
        try {
            Files.write(ruta, xml.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println("Error al exportar: "+ e);
        }
        
    }

    private void exportarJSON(ArrayList<Conversacion> conversaciones) {
        Gson gson = new Gson();
        String json = null;
        try{
            json = gson.toJson(conversaciones);
        }catch(IOException e){
            System.out.println("Error al pasar las conversaciones a String: "+e);
        }
        try{
            Files.write(ruta, json.getBytes(StandardCharsets.UTF_8));
        }catch (IOException e){
            System.out.println("Error al exportar: "+e);
        }

    }
   
    
}
