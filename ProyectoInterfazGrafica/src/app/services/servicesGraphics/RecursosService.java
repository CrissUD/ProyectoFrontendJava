package app.services.servicesGraphics;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.FontFormatException;

import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import java.io.File;
import java.io.IOException;

/** @author Cristian Felipe Patiño Cáceres */

public class RecursosService {

    private GraficosAvanzadosService sGraficosAvanzados;
    private Color colorAzul, colorAzulOscuro, colorAzulClaro, colorAzulMarino, colorMorado;
    private Color colorGrisOscuro, colorGrisClaro;
    private Font fontTPrincipal, fontTitulo, fontSubtitulo;
    private Font fontBotones, fontPequeña, fontTProducto;
    private Cursor cMano;
    private Border borderInferiorAzul, borderInferiorGris, bordeLateralAzul, borderGris, borderAzul;
    private Border bordeCircular, bordeRedondeado, bordeDifuminado;
    private ImageIcon iCerrar, iMinimizar;

    static private RecursosService servicio;

    private RecursosService(){
        sGraficosAvanzados = GraficosAvanzadosService.getService();
        this.generarFuentes();

        colorMorado = new Color(151, 0, 158);
        colorAzul = new Color(60, 78, 120);
        colorAzulOscuro = new Color(30, 48, 90);
        colorAzulClaro = new Color(231, 244, 253);
        colorAzulMarino = new Color(17, 146, 238);
        colorGrisOscuro = new Color(80, 80, 80);
        colorGrisClaro = new Color(247, 247, 247);
        fontTPrincipal = new Font("Rockwell Extra Bold", Font.PLAIN, 20);
        fontTProducto = new Font("LuzSans-Book", Font.BOLD, 28);
        fontTitulo = new Font("LuzSans-Books", Font.BOLD, 17);
        fontSubtitulo = new Font("Forte", Font.PLAIN, 13);
        fontBotones = new Font("LuzSans-Book", Font.PLAIN, 15);
        fontPequeña = new Font("LuzSans-Book", Font.PLAIN, 12);
        cMano = new Cursor(Cursor.HAND_CURSOR);
        borderInferiorAzul = BorderFactory.createMatteBorder(0, 0, 2, 0, colorAzul);
        bordeLateralAzul = BorderFactory.createMatteBorder(2, 0, 2, 2, colorAzul);
        borderInferiorGris = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY);
        borderGris = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
        borderAzul = BorderFactory.createLineBorder(colorAzul, 2, true);
        bordeCircular = sGraficosAvanzados.DibujarBordeCircular(null, false, null);
        bordeRedondeado = sGraficosAvanzados.DibujarBordeRedondeado(null, 40, false, null);
        bordeDifuminado = sGraficosAvanzados.devolverBordeDifuminado(new Color(215, 215, 215), 8);
        iCerrar = new ImageIcon("ProyectoInterfazGrafica/resources/images/cerrar.png");
        iMinimizar = new ImageIcon("ProyectoInterfazGrafica/resources/images/minimizar.png");

        this.personalizarJOptionPane();
    }

    public void generarFuentes(){
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(
                Font.TRUETYPE_FONT, new File("ProyectoInterfazGrafica/resources/fonts/LUZRO.ttf")
            ));
        } catch (IOException|FontFormatException e) {
            System.out.println(e);
        }
    }
    

    public void personalizarJOptionPane(){
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("OptionPane.messageForeground", this.colorAzulOscuro);
        UIManager.put("Button.background", this.colorAzul);
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
    }

    public Color getColorMorado(){
        return colorMorado;
    }

    public Color getColorAzul(){
        return colorAzul;
    }

    public Color getColorAzulOscuro(){
        return colorAzulOscuro;
    }

    public Color getColorAzulClaro(){
        return colorAzulClaro;
    }

    public Color getColorAzulMarino(){
        return colorAzulMarino;
    }

    public Color getColorGrisOscuro(){
        return colorGrisOscuro;
    }

    public Color getColorGrisClaro(){
        return colorGrisClaro;
    }

    public Font getFontTProducto(){
        return fontTProducto;
    }

    public Font getFontTPrincipal(){
        return fontTPrincipal;
    }

    public Font getFontTitulo(){
        return fontTitulo;
    }
    
    public Font getFontSubtitulo(){
        return fontSubtitulo;
    }
    
    public Font getFontBotones(){
        return fontBotones;
    }

    public Font getFontPequeña(){
        return fontPequeña;
    }

    public Cursor getCMano(){
        return cMano;
    }

    public Border getBorderInferiorAzul(){
        return borderInferiorAzul;
    }

    public Border getBordeLateralAzul(){
        return bordeLateralAzul;
    }

    public Border getBorderInferiorGris(){
        return borderInferiorGris;
    }

    public Border getBorderGris(){
        return borderGris;
    }

    public Border getBorderAzul(){
        return borderAzul;
    }

    public Border getBordeCircular(){
        return bordeCircular;
    }

    public Border getBordeRedondeado(){
        return bordeRedondeado;
    }

    public Border getBordeDifuminado(){
        return bordeDifuminado;
    }

    public ImageIcon getICerrar(){
        return iCerrar;
    }

    public ImageIcon getIMinimizar(){
        return iMinimizar;
    }

    public static RecursosService getService(){
        if(servicio == null)
            servicio = new RecursosService();
        return servicio;
    }
}