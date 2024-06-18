package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import control.MudarTela;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import persistencia.DBconnectionTest;
import utils.CenaNome;

public class HomePageFuncBoundary implements TelaInterface {
    
    private Label homepageLabel = new Label();
    private Label saudacao = new Label();
    private Button manterAluguel = new Button("Manter Aluguel");
    private Button manterCliente = new Button("Manter Cliente");
    private Button manterFunc = new Button("Manter Funcionario");
    private Button manterVestido = new Button("Manter Vestido");
    private VBox box = new VBox();
    private DBconnectionTest con = new DBconnectionTest();
    private MudarTela mudarTela = new MudarTela();
    
    @Override
    public void montarTela(Pane pane, String cpf) {
        homepageLabel.setLayoutX(38);
        homepageLabel.setLayoutY(50);
        homepageLabel.setText("Homepage funcionário");

        saudacao.setLayoutX(38);
        saudacao.setLayoutY(80);
        
        //select aqui
        saudacao.setText("Olá "+sqlGetNome(cpf));

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

        manterVestido.setOnAction(e -> manterVestidoAction(pane, cpf));

        pane.getChildren().addAll(homepageLabel,saudacao,box);
    }

    public void manterVestidoAction (Pane pane, String cpf) {
        mudarTela.mudarCena(pane, cpf, CenaNome.MANTER_VESTIDO);
    }

    public void manterClienteAction (Pane pane, String cpf) {
        mudarTela.mudarCena(pane, cpf, CenaNome.MANTER_CLIENTE);
    }

    //add outros botoes

    private String sqlGetNome(String cpf) {
        Connection c = con.getConnection();

        String sql = "SELECT nome FROM pessoa "+
        "WHERE cpf = ?";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();

            rs.next();

		    String result = rs.getString("nome");

            System.out.println(result);

            
            rs.close();
		    ps.close();
		    c.close();
		    return result;

        } catch (Exception e) {
            return "ERRO AO ENCONTRAR CLIENTE";
        }
    }
    
}
