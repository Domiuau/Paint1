package com.domiuau.Jpanels.opcoes;

import com.domiuau.Jpanels.cores.PainelCores;
import com.domiuau.Jpanels.stroke.PainelStroke;

import javax.swing.*;
import java.awt.*;

public class PainelOpcoes extends JPanel {

    public static Color corPadrao = new Color(243, 243, 243);

    public PainelOpcoes() {

        this.setLayout(new BorderLayout());

        this.setBackground(PainelOpcoes.corPadrao);
        this.setBounds(0,0,1920,140);
        PainelOpcoesCima painelOpcoesCima = new PainelOpcoesCima();
        painelOpcoesCima.setPreferredSize(new Dimension(this.getWidth(), 30));
        painelOpcoesCima.setBackground(Color.white);
        this.add(painelOpcoesCima, BorderLayout.NORTH);
        this.add(new PainelOpcoesBaixo(), BorderLayout.CENTER);
       // this.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),160));

        this.setBorder(BorderFactory.createLineBorder(new Color(152, 152, 152)));

    }


}
