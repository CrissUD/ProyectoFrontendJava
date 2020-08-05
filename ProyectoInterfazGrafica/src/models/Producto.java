package models;

import javax.swing.ImageIcon;

public class Producto {
    private int id;
    private String nombreProducto, descripcion, campo, puntuacion;
    private ImageIcon imagen;

    public int getId(){
        return id;
    }

    public String getNombreProducto(){
        return  nombreProducto;
    }

    public String getDescripcion(){
        return  descripcion;
    }

    public String getCampo(){
        return  campo;
    }

    public String getPuntuacion(){
        return puntuacion;
    }

    public ImageIcon getImagen(){
        return imagen;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombreProducto(String nombreProducto){
        this.nombreProducto = nombreProducto;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setCampo(String campo){
        this.campo = campo;
    }

    public void setPuntuacion(String puntuacion){
        this.puntuacion = puntuacion;
    }

    public void setImagen(ImageIcon imagen){
        this.imagen = imagen;
    }
}