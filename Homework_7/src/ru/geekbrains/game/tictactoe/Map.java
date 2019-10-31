package ru.geekbrains.game.tictactoe;

import javax.swing.*;
import java.awt.*;

class Map extends JPanel {

    final static int GM_HVA = 0;
    final static int GM_HVH = 1;

    Map() {
        Color colorBack = new Color(10, 50, 60);
        setBackground(colorBack);

    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.println("Mode " + mode +
                "\nField size X " + fieldSizeX +
                "\nField size Y " + fieldSizeY +
                "\nWin Length " + winLength);

    }
}


