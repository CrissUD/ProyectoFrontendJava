package app.services.graphicServices;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/** @author Cristian Felipe Patiño Cáceres Github: CrissUD*/

public class ObjGraficosService {
  private JPanel panel;
  private JScrollPane panelScroll;
  private JButton button;
  private JRadioButton radioButton;
  private JCheckBox check;
  private JLabel label;
  private JTextField textField;
  private JPasswordField passwordField;
  private JTextArea textArea;
  private JComboBox<String> comboBox;

  private static ObjGraficosService servicio;

  private ObjGraficosService() {}

  /**
   * Descripción: Esta función se encarga de construir un objeto gráfico tipo JPanel.
   * @param x (int): Posición inicial en pixeles sobre el eje X.
   * @param y (int): Posición inicial en pixeles sobre el eje Y.
   * @param ancho (int): Tamaño sobre el eje X en pixeles del panel.
   * @param alto (int): Tamaño sobre el eje Y en pixeles del panel.
   * @param colorFondo (Color): Color de fondo o Background del panel.
   * @param borde (Border): Borde del panel.
   * @return panel (JPanel): Objeto gráfico tipo JPanel.
   * @throws null : Si construye un JPanel sin color de fondo o borde envíe un [null] como parámetro.
  */
  public JPanel construirJPanel(
    int x, int y, int ancho, int alto, Color colorFondo, Border borde
  ) {
    panel = new JPanel();
    panel.setLocation(x, y);
    panel.setSize(ancho, alto);
    panel.setLayout(null);
    panel.setBackground(colorFondo);
    panel.setBorder(borde);
    return panel;
  }

  /**
   * Descripción: Esta función se encarga de construir un objeto gráfico tipo JScrollPane.
   * @param componente (Component): Objeto gráfico que contiene el JScrollPane.
   * @param x (int): Posición inicial en pixeles sobre el eje X.
   * @param y (int): Posición inicial en pixeles sobre el eje Y.
   * @param ancho (int): Tamaño sobre el eje X en pixeles del JScrollPane.
   * @param alto (int): Tamaño sobre el eje Y en pixeles del JScrollPane.
   * @param colorFondo (Color): Color de fondo o Background del JScrollPane.
   * @param borde (Border): Borde del JScrollPane.
   * @return panelScroll (JPaneScroll): Objeto gráfico tipo JPaneScroll.
   * @throws null : Si construye un JScrollPane sin color de fondo o borde envíe un [null] como parámetro.
  */
  public JScrollPane construirPanelBarra(
    Component componente, int x, int y, int ancho, int alto, Color colorFondo, Border borde
  ) {
    panelScroll = new JScrollPane(componente);
    panelScroll.setLocation(x, y);
    panelScroll.setSize(ancho, alto);
    panelScroll.getViewport().setBackground(colorFondo);
    panelScroll.setBorder(borde);
    return panelScroll;
  }

