package persistencia.vestido;

import modelo.Vestido;

import java.util.List;

public interface VestidoDao {
    public void insert(Vestido v) throws VestidoException;
    public void update(Vestido v) throws VestidoException;
    public void delete(int id) throws VestidoException;
    public List<Vestido> pesquisarTodos() throws VestidoException;
    public List<Vestido> pesquisarPor(String marca) throws VestidoException;
}
