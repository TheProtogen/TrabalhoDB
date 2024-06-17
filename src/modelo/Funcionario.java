package modelo;

public class Funcionario extends Pessoa{

    public double salario;

//    public Funcionario(int cpf, String senha, String nome, String sobrenome, String endCep, String endLog,
//            String endNum, String endComplemento, double salario) {
//        super(cpf, senha, nome, sobrenome, endCep, endLog, endNum, endComplemento);
//        this.salario = salario;
//    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
