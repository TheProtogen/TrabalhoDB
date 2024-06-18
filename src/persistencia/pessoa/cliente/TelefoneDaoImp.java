package persistencia.pessoa.cliente;

import modelo.Telefone;
import persistencia.pessoa.PessoaException;

import java.util.List;

public class TelefoneDaoImp {
    public void insert(Telefone t) throws PessoaException;
    public void update(Telefone t) throws PessoaException;
    public void delete(String cpf) throws PessoaException;
    public List<Telefone> pesquisarTodos() throws PessoaException;
    public List<Telefone> pesquisarPor(String cpf) throws PessoaException;
}
