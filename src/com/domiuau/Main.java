package com.domiuau;

import com.domiuau.Jpanels.PainelFolha;
import com.domiuau.Jpanels.PainelPrincipal;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {



    public static void main(String[] args) {

        Main main = new Main();
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
        main.setExtendedState(JFrame.MAXIMIZED_BOTH);
        main.setSize(new Dimension(1300,150));
        main.setVisible(true);
        main.setLocationRelativeTo(null);
        main.setLayout(new BorderLayout());


        main.add(new PainelPrincipal());




    }


}
