package app.client.components.perfil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerfilComponent implements ActionListener{

    private PerfilTemplate perfilTemplate;

    public PerfilComponent(){
        perfilTemplate = new PerfilTemplate(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
    }

    public PerfilTemplate getPerfilTemplate(){
        return perfilTemplate;
    }
}