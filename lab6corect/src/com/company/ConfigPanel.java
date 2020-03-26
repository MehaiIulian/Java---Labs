package com.company;

import javax.swing.*;

/**
 * Drawing options for a hex shape(sides and color:random by default)
 */

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField;
    JComboBox colorCombo;


    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides

        //create the colorCombo, containing the values: Random and Black
        String[] valori = new String[]{"Random", "Black", "Rosu","Verde"};
        colorCombo = new JComboBox(valori);

        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }
}