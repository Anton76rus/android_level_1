package ru.geekbrains.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private final int HEIGHT_WINDOW = 800;
    private final int WIDTH_WINDOW = 700;

    Map map;
    SettingWindow settingWindow;

    public GameWindow(){
        setTitle("TicTacToe");
        setSize(WIDTH_WINDOW,HEIGHT_WINDOW);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.darkGray);
        setVisible(true);

        settingWindow = new SettingWindow(this);
        map = new Map();
        add(map);

        JButton btnStart = new JButton("Start");
        JButton btnExit = new JButton("Exit");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingWindow.setLocationRelativeTo(settingWindow.gameWindow);
                settingWindow.setVisible(true);
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1,2));
        panelBottom.add(btnStart);
        panelBottom.add(btnExit);
        add(panelBottom,BorderLayout.SOUTH);
        setVisible(true);
    }

     protected void startGame(int gameMode,int sizeMapX,int sizeMapY,int winLength){
        map.drawMap(gameMode,sizeMapX,sizeMapY,winLength);
    }

}