  /**
   * Descripción: Esta función se encarga de construir un objeto gráfico tipo JButton.
   * @param texto (String): Texto que contiene el botón.
   * @param x (int): Posición inicial en pixeles sobre el eje X.
   * @param y (int): Posición inicial en pixeles sobre el eje Y.
   * @param ancho (int): Tamaño sobre el eje X en pixeles del botón.
   * @param alto (int): Tamaño sobre el eje Y en pixeles del botón.
   * @param cursor (Cursor): Tipo de cursor que se muestra al pasar sobre el botón.
   * @param imagen (ImageIcon): Imágen que contiene el Botón.
   * @param fuente (Font): Tipo de fuente que tendrá el texto del botón.
   * @param colorFondo (Color): Color de fondo o Background del botón.
   * @param colorFuente (Color): Color de la letra o ForeGround del botón.
   * @param borde (Border): Borde del botón.
   * @param direccion (String): Dirección de los elementos dentro del botón siendo:
   * <ul>
   *   <li>'c' (CENTER): Contenido centrado (por defecto).</li>
   *   <li>'t' (TOP): Contenido centrado con texto arriba de una imágen.</li>
   *   <li>'l' (LEFT): Contenido en la izquierda [Si tiene imágen y texto la imágen se posiciona primero].</li>
   *   <li>'r' (RIGHT): Contenido en la derecha [Si tiene imágen y texto el texto se posiciona primero].</li>
   *   <li>'b' (BOTTOM): Contenido centrado con texto abajo de una imágen.</li>
   * </ul>
   * @param esSolido (boolean): Booleano que indica si el boton tiene color de fondo (true) o tiene fondo transparente (false).
   * @return boton (JButton): Objeto gráfico tipo JButton.
   * @throws null : Si construye un JButton sin texto, cursor, imagen, fuente, colorFondo, colorFuente o borde envíe un [null] como parámetro.
  */
  public JButton construirJButton(
    String texto, int x, int y, int ancho, int alto, Cursor cursor, ImageIcon imagen, Font fuente,
    Color colorFondo, Color colorFuente, Border borde, String direccion, boolean esSolido
  ) {
    button = new JButton(texto);
    button.setLocation(x, y);
    button.setSize(ancho, alto);
    button.setFocusable(false);
    button.setCursor(cursor);
    button.setFont(fuente);
    button.setBackground(colorFondo);
    button.setForeground(colorFuente);
    button.setIcon(imagen);
    button.setBorder(borde);
    button.setContentAreaFilled(esSolido);
    switch (direccion) {
      case "l":
        button.setHorizontalAlignment(SwingConstants.LEFT);
        break;
      case "r":
        button.setHorizontalAlignment(SwingConstants.RIGHT);
        button.setHorizontalTextPosition(SwingConstants.LEFT);
        break;
      case "t":
        button.setVerticalTextPosition(SwingConstants.TOP);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        break;
      case "b":
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        break;
      default:
        break;
    }
    return button;
  }

  /**
   * Descripción: Esta función se encarga de construir un objeto gráfico tipo JRaddioButton.
   * @param texto (String): Texto que contiene el radioButton.
   * @param x (int): Posición inicial en pixeles sobre el eje X.
   * @param y (int): Posición inicial en pixeles sobre el eje Y.
   * @param ancho (int): Tamaño sobre el eje X en pixeles del radioButton.
   * @param alto (int): Tamaño sobre el eje Y en pixeles del radioButton.
   * @param cursor (Cursor): Tipo de cursor que se muestra al pasar sobre el radioButton.
   * @param fuente (Font): Tipo de fuente que tendrá el texto del radioButton.
   * @param colorFuente (Color): Color de la letra o ForeGround del radioButton.
   * @return radioButton (JButton): Objeto gráfico tipo JRadioButton.
   * @throws null : Si construye un JRadioButton sin texto, cursor, fuente, o colorFuente envíe un [null] como parámetro.
  */
  public JRadioButton construirJRadioButton(
    String texto, int x, int y, int ancho, int alto, Cursor cursor, Font fuente, Color colorFuente
  ) {
    radioButton = new JRadioButton(texto);
    radioButton.setLocation(x, y);
    radioButton.setSize(ancho, alto);
    radioButton.setFocusable(false);
    radioButton.setBackground(null);
    radioButton.setCursor(cursor);
    radioButton.setFont(fuente);
    radioButton.setForeground(colorFuente);
    return radioButton;
  }

