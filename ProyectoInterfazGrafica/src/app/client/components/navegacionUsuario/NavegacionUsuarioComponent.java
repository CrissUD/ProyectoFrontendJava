package app.client.components.navegacionUsuario;

import app.client.vistaPrincipal.VistaPrincipalComponent;

import app.services.graphicServices.RecursosService;
import app.services.logicServices.UsuarioService;

import models.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class NavegacionUsuarioComponent extends MouseAdapter implements ActionListener {
  private NavegacionUsuarioTemplate navegacionUsuarioTemplate;
  private VistaPrincipalComponent vistaPrincipalComponent;
  private UsuarioService sUsuario;
  private Usuario usuarioConectado;

  public NavegacionUsuarioComponent(VistaPrincipalComponent vistaPrincipalComponent) {
    this.vistaPrincipalComponent = vistaPrincipalComponent;
    this.sUsuario = UsuarioService.getService();
    this.usuarioConectado = sUsuario.getUsuarioConectado();
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
    this.usuarioConectado = sUsuario.getUsuarioConectado();
    this.navegacionUsuarioTemplate.getPSuperior().removeAll();
    this.navegacionUsuarioTemplate.crearJLabels();
    this.navegacionUsuarioTemplate.repaint();
  }

  public Usuario getUsuario() {
    return this.usuarioConectado;
  }

  public NavegacionUsuarioTemplate getNavegacionUsuarioTemplate() {
    return this.navegacionUsuarioTemplate;
  }
}