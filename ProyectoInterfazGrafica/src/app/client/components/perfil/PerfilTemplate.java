package app.client.components.perfil;

import java.awt.Color;
import javax.swing.JPanel;

public class PerfilTemplate extends JPanel{

    private static final long serialVersionUID = 7007624666793242889L;

    private PerfilComponent perfilComponent;

    public PerfilTemplate(PerfilComponent perfilComponent) {

        this.perfilComponent = perfilComponent;
        this.perfilComponent.getClass();
        
        this.setSize(850, 600);
        this.setBackground(Color.RED);
        this.setLayout(null);
        this.setVisible(true);
    }
}