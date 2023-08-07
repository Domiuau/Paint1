package com.domiuau.Jpanels.ajustavel;

import com.domiuau.Jpanels.PainelDesenho;
import com.domiuau.Jpanels.PainelPrincipal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public interface Ajustavel {



    default void setAjuste(JComponent jComponent, boolean noroeste, boolean norte, boolean nordeste, boolean este, boolean sueste, boolean sul, boolean sudoeste, boolean oeste){

        ArrayList<BotaoAjuste> botoes = new ArrayList<>();
        System.out.println(jComponent.getParent());

        if (noroeste)
        botoes.add(new BotaoAjuste(new Point(0, 0), jComponent, new DirecaoAjuste() {
            @Override
            public void direcao(Point point, BotaoAjuste botaoAjuste) {



                int xAnterior = jComponent.getX();

                int yAnterior = jComponent.getY();

                jComponent.setLocation(new Point(
                        point.x,
                        point.y));

                jComponent.setBounds(jComponent.getX(), jComponent.getY(), (xAnterior - jComponent.getX()) + jComponent.getWidth(), (yAnterior - jComponent.getY()) + jComponent.getHeight());


                ajustarPosicoes(botoes);


            }

            @Override
            public void ajustePosicao(BotaoAjuste botaoAjuste) {

                botaoAjuste.setLocation(new Point(0, 0));
            }
        }));

        if (norte)
        botoes.add(new BotaoAjuste(new Point( (jComponent.getWidth()/2)-3, 0), jComponent, new DirecaoAjuste() {
            @Override
            public void direcao(Point point, BotaoAjuste botaoAjuste) {

                int yAnterior = jComponent.getY();

                jComponent.setLocation(new Point(
                        jComponent.getX(),
                        point.y));

                jComponent.setBounds(jComponent.getX(), jComponent.getY(), jComponent.getWidth(), (yAnterior - jComponent.getY()) + jComponent.getHeight());
                ajustarPosicoes(botoes);


            }

            @Override
            public void ajustePosicao(BotaoAjuste botaoAjuste) {

                botaoAjuste.setLocation(new Point( (jComponent.getWidth()/2)-3, 0));
            }
        }));

        if (nordeste)
        botoes.add(new BotaoAjuste(new Point( jComponent.getWidth()-7, 0), jComponent, new DirecaoAjuste() {
            @Override
            public void direcao(Point point, BotaoAjuste botaoAjuste) {

                int yAnterior = jComponent.getY();

                jComponent.setLocation(new Point(
                        jComponent.getX(),
                        point.y));

                jComponent.setBounds(jComponent.getX(), jComponent.getY(),
                        point.x - jComponent.getX()
                        , (yAnterior - jComponent.getY()) + jComponent.getHeight());
                ajustarPosicoes(botoes);

            }

            @Override
            public void ajustePosicao(BotaoAjuste botaoAjuste) {

                botaoAjuste.setLocation(new Point( jComponent.getWidth()-7, 0));
            }
        }));

        if (este)
        botoes.add(new BotaoAjuste(new Point( jComponent.getWidth()-7, (jComponent.getHeight()/2)-3), jComponent, new DirecaoAjuste() {
            @Override
            public void direcao(Point point, BotaoAjuste botaoAjuste) {

                jComponent.setBounds(jComponent.getX(), jComponent.getY(),  point.x - jComponent.getX()
                        ,jComponent.getHeight());
                ajustarPosicoes(botoes);
            }

            @Override
            public void ajustePosicao(BotaoAjuste botaoAjuste) {

                botaoAjuste.setLocation(new Point( jComponent.getWidth()-7, (jComponent.getHeight()/2)-3));

            }
        }));

        if (sueste)
        botoes.add(new BotaoAjuste(new Point( jComponent.getWidth()-7, jComponent.getHeight()-7), jComponent, new DirecaoAjuste() {
            @Override
            public void direcao(Point point, BotaoAjuste botaoAjuste) {

              //  botaoAjuste.setLocation(point);

                jComponent.setBounds(jComponent.getX(), jComponent.getY(),  point.x - jComponent.getX()
                        , point.y - jComponent.getY());
                ajustarPosicoes(botoes);

            }

            @Override
            public void ajustePosicao(BotaoAjuste botaoAjuste) {

                botaoAjuste.setLocation(new Point( jComponent.getWidth()-7, jComponent.getHeight()-7));

            }
        }));

        if (sul)
        botoes.add(new BotaoAjuste(new Point( (jComponent.getWidth()/2)-3, jComponent.getHeight()-7), jComponent, new DirecaoAjuste() {
            @Override
            public void direcao(Point point, BotaoAjuste botaoAjuste) {

                jComponent.setBounds(jComponent.getX(), jComponent.getY(), jComponent.getWidth()
                        , point.y - jComponent.getY());
                ajustarPosicoes(botoes);

            }

            @Override
            public void ajustePosicao(BotaoAjuste botaoAjuste) {

                botaoAjuste.setLocation(new Point( (jComponent.getWidth()/2)-3, jComponent.getHeight()-7));
            }
        }));

        if (sudoeste)
        botoes.add(new BotaoAjuste(new Point( 0, jComponent.getHeight()-7), jComponent, new DirecaoAjuste() {
            @Override
            public void direcao(Point point, BotaoAjuste botaoAjuste) {



                int xAnterior = jComponent.getX();
                jComponent.setLocation(new Point(
                        point.x,
                        jComponent.getY()));

                jComponent.setBounds(jComponent.getX(), jComponent.getY(),
                        (xAnterior - jComponent.getX()) + jComponent.getWidth()
                        ,  point.y - jComponent.getY());
                ajustarPosicoes(botoes);

            }

            @Override
            public void ajustePosicao(BotaoAjuste botaoAjuste) {

                botaoAjuste.setLocation(new Point( 0, jComponent.getHeight()-7));
            }
        }));

        if (oeste)
        botoes.add(new BotaoAjuste(new Point( 0, (jComponent.getHeight()/2)-3), jComponent, new DirecaoAjuste() {
            @Override
            public void direcao(Point point, BotaoAjuste botaoAjuste) {

                int xAnterior = jComponent.getX();
                jComponent.setLocation(new Point(
                        point.x,
                        jComponent.getY()));

                jComponent.setBounds(jComponent.getX(), jComponent.getY(),
                        (xAnterior - jComponent.getX()) + jComponent.getWidth()
                        , jComponent.getHeight());
                ajustarPosicoes(botoes);
            }

            @Override
            public void ajustePosicao(BotaoAjuste botaoAjuste) {

                botaoAjuste.setLocation(new Point( 0, (jComponent.getHeight()/2)-3));

            }
        }));


       // LayoutManager layoutManager = jComponent.getLayout();
       // jComponent.setLayout(null);

        for (BotaoAjuste botao:
             botoes) {
            jComponent.add(botao);

        }



      //  jComponent.setLayout(layoutManager);
        ajustarPosicoes(botoes);



    }

    default void ajustarPosicoes(ArrayList<BotaoAjuste> botoes){
        for (BotaoAjuste botao:
             botoes) {
            botao.getDirecaoAjuste().ajustePosicao(botao);
        }
    }
}
