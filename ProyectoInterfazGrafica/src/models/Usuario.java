package models;

import javax.swing.ImageIcon;

public class Usuario {
  private String nombreUsuario;
  private String claveUsuario;
  private String tipoUsuario;
  private ImageIcon imagenUsuario;

  public String getNombreUsuario() { return nombreUsuario; }

  public String getClaveUsuario() { return claveUsuario; }

  public String getTipoUsuario() { return tipoUsuario; }

  public ImageIcon getImagenUsuario() { return imagenUsuario; }

  public void setNombreUsuario(String nombreUsuario) {
    this.nombreUsuario = nombreUsuario;
  }

  public void setClaveUsuario(String claveUsuario) {
    this.claveUsuario = claveUsuario;
  }

  public void setTipoUsuario(String tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
  }

  public void setImagenUsuario(ImageIcon imagenUsuario) {
    this.imagenUsuario = imagenUsuario;
  }
}