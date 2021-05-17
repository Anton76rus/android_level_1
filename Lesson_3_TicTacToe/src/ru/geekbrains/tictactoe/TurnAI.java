package ru.geekbrains.tictactoe;

class AI {
    private final char AI_DOT;
    private final char HUMAN_DOT;
    private final char EMPTY_DOT;

    private char[][]map;

    public AI(char DOT_AI, char DOT_HUMAN, char DOT_EMPTY, char[][] map) {
        this.AI_DOT = DOT_AI;
        this.HUMAN_DOT = DOT_HUMAN;
        this.EMPTY_DOT = DOT_EMPTY;
        this.map = map;
    }

    void turn() {
        if (isWinAI()) return;
        if (isHumanWin()) return;
        turnRandom();
    }

    private boolean isWinAI() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (TicTacToe.isEmptyDot(i, j)) {
                    map[i][j] = AI_DOT;
                    if (!TicTacToe.checkWin(AI_DOT)) map[i][j] = EMPTY_DOT;
                    else return true;
                }
            }
        }
        return false;
    }

    private boolean isHumanWin() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (TicTacToe.isEmptyDot(i, j)) {
                    map[i][j] = HUMAN_DOT;
                    if (TicTacToe.checkWin(HUMAN_DOT)) {
                        map[i][j] = AI_DOT;
                        return true;
                    } else map[i][j] = EMPTY_DOT;
                }
            }
        }
        return false;
    }

    private void turnRandom(){
        int dotX;
        int dotY;
        do {
            dotX = TicTacToe.random.nextInt(TicTacToe.sizeX);
            dotY = TicTacToe.random.nextInt(TicTacToe.sizeY);
        } while (!TicTacToe.isEmptyDot(dotX, dotY));
        map[dotX][dotY] = AI_DOT;
    }
}
