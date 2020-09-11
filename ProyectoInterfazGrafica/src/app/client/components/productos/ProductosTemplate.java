package app.client.components.productos;

import app.client.components.producto.ProductoComponent;
import app.client.components.producto.ProductoTemplate;

import app.services.graphicServices.ObjGraficosService;
import app.services.graphicServices.RecursosService;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Producto;

public class ProductosTemplate extends JPanel {
  private static final long serialVersionUID = 1652828222229841161L;

  //Declaración servicios y objetos
  private ProductosComponent productosComponent;
  private ObjGraficosService sObjGraficos;
  private RecursosService sRecursos;

  //Declaración Layout
  private GridBagLayout lGrid;
  private GridBagConstraints gbc;

  //Declaración Objetos Gráficos
  private JLabel lTitulo;

  public ProductosTemplate(ProductosComponent productosComponent) {
    this.productosComponent = productosComponent;
    this.productosComponent.getClass();
    this.sRecursos = RecursosService.getService();
    this.sObjGraficos = ObjGraficosService.getService();

    lGrid = new GridBagLayout();
    gbc = new GridBagConstraints();

    lTitulo = sObjGraficos.construirJLabel(
      "Cursos en Linea",
      0, 0, 0, 0,
      null, null,
      sRecursos.getFontTProducto(),
      null,
      sRecursos.getColorAzul(),
      sRecursos.getBInferiorAzul(),
      "c"
    );

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

  public void crearProductos() {
    int numProducto = 0, fila = 1;
    Producto producto = productosComponent.devolverProducto(numProducto);
    gbc.fill = GridBagConstraints.NONE;
    gbc.gridwidth = 1;
    gbc.insets.right = 0;
    while (producto != null) {
      ProductoTemplate pProducto = new ProductoComponent(producto).getProductoTemplate();
      gbc.gridx = numProducto % 3;
      gbc.gridy = fila;
      lGrid.setConstraints(pProducto, gbc);
      this.add(pProducto);
      if (numProducto % 3 == 2) fila++;
      numProducto++;
      producto = productosComponent.devolverProducto(numProducto);
    }
  }
}