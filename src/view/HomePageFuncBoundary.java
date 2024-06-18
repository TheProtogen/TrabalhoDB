package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HomePageFuncBoundary implements TelaInterface {
    
    private Label homepageLabel = new Label();
    private Label saudacao = new Label();
    private Button manterAluguel = new Button("Manter Aluguel");
    private Button manterCliente = new Button("Manter Cliente");
    private Button manterFunc = new Button("Manter Funcionario");
    private Button manterVestido = new Button("Manter Vestido");
    private VBox box = new VBox();
    
    @Override
    public void montarTela(Pane pane) {
        homepageLabel.setLayoutX(38);
        homepageLabel.setLayoutY(50);
        homepageLabel.setText("Homepage funcionário");

        saudacao.setLayoutX(38);
        saudacao.setLayoutY(80);
        
        //select aqui
        saudacao.setText("Olá ");

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

        pane.getChildren().addAll(homepageLabel,saudacao,box);
    }
    
}
