package persistencia.pessoa.cliente;

import modelo.Cliente;
import persistencia.pessoa.PessoaDao;
import persistencia.pessoa.PessoaException;

import java.util.List;

public class ClienteDaoImp implements PessoaDao<Cliente> {



    @Override
    public void insert(Cliente cliente) throws PessoaException {

    }

    @Override
    public void update(Cliente cliente) throws PessoaException {

    }

    @Override
    public void delete(String cpf) throws PessoaException {

    }

    @Override
    public List<Cliente> pesquisarTodos() throws PessoaException {
        return List.of();
    }

    @Override
    public List<Cliente> pesquisarPor(String cpf) throws PessoaException {
        return List.of();
    }
}
