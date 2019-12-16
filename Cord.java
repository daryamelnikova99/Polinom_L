package polinomlagrange;

import java.util.ArrayList;

public class Cord {

    private double x1 = 500;
    private double y1 = 270;
    private int z = 20;

    public ArrayList Coordinates(int x, int y) {
        ArrayList<Double> cord = new ArrayList<>();
        double a, b;
        a = ((x - x1) / z);
        b = ((-y + y1) / z);
        cord.add(a);
        cord.add(b);

        return cord;
    }

}
