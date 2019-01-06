package com.blackdartq.MathSharpener;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    @FXML
    private TextArea scratchPadTextArea;
    @FXML
    private Button easyButton;
    @FXML
    private Button mediumButton;
    @FXML
    private Button hardButton;

    public void setMathLabel() {
        this.mathLabel.setText(this.mathSharpenerLogic.getMathProblemString());
    }

    @FXML
    public void checkAnswer(){
        int answer = 1;
        try {
            answer = Integer.parseInt(this.answerTextField.getText());
        }catch (Exception e){ }
        boolean answerOutcome = this.mathSharpenerLogic.checkAnswer(answer);
        if(answerOutcome){
            this.statusLabel.setText("Correct!: " + this.mathSharpenerLogic.getSolution());
        }else{
            this.statusLabel.setText("Wrong!: " + this.mathSharpenerLogic.getSolution());
        }
        this.scoreLabel.setText(this.mathSharpenerLogic.winLossToString());
        this.mathSharpenerLogic.createMathProblem();
        setMathLabel();
        this.answerTextField.clear();
        this.scratchPadTextArea.clear();
    }

    public void initialize(){
        this. mathSharpenerLogic = new MathSharpenerLogic();
        this.mathSharpenerLogic.createMathProblem();
        setMathLabel();
    }

    @FXML
    public void setHardnessEasy(){
        this.mathSharpenerLogic.setHardnessLevel(1);
    }

    @FXML
    public void setHardnessMedium(){
        this.mathSharpenerLogic.setHardnessLevel(2);
    }

    @FXML
    public void setHardnessHard(){
        this.mathSharpenerLogic.setHardnessLevel(3);
    }
}
