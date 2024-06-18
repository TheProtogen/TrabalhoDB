package persistencia.pessoa.cliente;

import modelo.Telefone;
import persistencia.DBconnectionTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDaoImp implements TelefoneDao{

    DBconnectionTest dbConn = null;

    public TelefoneDaoImp() throws TelefoneException{
        try{
            dbConn = DBconnectionTest.getInstance();
        }catch (Exception e){
            throw new TelefoneException(e);
        }
    }


    @Override
    public void insert(Telefone t) throws TelefoneException {
        try{
            Connection con = dbConn.getConnection();
            String sql = """
                    INSERT INTO telefone_cliente (clienteCPF, ddd, numero) VALUES (?,?,?);
                    """;
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, t.getPessoaCpf());
            pstm.setString(2, t.getDdd());
            pstm.setString(3, t.getNumero());

            pstm.executeUpdate();

            con.close();
        }catch (Exception e){
            throw new TelefoneException(e);
        }
    }

    @Override
    public void update(Telefone t) throws TelefoneException {
        try{
            Connection con = dbConn.getConnection();

            String sql = """
                    UPDATE telefone_cliente SET ddd = ?, numero = ?
                    WHERE pessoaCPF = ?
                    """;
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, t.getDdd());
            pstm.setString(2,t.getNumero());
            pstm.setString(3, t.getPessoaCpf());

            pstm.executeUpdate();
            con.close();

        }catch (Exception e){
            throw new TelefoneException(e);
        }
    }

    @Override
    public void delete(String cpf) throws TelefoneException {
        try{
            Connection con = dbConn.getConnection();
            String sql = """
                    DELETE FROM telefone_cliente WHERE clienteCPF = ?
                    """;
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cpf);
            pstm.executeUpdate();

            con.close();
        }catch (Exception e){
            throw new TelefoneException(e);
        }
    }

    @Override
    public List<Telefone> pesquisarTodos() throws TelefoneException {
        return pesquisarPor("");
    }

    @Override
    public List<Telefone> pesquisarPor(String cpf) throws TelefoneException {
        try{
            List<Telefone> lista = new ArrayList<Telefone>();
            Connection con = dbConn.getConnection();
            String sql = """
                    SELECT *
                    FROM telefone_cliente
                    WHERE clienteCPF = ?""";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, "%"+cpf+"%");
            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                Telefone t =new Telefone();

                t.setPessoaCpf(rs.getString("pessoaCPF"));
                t.setDdd(rs.getString("ddd"));
                t.setNumero(rs.getString("numero"));

                lista.add(t);
            }
            con.close();
            return lista;
        }catch (Exception e){
            throw new TelefoneException(e);
        }
    }
}