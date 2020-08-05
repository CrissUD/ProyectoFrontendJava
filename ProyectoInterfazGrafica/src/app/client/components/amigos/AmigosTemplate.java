package app.client.components.amigos;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import app.services.servicesGraphics.GraficosAvanzadosService;
import app.services.servicesGraphics.ObjGraficosService;
import app.services.servicesGraphics.RecursosService;

import java.awt.Color;

public class AmigosTemplate extends JPanel{

    private static final long serialVersionUID = 767443757219592088L;
    // Declaración servicios y objetos
    private AmigosComponent amigosComponent;
    private ObjGraficosService sObjGraficos;
    private GraficosAvanzadosService sGraficosAvanzados;
    private RecursosService sRecursos;

    // Declaración objetos gráficos
    private JPanel pOpciones, pDatos;
    private JButton bMostrar, bInsertar, bFiltrar, bModificar, bEliminar;
    private JTextField tConsulta;
    private JLabel lTitulo, lInstrucciones, lEslogan;
    private JLabel lId, lIdValor, lNombre, lEdad, lOficio, lTelefono, lEmail;
    private JTextField tNombre, tEdad, tOficio, tTelefono, tEmail;
    
    private Color colorGris;

    // Declaración objetos para JTable
    private JScrollPane pTabla;
    private JPanel pCorner;
    private JTable tabla;
    private JTableHeader header;
    private DefaultTableModel modelo;
    private String [] cabecera={"id", "Nombre", "Teléfono", "Email"};

    public AmigosTemplate(AmigosComponent amigosComponent) {

        this.amigosComponent = amigosComponent;
        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.sGraficosAvanzados = GraficosAvanzadosService.getService();
        
        this.colorGris = new Color(235,235,235);

        this.crearJPanels();
        this.crearJTable();
        this.crearContenidoPOpciones();
        this.crearContenidoPDatos();

        this.setSize(850, 600);
        this.setBackground(sRecursos.getColorGrisClaro());
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearJPanels(){
        pOpciones = sObjGraficos.construirJPanel(10, 10, 580, 200, Color.WHITE, null);
        this.add(pOpciones);

        pDatos = sObjGraficos.construirJPanel(600, 10, 240, 580, Color.WHITE, null);
        this.add(pDatos);
    }

    public void crearJTable(){
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);

        tabla = new JTable();
        tabla.setModel(modelo);
        tabla.addMouseListener(amigosComponent);

        tabla.setRowHeight(40);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);

