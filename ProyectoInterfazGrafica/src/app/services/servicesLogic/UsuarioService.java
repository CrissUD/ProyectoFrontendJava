package app.services.servicesLogic;

import logic.ControlUsuarios;
import models.Usuario;

public class UsuarioService {
    private static UsuarioService servicio;
    private ControlUsuarios cUsuario;
    private String usuarioLogeado;
    
    public UsuarioService() {
        cUsuario = new ControlUsuarios();
    }

    public boolean verificarDatosUsuario(String nombreUsuario, String claveUsuario, String tipoUsuario){
        if(cUsuario.verificarUsuario(nombreUsuario, claveUsuario, tipoUsuario)){
            this.usuarioLogeado = nombreUsuario;
            return true;
        }
        return false;
    }

    public Usuario getUsuarioLogeado(){
        return cUsuario.devolverUsuario(usuarioLogeado);
    }

    public static UsuarioService getService(){
        if(servicio == null)
            servicio = new UsuarioService();
        return servicio;
    }
}