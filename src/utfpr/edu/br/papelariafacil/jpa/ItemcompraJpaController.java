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
import utfpr.edu.br.papelariafacil.model.Itemcompra;
import utfpr.edu.br.papelariafacil.model.Produto;

/**
 *
 * @author magno
 */
public class ItemcompraJpaController implements Serializable {

    public ItemcompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Itemcompra itemcompra) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra compraitemcompra = itemcompra.getCompraitemcompra();
            if (compraitemcompra != null) {
                compraitemcompra = em.getReference(compraitemcompra.getClass(), compraitemcompra.getIdcompra());
                itemcompra.setCompraitemcompra(compraitemcompra);
            }
            Produto produtoitemcompra = itemcompra.getProdutoitemcompra();
            if (produtoitemcompra != null) {
                produtoitemcompra = em.getReference(produtoitemcompra.getClass(), produtoitemcompra.getIdproduto());
                itemcompra.setProdutoitemcompra(produtoitemcompra);
            }
            em.persist(itemcompra);
            if (compraitemcompra != null) {
                compraitemcompra.getItemcompraCollection().add(itemcompra);
                compraitemcompra = em.merge(compraitemcompra);
            }
            if (produtoitemcompra != null) {
                produtoitemcompra.getItemcompraCollection().add(itemcompra);
                produtoitemcompra = em.merge(produtoitemcompra);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Itemcompra itemcompra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Itemcompra persistentItemcompra = em.find(Itemcompra.class, itemcompra.getIditemcompra());
            Compra compraitemcompraOld = persistentItemcompra.getCompraitemcompra();
            Compra compraitemcompraNew = itemcompra.getCompraitemcompra();
            Produto produtoitemcompraOld = persistentItemcompra.getProdutoitemcompra();
            Produto produtoitemcompraNew = itemcompra.getProdutoitemcompra();
            if (compraitemcompraNew != null) {
                compraitemcompraNew = em.getReference(compraitemcompraNew.getClass(), compraitemcompraNew.getIdcompra());
                itemcompra.setCompraitemcompra(compraitemcompraNew);
            }
            if (produtoitemcompraNew != null) {
                produtoitemcompraNew = em.getReference(produtoitemcompraNew.getClass(), produtoitemcompraNew.getIdproduto());
                itemcompra.setProdutoitemcompra(produtoitemcompraNew);
            }
            itemcompra = em.merge(itemcompra);
            if (compraitemcompraOld != null && !compraitemcompraOld.equals(compraitemcompraNew)) {
                compraitemcompraOld.getItemcompraCollection().remove(itemcompra);
                compraitemcompraOld = em.merge(compraitemcompraOld);
            }
            if (compraitemcompraNew != null && !compraitemcompraNew.equals(compraitemcompraOld)) {
                compraitemcompraNew.getItemcompraCollection().add(itemcompra);
                compraitemcompraNew = em.merge(compraitemcompraNew);
            }
            if (produtoitemcompraOld != null && !produtoitemcompraOld.equals(produtoitemcompraNew)) {
                produtoitemcompraOld.getItemcompraCollection().remove(itemcompra);
                produtoitemcompraOld = em.merge(produtoitemcompraOld);
            }
            if (produtoitemcompraNew != null && !produtoitemcompraNew.equals(produtoitemcompraOld)) {
                produtoitemcompraNew.getItemcompraCollection().add(itemcompra);
                produtoitemcompraNew = em.merge(produtoitemcompraNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = itemcompra.getIditemcompra();
                if (findItemcompra(id) == null) {
                    throw new NonexistentEntityException("The itemcompra with id " + id + " no longer exists.");
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
            Itemcompra itemcompra;
            try {
                itemcompra = em.getReference(Itemcompra.class, id);
                itemcompra.getIditemcompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemcompra with id " + id + " no longer exists.", enfe);
            }
            Compra compraitemcompra = itemcompra.getCompraitemcompra();
            if (compraitemcompra != null) {
                compraitemcompra.getItemcompraCollection().remove(itemcompra);
                compraitemcompra = em.merge(compraitemcompra);
            }
            Produto produtoitemcompra = itemcompra.getProdutoitemcompra();
            if (produtoitemcompra != null) {
                produtoitemcompra.getItemcompraCollection().remove(itemcompra);
                produtoitemcompra = em.merge(produtoitemcompra);
            }
            em.remove(itemcompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Itemcompra> findItemcompraEntities() {
        return findItemcompraEntities(true, -1, -1);
    }

    public List<Itemcompra> findItemcompraEntities(int maxResults, int firstResult) {
        return findItemcompraEntities(false, maxResults, firstResult);
    }

    private List<Itemcompra> findItemcompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Itemcompra.class));
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

    public Itemcompra findItemcompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Itemcompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemcompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Itemcompra> rt = cq.from(Itemcompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
