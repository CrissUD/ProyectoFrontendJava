package app.services.graphicServices;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.Border;

/** @author Cristian Felipe Patiño Cáceres Github: CrissUD*/

public class RecursosService {
  private GraficosAvanzadosService sGraficosAvanzados;
  private Color colorPrincipal, colorPrincipalOscuro, colorPrincipalClaro, colorSecundario;
  private Color colorAzulMarino, colorGrisOscuro, colorGrisClaro, colorTransparente;
  private Font fontTPrincipal, fontTitulo, fontSubtitulo;
  private Font fontMediana, fontLigera, fontTProducto;
  private Cursor cMano;
  private Border bInferiorAzul, bInferiorGris, bLateralAzul, bGris, bAzul;
  private Border bCircular, bRedondeado, bDifuminado;
  private ImageIcon iCerrar, iMinimizar;

  private static RecursosService servicio;

  private RecursosService() {
    sGraficosAvanzados = GraficosAvanzadosService.getService();
    this.generarFuentes();
    this.personalizarJOptionPane();

    this.crearColores();
    this.crearFuentes();
    this.crearCursores();
    this.crearBordes();
    this.crearImagenes();
  }

  private void crearColores() {
    colorSecundario = new Color(151, 0, 158);
    colorPrincipal = new Color(60, 78, 120);
    colorPrincipalOscuro = new Color(30, 48, 90);
    colorPrincipalClaro = new Color(231, 244, 253);
    colorAzulMarino = new Color(17, 146, 238);
    colorGrisOscuro = new Color(80, 80, 80);
    colorGrisClaro = new Color(247, 247, 247);
    colorTransparente = new Color(0, 0, 0, 0);
  }

  private void crearFuentes() {
    fontTPrincipal = new Font("Rockwell Extra Bold", Font.PLAIN, 20);
    fontTProducto = new Font("LuzSans-Book", Font.BOLD, 28);
    fontTitulo = new Font("Calibri (Cuerpo)", Font.BOLD, 17);
    fontSubtitulo = new Font("Forte", Font.PLAIN, 13);
    fontMediana = new Font("LuzSans-Book", Font.PLAIN, 15);
    fontLigera = new Font("LuzSans-Book", Font.PLAIN, 12);
  }

  private void crearCursores() { cMano = new Cursor(Cursor.HAND_CURSOR); }

  private void crearBordes() {
    bInferiorAzul = BorderFactory.createMatteBorder(0, 0, 2, 0, colorPrincipal);
    bLateralAzul = BorderFactory.createMatteBorder(2, 0, 2, 2, colorPrincipal);
    bInferiorGris = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY);
    bGris = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
    bAzul = BorderFactory.createLineBorder(colorPrincipal, 2, true);
    bCircular = sGraficosAvanzados.DibujarBordeCircular(null, false, false, null);
    bRedondeado = sGraficosAvanzados.DibujarBordeRedondeado(null, 40, false, false, null);
    bDifuminado = sGraficosAvanzados.devolverBordeDifuminado(new Color(215, 215, 215), 8);
  }

  private void crearImagenes() {
    iCerrar = new ImageIcon("ProyectoInterfazGrafica/resources/images/cerrar.png");
    iMinimizar = new ImageIcon("ProyectoInterfazGrafica/resources/images/minimizar.png");
  }

  private void generarFuentes() {
    try {
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont( Font.createFont(
          Font.TRUETYPE_FONT,
          new File("ProyectoInterfazGrafica/resources/fonts/LUZRO.ttf")
      ));
    } catch (IOException | FontFormatException e) {
      System.out.println(e);
    }
  }

  private void personalizarJOptionPane() {
    UIManager.put("OptionPane.background", Color.WHITE);
    UIManager.put("OptionPane.messageForeground", this.colorPrincipalOscuro);
    UIManager.put("Button.background", this.colorPrincipal);
    UIManager.put("Button.foreground", Color.WHITE);
    UIManager.put("Panel.background", Color.WHITE);
  }

  public Color getColorSecundario() { return colorSecundario; }

  public Color getColorPrincipal() { return colorPrincipal; }

  public Color getColorPrincipalOscuro() { return colorPrincipalOscuro; }

  public Color getColorPrincipalClaro() { return colorPrincipalClaro; }

  public Color getColorPrincipalMarino() { return colorAzulMarino; }

  public Color getColorGrisOscuro() { return colorGrisOscuro; }

  public Color getColorGrisClaro() { return colorGrisClaro; }

  public Color getColorTransparente() { return colorTransparente; }

  public Font getFontTProducto() { return fontTProducto; }

  public Font getFontTPrincipal() { return fontTPrincipal; }

  public Font getFontTitulo() { return fontTitulo; }

  public Font getFontSubtitulo() { return fontSubtitulo; }

  public Font getFontMediana() { return fontMediana; }

  public Font getFontLigera() { return fontLigera; }

  public Cursor getCMano() { return cMano; }

  public Border getBInferiorAzul() { return bInferiorAzul; }

  public Border getBLateralAzul() { return bLateralAzul; }

  public Border getBInferiorGris() { return bInferiorGris; }

  public Border getBGris() { return bGris; }

  public Border getBAzul() { return bAzul; }

  public Border getBCircular() { return bCircular; }

  public Border getBRedondeado() { return bRedondeado; }

  public Border getBDifuminado() { return bDifuminado; }

  public ImageIcon getICerrar() { return iCerrar; }

  public ImageIcon getIMinimizar() { return iMinimizar; }

  public static RecursosService getService() {
    if (servicio == null) servicio = new RecursosService();
    return servicio;
  }
}