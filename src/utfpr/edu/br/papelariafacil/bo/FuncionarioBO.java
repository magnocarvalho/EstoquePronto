package utfpr.edu.br.papelariafacil.bo;


import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import utfpr.edu.br.papelariafacil.dao.GenericDAO;
import utfpr.edu.br.papelariafacil.vo.Funcionario;

/**
 * @see Classe de objetos de negócios. Métodos: alterarFuncionario(),
 * inserirFuncionario(), buscarPessoaFisica(), validarCampos().
 * @author
 */
public class FuncionarioBO {

    /**
     * @see Método que inseri um objeto no banco de dados por meio da
     * GenericDAO.
     * @param funcionario
     * @param nome
     * @param email
     * @param telefone
     * @param celular
     * @param cargo
     * @param usuario
     * @param senha
     * @param cpf
     * @param rg
     * @param nascimento
     * @param endereco
     * @param cep
     * @param complemento
     * @param numero
     * @param bairro
     * @param cidade
     * @param estado
     * @return true/false.
     */
    public Boolean inserirFuncionario(String nome, String email, String telefone, String celular, String cargo)        
    {       
        try{
            GenericDAO<Funcionario> dao = new GenericDAO<>();
            Funcionario f = new Funcionario();
            f.setCargofuncionario(cargo);
            f.setCelular(celular);
            f.setCriacaofuncionario(new Date());
            f.setNomefuncionario(nome);
            f.setTelefone(telefone);
            
            if (dao.inserir(f)) {
                JOptionPane.showMessageDialog(null, "Funcionário inserido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * @see Método que altera um objeto no banco de dados por meio da
     * GenericDAO.
     * @param idFuncionario
     * @param idContato
     * @param idEndereco
     * @param idPessoa
     * @param funcionario
     * @param nome
     * @param email
     * @param telefone
     * @param celular
     * @param cargo
     * @param usuario
     * @param senha
     * @param cpf
     * @param rg
     * @param nascimento
     * @param endereco
     * @param cep
     * @param complemento
     * @param numero
     * @param bairro
     * @param cidade
     * @param estado
     * @return true/false.
     */
    public Boolean alterarFuncionario(Long id, String nome, String email, String telefone, String celular, String cargo) {
        try{
            GenericDAO<Funcionario> dao = new GenericDAO<>();
            Funcionario f = new Funcionario(id.intValue());
            f.setCargofuncionario(cargo);
            f.setCelular(celular);
//            
            f.setNomefuncionario(nome);
            f.setTelefone(telefone);
            
            if (dao.atualizar(f)) {
                JOptionPane.showMessageDialog(null, "Funcionário inserido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * @see Método que retorna PessoaFisica que possua o atributo Pessoa passado
     * como parâmetro.
     * @param idPessoa
     * @return Pessoafisica/null.
     */
    

    /**
     * @see Método que verifica se os elementos do JPanel são diferentes de
     * null, usado para verificar se os campos estão preenchidos pelo usuário.
     * @param panel
     * @return false caso pelo menos um componente possuir getText() == null.
     */
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
