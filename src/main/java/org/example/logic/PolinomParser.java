package org.example.logic;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolinomParser {

    public static TreeMap<Integer, Double> parsePolinom(String input) {
        TreeMap<Integer, Double> polinom = new TreeMap<>();
        Pattern pattern = Pattern.compile("([-+]?)\\b(\\d*)x?(\\^\\d+)?");
        Matcher matcher = pattern.matcher(input.replaceAll("\\s+", ""));

        while (matcher.find()) {
            String sign = matcher.group(1);
            String coefPart = matcher.group(2);
            String powerPart = matcher.group(3);

            double coefficient = 0.0; // Coeficientul implicit
            int power = 0; // Gradul implicit

            // Determina coeficientul
            if (!coefPart.isEmpty()) {
                coefficient = Double.parseDouble(coefPart);
            } else if (matcher.group().contains("x")) {
                coefficient = 1.0; // Coeficient implicit pentru x
            }

            // Aplică semnul coeficientului
            if ("-".equals(sign)) {
                coefficient = -coefficient;
            }

            // Determina puterea lui x
            if (powerPart != null && powerPart.length() > 1) {
                power = Integer.parseInt(powerPart.substring(1));
            } else if (matcher.group().contains("x")) {
                power = 1; // x fără exponent are gradul 1
            }

            // Adauga termenul la polinom
            polinom.put(power, polinom.getOrDefault(power, 0.0) + coefficient);

        }
        if(polinom.get(0) == 0){
            polinom.remove(0);
        }
        return polinom;
    }
}

