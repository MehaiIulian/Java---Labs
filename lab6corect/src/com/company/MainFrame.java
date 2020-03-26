package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    listShapes list;

    public MainFrame() {
        super("Drawing app");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /**
         * Drawing zone
         */
        canvas = new DrawingPanel(this);

        /**
         * Drawing options area
         */
        controlPanel = new ControlPanel(this);

        /**
         * Save/load/Reset/Exit area
         */
        configPanel = new ConfigPanel(this);

        list = new listShapes(this);


        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        add(configPanel, BorderLayout.NORTH);
        add(list, BorderLayout.WEST);

        pack();
    }


}
