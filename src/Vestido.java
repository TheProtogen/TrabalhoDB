public class Vestido {
    
    public int id;
    public int tamanho;
    public String cor;
    public String marca;
    public String finalidade;
    public double valor;

    public Vestido(int id, int tamanho, String cor, String marca, String finalidade, double valor) {
        this.id = id;
        this.tamanho = tamanho;
        this.cor = cor;
        this.marca = marca;
        this.finalidade = finalidade;
        this.valor = valor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    

}
