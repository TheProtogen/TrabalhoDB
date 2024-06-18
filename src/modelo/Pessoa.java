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
    
    /* 
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
    */
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndCep() {
        return endCep;
    }

    public void setEndCep(String endCep) {
        this.endCep = endCep;
    }

    public String getEndLog() {
        return endLog;
    }

    public void setEndLog(String endLog) {
        this.endLog = endLog;
    }

    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
    }

    public String getEndComplemento() {
        return endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }
}
