package utfpr.edu.br.papelariafacil.dao;

import utfpr.edu.br.papelariafacil.util.HibernateUtil2;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * @see @see Classe de objetos de acesso ao banco de dados. Métodos: inserir(),
 * atualizar(), apagar(), consultar().
 * @author Magno
 * @param <T> obejeto genérico que substitui como parâmetro todos os objetos de
 * valores do sistema.
 */
public class GenericDAO<T> {

    //Declaração da sessão de conexão ao banco de dados.
    private final Session session = (Session) HibernateUtil2.getSession();

    /**
     * @see Método INSERT INTO.
     * @param obj objeto de valor que abstrai uma linha do banco.
     * @return T obj
     */
    public Boolean inserir(T obj) {
        try {
            session.beginTransaction();
            session.persist(obj);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * @see Método UPDATE.
     * @param obj objeto de valor que abstrai uma linha do banco.
     * @return T obj
     */
    public Boolean atualizar(T obj) {
        try {
            session.beginTransaction();
            session.saveOrUpdate(obj);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * @see Método DELETE.
     * @param obj objeto de valor que abstrai uma linha do banco.
     * @return
     */
    public Boolean apagar(T obj) {
        try {
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * @see Método SELECT *.
     * @param obj objeto de valor que abstrai uma linha do banco.
     * @return Lista de obejtos do parâmetro.
     */
    public List<T> consultar(T obj) {
        Criteria c = session.createCriteria(obj.getClass());
        return c.list();
    }

    /**
     * @see Método SELECT WHERE(campo = valor).
     * @param campo nome da linha no BD.
     * @param valor valor da linha no BD.
     * @param obj objeto de valor que abstrai uma linha do banco.
     * @return obejeto do parâmetro que a consulta localizar.
     */
    public T consultar(String campo, Long valor, T obj) {
        Criteria c = session.createCriteria(obj.getClass());
        c.add(Restrictions.eq(campo, valor));
        if (c.list() == null) {
            return null;
        } else {
            return (T) c.uniqueResult();
        }
    }

    /**
     * @see Método SELECT WHERE(campo1 = valor1 AND campo2 = valor2).
     * @param campo1 primeiro nome da linha no BD.
     * @param valor1 primeiro valor da linha no BD.
     * @param campo2 segundo nome da linha no BD.
     * @param valor2 segundo valor da linha no BD.
     * @param obj objeto de valor que abstrai uma linha do banco.
     * @return obejeto do parâmetro que a consulta localizar quando dos dois
     * critérios forem verdadeiros.
     */
    public T consultar(String campo1, String valor1, String campo2, String valor2, T obj) {
        Criteria c = session.createCriteria(obj.getClass());
        c.add(Restrictions.eq(campo1, valor1));
        c.add(Restrictions.eq(campo2, valor2));
        if (c.list() == null) {
            return null;
        } else {
            return (T) c.uniqueResult();
        }
    }

    /**
     * @see Método SELECT ORDER BY(campo).
     * @param campo nome da linha no BD.
     * @param obj objeto de valor que abstrai uma linha do banco.
     * @return único resultado de uma lista de objetos do parâmetro ordenados
     * pelo campo do parâmetro.
     */
    public T consultar(String campo, T obj) {
        Criteria c = session.createCriteria(obj.getClass());
        c.addOrder(Order.desc(campo));
        c.setMaxResults(1);
        session.close();
        if (c.list() == null) {
            return null;
        } else {
            return (T) c.uniqueResult();
        }
    }
}

