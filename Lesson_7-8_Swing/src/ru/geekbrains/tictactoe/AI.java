package ru.geekbrains.tictactoe;

public class AI {
    private final char AI_DOT;
    private final char HUMAN_DOT;
    private final char EMPTY_DOT;

    private final char[][] field;
    private final Map map;
    private int sizeMapX;
    private int sizeMapY;

    public AI(Map map, char DOT_AI, char DOT_HUMAN, char DOT_EMPTY, char[][] field) {
        this.AI_DOT = DOT_AI;
        this.HUMAN_DOT = DOT_HUMAN;
        this.EMPTY_DOT = DOT_EMPTY;
        this.field = field;
        this.map = map;
        sizeMapX = map.getSizeMapX();
        sizeMapY = map.getSizeMapY();
    }

    void turn() {
        if (isWinAI()) return;
        if (isHumanWin()) return;
        turnRandom();
    }

    private boolean isWinAI() {
        for (int i = 0; i < sizeMapX; i++) {
            for (int j = 0; j < sizeMapY; j++) {
                if (map.isEmptyDot(i, j)) {
                    field[i][j] = AI_DOT;
                    if (!map.checkWin(AI_DOT)) field[i][j] = EMPTY_DOT;
                    else return true;
                }
            }
        }
        return false;
    }

    private boolean isHumanWin() {
        for (int i = 0; i < sizeMapX; i++) {
            for (int j = 0; j < sizeMapY; j++) {
                if (map.isEmptyDot(i, j)) {
                    field[i][j] = HUMAN_DOT;
                    if (map.checkWin(HUMAN_DOT)) {
                        field[i][j] = AI_DOT;
                        return true;
                    } else field[i][j] = EMPTY_DOT;
                }
            }
        }
        return false;
    }

    private void turnRandom() {
        int dotX;
        int dotY;
        do {
            dotX = map.random.nextInt(sizeMapX);
            dotY = map.random.nextInt(sizeMapY);
        } while (!map.isEmptyDot(dotX, dotY));
        field[dotX][dotY] = AI_DOT;
    }
}

