package com.domiuau.desenhos;

import java.awt.*;

public interface Desenhavel {

    public int getTipo();
    public Color getCor();

    public void setX(int x);
    public void setY(int y);

    public BasicStroke getStroke();


}
