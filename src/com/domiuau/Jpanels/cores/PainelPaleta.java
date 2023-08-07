package com.domiuau.Jpanels.cores;

import com.domiuau.Jpanels.PainelDesenho;
import com.domiuau.Jpanels.opcoes.PainelOpcoes;
import com.domiuau.desenhos.CorVariavel;
import com.domiuau.formas.Quadrado;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PainelPaleta extends JPanel {

    ArrayList<JButton> botoesCores = new ArrayList<>();
    Random random = new Random();

    public PainelPaleta() {

        this.setPreferredSize(new Dimension(305,90));
        this.setBackground(PainelOpcoes.corPadrao);
        this.setLayout(new FlowLayout(FlowLayout.LEADING));

        for (int i = 0; i < 36; i++) {

            botoesCores.add(new BotaoCor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256))));
            this.add(botoesCores.get(i));

        }
    }


}
