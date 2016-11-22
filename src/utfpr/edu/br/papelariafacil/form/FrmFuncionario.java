package utfpr.edu.br.papelariafacil.form;

import utfpr.edu.br.papelariafacil.bo.FuncionarioBO;
import utfpr.edu.br.papelariafacil.vo.Funcionario;

import java.awt.Cursor;
import java.text.SimpleDateFormat;

/**
 * @see Classe visual. JDialog que tem como objetivo cadastrar um novo usuário.
 * @author 
 */
public class FrmFuncionario extends javax.swing.JDialog {

    /**
     * @see Construtor padrão.
     * @param parent
     * @param modal
     * @param viewPainelControle
     */
    public FrmFuncionario(java.awt.Frame parent, boolean modal, FrmPainelControle viewPainelControle) {
        //Inicialização dos componentes padrões do JDialog.
        super(parent, modal);
        initComponents();
        this.viewPainelControle = viewPainelControle;
        btnAlterar.setVisible(false);
    }

    /**
     * @see Construtor usado para visualizar ou alterar um Funcionario.
     * @param parent
     * @param modal
     * @param viewPainelControle
     * @param funcionario
     * @param alterar
     */
    public FrmFuncionario(java.awt.Frame parent, boolean modal, FrmPainelControle viewPainelControle, Funcionario funcionario, Boolean alterar) {
        //Inicialização dos componentes padrões do JDialog.
        super(parent, modal);
        initComponents();
        this.viewPainelControle = viewPainelControle;
        this.funcionarioVO = funcionario;
        this.funcionarioBO = new FuncionarioBO();
    //    this.pessoaFisicaVO = funcionarioBO.buscarPessoaFisica(funcionarioVO.getPessoa().getIdPessoa());
        btnCadastrar.setVisible(false);
        lbTitulo.setText("Alterar Funcionário");

        //Definindo os atributos.
        tfNomeFuncionario.setText(funcionario.getNomefuncionario());
      //  tfNomeContato.setText(funcionario.getContato().getNomeContato());
        tfEmail.setText(funcionario.getEmailcontato());
        tfTelefone.setText(funcionario.getTelefone());
        tfCelular.setText(funcionario.getCelular());
        tfCargo.setText(funcionario.getCargofuncionario());
        
        

        //Definindo como não editável
        if (!alterar) {
            lbTitulo.setText("Funcionário");
            btnAlterar.setVisible(false);
            tfNomeFuncionario.setEditable(false);
            
            tfEmail.setEditable(false);
            tfTelefone.setEditable(false);
            tfCelular.setEditable(false);
            tfCargo.setEditable(false);
            
            
        }
    }

    //Componentes padrões do JFrame.
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTitulo = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        pnCorpo = new javax.swing.JPanel();
        pnObrigatorio = new javax.swing.JPanel();
        lbNomeFuncionario = new javax.swing.JLabel();
        tfNomeFuncionario = new javax.swing.JFormattedTextField();
        lbCargo = new javax.swing.JLabel();
        tfCargo = new javax.swing.JFormattedTextField();
        pnContato = new javax.swing.JPanel();
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JFormattedTextField();
        lbTelefone = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JFormattedTextField();
        lbCelular = new javax.swing.JLabel();
        tfCelular = new javax.swing.JFormattedTextField();
        sprDireita = new javax.swing.JSeparator();
        sprRodape = new javax.swing.JSeparator();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcionário");
        setResizable(false);

        pnTitulo.setBackground(new java.awt.Color(51, 51, 51));

        lbTitulo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setText("Novo Funcionário");

