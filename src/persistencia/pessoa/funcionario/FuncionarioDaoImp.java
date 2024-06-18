package persistencia.pessoa.funcionario;

import modelo.Funcionario;
import persistencia.DBconnectionTest;
import persistencia.pessoa.PessoaDao;
import persistencia.pessoa.PessoaException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDaoImp implements PessoaDao<Funcionario> {

    private DBconnectionTest dbConn = null;

    public FuncionarioDaoImp() throws PessoaException {
        try {
            dbConn = DBconnectionTest.getInstance();
        } catch (Exception e) {
            throw new PessoaException(e);
        }
    }


    @Override
    public void insert(Funcionario f) throws PessoaException {
        try{
            Connection con = dbConn.getConnection();
            // inserir na tabela pessoa
            String sqlPessoa = "INSERT INTO pessoa (cpf, senha, nome, sobrenome, end_cep, end_logradouro, end_numero, end_complemento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmPessoa = con.prepareStatement(sqlPessoa);
            pstmPessoa.setString(1, f.getCpf());
            pstmPessoa.setString(2, f.getSenha());
            pstmPessoa.setString(3, f.getNome());
            pstmPessoa.setString(4, f.getSobrenome());
            pstmPessoa.setString(5, f.getEndCep());
            pstmPessoa.setString(6, f.getEndLog());
            pstmPessoa.setString(7, f.getEndNum());
            pstmPessoa.setString(8, f.getEndComplemento());


            pstmPessoa.executeUpdate();

            // inserir na tabela funcionario
            String sqlFuncionario = "INSERT INTO funcionario (pessoaCPF, salario) VALUES (?, ?)";
            PreparedStatement pstmFuncionario = con.prepareStatement(sqlFuncionario);
            pstmFuncionario.setString(1, f.getCpf());
            pstmFuncionario.setDouble(2, f.getSalario());

            pstmFuncionario.executeUpdate();

            con.close();
        }catch (Exception e){
            throw new PessoaException(e);
        }


    }

    @Override
    public void update(Funcionario f) throws PessoaException {
        Connection con = null;
        PreparedStatement pstmPessoa = null;
        PreparedStatement pstmFuncionario = null;

        try {
            con = dbConn.getConnection();

            // Atualizar a tabela pessoa
            String sqlPessoa = """
            UPDATE pessoa SET senha = ?, nome = ?, sobrenome = ?, end_cep = ?, end_logradouro = ?, end_numero = ?, end_complemento = ?
            WHERE cpf = ?
            """;
            pstmPessoa = con.prepareStatement(sqlPessoa);
            pstmPessoa.setString(1, f.getSenha());
            pstmPessoa.setString(2, f.getNome());
            pstmPessoa.setString(3, f.getSobrenome());
            pstmPessoa.setString(4, f.getEndCep());
            pstmPessoa.setString(5, f.getEndLog());
            pstmPessoa.setString(6, f.getEndNum());
            pstmPessoa.setString(7, f.getEndComplemento());
            pstmPessoa.setString(8, f.getCpf());

            pstmPessoa.executeUpdate();

            // Atualizar a tabela funcionario
            String sqlFuncionario = """
            UPDATE funcionario SET salario = ?
            WHERE pessoaCPF = ?
            """;
            pstmFuncionario = con.prepareStatement(sqlFuncionario);
            pstmFuncionario.setDouble(1, f.getSalario());
            pstmFuncionario.setString(2, f.getCpf());

            pstmFuncionario.executeUpdate();
            con.close();
        } catch (Exception e) {
            throw new PessoaException(e);
        }
    }


    @Override
    public void delete(String cpf) throws PessoaException {
        Connection con = null;
        PreparedStatement pstmFuncionario = null;
        PreparedStatement pstmPessoa = null;

        try {
            con = dbConn.getConnection();
            con.setAutoCommit(false);

            String sqlFuncionario = "DELETE FROM funcionario WHERE pessoaCPF = ?";
            pstmFuncionario = con.prepareStatement(sqlFuncionario);
            pstmFuncionario.setString(1, cpf);
            pstmFuncionario.executeUpdate();

            String sqlPessoa = "DELETE FROM pessoa WHERE cpf = ?";
            pstmPessoa = con.prepareStatement(sqlPessoa);
            pstmPessoa.setString(1, cpf);
            pstmPessoa.executeUpdate();

            con.close();
        } catch (Exception e) {
            throw new PessoaException( e );
        }
    }


    @Override
    public List<Funcionario> pesquisarTodos() throws PessoaException {
        return pesquisarPor("");
    }

    @Override
    public List<Funcionario> pesquisarPor(String cpf) throws PessoaException {
        try{
            List<Funcionario> lista = new ArrayList<Funcionario>();
            Connection con = dbConn.getConnection();
            String sql = """
                    SELECT *
                    FROM funcionario f, pessoa p
                    WHERE f.pessoaCPF = p.cpf AND f.pessoaCPF = ?
                    """;
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, "%"+cpf+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Funcionario f = new Funcionario();
                
                f.setCpf(rs.getString("pessoaCPF"));
                f.setSalario(rs.getDouble("salario"));
                f.setSenha(rs.getString("senha"));
                f.setNome(rs.getString("nome"));
                f.setSobrenome(rs.getString("sobrenome"));
                f.setEndCep(rs.getString("end_cep"));
                f.setEndLog(rs.getString("end_logradouro"));
                f.setEndNum(rs.getString("end_numero"));
                f.setEndComplemento(rs.getString("end_complemento"));

                //Funcionario f = new Funcionario(cpf_novo, senha, nome, sobrenome, endCep, endLog, endNum, endComp, salario);

                lista.add(f);
            }
            con.close();
            return lista;
        }catch (Exception e){
            throw new PessoaException(e);
        }
    }
}
