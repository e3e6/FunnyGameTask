package com.creamtec.techtalk.game.api;

import java.awt.Color;
import java.awt.Point;

import javax.swing.Icon;

public interface Cell {

    Point getPosition();

    Border getBorder();

    Color getBackgroundColor();

    Icon getIcon();

}
