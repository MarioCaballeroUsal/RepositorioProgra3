/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinalprogra3.modelo;

/**
 *
 * @author mario
 */
public class Modelo implements Repositorio, LLM {
    String modeloLLM;
    String repositorio;

    public Modelo(String modeloLLM, String repositorio) {
        this.modeloLLM = modeloLLM;
        this.repositorio = repositorio;
    }
    
    
    
}
