package app.services.graphicServices;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;

/** @author Cristian Felipe Patiño Cáceres Github: CrissUD*/

public class GraficosAvanzadosService {
  private static GraficosAvanzadosService servicio;

  private GraficosAvanzadosService() {}

  /**
   * Descripción: Esta función se encarga de personalizar una tabla, tomando cada celda de la tabla y tratandola como si fuera un JLabel para realizar una personalización completa, el estilo de personalización esta basado en el intercalado de filas.
   * Para invocarlo se debe llamar al método: setDefaultRenderer() del objeto gráfico JTable o JTableHeader.
   * @param colorPrincipal (Color): Color de fondo de las filas impares (1, 3, 5 ...).
   * @param colorSecundario (Color): Color de fondo de las filas pares (2, 4, 6 ...).
   * @param colorSeleccion (int): Color de fondo de la fila que sea seleccionada por el usuario.
   * @param colorFuente (Color): Color de la letra o Foreground de la tabla.
   * @param fuente (Font): Fuente de la letra de la tabla.
   * @return DefaultTableCellRenderer: Objeto encargado de la personalización de un objeto JTable.
   * @throws null : Si no necesita enviar algun color o la fuente envíe un [null] como parámetro.
  */
  public DefaultTableCellRenderer devolverTablaPersonalizada(
    Color colorPrincipal, Color colorSecundario, Color colorSeleccion, Color colorFuente, Font fuente
  ) {
    return new DefaultTableCellRenderer() {
      private static final long serialVersionUID = -8946942932242371111L;

      @Override
      public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column
      ) {
        JLabel celda = (JLabel) super.getTableCellRendererComponent(
          table, value, isSelected, hasFocus, row, column
        );
        celda.setOpaque(true);
        celda.setFont(fuente);
        celda.setForeground(colorFuente);
        celda.setHorizontalAlignment(SwingConstants.CENTER);
        if (row % 2 != 0) celda.setBackground(colorPrincipal); 
        else celda.setBackground(colorSecundario);
        if (isSelected) {
          celda.setBackground(colorSeleccion);
          celda.setForeground(Color.WHITE);
        }
        return celda;
      }
    };
  }

  /**
   * Descripción: Esta función se encarga de personalizar un objeto tipo JScrollBar. El modelo que retorna esta basado en un ScrollBar sin botones esquineros y con la posibilidad de devolver un Thumb personalizado.
   * Para invocarlo se debe llamar al método: setUI() del objeto gráfico JScrollBar.
   * @param grosor (int): Grosor del Thumb o barra de navegación (no se recomiendan valores mayores a 15).
   * @param radio (int): Valor del arco en las esquinas del Thumb siendo 0 un arco nulo y con valores mayores se crean bordes redonreados al Thumb (no se recomiendan valores mayores a 15).
   * @param colorFondo (Color): Color de fondo (Background) del Track del JScrollBar.
   * @param colorBarraNormal (Color): Color de fondo (Background) del Thumb del JScrollBar cuando no se esta usando.
   * @param colorBarraArrastrada (Color): Color de fondo (Background) del Thumb del JScrollBar cuando se esta arrastrando a traves del mouse.
   * @return BasicScrollBarUI: Objeto encargado de la personalización de un objeto JScrollBar.
   * @throws null : Si no necesita enviar algun color envíe un [null] como parámetro.
  */
  public BasicScrollBarUI devolverScrollPersonalizado(
    int grosor, int radio, Color colorFondo, Color colorBarraNormal, Color colorBarraArrastrada
  ) {
    return new BasicScrollBarUI() {
      private Dimension d = new Dimension();

      @Override
      protected JButton createDecreaseButton(int orientation) {
        JButton boton = new JButton();
        boton.setPreferredSize(d);
        return boton;
      }

      @Override
      protected JButton createIncreaseButton(int orientation) {
        JButton boton = new JButton();
        boton.setPreferredSize(d);
        return boton;
      }

      @Override
      protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
        g.setColor(colorFondo);
        g.fillRect(r.x, r.y, r.width, r.height);
      }

      @Override
      protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(
          RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
        );
        JScrollBar sb = (JScrollBar) c;
        if (!sb.isEnabled()) return; 
        else if (isDragging) g2.setPaint(colorBarraArrastrada); 
        else if (isThumbRollover()) g2.setPaint(colorBarraNormal); 
        else g2.setPaint(colorBarraNormal);

        if (r.width < r.height) g2.fillRoundRect(
          (r.width - grosor) / 2, r.y, grosor, r.height, radio, radio
        ); 
        else 
          g2.fillRoundRect(
            r.x, (r.height - grosor) / 2, r.width, grosor, radio, radio
          );
      }
    };
  }

  /**
   * Descripción: Esta función se encarga de personalizar un objeto tipo JComboBox. El modelo que retorna esta basado en un comboBox con boton personalizado, borde personalizado y color de fondo.
   * Para invocarlo se debe llamar al método: setUI() del objeto gráfico JComboBox.
   * @param boton (JButton): Botón del comboBox situado a la derecha encargado de desplegar la información.
   * @param colorBorde (Color): Color de borde en caso de de crear un comboBox sin fondo.
   * @param colorFondo (Color): Color de fondo (Background) del valor actual seleccionado del comboBox.
   * @param colorSeleccionMenu (Color): Color de fondo de las opciones dentro del popMenu una ves se pasa encima con el cursor.
   * @param colorFuenteMenu (Color): Color de fuente (Foreground) las opciones dentro del popMenu del comboBox (es diferente al color de fuente que esta en la selección actual).
   * @param esSolido booleano que indica si el comboBox tiene color de Fondo en la selección actual (true) si se deja en (false) obtendra el color de fondo por defecto que tiene el comboBox.
   * @return BasicScrollBarUI: Objeto encargado de la personalización de un objeto JScrollBar.
   * @throws null : Si no necesita enviar algun color envíe un [null] como parámetro.
  */
  public BasicComboBoxUI devolverJComboBoxPersonalizado(
    JButton boton, Color colorBorde, Color colorFondo, Color colorSeleccionMenu, Color colorFuenteMenu, boolean esSolido
  ) {
    return new BasicComboBoxUI() {

      @Override
      protected JButton createArrowButton() {
        return boton;
      }

      @Override
      public void paintCurrentValueBackground(
        Graphics g, Rectangle bounds, boolean hasFocus
      ) {
        g.setColor(colorBorde);
        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height - 1);
        g.drawRect(
          bounds.x + 1, bounds.y + 1, bounds.width - 2, bounds.height - 3
        );
        if (esSolido) {
          g.setColor(colorFondo);
          g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }
      }

      @Override
      protected ListCellRenderer<Object> createRenderer() {
        return new DefaultListCellRenderer() {
          private static final long serialVersionUID = 1L;

          @Override
          public Component getListCellRendererComponent(
            JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus
          ) {
            super.getListCellRendererComponent(
              list, value, index, isSelected, cellHasFocus
            );
            this.setHorizontalAlignment(SwingConstants.CENTER);
            list.setSelectionBackground(colorSeleccionMenu);
            list.setSelectionForeground(Color.WHITE);
            if (!isSelected) this.setForeground(colorFuenteMenu);
            return this;
          }
        };
      }
    };
  }

  /**
   * Descripción: Esta función se encarga de crear un borde difuminado, [version BETA] se recomienda usar colores claros (por encima de 200 en los canales RGB).
   * Para invocarlo se debe llamar al método: setBorder() de cualquier objeto Gráfico.
   * @param colorBase (Color): Color con el que inicia el borde y con el que empieza la difuminación.
   * @param grosor (int): Grosor del borde (no se recomiendan valores superiores a 10) para objetos gráficos pequeños. Tener en cuenta que el grosor del borde se expande de forma interna en el objeto gráfico.
   * @return Border: Objeto decorador tipo Border.
  */
  public Border devolverBordeDifuminado(Color colorBase, int grosor) {
    Border bordeFinal = null;
    Border bordeInicial = BorderFactory.createLineBorder(colorBase, 1, true);
    Color siguienteColor = new Color(
      colorBase.getRed() + 5, colorBase.getGreen() + 5, colorBase.getBlue() + 5
    );
    int contador = 0;
    while (
      siguienteColor.getRed() < 251 &&
      siguienteColor.getGreen() < 251 &&
      siguienteColor.getBlue() < 251 &&
      contador < grosor
    ) {
      Border bordeExterno = BorderFactory.createLineBorder(
        siguienteColor, 1, true
      );
      if (contador == 0) 
        bordeFinal = BorderFactory.createCompoundBorder(bordeExterno, bordeInicial); 
      else 
        bordeFinal = BorderFactory.createCompoundBorder(bordeExterno, bordeFinal);
      siguienteColor = new Color(
          siguienteColor.getRed() + 5, siguienteColor.getGreen() + 5, siguienteColor.getBlue() + 5
      );
      contador++;
    }
    return bordeFinal;
  }

  /**
   * Descripción: Esta función se encarga de crear un borde con esquinas redondeadas.
   * Para invocarlo se debe llamar al método: setBorder() de cualquier objeto Gráfico.
   * @param colorBorde (Color): Color del contonro del borde en caso de crear el borde lineal.
   * @param radio (int): Valor del arco en las esquinas del borde siendo 0 un arco nulo y con valores mayores se crean bordes redonreados.
   * @param esLineal (boolean): Si quiere crear un borde con contorno o borde lineal se envia el valor (true), en caso de solo crear la forma del borde sin contorno se envia el valor (false).
   * @param esSolido (boolean): Si quiere crear un borde con contorno o borde lineal y ademas quiere que el contenido tenga un color diferente al del fondo, se envia el valor (true) si lo quiere igual al fondo o transparente se envia un (false).
   * @param imagenFondo (ImageIcon): En caso de que el objeto Gráfico que obtenga el borde este situado encima de una imágen de fondo se debe enviar la imágen con las mismas dimensiones para crear el efecto de transparencia en las esquinas redondeadas.
   * @return Border: Objeto decorador tipo Border.
   * @throws null : Si no necesita enviar colorBorde o imagenFondo envíe un [null] como parámetro.
  */
  public Border DibujarBordeRedondeado(
    Color colorBorde, int radio, boolean esLineal, boolean esSolido, Image imagenFondo
  ) {
    Border bordeRedondeado = new Border() {

      @Override
      public void paintBorder(
        Component c, Graphics g, int x, int y, int ancho, int alto
      ) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
          RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
        );
        Area area;
        Component padreContenedor = c.getParent();
        RoundRectangle2D rectanguloBordeado = new RoundRectangle2D.Double();
        rectanguloBordeado.setRoundRect(
          x, y, ancho - 1, alto - 1, radio, radio
        );
        if (esLineal) {
          dibujarFondo(c, padreContenedor, imagenFondo, g2, ancho, alto);
          if(esSolido) {
            g2.setColor(c.getBackground());
            g2.fill(rectanguloBordeado);
          }
          area = dibujarBorde(c, g2, colorBorde, x, y, ancho, alto, rectanguloBordeado);
        } else {
          area = dibujarBorde(c, g2, colorBorde, x, y, ancho, alto, rectanguloBordeado);
          dibujarFondo(c, padreContenedor, imagenFondo, g2, ancho, alto);
        }
        g2.setClip(null);
        g2.draw(area);
      }

      @Override
      public Insets getBorderInsets(Component c) {
        return new Insets(2, 2, 2, 2);
      }

      @Override
      public boolean isBorderOpaque() {
        return false;
      }
    };
    return bordeRedondeado;
  }

  /**
   * Descripción: Esta función se encarga de crear un borde circular.
   * Para invocarlo se debe llamar al método: setBorder() de cualquier objeto Gráfico.
   * @param colorBorde (Color): Color del contonro del borde en caso de crear el borde lineal.
   * @param esLineal (boolean): Si quiere crear un borde con contorno o borde lineal se envia el valor (true), en caso de solo crear la forma del borde sin contorno se envia el valor (false).
   * @param esSolido (boolean): Si quiere crear un borde con contorno o borde lineal y ademas quiere que el contenido tenga un color diferente al del fondo, se envia el valor (true) si lo quiere igual al fondo o transparente se envia un (false).
   * @param imagenFondo (ImageIcon): En caso de que el objeto Gráfico que obtenga el borde este situado encima de una imágen de fondo se debe enviar la imágen con las mismas dimensiones para crear el efecto de transparencia en las esquinas sobrantes de la circunferencia.
   * @return AbstractBorder: Objeto decorador tipo AbstractBorder, compatible con Border.
   * @throws null : Si no necesita enviar colorBorde o imagenFondo envíe un [null] como parámetro.
  */
  public AbstractBorder DibujarBordeCircular(
    Color colorBorde, boolean esLineal, boolean esSolido, Image imagenFondo
  ) {
    AbstractBorder bordeCircular = new AbstractBorder() {
      private static final long serialVersionUID = 2009875951859777681L;

      @Override
      public void paintBorder(
        Component c, Graphics g, int x, int y, int ancho, int alto
      ) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
          RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
        );
        Area area;
        Component padreContenedor = c.getParent();
        Ellipse2D circulo = new Ellipse2D.Double();
        circulo.setFrameFromCenter(
          new Point(x + ancho / 2, y + alto / 2),
          new Point(ancho, alto)
        );
        if (esLineal) {
          dibujarFondo(c, padreContenedor, imagenFondo, g2, ancho, alto);
          if(esSolido) {
            g2.setColor(c.getBackground());
            g2.fill(circulo);
          }
          area = dibujarBorde(c, g2, colorBorde, x, y, ancho, alto, circulo);
        } else {
          area = dibujarBorde(c, g2, colorBorde, x, y, ancho, alto, circulo);
          dibujarFondo(c, padreContenedor, imagenFondo, g2, ancho, alto);
        }
        g2.setClip(null);
        g2.draw(area);
      }
    };
    return bordeCircular;
  }

  private void dibujarFondo(
    Component c, Component padreContenedor, Image imagen, Graphics2D g2, int ancho, int alto
  ) {
    if (imagen != null) 
      g2.drawImage(
        imagen, 
        0, 0,
        imagen.getWidth(null), imagen.getHeight(null),
        c.getX(), c.getY(),
        imagen.getWidth(null) + c.getX(),
        imagen.getHeight(null) + c.getY(),
        c
      ); 
    else {
      g2.setColor(padreContenedor.getBackground());
      g2.fillRect(0, 0, ancho, alto);
    }
  }

  private Area dibujarBorde(
    Component c, Graphics2D g2, Color color, int x, int y, int ancho, int alto, RectangularShape figura
  ) {
    if (color == null) g2.setPaint(c.getBackground()); 
    else g2.setPaint(color);
    Area area = new Area(figura);
    Rectangle rectangulo = new Rectangle(0, 0, ancho, alto);
    Area regionBorde = new Area(rectangulo);
    regionBorde.subtract(area);
    g2.setClip(regionBorde);
    return area;
  }

  public static GraficosAvanzadosService getService() {
    if (servicio == null) servicio = new GraficosAvanzadosService();
    return servicio;
  }
}