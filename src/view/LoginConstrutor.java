package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class LoginConstrutor implements TelaInterface {

    private Pane pLogin;

    @Override
    public void montarTela(Pane pane) {
        Label userLabel = new Label("Usuário:");
        userLabel.setLayoutX(50);
        userLabel.setLayoutY(50);

        TextField userField = new TextField();
        userField.setLayoutX(150);
        userField.setLayoutY(50);

        Label passwordLabel = new Label("Senha:");
        passwordLabel.setLayoutX(50);
        passwordLabel.setLayoutY(100);

        TextField passwordField = new TextField();
        passwordField.setLayoutX(150);
        passwordField.setLayoutY(100);

        Button loginButton = new Button("Login");
        loginButton.setLayoutX(150);
        loginButton.setLayoutY(150);
        
        // Adicione todos os componentes ao pane
        pane.getChildren().addAll(userLabel, userField, passwordLabel, passwordField, loginButton);
        
    }
    
}
