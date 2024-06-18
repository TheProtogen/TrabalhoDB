package control;


import modelo.Vestido;
import persistencia.Aluguel.AluguelException;
import persistencia.vestido.VestidoDao;
import persistencia.vestido.VestidoDaoImp;
import persistencia.vestido.VestidoException;

public class CtrlManterVestido {

    private VestidoDao vestidoDao = null;
    private VestidoDaoImp daoImp = new VestidoDaoImp();

    public CtrlManterVestido() throws Exception {
        try {
            vestidoDao = new VestidoDaoImp();
        } catch (Exception e) {
            throw new VestidoException(e);
        }
    }

    public Vestido construirVestido(int id, int tamanho, String cor, String marca, String finalidade, boolean disponivel, double valor) {
        Vestido v = new Vestido();

        v.setId(id);
        v.setTamanho(tamanho);
        v.setCor(cor);
        v.setMarca(marca);
        v.setFinalidade(finalidade);
        v.setDisponivel(disponivel);
        v.setValor(valor);
        return v;
    }

    public void atualizar(Vestido vestido) throws VestidoException {
        //vestido.setId(id.get());
        //vestido.setTamanho(tamanho.get());
        //vestido.setCor(cor.get());
       // vestido.setMarca(marca.get());
       // vestido.setFinalidade(finalidade.get());
        //vestido.setDisponivel(disponivel.get());
        //vestido.setValor(valor.get());

        System.out.println(vestido.toString());

        System.out.println("Atualizar checked");
        daoImp.update(vestido);
    }

    public void voltar() {
        //Voltar para pagina inicial do funcionario
    }

    public void excluir(int id) throws VestidoException {
        vestidoDao.delete(id);
        System.out.println("Excluir checked");
    }


}
