package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    void toggleButtons(Button btn, Button...buttons) {
        btn.setVisible(true);

        for (Button button : buttons) {
            button.setVisible(false);
        }
    }

    @FXML
    private Label welcomeText;

    @FXML
    public Button yesButton;
    public Button noButton1;
    public Button noButton2;
    public Button noButton3;
    public Button noButton4;
    public Button noButton5;

    @FXML
    protected void onYesButtonClick() {
        welcomeText.setText("I knew it! 😂");
        toggleButtons(new Button(), yesButton, noButton1, noButton2, noButton3, noButton4, noButton5);
    }

    @FXML
    protected void noButton1Click() {
        toggleButtons(noButton2, noButton1);
    }

    @FXML
    protected void noButton2Click() {
        toggleButtons(noButton3, noButton2);
    }

    @FXML
    protected void noButton3Click() {
        toggleButtons(noButton4, noButton3);
    }

    @FXML
    protected void noButton4Click() {
        toggleButtons(noButton5, noButton4);
    }

    @FXML
    protected void noButton5Click() {
        toggleButtons(noButton1, noButton5);
    }
}