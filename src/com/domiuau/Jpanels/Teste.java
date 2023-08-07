package com.domiuau.Jpanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class Teste extends JPanel {

    boolean a = true;
    Random random = new Random();

    public Teste() {
        // Adiciona um ouvinte de mouse para capturar os cliques do mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Redesenha o JPanel

                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Desenha as linhas diretamente no Graphics2D
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;


            g2d.setColor(Color.BLACK);
            g2d.drawLine(centerX, centerY, 0, 0);
            g2d.drawLine(centerX, centerY, width, 0);
            g2d.drawLine(centerX, centerY, 0, height);
            g2d.drawLine(centerX, centerY, width, height);



            int tamanhoX = this.getSize().width;
            int tamanhoY = this.getSize().height;

        for (int i = 0; i < 100; i++) {
            g2d.setPaint(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            g2d.drawLine(random.nextInt(tamanhoX),random.nextInt(tamanhoY),random.nextInt(tamanhoX),random.nextInt(tamanhoY));
        }





    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Desenhar Linhas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Teste());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
