package app.client.components.lienzo;

import app.services.graphicServices.RecursosService;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
// import java.awt.Image;
// import java.awt.geom.RoundRectangle2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LienzoTemplate extends Canvas {
  private static final long serialVersionUID = 1L;
  
  private LienzoComponent lienzoComponent;
  private RecursosService sRecursos;
  private Graphics2D g2d;
  private ImageIcon sprites = new ImageIcon(
    "ProyectoInterfazGrafica/resources/images/sprites.png"
  );

  public LienzoTemplate(LienzoComponent lienzoComponent, JPanel pPadre) {
    this.lienzoComponent = lienzoComponent;
    this.sRecursos = RecursosService.getService();

    this.addMouseListener(pPadre.getMouseListeners()[0]);
    this.addMouseMotionListener(pPadre.getMouseMotionListeners()[0]);
    this.addMouseWheelListener(pPadre.getMouseWheelListeners()[0]);

    this.addMouseListener(this.lienzoComponent);
    this.addMouseMotionListener(this.lienzoComponent);
    this.setBounds(2, 2, 496, 566);
    this.setBackground(Color.WHITE);
    this.setVisible(true);
  }

  @Override
  public void paint(Graphics g) {
    g2d = (Graphics2D) g.create();
    g2d.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
    );
    g2d.setRenderingHint(
      RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE
    );
    // this.pintarStrings(g2d);
    // this.pintarRectangulos(g2d);
    // this.pintarLineas(g2d);
    // this.pintarArcos(g2d);
    // this.pintarOvalos(g2d);
    // this.pintarPoligonos(g2d);
    // this.pintarImagenes(g2d);
    this.pintarAreas(g2d);
  }

  public void pintarStrings(Graphics2D g2d) {
    g2d.setColor(sRecursos.getColorAzul());
    g2d.setFont(sRecursos.getFontTitulo());
    g2d.drawString("Rectangulos", (this.getWidth() / 2) - 50, 15);
    g2d.drawString("Arcos", (this.getWidth() / 2) - 23, 165);
    g2d.drawString("Óvalos y Polígonos", (this.getWidth() / 2) - 65, 315);
    g2d.drawString("Imágenes", (this.getWidth() / 2) - 35, 465);
  }

  public void pintarRectangulos(Graphics2D g2d) {
    g2d.setColor(sRecursos.getColorAzul());
    g2d.fillRect(15, 65, 100, 50);
    g2d.drawRect(135, 40, 100, 100);
    g2d.fillRoundRect(255, 40, 100, 100, 20, 20);
    g2d.drawRoundRect(400, 40, 50, 100, 20, 20);
  }

  public void pintarLineas(Graphics2D g2d) {
    g2d.setColor(sRecursos.getColorMorado());
    g2d.drawLine(0, 150, 496, 150);
    g2d.drawLine(0, 300, 496, 300);
    g2d.drawLine(0, 450, 496, 450);
  }

  public void pintarArcos(Graphics2D g2d) {
    g2d.setColor(sRecursos.getColorAzul());

    g2d.fillArc(15, 190, 100, 100, 0, 90);
    g2d.fillArc(15, 190, 100, 100, 180, 90);
    g2d.setColor(Color.ORANGE);
    g2d.fillArc(15, 190, 100, 100, 90, 90);
    g2d.fillArc(15, 190, 100, 100, 270, 90);

    g2d.setColor(sRecursos.getColorAzul());
    g2d.drawArc(135, 190, 100, 100, 0, 90);
    g2d.drawArc(135, 190, 100, 100, 180, 90);
    g2d.setColor(Color.ORANGE);
    g2d.drawArc(135, 190, 100, 100, 90, 90);
    g2d.drawArc(135, 190, 100, 100, 270, 90);

    g2d.setColor(sRecursos.getColorAzul());
    g2d.fillArc(255, 190, 100, 100, 0, 180);

    g2d.drawArc(375, 190, 100, 100, -15, 90);
    g2d.setColor(Color.ORANGE);
    g2d.drawArc(375, 190, 100, 100, 105, 90);
    g2d.setColor(sRecursos.getColorMorado());
    g2d.drawArc(375, 190, 100, 100, 225, 90);
  }

  public void pintarOvalos(Graphics2D g2d) {
    g2d.setColor(sRecursos.getColorAzul());
    g2d.fillOval(15, 340, 100, 100);

    g2d.drawOval(160, 340, 50, 100);
    g2d.drawOval(135, 365, 100, 50);
  }

  public void pintarPoligonos(Graphics2D g2d) {
    g2d.setColor(sRecursos.getColorAzul());
    g2d.fillPolygon(
      new int[] { 305, 255, 355 },
      new int[] { 340, 440, 440 },
      3
    );

    g2d.drawPolygon(
      new int[] { 400, 450, 475, 475, 450, 400, 375, 375 },
      new int[] { 340, 340, 365, 415, 440, 440, 415, 365 },
      8
    );
  }

  public void pintarImagenes(Graphics2D g2d) {
    for (int i = 0; i < 7; i++) {
      g2d.drawImage(
        sprites.getImage(),
        90 + (45 * i), 490,
        135 + (45 * i), 550,
        0 + (45 * i), 0,
        45 + (45 * i), 60,
        null
      );
    }
  }

  public void pintarAreas(Graphics2D g2d) {
    g2d.setColor(sRecursos.getColorAzul());
    g2d.fillRect(80, 30, 340, 340);

    g2d.setColor(Color.WHITE);
    g2d.setFont(sRecursos.getFontTitulo());
    g2d.drawString("Soy un Panel", 200, 200);

    g2d.setPaint(Color.ORANGE);
    // RoundRectangle2D rectanguloRedondeado = new RoundRectangle2D.Double();
    // rectanguloRedondeado.setRoundRect(80, 30, 340, 340, 100, 100);

    Ellipse2D circulo = new Ellipse2D.Double();
    circulo.setFrameFromCenter(
      (80 + 340 / 2), (30 + 340 / 2),
      340 + 80, 340 + 30
    );

    Area area = new Area(circulo);

    Rectangle rectangulo = new Rectangle(80, 30, 340, 340);
    Area areaFueraBorde = new Area(rectangulo);
    areaFueraBorde.subtract(area);
    g2d.setClip(areaFueraBorde);

    g2d.setColor(Color.WHITE);
    g2d.fillRect(80, 30, 340, 340);

    g2d.setClip(null);
    g2d.draw(area);
  }

  public void pintarRectanguloTiempoReal(int x, int y, MouseEvent e) {
    g2d.setColor(Color.WHITE);
    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
    g2d.setColor(sRecursos.getColorAzul());

    // Dirección Inferior Izquierda
    if (e.getX() - x < 0 && e.getY() - y > 0) 
      g2d.drawRect(e.getX(), y, x - e.getX(), e.getY() - y );

    // Dirección Superior Izquierda
    if (e.getX() - x < 0 && e.getY() - y < 0) 
      g2d.drawRect(e.getX(), e.getY(), x - e.getX(), y - e.getY() );

    // Dirección Superior Derecha
    if (e.getX() - x > 0 && e.getY() - y < 0) 
      g2d.drawRect( x, e.getY(), e.getX() - x, y - e.getY() );

    // Dirección Inferior Derecha
    if (e.getX() - x > 0 && e.getY() - y > 0) 
      g2d.drawRect( x, y, e.getX() - x, e.getY() - y );
  }
}