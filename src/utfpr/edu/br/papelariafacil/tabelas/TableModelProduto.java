package utfpr.edu.br.papelariafacil.tabelas;

import java.math.BigDecimal;
import java.math.BigInteger;
import utfpr.edu.br.papelariafacil.vo.Categoria;
import utfpr.edu.br.papelariafacil.vo.Fornecedor;
import utfpr.edu.br.papelariafacil.vo.Produto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * @see Classe modelo. Modela uma tabela para possuir todos os campos de valores
 * do Produto.
 * @author Bruna Danieli Ribeiro Gonçalves, Márlon Ândrel Coelho Freitas
 */
public class TableModelProduto extends AbstractTableModel {

    //Declaração de variáveis.
    private final List<Produto> linhas;
    private final String[] colunas;

    //Declaração de variáveis que compoem os campos da tabela.
    private static final int descricaoProduto = 0;
    private static final int categoriaProduto = 1;
    private static final int fornecedorProduto = 2;
    private static final int codigoProduto = 3;
    private static final int custo = 4;
    private static final int valor = 5;
    private static final int quantidade = 6;

    /**
     * @see Construtor padrão. Inicializa as linhas da coluna como nulo e define
     * as colunas com os valores do objeto.
     */
    public TableModelProduto() {
        linhas = new ArrayList<>();
        colunas = new String[]{"Produto", "Categoria", "Fornecedor", "Codigo",  "Custo", "Valor" , "Quantidade"};
    }

    /**
     * @see Contrutor que inicializa as linhas da coluna com a lista recebida
     * pelo parâmetro e define as colunas com os valores do objeto.
     * @param produtos
     */
    public TableModelProduto(List<Produto> produtos) {
        linhas = new ArrayList<>(produtos);
        colunas = new String[]{"Produto", "Categoria", "Fornecedor", "Codigo",  "Custo", "Valor" , "Quantidade"};
    }

    //Gets and Sets
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case descricaoProduto:
                return String.class;
            case categoriaProduto:
                return String.class;
            case fornecedorProduto:
                return String.class;
            case codigoProduto:
                return String.class;
            
            case custo:
                return String.class;
            case valor:
                return String.class;
            case quantidade:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = linhas.get(rowIndex);
        switch (columnIndex) {
            case descricaoProduto:
                return produto.getDescricaoproduto();
            case categoriaProduto:
                if (produto.getCategoriaproduto()!= null) {
                    return produto.getCategoriaproduto().getDescricaocategoria();
                } else {
                    return null;
                }
            case fornecedorProduto:
                if (produto.getFornecedorproduto()!= null) {
                    return produto.getFornecedorproduto().getNomefornecedor();
                } else {
                    return null;
                }
            case codigoProduto:
                return produto.getCodigoproduto();
            case custo:
                return produto.getCustoproduto();
            case valor:
                return produto.getVendaproduto();
            case quantidade:
                return produto.getQuantidade();
           
           
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Produto produto = linhas.get(rowIndex);
        switch (columnIndex) {
            case descricaoProduto:
                produto.setDescricaoproduto((String) aValue);
                break;
            case categoriaProduto:
                produto.setCategoriaproduto((Categoria) aValue);
                break;
            case fornecedorProduto:
                produto.setFornecedorproduto((Fornecedor) aValue);
                break;
            case codigoProduto:
                produto.setCodigoproduto((String) aValue);
                break;
           case custo:
                produto.setCustoproduto((BigDecimal) aValue);
                break;
            case valor:
                produto.setVendaproduto((BigDecimal) aValue);
                break;
            case quantidade:
                produto.setQuantidade((BigInteger) aValue);
                break;
            
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Produto getProduto(int rowIndex) {
        return linhas.get(rowIndex);
    }

    /**
     * @see Método que adiciona uma nova linha com os valores do objeto recebido
     * como parâmetro.
     * @param produto Usuario que compoe uma linha da tabela.
     */
    public void addProduto(Produto produto) {
        linhas.add(produto);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /**
     * @see Método que adiciona uma lista de linhas com a lista de objetos
     * recebida como parâmetro.
     * @param produtos
     */
    public void addListaProdutos(List<Produto> produtos) {
        int indice = getRowCount();
        linhas.addAll(produtos);
        fireTableRowsInserted(indice, indice + produtos.size());
    }

    /**
     * @see Método que remove linha da tabela atravez do index rebecido como
     * parâmetro.
     * @param rowIndex numero da linha da tabela.
     */
    public void removeProduto(int rowIndex) {
        linhas.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    /**
     * @see Método que remove todas as linhas da tabela.
     */
    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }
}