        header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(580, 30));

        pTabla = sObjGraficos.construirPanelBarra(tabla, 10, 220, 580, 370, Color.WHITE, null);

        header.setDefaultRenderer(sGraficosAvanzados.devolverTablaPersonalizada(
            sRecursos.getColorAzul(), null , null, Color.WHITE, sRecursos.getFontPequeña()
        ));
        tabla.setDefaultRenderer(Object.class, sGraficosAvanzados.devolverTablaPersonalizada(
            Color.WHITE, sRecursos.getColorGrisClaro() , sRecursos.getColorAzulOscuro(), 
            sRecursos.getColorGrisOscuro(), sRecursos.getFontPequeña()
        ));
        
        
        pTabla.getVerticalScrollBar().setUI(
            sGraficosAvanzados.devolverScrollPersonalizado(
                7, 10, Color.WHITE, Color.GRAY, sRecursos.getColorGrisOscuro()
            )
        );
        pCorner = new JPanel();
        pCorner.setBackground(sRecursos.getColorAzul());
        pTabla.setCorner(JScrollPane.UPPER_RIGHT_CORNER, pCorner);
        this.add(pTabla);
    }

    public void crearContenidoPOpciones(){
        // LABEL TITULO--------------------------------------------------------------------
        lTitulo = sObjGraficos.construirJLabel(
            "Edición de Contactos", 20, 10, 200, 30, null, sRecursos.getColorGrisOscuro(), 
            null, sRecursos.getFontTitulo(), "c"
        );
        pOpciones.add(lTitulo);

        // TEXTFIELD CONSULTA--------------------------------------------------------------------
        tConsulta = sObjGraficos.construirJTextField(
            "Filtrar...", 30, 60, 380, 40, colorGris , sRecursos.getColorGrisOscuro(), 
            sRecursos.getColorGrisOscuro(), sRecursos.getFontBotones(), null, "c"
        );
        tConsulta.addFocusListener(amigosComponent);
        pOpciones.add(tConsulta);

        // BOTÓN FILTRAR--------------------------------------------------------------------
        bFiltrar = sObjGraficos.construirJButton(
            "Filtrar", 430, 65, 120, 35, sRecursos.getCMano(), null, sRecursos.getFontBotones(), 
            sRecursos.getColorAzul(), Color.WHITE, null, "c", true
        );
        bFiltrar.addMouseListener(amigosComponent);
        bFiltrar.addActionListener(amigosComponent);
        pOpciones.add(bFiltrar);

        // BOTÓN MOSTRAR--------------------------------------------------------------------
        bMostrar = sObjGraficos.construirJButton(
            "Mostrar", 20, 145, 120, 35, sRecursos.getCMano(), null, sRecursos.getFontBotones(), 
            sRecursos.getColorAzul(), Color.WHITE, null, "c", true
        );
        bMostrar.addMouseListener(amigosComponent);
        bMostrar.addActionListener(amigosComponent);
        pOpciones.add(bMostrar);

        // BOTÓN INSERTAR--------------------------------------------------------------------
        bInsertar = sObjGraficos.construirJButton(
            "Insertar", 160, 145, 120, 35, sRecursos.getCMano(), null, sRecursos.getFontBotones(), 
            sRecursos.getColorAzul(), Color.WHITE, null, "c", true
        );
        bInsertar.addMouseListener(amigosComponent);
        bInsertar.addActionListener(amigosComponent);
        pOpciones.add(bInsertar);

        // BOTÓN MODIFICAR--------------------------------------------------------------------
        bModificar = sObjGraficos.construirJButton(
            "Modificar", 300, 145, 120, 35, sRecursos.getCMano(), null, sRecursos.getFontBotones(), 
            sRecursos.getColorAzul(), Color.WHITE, null, "c", true
        );
        bModificar.addMouseListener(amigosComponent);
        bModificar.addActionListener(amigosComponent);
        pOpciones.add(bModificar);

        // BOTÓN ELIMINAR--------------------------------------------------------------------
        bEliminar= sObjGraficos.construirJButton(
            "Eliminar", 440, 145, 120, 35, sRecursos.getCMano(), null, sRecursos.getFontBotones(), 
            sRecursos.getColorAzul(), Color.WHITE, null, "c", true
        );
        bEliminar.addMouseListener(amigosComponent);
        bEliminar.addActionListener(amigosComponent);
        pOpciones.add(bEliminar);
    }

    public void crearContenidoPDatos(){
        // LABEL INSTRUCCIONES ----------------------------------------------------------------
        lInstrucciones = sObjGraficos.construirJLabel(
            "<html>Datos de los contactos<html>", 20, 10, 120, 50, null, 
            sRecursos.getColorGrisOscuro(), null, sRecursos.getFontTitulo(), "l"
        );
        pDatos.add(lInstrucciones);

        // LABEL ESLOGAN ----------------------------------------------------------------
        lEslogan = sObjGraficos.construirJLabel(
            "<html>A continuación puede ver y editar la información del Contacto<html>", 
            20, 50, 180, 90, null, sRecursos.getColorGrisOscuro(), null, 
            sRecursos.getFontPequeña(), "l"
        );
        pDatos.add(lEslogan);

        // LABEL ID ----------------------------------------------------------------
        lId = sObjGraficos.construirJLabel(
            "Id Contacto:", 20, 140, 160, 30, null, 
            sRecursos.getColorAzulOscuro(), null, sRecursos.getFontPequeña(), "l"
        );
        pDatos.add(lId);

        // LABEL ID CONTENIDO ----------------------------------------------------------
        lIdValor = sObjGraficos.construirJLabel(
            "0", 120, 140, 160, 30, null, sRecursos.getColorAzulOscuro(), 
            null, sRecursos.getFontPequeña(), "l"
        );
        pDatos.add(lIdValor);

        // LABEL NOMBRE ----------------------------------------------------------------
        lNombre = sObjGraficos.construirJLabel(
            "Nombre Contacto:", 20, 180, 160, 30, null, 
            sRecursos.getColorAzulOscuro(), null, sRecursos.getFontPequeña(), "l"
        );
        pDatos.add(lNombre);

        // TEXTFIELD NOMBRE ----------------------------------------------------------------
        tNombre = sObjGraficos.construirJTextField(
            "Nombre", 30, 215, 180, 30, colorGris, sRecursos.getColorGrisOscuro(),
            sRecursos.getColorGrisOscuro(), sRecursos.getFontPequeña(), null, "c"
        );
        tNombre.addFocusListener(amigosComponent);
        pDatos.add(tNombre);

        // LABEL EDAD ----------------------------------------------------------------
        lEdad = sObjGraficos.construirJLabel(
            "Edad Contacto:", 20, 265, 160, 30, null, 
            sRecursos.getColorAzulOscuro(), null, sRecursos.getFontPequeña(), "l"
        );
        pDatos.add(lEdad);

        // TEXTFIELD NOMBRE ----------------------------------------------------------------
        tEdad = sObjGraficos.construirJTextField(
            "Edad", 30, 300, 180, 30, colorGris, sRecursos.getColorGrisOscuro(),
            sRecursos.getColorGrisOscuro(), sRecursos.getFontPequeña(), null, "c"
        );
        tEdad.addFocusListener(amigosComponent);
        pDatos.add(tEdad);
        
        // LABEL OFICIO ----------------------------------------------------------------
        lOficio = sObjGraficos.construirJLabel(
            "Oficio Contacto:", 20, 350, 160, 30, null, 
            sRecursos.getColorAzulOscuro(), null, sRecursos.getFontPequeña(), "l"
        );
        pDatos.add(lOficio);

        // TEXTFIELD OFICIO ----------------------------------------------------------------
        tOficio = sObjGraficos.construirJTextField(
            "Oficio", 30, 385, 180, 30, colorGris, sRecursos.getColorGrisOscuro(),
            sRecursos.getColorGrisOscuro(), sRecursos.getFontPequeña(), null, "c"
        );
        tOficio.addFocusListener(amigosComponent);
        pDatos.add(tOficio);
        
        // LABEL TELEFONO ----------------------------------------------------------------
        lTelefono = sObjGraficos.construirJLabel(
            "Telefono Contacto:", 20, 425, 160, 30, null, 
            sRecursos.getColorAzulOscuro(), null, sRecursos.getFontPequeña(), "l"
        );
        pDatos.add(lTelefono);

        // TEXTFIELD TELEFONO ----------------------------------------------------------------
        tTelefono = sObjGraficos.construirJTextField(
            "Telefono", 30, 460, 180, 30, colorGris, sRecursos.getColorGrisOscuro(),
            sRecursos.getColorGrisOscuro(), sRecursos.getFontPequeña(), null, "c"
        );
        tTelefono.addFocusListener(amigosComponent);
        pDatos.add(tTelefono);

        // LABEL EMAIL ----------------------------------------------------------------
        lEmail = sObjGraficos.construirJLabel(
            "Email Contacto:", 20, 510, 160, 30, null, 
            sRecursos.getColorAzulOscuro(), null, sRecursos.getFontPequeña(), "l"
        );
        pDatos.add(lEmail);

        // TEXTFIELD EMAIL ----------------------------------------------------------------
        tEmail = sObjGraficos.construirJTextField(
            "Email", 30, 545, 180, 30, colorGris, sRecursos.getColorGrisOscuro(),
            sRecursos.getColorGrisOscuro(), sRecursos.getFontPequeña(), null, "c"
        );
        tEmail.addFocusListener(amigosComponent);
        pDatos.add(tEmail);
    }

    public JTable getTabla(){
        return tabla;
    }

    public DefaultTableModel getModelo(){
        return modelo;
    }

    public JButton getBMostrar(){
        return bMostrar;
    }

    public JButton getBInsertar(){
        return bInsertar;
    }

    public JButton getBModificar(){
        return bModificar;
    }

    public JButton getBEliminar(){
        return bEliminar;
    }

    public JButton getBFiltrar(){
        return bFiltrar;
    }

    public JLabel getLIdValor(){
        return lIdValor;
    }

    public JTextField getTNombre(){
        return tNombre;
    }

    public JTextField getTEdad(){
        return tEdad;
    }

    public JTextField getTOficio(){
        return tOficio;
    }

    public JTextField getTTelefono(){
        return tTelefono;
    }

    public JTextField getTEmail(){
        return tEmail;
    }

    public JTextField getTConsulta(){
        return tConsulta;
    }
}
