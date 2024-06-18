package view;

import control.CtrlCadastro;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import modelo.Cliente;
import persistencia.pessoa.PessoaException;

public class CadastroClienteBoundary implements TelaInterface {

    private Label titulo = new Label("Cadastro de Cliente");

    private Label cpfL = new Label("CPF");
    private Label nome = new Label("Nome");
    private Label sobrenome = new Label("Sobrenome");
    private Label email = new Label("Email");
    private Label cep = new Label("CEP");
    private Label numero = new Label("Numero");
    private Label logradouro = new Label("Logradouro");
    private Label complement = new Label("Complemento");
    private Label senha = new Label("Senha");

    private TextField cpftxt = new TextField();
    private TextField nometxt = new TextField();
    private TextField sobrenometxt = new TextField();
    private TextField emailtxt = new TextField();
    private TextField ceptxt = new TextField();
    private TextField numerotxt = new TextField();
    private TextField logradourotxt = new TextField();
    private TextField complementtxt = new TextField();
    private TextField senhatxt = new TextField();

    private Button btnCadastrar = new Button("Cadastrar");
    private Button btnVoltar = new Button("Voltar");

    private CtrlCadastro ctr = new CtrlCadastro();
    private Cliente c = new Cliente();

    @Override
    public void montarTela(Pane pane, String cpf) {
        //Labels
        titulo.setLayoutX(52);
        titulo.setLayoutY(40);

        cpfL.setLayoutX(77);
        cpfL.setLayoutY(127);

        nome.setLayoutX(77);
        nome.setLayoutY(192);

        sobrenome.setLayoutX(77);
        sobrenome.setLayoutY(252);

        email.setLayoutX(77);
        email.setLayoutY(312);

        cep.setLayoutX(394);
        cep.setLayoutY(127);

        numero.setLayoutX(394);
        numero.setLayoutY(192);

        logradouro.setLayoutX(394);
        logradouro.setLayoutY(252);

        complement.setLayoutX(394);
        complement.setLayoutY(312);

        senha.setLayoutX(77);
        senha.setLayoutY(450);

        //TextFields

        cpftxt.setLayoutX(179);
        cpftxt.setLayoutY(125);

        nometxt.setLayoutX(179);
        nometxt.setLayoutY(190);

        sobrenometxt.setLayoutX(179);
        sobrenometxt.setLayoutY(250);

        emailtxt.setLayoutX(179);
        emailtxt.setLayoutY(310);

        ceptxt.setLayoutX(496);
        ceptxt.setLayoutY(125);

        numerotxt.setLayoutX(496);
        numerotxt.setLayoutY(190);

        logradourotxt.setLayoutX(496);
        logradourotxt.setLayoutY(250);

        complementtxt.setLayoutX(496);
        complementtxt.setLayoutY(310);

        senhatxt.setLayoutX(179);
        senhatxt.setLayoutY(450);

        HBox vbox = new HBox(btnCadastrar,btnVoltar);
        vbox.setSpacing(50);
        vbox.setLayoutY(400);
        vbox.setLayoutX(300);

        btnCadastrar.setOnAction(e -> {
            c.setCpf(cpftxt.getText());
            c.setSenha(senhatxt.getText());
            c.setNome(nometxt.getText());
            c.setSobrenome(sobrenometxt.getText());
            c.setEndCep(ceptxt.getText());
            c.setEndLog(logradourotxt.getText());
            c.setEndNum(numerotxt.getText());
            c.setEndComplemento(complementtxt.getText());
            c.setEmail(emailtxt.getText());

            try {
                ctr.cadastrar(c);
            } catch (PessoaException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        pane.getChildren().addAll(titulo,cpfL,nome,sobrenome,email,cep,numero,logradouro,complement);
        pane.getChildren().addAll(cpftxt,nometxt,sobrenometxt,emailtxt,ceptxt,numerotxt,logradourotxt,complementtxt,vbox);
    }
    
}
