/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import utfpr.edu.br.papelariafacil.jpa.exceptions.NonexistentEntityException;
import utfpr.edu.br.papelariafacil.model.Compra;
import utfpr.edu.br.papelariafacil.model.Funcionario;
import utfpr.edu.br.papelariafacil.model.Pagamento;

/**
 *
 * @author magno
 */
public class PagamentoJpaController implements Serializable {

    public PagamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pagamento pagamento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra comprapagamento = pagamento.getComprapagamento();
            if (comprapagamento != null) {
                comprapagamento = em.getReference(comprapagamento.getClass(), comprapagamento.getIdcompra());
                pagamento.setComprapagamento(comprapagamento);
            }
            Funcionario funcionariopagamento = pagamento.getFuncionariopagamento();
            if (funcionariopagamento != null) {
                funcionariopagamento = em.getReference(funcionariopagamento.getClass(), funcionariopagamento.getIdfuncionario());
                pagamento.setFuncionariopagamento(funcionariopagamento);
            }
            em.persist(pagamento);
            if (comprapagamento != null) {
                comprapagamento.getPagamentoCollection().add(pagamento);
                comprapagamento = em.merge(comprapagamento);
            }
            if (funcionariopagamento != null) {
                funcionariopagamento.getPagamentoCollection().add(pagamento);
                funcionariopagamento = em.merge(funcionariopagamento);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pagamento pagamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pagamento persistentPagamento = em.find(Pagamento.class, pagamento.getIdpagamento());
            Compra comprapagamentoOld = persistentPagamento.getComprapagamento();
            Compra comprapagamentoNew = pagamento.getComprapagamento();
            Funcionario funcionariopagamentoOld = persistentPagamento.getFuncionariopagamento();
            Funcionario funcionariopagamentoNew = pagamento.getFuncionariopagamento();
            if (comprapagamentoNew != null) {
                comprapagamentoNew = em.getReference(comprapagamentoNew.getClass(), comprapagamentoNew.getIdcompra());
                pagamento.setComprapagamento(comprapagamentoNew);
            }
            if (funcionariopagamentoNew != null) {
                funcionariopagamentoNew = em.getReference(funcionariopagamentoNew.getClass(), funcionariopagamentoNew.getIdfuncionario());
                pagamento.setFuncionariopagamento(funcionariopagamentoNew);
            }
            pagamento = em.merge(pagamento);
            if (comprapagamentoOld != null && !comprapagamentoOld.equals(comprapagamentoNew)) {
                comprapagamentoOld.getPagamentoCollection().remove(pagamento);
                comprapagamentoOld = em.merge(comprapagamentoOld);
            }
            if (comprapagamentoNew != null && !comprapagamentoNew.equals(comprapagamentoOld)) {
                comprapagamentoNew.getPagamentoCollection().add(pagamento);
                comprapagamentoNew = em.merge(comprapagamentoNew);
            }
            if (funcionariopagamentoOld != null && !funcionariopagamentoOld.equals(funcionariopagamentoNew)) {
                funcionariopagamentoOld.getPagamentoCollection().remove(pagamento);
                funcionariopagamentoOld = em.merge(funcionariopagamentoOld);
            }
            if (funcionariopagamentoNew != null && !funcionariopagamentoNew.equals(funcionariopagamentoOld)) {
                funcionariopagamentoNew.getPagamentoCollection().add(pagamento);
                funcionariopagamentoNew = em.merge(funcionariopagamentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pagamento.getIdpagamento();
                if (findPagamento(id) == null) {
                    throw new NonexistentEntityException("The pagamento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pagamento pagamento;
            try {
                pagamento = em.getReference(Pagamento.class, id);
                pagamento.getIdpagamento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pagamento with id " + id + " no longer exists.", enfe);
            }
            Compra comprapagamento = pagamento.getComprapagamento();
            if (comprapagamento != null) {
                comprapagamento.getPagamentoCollection().remove(pagamento);
                comprapagamento = em.merge(comprapagamento);
            }
            Funcionario funcionariopagamento = pagamento.getFuncionariopagamento();
            if (funcionariopagamento != null) {
                funcionariopagamento.getPagamentoCollection().remove(pagamento);
                funcionariopagamento = em.merge(funcionariopagamento);
            }
            em.remove(pagamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pagamento> findPagamentoEntities() {
        return findPagamentoEntities(true, -1, -1);
    }

    public List<Pagamento> findPagamentoEntities(int maxResults, int firstResult) {
        return findPagamentoEntities(false, maxResults, firstResult);
    }

    private List<Pagamento> findPagamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pagamento.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Pagamento findPagamento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pagamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getPagamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pagamento> rt = cq.from(Pagamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
