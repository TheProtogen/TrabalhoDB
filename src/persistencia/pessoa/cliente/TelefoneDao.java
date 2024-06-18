package persistencia.pessoa.cliente;

import modelo.Telefone;

import java.util.List;

public interface TelefoneDao {
    public void insert(Telefone t) throws TelefoneException;
    public void update(Telefone t) throws TelefoneException;
    public void delete(String cpf) throws TelefoneException;
    public List<Telefone> pesquisarTodos() throws TelefoneException;
    public List<Telefone> pesquisarPor(String cpf) throws TelefoneException;
}
