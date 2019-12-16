package polinomlagrange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Graph {

    //private ArrayList<Double> CF;
    //private ArrayList<ArrayList<Double>> mass;
    private ArrayList<Double> valfunc;
    private ArrayList<Double> node;
    private Polynom resultAll;

    public Graph(ArrayList<Double> node, ArrayList<Double> valfunc) {
        this.valfunc = valfunc;//f(xi)
        this.node = node; //xi (узлы)
        resultAll = basicpols();

        //this.mass = Matrix(); //Матрица системы
        //this.CF = Coefficient(CalculateMatrix(Mtr(mass)));//Коэффиценты
    }

    public Polynom basicpols() {
        Map<Integer, Double> members1 = new HashMap<>();
        Map<Integer, Double> members = new HashMap<>();
        Map<Integer, Double> result = new HashMap<>();
        Polynom[] polynomObj = new Polynom[node.size()];

        if (node.size() == 2) {
            members.put(1, (double) 1);
            members.put(0, (double) -node.get(1));
            members1.put(1, (double) 1);
            members1.put(0, (double) -node.get(0));

            Polynom firstPolynom = new Polynom(members);
            Polynom secondPolynom = new Polynom(members1);

            polynomObj[0] = firstPolynom.dividingNumber(node.get(0) - node.get(1))
                    .multiplicationNumber(valfunc.get(0));

            polynomObj[1] = secondPolynom.dividingNumber(node.get(1) - node.get(0))
                    .multiplicationNumber(valfunc.get(1));

        } else if (node.size() == 1) {
            System.out.println(node);

        } else {
            for (int i = 0; i < node.size(); i++) {
                for (int j = 0; j < node.size(); j++) {

                    if (i != j) {
                        if (i == 0) {
                            if (j < 2) {
                                members.put(1, (double) 1);
                                members.put(0, (double) -node.get(j));
                                members1.put(1, (double) 1);
                                members1.put(0, (double) -node.get(j + 1));

                                Polynom firstPolynom = new Polynom(members);
                                Polynom secondPolynom = new Polynom(members1);

                                result = firstPolynom.multiply(secondPolynom);

                            } else if (j > 2) {
                                Polynom firstPolynom = new Polynom(result);
                                members.put(1, (double) 1);
                                members.put(0, (double) -node.get(j));
                                Polynom secondPolynom = new Polynom(members);
                                result = firstPolynom.multiply(secondPolynom);
                            }

                        } else if (i == 1) {
                            if (j < 2) {
                                members.put(1, (double) 1);
                                members.put(0, (double) -node.get(j));
                                members1.put(1, (double) 1);
                                members1.put(0, (double) -node.get(j + 2));
// System.out.println("vvvt" + members + " " + members1); 
                                Polynom firstPolynom = new Polynom(members);
                                Polynom secondPolynom = new Polynom(members1);

                                result = firstPolynom.multiply(secondPolynom);

                            } else if (j > 2) {
                                Polynom firstPolynom = new Polynom(result);
                                members.put(1, (double) 1);
                                members.put(0, (double) -node.get(j));
// System.out.println(members); 
                                Polynom secondPolynom = new Polynom(members);
                                result = firstPolynom.multiply(secondPolynom);
// 
                            }
                        } else if (i > 1) {
                            if (j < 1) {
                                members.put(1, (double) 1);
                                members.put(0, (double) -node.get(j));
                                members1.put(1, (double) 1);
                                members1.put(0, (double) -node.get(j + 1));
// System.out.println("vvvt1" + members + " " + members1); 
// System.out.println(members+" "+ members1); 
                                Polynom firstPolynom = new Polynom(members);
                                Polynom secondPolynom = new Polynom(members1);

                                result = firstPolynom.multiply(secondPolynom);

                            } else if (j > 1) {
                                Polynom firstPolynom = new Polynom(result);
                                members.put(1, (double) 1);
                                members.put(0, (double) -node.get(j));
                                Polynom secondPolynom = new Polynom(members);
                                result = firstPolynom.multiply(secondPolynom);
                            }
                        }

                    }

                }

                Polynom resultPol = new Polynom(result);

                double counter = 1;
                for (int j = 0; j < node.size(); j++) {
                    if (i != j) {
                        counter *= node.get(i) - node.get(j);

                    }
                }

                resultPol = resultPol.dividingNumber((double) counter);
                resultPol = resultPol.multiplicationNumber(valfunc.get(i));
                polynomObj[i] = resultPol;

            }

        }
        resultAll = polynomObj[node.size() - 1];
        for (int i = 0; i < node.size() - 1; i++) {

            resultAll = resultAll.add(polynomObj[i]);
        }
        if (node.size() != 1) {
            resultAll.print();
        }
        return resultAll;
    }

    public Polynom GetRes() {
        return resultAll;
    }


}
