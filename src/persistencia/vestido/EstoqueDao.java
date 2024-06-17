package persistencia.vestido;

import modelo.Estoque;

import java.util.List;

public interface EstoqueDao{
public void insert(Estoque e) throws EstoqueException;
public void update(Estoque e) throws EstoqueException;
public void delete(int id) throws EstoqueException;
public List<Estoque> pesquisarTodos() throws EstoqueException;
public List<Estoque> pesquisarPor(String marca) throws EstoqueException;
}
