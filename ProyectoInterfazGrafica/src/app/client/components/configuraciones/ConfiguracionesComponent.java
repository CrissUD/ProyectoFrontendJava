package app.client.components.configuraciones;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class ConfiguracionesComponent implements MouseListener, MouseMotionListener, MouseWheelListener {

    private ConfiguracionesTemplate configuracionesTemplate;
    private int posicionInicialX, posicionInicialY;

    public ConfiguracionesComponent() {
        configuracionesTemplate = new ConfiguracionesTemplate(this);
    }

    public ConfiguracionesTemplate getConfiguracionesTemplate() {
        return configuracionesTemplate;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.configuracionesTemplate.getLPOnClickXValor().setText(e.getX()+"");
        this.configuracionesTemplate.getLPOnClickYValor().setText(e.getY()+"");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.configuracionesTemplate.getLPInicialXValor().setText(e.getX()+"");
        this.configuracionesTemplate.getLPInicialYValor().setText(e.getY()+"");
        this.posicionInicialX = e.getX();
        this.posicionInicialY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.configuracionesTemplate.getLPFinalXValor().setText(e.getX()+"");
        this.configuracionesTemplate.getLPFinalYValor().setText(e.getY()+"");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.configuracionesTemplate.getLEstadoValor().setText("ADENTRO");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.configuracionesTemplate.getLEstadoValor().setText("AFUERA");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.configuracionesTemplate.getLLadoXValor().setText(Math.abs((e.getX() - posicionInicialX)) + "");
        this.configuracionesTemplate.getLLadoYValor().setText(Math.abs((e.getY() - posicionInicialY)) + "");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.configuracionesTemplate.getLPActualXValor().setText(e.getX()+"");
        this.configuracionesTemplate.getLPActualYValor().setText(e.getY()+"");
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int valorZoomActual = Integer.parseInt(this.configuracionesTemplate.getLZoomValor().getText());
        if(e.getWheelRotation() == -1)
            this.configuracionesTemplate.getLZoomValor().setText(valorZoomActual + 1 + "");
        if(
            e.getWheelRotation() == 1 &&
            Integer.parseInt(this.configuracionesTemplate.getLZoomValor().getText()) > 0
        )
            this.configuracionesTemplate.getLZoomValor().setText(valorZoomActual - 1 + "");
    }
}