package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComponentPanel extends JPanel {
        private static final int WIDTH = 300;
        private static final int HEIGHT = 1000;

        public ComponentPanel(){
            setLayout(null);
            setBounds(0,0,WIDTH,HEIGHT);

            JButton paintBtn = new JButton("Построить график!");
            paintBtn.setBounds(35,500,180,100);

            JTextField mathExpectationField = new JTextField("Матожидание");
            mathExpectationField.setBounds(35,30,180,30);
            mathExpectationField.addMouseListener(new FieldMouseListener(mathExpectationField));
            mathExpectationField.addKeyListener(new FieldKeyListener());
            mathExpectationField.setToolTipText("Введите матожидание");

            JTextField dispersionField = new JTextField("Дисперсия");
            dispersionField.setBounds(35,90,180,30);
            dispersionField.addMouseListener(new FieldMouseListener(dispersionField));
            dispersionField.addKeyListener(new FieldKeyListener());
            dispersionField.setToolTipText("Введите дисперсию");

            JTextField dotsCountField = new JTextField("Кол-во точек");
            dotsCountField.setBounds(35,150,180,30);
            dotsCountField.addMouseListener(new FieldMouseListener(dotsCountField));
            dotsCountField.addKeyListener(new FieldKeyListener());
            dotsCountField.setToolTipText("Введите кол-во точек");

            DefaultComboBoxModel dcms = new DefaultComboBoxModel();
            dcms.addElement("frfrgt");
            dcms.addElement("aaaaaa");
            JComboBox<String> distribution = new JComboBox<String>(dcms);
            distribution.setBounds(35,320,180,30);
            distribution.setToolTipText("Выберите закон распределения");

            JButton exitBtn = new JButton("Выйти");
            exitBtn.setBounds(35,670,180,100);

            add(distribution);
            add(dotsCountField);
            add(dispersionField);
            add(mathExpectationField);
            add(paintBtn);
            add(exitBtn);

            paintBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (    (mathExpectationField.getText().equals("Матожидание")) ||
                            (dispersionField.getText().equals("Дисперсия")) ||
                            (dotsCountField.getText().equals("Кол-во точек"))) return;
                }
            });

            exitBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        }

        private class FieldMouseListener extends MouseAdapter{

            JTextField textField;

            FieldMouseListener(JTextField textField){
                this.textField = textField;
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                textField.setText("");
            }
        }

        private class FieldKeyListener extends KeyAdapter{

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (  ((c < '0') || (c > '9')) && (c != '\b')  ) e.consume();
            }
        }
}
