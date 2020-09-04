package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import models.Amigo;

public class ControlAmigos {
  private ArrayList<Amigo> amigos;

  public ControlAmigos() {
    amigos = new ArrayList<Amigo>();
    cargarDatos();
  }

  public void cargarDatos() {
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    try {
      archivo = new File("ProyectoInterfazGrafica/src/archives/amigos.txt");
      fr = new FileReader(archivo);
      br = new BufferedReader(fr);
      String linea;
      while ((linea = br.readLine()) != null) {
        String[] atributos = linea.split(",");
        Amigo amigo = new Amigo();
        amigo.setId(Integer.parseInt(atributos[0]));
        amigo.setNombre(atributos[1]);
        amigo.setEdad(atributos[2]);
        amigo.setOficio(atributos[3]);
        amigo.setTelefono(atributos[4]);
        amigo.setEmail(atributos[5]);
        amigos.add(amigo);
      }
      fr.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Amigo> getAmigos() { return amigos; }
}