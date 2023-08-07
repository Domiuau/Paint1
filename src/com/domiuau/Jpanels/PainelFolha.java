package com.domiuau.Jpanels;

import com.domiuau.Jpanels.ajustavel.Ajustavel;
import com.domiuau.Jpanels.ajustavel.PainelTesteAjustavel;
import com.domiuau.Jpanels.cores.PainelCores;
import com.domiuau.Jpanels.stroke.PainelStroke;
import com.domiuau.Jpanels.stroke.PainelStrokeAjuste;
import com.domiuau.desenhos.*;
import com.domiuau.formas.LinhaCompleta;
import com.domiuau.formas.Linhas;
import com.domiuau.formas.Quadrado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PainelFolha extends JPanel implements MouseListener, MouseMotionListener, KeyListener, Ajustavel, FocusListener {


    private LinhaCompleta linhaCompleta = new LinhaCompleta(new ArrayList<>(), 0, PainelCores.cor1.getCor(), PainelStroke.strokeSelecionada);

    public static ArrayList<DesenhoPaint> desenhoPaints = new ArrayList<>();

    private ArrayList<PainelDesenho> painelDesenhos = new ArrayList<>();
    public static BasicStroke basicStroke = new BasicStroke(2);
    public static boolean editStroke = true;

    private int xAntigo, yAntigo, xAtual, yAtual, xAntigoForma, yAntigoForma;


    private Quadrado quadrado = new Quadrado();
    private boolean formaValida = false;






    //ArrayList<LinhaCompleta> linhasCompletas = new ArrayList<>();
    private ArrayList<Desenhavel> formasProntas = new ArrayList<>();


    int forma = 0;

    PainelFolha() {
        this.setBounds(0,150, 1000,700);
       // this.setPreferredSize(new Dimension(1920,1080));
        this.setBackground(Color.white);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.addFocusListener(this);
        this.setLayout(null);
        this.setAjuste(this,false,false,false,true ,true ,true,false,false);









        desenhoPaints.add(new DesenhoPaint() {
            @Override
            public void desenharFormaPaint(Graphics graphics, Desenhavel forma) {

                graphics.setColor(((LinhaCompleta) forma).getCor());

                for (Linhas linha:
                        ((LinhaCompleta) forma).getLinhaCompleta()) {
                    ((Graphics2D) graphics).setStroke(forma.getStroke());
                    ((Graphics2D) graphics).drawLine(linha.xAntigo(), linha.yAntigo(), linha.xAtual(), linha.yAtual());

                }
            }
        });

        desenhoPaints.add(new DesenhoPaint() {
            @Override
            public void desenharFormaPaint(Graphics graphics, Desenhavel forma) {

                ((Graphics2D) graphics).setColor(((Quadrado) forma).getColor());
                ((Graphics2D) graphics).setStroke(forma.getStroke());
                ((Graphics2D) graphics).drawRect(((Quadrado) forma).getX(),((Quadrado) forma).getY(),((Quadrado) forma).getWidth(),((Quadrado) forma).getHeight());

            }
        });

        desenhoPaints.add(new DesenhoPaint() {
            @Override
            public void desenharFormaPaint(Graphics graphics, Desenhavel forma) {

                ((Graphics2D) graphics).setStroke(forma.getStroke());
                ((Graphics2D) graphics).setColor(((Quadrado) forma).getColor());
                ((Graphics2D) graphics).drawOval(((Quadrado) forma).getX(),((Quadrado) forma).getY(),((Quadrado) forma).getWidth(),((Quadrado) forma).getHeight());
            }
        });


    }


    @Override
    public void mouseClicked(MouseEvent e) {

        this.requestFocus();
    }

    @Override
    public void mousePressed(MouseEvent e) {

        this.requestFocus();
        PainelDesenho.painelDesenhoFoco = null;


        xAtual = e.getX();
        yAtual = e.getY();

        xAntigoForma = forma == 0? 0 : e.getX();
        yAntigoForma = forma == 0? 0 : e.getY();





        linhaCompleta = new LinhaCompleta(new ArrayList<>(), 0, PainelCores.cor1.getCor(), PainelStroke.strokeSelecionada);
        if (forma == 0) {
            formasProntas.add(linhaCompleta);

        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {

        //if (forma != 0 && (xAtual - xAntigoForma > 2 &&  xAtual - xAntigoForma > 2)) {

//            PainelDesenho painelDesenho = new PainelDesenho(new Rectangle(xAntigoForma, yAntigoForma,(xAtual - xAntigoForma)+1, (yAtual - yAntigoForma)+1),
//                    new Quadrado(0,0,xAtual-xAntigoForma,yAtual-yAntigoForma, forma,PainelCores.cor1.getCor()) );



          //  PainelDesenho painelDesenho = new PainelDesenho(new Rectangle(xAntigoForma, yAntigoForma,((xAtual-xAntigoForma)+7) + ((int) PainelStroke.strokeSelecionada.getLineWidth()), ((yAtual - yAntigoForma)+7) + ((int) PainelStroke.strokeSelecionada.getLineWidth())),
             //       new Quadrado(3,3,(xAtual-xAntigoForma) + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2),(yAtual-yAntigoForma) + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2), forma,PainelCores.cor1.getCor(),PainelStroke.strokeSelecionada) );

        if (formaValida && forma != 0) {

            Rectangle rectangle = new Rectangle(((quadrado.getX()-3) - ((int) PainelStroke.strokeSelecionada.getLineWidth()/2)),
                    ((quadrado.getY()-3) - ((int) PainelStroke.strokeSelecionada.getLineWidth()/2)),
                    ((quadrado.getWidth())+6) + ((int) PainelStroke.strokeSelecionada.getLineWidth()),
                    ((quadrado.getHeight())+6) + ((int) PainelStroke.strokeSelecionada.getLineWidth()));
            quadrado.setX(3 + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2));
            quadrado.setY(quadrado.getX());
            PainelDesenho painelDesenho = new PainelDesenho(rectangle, quadrado);
            quadrado = null;


            this.add(painelDesenho, JLayeredPane.DRAG_LAYER);
            painelDesenho.requestFocus();
            xAntigoForma = 0;
            yAntigoForma = 0;
            xAtual = 0;
            yAtual = 0;
            repaint();
            formaValida = false;
        }
        //formasProntas.add(new Quadrado(xAntigoForma,yAntigoForma,xAtual-xAntigoForma,yAtual-yAntigoForma, 1));
    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void mouseDragged(MouseEvent e) {

        xAntigo = xAtual;
        yAntigo = yAtual;

        xAtual = e.getX();
        yAtual = e.getY();

        quadrado = new Quadrado((xAntigoForma+3) + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2),
                (yAntigoForma+3) + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2),
                1,
                1,
                forma,
                PainelCores.cor1.getCor(),
                PainelStroke.strokeSelecionada);

        if (xAtual - xAntigoForma > 3 && yAtual - yAntigoForma > 3) {

            quadrado.setX((xAntigoForma+3) + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2));
            quadrado.setY((yAntigoForma+3) + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2));
            quadrado.setWidth((xAtual-xAntigoForma) - (int) PainelStroke.strokeSelecionada.getLineWidth());
            quadrado.setHeight((yAtual-yAntigoForma) - (int) PainelStroke.strokeSelecionada.getLineWidth());
            formaValida = true;

        } else if (xAtual - xAntigoForma < 3 && yAtual - yAntigoForma < 3) {

            int xAntigoDesenho = quadrado.getX();
            int yAntigoDesenho = quadrado.getY();

            quadrado.setX((xAtual+3) + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2));
            quadrado.setY((yAtual+3) + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2));
            quadrado.setWidth(((xAntigoDesenho - quadrado.getX()) + quadrado.getWidth()) - (int) PainelStroke.strokeSelecionada.getLineWidth());
            quadrado.setHeight(((yAntigoDesenho - quadrado.getY()) + quadrado.getHeight()) - (int) PainelStroke.strokeSelecionada.getLineWidth());
            formaValida = true;

        } else if (xAtual - xAntigoForma > 3 && yAtual - yAntigoForma < 3) {

            int yAntigoDesenho = quadrado.getY();

            quadrado.setX((xAntigoForma+3) + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2));
            quadrado.setY((yAtual+3) + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2));
            quadrado.setWidth((xAtual-xAntigoForma) - (int) PainelStroke.strokeSelecionada.getLineWidth());
            quadrado.setHeight(((yAntigoDesenho - quadrado.getY()) + quadrado.getHeight()) - (int) PainelStroke.strokeSelecionada.getLineWidth());
            formaValida = true;

        } else if (xAtual - xAntigoForma < 3 && yAtual - yAntigoForma > 3) {

            int xAntigoDesenho = quadrado.getX();

            quadrado.setX((xAtual+3) + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2));
            quadrado.setY((yAntigoForma+3) + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2));
            quadrado.setWidth(((xAntigoDesenho - quadrado.getX()) + quadrado.getWidth()) - (int) PainelStroke.strokeSelecionada.getLineWidth());
            quadrado.setHeight((yAtual-yAntigoForma) - (int) PainelStroke.strokeSelecionada.getLineWidth());
            formaValida = true;

        }







         linhaCompleta.getLinhaCompleta().add(new Linhas(xAntigo, yAntigo, xAtual, yAtual));





        // formasProntas.add(new Linhas(xAntigo, yAntigo, xAtual, yAtual));

       // geral.get(forma).add(new Linhas(xAntigo, yAntigo, xAtual, yAtual));


        repaint();

    }


    @Override
    public void mouseMoved(MouseEvent e) {

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (var formaCompleta :
                formasProntas) {

            desenhoPaints.get(formaCompleta.getTipo()).desenharFormaPaint(g,formaCompleta);

        }

        if (forma != 0 && quadrado != null)
            desenhoPaints.get(forma).desenharFormaPaint(g,quadrado);

//            desenhoPaints.get(forma).desenharFormaPaint(g,new Quadrado(
//                    (xAntigoForma+3) + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2),
//                    (yAntigoForma+3) + ((int) PainelStroke.strokeSelecionada.getLineWidth()/2),
//                    (xAtual-xAntigoForma) - (int) PainelStroke.strokeSelecionada.getLineWidth(),
//                    (yAtual-yAntigoForma) - (int) PainelStroke.strokeSelecionada.getLineWidth(),
//                    1,
//                    PainelCores.cor1.getCor(),
//                    PainelStroke.strokeSelecionada));



    }







    @Override
    public void paint(Graphics g) {
        super.paint(g);




    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {

        if ((e.getKeyChar()+"").equals("z")){
            formasProntas.remove(formasProntas.size() - 1);
            repaint();
        }

        if ((e.getKeyChar()+"").equals("1"))
            forma = 1;
        if ((e.getKeyChar()+"").equals("0"))
            forma = 0;
        if ((e.getKeyChar()+"").equals("2"))
            forma = 2;
        if ((e.getKeyChar()+"").equals("m")){

            this.add(new PainelTesteAjustavel());
            repaint();
            revalidate();

        }




    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public LinhaCompleta getLinhaCompleta() {
        return linhaCompleta;
    }

    public void setLinhaCompleta(LinhaCompleta linhaCompleta) {
        this.linhaCompleta = linhaCompleta;
    }

    public Point getLocalPonteiro(){
        return getMousePosition();
    }

    public int getxAntigoForma() {
        return xAntigoForma;
    }

    public void setxAntigoForma(int xAntigoForma) {
        this.xAntigoForma = xAntigoForma;
    }

    public int getyAntigoForma() {
        return yAntigoForma;
    }

    public void setyAntigoForma(int yAntigoForma) {
        this.yAntigoForma = yAntigoForma;
    }

    public ArrayList<Desenhavel> getFormasProntas() {
        return formasProntas;
    }

    public void setFormasProntas(ArrayList<Desenhavel> formasProntas) {
        this.formasProntas = formasProntas;
    }

    @Override
    public void focusGained(FocusEvent e) {
      editStroke = true;
      PainelDesenho.painelDesenhoFoco = null;
      PainelStrokeAjuste.getjSlider().setValue((int) basicStroke.getLineWidth());
        System.out.println("a");
    }

    @Override
    public void focusLost(FocusEvent e) {
        editStroke = false;
        quadrado = null;
        System.out.println("b");
    }
}
