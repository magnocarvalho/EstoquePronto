package utfpr.edu.br.papelariafacil.bo;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import utfpr.edu.br.papelariafacil.dao.GenericDAO;
import utfpr.edu.br.papelariafacil.vo.Categoria;
import utfpr.edu.br.papelariafacil.vo.Fornecedor;
import utfpr.edu.br.papelariafacil.vo.Funcionario;
import utfpr.edu.br.papelariafacil.vo.Produto;

/**
 * @see Classe de objetos de negócios. Métodos: buscarCategorias(),
 * buscarClientes(), BuscarFornecedores(), buscarFuncionarios(),
 * buscarPessoaFisica(), buscarPessoaJuridica(), buscarProdutos(),
 * excluirCategoria(), excluirCliente(), excluirFornecedor(),
 * excluirFuncionario(), excluirProduto().
 * @author 
 * /
 * */

public class PainelControleBO {

    /**
     * @see Método que realiza consulta ao banco de dados por todos os Usuarios.
     * @return Lista de Usuarios composta por todas as linhas da tabela usuario
     * do banco de dados.
     */
    public List<Funcionario> buscarFuncionarios() {
        GenericDAO<Funcionario> funcionarioDAO = new GenericDAO();
        ArrayList<Funcionario> funcionariosVO = new ArrayList<>(funcionarioDAO.consultar(new Funcionario()));
        return funcionariosVO;
    }

    /**
     * @see Método que realiza consulta ao banco de dados por todos os Clientes.
     * @return Lista de Clientes composta por todas as linhas da tabela cliente
     * do banco de dados.
     */
//    public List<> buscarClientes() {
//       
//        return null;
//    }

    /**
     * @see Método que realiza consulta ao banco de dados por todos os
     * Fornecedores.
     * @return Lista de Fornecedores composta por todas as linhas da tabela
     * fornecedor do banco de dados.
     */
    public List<Fornecedor> buscarFornecedores() {
        GenericDAO<Fornecedor> fornecedorDAO = new GenericDAO<>();
        ArrayList<Fornecedor> fornecedoresVO = new ArrayList<>(fornecedorDAO.consultar(new Fornecedor()));
        return fornecedoresVO;
    }

    /**
     * @see Método que realiza consulta ao banco de dados por todos as
     * Categorias.
     * @return Lista de Categorias composta por todas as linhas da tabela
     * categoria do banco de dados.
     */
    public List<Categoria> buscarCategorias() {
        GenericDAO<Categoria> categoriaDAO = new GenericDAO<>();
        ArrayList<Categoria> categoriasVO = new ArrayList<>(categoriaDAO.consultar(new Categoria()));
        return categoriasVO;
    }

    /**
     * @see Método que realiza consulta ao banco de dados por todos os Produtos.
     * @return Lista de Produtos composta por todas as linhas da tabela produto
     * do banco de dados.
     */
    public List<Produto> buscarProdutos() {
        GenericDAO<Produto> produtoDAO = new GenericDAO<>();
        ArrayList<Produto> produtosVO = new ArrayList<>(produtoDAO.consultar(new Produto()));
        return produtosVO;
    }

    /**
     * @see Método que retorna PessoaFisica que possua o atributo Pessoa passado
     * como parâmetro.
     * @param idPessoa
     * @return Pessoafisica/null.
     */
//    public Pessoafisica buscarPessoaFisica(Long idPessoa) {
//        GenericDAO<Pessoafisica> pessoaFisicaDAO = new GenericDAO<>();
//        List<Pessoafisica> pessoaFisicaVO = pessoaFisicaDAO.consultar(new Pessoafisica());
//        for (Pessoafisica pessoaFisicaVO1 : pessoaFisicaVO) {
//            if (Objects.equals(pessoaFisicaVO1.getPessoa().getIdPessoa(), idPessoa)) {
//                return pessoaFisicaVO1;
//            }
//        }
//        return null;
   // }

    /**
     * @see Método que retorna PessoaJuridica que possua o atributo Pessoa
     * passado como parâmetro.
     * @param idPessoa
     * @return Pessoafisica/null.
     */
//    public Pessoajuridica buscarPessoaJuridica(Long idPessoa) {
//        GenericDAO<Pessoajuridica> pessoaJuridicaDAO = new GenericDAO<>();
//        List<Pessoajuridica> pessoaJuridicaVO = pessoaJuridicaDAO.consultar(new Pessoajuridica());
//        for (Pessoajuridica pessoaJuridicaVO1 : pessoaJuridicaVO) {
//            if (Objects.equals(pessoaJuridicaVO1.getPessoa().getIdPessoa(), idPessoa)) {
//                return pessoaJuridicaVO1;
//            }
//        }
//        return null;
//    }

    /**
     * @see Método que exclui um objeto no banco de dados por meio da
     * GenericDAO.
     * @param idFuncionario
     * @return
     */
    public Boolean excluirFuncionario(Long idFuncionario) {
        if(idFuncionario != null)
        {
            GenericDAO<Funcionario> FuncionarioDAO = new GenericDAO<>();
            Funcionario funcionarioVO = new Funcionario();
            Integer l = Integer.valueOf(idFuncionario.toString());
            funcionarioVO.setIdfuncionario(l);
            FuncionarioDAO.apagar(funcionarioVO);
            
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * @see Método que exclui um objeto no banco de dados por meio da
     * GenericDAO.
     * @param idCliente
     * @return true/false.
     */
    public Boolean excluirCliente(Long idCliente) {
       return true;
    }

    /**
     * @see Método que exclui um objeto no banco de dados por meio da
     * GenericDAO.
     * @param idFornecedor
     * @return true/falseretur.
     */
    public Boolean excluirFornecedor(Long idFornecedor) {
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este Fornecedor?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) 
        {
            return true;
        }
        else
        {
            return false;
        }
              
       
    }

    /**
     * @see Método que exclui um objeto no banco de dados por meio da
     * GenericDAO.
     * @param idCategoria
     * @return true/false.
     */
    public Boolean excluirCategoria(Long idCategoria) {
       
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta Categoria?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
                
                return true;
                
            } else {
                return false;
            }
        
    }

    /**
     * @see Método que exclui um objeto no banco de dados por meio da
     * GenericDAO.
     * @param idProduto
     * @return true/false.
     */
    public Boolean excluirProduto(Long idProduto) {
        try {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este Produto?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
                try {
                    GenericDAO<Produto> produtoDAO = new GenericDAO<>();
                    Produto produtoVO = produtoDAO.consultar("idProduto", idProduto, new Produto());
                    produtoDAO.apagar(produtoVO);
                    JOptionPane.showMessageDialog(null, "Produto excluido com sucesso.", "Secesso", JOptionPane.INFORMATION_MESSAGE);
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
}
