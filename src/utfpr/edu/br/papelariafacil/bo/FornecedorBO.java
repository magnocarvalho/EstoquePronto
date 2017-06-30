package utfpr.edu.br.papelariafacil.bo;

import java.awt.Color;
import java.awt.Component;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import utfpr.edu.br.papelariafacil.dao.GenericDAO;
import utfpr.edu.br.papelariafacil.vo.Fornecedor;

/**
 * @see Classe de objetos de negócios. Métodos: alterarFornecedor(),
 * inserirFornecedor(), buscarPessoaFisica(), buscarPessoaJuridica(),
 * validarCampos().
 * @author 
 */
public class FornecedorBO {

    /**
     * @see Método que inseri um objeto no banco de dados por meio da
     * GenericDAO.
     * @param cpf
     * @param taxa
     * @param rg
     * @param simples
     * @param fantasia
     * @param razao
     * @param cnpj
     * @param fundacao
     * @param fornecedor
     * @param nome
     * @param email
     * @param telefone
     * @param celular
     * @param endereco
     * @param cep
     * @param complemento
     * @param numero
     * @param bairro
     * @param cidade
     * @param estado
     * @param pessoa
     * @param nascimento
     * @param estadual
     * @param municipal
     * @param suframa
     * @param icms
     * @return true/false
     */
    /* */   
    public Boolean inserirFornecedor(String fornecedor, String RazaoSocial, String Cnpj, String email, String telefone, String celular, String endereco, String cep, String complemento, String numero, String bairro, String cidade, String estado )
    {
        try {
            GenericDAO<Fornecedor> dao = new GenericDAO<>();
            Fornecedor f = new Fornecedor();
            List<Fornecedor> consultar = dao.consultar(f);
            int i = consultar.size();
            f.setIdfornecedor(i + 1);
            f.setBairro(bairro);
            f.setCep(cep);
            f.setCelularcontato(celular);
            f.setTelefonecontato(telefone);
            f.setCnpjpessoajuridica(Cnpj);
            f.setCidade(cidade);
            f.setComplemento(complemento);
            f.setNomefornecedor(fornecedor);
            f.setRazaosocialpessoajuridica(RazaoSocial);
            f.setEmailcontato(email);
            f.setEstado(estado);
            f.setNumeroendereco(numero);
            dao.inserir(f);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }public Boolean alterarFornecedor(Long id, String fornecedor, String RazaoSocial, String Cnpj, String email, String telefone, String celular, String endereco, String cep, String complemento, String numero, String bairro, String cidade, String estado )
    {
        try {
            GenericDAO<Fornecedor> dao = new GenericDAO<>();
            Fornecedor f = new Fornecedor(id.intValue());
            f.setBairro(bairro);
            f.setCep(cep);
            f.setCelularcontato(celular);
            f.setTelefonecontato(telefone);
            f.setCnpjpessoajuridica(Cnpj);
            f.setCidade(cidade);
            f.setComplemento(complemento);
            f.setNomefornecedor(fornecedor);
            f.setRazaosocialpessoajuridica(RazaoSocial);
            f.setEmailcontato(email);
            f.setEstado(estado);
            f.setNumeroendereco(numero);
            dao.atualizar(f);
            return true;
        } catch (Exception e) {
            return false;
        }
     
    }
    public boolean validarCampos(JPanel panel) {
        Component componentes[] = panel.getComponents();
        boolean erro = true;
        for (Component c : componentes) {
            if (c instanceof JTextField) {
                if (((JTextField) c).isEnabled()) {
                    if (((JTextField) c).getText().trim().equals("")) {
                        ((JTextField) c).setBorder(new LineBorder(Color.RED));
                        erro = false;
                    } else {
                        ((JTextField) c).setBorder(new LineBorder(Color.LIGHT_GRAY));
                    }
                } else {
                    ((JTextField) c).setBorder(new LineBorder(Color.LIGHT_GRAY));
                }
            }
        }
        return erro;
    }
    
}
