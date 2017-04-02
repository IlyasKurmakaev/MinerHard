package com.javalessons.MineSweeper.Core;

import java.util.Random;

/**
 * Created by madmax on 25.03.17.
 */
public class RandomGameFieldGenerator implements GameFieldGeneratorInterface {

    @Override
    public GameField generateField(int width, int height, int mines) {
        GameField field = new GameField(width, height);

        Random randomGenerator = new Random();
        for (int i = 0; i < mines; i++) {
            int x, y;

            do {
                x = randomGenerator.nextInt(width);
                y = randomGenerator.nextInt(height);
            } while (field.isMine(x, y));

            field.addMine(x, y);
        }

        return field;
    }
}
