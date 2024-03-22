package org.example.logic;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;



public class OperationsTest {

    @Test
    public void testAdd() {

        // Arrange
        String pol1="3x^2+2";
        String pol2="4X+3";
        String polResult = "3x^2+4X+5";

        TreeMap<Integer, Double> polinom1 = PolinomParser.parsePolinom(pol1);


        TreeMap<Integer, Double> polinom2 = PolinomParser.parsePolinom(pol2);


        TreeMap<Integer, Double> expected = PolinomParser.parsePolinom(polResult);


        // Act
        Operations operations = new Operations();

        TreeMap<Integer, Double> result = operations.add(polinom1, polinom2);

        // Assert
        assertEquals(expected, result, "The addition of two polynomials is not correct.");
    }

    @Test
    public void testsubtract() {
        // Arrange
        String pol1="3x^2+2";
        String pol2="4X+3";
        String polResult = "3x^2-4X-1";

        TreeMap<Integer, Double> polinom1 = PolinomParser.parsePolinom(pol1);

        TreeMap<Integer, Double> polinom2 = PolinomParser.parsePolinom(pol2);

        TreeMap<Integer, Double> expected = PolinomParser.parsePolinom(polResult);

        // Act
        Operations operations = new Operations();

        TreeMap<Integer, Double> result = operations.subtract(polinom1, polinom2);

        // Assert
        assertEquals(expected, result, "The addition of two polynomials is not correct.");
    }

    @Test
    public void testmultiply() {
        // Arrange
        String pol1="3x^2+2";
        String pol2="4x-3";
        String polResult = "12x^3-9x^2+8x-6";

        TreeMap<Integer, Double> polinom1 = PolinomParser.parsePolinom(pol1);

        TreeMap<Integer, Double> polinom2 = PolinomParser.parsePolinom(pol2);

        TreeMap<Integer, Double> expected = PolinomParser.parsePolinom(polResult);

        // Act
        Operations operations = new Operations();

        TreeMap<Integer, Double> result = operations.multiply(polinom1, polinom2);

        // Assert
        assertEquals(expected, result, "The addition of two polynomials is not correct.");
    }

    @Test
    public void testderivative() {
        // Arrange
        String pol="3x^2+2x";
        String polResult="6x+2";

        TreeMap<Integer, Double> polinom = PolinomParser.parsePolinom(pol);

        TreeMap<Integer, Double> expected = PolinomParser.parsePolinom(polResult);

        // Act
        Operations operations = new Operations();

        TreeMap<Integer, Double> result = operations.derivative(polinom);

        // Assert
        assertEquals(expected, result, "The addition of two polynomials is not correct.");
    }

    @Test
    public void testintegration() {
        // Arrange
        String pol="3x^2+2x";
        String polResult="x^3+x^2";
        TreeMap<Integer, Double> polinom = PolinomParser.parsePolinom(pol);

        TreeMap<Integer, Double> expected = PolinomParser.parsePolinom(polResult);


        // Act
        Operations operations = new Operations();

        TreeMap<Integer, Double> result = operations.integration(polinom);

        // Assert
        assertEquals(expected, result, "The addition of two polynomials is not correct.");
    }



}