package utfpr.edu.br.papelariafacil.form;

import utfpr.edu.br.papelariafacil.bo.CompraBO;
import utfpr.edu.br.papelariafacil.tabelas.TableModelItemCompra;


import java.awt.Cursor;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import utfpr.edu.br.papelariafacil.form.FrmBase;
import utfpr.edu.br.papelariafacil.form.FrmEstoque;
import utfpr.edu.br.papelariafacil.form.FrmItemCompra;
import utfpr.edu.br.papelariafacil.vo.Compra;
import utfpr.edu.br.papelariafacil.vo.Itemcompra;
import utfpr.edu.br.papelariafacil.vo.Pagamento;

/**
 * @see Classe visual. JDialog que tem como objetivo cadastrar uma nova compra.
 * @author Magno
 */
public final class FrmCompra extends javax.swing.JDialog {

    /**
     * @see Construtor padrão.
     * @param parent
     * @param modal
     * @param viewPrincipal
     * @param viewEstoque
     */
    public FrmCompra(java.awt.Frame parent, boolean modal, FrmBase viewPrincipal, FrmEstoque viewEstoque) 
    {
        //Inicialização dos componentes padrões do JDialog.
        super(parent, modal);
        this.viewPrincipal = viewPrincipal;
        this.viewEstoque = viewEstoque;
        this.compraBO = new CompraBO();
        this.itens = new ArrayList<>();
        this.pagamentos = new ArrayList<>();
        initComponents();
      
        btnAlterar.setVisible(false);
        atualizarPagina();
    }

    /**
     * @param compra
     * @param alterar
     * @see Construtor padrão.
     * @param parent
     * @param modal
     * @param viewPrincipal
     * @param viewEstoque
     */
    public FrmCompra(java.awt.Frame parent, boolean modal, FrmBase viewPrincipal, FrmEstoque viewEstoque, Compra compra, Boolean alterar) {
        //Inicialização dos componentes padrões do JDialog.
        super(parent, modal);
        this.viewPrincipal = viewPrincipal;
        this.viewEstoque = viewEstoque;
        this.compraBO = new CompraBO();
        this.compraVO = compra;
        int c = compra.getIdcompra();
        Long d = Long.valueOf(c);
        this.itens = compraBO.buscarItens(d);
        this.pagamentos = new ArrayList<>();
        initComponents();
      
        btnFinalizarCompra.setVisible(false);

        //Definindo Modelo com Fornecedor para os JComboBox.
        ArrayList<String> array = new ArrayList<>();
        String[] Arr = new String[array.size()];
        if (compra.getFornecedorcompra()!= null) {
            array.add(compra.getFornecedorcompra().getNomefornecedor());
        } else {
            array.add("FORNECEDOR");
        }
        Arr = array.toArray(Arr);
        cbFornecedor.setModel(new javax.swing.DefaultComboBoxModel(Arr));

        //Definindo como não editável
        if (!alterar) {
            btnAlterar.setVisible(false);
            cbFornecedor.setEnabled(false);
            btnNovoItem.setVisible(false);
            btnAlterarItem.setVisible(false);
            btnVisualizarItem.setVisible(false);
            btnExcluirItem.setVisible(false);
            
        }
        atualizarPagina();
    }

    public void atualizarPagina() {
        calcularValores();
        
       
        atualizarTabelas();
        calcularValores();
      
    }

    /**
     * @see Método que Instancia a classe PainelControleBO para realizar buscas
     * de Objetos de valores que compoem os modelos de tabelas.
     */
    public final void atualizarTabelas() {
        //Inicialização dos modelos de tabelas.
        compraBO = new CompraBO();
        try {
            tabelaItens = new TableModelItemCompra(itens);
        } catch (Exception e) {
            tabelaItens = new TableModelItemCompra();
        }
        

        //Definindo modelo de tabelas para as tabelas.
        tbItens.setModel(tabelaItens);
       

        //Definir tabelas como sem seleção.
        tbItens.clearSelection();
        

        //Definindo botões Aleterar e Excluir como não habilitado.
        btnAlterarItem.setEnabled(false);
        btnExcluirItem.setEnabled(false);

        //Definindo valores da venda
        tfTotalVenda.setText("0.0");
    }

