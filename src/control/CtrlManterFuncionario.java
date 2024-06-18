package control;

import modelo.Funcionario;
import persistencia.pessoa.PessoaDao;
import persistencia.pessoa.PessoaException;
import persistencia.pessoa.funcionario.FuncionarioDaoImp;

public class CtrlManterFuncionario {

    private PessoaDao<Funcionario> funcionarioDao = null;
    private FuncionarioDaoImp daoImp = new FuncionarioDaoImp();

    public CtrlManterFuncionario() throws PessoaException {
        try {
            funcionarioDao = new FuncionarioDaoImp();
        } catch (Exception e) {
            throw new PessoaException(e);
        }
    }

    public void cadastrar(Funcionario funcionario) throws PessoaException {
        //Tem que colocar o funcionario
        daoImp.insert(funcionario);
    }

    public void atualizar(Funcionario funcionario) throws PessoaException {
        daoImp.update(funcionario);
    }

    public void excluir(String cpf) throws PessoaException {
        daoImp.delete(cpf);
    }
}
