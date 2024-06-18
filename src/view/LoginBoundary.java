package view;

import control.LoginControle;
import control.MudarTela;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;
import utils.CenaNome;

public class LoginBoundary implements TelaInterface {

    private Pane pane;
    private LoginControle ctr = new LoginControle();
    private Label avisoLabel = new Label();
    MudarTela mudarTela = new MudarTela();

    @Override
    public void montarTela(Pane pane, String cpf) {
        this.pane = pane;

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

        Hyperlink hyper = new Hyperlink(" Se cadastre");
        TextFlow txtCad = new TextFlow(new Text("Não tem uma conta?"), hyper);
        txtCad.setLayoutX(50);
        txtCad.setLayoutY(195);

        Button loginButton = new Button("Login");
        loginButton.setLayoutX(50);
        loginButton.setLayoutY(225);

        avisoLabel.setVisible(false);
        avisoLabel.setLayoutX(50);
        avisoLabel.setLayoutY(265);
        
        loginButton.setOnAction(e -> logar(cpfField, senhaField, pane));
        hyper.setOnAction(e -> mudarTela.mudarCena(pane, cpf, CenaNome.CADASTRO_CLIENTE));

        // Adicione todos os componentes ao pane
        pane.getChildren().addAll(cpfLabel, cpfField, senhaLabel, senhaField, loginButton, txtCad, avisoLabel);
    }

    private void logar(TextField cpf, PasswordField senha, Pane pane) {
        System.out.println(cpf.getText() + " | " + senha.getText());

        if (ctr.login(cpf.getText(), senha.getText())) {
            System.out.println("Usuário existe, mudando para home page");

            if (ctr.checkFuncionario(cpf.getText())) { mudarTela.mudarCena(pane, cpf.getText(), CenaNome.HOMEPAGE_FUNC); }
            else { mudarTela.mudarCena(pane, cpf.getText(), CenaNome.HOMEPAGE); }
        } else {
            avisoLabel.setText("Usuário não encontrado!");
            avisoLabel.setVisible(true);
            
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> avisoLabel.setVisible(false)));
            timeline.setCycleCount(1);
            timeline.play();
        }
    }
    
}
