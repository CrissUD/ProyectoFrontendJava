package app.client.components.configuraciones;

import javax.swing.JLabel;
import javax.swing.JPanel;

import app.client.components.lienzo.LienzoComponent;
import app.services.servicesGraphics.ObjGraficosService;
import app.services.servicesGraphics.RecursosService;

import java.awt.Cursor;
import java.awt.Color;

public class ConfiguracionesTemplate extends JPanel{

    private static final long serialVersionUID = -4187150474671099409L;

    // Declaración de servicios e inyección
    private ConfiguracionesComponent configuracionesComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursosService;
    private LienzoComponent lienzoComponent;

    // Declaración de Objetos Gráficos
    private JPanel pDibujo, pDatos;

    // Declaración Labels Estáticos
    private JLabel lTitulo, lTituloPosicion, lTituloEstado;
    private JLabel lPOnClickX, lPOnClickY, lPInicialX, lPInicialY, lPFinalX, lPFinalY;
    private JLabel lPActualX, lPActualY, lLadoX, lLadoY, lZoom, lEstado; 

    // Declaración Labels Dinámicos
    private JLabel lPOnClickXValor, lPOnClickYValor, lPInicialXValor, lPInicialYValor;
    private JLabel lPFinalXValor, lPFinalYValor, lPActualXValor, lPActualYValor;
    private JLabel lLadoXValor, lLadoYValor, lZoomValor, lEstadoValor;

    // Declaración Objetos Decoradores
    private Cursor cCruz;
    
