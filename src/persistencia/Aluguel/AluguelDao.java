package persistencia.Aluguel;

import modelo.Aluguel;
import modelo.Telefone;
import java.util.List;

public interface AluguelDao {
    public void insert(Aluguel a) throws AluguelException;
    public void update(Aluguel a) throws AluguelException;
    public void delete(Aluguel a) throws AluguelException;
    public List<Aluguel> pesquisarPor(int id) throws AluguelException;
}
