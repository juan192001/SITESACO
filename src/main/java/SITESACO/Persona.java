package SITESACO;
//clase 

import java.util.ArrayList;

public abstract class Persona {

    //Atributos
    protected String nombre;
    protected String doc;
    protected String nacimiento;

    //Constructor
    public Persona(String nombre, String doc, String nacimiento) {
        this.nombre = nombre;
        this.doc = doc;
        this.nacimiento = nacimiento;
    }

    //Métodos getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    //Método abstracto para agregar
    public abstract void agregarPersona();

    //Método para ver lista
    public abstract void verLista(ArrayList<Persona> personas);

    //Método para ver detalles
    public abstract void verDetalles();

    //Método para modificar
    //public abstract void Modificar(ArrayList<Persona> personas);
    //Método para eliminar
    public abstract void Eliminar(ArrayList<Persona> personas);
    //Método para buscar

    public abstract Persona buscar(ArrayList<Persona> persona);

}


