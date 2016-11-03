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
import utfpr.edu.br.papelariafacil.model.Funcionario;
import utfpr.edu.br.papelariafacil.model.Recebimento;
import utfpr.edu.br.papelariafacil.model.Venda;

/**
 *
 * @author magno
 */
public class RecebimentoJpaController implements Serializable {

    public RecebimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Recebimento recebimento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario funcionariorecebimento = recebimento.getFuncionariorecebimento();
            if (funcionariorecebimento != null) {
                funcionariorecebimento = em.getReference(funcionariorecebimento.getClass(), funcionariorecebimento.getIdfuncionario());
                recebimento.setFuncionariorecebimento(funcionariorecebimento);
            }
            Venda vendarecebimento = recebimento.getVendarecebimento();
            if (vendarecebimento != null) {
                vendarecebimento = em.getReference(vendarecebimento.getClass(), vendarecebimento.getIdvenda());
                recebimento.setVendarecebimento(vendarecebimento);
            }
            em.persist(recebimento);
            if (funcionariorecebimento != null) {
                funcionariorecebimento.getRecebimentoCollection().add(recebimento);
                funcionariorecebimento = em.merge(funcionariorecebimento);
            }
            if (vendarecebimento != null) {
                vendarecebimento.getRecebimentoCollection().add(recebimento);
                vendarecebimento = em.merge(vendarecebimento);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Recebimento recebimento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Recebimento persistentRecebimento = em.find(Recebimento.class, recebimento.getIdrecebimento());
            Funcionario funcionariorecebimentoOld = persistentRecebimento.getFuncionariorecebimento();
            Funcionario funcionariorecebimentoNew = recebimento.getFuncionariorecebimento();
            Venda vendarecebimentoOld = persistentRecebimento.getVendarecebimento();
            Venda vendarecebimentoNew = recebimento.getVendarecebimento();
            if (funcionariorecebimentoNew != null) {
                funcionariorecebimentoNew = em.getReference(funcionariorecebimentoNew.getClass(), funcionariorecebimentoNew.getIdfuncionario());
                recebimento.setFuncionariorecebimento(funcionariorecebimentoNew);
            }
            if (vendarecebimentoNew != null) {
                vendarecebimentoNew = em.getReference(vendarecebimentoNew.getClass(), vendarecebimentoNew.getIdvenda());
                recebimento.setVendarecebimento(vendarecebimentoNew);
            }
            recebimento = em.merge(recebimento);
            if (funcionariorecebimentoOld != null && !funcionariorecebimentoOld.equals(funcionariorecebimentoNew)) {
                funcionariorecebimentoOld.getRecebimentoCollection().remove(recebimento);
                funcionariorecebimentoOld = em.merge(funcionariorecebimentoOld);
            }
            if (funcionariorecebimentoNew != null && !funcionariorecebimentoNew.equals(funcionariorecebimentoOld)) {
                funcionariorecebimentoNew.getRecebimentoCollection().add(recebimento);
                funcionariorecebimentoNew = em.merge(funcionariorecebimentoNew);
            }
            if (vendarecebimentoOld != null && !vendarecebimentoOld.equals(vendarecebimentoNew)) {
                vendarecebimentoOld.getRecebimentoCollection().remove(recebimento);
                vendarecebimentoOld = em.merge(vendarecebimentoOld);
            }
            if (vendarecebimentoNew != null && !vendarecebimentoNew.equals(vendarecebimentoOld)) {
                vendarecebimentoNew.getRecebimentoCollection().add(recebimento);
                vendarecebimentoNew = em.merge(vendarecebimentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = recebimento.getIdrecebimento();
                if (findRecebimento(id) == null) {
                    throw new NonexistentEntityException("The recebimento with id " + id + " no longer exists.");
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
            Recebimento recebimento;
            try {
                recebimento = em.getReference(Recebimento.class, id);
                recebimento.getIdrecebimento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The recebimento with id " + id + " no longer exists.", enfe);
            }
            Funcionario funcionariorecebimento = recebimento.getFuncionariorecebimento();
            if (funcionariorecebimento != null) {
                funcionariorecebimento.getRecebimentoCollection().remove(recebimento);
                funcionariorecebimento = em.merge(funcionariorecebimento);
            }
            Venda vendarecebimento = recebimento.getVendarecebimento();
            if (vendarecebimento != null) {
                vendarecebimento.getRecebimentoCollection().remove(recebimento);
                vendarecebimento = em.merge(vendarecebimento);
            }
            em.remove(recebimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Recebimento> findRecebimentoEntities() {
        return findRecebimentoEntities(true, -1, -1);
    }

    public List<Recebimento> findRecebimentoEntities(int maxResults, int firstResult) {
        return findRecebimentoEntities(false, maxResults, firstResult);
    }

    private List<Recebimento> findRecebimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Recebimento.class));
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

    public Recebimento findRecebimento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Recebimento.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecebimentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Recebimento> rt = cq.from(Recebimento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
