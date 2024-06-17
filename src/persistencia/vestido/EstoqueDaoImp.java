package persistencia.vestido;

import modelo.Estoque;
import persistencia.DBconnectionTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDaoImp implements EstoqueDao{

    private DBconnectionTest dbConn = null;

    public EstoqueDaoImp() throws EstoqueException{
        try{
            dbConn = DBconnectionTest.getInstance();
        }catch (Exception e){
            throw new EstoqueException(e);
        }
    }

    @Override
    public void insert(Estoque es) throws EstoqueException {
        try{
            Connection con = dbConn.getConnection();
            String sql = """
                    INSERT INTO estoque (vestidoID, quantidade) VALUES(?,?)
                    """;
            PreparedStatement pmst = con.prepareStatement(sql);
            pmst.setInt(1,es.getId());
            pmst.setInt(2, es.getQuantidade());

            pmst.executeUpdate();
            con.close();

        }catch (Exception ex){
            throw new EstoqueException(ex);
        }
    }

    @Override
    public void update(Estoque e) throws EstoqueException {
        Connection con = null;
        PreparedStatement pstm=null;
        try{
            con = dbConn.getConnection();
            String sql= """
                    UPDATE estoque SET quantidade=?
                    WHERE   vestidoID = ?""";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, e.getQuantidade());
            pstm.setInt(2,e.getId());

            pstm.executeUpdate();
            con.close();
        }catch (Exception ex){
            throw new EstoqueException(ex);
        }
    }

    @Override
    public void delete(int id) throws EstoqueException {
        Connection con = null;
        PreparedStatement pstm = null;
        try{
            con = dbConn.getConnection();
            String sql = """
                    DELETE FROM estoque WHERE vestiID = ?""";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.executeUpdate();
            con.close();
        }catch (Exception e){
            throw new EstoqueException(e);
        }
    }

    @Override
    public List<Estoque> pesquisarTodos() throws EstoqueException {
        return pesquisarPor("");
    }

    @Override
    public List<Estoque> pesquisarPor(String marca) throws EstoqueException {
        try{
            List<Estoque> lista = new ArrayList<>();
            String sql = """
                    SELECT e.vestidoID, e.quantidade, v.marca
                         FROM estoque e, vestido v
                         WHERE e.vestidoID = v.id AND v.marca = ?
                          """;
            Connection con = dbConn.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, marca);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Estoque e = new Estoque();
                e.setId(rs.getInt("vestidoID"));
                e.setQuantidade(rs.getInt("quantidade"));

                lista.add(e);
            }
            con.close();
            return lista;

        }catch (Exception e){

        }
        return List.of();
    }
}