    /**
     * @see Método que calcula os valores da venda.
     */
    public void calcularValores() {
        if (itens.size() > 0) {
            BigDecimal aux = new BigDecimal(0);
            for (Itemcompra iten : itens) {
                aux = aux.add(iten.getValoritemcompra());
            }
            tfTotalVenda.setText(aux.toString());
        }
    }

    /**
     * @see Método que calcula os valores do troco.
     */
    

    

    /**
     * @see Método que calcula os valores do pagamento da venda.
     */
  
    //Componentes padrões do JFrame.
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnTitulo = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        pnCorpo = new javax.swing.JPanel();
        lbCategoria = new javax.swing.JLabel();
        lbOpcional1 = new javax.swing.JLabel();
        pnFornecedor = new javax.swing.JPanel();
        cbFornecedor = new javax.swing.JComboBox();
        lbPedido = new javax.swing.JLabel();
        pnPedido = new javax.swing.JPanel();
        btnNovoItem = new javax.swing.JButton();
        btnVisualizarItem = new javax.swing.JButton();
        btnAlterarItem = new javax.swing.JButton();
        btnExcluirItem = new javax.swing.JButton();
        spnItens = new javax.swing.JScrollPane();
        tbItens = new javax.swing.JTable();
        lbTotalVenda = new javax.swing.JLabel();
        tfTotalVenda = new javax.swing.JFormattedTextField();
        sprRodape = new javax.swing.JSeparator();
        btnFinalizarCompra = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnTitulo.setBackground(new java.awt.Color(51, 51, 51));

        lbTitulo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setText("Nova Compra");

        javax.swing.GroupLayout pnTituloLayout = new javax.swing.GroupLayout(pnTitulo);
        pnTitulo.setLayout(pnTituloLayout);
        pnTituloLayout.setHorizontalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTituloLayout.setVerticalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnCorpo.setBackground(new java.awt.Color(255, 255, 255));

        lbCategoria.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        lbCategoria.setForeground(new java.awt.Color(0, 102, 205));
        lbCategoria.setText("fornecedor");

        lbOpcional1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        lbOpcional1.setForeground(new java.awt.Color(102, 102, 102));
        lbOpcional1.setText("(Opcional)");

        pnFornecedor.setBackground(new java.awt.Color(255, 255, 255));

