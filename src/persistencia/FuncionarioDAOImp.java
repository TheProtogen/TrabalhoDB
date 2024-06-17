package persistencia;

import modelo.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class FuncionarioDAOImp implements FuncionarioDao {

    private DBconnectionTest dbConn = null;

    public FuncionarioDAOImp() throws FuncionarioException{
        try {
            dbConn = DBconnectionTest.getInstance();
        } catch (Exception e) {
            throw new FuncionarioException(e);
        }
    }


    @Override
    public void insert(Funcionario f) throws FuncionarioException {
        try{
            Connection con = dbConn.getConnection();
            String sql = """
                    INSERT INTO funcionario(pessoaCPF, senha, nome, sobrenome, endCep, endLog, endNum, endComplemento) VALUES (?, ?,?,?,?,?,?)
                    """;
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, f.getCpf());
            pstm.setString(2, f.getSenha());
            pstm.setString(3, f.getNome());
            pstm.setString(4, f.getSobrenome());
            pstm.setString(5, f.getEndCep());
            pstm.setString(6,f.getEndLog());
            pstm.setString(7,f.getEndNum());
            pstm.setString(8, f.getEndComplemento());

        }catch (Exception e){
            throw new FuncionarioException(e);
        }


    }

    @Override
    public int update(Funcionario f) throws FuncionarioException {
        try{
            Connection con = dbConn.getConnection();
            String sql = """
                    UPDATE funcionario SET cpf = ?, Senha = ?, nome = ?, sobrenome = ?, endCep = ?, endLog = ?,
                                                       endNum = ?, endComplemento = ?, salario = ?
                    WHERE cpf = ?
                    """;
            PreparedStatement pstm = con.prepareStatement(sql);
        }catch (Exception e){
            throw new FuncionarioException(e);
        }
        return 0;
    }

    @Override
    public List<Funcionario> pesquisarTodos(Funcionario f) throws FuncionarioException {




        return null;
    }

    @Override
    public List<Funcionario> findAll(Funcionario f) throws FuncionarioException {
        return null;
    }


    @Override
    public void delete(long id) throws FuncionarioException {
        try {
            Connection con = dbConn.getConnection();
            String sql = """
                DELETE FROM alunos WHERE id = ?)
            """;
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setLong(1, id);
            pstm.executeUpdate();
            con.close();
        } catch (Exception e) {
            throw new FuncionarioException( e );
        }
    }
}
