package models;

public class Amigo {
    private int id;
    private String nombre, edad, oficio, telefono, email;

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getEdad(){
        return edad;
    }

    public String getOficio(){
        return oficio;
    }

    public String getTelefono(){
        return telefono;
    }

    public String getEmail(){
        return email;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setEdad(String edad){
        this.edad = edad;
    }

    public void setOficio(String oficio){
        this.oficio = oficio;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void setEmail(String email){
        this.email = email;
    }
}