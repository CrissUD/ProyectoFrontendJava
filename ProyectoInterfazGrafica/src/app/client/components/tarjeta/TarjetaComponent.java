package app.client.components.tarjeta;

import javax.swing.ImageIcon;

public class TarjetaComponent{

    private TarjetaTemplate tarjetaTemplate;

    public TarjetaComponent(
        String titulo, ImageIcon iImagen, String parrafo
    ){
        tarjetaTemplate = new TarjetaTemplate(
            this, titulo, iImagen, parrafo
        );
    }

    public TarjetaTemplate getTarjetaTemplate(){
        return tarjetaTemplate;
    }
}