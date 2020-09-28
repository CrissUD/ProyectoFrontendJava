package app.client.components.navegacionUsuario;

import app.client.vistaPrincipal.VistaPrincipalComponent;

import app.services.graphicServices.RecursosService;
import app.services.logicServices.UsuarioService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import models.Usuario;

public class NavegacionUsuarioComponent extends MouseAdapter implements ActionListener {
  private NavegacionUsuarioTemplate navegacionUsuarioTemplate;
  private VistaPrincipalComponent vistaPrincipalComponent;
  private UsuarioService sUsuario;
  private Usuario usuarioLogeado;

  public NavegacionUsuarioComponent(VistaPrincipalComponent vistaPrincipalComponent) {
    this.vistaPrincipalComponent = vistaPrincipalComponent;
    this.sUsuario = UsuarioService.getService();
    this.usuarioLogeado = sUsuario.getUsuarioLogeado();
    this.navegacionUsuarioTemplate = new NavegacionUsuarioTemplate(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    this.vistaPrincipalComponent.mostrarComponente(e.getActionCommand().trim());
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    JButton boton = ((JButton) e.getSource());
    boton.setContentAreaFilled(true);
    boton.setBackground(RecursosService.getService().getColorPrincipalOscuro());
  }

  @Override
  public void mouseExited(MouseEvent e) {
    JButton boton = ((JButton) e.getSource());
    boton.setContentAreaFilled(false);
  }

  public void actualizarValores() {
    this.usuarioLogeado = sUsuario.getUsuarioLogeado();
    this.navegacionUsuarioTemplate.getPSuperior().removeAll();
    this.navegacionUsuarioTemplate.crearJLabels();
    this.navegacionUsuarioTemplate.repaint();
  }

  public Usuario getUsuario() {
    return this.usuarioLogeado;
  }

  public NavegacionUsuarioTemplate getNavegacionUsuarioTemplate() {
    return this.navegacionUsuarioTemplate;
  }
}