        javax.swing.GroupLayout pnTituloLayout = new javax.swing.GroupLayout(pnTitulo);
        pnTitulo.setLayout(pnTituloLayout);
        pnTituloLayout.setHorizontalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addContainerGap(544, Short.MAX_VALUE))
        );
        pnTituloLayout.setVerticalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnCorpo.setBackground(new java.awt.Color(255, 255, 255));

        pnObrigatorio.setBackground(new java.awt.Color(255, 255, 255));

        lbNomeFuncionario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbNomeFuncionario.setForeground(new java.awt.Color(102, 102, 102));
        lbNomeFuncionario.setText("Nome do Funcionario");

        tfNomeFuncionario.setForeground(new java.awt.Color(102, 102, 102));
        try {
            tfNomeFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**************************************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfNomeFuncionario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbCargo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbCargo.setForeground(new java.awt.Color(102, 102, 102));
        lbCargo.setText("Cargo");

        tfCargo.setForeground(new java.awt.Color(102, 102, 102));
        try {
            tfCargo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("********************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCargo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnObrigatorioLayout = new javax.swing.GroupLayout(pnObrigatorio);
        pnObrigatorio.setLayout(pnObrigatorioLayout);
        pnObrigatorioLayout.setHorizontalGroup(
            pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnObrigatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnObrigatorioLayout.createSequentialGroup()
                        .addComponent(lbNomeFuncionario)
                        .addGap(47, 443, Short.MAX_VALUE))
                    .addGroup(pnObrigatorioLayout.createSequentialGroup()
                        .addComponent(tfNomeFuncionario)
                        .addContainerGap())
                    .addGroup(pnObrigatorioLayout.createSequentialGroup()
                        .addComponent(lbCargo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfCargo)))
        );
        pnObrigatorioLayout.setVerticalGroup(
            pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnObrigatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNomeFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnContato.setBackground(new java.awt.Color(255, 255, 255));

        lbEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(102, 102, 102));
        lbEmail.setText("E-mail");

        tfEmail.setForeground(new java.awt.Color(102, 102, 102));
        try {
            tfEmail.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("******************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbTelefone.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbTelefone.setForeground(new java.awt.Color(102, 102, 102));
        lbTelefone.setText("Telefone");

        tfTelefone.setForeground(new java.awt.Color(102, 102, 102));
        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelefone.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbCelular.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbCelular.setForeground(new java.awt.Color(102, 102, 102));
        lbCelular.setText("Celular");

        tfCelular.setForeground(new java.awt.Color(102, 102, 102));
        try {
            tfCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCelular.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnContatoLayout = new javax.swing.GroupLayout(pnContato);
        pnContato.setLayout(pnContatoLayout);
        pnContatoLayout.setHorizontalGroup(
            pnContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbEmail)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnContatoLayout.createSequentialGroup()
                        .addComponent(lbTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbCelular)
                        .addGap(59, 59, 59))
                    .addGroup(pnContatoLayout.createSequentialGroup()
                        .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnContatoLayout.setVerticalGroup(
            pnContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContatoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail)
                    .addComponent(lbTelefone)
                    .addComponent(lbCelular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        sprDireita.setForeground(new java.awt.Color(204, 204, 204));
        sprDireita.setOrientation(javax.swing.SwingConstants.VERTICAL);

        sprRodape.setForeground(new java.awt.Color(204, 204, 204));

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnCadastrarUP.png"))); // NOI18N
        btnCadastrar.setBorder(null);
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnCadastrarDOWN.png"))); // NOI18N
        btnCadastrar.setFocusable(false);
        btnCadastrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnCadastrarDOWN.png"))); // NOI18N
        btnCadastrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/resources/imagens/btnCadastrarDOWN.png"))); // NOI18N
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
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
            .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnCorpoLayout.createSequentialGroup()
                    .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnObrigatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(sprDireita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnCorpoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnCadastrar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnAlterar)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addComponent(sprRodape)
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addComponent(pnObrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(pnContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 196, Short.MAX_VALUE))
                    .addComponent(sprDireita))
                .addGap(0, 0, 0)
                .addComponent(sprRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCorpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(pnCorpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @see Método que responde ao clique do JButton e verifica se os campos
     * estão preenchidos para alterar um novo Funcionário.
     * @param evt
     */
    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        btnAlterar.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        funcionarioBO = new FuncionarioBO();
        if (funcionarioBO.validarCampos(pnObrigatorio)) {
            if (funcionarioBO.alterarFuncionario(funcionarioVO.getIdfuncionario().longValue(), tfNomeFuncionario.getText(), tfEmail.getText(), tfTelefone.getText(), tfCelular.getText(), tfCargo.getText())) {
                viewPainelControle.atualizarTabelas();
                this.dispose();
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnAlterar.setEnabled(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

    /**
     * @see Método que responde ao clique do JButton e verifica se os campos
     * estão preenchidos para inserir um novo Funcionário.
     * @param evt
     */
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        btnCadastrar.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        funcionarioBO = new FuncionarioBO();
        if (funcionarioBO.validarCampos(pnObrigatorio)) {
            if (funcionarioBO.inserirFuncionario(tfNomeFuncionario.getText(), tfEmail.getText(), tfTelefone.getText(), tfCelular.getText(), tfCargo.getText())) {
                viewPainelControle.atualizarTabelas();
                this.dispose();
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnCadastrar.setEnabled(true);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    //Declaração de variáveis(View).
    private final FrmPainelControle viewPainelControle;

    //Declaração de variáveis(Value Object).
    private Funcionario funcionarioVO;


    //Declaração de variáveis(Business Object).
    private FuncionarioBO funcionarioBO;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JLabel lbCelular;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbNomeFuncionario;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pnContato;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnObrigatorio;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JSeparator sprDireita;
    private javax.swing.JSeparator sprRodape;
    private javax.swing.JFormattedTextField tfCargo;
    private javax.swing.JFormattedTextField tfCelular;
    private javax.swing.JFormattedTextField tfEmail;
    private javax.swing.JFormattedTextField tfNomeFuncionario;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
