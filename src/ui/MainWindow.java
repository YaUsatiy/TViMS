package ui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow(){
        initForm();
        initChart();
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);//потом вынести в метод
    }

    private void initForm(){
        Dimension fullSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(fullSize);
        //setSize(getDoubleDimension());
        setResizable(false);
        ImageIcon icon = new ImageIcon("res/img/icon.png");
        setIconImage(icon.getImage());
        setTitle("Визуализация законов распределения");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private Dimension getDoubleDimension(){
        double doubleWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 2;
        double doubleHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 2;
        return new Dimension((int) doubleWidth,(int) doubleHeight);
    }

    private void initChart(){
        ChartPanel chartPanel = new ChartPanel(this);
        //this.add(new ComponentPanel());
    }
}
