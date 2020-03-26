package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class for options for picture
 */


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");


    //create all buttons (Load, Reset, Exit)

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(4, 1));

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);


    }

    private void exit(ActionEvent actionEvent) {
        frame.dispose();
        System.exit(0);
    }

    private void reset(ActionEvent actionEvent) {
        frame.canvas.reset();
        frame.repaint();
    }

    private void load(ActionEvent actionEvent) {
        try {
            BufferedImage image = ImageIO.read(new File("d:\\java\\imagine.png"));
            frame.canvas.image = image;
            frame.canvas.graphics = frame.canvas.image.createGraphics();
            frame.repaint();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("d:\\java\\imagine.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}