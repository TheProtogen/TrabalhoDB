package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HomePageBoundary implements TelaInterface{

    private Label homepageLabel = new Label();
    private Label saudacao = new Label();
    private Button buscarVestidos = new Button("Buscar vestidos");
    private Button consultarAlugueis = new Button("Consultar aluguéis");
    private VBox box = new VBox();
    
    @Override
    public void montarTela(Pane pane) {
        homepageLabel.setLayoutX(38);
        homepageLabel.setLayoutY(50);
        homepageLabel.setText("Homepage cliente");

        saudacao.setLayoutX(38);
        saudacao.setLayoutY(80);

        //select aqui
        saudacao.setText("Olá");

        buscarVestidos.setPrefWidth(170);
        buscarVestidos.setPrefHeight(60);

        consultarAlugueis.setPrefWidth(170);
        consultarAlugueis.setPrefHeight(60);
        
        box.setLayoutX(478);
        box.setLayoutY(180);
        box.getChildren().addAll(buscarVestidos,consultarAlugueis);
        box.setSpacing(10);
        box.setMinWidth(200);
        box.setMinHeight(300);
        box.setStyle("-fx-border-color: black; -fx-border-width: 1;");
        box.setAlignment(Pos.CENTER);

        pane.getChildren().addAll(homepageLabel,saudacao,box);
    }
}
