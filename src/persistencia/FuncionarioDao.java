package persistencia;

import modelo.Funcionario;

import java.util.List;

public interface FuncionarioDao {

    public void insert(Funcionario f) throws FuncionarioException;
    public int update(Funcionario f) throws FuncionarioException;
    public void delete(long id) throws FuncionarioException;
    public List<Funcionario> pesquisarTodos(Funcionario f) throws FuncionarioException;
    public List<Funcionario> findAll(Funcionario f) throws FuncionarioException;
}
