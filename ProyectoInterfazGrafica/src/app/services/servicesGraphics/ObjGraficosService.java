package app.services.servicesGraphics;

import java.awt.Component;
import java.awt.Color;
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

/** @author Cristian Felipe Patiño Cáceres */

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

    static private ObjGraficosService servicio;

    private ObjGraficosService(){}

    public JPanel construirJPanel(
        int x, int y, int ancho, int alto, Color colorFondo, Border borde
    ){
        panel = new JPanel(); 
        panel.setLocation(x, y);
        panel.setSize(ancho, alto);
        panel.setLayout(null);
        panel.setBackground(colorFondo);
        panel.setBorder(borde);
        return panel;
    }

    public JScrollPane construirPanelBarra(
        Component componente, int x, int y, int ancho, int alto, Color color, Border borde
    ){
        panelScroll=new JScrollPane(componente);
        panelScroll.setLocation(x, y);
        panelScroll.setSize(ancho, alto); 
        panelScroll.getViewport().setBackground(color);
        panelScroll.setBorder(borde);
        return panelScroll;
    }

    public JButton construirJButton(
        String texto, int x, int y, int ancho, int alto, Cursor cursor, ImageIcon imagen, Font fuente, 
        Color colorFondo, Color colorFuente, Border borde, String direccion, boolean esSolido
    ){
        button= new JButton(texto);
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
        switch(direccion){
            case "l":
                button.setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case "r":
                button.setHorizontalAlignment(SwingConstants.RIGHT);
                break;    
            default:
                break;
        }
        return button;
    }

    public JRadioButton construirJRadioButton(
        String texto, int x, int y, int ancho, int alto, Cursor cursor, Font fuente, Color colorFuente
    ){
        radioButton= new JRadioButton(texto);
        radioButton.setLocation(x, y);
        radioButton.setSize(ancho, alto);
        radioButton.setFocusable(false);
        radioButton.setBackground(null);
        radioButton.setCursor(cursor);
        radioButton.setFont(fuente);
        radioButton.setForeground(colorFuente);
        return radioButton;
    }

    public JCheckBox construirJCheckBox(
        String texto, int x, int y, int ancho, int alto, Cursor cursor, Font fuente, Color colorFuente
    ){
        check= new JCheckBox(texto);
        check.setLocation(x, y);
        check.setSize(ancho, alto);
        check.setFocusable(false);
        check.setBackground(null);
        check.setCursor(cursor);
        check.setFont(fuente);
        check.setForeground(colorFuente);
        return check;
    }

    public JLabel construirJLabel(
        String texto, int x, int y, int ancho, int alto, ImageIcon imagen, Color colorFuente, 
        Color colorFondo, Font fuente, String direccion
    ){        
        label= new JLabel(texto);
        label.setLocation(x, y);
        label.setSize(ancho, alto);
        label.setForeground(colorFuente);
        label.setFont(fuente);
        label.setIcon(imagen);
        if(colorFondo!=null){
            label.setOpaque(true);
            label.setBackground(colorFondo);
        }
        switch(direccion){
            case "c":
                label.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "r":
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;        
            default:
                break;
        }
        return label;
    }

    public JTextField construirJTextField(
        String texto, int x, int y, int ancho, int alto, Color colorFondo, Color colorFuente, 
        Color colorCaret, Font fuente, Border borde, String direccion
    ){        
        textField = new JTextField();
        textField.setLocation(x, y);
        textField.setSize(ancho, alto);
        textField.setText(texto);
        textField.setForeground(colorFuente);
        textField.setBackground(colorFondo);
        textField.setCaretColor(colorCaret);
        textField.setFont(fuente);
        textField.setBorder(borde);
        switch(direccion){
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

    public JPasswordField construirJPasswordField(
        String texto, int x, int y, int ancho, int alto, Color colorFondo, Color colorFuente, 
        Color colorCaret, Font fuente, Border borde, String direccion
    ){        
        passwordField = new JPasswordField();
        passwordField.setLocation(x, y);
        passwordField.setSize(ancho, alto);
        passwordField.setText(texto);
        passwordField.setForeground(colorFuente);
        passwordField.setBackground(colorFondo);
        passwordField.setCaretColor(colorCaret);
        passwordField.setBorder(borde);
        switch(direccion){
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

    public JTextArea construirJTextArea(
        String texto, int x, int y, int ancho, int alto, Color colorFondo, Color colorFuente, 
        Color colorCaret, Font fuente, Border borde
    ){        
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

    public JComboBox<String> construirJComboBox(
        String cadena, int x, int y, int ancho, int alto, Color colorFondo, Color colorFuente, String direccion
    ){
        comboBox=new JComboBox<String>();
        comboBox.setLocation(x, y);
        comboBox.setSize(ancho, alto);
        for(String item : cadena.split("_")){
            comboBox.addItem(item);
        }
        comboBox.setBackground(colorFondo);
        comboBox.setForeground(colorFuente);
        switch(direccion){
            case "c":
                ((JLabel)comboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "r":
                ((JLabel)comboBox.getRenderer()).setHorizontalAlignment(SwingConstants.RIGHT);
                break;        
            default:
                break;
        }
        return comboBox;
    }

    public static ObjGraficosService getService(){
        if(servicio == null)
            servicio = new ObjGraficosService();
        return servicio;
    }
}