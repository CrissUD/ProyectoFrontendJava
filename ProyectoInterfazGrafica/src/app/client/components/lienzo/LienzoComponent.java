package app.client.components.lienzo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class LienzoComponent extends MouseAdapter {
  private LienzoTemplate lienzoTemplate;
  private int posicionInicialX, posicionInicialY;

  public LienzoComponent(JPanel pPadre) {
    lienzoTemplate = new LienzoTemplate(this, pPadre);
  }

  public LienzoTemplate getLienzoTemplate() {
    return lienzoTemplate;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    this.posicionInicialX = e.getX();
    this.posicionInicialY = e.getY();
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    this.lienzoTemplate.pintarRectanguloTiempoReal(
      posicionInicialX, posicionInicialY, e
    );
  }
}