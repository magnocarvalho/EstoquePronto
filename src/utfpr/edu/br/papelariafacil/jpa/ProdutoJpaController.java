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
import utfpr.edu.br.papelariafacil.model.Categoria;
import utfpr.edu.br.papelariafacil.model.Fornecedor;
import utfpr.edu.br.papelariafacil.model.Itemvenda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utfpr.edu.br.papelariafacil.jpa.exceptions.NonexistentEntityException;
import utfpr.edu.br.papelariafacil.model.Itemcompra;
import utfpr.edu.br.papelariafacil.model.Produto;

/**
 *
 * @author magno
 */
public class ProdutoJpaController implements Serializable {

    public ProdutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produto produto) {
        if (produto.getItemvendaCollection() == null) {
            produto.setItemvendaCollection(new ArrayList<Itemvenda>());
        }
        if (produto.getItemcompraCollection() == null) {
            produto.setItemcompraCollection(new ArrayList<Itemcompra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria categoriaproduto = produto.getCategoriaproduto();
            if (categoriaproduto != null) {
                categoriaproduto = em.getReference(categoriaproduto.getClass(), categoriaproduto.getIdcategoria());
                produto.setCategoriaproduto(categoriaproduto);
            }
            Fornecedor fornecedorproduto = produto.getFornecedorproduto();
            if (fornecedorproduto != null) {
                fornecedorproduto = em.getReference(fornecedorproduto.getClass(), fornecedorproduto.getIdfornecedor());
                produto.setFornecedorproduto(fornecedorproduto);
            }
            Collection<Itemvenda> attachedItemvendaCollection = new ArrayList<Itemvenda>();
            for (Itemvenda itemvendaCollectionItemvendaToAttach : produto.getItemvendaCollection()) {
                itemvendaCollectionItemvendaToAttach = em.getReference(itemvendaCollectionItemvendaToAttach.getClass(), itemvendaCollectionItemvendaToAttach.getIditemvenda());
                attachedItemvendaCollection.add(itemvendaCollectionItemvendaToAttach);
            }
            produto.setItemvendaCollection(attachedItemvendaCollection);
            Collection<Itemcompra> attachedItemcompraCollection = new ArrayList<Itemcompra>();
            for (Itemcompra itemcompraCollectionItemcompraToAttach : produto.getItemcompraCollection()) {
                itemcompraCollectionItemcompraToAttach = em.getReference(itemcompraCollectionItemcompraToAttach.getClass(), itemcompraCollectionItemcompraToAttach.getIditemcompra());
                attachedItemcompraCollection.add(itemcompraCollectionItemcompraToAttach);
            }
            produto.setItemcompraCollection(attachedItemcompraCollection);
            em.persist(produto);
            if (categoriaproduto != null) {
                categoriaproduto.getProdutoCollection().add(produto);
                categoriaproduto = em.merge(categoriaproduto);
            }
            if (fornecedorproduto != null) {
                fornecedorproduto.getProdutoCollection().add(produto);
                fornecedorproduto = em.merge(fornecedorproduto);
            }
            for (Itemvenda itemvendaCollectionItemvenda : produto.getItemvendaCollection()) {
                Produto oldProdutoitemvendaOfItemvendaCollectionItemvenda = itemvendaCollectionItemvenda.getProdutoitemvenda();
                itemvendaCollectionItemvenda.setProdutoitemvenda(produto);
                itemvendaCollectionItemvenda = em.merge(itemvendaCollectionItemvenda);
                if (oldProdutoitemvendaOfItemvendaCollectionItemvenda != null) {
                    oldProdutoitemvendaOfItemvendaCollectionItemvenda.getItemvendaCollection().remove(itemvendaCollectionItemvenda);
                    oldProdutoitemvendaOfItemvendaCollectionItemvenda = em.merge(oldProdutoitemvendaOfItemvendaCollectionItemvenda);
                }
            }
            for (Itemcompra itemcompraCollectionItemcompra : produto.getItemcompraCollection()) {
                Produto oldProdutoitemcompraOfItemcompraCollectionItemcompra = itemcompraCollectionItemcompra.getProdutoitemcompra();
                itemcompraCollectionItemcompra.setProdutoitemcompra(produto);
                itemcompraCollectionItemcompra = em.merge(itemcompraCollectionItemcompra);
                if (oldProdutoitemcompraOfItemcompraCollectionItemcompra != null) {
                    oldProdutoitemcompraOfItemcompraCollectionItemcompra.getItemcompraCollection().remove(itemcompraCollectionItemcompra);
                    oldProdutoitemcompraOfItemcompraCollectionItemcompra = em.merge(oldProdutoitemcompraOfItemcompraCollectionItemcompra);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produto produto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto persistentProduto = em.find(Produto.class, produto.getIdproduto());
            Categoria categoriaprodutoOld = persistentProduto.getCategoriaproduto();
            Categoria categoriaprodutoNew = produto.getCategoriaproduto();
            Fornecedor fornecedorprodutoOld = persistentProduto.getFornecedorproduto();
            Fornecedor fornecedorprodutoNew = produto.getFornecedorproduto();
            Collection<Itemvenda> itemvendaCollectionOld = persistentProduto.getItemvendaCollection();
            Collection<Itemvenda> itemvendaCollectionNew = produto.getItemvendaCollection();
            Collection<Itemcompra> itemcompraCollectionOld = persistentProduto.getItemcompraCollection();
            Collection<Itemcompra> itemcompraCollectionNew = produto.getItemcompraCollection();
            if (categoriaprodutoNew != null) {
                categoriaprodutoNew = em.getReference(categoriaprodutoNew.getClass(), categoriaprodutoNew.getIdcategoria());
                produto.setCategoriaproduto(categoriaprodutoNew);
            }
            if (fornecedorprodutoNew != null) {
                fornecedorprodutoNew = em.getReference(fornecedorprodutoNew.getClass(), fornecedorprodutoNew.getIdfornecedor());
                produto.setFornecedorproduto(fornecedorprodutoNew);
            }
            Collection<Itemvenda> attachedItemvendaCollectionNew = new ArrayList<Itemvenda>();
            for (Itemvenda itemvendaCollectionNewItemvendaToAttach : itemvendaCollectionNew) {
                itemvendaCollectionNewItemvendaToAttach = em.getReference(itemvendaCollectionNewItemvendaToAttach.getClass(), itemvendaCollectionNewItemvendaToAttach.getIditemvenda());
                attachedItemvendaCollectionNew.add(itemvendaCollectionNewItemvendaToAttach);
            }
            itemvendaCollectionNew = attachedItemvendaCollectionNew;
            produto.setItemvendaCollection(itemvendaCollectionNew);
            Collection<Itemcompra> attachedItemcompraCollectionNew = new ArrayList<Itemcompra>();
            for (Itemcompra itemcompraCollectionNewItemcompraToAttach : itemcompraCollectionNew) {
                itemcompraCollectionNewItemcompraToAttach = em.getReference(itemcompraCollectionNewItemcompraToAttach.getClass(), itemcompraCollectionNewItemcompraToAttach.getIditemcompra());
                attachedItemcompraCollectionNew.add(itemcompraCollectionNewItemcompraToAttach);
            }
            itemcompraCollectionNew = attachedItemcompraCollectionNew;
            produto.setItemcompraCollection(itemcompraCollectionNew);
            produto = em.merge(produto);
            if (categoriaprodutoOld != null && !categoriaprodutoOld.equals(categoriaprodutoNew)) {
                categoriaprodutoOld.getProdutoCollection().remove(produto);
                categoriaprodutoOld = em.merge(categoriaprodutoOld);
            }
            if (categoriaprodutoNew != null && !categoriaprodutoNew.equals(categoriaprodutoOld)) {
                categoriaprodutoNew.getProdutoCollection().add(produto);
                categoriaprodutoNew = em.merge(categoriaprodutoNew);
            }
            if (fornecedorprodutoOld != null && !fornecedorprodutoOld.equals(fornecedorprodutoNew)) {
                fornecedorprodutoOld.getProdutoCollection().remove(produto);
                fornecedorprodutoOld = em.merge(fornecedorprodutoOld);
            }
            if (fornecedorprodutoNew != null && !fornecedorprodutoNew.equals(fornecedorprodutoOld)) {
                fornecedorprodutoNew.getProdutoCollection().add(produto);
                fornecedorprodutoNew = em.merge(fornecedorprodutoNew);
            }
            for (Itemvenda itemvendaCollectionOldItemvenda : itemvendaCollectionOld) {
                if (!itemvendaCollectionNew.contains(itemvendaCollectionOldItemvenda)) {
                    itemvendaCollectionOldItemvenda.setProdutoitemvenda(null);
                    itemvendaCollectionOldItemvenda = em.merge(itemvendaCollectionOldItemvenda);
                }
            }
            for (Itemvenda itemvendaCollectionNewItemvenda : itemvendaCollectionNew) {
                if (!itemvendaCollectionOld.contains(itemvendaCollectionNewItemvenda)) {
                    Produto oldProdutoitemvendaOfItemvendaCollectionNewItemvenda = itemvendaCollectionNewItemvenda.getProdutoitemvenda();
                    itemvendaCollectionNewItemvenda.setProdutoitemvenda(produto);
                    itemvendaCollectionNewItemvenda = em.merge(itemvendaCollectionNewItemvenda);
                    if (oldProdutoitemvendaOfItemvendaCollectionNewItemvenda != null && !oldProdutoitemvendaOfItemvendaCollectionNewItemvenda.equals(produto)) {
                        oldProdutoitemvendaOfItemvendaCollectionNewItemvenda.getItemvendaCollection().remove(itemvendaCollectionNewItemvenda);
                        oldProdutoitemvendaOfItemvendaCollectionNewItemvenda = em.merge(oldProdutoitemvendaOfItemvendaCollectionNewItemvenda);
                    }
                }
            }
            for (Itemcompra itemcompraCollectionOldItemcompra : itemcompraCollectionOld) {
                if (!itemcompraCollectionNew.contains(itemcompraCollectionOldItemcompra)) {
                    itemcompraCollectionOldItemcompra.setProdutoitemcompra(null);
                    itemcompraCollectionOldItemcompra = em.merge(itemcompraCollectionOldItemcompra);
                }
            }
            for (Itemcompra itemcompraCollectionNewItemcompra : itemcompraCollectionNew) {
                if (!itemcompraCollectionOld.contains(itemcompraCollectionNewItemcompra)) {
                    Produto oldProdutoitemcompraOfItemcompraCollectionNewItemcompra = itemcompraCollectionNewItemcompra.getProdutoitemcompra();
                    itemcompraCollectionNewItemcompra.setProdutoitemcompra(produto);
                    itemcompraCollectionNewItemcompra = em.merge(itemcompraCollectionNewItemcompra);
                    if (oldProdutoitemcompraOfItemcompraCollectionNewItemcompra != null && !oldProdutoitemcompraOfItemcompraCollectionNewItemcompra.equals(produto)) {
                        oldProdutoitemcompraOfItemcompraCollectionNewItemcompra.getItemcompraCollection().remove(itemcompraCollectionNewItemcompra);
                        oldProdutoitemcompraOfItemcompraCollectionNewItemcompra = em.merge(oldProdutoitemcompraOfItemcompraCollectionNewItemcompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = produto.getIdproduto();
                if (findProduto(id) == null) {
                    throw new NonexistentEntityException("The produto with id " + id + " no longer exists.");
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
            Produto produto;
            try {
                produto = em.getReference(Produto.class, id);
                produto.getIdproduto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produto with id " + id + " no longer exists.", enfe);
            }
            Categoria categoriaproduto = produto.getCategoriaproduto();
            if (categoriaproduto != null) {
                categoriaproduto.getProdutoCollection().remove(produto);
                categoriaproduto = em.merge(categoriaproduto);
            }
            Fornecedor fornecedorproduto = produto.getFornecedorproduto();
            if (fornecedorproduto != null) {
                fornecedorproduto.getProdutoCollection().remove(produto);
                fornecedorproduto = em.merge(fornecedorproduto);
            }
            Collection<Itemvenda> itemvendaCollection = produto.getItemvendaCollection();
            for (Itemvenda itemvendaCollectionItemvenda : itemvendaCollection) {
                itemvendaCollectionItemvenda.setProdutoitemvenda(null);
                itemvendaCollectionItemvenda = em.merge(itemvendaCollectionItemvenda);
            }
            Collection<Itemcompra> itemcompraCollection = produto.getItemcompraCollection();
            for (Itemcompra itemcompraCollectionItemcompra : itemcompraCollection) {
                itemcompraCollectionItemcompra.setProdutoitemcompra(null);
                itemcompraCollectionItemcompra = em.merge(itemcompraCollectionItemcompra);
            }
            em.remove(produto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produto> findProdutoEntities() {
        return findProdutoEntities(true, -1, -1);
    }

    public List<Produto> findProdutoEntities(int maxResults, int firstResult) {
        return findProdutoEntities(false, maxResults, firstResult);
    }

    private List<Produto> findProdutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produto.class));
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

    public Produto findProduto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produto> rt = cq.from(Produto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
