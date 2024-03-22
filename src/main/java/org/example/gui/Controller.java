package org.example.gui;

import org.example.logic.Operations;
import org.example.logic.PolinomParser;
import org.example.logic.PolynomialConverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

public class Controller implements ActionListener {

    private View view;

    private Operations operations = new Operations();

    public Controller(View v){
        this.view = v;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command == "COMPUTE"){

            String operation = String.valueOf(view.getOperationsComboBox().getSelectedItem());

            TreeMap <Integer, Double> result = new TreeMap<>();
            TreeMap<Integer, Double> pol1 = PolinomParser.parsePolinom(view.getFirstNumberTextField().getText());
            TreeMap<Integer, Double> pol2 = PolinomParser.parsePolinom(view.getSecondNumberTextField().getText());


            switch(operation){
                case "Add": result = operations.add(pol1, pol2);
                    break;
                case "Subtract": result = operations.subtract(pol1, pol2);
                    break;
                case "Multiply": result = operations.multiply(pol1, pol2);
                    break;
                case "Derivative": result = operations.derivative(pol1);
                    break;
                case "Integration": result = operations.integration(pol1);
                    break;

            }
            String sumaString = PolynomialConverter.polynomialToString(result);
            view.getResultValueLabel().setText(String.valueOf(sumaString));

        }
    }

}
