package ru.geekbrains.tictactoe;

public class AI {
    private final char DOT_AI;
    private final char DOT_HUMAN;
    private final char DOT_EMPTY;

    private final char[][] field;
    private final Map map;
    private int sizeMapX;
    private int sizeMapY;

    public AI(Map map, char DOT_AI, char DOT_HUMAN, char DOT_EMPTY, char[][] field) {
        this.DOT_AI = DOT_AI;
        this.DOT_HUMAN = DOT_HUMAN;
        this.DOT_EMPTY = DOT_EMPTY;
        this.field = field;
        this.map = map;
        sizeMapX = map.getSizeMapX();
        sizeMapY = map.getSizeMapY();
    }

    void turn() {
        if (isNextTurnWinAI()) return;
        if (isNextTurnHumanWin()) return;
        turnRandom();
    }

    private boolean isNextTurnWinAI() {
        for (int i = 0; i < sizeMapX; i++) {
            for (int j = 0; j < sizeMapY; j++) {
                if (map.isEmptyDot(i, j)) {
                    field[i][j] = DOT_AI;
                    if (!map.checkWin(DOT_AI)) field[i][j] = DOT_EMPTY;
                    else return true;
                }
            }
        }
        return false;
    }

    private boolean isNextTurnHumanWin() {
        for (int i = 0; i < sizeMapX; i++) {
            for (int j = 0; j < sizeMapY; j++) {
                if (map.isEmptyDot(i, j)) {
                    field[i][j] = DOT_HUMAN;
                    if (map.checkWin(DOT_HUMAN)) {
                        field[i][j] = DOT_AI;
                        return true;
                    } else field[i][j] = DOT_EMPTY;
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
        field[dotX][dotY] = DOT_AI;
    }
}

