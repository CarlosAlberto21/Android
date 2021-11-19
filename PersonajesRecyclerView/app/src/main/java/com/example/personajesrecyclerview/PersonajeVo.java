package com.example.personajesrecyclerview;
// Esta clase crea los personajes que se almacenaran en el Array
public class PersonajeVo {

    private String nombre;
    private String info;
    private int foto;

    public  PersonajeVo(){

    }

    public PersonajeVo(String nombre, String info, int foto) {
        this.nombre = nombre;
        this.info = info;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
