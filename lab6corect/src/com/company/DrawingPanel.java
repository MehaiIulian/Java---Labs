package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;


public class DrawingPanel extends JPanel {
    final static int W = 1200, H = 800;
    final MainFrame frame;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image

    /**
     * In our frame,in canvas area , a blank area will appear
     *
     * @param frame
     */

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }


    /**
     * Blank area filled with white
     */
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }

    /**
     * Click on the area and adding shapes
     */
    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }

    /**
     * Drawing shape at coordinates x and y
     *
     * @param x
     * @param y
     */
    private void drawShape(int x, int y) {
        Random random = new Random();
        int radius = random.nextInt(150);//generate a random number

        int sides = (Integer) frame.configPanel.sidesField.getValue();
        float r = (float) (random.nextFloat() / 2f + 0.5);
        float g = (float) (random.nextFloat() / 2f + 0.5);
        float b = (float) (random.nextFloat() / 2f + 0.5);
        float a = (float) 0.5;
        Color color = new Color(r, g, b, a);//create a random transparent color

        /**
         * (aici am testat sa desenez o forma cu o culoare ce o selectez din jcombobox
         */
        String culoare = frame.configPanel.colorCombo.getSelectedItem().toString();
        if (culoare == "Black") {
            graphics.setColor(Color.black);
            graphics.fill(new RegularPolygon(x,y,radius,sides));
        } else {
            graphics.setColor(color);
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        }


    }

    @Override
    public void update(Graphics g) {
    } //Why did I do that? For Drawing

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    public void reset() {
        createOffscreenImage();
    }
}


