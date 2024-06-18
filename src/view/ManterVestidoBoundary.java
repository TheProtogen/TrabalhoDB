package view;

import control.CtrlManterVestido;
import control.MudarTela;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import modelo.Vestido;
import persistencia.vestido.VestidoDaoImp;
import persistencia.vestido.VestidoException;
import utils.CenaNome;

public class ManterVestidoBoundary implements TelaInterface {

    private Label titulo = new Label("Manter vestido");

    private Label id = new Label("Id");
    private Label marca = new Label("Marca");
    private Label cor = new Label("Cor");
    private Label tamanho = new Label("Tamanho");
    private Label valor = new Label("Valor");
    private Label finalidade = new Label("Finalidade");
    private Label disp = new Label("Disponivel");

    private TextField idTxt = new TextField();
    private TextField marcaTxt = new TextField();
    private TextField corTxt = new TextField();
    private TextField tamanhoTxt = new TextField();
    private TextField valorTxt = new TextField();
    private TextField finalidadeTxt = new TextField();
    private TextField dispTxt = new TextField();

    private Button btnAtualizar = new Button("Atualizar");
    private Button btnExcluir = new Button("Excluir");
    private Button btnVoltar = new Button("Voltar");
    private Button checkar = new Button("Check");

    private Vestido v = new Vestido();

    private CtrlManterVestido ctr;
    private MudarTela mudarTela = new MudarTela();

    @Override
    public void montarTela(Pane pane, String cpf) {
        try {
            ctr = new CtrlManterVestido();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        titulo.setLayoutX(55);
        titulo.setLayoutY(25);

        id.setLayoutX(375);
        id.setLayoutY(31);

        marca.setLayoutX(72);
        marca.setLayoutY(88);

        cor.setLayoutX(72);
        cor.setLayoutY(176);

        tamanho.setLayoutX(72);
        tamanho.setLayoutY(255);

        valor.setLayoutX(392);
        valor.setLayoutY(88);

        finalidade.setLayoutX(392);
        finalidade.setLayoutY(176);

        disp.setLayoutX(392);
        disp.setLayoutY(255);

        //-----------

        idTxt.setLayoutX(454);
        idTxt.setLayoutY(30);

        marcaTxt.setLayoutX(72);
        marcaTxt.setLayoutY(122);

        corTxt.setLayoutX(72);
        corTxt.setLayoutY(210);

        tamanhoTxt.setLayoutX(72);
        tamanhoTxt.setLayoutY(289);

        valorTxt.setLayoutX(392);
        valorTxt.setLayoutY(122);

        finalidadeTxt.setLayoutX(392);
        finalidadeTxt.setLayoutY(210);

        dispTxt.setLayoutX(392);
        dispTxt.setLayoutY(289);

        HBox hbox = new HBox(checkar,btnAtualizar,btnExcluir,btnVoltar);
        hbox.setLayoutY(397);
        hbox.setLayoutX(250);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(50);

        checkar.setOnAction(e -> {
        v = ctr.construirVestido(
            Integer.parseInt(idTxt.getText()),
            Integer.parseInt(tamanhoTxt.getText()),
            corTxt.getText(),
            marcaTxt.getText(),
            finalidadeTxt.getText(),
            Boolean.parseBoolean(dispTxt.getText()),
            Double.parseDouble(valorTxt.getText())
        ); } );
        

        btnAtualizar.setOnAction(e -> {
            try {
                ctr.atualizar(v);
            } catch (VestidoException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        btnExcluir.setOnAction(e -> {
            try {
                ctr.excluir(v.id);
            } catch (NumberFormatException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (VestidoException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        btnVoltar.setOnAction(e -> {mudarTela.mudarCena(pane, cpf, CenaNome.HOMEPAGE_FUNC);});
        

        pane.getChildren().addAll(titulo,marca,cor,tamanho,valor,finalidade,id,disp);
        pane.getChildren().addAll(marcaTxt,corTxt,tamanhoTxt,valorTxt,finalidadeTxt,idTxt,dispTxt);
        pane.getChildren().addAll(hbox);


    }


    
}
