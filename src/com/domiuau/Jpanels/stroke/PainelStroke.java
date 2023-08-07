package com.domiuau.Jpanels.stroke;

import javax.swing.*;
import java.awt.*;

public class PainelStroke extends JPanel {

    private PainelDemo painelDemo;

    public static BasicStroke strokeSelecionada = new BasicStroke(3);

    public PainelStroke() {
        this.setPreferredSize(new Dimension(200, 100));
        this.setBackground(new Color(243, 243, 243));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        painelDemo = new PainelDemo();;
        this.add(painelDemo);
        this.add(new PainelStrokeAjuste());
    }

    void demonstrar(){
        painelDemo.repaint();
    }
}
