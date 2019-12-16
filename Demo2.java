package polinomlagrange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo2 extends JFrame {

    //int x1,y1;
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JLabel label1 = new JLabel();
    Animator A;

    public Demo2() {
        super("Лагранж");
        this.setSize(1000, 620);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        panel.setBounds(0, 0, 1000, 540);
        panel.setBackground(Color.BLACK);
        add(panel);
        label.setBounds(100, 545, 250, 20);
        label1.setBounds(100, 560, 450, 20);
        label.setText("Узловые точки");
        label1.setText("Полином - ");
        add(label);
        add(label1);
        A = new Animator(panel.getGraphics());
        Cord cordinate = new Cord();
        ArrayList<Double> m1 = new ArrayList<>();
        ArrayList<Double> m2 = new ArrayList<>();
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                A.drawPoint(e.getX(), e.getY());
                ArrayList<Double> s = cordinate.Coordinates(e.getX(), e.getY());
                m1.add(s.get(0));
                m2.add(s.get(1));
                if (m1.size() == 1) {
                    label.setText("Узловые точки: x-(" + s.get(0) + ") y- (" + s.get(1) + ")");
                    drowl(s.get(1),s.get(1));
                } else {
                    Graph polinom = new Graph(m1, m2);
                    label.setText("Узловые точки: x-(" + s.get(0) + ") y- (" + s.get(1) + ")");
                    label1.setText("Полином -" + polinom.GetRes().print());
                    drow(polinom);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (A != null) {
            A.drawXY(panel);
        }

    }

    public void drow(Graph p) {
        double s = 0.05;
        double a = (double) (panel.getX() - panel.getWidth() / 2) / 20;
        double b = (double) (-panel.getX() + panel.getWidth() - panel.getWidth() / 2) / 20;
        for (double i = a; i < b; i += s) {
            double yi = p.GetRes().ValueAtPoint((double) i);
            double yj = p.GetRes().ValueAtPoint((double) i + s);
            A.drawGraph((int) (i * 20 + panel.getWidth() / 2), (int) (panel.getHeight() / 2 - yi * 20), (int) ((i + s) * 20 + panel.getWidth() / 2), (int) (panel.getHeight() / 2 - yj * 20));
        }
    }

    public void drowl(double yi, double yj) {
        double s = 0.05;
        double a = (double) (panel.getX() - panel.getWidth() / 2) / 20;
        double b = (double) (-panel.getX() + panel.getWidth() - panel.getWidth() / 2) / 20;
        for (double i = a; i < b; i += s) {
            A.drawGraph((int) (i * 20 + panel.getWidth() / 2), (int) (panel.getHeight() / 2 - yi * 20), (int) ((i + s) * 20 + panel.getWidth() / 2), (int) (panel.getHeight() / 2 - yj * 20));
        }
    }

}