    public ConfiguracionesTemplate(ConfiguracionesComponent configuracionesComponent) {

        this.configuracionesComponent = configuracionesComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursosService = RecursosService.getService();
        
        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJLabelsEstaticos();
        this.crearJLabelsDinamicos();
        this.lienzoComponent = new LienzoComponent(pDibujo);
        this.pDibujo.add(lienzoComponent.getLienzoTemplate());

        this.setSize(850, 600);
        this.setBackground(sRecursosService.getColorGrisClaro());
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearObjetosDecoradores(){
        this.cCruz = new Cursor(Cursor.CROSSHAIR_CURSOR);
    }

    public void crearJPanels(){
        pDibujo = sObjGraficos.construirJPanel(15, 15, 500, 570, Color.WHITE, sRecursosService.getBorderGris());
        pDibujo.setCursor(cCruz);
        pDibujo.addMouseListener(this.configuracionesComponent);
        pDibujo.addMouseMotionListener(this.configuracionesComponent);
        pDibujo.addMouseWheelListener(this.configuracionesComponent);
        this.add(pDibujo);    

        pDatos = sObjGraficos.construirJPanel(530, 15, 305, 570, Color.WHITE, sRecursosService.getBorderGris());
        this.add(pDatos);
    }

    public void crearJLabelsEstaticos(){

        // LABEL TITULO -------------------------------------------------------------------------
        lTitulo = sObjGraficos.construirJLabel(
            "Datos de Eventos", (this.pDatos.getWidth() - 200) / 2, 15, 200, 40, null, 
            sRecursosService.getColorAzul(), null, sRecursosService.getFontTitulo(), "c"
        );
        pDatos.add(lTitulo);

        // LABEL TITULO POSICIÓN-----------------------------------------------------------------
        lTituloPosicion = sObjGraficos.construirJLabel(
            "Datos de Posiciones", 20, 60, 180, 40, null, sRecursosService.getColorMorado(), 
            null, sRecursosService.getFontTitulo(), "l"
        );
        pDatos.add(lTituloPosicion);

        // LABEL TITULO ESTADO--------------------------------------------------------------------
        lTituloEstado = sObjGraficos.construirJLabel(
            "Datos de Estado", 20, 440, 180, 40, null, sRecursosService.getColorMorado(), 
            null, sRecursosService.getFontTitulo(), "l"
        );
        pDatos.add(lTituloEstado);

        // LABEL POSICIÓN EN X CON CLICK----------------------------------------------------------
        lPOnClickX = sObjGraficos.construirJLabel(
            "Posición en X al dar click: ", 40, 100, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPOnClickX);

        // LABEL POSICIÓN EN Y CON CLICK----------------------------------------------------------
        lPOnClickY = sObjGraficos.construirJLabel(
            "Posición en Y al dar click: ", 40, 120, 160, 40, null, sRecursosService.getColorAzul(),
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPOnClickY);

        // LABEL POSICIÓN EN X INICIAL----------------------------------------------------------
        lPInicialX = sObjGraficos.construirJLabel(
            "Posición en X inicial: ", 40, 160, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPInicialX);

        // LABEL POSICIÓN EN Y INICIAL----------------------------------------------------------
        lPInicialY = sObjGraficos.construirJLabel(
            "Posición en Y inicial: ", 40, 180, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPInicialY);

        // LABEL POSICIÓN EN X FINAL----------------------------------------------------------
        lPFinalX = sObjGraficos.construirJLabel(
            "Posición en X final: ", 40, 220, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPFinalX);

        // LABEL POSICIÓN EN Y FINAL----------------------------------------------------------
        lPFinalY = sObjGraficos.construirJLabel(
            "Posición en Y final: ", 40, 240, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPFinalY);

        // LABEL POSICIÓN EN X ACTUAL----------------------------------------------------------
        lPActualX = sObjGraficos.construirJLabel(
            "Posición en X actual: ", 40, 280, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPActualX);

        // LABEL POSICIÓN EN Y ACTUAL----------------------------------------------------------
        lPActualY = sObjGraficos.construirJLabel(
            "Posición en Y actual: ", 40, 300, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPActualY);

        // LABEL LADO EN X -------------------------------------------------------------------
        lLadoX = sObjGraficos.construirJLabel(
            "Valor lado X: ", 40, 340, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lLadoX);

        // LABEL LADO EN Y --------------------------------------------------------------------
        lLadoY = sObjGraficos.construirJLabel(
            "Valor lado Y: ", 40, 360, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lLadoY);

        // LABEL ZOOM --------------------------------------------------------------------------
        lZoom = sObjGraficos.construirJLabel(
            "Zoom en el panel: ", 40, 400, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lZoom);

        // LABEL ESTADO ------------------------------------------------------------------------
        lEstado = sObjGraficos.construirJLabel(
            "Estado: ", 40, 480, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lEstado);
    }

    public void crearJLabelsDinamicos(){

        // LABEL POSICIÓN EN X CON CLICK VALOR -----------------------------------------------------
        lPOnClickXValor = sObjGraficos.construirJLabel(
            "0", 200, 100, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPOnClickXValor);

        // LABEL POSICIÓN EN Y CON CLICK VALOR -----------------------------------------------------
        lPOnClickYValor = sObjGraficos.construirJLabel(
            "0", 200, 120, 160, 40, null, sRecursosService.getColorAzul(),
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPOnClickYValor);

        // LABEL POSICIÓN EN X INICIAL VALOR -----------------------------------------------------
        lPInicialXValor = sObjGraficos.construirJLabel(
            "0", 200, 160, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPInicialXValor);

        // LABEL POSICIÓN EN Y INICIAL VALOR -----------------------------------------------------
        lPInicialYValor = sObjGraficos.construirJLabel(
            "0", 200, 180, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPInicialYValor);

        // LABEL POSICIÓN EN X FINAL VALOR -----------------------------------------------------
        lPFinalXValor = sObjGraficos.construirJLabel(
            "0", 200, 220, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPFinalXValor);

        // LABEL POSICIÓN EN Y FINAL VALOR -----------------------------------------------------
        lPFinalYValor = sObjGraficos.construirJLabel(
            "0", 200, 240, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPFinalYValor);

        // LABEL POSICIÓN EN X ACTUAL VALOR -----------------------------------------------------
        lPActualXValor = sObjGraficos.construirJLabel(
            "0", 200, 280, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPActualXValor);

        // LABEL POSICIÓN EN Y ACTUAL VALOR -----------------------------------------------------
        lPActualYValor = sObjGraficos.construirJLabel(
            "0", 200, 300, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPActualYValor);

        // LABEL LADO EN X VALOR --------------------------------------------------------------
        lLadoXValor = sObjGraficos.construirJLabel(
            "0", 200, 340, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lLadoXValor);

        // LABEL LADO EN Y VALOR ---------------------------------------------------------------
        lLadoYValor = sObjGraficos.construirJLabel(
            "0", 200, 360, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lLadoYValor);

        // LABEL ZOOM VALOR ----------------------------------------------------------------------
        lZoomValor = sObjGraficos.construirJLabel(
            "0", 200, 400, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lZoomValor);

        // LABEL ESTADO VALOR -------------------------------------------------------------------
        lEstadoValor = sObjGraficos.construirJLabel(
            "NINGUNO", 80, 520, 160, 40, null, sRecursosService.getColorAzul(), 
            null, sRecursosService.getFontTitulo(), "l"
        );
        pDatos.add(lEstadoValor);
    }

    public JLabel getLPOnClickXValor (){
        return lPOnClickXValor;
    }

    public JLabel getLPOnClickYValor (){
        return lPOnClickYValor;
    }

    public JLabel getLPInicialXValor (){
        return lPInicialXValor;
    }

    public JLabel getLPInicialYValor (){
        return lPInicialYValor;
    }

    public JLabel getLPFinalXValor (){
        return lPFinalXValor;
    }

    public JLabel getLPFinalYValor (){
        return lPFinalYValor;
    }

    public JLabel getLPActualXValor (){
        return lPActualXValor;
    }

    public JLabel getLPActualYValor (){
        return lPActualYValor;
    }

    public JLabel getLLadoXValor (){
        return lLadoXValor;
    }

    public JLabel getLLadoYValor (){
        return lLadoYValor;
    }

    public JLabel getLZoomValor (){
        return lZoomValor;
    }

    public JLabel getLEstadoValor (){
        return lEstadoValor;
    }
}