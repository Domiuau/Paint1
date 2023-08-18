package com.domiuau.Jpanels;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PainelTesteImagem extends JFrame {

    BufferedImage bufferedImage;

    PainelTesteImagem(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        this.setPreferredSize(new Dimension(1000,700));
        this.setVisible(true);


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(this.bufferedImage,0,0,null);

    }
}
