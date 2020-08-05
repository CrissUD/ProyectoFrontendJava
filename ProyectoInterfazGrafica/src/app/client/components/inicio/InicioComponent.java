package app.client.components.inicio;

import app.services.servicesLogic.AccionService;
import models.Accion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

public class InicioComponent implements ActionListener {

    private InicioTemplate inicioTemplate;
    private AccionService sAccion;
    private Timer timer;
    private int direccion, posicionInicial;

    public InicioComponent() {
        sAccion = AccionService.getService();
        timer = new Timer(1, this);
        this.inicioTemplate = new InicioTemplate(this);
    }

    public Accion obtenerAccion(int numeroAccion) {
        return sAccion.devolverAccion(numeroAccion);
    }

    public InicioTemplate getInicioTemplate() {
        return this.inicioTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
            if(e.getSource() == inicioTemplate.getBIzquierda())
                this.direccion = 1;
            if(e.getSource() == inicioTemplate.getBDerecha())
                this.direccion = -1;
            posicionInicial = inicioTemplate.getPTarjetas().getX();
            this.timer.start();
        }
        this.moverTarjetas2();
    }

    public void moverTarjetas1(){
        if(
            inicioTemplate.getPTarjetas().getX() == 0 && direccion == 1 ||
            inicioTemplate.getPTarjetas().getX() == -830 && direccion == -1
        )
            timer.stop();
        else
            inicioTemplate.getPTarjetas().setLocation(
                inicioTemplate.getPTarjetas().getX() + direccion, inicioTemplate.getPTarjetas().getY()
            );
        inicioTemplate.repaint();
    }

    public void moverTarjetas2(){
        if(
            inicioTemplate.getPTarjetas().getX() == 0 && direccion == 1 ||
            inicioTemplate.getPTarjetas().getX() == -830 && direccion == -1
        )
            assert true;
        else{
            if( 
                inicioTemplate.getPTarjetas().getX() == posicionInicial + 200 ||
                inicioTemplate.getPTarjetas().getX() == posicionInicial - 200 
            )
                timer.stop();
            else
                inicioTemplate.getPTarjetas().setLocation(
                    inicioTemplate.getPTarjetas().getX() + direccion, inicioTemplate.getPTarjetas().getY()
                );
        }
        inicioTemplate.repaint();
    }
}