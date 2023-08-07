package com.domiuau.Jpanels.stroke;

import com.domiuau.Jpanels.PainelDesenho;
import com.domiuau.Jpanels.PainelFolha;
import com.domiuau.desenhos.Desenhavel;
import com.domiuau.formas.Quadrado;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PainelStrokeAjuste extends JPanel {

    private static JSlider jSlider;

    public PainelStrokeAjuste() {
        this.setPreferredSize(new Dimension(200,30));
        jSlider = new JSlider(1,50);
        jSlider.setFocusable(false);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                PainelStroke.strokeSelecionada = new BasicStroke(jSlider.getValue());
                ((PainelStroke) getParent()).demonstrar();

                if (PainelDesenho.painelDesenhoFoco != null){
                    Quadrado quadrado = (Quadrado) PainelDesenho.painelDesenhoFoco.getDesenhavel();
                    PainelDesenho.painelDesenhoFoco.setDesenhavel(new Quadrado(
                            quadrado.getX(), quadrado.getY(), quadrado.getWidth(), quadrado.getHeight(), quadrado.getTipo(), quadrado.getCor(),new BasicStroke(jSlider.getValue())));
                    PainelDesenho.painelDesenhoFoco.repaint();
                } else {
                    PainelFolha.basicStroke = PainelStroke.strokeSelecionada;
                }





            }
        });
        jSlider.setPreferredSize(new Dimension(190,30));

        this.add(jSlider);

    }

    public static JSlider getjSlider(){
        return jSlider;
    }


}
