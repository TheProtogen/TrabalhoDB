package persistencia.Aluguel.Pagamento;

import modelo.Pagamento;
import persistencia.DBconnectionTest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDaoImp implements PagamentoDao{

    DBconnectionTest dbConn = null;

    public PagamentoDaoImp() throws PagamentoException{
        try{
            dbConn = DBconnectionTest.getInstance();
        }catch (Exception e){
            throw new PagamentoException(e);
        }
    }

    @Override
    public void insert(Pagamento p) throws PagamentoException {
        try{
            Connection con = dbConn.getConnection();

            String sql = "INSERT INTO pagamento (aluguelIID, total_pagar, data_pagamento, status)" +
                    "VALUES (?,?,?,?)";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, p.getAluguelId());
            pstm.setDouble(2, p.getTotal_pagar());
            pstm.setDate(3, Date.valueOf(p.getData()));
            pstm.setString(4, p.getStatus());

        }catch (Exception e){
            throw new PagamentoException(e);
        }
    }

    @Override
    public void delete(int id) throws PagamentoException {
        Connection con = null;
        PreparedStatement pstm = null;
        try{
            con = dbConn.getConnection();

            String sql = """
                    DELETE FROM pagamento
                    WHERE aluguelIID = ?
                    """;

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

            con.close();
        }catch (Exception e){
            throw new PagamentoException(e);
        }
    }

    @Override
    public List<Pagamento> pesquisarTodos() throws PagamentoException {
        try{
            List<Pagamento> lista = new ArrayList<Pagamento>();
            Connection con =dbConn.getConnection();
            String sql = """
                    SELECT *
                    FROM pagamento""";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                Pagamento p = new Pagamento();

                p.setAluguelId(rs.getInt("aluguelIID"));
                p.setTotal_pagar((rs.getDouble("total_pagar")));
                p.setData(rs.getDate("data_pagamento").toLocalDate());
                p.setStatus(rs.getString("status"));

                lista.add(p);
            }
            con.close();
            return lista;
        }catch (Exception e){
            throw new PagamentoException(e);
        }
    }

    @Override
    public List<Pagamento> pesquisarPor(int id) throws PagamentoException {
        try{
            List<Pagamento> lista = new ArrayList<Pagamento>();
            Connection con =dbConn.getConnection();
            String sql = """
                    SELECT *
                    FROM pagamento
                    WHERE aluguelIID = ?""";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                Pagamento p = new Pagamento();

                p.setAluguelId(id);
                p.setTotal_pagar((rs.getDouble("total_pagar")));
                p.setData(rs.getDate("data_pagamento").toLocalDate());
                p.setStatus(rs.getString("status"));

                lista.add(p);
            }
            con.close();
            return lista;
        }catch (Exception e){
            throw new PagamentoException(e);
        }
    }
}
