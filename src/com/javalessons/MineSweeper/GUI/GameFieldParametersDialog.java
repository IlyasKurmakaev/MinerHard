package com.javalessons.MineSweeper.GUI;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFieldParametersDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JSlider widthSlider;
    private JLabel widthLabel;
    private JSlider heightSlider;
    private JLabel heightLabel;
    private JSlider minesSlider;
    private JLabel minesLabel;
    private GameFieldParametersListener callback = null;

    public GameFieldParametersDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        widthSlider.addChangeListener(new SliderChangeListener(widthSlider, widthLabel));
        heightSlider.addChangeListener(new SliderChangeListener(heightSlider, heightLabel));
        minesSlider.addChangeListener(new SliderChangeListener(minesSlider, minesLabel));

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        pack();
    }

    public void setCallback(GameFieldParametersListener callback) {
        this.callback = callback;
    }

    private void onOK() {
        if (callback != null) {
            callback.parametersSelected(widthSlider.getValue(), heightSlider.getValue(), minesSlider.getValue());
        }

        dispose();
    }


    private static class SliderChangeListener implements ChangeListener {
        private JSlider slider;
        private JLabel label;

        public SliderChangeListener(JSlider slider, JLabel label) {
            this.slider = slider;
            this.label = label;
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            label.setText(String.valueOf(slider.getValue()));
        }
    }

    public static interface GameFieldParametersListener {
        public void parametersSelected(int width, int height, int mines);
    }
}
