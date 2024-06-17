package persistencia.pessoa;

import modelo.Pessoa;

import java.util.List;

public interface PessoaDao<T>{
    public void insert(T t) throws PessoaException;
    public void update(T t) throws PessoaException;
    public void delete(String cpf) throws PessoaException;
    public List<T> pesquisarTodos() throws PessoaException;
    public List<T> pesquisarPor(String cpf) throws PessoaException;
}
