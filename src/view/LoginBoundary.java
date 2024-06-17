package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class LoginBoundary implements TelaInterface {

    private Pane pLogin;

    @Override
    public void montarTela(Pane pane) {
        Label userLabel = new Label("CPF:");
        userLabel.setLayoutX(50);
        userLabel.setLayoutY(100);

        TextField userField = new TextField();
        userField.setLayoutX(150);
        userField.setLayoutY(100);

        Label passwordLabel = new Label("Senha:");
        passwordLabel.setLayoutX(50);
        passwordLabel.setLayoutY(150);

        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(150);
        passwordField.setLayoutY(150);

        Label txtCad = new Label("Não tem uma conta? Se cadastre.");
        txtCad.setLayoutX(50);
        txtCad.setLayoutY(195);

        Button loginButton = new Button("Login");
        loginButton.setLayoutX(50);
        loginButton.setLayoutY(225);
        
        // Adicione todos os componentes ao pane
        pane.getChildren().addAll(userLabel, userField, passwordLabel, passwordField, loginButton, txtCad);
        
    }
    
}
