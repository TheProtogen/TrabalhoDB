package persistencia.Aluguel.Pagamento;

import modelo.Pagamento;

import java.util.List;

public interface PagamentoDao {
    public void insert(Pagamento p) throws PagamentoException;
    public void delete(int id) throws PagamentoException;
    public List<Pagamento> pesquisarTodos() throws PagamentoException;
    public List<Pagamento> pesquisarPor(int id) throws PagamentoException;

}
