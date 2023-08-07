package com.domiuau.Jpanels.cores;

import com.domiuau.Jpanels.ajustavel.Ajustavel;
import com.domiuau.Jpanels.opcoes.PainelOpcoes;

import javax.swing.*;
import java.awt.*;

public class PainelCores extends JPanel {

    public static PainelCoresPrincipais cor1, cor2;

    public PainelCores() {

        this.setPreferredSize(new Dimension(500, 100));
        this.setBackground(PainelOpcoes.corPadrao);
        this.setLayout(new FlowLayout(FlowLayout.LEADING));

        cor1 = new PainelCoresPrincipais(new Color(175, 10, 10), 1, true);
        cor2 = new PainelCoresPrincipais(new Color(32, 117, 199), 2, false);


        this.add(cor1);
        this.add(cor2);
        this.add(new PainelPaleta());


    }

    static void resetSelecionado(){
        cor1.setSelecionado(false);
        cor2.setSelecionado(false);
        cor1.setBackground(PainelOpcoes.corPadrao);
        cor2.setBackground(PainelOpcoes.corPadrao);
        cor1.setBorder(null);
        cor2.setBorder(null);
    }

    static void alterarCor(Color color){
        if (cor1.isSelecionado()){
            cor1.setCor(color);

        } else {
            cor2.setCor(color);
        }

    }



}
