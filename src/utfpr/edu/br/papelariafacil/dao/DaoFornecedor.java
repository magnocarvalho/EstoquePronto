/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.dao;
import java.util.List;
import org.hibernate.Query;
import utfpr.edu.br.papelariafacil.vo.Fornecedor;
/**
 *
 * @author Magno
 */
public class DaoFornecedor extends DaoGenerics<Fornecedor> {

    public DaoFornecedor() {
        super.alvo = Fornecedor.class;
    }

    public List<Fornecedor> obterNome(String descricao) {
        List<Fornecedor> lista = null;
        if (descricao != null || !"".equals(descricao)) {

            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where nomefornecedor LIKE '%"
                    + descricao + "%'");
            lista = query.list();
        }
        return lista;
    }
    public List<Fornecedor> obterCnpj(String descricao) {
        List<Fornecedor> lista = null;
        if (descricao != null || !"".equals(descricao)) {

            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where cnpjpessoajuridica LIKE '"
                    + descricao + "%'");
            lista = query.list();
        }
        return lista;
    }
    public List<Fornecedor> obterRazao(String descricao) {
        List<Fornecedor> lista = null;
        if (descricao != null || !"".equals(descricao)) {

            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where razaosocialpessoajuridica LIKE '%"
                    + descricao + "%'");
            lista = query.list();
        }
        return lista;
    }
   
}
