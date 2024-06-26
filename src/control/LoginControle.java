package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import persistencia.DBconnectionTest;
import persistencia.pessoa.PessoaDao;
import persistencia.pessoa.PessoaException;

//Criar construtor que vai receber os dados do TextField pelo LoginBoundary
//Por esse construtor verificar a existencia do user no database

public class LoginControle {
    
    DBconnectionTest con = new DBconnectionTest();

    public boolean login (String cpf, String senha) {
        Connection c = con.getConnection();
		String sql = "SELECT * FROM pessoa "+
        "WHERE cpf = ? AND senha = ?"; 
		
		
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

    public boolean checkFuncionario(String cpf) {
        Connection c = con.getConnection();
        String sql = 
        """
        SELECT * 
        FROM funcionario
        WHERE pessoacpf = ?
        """;

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();
		    boolean result = rs.next();

            rs.close();
		    ps.close();
		    c.close();
		    return result;
        } catch (Exception e) {
            return false;
        }
        
    }
    
}
