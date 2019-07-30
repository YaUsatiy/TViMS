package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ChartPanel extends JPanel {
    MainWindow mainWindow;

    private final int padding = 25;

    ChartPanel(MainWindow mainWindow){
        this.mainWindow = mainWindow;
        setBackground(Color.BLACK);
        mainWindow.add(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setBackground(Color.CYAN);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(Color.CYAN);
        g2d.setStroke(new BasicStroke(5.0f));//толщина линий

        //рисуем координатные оси с отступом padding
        g2d.drawLine(padding,padding, padding, getHeight() - padding);
        g2d.drawLine(padding, getHeight() - padding, getWidth() - padding, getHeight() - padding);
        Font font = new Font("Monotype Corsiva",Font.BOLD, 18);
        g2d.setFont(font);
        g2d.drawString("Y", padding*2, padding);
        g2d.drawString("X", getWidth() - padding, getHeight() - padding*2);

        //сам график
        g2d.setColor(Color.white);
        drawExp(g2d);

    }

    private void drawExp(Graphics2D g2d){
        final int rangeMin = 0;
        final double rangeMax = 1e-30;

        final double alpha = 0.1D;
        final String FORMAT = "%f\t%f";

        Random random = new Random();
        for (int i=0; i<100000; i++) {

            double current = rangeMin + (rangeMax - rangeMin) * random.nextDouble();

            //int current = random.nextInt(10000);

            // Формула из методички
            double resultMethodical = (-(1.0 / alpha)) * Math.log(current);

            g2d.drawOval((int)resultMethodical, (int)resultMethodical, 2, 2);


            // Формула по указанной ссылке
            //double resultOther = Math.log(1 - current) / (-alpha);
        }
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }
}
