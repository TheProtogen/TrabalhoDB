package persistencia.pessoa.cliente;

import modelo.Cliente;
import persistencia.DBconnectionTest;
import persistencia.pessoa.PessoaDao;
import persistencia.pessoa.PessoaException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClienteDaoImp implements PessoaDao<Cliente> {
    DBconnectionTest dbConn = null;

    public ClienteDaoImp() throws PessoaException {
        try{
            dbConn = DBconnectionTest.getInstance();
        }catch (Exception e){
            throw new PessoaException(e);
        }
    }

    @Override
    public void insert(Cliente c) throws PessoaException {
        try{
            Connection con = dbConn.getConnection();

            String sqlPessoa = "INSERT INTO pessoa (cpf, senha, nome, sobrenome, end_cep, end_logradouro, end_numero, end_complemento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmPessoa = con.prepareStatement(sqlPessoa);
            pstmPessoa.setString(1, c.getCpf());
            pstmPessoa.setString(2, c.getSenha());
            pstmPessoa.setString(3, c.getNome());
            pstmPessoa.setString(4, c.getSobrenome());
            pstmPessoa.setString(5, c.getEndCep());
            pstmPessoa.setString(6, c.getEndLog());
            pstmPessoa.setString(7, c.getEndNum());
            pstmPessoa.setString(8, c.getEndComplemento());

            pstmPessoa.executeUpdate();

            String sqlCliente = """
                    INSERT INTO cliente (pessoaCPF, email)
                    VALUES (?,?)""";
            PreparedStatement pmstCliente = con.prepareStatement(sqlCliente);
            pmstCliente.setString(1, c.getCpf());
            pmstCliente.setString(2, c.getEmail());

            pmstCliente.executeUpdate();
            con.close();
        }catch (Exception e){
            throw new PessoaException(e);
        }
    }

    @Override
    public void update(Cliente cliente) throws PessoaException {
        Connection con = null;
        PreparedStatement pstmCliente = null;
        PreparedStatement pstmPessoa = null;
        try{
            Cliente c = new Cliente();

            String sqlPessoa = """
            UPDATE pessoa SET senha = ?, nome = ?, sobrenome = ?, end_cep = ?, end_logradouro = ?, end_numero = ?, end_complemento = ?
            WHERE cpf = ?
        """;
            pstmPessoa = con.prepareStatement(sqlPessoa);
            pstmPessoa.setString(1, c.getSenha());
            pstmPessoa.setString(2, c.getNome());
            pstmPessoa.setString(3, c.getSobrenome());
            pstmPessoa.setString(4, c.getEndCep());
            pstmPessoa.setString(5, c.getEndLog());
            pstmPessoa.setString(6, c.getEndNum());
            pstmPessoa.setString(7, c.getEndComplemento());
            pstmPessoa.setString(8, c.getCpf());

            pstmPessoa.executeUpdate();

            String sql = """
                    UPDATE cliente
                    SET email = ?
                    WHERE pessoaCPF = ?""";
            pstmCliente.setString(1, c.getEmail());
            pstmCliente.setString(2, c.getCpf());

            pstmCliente.executeUpdate();

            con.close();
        }catch (Exception e){
            throw new PessoaException(e);
        }
    }

    @Override
    public void delete(String cpf) throws PessoaException {
        try{
            Connection con = dbConn.getConnection();

            String sqlPessoa = "DELETE FROM pessoa WHERE cpf = ?";
            PreparedStatement pstmPessoa = con.prepareStatement(sqlPessoa);
            pstmPessoa = con.prepareStatement(sqlPessoa);
            pstmPessoa.setString(1, cpf);
            pstmPessoa.executeUpdate();

            String sqlCliente = """
                    DELETE FROM cliente
                    WHERE pessoaCPF = ?""";
            PreparedStatement pstmCliente = con.prepareStatement(sqlCliente);
            pstmCliente.setString(1, cpf);

            pstmCliente.executeUpdate();
            con.close();
        }catch (Exception e){
            throw new PessoaException(e);
        }
    }

    @Override
    public List<Cliente> pesquisarTodos() throws PessoaException {
        return pesquisarPor("");
    }

    @Override
    public List<Cliente> pesquisarPor(String cpf) throws PessoaException {
        try{
            List<Cliente> lista = new ArrayList<Cliente>();
            Connection con = dbConn.getConnection();
            String sql = """
                    SELECT *
                        FROM cliente c, pessoa p
                        WHERE c.pessoaCPF = p.cpf AND c.pessoaCPF = ? """;
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cpf);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Cliente c = new Cliente();
                c.setCpf(rs.getString("pessoaCPF"));
                c.setEmail(rs.getString("email"));
                c.setSenha(rs.getString("senha"));
                c.setNome(rs.getString("nome"));
                c.setSobrenome(rs.getString("sobrenome"));
                c.setEndCep(rs.getString("end_cep"));
                c.setEndLog(rs.getString("end_logradouro"));
                c.setEndNum(rs.getString("end_numero"));
                c.setEndComplemento(rs.getString("end_complemento"));

                lista.add(c);
            }
            con.close();
            return lista;
        }catch (Exception e){
            throw new PessoaException(e);
        }
    }
}
