package ru.geekbrains.tictactoe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {

    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;
    private final int MIN_WIN_LENGTH = 3;
    private final String SIZE_PREFIX = "Choose field size : ";
    private final String WIN_PREFIX = "Choose win length : ";

    JRadioButton btnModeHVA;
    JRadioButton btnModeHVH;
    JSlider slSizeMap;
    JSlider slWinLength;
    GameWindow gameWindow;

    public SettingWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setTitle("Settings");
        setVisible(false);
        setSize(gameWindow.getSize());
        setResizable(false);
        setLayout(new GridLayout(10,1));

        btnModeHVA = new JRadioButton("Human vs AI",true);
        btnModeHVH = new JRadioButton("Human vs Human");
        btnModeHVA.setBackground(Color.PINK);
        btnModeHVH.setBackground(Color.PINK);
        ButtonGroup btnMode = new ButtonGroup();
        btnMode.add(btnModeHVA);
        btnMode.add(btnModeHVH);
        add(btnModeHVA);
        add(btnModeHVH);

        JLabel lbSizeMap = new JLabel(SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_PREFIX + MIN_WIN_LENGTH);
        slSizeMap = new JSlider(MIN_FIELD_SIZE,MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        slWinLength = new JSlider(MIN_WIN_LENGTH,MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        lbSizeMap.setOpaque(true);
        lbWinLength.setOpaque(true);
        slSizeMap.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slSizeMap.getValue();
                lbSizeMap.setText(WIN_PREFIX + currentValue);
                slWinLength.setMaximum(currentValue);
            }
        });
        slWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_PREFIX + slWinLength.getValue());
            }
        });

        add(lbSizeMap);
        add(slSizeMap);
        add(lbWinLength);
        add(slWinLength);

        JButton btnStartGame = new JButton("Start game");
        btnStartGame.setBackground(Color.ORANGE);
        add(btnStartGame);
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickBtmStart();
            }
        });
    }

    private void clickBtmStart(){
        setVisible(false);
        int currentMode;
        if(btnModeHVA.isSelected()) currentMode = 1;
        else if(btnModeHVH.isSelected()) currentMode = 2;
        else throw new RuntimeException("Unexpected mode");
        gameWindow.startGame(currentMode,slSizeMap.getValue(),slSizeMap.getValue(),slWinLength.getValue());
    }

}
