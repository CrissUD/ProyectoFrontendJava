package app.client.components.lienzo;

import javax.swing.JPanel;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class LienzoComponent implements MouseListener, MouseMotionListener{
    
    private LienzoTemplate lienzoTemplate;
    private int posicionInicialX, posicionInicialY;

    public LienzoComponent(JPanel pPadre){
        lienzoTemplate = new LienzoTemplate(this, pPadre);
    }

    public LienzoTemplate getLienzoTemplate(){
        return lienzoTemplate;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        this.posicionInicialX = e.getX();
        this.posicionInicialY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        this.lienzoTemplate.pintarRectanguloTiempoReal(posicionInicialX, posicionInicialY, e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}