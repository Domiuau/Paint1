package com.domiuau.Jpanels.cores;

import com.domiuau.Jpanels.PainelDesenho;
import com.domiuau.Jpanels.stroke.PainelStroke;
import com.domiuau.formas.Quadrado;

import javax.swing.*;
import javax.swing.colorchooser.ColorChooserComponentFactory;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotaoCor extends JButton implements MouseListener {

    public static Color corAtual;
    public BotaoCor(Color color) {

        this.setFocusPainted(false);
        this.setPreferredSize(new Dimension(20,20));
        this.setBackground(color);
        this.setFocusable(false);
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        g.drawRect(1, 1, this.getWidth()-3, this.getHeight()-3);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        PainelCores.alterarCor(this.getBackground());



        if (PainelDesenho.painelDesenhoFoco != null){
            ((Quadrado) PainelDesenho.painelDesenhoFoco.getDesenhavel()).setColor(this.getBackground());
            PainelDesenho.painelDesenhoFoco.repaint();
        }



        if (e.getClickCount() == 2){
            this.setBackground(JColorChooser.showDialog(this,"Selecionar cor", Color.white));
        }

       // corAtual = this.getBackground();


    }


    @Override
    public void mousePressed(MouseEvent e) {

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
