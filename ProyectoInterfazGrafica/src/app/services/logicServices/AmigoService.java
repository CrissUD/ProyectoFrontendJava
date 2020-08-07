package app.services.servicesLogic;

import java.util.ArrayList;

import logic.ControlAmigos;
import models.Amigo;

public class AmigoService {
    private static AmigoService servicio;
    private ControlAmigos cAmigos;
    private ArrayList<Amigo> amigos;

    public AmigoService(){
        cAmigos = new ControlAmigos();
        amigos = cAmigos.getAmigos();
    }

    public Amigo devolverAmigo(int posicion){
        try{
            return amigos.get(posicion);
        }
        catch(Exception e){
            return null;
        }
    }

    public void agregarAmigo(Amigo amigo){
        this.amigos.add(amigo);
    }

    public int devolverCantidadAmigos(){
        return amigos.size();
    }

    public static AmigoService getService(){
        if(servicio == null)
            servicio = new AmigoService();
        return servicio;
    }
}