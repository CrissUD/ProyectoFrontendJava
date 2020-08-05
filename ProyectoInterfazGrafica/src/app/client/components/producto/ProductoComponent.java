package app.client.components.producto;

import models.Producto;

public class ProductoComponent {
    
    private ProductoTemplate productoTemplate;

    public ProductoComponent(Producto producto){
        productoTemplate = new ProductoTemplate(this, producto);
    }

    public ProductoTemplate getProductoTemplate(){
        return productoTemplate;
    }
}