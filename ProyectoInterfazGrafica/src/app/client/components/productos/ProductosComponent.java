package app.client.components.productos;

import app.services.servicesLogic.ProductoService;
import models.Producto;

public class ProductosComponent{

    private ProductosTemplate productosTemplate;
    private ProductoService sProducto;

    public ProductosComponent(){
        sProducto = ProductoService.getService();
        productosTemplate = new ProductosTemplate(this);
    }

    public Producto devolverProducto(int posicion){
        return this.sProducto.devolverProducto(posicion);
    }
    
    public ProductosTemplate getProductosTemplate(){
        return productosTemplate;
    }
}