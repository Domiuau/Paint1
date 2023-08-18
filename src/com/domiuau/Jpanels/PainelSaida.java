package com.domiuau.Jpanels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class PainelSaida extends JLayeredPane implements MouseMotionListener, MouseListener {

    int areaWidth = 400;
    int areaHeight = 300;
    JComponent jComponent;

    PainelSaida(JComponent jComponent) {
        this.setBackground(new Color(0, 0, 0, 0));
        this.setBounds(0, 0, jComponent.getWidth(), jComponent.getHeight());
        this.jComponent = jComponent;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {

            int mouseX = this.getMousePosition().x;
            int mouseY = this.getMousePosition().y;

            g.setColor(new Color(0, 0, 0, 90));
            g.fillRect(0, 0, jComponent.getWidth(), mouseY - (areaHeight/2));
            g.fillRect(mouseX - (areaWidth/2), 0, areaWidth , mouseY - (areaHeight/2));


            g.fillRect(0, 0, mouseX - (areaWidth/2), jComponent.getHeight());
            g.fillRect(0, mouseY - (areaHeight/2), mouseX - (areaWidth/2), areaHeight);

            g.fillRect(mouseX + (areaWidth/2), 0, jComponent.getWidth() - (mouseX + (areaWidth/2)), jComponent.getHeight());

            g.fillRect(mouseX + (areaWidth/2), mouseY - (areaHeight/2),
                    jComponent.getWidth() - (mouseX + (areaWidth/2)),
                    areaHeight);

            g.fillRect(0, mouseY + (areaHeight/2), jComponent.getWidth(), jComponent.getHeight() - (mouseY + (areaHeight/2)));

            g.fillRect(mouseX - (areaWidth/2), mouseY + (areaHeight/2),
                    areaWidth,
                    jComponent.getHeight() - (mouseY + (areaHeight/2)));

        } catch (Exception e) {

        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        repaint();


    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        Robot robot = null;


            try {
                robot = new Robot();
            } catch (Exception exception) {

            }
            BufferedImage screen = robot.createScreenCapture(new Rectangle(this.getLocationOnScreen().x + (this.getMousePosition().x - (areaWidth/2)),
                    this.getLocationOnScreen().y + (this.getMousePosition().y - (areaHeight/2)), areaWidth, areaHeight));

            // PainelTesteImagem painelTesteImagem = new PainelTesteImagem(screen);


            try {
                ImageIO.write(screen, "png", new File("src/imagensSaidaTeste/NomeRandomTeste " + (new Random()).nextInt() + ".png"));
            } catch (Exception exception) {
                System.out.println("fdsdfsfdsfh");
            }

            jComponent.remove(this);
            jComponent.repaint();




    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
