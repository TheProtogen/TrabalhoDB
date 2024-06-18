package modelo;

import java.time.LocalDate;

public class Pagamento {
    private int aluguelId;
    private double total_pagar;
    private LocalDate data;
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getTotal_pagar() {
        return total_pagar;
    }

    public void setTotal_pagar(double total_pagar) {
        this.total_pagar = total_pagar;
    }

    public int getAluguelId() {
        return aluguelId;
    }

    public void setAluguelId(int aluguelId) {
        this.aluguelId = aluguelId;
    }
}
