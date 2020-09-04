package app.client.components.barraTitulo;

import app.client.vistaPrincipal.VistaPrincipalComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BarraTituloComponent extends MouseAdapter implements ActionListener {
  private VistaPrincipalComponent vistaPrincipalComponent;
  private BarraTituloTemplate barraTituloTemplate;
  private int posicionInicialX, posicionInicialY;

  public BarraTituloComponent(VistaPrincipalComponent vistaPrincipalComponent) {
    this.vistaPrincipalComponent = vistaPrincipalComponent;
    this.barraTituloTemplate = new BarraTituloTemplate(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if ( e.getSource() == barraTituloTemplate.getBMinimizar()) 
      vistaPrincipalComponent.minimizar();
    if (e.getSource() == barraTituloTemplate.getBCerrar()) 
      System.exit(0);
  }

  @Override
  public void mousePressed(MouseEvent e) {
    posicionInicialX = e.getX() + 250;
    posicionInicialY = e.getY();
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    this.vistaPrincipalComponent.moverVentana(
        e.getXOnScreen() - posicionInicialX,
        e.getYOnScreen() - posicionInicialY
      );
  }

  public BarraTituloTemplate getBarraTituloTemplate() {
    return this.barraTituloTemplate;
  }
}