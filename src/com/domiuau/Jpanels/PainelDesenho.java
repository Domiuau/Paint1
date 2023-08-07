package com.domiuau.Jpanels;

import com.domiuau.Jpanels.ajustavel.Ajustavel;
import com.domiuau.Jpanels.cores.BotaoCor;
import com.domiuau.Jpanels.stroke.PainelStroke;
import com.domiuau.Jpanels.stroke.PainelStrokeAjuste;
import com.domiuau.desenhos.Desenhavel;
import com.domiuau.formas.Quadrado;
import com.domiuau.threads.AnimacaoFoco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PainelDesenho extends JLayeredPane implements Ajustavel, MouseMotionListener, MouseListener {

    public static PainelDesenho painelDesenhoFoco;
    int x1,y1;



    private Desenhavel desenhavel;
    private Rectangle rectangle;
    private Thread animacao;
    private AnimacaoFoco animacaoFoco;
    private Graphics g;
    public Desenhavel getDesenhavel() {
        return this.desenhavel;
    }
    private boolean animar = true;

    public void setDesenhavel(Desenhavel desenhavel) {
        this.desenhavel = desenhavel;
    }



    public PainelDesenho(Rectangle rectangle, Desenhavel desenhavel) {
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.setBackground(new Color(0,0,0,0));
        this.setBounds(rectangle);
        this.desenhavel = desenhavel;
        this.setVisible(true);
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                PainelStrokeAjuste.getjSlider().setValue((int) desenhavel.getStroke().getLineWidth());
                animar = true;
                animar();
            }

            @Override
            public void focusLost(FocusEvent e) {

                animar = false;
                animacao.interrupt();
                repaint();

            }
        });
        repaint();
        this.rectangle = rectangle;
        this.setAjuste(this, true, true, true, true, true, true, true, true);

        painelDesenhoFoco = this;
        repaint();


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        this.g = g;
        // g.drawRect(0,0,((Quadrado) desenhavel1).width(),((Quadrado) desenhavel1).height());


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = g;

        ((Quadrado) desenhavel).setX(3 + ((int) desenhavel.getStroke().getLineWidth()/2));
        ((Quadrado) desenhavel).setY(3 + ((int) desenhavel.getStroke().getLineWidth()/2));
        ((Quadrado) desenhavel).setWidth((this.getWidth() - 6) - ((int) desenhavel.getStroke().getLineWidth()));
        ((Quadrado) desenhavel).setHeight((this.getHeight() - 6) - ((int) desenhavel.getStroke().getLineWidth()));
        PainelFolha.desenhoPaints.get(desenhavel.getTipo()).desenharFormaPaint(g,desenhavel);



       // ((Graphics2D) g).setStroke(new BasicStroke(1));
      //  g.setColor(Color.BLACK);
    //    g.drawRect(3,3, this.getWidth()-7, this.getHeight()-7);
//        g.setColor(Color.WHITE);
//        g.drawRect(1,1, this.getWidth()-2, this.getHeight()-2);





//        for (int j = 3; true; j = this.getHeight()-4) {
//
//            for (int i = 3; i < this.getWidth()-4; i += 5) {
//                g.setColor(Color.BLACK);
//                g.drawLine(i, j, i+4, j);
//                i+=5;
//                g.setColor(Color.WHITE);
//                g.drawLine(i, j, i+4, j);
//
//            }
//
//            if (j == this.getHeight()-4)
//                break;
//        }
//
//        for (int j = 3; true; j = this.getWidth()-4) {
//
//            for (int i = 3; i < this.getHeight()-4; i += 5) {
//
//                g.setColor(Color.BLACK);
//                g.drawLine(j, i, j, i+4);
//                i+=5;
//                g.setColor(Color.WHITE);
//                g.drawLine(j, i, j, i+4);
//
//            }
//
//            if (j == this.getWidth()-4)
//                break;
//
//        }



            animar();






    }

    @Override
    public void mouseDragged(MouseEvent e) {




                this.setLocation(PainelPrincipal.getPainelFolha().getLocalPonteiro().x - x1, PainelPrincipal.getPainelFolha().getLocalPonteiro().y - y1);


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getClickCount() == 2){
            desenhavel.setX(this.getX() + 3 + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2));
            desenhavel.setY(this.getY() + 3 + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2));
            PainelPrincipal.getPainelFolha().getFormasProntas().add(desenhavel);
            PainelPrincipal.getPainelFolha().remove(this);
            PainelPrincipal.getPainelFolha().repaint();

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

        this.animar = false;
        painelDesenhoFoco = this;
        this.requestFocus();


            animacao.interrupt();



        x1 = e.getX();
        y1 = e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        desenhavel.setX(this.getX());
        desenhavel.setY(this.getY());
        animar = true;
        animar();


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void animar(){

        if (animacao != null) {
            animacao.interrupt();
        }

        if (animar) {
            animacao = new Thread(new AnimacaoFoco(this.getGraphics(),this));
            animacao.start();
        }



    }

    public PainelDesenho getPainelDesenho(){
        return this;
    }



}
