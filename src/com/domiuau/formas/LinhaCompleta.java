package com.domiuau.formas;

import com.domiuau.desenhos.Desenhavel;

import java.awt.*;
import java.util.ArrayList;


public class LinhaCompleta implements Desenhavel {

    private ArrayList<Linhas> linhaCompleta;
    private int tipo;

    public LinhaCompleta(ArrayList<Linhas> linhaCompleta, int tipo, Color color, BasicStroke basicStroke) {
        this.linhaCompleta = linhaCompleta;
        this.tipo = tipo;
        this.color = color;
        this.basicStroke = basicStroke;
    }

    private Color color;
    private BasicStroke basicStroke;

    public ArrayList<Linhas> getLinhaCompleta() {
        return linhaCompleta;
    }

    public void setLinhaCompleta(ArrayList<Linhas> linhaCompleta) {
        this.linhaCompleta = linhaCompleta;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setBasicStroke(BasicStroke basicStroke) {
        this.basicStroke = basicStroke;
    }

    @Override
    public int getTipo() {
        return 0;
    }

    @Override
    public Color getCor() {
        return color;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

    }

    @Override
    public BasicStroke getStroke() {
        return basicStroke;
    }
}
