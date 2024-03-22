package org.example.logic;

import java.util.TreeMap;

public class Operations {

    public TreeMap <Integer, Double> add(TreeMap <Integer, Double> polinom1, TreeMap <Integer, Double> polinom2) {
        TreeMap <Integer, Double> result = new TreeMap<>();
        for (Integer grad : polinom1.keySet()){
            result.put(grad , polinom1.get(grad));
        }
        for (Integer grad : polinom2.keySet()){
            double coeficient = polinom2.get(grad);
            if (result.containsKey(grad)) {
                coeficient += result.get(grad);
            }
            result.put(grad, coeficient);
        }
        return result;
    }

    public TreeMap <Integer, Double> subtract(TreeMap <Integer, Double> polinom1, TreeMap <Integer, Double> polinom2) {
        TreeMap <Integer, Double> result = new TreeMap<>();
        double variabila;
        for (Integer grad : polinom2.keySet()){
            variabila=polinom2.get(grad)*(-1);
            result.put(grad , variabila);
        }
        for (Integer grad : polinom1.keySet()){
            double coeficient = polinom1.get(grad);
            if (result.containsKey(grad)) {
                coeficient += result.get(grad);
            }
            result.put(grad, coeficient);
        }
        return result;
    }

    public TreeMap<Integer, Double> multiply(TreeMap<Integer, Double> polinom1, TreeMap<Integer, Double> polinom2) {
        TreeMap<Integer, Double> result = new TreeMap<>();

        for (Integer grad1 : polinom1.keySet()) {
            for (Integer grad2 : polinom2.keySet()) {
                int combinedPower = grad1 + grad2;
                double combinedCoefficient = polinom1.get(grad1) * polinom2.get(grad2);

                if (result.containsKey(combinedPower)) {
                    combinedCoefficient += result.get(combinedPower);
                }
                result.put(combinedPower, combinedCoefficient);
            }
        }
        return result;
    }

    public TreeMap<Integer, Double> derivative(TreeMap<Integer, Double> polinom1){
        TreeMap<Integer, Double> result = new TreeMap<>();
        double coeficient;
        for(Integer grad : polinom1.keySet()){
            if(grad != 0){
                coeficient = polinom1.get(grad);
                coeficient *= grad;
                result.put(grad - 1, coeficient);
            }
        }
        return result;
    }
    public TreeMap<Integer, Double> integration(TreeMap<Integer, Double> polinom1) {
        TreeMap<Integer, Double> result = new TreeMap<>();
        double coeficient;
        for (Integer grad : polinom1.keySet()) {

                coeficient = polinom1.get(grad);
                if (grad != 0) {
                    coeficient /= grad + 1;
                }
                result.put(grad + 1, coeficient);
            }
        result.remove(0);
        return result;
    }
}
