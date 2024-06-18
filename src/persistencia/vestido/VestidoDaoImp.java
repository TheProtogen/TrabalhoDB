package persistencia.vestido;

import modelo.Vestido;
import persistencia.DBconnectionTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VestidoDaoImp implements VestidoDao{

    DBconnectionTest dbConn = null;

    public VestidoDaoImp() throws VestidoException{
        try{
            dbConn = DBconnectionTest.getInstance();
        }catch (Exception e){
            throw new VestidoException(e);
        }
    }

    @Override
    public void insert(Vestido v) throws VestidoException {
        try{
            Connection con = dbConn.getConnection();

            String sqlVestido = "INSERT INTO vestido (id, tamanho, cor, marca, finalidade, disponivel, valor)" +
                    "(?,?,?,?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sqlVestido);
            pstm.setInt(1,v.getId());
            pstm.setInt(2,v.getTamanho());
            pstm.setString(3,v.getCor());
            pstm.setString(3, v.getMarca());
            pstm.setString(4, v.getFinalidade());
            pstm.setBoolean(5, v.isDisponivel());
            pstm.setDouble(6, v.getValor());

            pstm.executeUpdate();

            con.close();
        }catch (Exception e){
            throw new VestidoException(e);
        }
    }

    @Override
    public void update(Vestido v) throws VestidoException {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = dbConn.getConnection();

            String sql = """
            UPDATE vestido 
            SET tamanho = ?, cor = ?, marca = ?, finalidade = ?, disponivel = ?, valor = ? 
            WHERE id = ?
        """;

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, v.getTamanho());
            pstm.setString(2, v.getCor());
            pstm.setString(3, v.getMarca());
            pstm.setString(4, v.getFinalidade());
            pstm.setBoolean(5, v.isDisponivel());
            pstm.setDouble(6, v.getValor());
            pstm.setInt(7, v.getId());

            pstm.executeUpdate();
            con.close();
        } catch (Exception e) {
            throw new VestidoException(e);
        }
    }

    @Override
    public void delete(int id) throws VestidoException {
        Connection con = null;
        PreparedStatement pstm = null;

        try{
            con = dbConn.getConnection();
            con.setAutoCommit(false);

            String sql ="DELETE FROM vestido WHERE id=?";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

            con.close();
        }catch (Exception e){
            throw new VestidoException(e);
        }
    }

    @Override
    public List<Vestido> pesquisarTodos() throws VestidoException {
        return pesquisarPor("");
    }

    @Override
    public List<Vestido> pesquisarPor(String marca) throws VestidoException {
        try{
            List<Vestido> lista = new ArrayList<Vestido>();
            Connection con = dbConn.getConnection();
            String sql = """
                        SELECT * 
                        FROM vestido
                        WHERE marca LIKE ?""";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,"%"+marca+"%");
            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                Vestido v = new Vestido();

                v.setId(rs.getInt("id"));
                v.setTamanho(rs.getInt("tamanho"));
                v.setCor(rs.getString("cor"));
                v.setMarca(rs.getString("marca"));
                v.setFinalidade(rs.getString("finalidade"));
                v.setDisponivel(rs.getBoolean("disponivel"));
                v.setValor(rs.getDouble("valor"));

                lista.add(v);
            }
            con.close();
            return  lista;
        }catch (Exception e){
            throw new VestidoException(e);
        }
    }
}
