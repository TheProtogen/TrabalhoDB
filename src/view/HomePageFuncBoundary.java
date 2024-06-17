package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class HomePageFuncBoundary implements TelaInterface {
    
    private Label homepageLabel;

    private Label saudacao;

    private Button manterAluguel;

    private Button manterCliente;

    private Button manterFunc;

    private Button manterVestido;
    
    private VBox box;
    
    private Pane pane1;
    
    @Override
    public void montarTela(Pane pane) {
        homepageLabel.setLayoutX(38);
        homepageLabel.setLayoutY(50);
        homepageLabel.setText("Homepage funcionário");

        saudacao.setLayoutX(38);
        saudacao.setLayoutY(80);
        homepageLabel.setText("Olá");

        manterVestido.setPrefWidth(170);
        manterVestido.setPrefHeight(60);

        manterAluguel.setPrefWidth(170);
        manterAluguel.setPrefHeight(60);

        manterCliente.setPrefWidth(170);
        manterCliente.setPrefHeight(60);

        manterFunc.setPrefWidth(170);
        manterFunc.setPrefHeight(60);
        
        box.setLayoutX(478);
        box.setLayoutY(228);
        box.getChildren().addAll(manterVestido,manterAluguel,manterCliente,manterFunc);

        pane1.getChildren().addAll(homepageLabel,saudacao,box);
    }
    
}
