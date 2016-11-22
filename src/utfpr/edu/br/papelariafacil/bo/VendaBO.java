package utfpr.edu.br.papelariafacil.bo;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import javax.swing.JOptionPane;
import utfpr.edu.br.papelariafacil.dao.GenericDAO;
import utfpr.edu.br.papelariafacil.vo.Funcionario;
import utfpr.edu.br.papelariafacil.vo.Itemvenda;
import utfpr.edu.br.papelariafacil.vo.Venda;

/**
 * @see Classe de objetos de negócios. Métodos:
 */
public class VendaBO {

    /**
     * @param idCliente
     * @see Método que realiza consulta ao banco de dados por todos os Clientes.
     * @return Lista de Categorias composta por todas as linhas da tabela
     * categoria do banco de dados.
     */
   

    /**
     * @see Método que realiza consulta ao banco de dados por todos as
     * Categorias.
     * @return Lista de Categorias composta por todas as linhas da tabela
     * categoria do banco de dados.
     */
    

    /**
     * @see Método que realiza consulta ao banco de dados por todos as
     * Categorias.
     * @return Lista de Categorias composta por todas as linhas da tabela
     * categoria do banco de dados.
     */
    public List<Venda> buscarVendas() {
        GenericDAO<Venda> vendaDAO = new GenericDAO<>();
        ArrayList<Venda> vendasVO = new ArrayList<>(vendaDAO.consultar(new Venda()));
        return vendasVO;
    }

    /**
     * @see Método que exclui um objeto no banco de dados por meio da
     * GenericDAO.
     * @param idVenda
     * @return true/false.
     */
    public Boolean excluirVenda(Long idVenda) {
        try {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta Venda?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
                try {
                    GenericDAO<Venda> vendaDAO = new GenericDAO<>();
                    Venda vendaVO = vendaDAO.consultar("idVenda", idVenda, new Venda());
                    ArrayList<Itemvenda> itens = buscarItens(idVenda);
                    GenericDAO<Itemvenda> itemDAO = new GenericDAO<>();
                    itens.stream().forEach((iten) -> {
                        itemDAO.apagar(iten);
                    });
                    vendaDAO.apagar(vendaVO);
                    JOptionPane.showMessageDialog(null, "Venda excluida com sucesso.", "Secesso", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Boolean finalizarVenda(Long idFuncionario, Integer idCliente, String valor, Integer parcelas, String vencimento, ArrayList<Itemvenda> itens) {
        try {
            GenericDAO<Venda> vendaDAO = new GenericDAO<>();
            Venda vendaVO = new Venda();

            GenericDAO<Funcionario> funcionarioDAO = new GenericDAO<>();
            vendaVO.setFuncionario(funcionarioDAO.consultar("idFuncionario", idFuncionario, new Funcionario()));
            
            vendaVO.setValor(new BigDecimal(valor));
            
            
            vendaVO.setCriacaovenda(new Date());
            vendaVO.setAtualizacaovenda(new Date());
            vendaDAO.inserir(vendaVO);

            GenericDAO<Itemvenda> itemDAO = new GenericDAO<>();
            itens.stream().forEach((iten) -> {
                iten.setVenda(vendaVO);
                itemDAO.inserir(iten);
            });
            JOptionPane.showMessageDialog(null, "Venda finalizada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void excluirVenda(Long idVenda, ArrayList<Itemvenda> itens) {
        try {
            GenericDAO<Venda> vendaDAO = new GenericDAO<>();
            vendaDAO.apagar(vendaDAO.consultar("idVenda", idVenda, new Venda()));
            GenericDAO<Itemvenda> itemDAO = new GenericDAO<>();
            itens.stream().forEach(new Consumer<Itemvenda>() {
                @Override
                public void accept(Itemvenda iten) {
                    itemDAO.apagar(itemDAO.consultar("idItem", (long)iten.getIditemvenda(), new Itemvenda()));
                }
            });
        } catch (Exception e) {

        }
    }

    public ArrayList<Itemvenda> buscarItens(Long idVenda) {
        GenericDAO<Itemvenda> itemDAO = new GenericDAO<>();
        List<Itemvenda> itens = itemDAO.consultar(new Itemvenda());
        ArrayList<Itemvenda> itensVenda = new ArrayList<>();
        itens.stream().filter((iten) -> (Objects.equals(iten.getVenda().getIdvenda(), idVenda))).forEach((iten) -> {
            itensVenda.add(iten);
        });
        return itensVenda;
    }
}
