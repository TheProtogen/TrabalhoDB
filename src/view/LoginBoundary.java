package view;

import control.LoginControle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class LoginBoundary implements TelaInterface {

    private Pane pLogin;
    private LoginControle ctr = new LoginControle();
    private Label avisoLabel = new Label();

    @Override
    public void montarTela(Pane pane) {
        Label cpfLabel = new Label("CPF:");
        cpfLabel.setLayoutX(50);
        cpfLabel.setLayoutY(100);

        TextField cpfField = new TextField();
        cpfField.setLayoutX(150);
        cpfField.setLayoutY(100);

        Label senhaLabel = new Label("Senha:");
        senhaLabel.setLayoutX(50);
        senhaLabel.setLayoutY(150);

        PasswordField senhaField = new PasswordField();
        senhaField.setLayoutX(150);
        senhaField.setLayoutY(150);

        Label txtCad = new Label("Não tem uma conta? Se cadastre.");
        txtCad.setLayoutX(50);
        txtCad.setLayoutY(195);

        Button loginButton = new Button("Login");
        loginButton.setLayoutX(50);
        loginButton.setLayoutY(225);

        avisoLabel.setVisible(false);
        avisoLabel.setLayoutX(50);
        avisoLabel.setLayoutY(265);
        
        // Adicione todos os componentes ao pane
        pane.getChildren().addAll(cpfLabel, cpfField, senhaLabel, senhaField, loginButton, txtCad, avisoLabel);
        
        loginButton.setOnAction(e -> logar(cpfField, senhaField));
    }

    private void logar(TextField cpf, PasswordField senha) {
        System.out.println(cpf.getText() + " | " + senha.getText());

        if (ctr.login(cpf.getText(), senha.getText())) {
            /* 
             * TODO
             * ir pra pagina principal caso isso funciona [ ], se não, mandar mensagem de erro [X]
             * verificar se é funcionario e mandar pra outra pagina []
             */
            System.out.println("Usuário existe, mudando para home page");
            
        } else {
            avisoLabel.setText("Usuário não encontrado!");
            avisoLabel.setVisible(true);
            
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> avisoLabel.setVisible(false)));
            timeline.setCycleCount(1);
            timeline.play();
        }
    }
    
}
