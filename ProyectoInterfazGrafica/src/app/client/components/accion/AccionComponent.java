package app.client.components.accion;

import models.Accion;

public class AccionComponent {
  private AccionTemplate accionTemplate;

  public AccionComponent(Accion accion) {
    this.accionTemplate = new AccionTemplate(this, accion);
  }

  public AccionTemplate getAccionTemplate() {
    return accionTemplate;
  }
}