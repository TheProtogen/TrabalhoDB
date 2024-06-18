package control;

import javafx.scene.layout.Pane;
import utils.CenaNome;
import view.HomePageBoundary;
import view.HomePageFuncBoundary;
import view.TelaInterface;

public class MudarTela {

    public CenaNome nomes;

    public void mudarCena(Pane pane, CenaNome nome) {
        pane.getChildren().clear();
        
        HomePageBoundary homeCliente;
        HomePageFuncBoundary homeFunc;

        switch (nome) {
            case HOMEPAGE:
                homeCliente = new HomePageBoundary();
                homeCliente.montarTela(pane);
                break;
            case HOMEPAGE_FUNC:
                homeFunc = new HomePageFuncBoundary();
                homeFunc.montarTela(pane);
                break;
        }
    }
}
