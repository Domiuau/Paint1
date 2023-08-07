package com.domiuau.Jpanels;

import com.domiuau.Jpanels.opcoes.PainelOpcoes;

import javax.swing.*;
import java.awt.*;

public class PainelPrincipal extends JPanel {

    private static PainelFolha painelFolha;
    public PainelPrincipal() {

        this.setBackground(new Color(213, 243, 235));
        this.setLayout(null);





        this.add(new PainelOpcoes());
        painelFolha = new PainelFolha();
        this.add(painelFolha, BorderLayout.CENTER);
        this.revalidate();


    }

    public static PainelFolha getPainelFolha() {
        return painelFolha;
    }



    public static void setPainelFolha(PainelFolha painelFolha) {
        PainelPrincipal.painelFolha = painelFolha;
    }
}
