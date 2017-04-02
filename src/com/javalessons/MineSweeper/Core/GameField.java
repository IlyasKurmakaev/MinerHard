package com.javalessons.MineSweeper.Core;

/**
 * Created by madmax on 25.03.17.
 */
public class GameField {
    private boolean mines[][];

    public GameField(int width, int height) {
        mines = new boolean[width][height];
    }

    public int getWidth() {
        return mines.length;
    }

    public int getHeight() {
        return mines[0].length;
    }

    public void addMine(int x, int y) {
        mines[x][y] = true;
    }

    public boolean isMine(int x, int y) {
        return mines[x][y];
    }

    public int getMinesCountAround(int x, int y) {
        //Непонятный баг
        int count = 0;

        for (int mX = x - 1; mX < (x + 1); mX++) {
            for (int mY = y - 1; mY < (y + 1); mY++) {
                if (mX < 0 || mY < 0 || mX >= getWidth() || mY >= getHeight() || (mX == x && mY == y)) {
                    continue;
                } else if (mines[mX][mY]) {
                    count++;
                }
            }
        }

        return count;
    }
}