  /**
   * Descripción: Esta función se encarga de construir un objeto gráfico tipo JCheckBox.
   * @param texto (String): Texto que contiene el checkBox.
   * @param x (int): Posición inicial en pixeles sobre el eje X.
   * @param y (int): Posición inicial en pixeles sobre el eje Y.
   * @param ancho (int): Tamaño sobre el eje X en pixeles del checkBox.
   * @param alto (int): Tamaño sobre el eje Y en pixeles del checkBox.
   * @param cursor (Cursor): Tipo de cursor que se muestra al pasar sobre el checkBox.
   * @param fuente (Font): Tipo de fuente que tendrá el texto del checkBox.
   * @param colorFuente (Color): Color de la letra o ForeGround del checkBox.
   * @return check (JCheckBox): Objeto gráfico tipo JCheckBox.
   * @throws null : Si construye un JCheckBox sin texto, cursor, fuente, o colorFuente envíe un [null] como parámetro.
  */
  public JCheckBox construirJCheckBox(
    String texto, int x, int y, int ancho, int alto, Cursor cursor, Font fuente, Color colorFuente
  ) {
    check = new JCheckBox(texto);
    check.setLocation(x, y);
    check.setSize(ancho, alto);
    check.setFocusable(false);
    check.setBackground(null);
    check.setCursor(cursor);
    check.setFont(fuente);
    check.setForeground(colorFuente);
    return check;
  }

