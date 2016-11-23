package utfpr.edu.br.papelariafacil.tabelas;

import utfpr.edu.br.papelariafacil.vo.Venda;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * @see Classe modelo. Modela uma tabela para possuir todos os campos de valores
 * do Venda.
 * @author Bruna Danieli Ribeiro Gonçalves, Márlon Ândrel Coelho Freitas
 */
public class TableModelVenda extends AbstractTableModel {

    //Declaração de variáveis.
    private final List<Venda> linhas;
    private final String[] colunas;

    //Declaração de variáveis que compoem os campos da tabela.
    private static final int clienteVenda = 0;
    private static final int valorVenda = 1;
    private static final int criacaoVenda = 2;
    private static final int atualizacaoVenda = 3;

    /**
     * @see Construtor padrão. Inicializa as linhas da coluna como nulo e define
     * as colunas com os valores do objeto.
     */
    public TableModelVenda() {
        linhas = new ArrayList<>();
        colunas = new String[]{"ID", "Valor",  "Criação", "Atualização"};
    }

    /**
     * @see Contrutor que inicializa as linhas da coluna com a lista recebida
     * pelo parâmetro e define as colunas com os valores do objeto.
     * @param vendas
     */
    public TableModelVenda(List<Venda> vendas) {
        linhas = new ArrayList<>(vendas);
        colunas = new String[]{"ID", "Valor",  "Criação", "Atualização"};
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
            case clienteVenda:
                return String.class;
            case valorVenda:   
                return String.class;
            case criacaoVenda:
                return Date.class;
            case atualizacaoVenda:
                return Date.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venda venda = linhas.get(rowIndex);
        switch (columnIndex) {
            case clienteVenda:
                return venda.getIdvenda();
            case valorVenda:
                return venda.getValor();
            case criacaoVenda:
                return venda.getCriacaovenda();
            case atualizacaoVenda:
                return venda.getAtualizacaovenda();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Venda venda = linhas.get(rowIndex);
        switch (columnIndex) {
            case clienteVenda:
                venda.setIdvenda((Integer) aValue);
                break;
            case valorVenda:
                venda.setValor((BigDecimal) (aValue));
                break;
            
            case criacaoVenda:
                venda.setCriacaovenda((Date) (aValue));
                break;
            case atualizacaoVenda:
                venda.setAtualizacaovenda((Date) (aValue));
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Venda getVenda(int rowIndex) {
        return linhas.get(rowIndex);
    }

    /**
     * @see Método que adiciona uma nova linha com os valores do objeto recebido
     * como parâmetro.
     * @param venda Usuario que compoe uma linha da tabela.
     */
    public void addVenda(Venda venda) {
        linhas.add(venda);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /**
     * @see Método que adiciona uma lista de linhas com a lista de objetos
     * recebida como parâmetro.
     * @param vendas
     */
    public void addListaVendas(List<Venda> vendas) {
        int indice = getRowCount();
        linhas.addAll(vendas);
        fireTableRowsInserted(indice, indice + vendas.size());
    }

    /**
     * @see Método que remove linha da tabela atravez do index rebecido como
     * parâmetro.
     * @param rowIndex numero da linha da tabela.
     */
    public void removeVenda(int rowIndex) {
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
