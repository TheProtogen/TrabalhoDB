package control;

import modelo.Cliente;
import persistencia.pessoa.PessoaException;
import persistencia.pessoa.cliente.ClienteDaoImp;

public class CtrlCadastro {

    ClienteDaoImp cDao;

    public Cliente clienteCriador(String cpf, String senha, String nome, String sobrenome, String endCep, String endLog, String endNum,
    String endComplemento, String email) {
        Cliente c = new Cliente();
        c.setCpf(cpf);
        c.setSenha(senha);
        c.setNome(sobrenome);
        c.setSobrenome(sobrenome);
        c.setEndCep(endCep);
        c.setEndLog(endLog);
        c.setEndNum(endNum);
        c.setEndComplemento(endComplemento);
        c.setEmail(email);
        return c;
    }

    public void cadastrar(Cliente c) throws PessoaException {
        cDao = new ClienteDaoImp();

        cDao.insert(c);
    }
}
