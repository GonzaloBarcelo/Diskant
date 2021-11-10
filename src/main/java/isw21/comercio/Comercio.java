package main.java.isw21.comercio;

import java.io.Serializable;

public class Comercio implements Serializable {
    String direccion;
    String nombre;
    String horario;

    public Comercio(String nombre, String direccion){
        this.direccion=direccion;
        this.nombre=nombre;
    }
}
