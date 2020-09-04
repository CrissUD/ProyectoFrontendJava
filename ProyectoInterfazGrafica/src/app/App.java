package app;

import app.client.login.LoginComponent;
import javax.swing.SwingUtilities;

public class App {

  public static void main(String[] args) throws Exception {
    SwingUtilities.invokeLater(
      new Runnable() {
        
        public void run() {
          LoginComponent vista = new LoginComponent();
          vista.getClass();
        }
      }
    );
  }
}
