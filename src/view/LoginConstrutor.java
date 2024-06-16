package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class LoginConstrutor implements TelaInterface {

    private Pane pLogin;

    @Override
    public void montarTela(Pane pane) {
        pane = new GridPane();
        pane.setStyle("-fx-background-color: #2F3C7E");
        pane.setPadding(new Insets(10, 10, 10, 10));

        Button btnGravar = new Button("Gravar");
        Button btnPesquisar = new Button("Pesquisar");
        Button btnAtualizar = new Button("Atualizar");
        Button btnDeletar = new Button("Deletar");

        btnGravar.setPrefWidth(150);
        btnPesquisar.setPrefWidth(150);
        btnAtualizar.setPrefWidth(150);
        btnDeletar.setPrefWidth(150);
    
        btnGravar.setStyle("-fx-font-size: 20pt;");
        btnPesquisar.setStyle("-fx-font-size: 20pt;");
        btnAtualizar.setStyle("-fx-font-size: 20pt;");
        btnDeletar.setStyle("-fx-font-size: 20pt;");

        //pane.add(new FlowPane(btnGravar, btnPesquisar,btnAtualizar,btnDelete), 0,0);
        pane.getChildren().addAll(btnAtualizar);
        
    }
    
}
