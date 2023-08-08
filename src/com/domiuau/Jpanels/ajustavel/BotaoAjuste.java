package com.domiuau.Jpanels.ajustavel;

import com.domiuau.Jpanels.PainelDesenho;
import com.domiuau.Jpanels.PainelPrincipal;
import com.domiuau.desenhos.DesenhoPaint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Locale;

public class BotaoAjuste extends JButton implements MouseMotionListener, MouseListener {

    private DirecaoAjuste direcaoAjuste;
    private Teste desenhoPaint;
    private JComponent jComponent;


    BotaoAjuste(Point point, JComponent jComponent, DirecaoAjuste direcaoAjuste){
        this.setBackground(Color.WHITE);
        this.jComponent = jComponent;
        this.setPreferredSize(new Dimension(7,7));
        this.setBounds(point.x,point.y,7,7);
        this.direcaoAjuste = direcaoAjuste;
        this.setFocusable(false);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.repaint();

    }

    public DirecaoAjuste getDirecaoAjuste() {
        return direcaoAjuste;
    }

    public void setDirecaoAjuste(DirecaoAjuste direcaoAjuste) {
        this.direcaoAjuste = direcaoAjuste;
    }

    @Override
    public void mouseDragged(MouseEvent e) {


        this.direcaoAjuste.direcao(jComponent.getParent().getMousePosition(),this);
        try {
            PainelDesenho.painelDesenhoFoco = (PainelDesenho) jComponent;

        } catch (Exception exception){

        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        jComponent.requestFocus();
    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
