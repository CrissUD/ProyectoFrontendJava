package app.client.components.perfil;

public class PerfilComponent {
  private PerfilTemplate perfilTemplate;

  public PerfilComponent() {
    perfilTemplate = new PerfilTemplate(this);
  }

  public PerfilTemplate getPerfilTemplate() {
    return perfilTemplate;
  }
}