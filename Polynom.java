package polinomlagrange;


import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Polynom {

    final static String EMPTY_STRING = "";
    final static String DEGREE_MARK_1 = "x";
    final static String DEGREE_MARK_NTH = "x^";

    private final Map<Integer, Double> members = new TreeMap<>(Collections.reverseOrder());

    public Polynom(Map<Integer, Double> members) {
        //members = roundDict();
        this.members.putAll(members);

    }

    public double ValueAtPoint(double s) {
        double num = 0.0;

        for (Integer k : this.members.keySet()) {
            if (k == 0) {
                num += this.members.get(k);
            } else {
                num += Math.pow(s, k) * this.members.get(k);
            }
        }
        return num;
    }

    public Map<Integer, Double> roundDict() {
        Map<Integer, Double> members1 = new HashMap<>();
        System.out.println("dd" + members);
        for (Integer currentKey : this.members.keySet()) {
            double value = round(this.members.get(currentKey));
            members1.put(currentKey, value);
        }
        System.out.println(members);
        System.out.println(members1);
        return members1;
    }

    // Сложение
    public Polynom add(Polynom other) {
        Map<Integer, Double> result = new TreeMap<Integer, Double>();
        result.putAll(members);

        for (Integer currentKey : other.members.keySet()) {
            Double resultValue = other.members.get(currentKey);
            Double currentValue = result.get(currentKey);
            if (currentValue != null) {
                resultValue += currentValue;
            }
            result.put(currentKey, resultValue);
        }
        return new Polynom(result);
    }

    // Деление на число
    public Polynom dividingNumber(Double NUM) {
        Map<Integer, Double> resultDiv = new HashMap<>();
        for (Entry<Integer, Double> currentKey : members.entrySet()) {
            double resultValue = (double) currentKey.getValue() / NUM;
            resultDiv.put(currentKey.getKey(), resultValue);
        }
        return new Polynom(resultDiv);

    }

    // Умножение на число
    public Polynom multiplicationNumber(Double NUM) {
        Map<Integer, Double> resultMul = new HashMap<>();
        for (Entry<Integer, Double> currentKey : members.entrySet()) {
            double resultValue = (double) currentKey.getValue() * NUM;
            resultMul.put(currentKey.getKey(), resultValue);
        }

        return new Polynom(resultMul);
    }

    // Умножение
    public Map<Integer, Double> multiply(Polynom other) {
        Map<Integer, Double> result = new TreeMap<Integer, Double>();

        for (Entry<Integer, Double> first : members.entrySet()) {
            for (Entry<Integer, Double> second : other.members.entrySet()) {
                Integer amountKey = first.getKey() + second.getKey();
                Double productValue = first.getValue() * second.getValue();

                if (result.containsKey(amountKey)) {
                    productValue += result.get(amountKey);
                }
                result.put(amountKey, productValue);
            }
        }
        return result;
    }

    // Вывод на экран
    public String print() {
        String resultList = "";

        for (Entry<Integer, Double> currentKey : members.entrySet()) {
            double ZEROVAl = round(currentKey.getValue());

            if (ZEROVAl == 0) {
                resultList += "";
            } else if (currentKey.getValue() == 1) {
                if (currentKey.getKey() > 1) {
                    resultList += "" + DEGREE_MARK_NTH + "" + currentKey.getKey();
                } else if (currentKey.getKey() == 0) {
                    resultList += "" + sign(currentKey.getValue());
                } else if (currentKey.getKey() == 1) {
                    resultList += "" + DEGREE_MARK_1;
                }

            } else {
                if (currentKey.getKey() > 1) {
                    resultList += "" + sign(currentKey.getValue()) + DEGREE_MARK_NTH + currentKey.getKey();
                } else if (currentKey.getKey() == 0) {
                    resultList += "" + sign(currentKey.getValue());
                } else if (currentKey.getKey() == 1) {
                    resultList += "" + sign(currentKey.getValue()) + DEGREE_MARK_1;
                }

            }

        }

        char plusRes = resultList.charAt(0);

        if ("+".equals("" + plusRes)) {
            resultList = resultList.substring(1, resultList.length());

        }
        System.out.println(members);
        System.out.println("Ответ:");
        System.out.println("f(x) = " + resultList);
        
        return resultList;
    }

    //округление числа
    public Double round(Double NUM) {
        int a = (int) (NUM * 10);
        return (double) ((int) (NUM * 100)) / 100;
    }

    //знак числа
    public String sign(Double NUM) {
        String NumStr = "";
        if (NUM > 0) {
            NumStr += "+" + NUM;
        } else {
            NumStr += "" + NUM;
        }
        return NumStr;

    }

}

