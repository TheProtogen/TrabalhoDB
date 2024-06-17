package persistencia;
public interface CrudDAO <Obj> {

    public void pesquisar(Obj o);

    public void criar(Obj o);

    public void atualizar(Obj o);
    
    public void deletar(Obj o);
}
