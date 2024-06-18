package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import control.MudarTela;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import persistencia.DBconnectionTest;
import utils.CenaNome;

public class HomePageBoundary implements TelaInterface{

    private MudarTela mudarTela = new MudarTela();
    private Label homepageLabel = new Label();
    private Label saudacao = new Label();
    private Button buscarVestidos = new Button("Buscar vestidos");
    private Button consultarAlugueis = new Button("Consultar aluguéis");
    private VBox box = new VBox();
    private Hyperlink hyperLinkDeslogar;
    DBconnectionTest con = new DBconnectionTest();
    
    @Override
    public void montarTela(Pane pane, String cpf) {
        homepageLabel.setLayoutX(38);
        homepageLabel.setLayoutY(50);
        homepageLabel.setText("Homepage cliente");

        saudacao.setLayoutX(38);
        saudacao.setLayoutY(80);

        //select aqui
        saudacao.setText("Olá "+sqlGetNome(cpf));

        hyperLinkDeslogar = new Hyperlink("Deslogar");

        hyperLinkDeslogar.setLayoutX(558);
        hyperLinkDeslogar.setLayoutY(42);

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

        pane.getChildren().addAll(homepageLabel,saudacao,box, hyperLinkDeslogar);

        buscarVestidos.setOnAction(e -> buscarVestidosAction(pane));
        consultarAlugueis.setOnAction(e -> consultarAlugueisAction(pane, cpf));
        hyperLinkDeslogar.setOnAction(e -> deslogar(pane, cpf));
    }

    

    public void buscarVestidosAction(Pane pane) {
        mudarTela.mudarCena(pane, "0",CenaNome.BUSCAR_VESTIDO);
    }

    public void consultarAlugueisAction (Pane pane, String cpf) {
        mudarTela.mudarCena(pane, cpf, CenaNome.CONSULTAR_ALUGEL);
    }

    public void deslogar (Pane pane, String cpf) {
        mudarTela.mudarCena(pane, cpf, CenaNome.LOGIN);
    }
    
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
