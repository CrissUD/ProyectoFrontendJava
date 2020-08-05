package app.client.components.accion;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.services.servicesGraphics.ObjGraficosService;
import app.services.servicesGraphics.RecursosService;

public class AccionTemplate extends JPanel {

    private static final long serialVersionUID = -988664250754837512L;

    // Declaración de servicios y objetos
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private AccionComponent accionComponent;

    // Declaración Objetos Gráficos
    private JLabel lImagen, lTitulo, lParrafo;

    // Declaración Objetos Decoradores
    private ImageIcon iDimAux;

    public AccionTemplate(
        AccionComponent accionComponent, ImageIcon imagen, String titulo, String parrafo
    ){

        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.accionComponent = accionComponent;
        this.accionComponent.getClass();

        iDimAux = new ImageIcon(
            imagen.getImage().getScaledInstance(45, 45, Image.SCALE_AREA_AVERAGING)
        );
        this.lImagen = sObjGraficos.construirJLabel(
            null, (250-60)/2, 15, 45, 45, iDimAux, null, null, null, "c"
        );
        this.add(lImagen);

        this.lTitulo = sObjGraficos.construirJLabel(
            titulo, (250-220)/2, 60, 220, 30, null, sRecursos.getColorGrisOscuro(), 
            null, sRecursos.getFontTitulo(), "c"
        );
        this.add(lTitulo);

        this.lParrafo = sObjGraficos.construirJLabel(
            "<html><div align='center'>"+parrafo+"</div></html>", (250-230)/2, 85, 230, 50, null, 
            sRecursos.getColorGrisOscuro(), null, sRecursos.getFontPequeña(), "c"
        );
        this.add(lParrafo);

        this.setSize(250, 135);
        this.setBackground(Color.WHITE);
        this.setBorder(sRecursos.getBordeDifuminado());
        this.setLayout(null);
        this.setVisible(true);
    }
}