package app.client.components.productos;

import javax.swing.JLabel;
import javax.swing.JPanel;

import app.client.components.producto.ProductoComponent;
import app.client.components.producto.ProductoTemplate;
import app.services.servicesGraphics.ObjGraficosService;
import app.services.servicesGraphics.RecursosService;
import models.Producto;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class ProductosTemplate extends JPanel{

    private static final long serialVersionUID = 1652828222229841161L;

    private ProductosComponent productosComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;

    private GridBagLayout lGrid;
    private GridBagConstraints gbc;

    private JLabel lTitulo;

    public ProductosTemplate(ProductosComponent productosComponent) {

        this.productosComponent = productosComponent;
        this.productosComponent.getClass();
        this.sRecursos = RecursosService.getService();
        this.sObjGraficos = ObjGraficosService.getService();

        lGrid = new GridBagLayout();
        gbc = new GridBagConstraints();

        lTitulo = sObjGraficos.construirJLabel(
            "Cursos en Linea", 0, 0, 0, 0, null, sRecursos.getColorAzul(), null, sRecursos.getFontTProducto(), "c"
        );
        lTitulo.setBorder(sRecursos.getBorderInferiorAzul());
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets.top = 15;
        gbc.insets.bottom = 15;
        gbc.insets.left = 15;
        gbc.insets.right = 15;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        lGrid.setConstraints(lTitulo, gbc);
        this.add(lTitulo);

        this.crearProductos();

        this.setLayout(lGrid);
        this.setBackground(sRecursos.getColorGrisClaro());
        this.setVisible(true);
    }

    public void crearProductos(){
        int numProducto = 0, fila = 1;
        Producto producto = productosComponent.devolverProducto(numProducto);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.insets.right = 0;
        while(producto != null){
            ProductoTemplate pProducto = new ProductoComponent(producto).getProductoTemplate();
            gbc.gridx = numProducto % 3;
            gbc.gridy = fila;
            lGrid.setConstraints(pProducto, gbc);
            this.add(pProducto);
            if(numProducto % 3 == 2)
                fila ++;
            numProducto ++;
            producto = productosComponent.devolverProducto(numProducto);
        }
    }
}