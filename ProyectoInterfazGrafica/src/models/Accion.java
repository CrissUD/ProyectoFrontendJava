package models;

import javax.swing.ImageIcon;

public class Accion {
  private String nombreAccion;
  private String descripcionAccion;
  private ImageIcon imagenAccion;

  public String getNombreAccion() { return nombreAccion; }

  public String getDescripcionAccion() { return descripcionAccion; }

  public ImageIcon getImagenAccion() { return imagenAccion; }

  public void setNombreAccion(String nombreAccion) {
    this.nombreAccion = nombreAccion;
  }

  public void setDescripcionAccion(String descripcionAccion) {
    this.descripcionAccion = descripcionAccion;
  }

  public void setImagenAccion(ImageIcon imagenAcciIcon) {
    this.imagenAccion = imagenAcciIcon;
  }
}