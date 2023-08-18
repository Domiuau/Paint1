package com.domiuau.formas;

import com.domiuau.desenhos.Desenhavel;

import java.awt.*;

public class Imagem implements Desenhavel {

    private Image image;
    private int x;
    private int y;

    public Imagem(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    @Override
    public int getTipo() {
        return 3;
    }

    @Override
    public Color getCor() {
        return null;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public BasicStroke getStroke() {
        return new BasicStroke(0);
    }
}
