package modelo;

public class Cliente extends Pessoa {

    public String email;

    public Cliente(int cpf, String senha, String nome, String sobrenome, String endCep, String endLog, String endNum,
            String endComplemento, String email) {
        super(cpf, senha, nome, sobrenome, endCep, endLog, endNum, endComplemento);
        this.email = email;
    }

    


}
