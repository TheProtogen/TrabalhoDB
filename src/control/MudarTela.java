package control;

import javafx.scene.layout.Pane;
import utils.CenaNome;
import view.BuscarVestidoBoundary;
import view.CadastroClienteBoundary;
import view.HomePageBoundary;
import view.HomePageFuncBoundary;
import view.LoginBoundary;
import view.ManterClienteBoundary;
import view.ManterFuncionario;
import view.ManterVestidoBoundary;
import view.TelaInterface;

public class MudarTela {

    public CenaNome nomes;

    public void mudarCena(Pane pane, String cpf ,CenaNome nome) {
        pane.getChildren().clear();
        
        LoginBoundary login;

        HomePageBoundary homeCliente;
        HomePageFuncBoundary homeFunc;

        ManterVestidoBoundary manterVestido;
        ManterClienteBoundary manterCliente;
        ManterFuncionario manterFunc;

        CadastroClienteBoundary cadastroC;

        BuscarVestidoBoundary buscarVestido;


        switch (nome) {
            case LOGIN:
                login = new LoginBoundary();
                login.montarTela(pane, cpf);
                break;
            case HOMEPAGE:
                homeCliente = new HomePageBoundary();
                homeCliente.montarTela(pane, cpf);
                break;
            case HOMEPAGE_FUNC:
                homeFunc = new HomePageFuncBoundary();
                homeFunc.montarTela(pane, cpf);
                break;
            case MANTER_VESTIDO:
                manterVestido = new ManterVestidoBoundary();
                manterVestido.montarTela(pane, cpf);
                break;
            case MANTER_CLIENTE:
                manterCliente = new ManterClienteBoundary();
                manterCliente.montarTela(pane, cpf);
                break;
            case CADASTRO_CLIENTE:
                cadastroC = new CadastroClienteBoundary();
                cadastroC.montarTela(pane, cpf);
                break;
            case MANTER_FUNC:
                manterFunc = new ManterFuncionario();
                manterFunc.montarTela(pane, cpf);
                break;
            case BUSCAR_VESTIDO:
                buscarVestido = new BuscarVestidoBoundary();
                buscarVestido.montarTela(pane, cpf);
                break;
            default:
                break;
        }
    }
}
