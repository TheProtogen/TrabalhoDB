package modelo;

public class Pessoa {
    public String cpf;
    public String senha;
    public String nome;
    public String sobrenome;
    public String endCep;
    public String endLog;
    public String endNum;
    public String endComplemento;
    
    public Pessoa(String cpf, String senha, String nome, String sobrenome, 
    String endCep, String endLog, String endNum, String endComplemento) {

        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endCep = endCep;
        this.endLog = endLog;
        this.endNum = endNum;
        this.endComplemento = endComplemento;
        
    }
}
