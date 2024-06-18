package modelo;

import java.time.LocalDate;

public class Aluguel {
    private int id;
    private String clientePessoaCPF;
    private int vestidoID;
    private LocalDate data_retirada;
    private LocalDate data_devolucao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(LocalDate data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public String getClientePessoaCPF() {
        return clientePessoaCPF;
    }

    public void setClientePessoaCPF(String clientePessoaCPF) {
        this.clientePessoaCPF = clientePessoaCPF;
    }

    public int getVestidoID() {
        return vestidoID;
    }

    public void setVestidoID(int vestidoID) {
        this.vestidoID = vestidoID;
    }

    public LocalDate getData_retirada() {
        return data_retirada;
    }

    public void setData_retirada(LocalDate data_retirada) {
        this.data_retirada = data_retirada;
    }
}
