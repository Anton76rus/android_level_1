package ru.geekbrains.game.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WIN_WIDTH = 507;
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_POSX = 650;
    private static final int WIN_POSY = 250;

    private Color cBtmNewGame = new Color(150,200,0);
    private Color cBtmExitGame = new Color(230,30,60);

    private Map map;
    private SettingWindow settingWindow;

    GameWindow (){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(WIN_POSX,WIN_POSY);
        setSize(WIN_WIDTH,WIN_HEIGHT);
        setTitle(" TicTacToe ");
        map = new Map();
        settingWindow = new SettingWindow(this);

        JButton btmStartNewGame = new JButton("Start new game");
        btmStartNewGame.setBackground(cBtmNewGame);
        btmStartNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingWindow.setVisible(true);
            }
        });

        JButton btmExitGame = new JButton("Exit");
        btmExitGame.setBackground(cBtmExitGame);
        btmExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(2,1));
        panelBottom.add(btmStartNewGame);
        panelBottom.add(btmExitGame);

        add(panelBottom,BorderLayout.SOUTH);
        add(map);

        setVisible(true);
    }

    void startNewGame(int mode,int fieldSizeX,int fieldSizeY,int winLength){
        map.startNewGame(mode,fieldSizeX,fieldSizeY,winLength);
    }
}
