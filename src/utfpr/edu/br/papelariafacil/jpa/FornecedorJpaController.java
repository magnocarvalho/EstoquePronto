/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.jpa;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import utfpr.edu.br.papelariafacil.model.Compra;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utfpr.edu.br.papelariafacil.jpa.exceptions.NonexistentEntityException;
import utfpr.edu.br.papelariafacil.model.Fornecedor;
import utfpr.edu.br.papelariafacil.model.Produto;

/**
 *
 * @author magno
 */
public class FornecedorJpaController implements Serializable {

    public FornecedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Fornecedor fornecedor) {
        if (fornecedor.getCompraCollection() == null) {
            fornecedor.setCompraCollection(new ArrayList<Compra>());
        }
        if (fornecedor.getProdutoCollection() == null) {
            fornecedor.setProdutoCollection(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Compra> attachedCompraCollection = new ArrayList<Compra>();
            for (Compra compraCollectionCompraToAttach : fornecedor.getCompraCollection()) {
                compraCollectionCompraToAttach = em.getReference(compraCollectionCompraToAttach.getClass(), compraCollectionCompraToAttach.getIdcompra());
                attachedCompraCollection.add(compraCollectionCompraToAttach);
            }
            fornecedor.setCompraCollection(attachedCompraCollection);
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : fornecedor.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getIdproduto());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            fornecedor.setProdutoCollection(attachedProdutoCollection);
            em.persist(fornecedor);
            for (Compra compraCollectionCompra : fornecedor.getCompraCollection()) {
                Fornecedor oldFornecedorcompraOfCompraCollectionCompra = compraCollectionCompra.getFornecedorcompra();
                compraCollectionCompra.setFornecedorcompra(fornecedor);
                compraCollectionCompra = em.merge(compraCollectionCompra);
                if (oldFornecedorcompraOfCompraCollectionCompra != null) {
                    oldFornecedorcompraOfCompraCollectionCompra.getCompraCollection().remove(compraCollectionCompra);
                    oldFornecedorcompraOfCompraCollectionCompra = em.merge(oldFornecedorcompraOfCompraCollectionCompra);
                }
            }
            for (Produto produtoCollectionProduto : fornecedor.getProdutoCollection()) {
                Fornecedor oldFornecedorprodutoOfProdutoCollectionProduto = produtoCollectionProduto.getFornecedorproduto();
                produtoCollectionProduto.setFornecedorproduto(fornecedor);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldFornecedorprodutoOfProdutoCollectionProduto != null) {
                    oldFornecedorprodutoOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldFornecedorprodutoOfProdutoCollectionProduto = em.merge(oldFornecedorprodutoOfProdutoCollectionProduto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Fornecedor fornecedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Fornecedor persistentFornecedor = em.find(Fornecedor.class, fornecedor.getIdfornecedor());
            Collection<Compra> compraCollectionOld = persistentFornecedor.getCompraCollection();
            Collection<Compra> compraCollectionNew = fornecedor.getCompraCollection();
            Collection<Produto> produtoCollectionOld = persistentFornecedor.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = fornecedor.getProdutoCollection();
            Collection<Compra> attachedCompraCollectionNew = new ArrayList<Compra>();
            for (Compra compraCollectionNewCompraToAttach : compraCollectionNew) {
                compraCollectionNewCompraToAttach = em.getReference(compraCollectionNewCompraToAttach.getClass(), compraCollectionNewCompraToAttach.getIdcompra());
                attachedCompraCollectionNew.add(compraCollectionNewCompraToAttach);
            }
            compraCollectionNew = attachedCompraCollectionNew;
            fornecedor.setCompraCollection(compraCollectionNew);
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getIdproduto());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            fornecedor.setProdutoCollection(produtoCollectionNew);
            fornecedor = em.merge(fornecedor);
            for (Compra compraCollectionOldCompra : compraCollectionOld) {
                if (!compraCollectionNew.contains(compraCollectionOldCompra)) {
                    compraCollectionOldCompra.setFornecedorcompra(null);
                    compraCollectionOldCompra = em.merge(compraCollectionOldCompra);
                }
            }
            for (Compra compraCollectionNewCompra : compraCollectionNew) {
                if (!compraCollectionOld.contains(compraCollectionNewCompra)) {
                    Fornecedor oldFornecedorcompraOfCompraCollectionNewCompra = compraCollectionNewCompra.getFornecedorcompra();
                    compraCollectionNewCompra.setFornecedorcompra(fornecedor);
                    compraCollectionNewCompra = em.merge(compraCollectionNewCompra);
                    if (oldFornecedorcompraOfCompraCollectionNewCompra != null && !oldFornecedorcompraOfCompraCollectionNewCompra.equals(fornecedor)) {
                        oldFornecedorcompraOfCompraCollectionNewCompra.getCompraCollection().remove(compraCollectionNewCompra);
                        oldFornecedorcompraOfCompraCollectionNewCompra = em.merge(oldFornecedorcompraOfCompraCollectionNewCompra);
                    }
                }
            }
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setFornecedorproduto(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Fornecedor oldFornecedorprodutoOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getFornecedorproduto();
                    produtoCollectionNewProduto.setFornecedorproduto(fornecedor);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldFornecedorprodutoOfProdutoCollectionNewProduto != null && !oldFornecedorprodutoOfProdutoCollectionNewProduto.equals(fornecedor)) {
                        oldFornecedorprodutoOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldFornecedorprodutoOfProdutoCollectionNewProduto = em.merge(oldFornecedorprodutoOfProdutoCollectionNewProduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = fornecedor.getIdfornecedor();
                if (findFornecedor(id) == null) {
                    throw new NonexistentEntityException("The fornecedor with id " + id + " no longer exists.");
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
            Fornecedor fornecedor;
            try {
                fornecedor = em.getReference(Fornecedor.class, id);
                fornecedor.getIdfornecedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fornecedor with id " + id + " no longer exists.", enfe);
            }
            Collection<Compra> compraCollection = fornecedor.getCompraCollection();
            for (Compra compraCollectionCompra : compraCollection) {
                compraCollectionCompra.setFornecedorcompra(null);
                compraCollectionCompra = em.merge(compraCollectionCompra);
            }
            Collection<Produto> produtoCollection = fornecedor.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setFornecedorproduto(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            em.remove(fornecedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Fornecedor> findFornecedorEntities() {
        return findFornecedorEntities(true, -1, -1);
    }

    public List<Fornecedor> findFornecedorEntities(int maxResults, int firstResult) {
        return findFornecedorEntities(false, maxResults, firstResult);
    }

    private List<Fornecedor> findFornecedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Fornecedor.class));
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

    public Fornecedor findFornecedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fornecedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getFornecedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Fornecedor> rt = cq.from(Fornecedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
