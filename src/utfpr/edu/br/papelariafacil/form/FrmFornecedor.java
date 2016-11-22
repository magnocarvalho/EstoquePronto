package utfpr.edu.br.papelariafacil.form;


import utfpr.edu.br.papelariafacil.vo.Fornecedor;
import java.awt.Cursor;
import java.text.SimpleDateFormat;
import utfpr.edu.br.papelariafacil.bo.FornecedorBO;

/**
 * @see Classe visual. JDialog que tem como objetivo cadastrar um novo
 * fornecedor.
// * @author
 */

public class FrmFornecedor extends javax.swing.JDialog 
{

    /**
     * @see Construtor padrão.
     * @param viewPainelControle
     * @param parent
     * @param modal
     */
    public FrmFornecedor(java.awt.Frame parent, boolean modal, FrmPainelControle viewPainelControle) {
        //Inicialização dos componentes padrões do JDialog.
        super(parent, modal);
        initComponents();

        this.viewPainelControle = viewPainelControle;
        this.fornecedorBO = new FornecedorBO();
        btnAlterar.setVisible(false);
    }

    /**
     * @see Construtor usado para visualizar ou alterar um Fornecedor.
     * @param fornecedor
     * @param alterar
     * @param viewPainelControle
     * @param parent
     * @param modal
     */
    public FrmFornecedor(java.awt.Frame parent, boolean modal, FrmPainelControle viewPainelControle, Fornecedor fornecedor, Boolean alterar) {
        //Inicialização dos componentes padrões do JDialog.
        super(parent, modal);
        initComponents();
        this.viewPainelControle = viewPainelControle;
        this.fornecedorBO = new FornecedorBO();
        this.fornecedorVO = fornecedor;
        btnCadastrar.setVisible(false);
        

        //Definindo os atributos.
        tfNomeFornecedor.setText(fornecedor.getNomefornecedor());
        tfNomeContato.setText(fornecedor.getRazaosocialpessoajuridica());
        tfEmail.setText(fornecedor.getEmailcontato());
        tfTelefone.setText(fornecedor.getTelefonecontato());
        tfCelular.setText(fornecedor.getCelularcontato());
        tfEndereco.setText(fornecedor.getEndereco());
        tfCep.setText(fornecedor.getCep());
        tfComplemento.setText(fornecedor.getComplemento());
        tfNumero.setText(fornecedor.getNumeroendereco());
        tfBairro.setText(fornecedor.getBairro());
        tfCidade.setText(fornecedor.getCidade());
        tfEstado.setText(fornecedor.getEstado());
//        if ("Fisica".equals(fornecedor.getPessoa().getTipoPessoa())) {
//            rbPessoaFisica.doClick();
//            Pessoafisica pessoaFisica = fornecedorBO.buscarPessoaFisica(fornecedor.getPessoa().getIdPessoa());
//            tfCpf.setText(pessoaFisica.getCpfPessoaFisica());
//            tfRg.setText(pessoaFisica.getRgPessoaFisica());
//            tfNascimento.setText(new SimpleDateFormat("dd/MM/yyyy").format(pessoaFisica.getNascimentoPessoaFisica()));
//        } else {
//            rbPessoaJuridica.doClick();
//            Pessoajuridica pessoaJuridica = fornecedorBO.buscarPessoaJuridica(fornecedor.getPessoa().getIdPessoa());
//            tfRazao.setText(pessoaJuridica.getRazaoSocialPessoaJuridica());
//            tfNomeFantasia.setText(pessoaJuridica.getNomeFantasiaPessoaJuridica());
//            tfCnpj.setText(pessoaJuridica.getCnpjPessoaJuridica());
//            tfEstadual.setText(pessoaJuridica.getEstadualPessoaJuridica());
//            tfMunicipal.setText(pessoaJuridica.getMunicipalPessoaJuridica());
//            tfSuframa.setText(pessoaJuridica.getSuframaPessoaJuridica());
//            if (pessoaJuridica.getTributoSimplesPessoaJuridica()) {
//                rbSimples.doClick();
//            }
//            if (pessoaJuridica.getImportacaoPessoaJuridica()) {
//                rbTaxas.doClick();
//            }
//            if (pessoaJuridica.getIcmsPessoaJuridica()) {
//                rbIcms.doClick();
//            }
//            tfFundacao.setText(new SimpleDateFormat("dd/MM/yyyy").format(pessoaJuridica.getFundacaoPessoaJuridica()));
//        }

        //Definindo como não editável
//        if (!alterar) {
//            lbTitulo.setText("Cliente");
//            btnAlterar.setVisible(false);
//            tfNomeFornecedor.setEditable(false);
//            tfNomeContato.setEditable(false);
//            tfEmail.setEditable(false);
//            tfTelefone.setEditable(false);
//            tfCelular.setEditable(false);
//            tfEndereco.setEditable(false);
//            tfCep.setEditable(false);
//            tfComplemento.setEditable(false);
//            tfNumero.setEditable(false);
//            tfBairro.setEditable(false);
//            tfCidade.setEditable(false);
//            tfEstado.setEditable(false);
//            rbPessoaFisica.setEnabled(false);
//            rbPessoaJuridica.setEnabled(false);
//            tfRg.setEditable(false);
//            tfCpf.setEditable(false);
//            tfNascimento.setEditable(false);
//            tfRazao.setEditable(false);
//            tfNomeFantasia.setEditable(false);
//            tfCnpj.setEditable(false);
//            tfEstadual.setEditable(false);
//            tfMunicipal.setEditable(false);
//            tfSuframa.setEditable(false);
//            rbSimples.setEnabled(false);
//            rbTaxas.setEnabled(false);
//            rbIcms.setEnabled(false);
//            tfFundacao.setEditable(false);
//        }
    }

