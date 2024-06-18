

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.LoginBoundary;

public class App extends Application {

  private Pane pane;
  private Scene scene;
  private Stage stage;
  private LoginBoundary login = new LoginBoundary();

    @Override
    public void start(Stage primaryStage) {
		  stage = primaryStage;

        pane = new Pane();
        pane.setPrefWidth(700);
        pane.setPrefHeight(500);

        login.montarTela(pane, "0");

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
