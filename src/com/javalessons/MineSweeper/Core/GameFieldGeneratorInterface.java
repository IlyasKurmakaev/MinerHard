package com.javalessons.MineSweeper.Core;

/**
 * Created by madmax on 25.03.17.
 */
public interface GameFieldGeneratorInterface {
    public GameField generateField(int width, int height, int mines);
}
