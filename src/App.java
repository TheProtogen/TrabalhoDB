import java.sql.Connection;

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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import view.LoginConstrutor;

public class App extends Application {

    private Stage stage;
    private Scene scene;
    private static Pane pane;

    private static LoginConstrutor login = new LoginConstrutor();

    @Override
    public void start(Stage primaryStage) {
		stage = primaryStage;


		pane = new Pane();
		pane.setPrefWidth(640);
		pane.setPrefHeight(400);
		
		login.montarTela(pane);
		
		scene = new Scene(pane);
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Teste");
		stage.show();
    }

    public static void main(String[] args) throws Exception {
        App.launch(args);
    }
}



/* ================================ A FAZER ================================
Fazer bind
Fazer tela : Gravar | Pesquisar | Atualizar | Deletar
Fazer os MVC
*/