    //Componentes padrões do JFrame.
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnTitulo = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        pnCorpo = new javax.swing.JPanel();
        pnObrigatorio = new javax.swing.JPanel();
        lbNomeFornecedor = new javax.swing.JLabel();
        tfNomeFornecedor = new javax.swing.JFormattedTextField();
        pnContato = new javax.swing.JPanel();
        lbNomeContato = new javax.swing.JLabel();
        tfNomeContato = new javax.swing.JFormattedTextField();
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JFormattedTextField();
        lbTelefone = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JFormattedTextField();
        lbCelular = new javax.swing.JLabel();
        tfCelular = new javax.swing.JFormattedTextField();
        lbMaisEndereco = new javax.swing.JLabel();
        lbOpcional2 = new javax.swing.JLabel();
        pnEndereco = new javax.swing.JPanel();
        lbEndereco2 = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JFormattedTextField();
        lbCep = new javax.swing.JLabel();
        tfCep = new javax.swing.JFormattedTextField();
        lbComplemento = new javax.swing.JLabel();
        tfComplemento = new javax.swing.JFormattedTextField();
        lbBairro = new javax.swing.JLabel();
        tfBairro = new javax.swing.JFormattedTextField();
        lbNumero = new javax.swing.JLabel();
        tfNumero = new javax.swing.JFormattedTextField();
        lbCidade = new javax.swing.JLabel();
        tfCidade = new javax.swing.JFormattedTextField();
        lbEstado = new javax.swing.JLabel();
        tfEstado = new javax.swing.JFormattedTextField();
        sprDireita = new javax.swing.JSeparator();
        sprRodape = new javax.swing.JSeparator();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        tfCnpj = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Forecedor");

        pnTitulo.setBackground(new java.awt.Color(51, 51, 51));

        lbTitulo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setText("Novo Fornecedor");

