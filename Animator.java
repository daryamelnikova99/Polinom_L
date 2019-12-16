    package polinomlagrange;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;
import javax.swing.JPanel;

public class Animator {

    private Graphics2D G;
    Color C;
    int x = 0;
    int y = 50;

    public Animator(Graphics G) {
        this.G = (Graphics2D) G;
        this.G.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void drawPoint(int x, int y) {
        Random R = new Random();
        C = new Color(R.nextInt(255), R.nextInt(255), R.nextInt(255));
        G.setColor(C);
        G.fillOval(x - 4, y - 4, 8, 8);
    }

    public void drawXY(JPanel panel) {
        G.setColor(Color.blue);
        //X
        G.drawLine(panel.getWidth() / 2, 0, panel.getWidth() / 2, panel.getHeight());

        //Y
        G.drawLine(0, panel.getHeight() / 2, panel.getWidth(), panel.getHeight() / 2);
        G.setColor(Color.black);
        G.drawString("0", panel.getWidth() / 2, panel.getHeight() / 2);
        G.setColor(Color.blue);
        

    }

    public void drawGraph(int x1, int y1, int x2, int y2) {
        G.drawLine(x1, y1, x2, y2);
    }

}
