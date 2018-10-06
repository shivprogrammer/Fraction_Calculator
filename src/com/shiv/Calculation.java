package com.shiv;

public abstract class Calculation {
    private final String firstNum;
    private final String secondNum;
    private final String operation;
    protected String result;

    public Calculation(String firstNum, String secondNum, String operation) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operation = operation;
        this.result = calculateResult();
    }

    public abstract String calculateResult();
}
