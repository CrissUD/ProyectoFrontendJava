package app.services.logicServices;

import java.util.ArrayList;

import logic.ControlProductos;
import models.Producto;

public class ProductoService {
    private static ProductoService servicio;
    private ControlProductos cProductos;
    private ArrayList<Producto> productos;

    public ProductoService(){
        cProductos = new ControlProductos();
        productos = cProductos.getProductos();
    }

    public Producto devolverProducto(int posicion){
        try{
            return productos.get(posicion);
        }
        catch(Exception e){
            return null;
        }
    }

    public static ProductoService getService(){
        if(servicio == null)
            servicio = new ProductoService();
        return servicio;
    }
}