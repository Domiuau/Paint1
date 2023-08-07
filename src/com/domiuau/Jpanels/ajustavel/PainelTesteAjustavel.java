package com.domiuau.Jpanels.ajustavel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PainelTesteAjustavel extends JPanel implements Ajustavel {

    public PainelTesteAjustavel() {
        Random random = new Random();
        this.setBackground(Color.blue);
        this.setLayout(null);
        this.setBounds(random.nextInt(700), random.nextInt(700), 300,300);
        this.setAjuste(this, true, true, true, false, true, true, true, false);
    }
}
