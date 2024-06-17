package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistencia.FuncionarioDao;
import persistencia.DBconnectionTest;

//Criar construtor que vai receber os dados do TextField pelo LoginBoundary
//Por esse construtor verificar a existencia do user no database

public class LoginControle implements FuncionarioDao {
    
    DBconnectionTest con = new DBconnectionTest();

    public boolean login (String cpf, String senha) {
        Connection c = con.getConnection();
		String sql = "SELECT * FROM pessoa "+
        "WHERE cpf = ? AND senha = ?"; //criar select aqui
		
		
		try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cpf);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();
		    boolean result = rs.next();

            rs.close();
		    ps.close();
		    c.close();
		    return result;

        } catch (SQLException e) {
            System.out.println("Conexão falhou, usuário não encontrado");
            return false;
        }	
    }

    @Override
    public void pesquisar(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisar'");
    }

    @Override
    public void criar(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criar'");
    }

    @Override
    public void atualizar(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

}
