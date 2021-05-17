package ru.geekbrains.game.tictactoe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {

    private static final int WIN_WIDTH = 350;
    private static final int WIN_HEIGHT = 230;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Field size is ";
    private static final String WIN_LENGTH_PREFIX = "Win length is ";

    private GameWindow gameWindow;
    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideWinLength;
    private JSlider slideFieldSize;
    private JButton startGame;

    SettingWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;

        setSize(WIN_WIDTH,WIN_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WIN_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WIN_HEIGHT / 2;
        setLocation(posX,posY);
        setResizable(false);
        setTitle("Creating new game");
        setLayout(new GridLayout(10,1));

        startGame = new JButton("Start game");
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartClick();
            }
        });
        addGameModeControls();
        addFieldControl();
        add(startGame);

    }

    private void btnStartClick(){
        int gameMode;
        if(humVSAI.isSelected()){
            gameMode = Map.GM_HVA;
        }else if(humVShum.isSelected()){
            gameMode = Map.GM_HVH;
        }else {
            throw new RuntimeException("Unexpected game mode");
        }

        int fieldSize = slideFieldSize.getValue();
        int winLength = slideWinLength.getValue();

        gameWindow.startNewGame(gameMode,fieldSize,fieldSize,winLength);

        setVisible(false);
    }

    private void addGameModeControls(){
        add(new JLabel ("Choose gaming mode"));
        humVSAI = new JRadioButton("Human VS AI",true);
        humVShum = new JRadioButton("Human VS Human");
        ButtonGroup gamemode = new ButtonGroup();
        gamemode.add(humVSAI);
        gamemode.add(humVShum);
        add(humVSAI);
        add(humVShum);
    }

    private void addFieldControl(){
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);

        slideFieldSize = new JSlider(MIN_FIELD_SIZE,MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        slideWinLength = new JSlider(MIN_WIN_LENGTH,MIN_FIELD_SIZE,MIN_FIELD_SIZE);
        slideWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLength.getValue());
            }
        });
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLength.setMaximum(currentValue);
            }
        });

        add(new JLabel("Choose Field Size "));
        add(lbFieldSize);
        add(slideFieldSize);
        add(new JLabel("Choose Win Length"));
        add(lbWinLength);
        add(slideWinLength);
    }
}