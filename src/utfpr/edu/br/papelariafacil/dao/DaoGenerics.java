/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.dao;

import utfpr.edu.br.papelariafacil.conexao.TransactionUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author JoaoPaulo
 */
public abstract class DaoGenerics<T> {

  protected Session session = TransactionUtil.getCurrentSession();
    protected Class alvo;

    public void persistir(T o) {
        session.saveOrUpdate(o);
        session.flush();
    }

    public void remover(T o) {
        session.delete(o);
        session.flush();
    }

    public T obterPorId(int id) {
        T objeto = null;
        if (id > 0) {
            Query select = session.createQuery("From " + alvo.getSimpleName() + " where id = " + id);
            objeto = (T) select.uniqueResult();
        }
        return objeto;
    }
    public void atualizar(T o)
    {
        session.update(o);
        session.flush();
    }
    
    public List<T> listar() {
        List<T> lista = null;        
        Query query = session.createQuery("from " + alvo.getSimpleName());
        lista = query.list();   
           
        return lista;
    }
    public int contar()
    {
        int i;
        Query query = session.createQuery("from" + alvo.getSimpleName() +" GROUP BY id");
        i = query.getFirstResult();
        i++;
        
        return i;
    }
}