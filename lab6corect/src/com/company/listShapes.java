package com.company;

import javax.swing.*;

public class listShapes extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel;
    JComboBox shapes;


    public listShapes(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public void init()
    {
        sidesLabel = new JLabel("Available shapes:");
        add(sidesLabel);


    }


}
