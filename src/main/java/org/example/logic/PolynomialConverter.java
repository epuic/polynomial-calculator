package org.example.logic;

import java.util.TreeMap;

public class PolynomialConverter {

    public static String polynomialToString(TreeMap<Integer, Double> polynomial) {
        if (polynomial.isEmpty()) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        boolean isFirstTerm = true;

        for (Integer exponent : polynomial.descendingKeySet()) {
            double coefficient = polynomial.get(exponent);

            if (coefficient == 0) {
                continue;
            }

            if (!isFirstTerm) {
                result.append(coefficient > 0 ? " + " : " - ");
            } else {
                if (coefficient < 0) {
                    result.append("-");
                }
                isFirstTerm = false;
            }

            double absCoefficient = Math.abs(coefficient);
            if (absCoefficient != 1 || exponent == 0) {
                result.append(String.format(absCoefficient == (long) absCoefficient ? "%.0f" : "%.2f", absCoefficient));
            }

            if (exponent == 1) {
                result.append("x");
            } else if (exponent > 1) {
                result.append("x^").append(exponent);
            }
        }

        return result.toString();
    }
}
