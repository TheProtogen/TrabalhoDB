import javax.tools.Tool;

import javafx.application.Application;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class App extends Application {


    public static void main(String[] args) throws Exception {
        App.launch(args);
    }

    

    public void start(Stage stage) {
        GridPane panePrincipal = new GridPane();
        panePrincipal.setStyle("-fx-background-color: #2F3C7E");
        panePrincipal.setPadding(new Insets(10, 10, 10, 10));

        panePrincipal.setVgap(5); 
        panePrincipal.setHgap(5);

        panePrincipal.setAlignment(Pos.CENTER);

        
        Scene scn = new Scene( panePrincipal, 800, 600);

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


        //panePrincipal.add(new FlowPane(btnGravar, btnPesquisar,btnAtualizar,btnDelete), 0,0);

        
        panePrincipal.add(btnPesquisar, 1, 1);
        panePrincipal.add(btnGravar, 2, 1);
        panePrincipal.add(btnAtualizar, 3, 1);
        panePrincipal.add(btnDeletar, 4, 1);
        

        stage.setScene(scn);
        stage.setTitle("Controle de aluguel");
        //stage.setResizable(false);
        stage.show();
    }

}