  /**
   * Descripción: Esta función se encarga de construir un objeto gráfico tipo JLabel.
   * @param texto (String): Texto que contiene el label.
   * @param x (int): Posición inicial en pixeles sobre el eje X.
   * @param y (int): Posición inicial en pixeles sobre el eje Y.
   * @param ancho (int): Tamaño sobre el eje X en pixeles del label.
   * @param alto (int): Tamaño sobre el eje Y en pixeles del label.
   * @param cursor (Cursor): Tipo de cursor que se muestra al pasar sobre el label.
   * @param imagen (ImageIcon): Imagen que contiene el label.
   * @param fuente (Font): Tipo de fuente que tendrá el texto del label.
   * @param colorFondo (Color): Color de fondo o Background del label.
   * @param colorFuente (Color): Color de la letra o ForeGround del label.
   * @param borde (Border): Borde del label.
   * @param direccion (String): Dirección de los elementos dentro del label siendo:
   * <ul>
   *   <li>'l' (LEFT): Contenido en la izquierda (por defecto).</li>
   *   <li>'c' (CENTER): Contenido centrado [Si tiene imágen y texto la imágen se posiciona primero].</li>
   *   <li>'t' (TOP): Contenido centrado con texto arriba de una imágen.</li>
   *   <li>'r' (RIGHT): Contenido en la derecha [Si tiene imágen y texto el texto se posiciona primero].</li>
   *   <li>'b' (BOTTOM): Contenido centrado con texto abajo de una imágen.</li>
   * </ul>
   * @return label (JLabel): Objeto gráfico tipo JLabel.
   * @throws null : Si construye un JLabel sin texto, cursor, imagen, fuente, colorFondo, colorFuente o borde envíe un [null] como parámetro.
  */
  public JLabel construirJLabel(
    String texto, int x, int y, int ancho, int alto, Cursor cursor, ImageIcon imagen,
    Font fuente, Color colorFondo, Color colorFuente, Border borde, String direccion
  ) {
    label = new JLabel(texto);
    label.setLocation(x, y);
    label.setSize(ancho, alto);
    label.setForeground(colorFuente);
    label.setFont(fuente);
    label.setCursor(cursor);
    label.setIcon(imagen);
    label.setBorder(borde);
    if (colorFondo != null) {
      label.setOpaque(true);
      label.setBackground(colorFondo);
    }
    switch (direccion) {
      case "c":
        label.setHorizontalAlignment(SwingConstants.CENTER);
        break;
      case "r":
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setHorizontalTextPosition(SwingConstants.LEFT);
        break;
      case "t":
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.TOP);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        break;
      case "b":
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        break;
      default:
        break;
    }
    return label;
  }

  /**
   * Descripción: Esta función se encarga de construir un objeto gráfico tipo JTextField.
   * @param texto (String): Texto que contiene el textField.
   * @param x (int): Posición inicial en pixeles sobre el eje X.
   * @param y (int): Posición inicial en pixeles sobre el eje Y.
   * @param ancho (int): Tamaño sobre el eje X en pixeles del textField.
   * @param alto (int): Tamaño sobre el eje Y en pixeles del textField.
   * @param fuente (Font): Tipo de fuente que tendrá el texto del textField.
   * @param colorFondo (Color): Color de fondo o Background del textField.
   * @param colorFuente (Color): Color de la letra o ForeGround del textField.
   * @param colorCaret (Color): Color del Caret del textField.
   * @param borde (Border): Borde del textField.
   * @param direccion (String): Dirección de los elementos dentro del textField siendo:
   * <ul>
   *   <li>'l' (LEFT): Contenido en la izquierda (por defecto).</li>
   *   <li>'c' (CENTER): Contenido centrado.</li>
   *   <li>'r' (RIGHT): Contenido en la derecha.</li>
   * </ul>
   * @return textField (JTextField): Objeto gráfico tipo JTextField.
   * @throws null : Si construye un JTextField sin texto, fuente, colorFondo, colorFuente, colorCaret o borde envíe un [null] como parámetro.
  */
  public JTextField construirJTextField(
    String texto, int x, int y, int ancho, int alto, Font fuente, Color colorFondo,
    Color colorFuente, Color colorCaret, Border borde, String direccion
  ) {
    textField = new JTextField();
    textField.setLocation(x, y);
    textField.setSize(ancho, alto);
    textField.setText(texto);
    textField.setForeground(colorFuente);
    textField.setBackground(colorFondo);
    textField.setCaretColor(colorCaret);
    textField.setFont(fuente);
    textField.setBorder(borde);
    switch (direccion) {
      case "c":
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        break;
      case "r":
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        break;
      default:
        break;
    }
    return textField;
  }

  /**
   * Descripción: Esta función se encarga de construir un objeto gráfico tipo JPasswordField.
   * @param texto (String): Texto que contiene el passwordField.
   * @param x (int): Posición inicial en pixeles sobre el eje X.
   * @param y (int): Posición inicial en pixeles sobre el eje Y.
   * @param ancho (int): Tamaño sobre el eje X en pixeles del passwordField.
   * @param alto (int): Tamaño sobre el eje Y en pixeles del passwordField.
   * @param fuente (Font): Tipo de fuente que tendrá el texto del passwordField.
   * @param colorFondo (Color): Color de fondo o Background del passwordField.
   * @param colorFuente (Color): Color de la letra o ForeGround del passwordField.
   * @param colorCaret (Color): Color del Caret del passwordField.
   * @param borde (Border): Borde del passwordField.
   * @param direccion (String): Dirección de los elementos dentro del passwordField siendo:
   * <ul>
   *   <li>'l' (LEFT): Contenido en la izquierda (por defecto).</li>
   *   <li>'c' (CENTER): Contenido centrado.</li>
   *   <li>'r' (RIGHT): Contenido en la derecha.</li>
   * </ul>
   * @return passwordField (JPasswordField): Objeto gráfico tipo JPasswordField.
   * @throws null : Si construye un JPasswordField sin texto, fuente, colorFondo, colorFuente, colorCaret o borde envíe un [null] como parámetro.
  */
  public JPasswordField construirJPasswordField(
    String texto, int x, int y, int ancho, int alto, Font fuente, Color colorFondo,
    Color colorFuente, Color colorCaret, Border borde, String direccion
  ) {
    passwordField = new JPasswordField();
    passwordField.setLocation(x, y);
    passwordField.setSize(ancho, alto);
    passwordField.setText(texto);
    passwordField.setForeground(colorFuente);
    passwordField.setBackground(colorFondo);
    passwordField.setCaretColor(colorCaret);
    passwordField.setBorder(borde);
    switch (direccion) {
      case "c":
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        break;
      case "r":
        passwordField.setHorizontalAlignment(SwingConstants.RIGHT);
        break;
      default:
        break;
    }
    return passwordField;
  }

  /**
   * Descripción: Esta función se encarga de construir un objeto gráfico tipo JTextArea.
   * @param texto (String): Texto que contiene el textArea.
   * @param x (int): Posición inicial en pixeles sobre el eje X.
   * @param y (int): Posición inicial en pixeles sobre el eje Y.
   * @param ancho (int): Tamaño sobre el eje X en pixeles del textArea.
   * @param alto (int): Tamaño sobre el eje Y en pixeles del textArea.
   * @param fuente (Font): Tipo de fuente que tendrá el texto del textArea.
   * @param colorFondo (Color): Color de fondo o Background del textArea.
   * @param colorFuente (Color): Color de la letra o ForeGround del textArea.
   * @param colorCaret (Color): Color del Caret del textArea.
   * @param borde (Border): Borde del textArea.
   * @return textArea (JTextArea): Objeto gráfico tipo JTextArea.
   * @throws null : Si construye un JTextArea sin texto, fuente, colorFondo, colorFuente, colorCaret o borde envíe un [null] como parámetro.
  */
  public JTextArea construirJTextArea(
    String texto, int x, int y, int ancho, int alto, Font fuente, 
    Color colorFondo, Color colorFuente, Color colorCaret, Border borde
  ) {
    textArea = new JTextArea();
    textArea.setLocation(x, y);
    textArea.setSize(ancho, alto);
    textArea.setText(texto);
    textArea.setFont(fuente);
    textArea.setForeground(colorFuente);
    textArea.setBackground(colorFondo);
    textArea.setCaretColor(colorCaret);
    textArea.setBorder(borde);
    return textArea;
  }

  /**
   * Descripción: Esta función se encarga de construir un objeto gráfico tipo JComboBox.
   * @param cadena (String): Todas las opciones que tendrá el comboBox, para enviar varias opciones separe cada opcion con un "_".
   * @param x (int): Posición inicial en pixeles sobre el eje X.
   * @param y (int): Posición inicial en pixeles sobre el eje Y.
   * @param ancho (int): Tamaño sobre el eje X en pixeles del comboBox.
   * @param alto (int): Tamaño sobre el eje Y en pixeles del comboBox.
   * @param fuente (Font): Tipo de fuente que tendrá el texto del comboBox.
   * @param colorFondo (Color): Color de fondo o Background del comboBox.
   * @param colorFuente (Color): Color de la letra o ForeGround del comboBox.
   * @param direccion (String): Dirección de los elementos dentro del comboBox siendo:
   * <ul>
   *   <li>'l' (LEFT): Contenido en la izquierda (por defecto).</li>
   *   <li>'c' (CENTER): Contenido centrado.</li>
   *   <li>'r' (RIGHT): Contenido en la derecha.</li>
   * </ul>
   * @return comboBox (JComboBox): Objeto gráfico tipo JComboBox.
   * @throws null : Si construye un JComboBox sin texto, fuente, colorFondo o colorFuente envíe un [null] como parámetro.
  */
  public JComboBox<String> construirJComboBox(
    String cadena, int x, int y, int ancho, int alto, Font fuente,
    Color colorFondo, Color colorFuente, String direccion
  ) {
    comboBox = new JComboBox<String>();
    comboBox.setLocation(x, y);
    comboBox.setSize(ancho, alto);
    for (String item : cadena.split("_")) {
      comboBox.addItem(item);
    }
    comboBox.setFont(fuente);
    comboBox.setBackground(colorFondo);
    comboBox.setForeground(colorFuente);
    switch (direccion) {
      case "c":
        ((JLabel) comboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        break;
      case "r":
        ((JLabel) comboBox.getRenderer()).setHorizontalAlignment(SwingConstants.RIGHT);
        break;
      default:
        break;
    }
    return comboBox;
  }

  public static ObjGraficosService getService() {
    if (servicio == null) servicio = new ObjGraficosService();
    return servicio;
  }
}