package com.blackdartq.MathSharpener;

import java.util.Random;

public class MathSharpenerLogic {

    private String mathProblemString;
    private int solution;
    private int wins = 0;
    private int loses = 0;
    private int hardnessLevel = 1;

    public void setHardnessLevel(int hardnessLevel) {
        this.hardnessLevel = hardnessLevel;
    }

    public int getHardnessLevel() {
        return hardnessLevel;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public String winLossToString(){
        return "Score: " + this.getWins() + ":" + this.getLoses();
    }

    public String getMathProblemString() {
        return mathProblemString;
    }

    public void setMathProblemString(String mathProblemString) {
        this.mathProblemString = mathProblemString;
    }

    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }

    public boolean checkAnswer(int answer){
        if(answer == this.solution){
            this.setWins(this.getWins() + 1);
            return true;
        }
        this.setLoses(this.getLoses() + 1);
        return false;
    }

    public void createMathProblem(){
        Random randomNumber = new Random();
        int num1 = randomNumber.nextInt(25 * this.getHardnessLevel());
        int num2 = randomNumber.nextInt(25 * this.getHardnessLevel());
        int sign = randomNumber.nextInt(4);
        int answer = 0;
        String problem = "";
        switch (sign){
            case 0:
                answer = num1 + num2;
                problem = num1 + " + " + num2 + " =";
                break;
            case 1:
                answer = num1 - num2;
                problem = num1 + " - " + num2 + " =";
                break;
            case 2:
                answer = num1 * num2;
                problem = num1 + " X " + num2 + " =";
                break;
            case 3:
                answer = num1 / num2;
                problem = num1 + " / " + num2 + " =";
                break;
        }
        this.setMathProblemString(problem);
        this.setSolution(answer);
    }
}
