package ru.geekbrains.tictactoe;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    private final int HVI = 0;
    private final int HVH = 1;
    private int winLength;

    public Map() {
        setVisible(true);
    }

    void drawMap(int gameMode, int sizeMapX, int sizeMapY, int winLength){
        drawLines(super.getGraphics(),sizeMapX,sizeMapY);
    }

    private void drawLines(Graphics g,int sizeMapX,int sizeMapY) {
        int currentPositionX = getX();
        int currentPositionY = getY();
        int widthCell = getWidth() / sizeMapX;
        int heightCell = getHeight() / sizeMapY;
        for (int i = 0; i < sizeMapX + 1; i++) {
            g.drawLine(currentPositionX, getY(), currentPositionX, getY() + getHeight());
            currentPositionX += widthCell;
            g.drawLine(getX(), currentPositionY, getX() + getWidth(), currentPositionY);
            currentPositionY += heightCell;
        }
    }
}
