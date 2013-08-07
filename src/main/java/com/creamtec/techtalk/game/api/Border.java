package com.creamtec.techtalk.game.api;

import java.awt.Color;

public interface Border {

    public boolean hasTop();

    public boolean hasRight();

    public boolean hasBottom();

    public boolean hasLeft();

    public int getThickness();

    public Color getColor();

}