        cbFornecedor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbFornecedor.setForeground(new java.awt.Color(102, 102, 102));
        cbFornecedor.setModel(new javax.swing.DefaultComboBoxModel(compraBO.buscarNomeFornecedores()));
        cbFornecedor.setFocusable(false);
        cbFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFornecedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFornecedorLayout = new javax.swing.GroupLayout(pnFornecedor);
        pnFornecedor.setLayout(pnFornecedorLayout);
        pnFornecedorLayout.setHorizontalGroup(
            pnFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnFornecedorLayout.setVerticalGroup(
            pnFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbPedido.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        lbPedido.setForeground(new java.awt.Color(0, 102, 205));
        lbPedido.setText("pedido");

        pnPedido.setBackground(new java.awt.Color(255, 255, 255));

        btnNovoItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnNovoItemUP.png"))); // NOI18N
        btnNovoItem.setBorder(null);
        btnNovoItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovoItem.setFocusable(false);
        btnNovoItem.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnNovoItemDOWN.png"))); // NOI18N
        btnNovoItem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnNovoItemDOWN.png"))); // NOI18N
        btnNovoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoItemActionPerformed(evt);
            }
        });

        btnVisualizarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnVisualizarUP.png"))); // NOI18N
        btnVisualizarItem.setBorder(null);
        btnVisualizarItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVisualizarItem.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnVisualizarDOWN.png"))); // NOI18N
        btnVisualizarItem.setEnabled(false);
        btnVisualizarItem.setFocusable(false);
        btnVisualizarItem.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnVisualizarDOWN.png"))); // NOI18N
        btnVisualizarItem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnVisualizarDOWN.png"))); // NOI18N
        btnVisualizarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarItemActionPerformed(evt);
            }
        });

        btnAlterarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnAlterarUP.png"))); // NOI18N
        btnAlterarItem.setBorder(null);
        btnAlterarItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterarItem.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnAlterarDOWN.png"))); // NOI18N
        btnAlterarItem.setEnabled(false);
        btnAlterarItem.setFocusable(false);
        btnAlterarItem.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnAlterarDOWN.png"))); // NOI18N
        btnAlterarItem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnAlterarDOWN.png"))); // NOI18N
        btnAlterarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarItemActionPerformed(evt);
            }
        });

        btnExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnExcluirUP.png"))); // NOI18N
        btnExcluirItem.setBorder(null);
        btnExcluirItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluirItem.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnExcluirDOWN.png"))); // NOI18N
        btnExcluirItem.setEnabled(false);
        btnExcluirItem.setFocusable(false);
        btnExcluirItem.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnExcluirDOWN.png"))); // NOI18N
        btnExcluirItem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnExcluirDOWN.png"))); // NOI18N
        btnExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirItemActionPerformed(evt);
            }
        });

        spnItens.setBackground(new java.awt.Color(255, 255, 255));
        spnItens.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        spnItens.setForeground(new java.awt.Color(102, 102, 102));
        spnItens.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tbItens.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbItens.setForeground(new java.awt.Color(102, 102, 102));
        tbItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbItens.setFocusable(false);
        tbItens.setGridColor(new java.awt.Color(204, 204, 204));
        tbItens.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tbItens.setRowHeight(30);
        tbItens.setSelectionBackground(new java.awt.Color(95, 180, 25));
        tbItens.setShowVerticalLines(false);
        tbItens.getTableHeader().setReorderingAllowed(false);
        tbItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbItensMouseClicked(evt);
            }
        });
        spnItens.setViewportView(tbItens);
        cabecalho = tbItens.getTableHeader();
        cabecalho.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
        cabecalho.setForeground(new java.awt.Color(102,102,102));

        lbTotalVenda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbTotalVenda.setForeground(new java.awt.Color(102, 102, 102));
        lbTotalVenda.setText("Total da venda R$");

        tfTotalVenda.setEditable(false);
        tfTotalVenda.setForeground(new java.awt.Color(102, 102, 102));
        tfTotalVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########.##"))));
        tfTotalVenda.setText("0,0");
        tfTotalVenda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnPedidoLayout = new javax.swing.GroupLayout(pnPedido);
        pnPedido.setLayout(pnPedidoLayout);
        pnPedidoLayout.setHorizontalGroup(
            pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPedidoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnNovoItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVisualizarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluirItem)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spnItens)
                .addContainerGap())
            .addGroup(pnPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTotalVenda)
                .addGap(42, 42, 42)
                .addComponent(tfTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnPedidoLayout.setVerticalGroup(
            pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNovoItem)
                        .addComponent(btnAlterarItem)
                        .addComponent(btnExcluirItem))
                    .addComponent(btnVisualizarItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnItens, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addGap(83, 83, 83)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotalVenda))
                .addContainerGap())
        );

        sprRodape.setForeground(new java.awt.Color(204, 204, 204));

        btnFinalizarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnFinalizarCompraUP.png"))); // NOI18N
        btnFinalizarCompra.setBorder(null);
        btnFinalizarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinalizarCompra.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnFinalizarCompraDOWN.png"))); // NOI18N
        btnFinalizarCompra.setFocusable(false);
        btnFinalizarCompra.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnFinalizarCompraDOWN.png"))); // NOI18N
        btnFinalizarCompra.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnFinalizarCompraDOWN.png"))); // NOI18N
        btnFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCompraActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnAlterarUP.png"))); // NOI18N
        btnAlterar.setBorder(null);
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnAlterarDOWN.png"))); // NOI18N
        btnAlterar.setFocusable(false);
        btnAlterar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnAlterarDOWN.png"))); // NOI18N
        btnAlterar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnAlterarDOWN.png"))); // NOI18N
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCorpoLayout = new javax.swing.GroupLayout(pnCorpo);
        pnCorpo.setLayout(pnCorpoLayout);
        pnCorpoLayout.setHorizontalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sprRodape)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCorpoLayout.createSequentialGroup()
                                .addComponent(lbCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbOpcional1))
                            .addComponent(lbPedido)
                            .addGroup(pnCorpoLayout.createSequentialGroup()
                                .addComponent(btnFinalizarCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCategoria)
                    .addComponent(lbOpcional1))
                .addGap(0, 0, 0)
                .addComponent(pnFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPedido)
                .addGap(0, 0, 0)
                .addComponent(pnPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(sprRodape, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar)
                    .addComponent(btnFinalizarCompra))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCorpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(pnCorpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        btnAlterar.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnAlterar.setEnabled(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCompraActionPerformed
        btnFinalizarCompra.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (tbItens.getModel().getRowCount() > 0) {
            if (compraBO.verificarEstoque(itens)) {
               
                    viewEstoque.atualizarTabelas();
                    this.dispose();
                
            }else {
                JOptionPane.showMessageDialog(null, "Quantidade maxima de produto no estoque.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insira itens para a compra primeiro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnFinalizarCompra.setEnabled(true);
    }//GEN-LAST:event_btnFinalizarCompraActionPerformed

    private void tbItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbItensMouseClicked
        if (tbItens.getSelectedRow() != -1) {
            btnAlterarItem.setEnabled(true);
            btnExcluirItem.setEnabled(true);
        }
    }//GEN-LAST:event_tbItensMouseClicked

    private void btnExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirItemActionPerformed
        if (tbItens.getSelectedRow() != -1) {
            itens.remove(tbItens.getSelectedRow());
            atualizarPagina();
        }
    }//GEN-LAST:event_btnExcluirItemActionPerformed

    private void btnAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarItemActionPerformed
        if (tbItens.getSelectedRow() != -1) {
            viewItem = new FrmItemCompra(viewPrincipal, true, this, itens.get(tbItens.getSelectedRow()), true);
            viewItem.setVisible(true);
        }
    }//GEN-LAST:event_btnAlterarItemActionPerformed

    private void btnVisualizarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVisualizarItemActionPerformed

    private void btnNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoItemActionPerformed
        viewItem = new FrmItemCompra(viewPrincipal, true, this, itens);
        viewItem.setVisible(true);
    }//GEN-LAST:event_btnNovoItemActionPerformed

    private void cbFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFornecedorActionPerformed

    //Declaração de variáveis(View).
    private final FrmBase viewPrincipal;
    private final FrmEstoque viewEstoque;
    private FrmItemCompra viewItem;

    //Declaração de variáveis(Value Object).
    private Compra compraVO;
    private final ArrayList<Itemcompra> itens;
    private final ArrayList<Pagamento> pagamentos;

    //Declaração de variáveis(Business Object).
    private CompraBO compraBO;

    //Declaração de variáveis(Tabelas).
    private TableModelItemCompra tabelaItens;
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAlterarItem;
    private javax.swing.JButton btnExcluirItem;
    private javax.swing.JButton btnFinalizarCompra;
    private javax.swing.JButton btnNovoItem;
    private javax.swing.JButton btnVisualizarItem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbFornecedor;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbOpcional1;
    private javax.swing.JLabel lbPedido;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTotalVenda;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnFornecedor;
    private javax.swing.JPanel pnPedido;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JScrollPane spnItens;
    private javax.swing.JSeparator sprRodape;
    private javax.swing.JTable tbItens;
    private javax.swing.table.JTableHeader cabecalho;
    private javax.swing.JFormattedTextField tfTotalVenda;
    // End of variables declaration//GEN-END:variables
}
