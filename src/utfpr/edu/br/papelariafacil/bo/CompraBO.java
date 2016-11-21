package utfpr.edu.br.papelariafacil.bo;

import utfpr.edu.br.papelariafacil.dao.GenericDAO;

import utfpr.edu.br.papelariafacil.vo.Produto;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import utfpr.edu.br.papelariafacil.vo.Compra;
import utfpr.edu.br.papelariafacil.vo.Fornecedor;
import utfpr.edu.br.papelariafacil.vo.Funcionario;
import utfpr.edu.br.papelariafacil.vo.Itemcompra;


public class CompraBO {

    /**
     * @see Método que realiza consulta ao banco de dados por todo o Inventario.
     * @return Lista de Produtos
     */
    public List<Produto> buscarInventario() {
        GenericDAO<Produto> produtoDAO = new GenericDAO<>();
        ArrayList<Produto> produtosVO = new ArrayList<>(produtoDAO.consultar(new Produto()));
        return produtosVO;
    }

    /**
     * @see Método que realiza consulta ao banco de dados por todo o Inventario.
     * @return Lista de Compras
     */
    public List<Compra> buscarCompras() {
        GenericDAO<Compra> compraDAO = new GenericDAO<>();
        ArrayList<Compra> comprasVO = new ArrayList<>(compraDAO.consultar(new Compra()));
        return comprasVO;
    }

    public Fornecedor buscarFornecedor(Integer idCliente) {
        GenericDAO<Fornecedor> clienteDAO = new GenericDAO<>();
        ArrayList<Fornecedor> clientesVO = new ArrayList<>(clienteDAO.consultar(new Fornecedor()));
        return clientesVO.get(idCliente);
    }

   

    public Boolean excluirCompra(Long idCompra) {
        try {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta Compra?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
                try {
                    GenericDAO<Compra> compraDAO = new GenericDAO<>();
                    Compra compraVO = compraDAO.consultar("idCompra", idCompra, new Compra());
                    ArrayList<Itemcompra> itens = buscarItens(idCompra);
                    GenericDAO<Itemcompra> itemDAO = new GenericDAO<>();
                    itens.stream().forEach((iten) -> {
                        itemDAO.apagar(iten);
                    });
                    compraDAO.apagar(compraVO);
                    JOptionPane.showMessageDialog(null, "Compra excluida com sucesso.", "Secesso", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CompraBO/excluirCompra/" + e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
   public Boolean finalizarCompra(Long idFuncionario, Integer idFornecedor, String valor, Integer parcelas, String vencimento, ArrayList<Itemcompra> itens) {
        try {
            GenericDAO<Compra> compraDAO = new GenericDAO<>();
            Compra compraVO = new Compra();

            GenericDAO<Funcionario> funcionarioDAO = new GenericDAO<>();
            compraVO.setFuncionariocompra(funcionarioDAO.consultar("idFuncionario", idFuncionario, new Funcionario()));
            if (idFornecedor > 0) {
                compraVO.setFornecedorcompra(buscarFornecedor(idFornecedor - 1));
            }
            compraVO.setValorcompra(new BigDecimal(valor));
           
            compraVO.setCriacaocompra(new Date());
            compraDAO.inserir(compraVO);

            GenericDAO<Itemcompra> itemDAO = new GenericDAO<>();
            itens.stream().forEach((iten) -> {
                iten.setCompraitemcompra(compraVO);
                itemDAO.inserir(iten);
            });
            JOptionPane.showMessageDialog(null, "Compra finalizada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CompraBO/finalizarCompra/" + e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void excluirCompra(Long idCompra, ArrayList<Itemcompra> itens) {
        try {
            GenericDAO<Compra> compraDAO = new GenericDAO<>();
            compraDAO.apagar(compraDAO.consultar("idCompra", idCompra, new Compra()));
            GenericDAO<Itemcompra> itemDAO = new GenericDAO<>();
            itens.stream().forEach((iten) -> {
                itemDAO.apagar(itemDAO.consultar("idItem", (long)iten.getIditemcompra(), new Itemcompra()));
            });
        } catch (Exception e) {

        }
    }

    public ArrayList<Itemcompra> buscarItens(Long idVenda) {
        GenericDAO<Itemcompra> itemDAO = new GenericDAO<>();
        List<Itemcompra> itens = itemDAO.consultar(new Itemcompra());
        ArrayList<Itemcompra> itensVenda = new ArrayList<>();
        itens.stream().filter((iten) -> (Objects.equals(iten.getCompraitemcompra().getIdcompra(), idVenda))).forEach((iten) -> {
            itensVenda.add(iten);
        });
        return itensVenda;
    }
    
    public Boolean verificarEstoque(ArrayList<Itemcompra> itens){
        Boolean retorno = true;
        for (Itemcompra iten : itens) {
            BigDecimal aux = new BigDecimal(iten.getProdutoitemcompra().getQuantidade()).add(new BigDecimal(iten.getQuantidadeitemcompra()));
            if (aux.compareTo(new BigDecimal(iten.getProdutoitemcompra().getMaximoproduto())) > 0) {
                retorno = false;
            }
        }
        return retorno;
    }

    public Object[] buscarNomeFornecedores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
}
