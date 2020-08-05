package app;

import javax.swing.SwingUtilities;

import app.client.login.LoginComponent;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginComponent vista = new LoginComponent();
                vista.getClass();
            }
        });
    }
}