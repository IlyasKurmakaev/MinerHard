package com.javalessons.MineSweeper.GUI;

import com.javalessons.MineSweeper.Core.GameField;

import javax.swing.*;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by madmax on 25.03.17.
 */
public class GameFrame extends JFrame {
    private GameField field;
    private JToggleButton buttons[][];


    public GameFrame(GameField field) throws HeadlessException {
        super("MineSweeper");

        this.field = field;

        int width = field.getWidth();
        int height = field.getHeight();
        setLayout(new GridLayout(height, width));

        this.buttons = new JToggleButton[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int finalX = x;
                int finalY = y;
                JToggleButton button = new JToggleButton();

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        checkForMine(finalX, finalY);
                    }
                });
                add(button);

                this.buttons[x][y] = button;
            }
        }


        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void checkForMine(int x, int y) {
        if (field.isMine(x, y)) {
            JOptionPane.showMessageDialog(this, "Вы проиграли!");
            dispose();
        } else {
            revealCell(x, y, true);
        }
    }

    private void revealCell(int x, int y, boolean isStart) {
        if (x < 0 || y < 0 || x >= field.getWidth() || y >= field.getHeight() || field.isMine(x, y) || (!isStart && buttons[x][y].isSelected())) {
            return;
        }

        int minesCount = field.getMinesCountAround(x, y);

        if (minesCount == 0) {
            /*revealCell(x - 1, y, false);
            revealCell(x + 1, y, false);
            revealCell(x, y - 1, false);*/
            revealCell(x, y + 1, false);
        } else {
            buttons[x][y].setText(String.valueOf(minesCount));
        }

        buttons[x][y].setSelected(true);
    }
}
