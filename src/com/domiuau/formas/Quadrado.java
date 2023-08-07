package com.domiuau.formas;

import com.domiuau.desenhos.Desenhavel;

import java.awt.*;

public class Quadrado implements Desenhavel {

    private int x;
    private int y;
    private int width;
    private int height;
    private int tipo;
    private Color color;
    private BasicStroke stroke;

    public Quadrado(int x, int y, int width, int height, int tipo, Color color, BasicStroke stroke) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tipo = tipo;
        this.color = color;
        this.stroke = stroke;
    }

    public Quadrado() {

    }

    public Quadrado(int tipo, Color color, BasicStroke stroke) {
            this.tipo = tipo;
            this.color = color;
            this.stroke = stroke;
    }

    public int getX() {
        return x;
    }





    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setStroke(BasicStroke stroke) {
        this.stroke = stroke;
    }

    @Override
    public int getTipo() {
        return tipo;
    }

    @Override
    public Color getCor() {
        return color;
    }

    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public BasicStroke getStroke() {
        return stroke;
    }


}
