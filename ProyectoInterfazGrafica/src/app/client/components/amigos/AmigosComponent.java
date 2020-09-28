package app.client.components.amigos;

import app.services.graphicServices.RecursosService;
import app.services.logicServices.AmigoService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import models.Amigo;

public class AmigosComponent extends MouseAdapter implements ActionListener, FocusListener {
  private AmigosTemplate amigosTemplate;
  private AmigoService sAmigos;
  private String[] placeholders = {
    "Nombre", "Edad", "Oficio", "Telefono", "Email", "Filtrar...",
  };
  private Amigo amigo;

  public AmigosComponent() {
    sAmigos = AmigoService.getService();
    amigosTemplate = new AmigosTemplate(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == amigosTemplate.getBMostrar()) mostrarRegistrosTabla();
    if (e.getSource() == amigosTemplate.getBInsertar()) insertarRegistroTabla();
    if (e.getSource() == amigosTemplate.getBModificar()) modificarRegistroTabla();
    if (e.getSource() == amigosTemplate.getBEliminar()) eliminarRegistroTabla();
    if (e.getSource() == amigosTemplate.getBFiltrar()) filtrarRegistrosTabla();
  }

  public AmigosTemplate getAmigosTemplate() {
    return amigosTemplate;
  }

  @Override
  public void focusGained(FocusEvent e) {
    JTextField textField = ((JTextField) e.getSource());
    textField.setBorder(RecursosService.getService().getBAzul());
    if (
      textField.getText().equals(placeholders[0]) ||
      textField.getText().equals(placeholders[1]) ||
      textField.getText().equals(placeholders[2]) ||
      textField.getText().equals(placeholders[3]) ||
      textField.getText().equals(placeholders[4]) ||
      textField.getText().equals(placeholders[5])
    ) textField.setText("");
  }

  @Override
  public void focusLost(FocusEvent e) {
    JTextField textField = ((JTextField) e.getSource());
    textField.setBorder(null);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getSource() instanceof JTable) {
      int fila = amigosTemplate.getTabla().getSelectedRow();
      amigo = sAmigos.devolverAmigo(fila);
      amigosTemplate.getLIdValor().setText(amigo.getId() + "");
      amigosTemplate.getTNombre().setText(amigo.getNombre());
      amigosTemplate.getTEdad().setText(amigo.getEdad());
      amigosTemplate.getTOficio().setText(amigo.getOficio());
      amigosTemplate.getTTelefono().setText(amigo.getTelefono());
      amigosTemplate.getTEmail().setText(amigo.getEmail());
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    if (e.getSource() instanceof JButton) {
      JButton boton = ((JButton) e.getSource());
      boton.setBackground(RecursosService.getService().getColorPrincipalOscuro());
    }
  }

  @Override
  public void mouseExited(MouseEvent e) {
    if (e.getSource() instanceof JButton) {
      JButton boton = ((JButton) e.getSource());
      boton.setBackground(RecursosService.getService().getColorPrincipal());
    }
  }

  public void restaurarValores() {
    amigosTemplate.getLIdValor().setText(sAmigos.devolverCantidadAmigos() + "");
    amigosTemplate.getTNombre().setText(placeholders[0]);
    amigosTemplate.getTEdad().setText(placeholders[1]);
    amigosTemplate.getTOficio().setText(placeholders[2]);
    amigosTemplate.getTTelefono().setText(placeholders[3]);
    amigosTemplate.getTEmail().setText(placeholders[4]);
    amigosTemplate.getTabla().setSelectionMode(0);
  }

  public void mostrarRegistrosTabla() {
    for (int i = 0; i < sAmigos.devolverCantidadAmigos(); i++) {
      amigo = sAmigos.devolverAmigo(i);
      this.agregarRegistro(amigo);
    }
    amigosTemplate.getLIdValor().setText(sAmigos.devolverCantidadAmigos() + "");
    amigosTemplate.getBMostrar().setEnabled(false);
  }

  public void insertarRegistroTabla() {
    amigo = new Amigo();
    amigo.setId(sAmigos.devolverCantidadAmigos());
    amigo.setNombre(amigosTemplate.getTNombre().getText());
    amigo.setEdad(amigosTemplate.getTEdad().getText());
    amigo.setOficio(amigosTemplate.getTOficio().getText());
    amigo.setTelefono(amigosTemplate.getTTelefono().getText());
    amigo.setEmail(amigosTemplate.getTEmail().getText());
    this.agregarRegistro(amigo);
    sAmigos.agregarAmigo(amigo);
    restaurarValores();
  }

  public void modificarRegistroTabla() {
    int fSeleccionada = amigosTemplate.getTabla().getSelectedRow();
    if (fSeleccionada != -1) {
      amigosTemplate.getModelo()
        .setValueAt(amigosTemplate.getTNombre().getText(), fSeleccionada, 1);
      amigosTemplate.getModelo()
        .setValueAt(amigosTemplate.getTTelefono().getText(), fSeleccionada, 2);
      amigosTemplate.getModelo()
        .setValueAt(amigosTemplate.getTEmail().getText(), fSeleccionada, 3);
      amigo = sAmigos.devolverAmigo(fSeleccionada);
      amigo.setNombre(amigosTemplate.getTNombre().getText());
      amigo.setEdad(amigosTemplate.getTEdad().getText());
      amigo.setOficio(amigosTemplate.getTOficio().getText());
      amigo.setTelefono(amigosTemplate.getTTelefono().getText());
      amigo.setEmail(amigosTemplate.getTEmail().getText());
      restaurarValores();
    } else JOptionPane.showMessageDialog(
      null,
      "seleccione una fila",
      "Error",
      JOptionPane.ERROR_MESSAGE
    );
  }

  public void eliminarRegistroTabla() {
    int fSeleccionada = amigosTemplate.getTabla().getSelectedRow();
    if (fSeleccionada != -1) 
      amigosTemplate.getModelo().removeRow(fSeleccionada); 
    else 
      JOptionPane.showMessageDialog(
        null,
        "seleccione una fila",
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
  }

  public void filtrarRegistrosTabla() {
    TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(
      amigosTemplate.getModelo()
    );
    amigosTemplate.getTabla().setRowSorter(trs);
    trs.setRowFilter(
      RowFilter.regexFilter(amigosTemplate.getTConsulta().getText())
    );
  }

  public void agregarRegistro(Amigo amigo) {
    amigosTemplate
      .getModelo()
      .addRow(
        new Object[] {
          amigo.getId(),
          amigo.getNombre(),
          amigo.getTelefono(),
          amigo.getEmail(),
        }
      );
  }
}