        javax.swing.GroupLayout pnTituloLayout = new javax.swing.GroupLayout(pnTitulo);
        pnTitulo.setLayout(pnTituloLayout);
        pnTituloLayout.setHorizontalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addContainerGap(452, Short.MAX_VALUE))
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

        lbNomeFornecedor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbNomeFornecedor.setForeground(new java.awt.Color(102, 102, 102));
        lbNomeFornecedor.setText("Nome do Fornecedor");

        tfNomeFornecedor.setForeground(new java.awt.Color(102, 102, 102));
        try {
            tfNomeFornecedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**************************************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfNomeFornecedor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNomeFornecedor.setNextFocusableComponent(tfNomeContato);

        javax.swing.GroupLayout pnObrigatorioLayout = new javax.swing.GroupLayout(pnObrigatorio);
        pnObrigatorio.setLayout(pnObrigatorioLayout);
        pnObrigatorioLayout.setHorizontalGroup(
            pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnObrigatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnObrigatorioLayout.createSequentialGroup()
                        .addComponent(lbNomeFornecedor)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfNomeFornecedor))
                .addContainerGap())
        );
        pnObrigatorioLayout.setVerticalGroup(
            pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnObrigatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNomeFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnContato.setBackground(new java.awt.Color(255, 255, 255));

        lbNomeContato.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbNomeContato.setForeground(new java.awt.Color(102, 102, 102));
        lbNomeContato.setText("Razão Social");

        tfNomeContato.setForeground(new java.awt.Color(102, 102, 102));
        try {
            tfNomeContato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**************************************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfNomeContato.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

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
                    .addComponent(tfNomeContato)
                    .addGroup(pnContatoLayout.createSequentialGroup()
                        .addGroup(pnContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnContatoLayout.createSequentialGroup()
                                .addComponent(lbNomeContato)
                                .addGap(459, 459, 459))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnContatoLayout.createSequentialGroup()
                                .addGroup(pnContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbEmail)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnContatoLayout.createSequentialGroup()
                                        .addComponent(lbTelefone)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbCelular)
                                        .addGap(59, 59, 59))
                                    .addGroup(pnContatoLayout.createSequentialGroup()
                                        .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfCelular)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnContatoLayout.setVerticalGroup(
            pnContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNomeContato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNomeContato, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        lbMaisEndereco.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        lbMaisEndereco.setForeground(new java.awt.Color(0, 102, 205));
        lbMaisEndereco.setText("endereço");

        lbOpcional2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        lbOpcional2.setForeground(new java.awt.Color(102, 102, 102));
        lbOpcional2.setText("(Opcional)");

        pnEndereco.setBackground(new java.awt.Color(255, 255, 255));

        lbEndereco2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbEndereco2.setForeground(new java.awt.Color(102, 102, 102));
        lbEndereco2.setText("Endereço");

        tfEndereco.setForeground(new java.awt.Color(102, 102, 102));
        try {
            tfEndereco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**************************************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfEndereco.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbCep.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbCep.setForeground(new java.awt.Color(102, 102, 102));
        lbCep.setText("CEP");

        tfCep.setForeground(new java.awt.Color(102, 102, 102));
        try {
            tfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCep.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbComplemento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbComplemento.setForeground(new java.awt.Color(102, 102, 102));
        lbComplemento.setText("Complemento");

        tfComplemento.setForeground(new java.awt.Color(102, 102, 102));
        try {
            tfComplemento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("********************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfComplemento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbBairro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbBairro.setForeground(new java.awt.Color(102, 102, 102));
        lbBairro.setText("Bairro");

        tfBairro.setForeground(new java.awt.Color(102, 102, 102));
        try {
            tfBairro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("********************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfBairro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbNumero.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbNumero.setForeground(new java.awt.Color(102, 102, 102));
        lbNumero.setText("Número");

        tfNumero.setForeground(new java.awt.Color(102, 102, 102));
        tfNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########.##"))));
        tfNumero.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbCidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbCidade.setForeground(new java.awt.Color(102, 102, 102));
        lbCidade.setText("Cidade");

        tfCidade.setForeground(new java.awt.Color(102, 102, 102));
        try {
            tfCidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("********************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbEstado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbEstado.setForeground(new java.awt.Color(102, 102, 102));
        lbEstado.setText("Estado");

        tfEstado.setForeground(new java.awt.Color(102, 102, 102));
        try {
            tfEstado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("********************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfEstado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnEnderecoLayout = new javax.swing.GroupLayout(pnEndereco);
        pnEndereco.setLayout(pnEnderecoLayout);
        pnEnderecoLayout.setHorizontalGroup(
            pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfEndereco)
                    .addGroup(pnEnderecoLayout.createSequentialGroup()
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCep))
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnEnderecoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbComplemento)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnEnderecoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfBairro))))
                    .addGroup(pnEnderecoLayout.createSequentialGroup()
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnEnderecoLayout.createSequentialGroup()
                                .addComponent(lbNumero)
                                .addGap(49, 49, 49))
                            .addGroup(pnEnderecoLayout.createSequentialGroup()
                                .addComponent(tfNumero)
                                .addGap(6, 6, 6)))
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnEnderecoLayout.createSequentialGroup()
                                .addComponent(lbCidade)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnEnderecoLayout.createSequentialGroup()
                                .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfEstado))))
                    .addGroup(pnEnderecoLayout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBairro)
                            .addComponent(lbEstado)))
                    .addComponent(lbEndereco2))
                .addContainerGap())
        );
        pnEnderecoLayout.setVerticalGroup(
            pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbEndereco2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnEnderecoLayout.createSequentialGroup()
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCep)
                            .addComponent(lbComplemento)
                            .addComponent(lbBairro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNumero)
                            .addComponent(lbEstado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnEnderecoLayout.createSequentialGroup()
                        .addComponent(lbCidade)
                        .addGap(36, 36, 36)))
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

        jLabel1.setText("CNPJ");

        javax.swing.GroupLayout pnCorpoLayout = new javax.swing.GroupLayout(pnCorpo);
        pnCorpo.setLayout(pnCorpoLayout);
        pnCorpoLayout.setHorizontalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sprRodape)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar))
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pnObrigatorio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnEndereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnContato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnCorpoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbMaisEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbOpcional2))
                            .addGroup(pnCorpoLayout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sprDireita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sprDireita)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addComponent(pnObrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMaisEndereco)
                            .addComponent(lbOpcional2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(sprRodape, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrar)
                    .addComponent(btnAlterar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 127, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @see Método que responde ao clique do JRadioButton e altera os atributos
     * para o padrão da Pessoa Fisíca.
     * @param evt
     */
    /**
     * @see Método que responde ao clique do JRadioButton e altera os atributos
     * para o padrão da Pessoa Jurídica.
     * @param evt
     */
    /**
     * @see Método que responde ao clique do JButton e verifica se os campos
     * estão preenchidos para inserir um novo Fornecedor.
     * @param evt
     */
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        btnCadastrar.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (fornecedorBO.validarCampos(pnObrigatorio)) {
            if (fornecedorBO.inserirFornecedor(tfNomeFornecedor.getText(), tfNomeContato.getText(), tfCnpj.getText(),  tfEmail.getText(), tfTelefone.getText(), tfCelular.getText(), tfEndereco.getText(), tfCep.getText(), tfComplemento.getText(), tfNumero.getText(), tfBairro.getText(), tfCidade.getText(), tfEstado.getText() )) {
                viewPainelControle.atualizarTabelas();
                this.dispose();
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnCadastrar.setEnabled(true);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    /**
     * @see Método que responde ao clique do JButton e verifica se os campos
     * estão preenchidos para alterar um novo Fornecedor.
     * @param evt
     */
    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        btnAlterar.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (fornecedorBO.validarCampos(pnObrigatorio)) {
            if (fornecedorBO.alterarFornecedor(fornecedorVO.getIdfornecedor().longValue(), tfNomeFornecedor.getText(), tfNomeContato.getText(), tfCnpj.getText(), tfEmail.getText(), tfTelefone.getText(), tfCelular.getText(), tfEndereco.getText(), tfCep.getText(), tfComplemento.getText(), tfNumero.getText(), tfBairro.getText(), tfCidade.getText(), tfEstado.getText())) {
                viewPainelControle.atualizarTabelas();
                this.dispose();
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnAlterar.setEnabled(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

    //Declaração de variáveis(View).
    private final FrmPainelControle viewPainelControle;

    //Declaração de variáveis(Business Object).
    private final FornecedorBO fornecedorBO;

    //Declaração de variáveis(Value Object).
    private Fornecedor fornecedorVO;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCelular;
    private javax.swing.JLabel lbCep;
    private javax.swing.JLabel lbCidade;
    private javax.swing.JLabel lbComplemento;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEndereco2;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbMaisEndereco;
    private javax.swing.JLabel lbNomeContato;
    private javax.swing.JLabel lbNomeFornecedor;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbOpcional2;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pnContato;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnEndereco;
    private javax.swing.JPanel pnObrigatorio;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JSeparator sprDireita;
    private javax.swing.JSeparator sprRodape;
    private javax.swing.JFormattedTextField tfBairro;
    private javax.swing.JFormattedTextField tfCelular;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JFormattedTextField tfCidade;
    private javax.swing.JTextField tfCnpj;
    private javax.swing.JFormattedTextField tfComplemento;
    private javax.swing.JFormattedTextField tfEmail;
    private javax.swing.JFormattedTextField tfEndereco;
    private javax.swing.JFormattedTextField tfEstado;
    private javax.swing.JFormattedTextField tfNomeContato;
    private javax.swing.JFormattedTextField tfNomeFornecedor;
    private javax.swing.JFormattedTextField tfNumero;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
