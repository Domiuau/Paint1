package com.domiuau.Jpanels.opcoes;

import com.domiuau.Jpanels.cores.PainelCores;
import com.domiuau.Jpanels.stroke.PainelStroke;

import javax.swing.*;
import java.awt.*;

public class PainelOpcoesBaixo extends JPanel {

    public PainelOpcoesBaixo() {
        this.setBackground(PainelOpcoes.corPadrao);
        this.setLayout(new FlowLayout(FlowLayout.LEADING, 100,0));
        this.add(new PainelStroke());
        this.add(new PainelCores());
    }
}
