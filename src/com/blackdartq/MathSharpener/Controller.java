package com.blackdartq.MathSharpener;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    private MathSharpenerLogic mathSharpenerLogic;

    @FXML
    private Label mathLabel;
    @FXML
    private TextField answerTextField;
    @FXML
    private Button submitButton;
    @FXML
    private Label statusLabel;
    @FXML
    private Label scoreLabel;

    public void setMathLabel() {
        this.mathLabel.setText(this.mathSharpenerLogic.getMathProblemString());
    }

    @FXML
    public void checkAnswer(){
        this.mathSharpenerLogic.checkAnswer(Integer.parseInt(this.answerTextField.getText()));
        this.scoreLabel.setText(this.mathSharpenerLogic.winLossToString());
        this.mathSharpenerLogic.createMathProblem();
        setMathLabel();
        this.answerTextField.clear();
    }

    public void initialize(){
        this. mathSharpenerLogic = new MathSharpenerLogic();
        this.mathSharpenerLogic.createMathProblem();
        setMathLabel();
    }
}
