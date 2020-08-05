package app.services.servicesLogic;

import javax.swing.ImageIcon;

import models.Accion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class AccionService {
    
    private static AccionService servicio;
    private ArrayList<Accion> acciones;


    public AccionService() {
        acciones = new ArrayList<Accion>();
        cargarDatos();
    }

    public void cargarDatos(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File ("ProyectoInterfazGrafica/src/archives/aciones.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            String linea;
            while((linea=br.readLine())!=null){
                String[] atributos = linea.split(",");
                Accion accion = new Accion();
                accion.setNombreAccion(atributos[0]);
                accion.setDescripcionAccion(atributos[1]);
                accion.setImagenAccion(new ImageIcon(atributos[2]));
                acciones.add(accion);
            }
            fr.close(); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Accion devolverAccion(int posicion){
        try{
            return acciones.get(posicion);
        }
        catch(Exception e){
            return null;
        }
    }

    public static AccionService getService(){
        if(servicio == null)
            servicio = new AccionService();
        return servicio;
    }
}