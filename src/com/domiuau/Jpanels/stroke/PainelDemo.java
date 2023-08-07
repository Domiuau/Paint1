package com.domiuau.Jpanels.stroke;

import javax.swing.*;
import java.awt.*;

public class PainelDemo extends JPanel {

    public PainelDemo() {
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(200,50));

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        ((Graphics2D) g).setStroke(PainelStroke.strokeSelecionada);
        g.drawLine(1,(this.getHeight()/2)-1, getWidth()-1, (this.getHeight()/2)-1);
    }

    private JPanel getPainelDemo(){
        return this;
    }
}
