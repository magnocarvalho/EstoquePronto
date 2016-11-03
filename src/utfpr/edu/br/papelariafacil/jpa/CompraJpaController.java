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
import utfpr.edu.br.papelariafacil.model.Fornecedor;
import utfpr.edu.br.papelariafacil.model.Funcionario;
import utfpr.edu.br.papelariafacil.model.Pagamento;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utfpr.edu.br.papelariafacil.jpa.exceptions.NonexistentEntityException;
import utfpr.edu.br.papelariafacil.model.Compra;
import utfpr.edu.br.papelariafacil.model.Itemcompra;

/**
 *
 * @author magno
 */
public class CompraJpaController implements Serializable {

    public CompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Compra compra) {
        if (compra.getPagamentoCollection() == null) {
            compra.setPagamentoCollection(new ArrayList<Pagamento>());
        }
        if (compra.getItemcompraCollection() == null) {
            compra.setItemcompraCollection(new ArrayList<Itemcompra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Fornecedor fornecedorcompra = compra.getFornecedorcompra();
            if (fornecedorcompra != null) {
                fornecedorcompra = em.getReference(fornecedorcompra.getClass(), fornecedorcompra.getIdfornecedor());
                compra.setFornecedorcompra(fornecedorcompra);
            }
            Funcionario funcionariocompra = compra.getFuncionariocompra();
            if (funcionariocompra != null) {
                funcionariocompra = em.getReference(funcionariocompra.getClass(), funcionariocompra.getIdfuncionario());
                compra.setFuncionariocompra(funcionariocompra);
            }
            Collection<Pagamento> attachedPagamentoCollection = new ArrayList<Pagamento>();
            for (Pagamento pagamentoCollectionPagamentoToAttach : compra.getPagamentoCollection()) {
                pagamentoCollectionPagamentoToAttach = em.getReference(pagamentoCollectionPagamentoToAttach.getClass(), pagamentoCollectionPagamentoToAttach.getIdpagamento());
                attachedPagamentoCollection.add(pagamentoCollectionPagamentoToAttach);
            }
            compra.setPagamentoCollection(attachedPagamentoCollection);
            Collection<Itemcompra> attachedItemcompraCollection = new ArrayList<Itemcompra>();
            for (Itemcompra itemcompraCollectionItemcompraToAttach : compra.getItemcompraCollection()) {
                itemcompraCollectionItemcompraToAttach = em.getReference(itemcompraCollectionItemcompraToAttach.getClass(), itemcompraCollectionItemcompraToAttach.getIditemcompra());
                attachedItemcompraCollection.add(itemcompraCollectionItemcompraToAttach);
            }
            compra.setItemcompraCollection(attachedItemcompraCollection);
            em.persist(compra);
            if (fornecedorcompra != null) {
                fornecedorcompra.getCompraCollection().add(compra);
                fornecedorcompra = em.merge(fornecedorcompra);
            }
            if (funcionariocompra != null) {
                funcionariocompra.getCompraCollection().add(compra);
                funcionariocompra = em.merge(funcionariocompra);
            }
            for (Pagamento pagamentoCollectionPagamento : compra.getPagamentoCollection()) {
                Compra oldComprapagamentoOfPagamentoCollectionPagamento = pagamentoCollectionPagamento.getComprapagamento();
                pagamentoCollectionPagamento.setComprapagamento(compra);
                pagamentoCollectionPagamento = em.merge(pagamentoCollectionPagamento);
                if (oldComprapagamentoOfPagamentoCollectionPagamento != null) {
                    oldComprapagamentoOfPagamentoCollectionPagamento.getPagamentoCollection().remove(pagamentoCollectionPagamento);
                    oldComprapagamentoOfPagamentoCollectionPagamento = em.merge(oldComprapagamentoOfPagamentoCollectionPagamento);
                }
            }
            for (Itemcompra itemcompraCollectionItemcompra : compra.getItemcompraCollection()) {
                Compra oldCompraitemcompraOfItemcompraCollectionItemcompra = itemcompraCollectionItemcompra.getCompraitemcompra();
                itemcompraCollectionItemcompra.setCompraitemcompra(compra);
                itemcompraCollectionItemcompra = em.merge(itemcompraCollectionItemcompra);
                if (oldCompraitemcompraOfItemcompraCollectionItemcompra != null) {
                    oldCompraitemcompraOfItemcompraCollectionItemcompra.getItemcompraCollection().remove(itemcompraCollectionItemcompra);
                    oldCompraitemcompraOfItemcompraCollectionItemcompra = em.merge(oldCompraitemcompraOfItemcompraCollectionItemcompra);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Compra compra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra persistentCompra = em.find(Compra.class, compra.getIdcompra());
            Fornecedor fornecedorcompraOld = persistentCompra.getFornecedorcompra();
            Fornecedor fornecedorcompraNew = compra.getFornecedorcompra();
            Funcionario funcionariocompraOld = persistentCompra.getFuncionariocompra();
            Funcionario funcionariocompraNew = compra.getFuncionariocompra();
            Collection<Pagamento> pagamentoCollectionOld = persistentCompra.getPagamentoCollection();
            Collection<Pagamento> pagamentoCollectionNew = compra.getPagamentoCollection();
            Collection<Itemcompra> itemcompraCollectionOld = persistentCompra.getItemcompraCollection();
            Collection<Itemcompra> itemcompraCollectionNew = compra.getItemcompraCollection();
            if (fornecedorcompraNew != null) {
                fornecedorcompraNew = em.getReference(fornecedorcompraNew.getClass(), fornecedorcompraNew.getIdfornecedor());
                compra.setFornecedorcompra(fornecedorcompraNew);
            }
            if (funcionariocompraNew != null) {
                funcionariocompraNew = em.getReference(funcionariocompraNew.getClass(), funcionariocompraNew.getIdfuncionario());
                compra.setFuncionariocompra(funcionariocompraNew);
            }
            Collection<Pagamento> attachedPagamentoCollectionNew = new ArrayList<Pagamento>();
            for (Pagamento pagamentoCollectionNewPagamentoToAttach : pagamentoCollectionNew) {
                pagamentoCollectionNewPagamentoToAttach = em.getReference(pagamentoCollectionNewPagamentoToAttach.getClass(), pagamentoCollectionNewPagamentoToAttach.getIdpagamento());
                attachedPagamentoCollectionNew.add(pagamentoCollectionNewPagamentoToAttach);
            }
            pagamentoCollectionNew = attachedPagamentoCollectionNew;
            compra.setPagamentoCollection(pagamentoCollectionNew);
            Collection<Itemcompra> attachedItemcompraCollectionNew = new ArrayList<Itemcompra>();
            for (Itemcompra itemcompraCollectionNewItemcompraToAttach : itemcompraCollectionNew) {
                itemcompraCollectionNewItemcompraToAttach = em.getReference(itemcompraCollectionNewItemcompraToAttach.getClass(), itemcompraCollectionNewItemcompraToAttach.getIditemcompra());
                attachedItemcompraCollectionNew.add(itemcompraCollectionNewItemcompraToAttach);
            }
            itemcompraCollectionNew = attachedItemcompraCollectionNew;
            compra.setItemcompraCollection(itemcompraCollectionNew);
            compra = em.merge(compra);
            if (fornecedorcompraOld != null && !fornecedorcompraOld.equals(fornecedorcompraNew)) {
                fornecedorcompraOld.getCompraCollection().remove(compra);
                fornecedorcompraOld = em.merge(fornecedorcompraOld);
            }
            if (fornecedorcompraNew != null && !fornecedorcompraNew.equals(fornecedorcompraOld)) {
                fornecedorcompraNew.getCompraCollection().add(compra);
                fornecedorcompraNew = em.merge(fornecedorcompraNew);
            }
            if (funcionariocompraOld != null && !funcionariocompraOld.equals(funcionariocompraNew)) {
                funcionariocompraOld.getCompraCollection().remove(compra);
                funcionariocompraOld = em.merge(funcionariocompraOld);
            }
            if (funcionariocompraNew != null && !funcionariocompraNew.equals(funcionariocompraOld)) {
                funcionariocompraNew.getCompraCollection().add(compra);
                funcionariocompraNew = em.merge(funcionariocompraNew);
            }
            for (Pagamento pagamentoCollectionOldPagamento : pagamentoCollectionOld) {
                if (!pagamentoCollectionNew.contains(pagamentoCollectionOldPagamento)) {
                    pagamentoCollectionOldPagamento.setComprapagamento(null);
                    pagamentoCollectionOldPagamento = em.merge(pagamentoCollectionOldPagamento);
                }
            }
            for (Pagamento pagamentoCollectionNewPagamento : pagamentoCollectionNew) {
                if (!pagamentoCollectionOld.contains(pagamentoCollectionNewPagamento)) {
                    Compra oldComprapagamentoOfPagamentoCollectionNewPagamento = pagamentoCollectionNewPagamento.getComprapagamento();
                    pagamentoCollectionNewPagamento.setComprapagamento(compra);
                    pagamentoCollectionNewPagamento = em.merge(pagamentoCollectionNewPagamento);
                    if (oldComprapagamentoOfPagamentoCollectionNewPagamento != null && !oldComprapagamentoOfPagamentoCollectionNewPagamento.equals(compra)) {
                        oldComprapagamentoOfPagamentoCollectionNewPagamento.getPagamentoCollection().remove(pagamentoCollectionNewPagamento);
                        oldComprapagamentoOfPagamentoCollectionNewPagamento = em.merge(oldComprapagamentoOfPagamentoCollectionNewPagamento);
                    }
                }
            }
            for (Itemcompra itemcompraCollectionOldItemcompra : itemcompraCollectionOld) {
                if (!itemcompraCollectionNew.contains(itemcompraCollectionOldItemcompra)) {
                    itemcompraCollectionOldItemcompra.setCompraitemcompra(null);
                    itemcompraCollectionOldItemcompra = em.merge(itemcompraCollectionOldItemcompra);
                }
            }
            for (Itemcompra itemcompraCollectionNewItemcompra : itemcompraCollectionNew) {
                if (!itemcompraCollectionOld.contains(itemcompraCollectionNewItemcompra)) {
                    Compra oldCompraitemcompraOfItemcompraCollectionNewItemcompra = itemcompraCollectionNewItemcompra.getCompraitemcompra();
                    itemcompraCollectionNewItemcompra.setCompraitemcompra(compra);
                    itemcompraCollectionNewItemcompra = em.merge(itemcompraCollectionNewItemcompra);
                    if (oldCompraitemcompraOfItemcompraCollectionNewItemcompra != null && !oldCompraitemcompraOfItemcompraCollectionNewItemcompra.equals(compra)) {
                        oldCompraitemcompraOfItemcompraCollectionNewItemcompra.getItemcompraCollection().remove(itemcompraCollectionNewItemcompra);
                        oldCompraitemcompraOfItemcompraCollectionNewItemcompra = em.merge(oldCompraitemcompraOfItemcompraCollectionNewItemcompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = compra.getIdcompra();
                if (findCompra(id) == null) {
                    throw new NonexistentEntityException("The compra with id " + id + " no longer exists.");
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
            Compra compra;
            try {
                compra = em.getReference(Compra.class, id);
                compra.getIdcompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compra with id " + id + " no longer exists.", enfe);
            }
            Fornecedor fornecedorcompra = compra.getFornecedorcompra();
            if (fornecedorcompra != null) {
                fornecedorcompra.getCompraCollection().remove(compra);
                fornecedorcompra = em.merge(fornecedorcompra);
            }
            Funcionario funcionariocompra = compra.getFuncionariocompra();
            if (funcionariocompra != null) {
                funcionariocompra.getCompraCollection().remove(compra);
                funcionariocompra = em.merge(funcionariocompra);
            }
            Collection<Pagamento> pagamentoCollection = compra.getPagamentoCollection();
            for (Pagamento pagamentoCollectionPagamento : pagamentoCollection) {
                pagamentoCollectionPagamento.setComprapagamento(null);
                pagamentoCollectionPagamento = em.merge(pagamentoCollectionPagamento);
            }
            Collection<Itemcompra> itemcompraCollection = compra.getItemcompraCollection();
            for (Itemcompra itemcompraCollectionItemcompra : itemcompraCollection) {
                itemcompraCollectionItemcompra.setCompraitemcompra(null);
                itemcompraCollectionItemcompra = em.merge(itemcompraCollectionItemcompra);
            }
            em.remove(compra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Compra> findCompraEntities() {
        return findCompraEntities(true, -1, -1);
    }

    public List<Compra> findCompraEntities(int maxResults, int firstResult) {
        return findCompraEntities(false, maxResults, firstResult);
    }

    private List<Compra> findCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Compra.class));
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

    public Compra findCompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compra.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Compra> rt = cq.from(Compra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
