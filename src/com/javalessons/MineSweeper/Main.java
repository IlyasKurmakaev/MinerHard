package com.javalessons.MineSweeper;

import com.javalessons.MineSweeper.Core.GameField;
import com.javalessons.MineSweeper.Core.RandomGameFieldGenerator;
import com.javalessons.MineSweeper.GUI.GameFieldParametersDialog;
import com.javalessons.MineSweeper.GUI.GameFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameFieldParametersDialog dialog = new GameFieldParametersDialog();
                dialog.setCallback(new GameFieldParametersDialog.GameFieldParametersListener() {
                    @Override
                    public void parametersSelected(int width, int height, int mines) {
                        RandomGameFieldGenerator generator = new RandomGameFieldGenerator();

                        GameField field = generator.generateField(width, height, mines);

                        GameFrame window = new GameFrame(field);
                        window.setVisible(true);
                    }
                });

                dialog.setVisible(true);
            }
        });
    }
}
