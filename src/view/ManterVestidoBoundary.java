package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ManterVestidoBoundary implements TelaInterface {

    private Label titulo = new Label("Manter vestido");
    private Label marca = new Label("Marca");
    private Label cor = new Label("Cor");
    private Label tamanho = new Label("Tamanho");
    private Label valor = new Label("Valor");
    private Label finalidade = new Label("Finalidade");

    private TextField marcaTxt = new TextField();
    private TextField corTxt = new TextField();
    private TextField tamanhoTxt = new TextField();
    private TextField valorTxt = new TextField();
    private TextField finalidadeTxt = new TextField();

    private Button btnAtualizar = new Button("Atualizar");
    private Button btnExcluir = new Button("Excluir");
    private Button btnVoltar = new Button("Voltar");


    @Override
    public void montarTela(Pane pane, String cpf) {
        titulo.setLayoutX(55);
        titulo.setLayoutY(25);

        marca.setLayoutX(72);
        marca.setLayoutY(88);

        cor.setLayoutX(72);
        cor.setLayoutY(176);

        tamanho.setLayoutX(72);
        tamanho.setLayoutY(255);

        valor.setLayoutX(392);
        valor.setLayoutY(88);

        finalidade.setLayoutX(392);
        finalidade.setLayoutY(193);

        marcaTxt.setLayoutX(72);
        marcaTxt.setLayoutY(122);

        corTxt.setLayoutX(72);
        corTxt.setLayoutY(210);

        tamanhoTxt.setLayoutX(72);
        tamanhoTxt.setLayoutY(289);

        valorTxt.setLayoutX(392);
        valorTxt.setLayoutY(122);

        finalidadeTxt.setLayoutX(392);
        finalidadeTxt.setLayoutY(228);

        HBox hbox = new HBox(btnAtualizar,btnExcluir,btnVoltar);
        hbox.setLayoutY(397);
        hbox.setLayoutX(350);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(50);

        pane.getChildren().addAll(titulo,marca,cor,tamanho,valor,finalidade);
        pane.getChildren().addAll(marcaTxt,corTxt,tamanhoTxt,valorTxt,finalidadeTxt);
        pane.getChildren().addAll(hbox);
        
    }
    
}
