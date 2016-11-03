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
import utfpr.edu.br.papelariafacil.model.Itemvenda;
import utfpr.edu.br.papelariafacil.model.Produto;
import utfpr.edu.br.papelariafacil.model.Venda;

/**
 *
 * @author magno
 */
public class ItemvendaJpaController implements Serializable {

    public ItemvendaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Itemvenda itemvenda) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto produtoitemvenda = itemvenda.getProdutoitemvenda();
            if (produtoitemvenda != null) {
                produtoitemvenda = em.getReference(produtoitemvenda.getClass(), produtoitemvenda.getIdproduto());
                itemvenda.setProdutoitemvenda(produtoitemvenda);
            }
            Venda vendaitemvenda = itemvenda.getVendaitemvenda();
            if (vendaitemvenda != null) {
                vendaitemvenda = em.getReference(vendaitemvenda.getClass(), vendaitemvenda.getIdvenda());
                itemvenda.setVendaitemvenda(vendaitemvenda);
            }
            em.persist(itemvenda);
            if (produtoitemvenda != null) {
                produtoitemvenda.getItemvendaCollection().add(itemvenda);
                produtoitemvenda = em.merge(produtoitemvenda);
            }
            if (vendaitemvenda != null) {
                vendaitemvenda.getItemvendaCollection().add(itemvenda);
                vendaitemvenda = em.merge(vendaitemvenda);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Itemvenda itemvenda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Itemvenda persistentItemvenda = em.find(Itemvenda.class, itemvenda.getIditemvenda());
            Produto produtoitemvendaOld = persistentItemvenda.getProdutoitemvenda();
            Produto produtoitemvendaNew = itemvenda.getProdutoitemvenda();
            Venda vendaitemvendaOld = persistentItemvenda.getVendaitemvenda();
            Venda vendaitemvendaNew = itemvenda.getVendaitemvenda();
            if (produtoitemvendaNew != null) {
                produtoitemvendaNew = em.getReference(produtoitemvendaNew.getClass(), produtoitemvendaNew.getIdproduto());
                itemvenda.setProdutoitemvenda(produtoitemvendaNew);
            }
            if (vendaitemvendaNew != null) {
                vendaitemvendaNew = em.getReference(vendaitemvendaNew.getClass(), vendaitemvendaNew.getIdvenda());
                itemvenda.setVendaitemvenda(vendaitemvendaNew);
            }
            itemvenda = em.merge(itemvenda);
            if (produtoitemvendaOld != null && !produtoitemvendaOld.equals(produtoitemvendaNew)) {
                produtoitemvendaOld.getItemvendaCollection().remove(itemvenda);
                produtoitemvendaOld = em.merge(produtoitemvendaOld);
            }
            if (produtoitemvendaNew != null && !produtoitemvendaNew.equals(produtoitemvendaOld)) {
                produtoitemvendaNew.getItemvendaCollection().add(itemvenda);
                produtoitemvendaNew = em.merge(produtoitemvendaNew);
            }
            if (vendaitemvendaOld != null && !vendaitemvendaOld.equals(vendaitemvendaNew)) {
                vendaitemvendaOld.getItemvendaCollection().remove(itemvenda);
                vendaitemvendaOld = em.merge(vendaitemvendaOld);
            }
            if (vendaitemvendaNew != null && !vendaitemvendaNew.equals(vendaitemvendaOld)) {
                vendaitemvendaNew.getItemvendaCollection().add(itemvenda);
                vendaitemvendaNew = em.merge(vendaitemvendaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = itemvenda.getIditemvenda();
                if (findItemvenda(id) == null) {
                    throw new NonexistentEntityException("The itemvenda with id " + id + " no longer exists.");
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
            Itemvenda itemvenda;
            try {
                itemvenda = em.getReference(Itemvenda.class, id);
                itemvenda.getIditemvenda();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemvenda with id " + id + " no longer exists.", enfe);
            }
            Produto produtoitemvenda = itemvenda.getProdutoitemvenda();
            if (produtoitemvenda != null) {
                produtoitemvenda.getItemvendaCollection().remove(itemvenda);
                produtoitemvenda = em.merge(produtoitemvenda);
            }
            Venda vendaitemvenda = itemvenda.getVendaitemvenda();
            if (vendaitemvenda != null) {
                vendaitemvenda.getItemvendaCollection().remove(itemvenda);
                vendaitemvenda = em.merge(vendaitemvenda);
            }
            em.remove(itemvenda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Itemvenda> findItemvendaEntities() {
        return findItemvendaEntities(true, -1, -1);
    }

    public List<Itemvenda> findItemvendaEntities(int maxResults, int firstResult) {
        return findItemvendaEntities(false, maxResults, firstResult);
    }

    private List<Itemvenda> findItemvendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Itemvenda.class));
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

    public Itemvenda findItemvenda(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Itemvenda.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemvendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Itemvenda> rt = cq.from(Itemvenda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
