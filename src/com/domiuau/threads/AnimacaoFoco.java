package com.domiuau.threads;

import com.domiuau.Jpanels.PainelDesenho;

import javax.swing.*;
import java.awt.*;

public class AnimacaoFoco implements Runnable {

    private Graphics g;
    private JComponent jComponent;


    public AnimacaoFoco(Graphics g, JComponent jComponent) {
        this.g = g;
        this.jComponent = jComponent;
    }

    public AnimacaoFoco() {

    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public JComponent getjComponent() {
        return jComponent;
    }

    public void setjComponent(JComponent jComponent) {
        this.jComponent = jComponent;
    }

    @Override
    public void run() {


            Color cor1 = Color.BLACK;
            Color cor2 = Color.WHITE;


            while (!Thread.currentThread().isInterrupted()){
                //while (true){

                this.jComponent = ((PainelDesenho) jComponent).getPainelDesenho();

                for (int j = 3; true; j = jComponent.getHeight()-4) {

                    for (int i = 3; i < jComponent.getWidth()-4; i += 5) {



                        g.setColor(cor1);
                        g.drawLine(i, j, i+4, j);
                        i+=5;
                        g.setColor(cor2);
                        g.drawLine(i, j, i+4, j);

                    }

                    if (j == jComponent.getHeight()-4)
                        break;
                }

                for (int j = 3; true; j = jComponent.getWidth()-4) {

                    for (int i = 3; i < jComponent.getHeight()-4; i += 5) {

                        g.setColor(cor1);
                        g.drawLine(j, i, j, i+4);
                        i+=5;
                        g.setColor(cor2);
                        g.drawLine(j, i, j, i+4);

                    }

                    if (j == jComponent.getWidth()-4)
                        break;

                }

                Color cor = cor1;
                cor1 = cor2;
                cor2 = cor;

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    break;

                }



        }





    }


}
