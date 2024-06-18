package persistencia.Aluguel;

import modelo.Aluguel;
import modelo.Telefone;
import persistencia.DBconnectionTest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AluguelDaoImp implements AluguelDao {
    DBconnectionTest dbconn =null;

    public AluguelDaoImp() throws AluguelException{
        try{
            dbconn = DBconnectionTest.getInstance();
        }catch (Exception e){
            throw new AluguelException(e);
        }
    }

    @Override
    public void insert(Aluguel a) throws AluguelException {
        try{
            Connection con = dbconn.getConnection();

            String sql = """
                    INSERT INTO aluguel (id, clientePessoaCPF, vestidoID, data_retirada, data_devolucao)
                           VALUES(?,?,?,?,?)
                    """;
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, a.getId());
            pstm.setString(2, a.getClientePessoaCPF());
            pstm.setInt(3,a.getVestidoID());
            pstm.setDate(4, Date.valueOf(a.getData_retirada()));
            pstm.setDate(5, Date.valueOf(a.getData_devolucao()));
        }catch (Exception e){
            throw new AluguelException(e);
        }
    }

    @Override
    public void update(Aluguel a) throws AluguelException {
        try{
            Connection con = dbconn.getConnection();

            String sql = """
                    UPDATE aluguel SET clientePessoaCPF = ?, vestidoID = ?, data_retirada = ?, data_devoluca = ?
                    WHERE id = ?
                    """;

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, a.getClientePessoaCPF());
            pstm.setInt(2, a.getVestidoID());
            pstm.setDate(3, Date.valueOf(a.getData_retirada()));
            pstm.setDate(4, Date.valueOf(a.getData_devolucao()));
            pstm.setInt(5,a.getId());

            pstm.executeUpdate();
            con.close();
        }catch (Exception e){
            throw new AluguelException(e);
        }
    }

    @Override
    public void delete(Aluguel a) throws AluguelException {
        try{
            Connection con = dbconn.getConnection();

            String sql = """
                    DELETE FROM aluguel
                    WHERE id = ?
                    """;
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setInt(1, a.getId());
            pstm.executeUpdate();
            con.close();
        }catch (Exception e){
            throw new AluguelException(e);
        }
    }

    @Override
    public List<Aluguel> pesquisarPor(int id) throws AluguelException {
        try{
            Connection con = dbconn.getConnection();
            List<Aluguel> lista = new ArrayList<Aluguel>();
            String sql = """
                    SELECT * 
                    FROM aluguel
                    WHERE id = ? 
                    """;

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Aluguel a = new Aluguel();

                a.setId(id);
                a.setClientePessoaCPF(rs.getString("clientePessoaCPF"));
                a.setVestidoID(rs.getInt("vestidoID"));
                a.setData_retirada(rs.getDate("data_retirada").toLocalDate());
                a.setData_devolucao(rs.getDate("data_devolucao").toLocalDate());

                lista.add(a);
            }
            con.close();
            return lista;
        }catch (Exception e){
            throw new AluguelException(e);
        }
    }
}
