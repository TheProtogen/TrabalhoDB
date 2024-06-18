package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Funcionario;
import persistencia.pessoa.PessoaException;

import java.io.IOException;

import control.CtrlManterFuncionario;

public class ManterFuncionario implements TelaInterface {
    private Label lblTitulo = new Label();
    private Label lblCpf = new Label();
    private Label lblNome = new Label();
    private Label lblSobrenome = new Label();
    private Label lblSalario = new Label();
    private Label lblCep = new Label();
    private Label lblNumero = new Label();
    private Label lblLogradouro = new Label();
    private Label lblComplemento = new Label();

    private TextField txtCpf = new TextField("");
    private TextField txtNome = new TextField("");
    private TextField txtSobrenome = new TextField("");
    private TextField txtSalario = new TextField("");
    private TextField txtCep = new TextField("");
    private TextField txtNumero = new TextField("");
    private TextField txtLogradouro = new TextField("");
    private TextField txtComplemento = new TextField("");

    private Button btnCadastrar = new Button("Cadastrar");
    private Button btnAtualizar = new Button("Atualizar");
    private Button btnExcluir = new Button("Excluir");
    private Button btnVoltar = new Button("Voltar");

    private CtrlManterFuncionario ctr;
    private Funcionario f;

    @Override
    public void montarTela(Pane pane, String cpf)  {

        try {
            ctr = new CtrlManterFuncionario();
        } catch (PessoaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        lblTitulo.setLayoutX(50);
        lblTitulo.setLayoutY(40);
        lblTitulo.setText("Manter Funcionario");

        lblCpf.setLayoutX(77);
        lblCpf.setLayoutY(127);
        lblCpf.setText("CPF");

        lblNome.setLayoutX(77);
        lblNome.setLayoutY(192);
        lblNome.setText("Nome");

        lblSobrenome.setLayoutX(77);
        lblSobrenome.setLayoutY(252);
        lblSobrenome.setText("Sobrenome");

        lblSalario.setLayoutX(77);
        lblSalario.setLayoutY(312);
        lblSalario.setText("Salario");

        lblCep.setLayoutX(394);
        lblCep.setLayoutY(127);
        lblCep.setText("CEP");

        lblNumero.setLayoutX(394);
        lblNumero.setLayoutY(192);
        lblNumero.setText("Numero");

        lblLogradouro.setLayoutX(394);
        lblLogradouro.setLayoutY(252);
        lblLogradouro.setText("Logradouro");

        lblComplemento.setLayoutX(394);
        lblComplemento.setLayoutY(312);
        lblComplemento.setText("Complemento");


        txtCpf.setLayoutX(180);
        txtCpf.setLayoutY(125);

        txtNome.setLayoutX(180);
        txtNome.setLayoutY(190);

        txtSobrenome.setLayoutX(180);
        txtSobrenome.setLayoutY(250);

        txtSalario.setLayoutX(180);
        txtSalario.setLayoutY(310);

        txtCep.setLayoutX(496);
        txtCep.setLayoutY(125);

        txtNumero.setLayoutX(496);
        txtNumero.setLayoutY(190);

        txtLogradouro.setLayoutX(496);
        txtLogradouro.setLayoutY(250);

        txtComplemento.setLayoutX(496);
        txtComplemento.setLayoutY(310);


        btnCadastrar.setPrefWidth(130);
        btnCadastrar.setPrefHeight(45);
        btnCadastrar.setLayoutX(40);
        btnCadastrar.setLayoutY(430);

        btnAtualizar.setPrefWidth(130);
        btnAtualizar.setPrefHeight(45);
        btnAtualizar.setLayoutX(200);
        btnAtualizar.setLayoutY(430);

        btnExcluir.setPrefWidth(130);
        btnExcluir.setPrefHeight(45);
        btnExcluir.setLayoutX(365);
        btnExcluir.setLayoutY(430);

        btnVoltar.setPrefWidth(130);
        btnVoltar.setPrefHeight(45);
        btnVoltar.setLayoutX(525);
        btnVoltar.setLayoutY(430);

        btnCadastrar.setOnAction(e -> { try {
            ctr.cadastrar(criarFunc());
        } catch (PessoaException e1) {
            e1.printStackTrace();
        } });

        btnAtualizar.setOnAction(e -> { try {
            ctr.atualizar(criarFunc());
        } catch (PessoaException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } });

        btnExcluir.setOnAction(e -> { try {
            ctr.excluir(txtCpf.getText());
        } catch (PessoaException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } });

        pane.getChildren().addAll
                (lblTitulo, lblCpf, lblNome, lblSobrenome, lblSalario, lblCep, lblNumero, lblLogradouro, lblComplemento,
                        txtCpf, txtNome, txtSobrenome, txtSalario, txtCep, txtNumero, txtLogradouro, txtComplemento,
                        btnCadastrar, btnAtualizar, btnExcluir, btnVoltar);

    }

    public Funcionario criarFunc() {
        f = new Funcionario();
        f.setCpf(txtCpf.getText());
        f.setNome(txtNome.getText());
        f.setSobrenome(txtSobrenome.getText());
        f.setSalario(Double.parseDouble(txtSalario.getText()));
        f.setEndCep(txtCep.getText());
        f.setEndNum(txtNumero.getText());
        f.setEndLog(txtLogradouro.getText());
        f.setEndComplemento(txtComplemento.getText());

        return f;
    }

}
