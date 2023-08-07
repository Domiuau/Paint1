package com.domiuau.Jpanels.cores;

import com.domiuau.Jpanels.opcoes.PainelOpcoes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PainelCoresPrincipais extends JButton implements MouseListener {

    private boolean selecionado;
    private JPanel painelCor = new JPanel();


    PainelCoresPrincipais(Color color, int numeroCor, boolean selecionado) {
        this.setPreferredSize(new Dimension(50, 95));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(PainelOpcoes.corPadrao);
        this.setOpaque(false);
        this.selecionado = selecionado;
        this.addMouseListener(this);
        this.setBorder(null);

        painelCor.setBackground(color);
        painelCor.setPreferredSize(new Dimension(44, 44));
        this.add(painelCor);
        this.add(new JLabel("   Cor   "));
        this.add(new JLabel(numeroCor + ""));

        if (selecionado) {
            this.setBackground(new Color(41, 185, 229, 218));
            this.setBorder(BorderFactory.createLineBorder(new Color(33, 84, 194, 169)));
        }
    }

    private void selecionar(){

        PainelCores.resetSelecionado();

        this.setBackground(new Color(41, 185, 229, 218));
        this.setBorder(BorderFactory.createLineBorder(new Color(33, 84, 194, 169)));
        this.setSelecionado(true);


    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public Color getCor() {
        return painelCor.getBackground();
    }

    public void setCor(Color color) {
        painelCor.setBackground(color);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {


        selecionar();

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
