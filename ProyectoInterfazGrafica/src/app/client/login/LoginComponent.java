package app.client.login;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import app.services.servicesLogic.UsuarioService;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginComponent implements ActionListener, MouseListener {

    private LoginTemplate loginTemplate;
    private VistaPrincipalComponent vistaPrincipal;
    private UsuarioService sUsuario;
    private JButton boton;
    private JLabel label;
    private int estado = 1, estadoAnterior = 0, direccion = -1;
    private Timer timer;

    public LoginComponent() {
        sUsuario = UsuarioService.getService();
        this.timer=new Timer(1, this);
        this.loginTemplate = new LoginTemplate(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
            this.estadoAnterior = estado;
            loginTemplate.getBOpcion(estadoAnterior).setIcon(loginTemplate.getIPunto());
            if (e.getSource() == loginTemplate.getBOpcion(1)){
                this.estado = 1;
                this.direccion = -1;
            }
            if (e.getSource() == loginTemplate.getBOpcion(2))
                this.estado = 2;
            if (e.getSource() == loginTemplate.getBOpcion(3)){
                this.estado = 3;
                this.direccion = 1;
            }
            loginTemplate.getBOpcion(estado).setIcon(loginTemplate.getIPunto2());
            timer.start();
        }
        moverImagenes();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == loginTemplate.getBEntrar())
            this.enviarDatosUsuario();
        if (e.getSource() == loginTemplate.getBCerrar())
            System.exit(0);
        if (e.getSource() == loginTemplate.getBRegistrarse()) 
            JOptionPane.showMessageDialog(null, "Boton Registro", "Advertencia", 1);
        
        if (e.getSource() == loginTemplate.getTNombreUsuario()) {
            // BORRA EL PLACEHOLDER
            if (loginTemplate.getTNombreUsuario().getText().equals("Nombre Usuario"))
                loginTemplate.getTNombreUsuario().setText("");
            // CAMBIA EL COLOR A GRIS DEL JPASSWORLDFIELD SI ESTA VACIÓ
            if (new String(loginTemplate.getTClaveUsuario().getPassword()).equals("")) {
                loginTemplate.getTClaveUsuario().setBorder(loginTemplate.getRecursosService().getBorderInferiorGris());
                loginTemplate.getTClaveUsuario().setForeground(loginTemplate.getRecursosService().getColorGrisOscuro());
            }
            // CAMBIA EL COLOR A AZUL DEL JTEXTFIELD
            loginTemplate.getTNombreUsuario().setBorder(loginTemplate.getRecursosService().getBorderInferiorAzul());
            loginTemplate.getTNombreUsuario().setForeground(loginTemplate.getRecursosService().getColorAzul());
        }
        if (e.getSource() == loginTemplate.getTClaveUsuario()) {
            // BORRA EL PLACEHOLDER
            if (new String(loginTemplate.getTClaveUsuario().getPassword()).equals("clave Usuario"))
                loginTemplate.getTClaveUsuario().setText("");
            // CAMBIA EL COLOR A GRIS DEL JTEXTFIELD SI ESTA VACIÓ
            if (loginTemplate.getTNombreUsuario().getText().equals("")) {
                loginTemplate.getTNombreUsuario().setBorder(loginTemplate.getRecursosService().getBorderInferiorGris());
                loginTemplate.getTNombreUsuario()
                        .setForeground(loginTemplate.getRecursosService().getColorGrisOscuro());
            }
            // CAMBIA EL COLOR A AZUL DEL JPASSWORLDFIELD
            loginTemplate.getTClaveUsuario().setBorder(loginTemplate.getRecursosService().getBorderInferiorAzul());
            loginTemplate.getTClaveUsuario().setForeground(loginTemplate.getRecursosService().getColorAzul());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(loginTemplate.getRecursosService().getColorAzulOscuro());
        }
        if (e.getSource() instanceof JLabel) {
            label = ((JLabel) e.getSource());
            label.setForeground(loginTemplate.getRecursosService().getColorMorado());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(loginTemplate.getRecursosService().getColorAzul());
        }
        if (e.getSource() instanceof JLabel) {
            label = ((JLabel) e.getSource());
            label.setForeground(loginTemplate.getRecursosService().getColorAzul());
        }
    }

    public void enviarDatosUsuario() {
        String nombreUsuario = loginTemplate.getTNombreUsuario().getText();
        String claveUsuario = new String(loginTemplate.getTClaveUsuario().getPassword());
        String tipoUsuario = ((String) loginTemplate.getCbTipoUsuario().getSelectedItem());
        if(sUsuario.verificarDatosUsuario(nombreUsuario, claveUsuario, tipoUsuario)){
            JOptionPane.showMessageDialog(null, "Ingreso Exitoso", "Advertencia", 1);
            entrar();
        }
        else
            JOptionPane.showMessageDialog(null, "Algo quedo mal", "Advertencia", 2);
    }

    public void entrar() {
        if (vistaPrincipal == null)
            this.vistaPrincipal = new VistaPrincipalComponent(this);
        else{
            this.vistaPrincipal.restaurarValores();
            this.vistaPrincipal.getVistaPrincipalTemplate().setVisible(true);
        }
        loginTemplate.setVisible(false);
    }

    public void restaurarValores(){
        this.getLoginTemplate().getTNombreUsuario().setText("Nombre Usuario");
        this.getLoginTemplate().getTNombreUsuario().setBorder(
            this.getLoginTemplate().getRecursosService().getBorderInferiorGris()
        );
        this.getLoginTemplate().getTNombreUsuario().setForeground(
            this.getLoginTemplate().getRecursosService().getColorGrisOscuro()
        );
        this.getLoginTemplate().getTClaveUsuario().setText("clave Usuario");
        this.getLoginTemplate().getTClaveUsuario().setBorder(
            this.getLoginTemplate().getRecursosService().getBorderInferiorGris()
        );
        this.getLoginTemplate().getTClaveUsuario().setForeground(
            this.getLoginTemplate().getRecursosService().getColorGrisOscuro()
        );
        this.getLoginTemplate().getCbTipoUsuario().setSelectedIndex(0);
    }

    private void moverImagenes(){
        switch(estado){
            case 1:
                if(loginTemplate.getPSvg().getX() == 100)
                    timer.stop();
                else
                    loginTemplate.getPSvg().setLocation(
                        loginTemplate.getPSvg().getX() + 1, loginTemplate.getPSvg().getY()
                    );
                break;
            case 2:
                if(loginTemplate.getPSvg().getX() == -500)
                    timer.stop();
                else
                    loginTemplate.getPSvg().setLocation(
                        loginTemplate.getPSvg().getX() + direccion, loginTemplate.getPSvg().getY()
                    );
                break;
            case 3:
                if(loginTemplate.getPSvg().getX() == -1100)
                    timer.stop();
                else
                    loginTemplate.getPSvg().setLocation(
                        loginTemplate.getPSvg().getX() - 1, loginTemplate.getPSvg().getY()
                    );
                break;
        }
        loginTemplate.repaint(0, 80, 620, 375);
    }

    public LoginTemplate getLoginTemplate() {
        return this.loginTemplate;
    }
}