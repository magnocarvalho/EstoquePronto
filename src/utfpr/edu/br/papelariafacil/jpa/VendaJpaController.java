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
import utfpr.edu.br.papelariafacil.model.Funcionario;
import utfpr.edu.br.papelariafacil.model.Itemvenda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utfpr.edu.br.papelariafacil.jpa.exceptions.NonexistentEntityException;
import utfpr.edu.br.papelariafacil.model.Recebimento;
import utfpr.edu.br.papelariafacil.model.Venda;

/**
 *
 * @author magno
 */
public class VendaJpaController implements Serializable {

    public VendaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venda venda) {
        if (venda.getItemvendaCollection() == null) {
            venda.setItemvendaCollection(new ArrayList<Itemvenda>());
        }
        if (venda.getRecebimentoCollection() == null) {
            venda.setRecebimentoCollection(new ArrayList<Recebimento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario funcionariovenda = venda.getFuncionariovenda();
            if (funcionariovenda != null) {
                funcionariovenda = em.getReference(funcionariovenda.getClass(), funcionariovenda.getIdfuncionario());
                venda.setFuncionariovenda(funcionariovenda);
            }
            Collection<Itemvenda> attachedItemvendaCollection = new ArrayList<Itemvenda>();
            for (Itemvenda itemvendaCollectionItemvendaToAttach : venda.getItemvendaCollection()) {
                itemvendaCollectionItemvendaToAttach = em.getReference(itemvendaCollectionItemvendaToAttach.getClass(), itemvendaCollectionItemvendaToAttach.getIditemvenda());
                attachedItemvendaCollection.add(itemvendaCollectionItemvendaToAttach);
            }
            venda.setItemvendaCollection(attachedItemvendaCollection);
            Collection<Recebimento> attachedRecebimentoCollection = new ArrayList<Recebimento>();
            for (Recebimento recebimentoCollectionRecebimentoToAttach : venda.getRecebimentoCollection()) {
                recebimentoCollectionRecebimentoToAttach = em.getReference(recebimentoCollectionRecebimentoToAttach.getClass(), recebimentoCollectionRecebimentoToAttach.getIdrecebimento());
                attachedRecebimentoCollection.add(recebimentoCollectionRecebimentoToAttach);
            }
            venda.setRecebimentoCollection(attachedRecebimentoCollection);
            em.persist(venda);
            if (funcionariovenda != null) {
                funcionariovenda.getVendaCollection().add(venda);
                funcionariovenda = em.merge(funcionariovenda);
            }
            for (Itemvenda itemvendaCollectionItemvenda : venda.getItemvendaCollection()) {
                Venda oldVendaitemvendaOfItemvendaCollectionItemvenda = itemvendaCollectionItemvenda.getVendaitemvenda();
                itemvendaCollectionItemvenda.setVendaitemvenda(venda);
                itemvendaCollectionItemvenda = em.merge(itemvendaCollectionItemvenda);
                if (oldVendaitemvendaOfItemvendaCollectionItemvenda != null) {
                    oldVendaitemvendaOfItemvendaCollectionItemvenda.getItemvendaCollection().remove(itemvendaCollectionItemvenda);
                    oldVendaitemvendaOfItemvendaCollectionItemvenda = em.merge(oldVendaitemvendaOfItemvendaCollectionItemvenda);
                }
            }
            for (Recebimento recebimentoCollectionRecebimento : venda.getRecebimentoCollection()) {
                Venda oldVendarecebimentoOfRecebimentoCollectionRecebimento = recebimentoCollectionRecebimento.getVendarecebimento();
                recebimentoCollectionRecebimento.setVendarecebimento(venda);
                recebimentoCollectionRecebimento = em.merge(recebimentoCollectionRecebimento);
                if (oldVendarecebimentoOfRecebimentoCollectionRecebimento != null) {
                    oldVendarecebimentoOfRecebimentoCollectionRecebimento.getRecebimentoCollection().remove(recebimentoCollectionRecebimento);
                    oldVendarecebimentoOfRecebimentoCollectionRecebimento = em.merge(oldVendarecebimentoOfRecebimentoCollectionRecebimento);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venda venda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venda persistentVenda = em.find(Venda.class, venda.getIdvenda());
            Funcionario funcionariovendaOld = persistentVenda.getFuncionariovenda();
            Funcionario funcionariovendaNew = venda.getFuncionariovenda();
            Collection<Itemvenda> itemvendaCollectionOld = persistentVenda.getItemvendaCollection();
            Collection<Itemvenda> itemvendaCollectionNew = venda.getItemvendaCollection();
            Collection<Recebimento> recebimentoCollectionOld = persistentVenda.getRecebimentoCollection();
            Collection<Recebimento> recebimentoCollectionNew = venda.getRecebimentoCollection();
            if (funcionariovendaNew != null) {
                funcionariovendaNew = em.getReference(funcionariovendaNew.getClass(), funcionariovendaNew.getIdfuncionario());
                venda.setFuncionariovenda(funcionariovendaNew);
            }
            Collection<Itemvenda> attachedItemvendaCollectionNew = new ArrayList<Itemvenda>();
            for (Itemvenda itemvendaCollectionNewItemvendaToAttach : itemvendaCollectionNew) {
                itemvendaCollectionNewItemvendaToAttach = em.getReference(itemvendaCollectionNewItemvendaToAttach.getClass(), itemvendaCollectionNewItemvendaToAttach.getIditemvenda());
                attachedItemvendaCollectionNew.add(itemvendaCollectionNewItemvendaToAttach);
            }
            itemvendaCollectionNew = attachedItemvendaCollectionNew;
            venda.setItemvendaCollection(itemvendaCollectionNew);
            Collection<Recebimento> attachedRecebimentoCollectionNew = new ArrayList<Recebimento>();
            for (Recebimento recebimentoCollectionNewRecebimentoToAttach : recebimentoCollectionNew) {
                recebimentoCollectionNewRecebimentoToAttach = em.getReference(recebimentoCollectionNewRecebimentoToAttach.getClass(), recebimentoCollectionNewRecebimentoToAttach.getIdrecebimento());
                attachedRecebimentoCollectionNew.add(recebimentoCollectionNewRecebimentoToAttach);
            }
            recebimentoCollectionNew = attachedRecebimentoCollectionNew;
            venda.setRecebimentoCollection(recebimentoCollectionNew);
            venda = em.merge(venda);
            if (funcionariovendaOld != null && !funcionariovendaOld.equals(funcionariovendaNew)) {
                funcionariovendaOld.getVendaCollection().remove(venda);
                funcionariovendaOld = em.merge(funcionariovendaOld);
            }
            if (funcionariovendaNew != null && !funcionariovendaNew.equals(funcionariovendaOld)) {
                funcionariovendaNew.getVendaCollection().add(venda);
                funcionariovendaNew = em.merge(funcionariovendaNew);
            }
            for (Itemvenda itemvendaCollectionOldItemvenda : itemvendaCollectionOld) {
                if (!itemvendaCollectionNew.contains(itemvendaCollectionOldItemvenda)) {
                    itemvendaCollectionOldItemvenda.setVendaitemvenda(null);
                    itemvendaCollectionOldItemvenda = em.merge(itemvendaCollectionOldItemvenda);
                }
            }
            for (Itemvenda itemvendaCollectionNewItemvenda : itemvendaCollectionNew) {
                if (!itemvendaCollectionOld.contains(itemvendaCollectionNewItemvenda)) {
                    Venda oldVendaitemvendaOfItemvendaCollectionNewItemvenda = itemvendaCollectionNewItemvenda.getVendaitemvenda();
                    itemvendaCollectionNewItemvenda.setVendaitemvenda(venda);
                    itemvendaCollectionNewItemvenda = em.merge(itemvendaCollectionNewItemvenda);
                    if (oldVendaitemvendaOfItemvendaCollectionNewItemvenda != null && !oldVendaitemvendaOfItemvendaCollectionNewItemvenda.equals(venda)) {
                        oldVendaitemvendaOfItemvendaCollectionNewItemvenda.getItemvendaCollection().remove(itemvendaCollectionNewItemvenda);
                        oldVendaitemvendaOfItemvendaCollectionNewItemvenda = em.merge(oldVendaitemvendaOfItemvendaCollectionNewItemvenda);
                    }
                }
            }
            for (Recebimento recebimentoCollectionOldRecebimento : recebimentoCollectionOld) {
                if (!recebimentoCollectionNew.contains(recebimentoCollectionOldRecebimento)) {
                    recebimentoCollectionOldRecebimento.setVendarecebimento(null);
                    recebimentoCollectionOldRecebimento = em.merge(recebimentoCollectionOldRecebimento);
                }
            }
            for (Recebimento recebimentoCollectionNewRecebimento : recebimentoCollectionNew) {
                if (!recebimentoCollectionOld.contains(recebimentoCollectionNewRecebimento)) {
                    Venda oldVendarecebimentoOfRecebimentoCollectionNewRecebimento = recebimentoCollectionNewRecebimento.getVendarecebimento();
                    recebimentoCollectionNewRecebimento.setVendarecebimento(venda);
                    recebimentoCollectionNewRecebimento = em.merge(recebimentoCollectionNewRecebimento);
                    if (oldVendarecebimentoOfRecebimentoCollectionNewRecebimento != null && !oldVendarecebimentoOfRecebimentoCollectionNewRecebimento.equals(venda)) {
                        oldVendarecebimentoOfRecebimentoCollectionNewRecebimento.getRecebimentoCollection().remove(recebimentoCollectionNewRecebimento);
                        oldVendarecebimentoOfRecebimentoCollectionNewRecebimento = em.merge(oldVendarecebimentoOfRecebimentoCollectionNewRecebimento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = venda.getIdvenda();
                if (findVenda(id) == null) {
                    throw new NonexistentEntityException("The venda with id " + id + " no longer exists.");
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
            Venda venda;
            try {
                venda = em.getReference(Venda.class, id);
                venda.getIdvenda();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venda with id " + id + " no longer exists.", enfe);
            }
            Funcionario funcionariovenda = venda.getFuncionariovenda();
            if (funcionariovenda != null) {
                funcionariovenda.getVendaCollection().remove(venda);
                funcionariovenda = em.merge(funcionariovenda);
            }
            Collection<Itemvenda> itemvendaCollection = venda.getItemvendaCollection();
            for (Itemvenda itemvendaCollectionItemvenda : itemvendaCollection) {
                itemvendaCollectionItemvenda.setVendaitemvenda(null);
                itemvendaCollectionItemvenda = em.merge(itemvendaCollectionItemvenda);
            }
            Collection<Recebimento> recebimentoCollection = venda.getRecebimentoCollection();
            for (Recebimento recebimentoCollectionRecebimento : recebimentoCollection) {
                recebimentoCollectionRecebimento.setVendarecebimento(null);
                recebimentoCollectionRecebimento = em.merge(recebimentoCollectionRecebimento);
            }
            em.remove(venda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venda> findVendaEntities() {
        return findVendaEntities(true, -1, -1);
    }

    public List<Venda> findVendaEntities(int maxResults, int firstResult) {
        return findVendaEntities(false, maxResults, firstResult);
    }

    private List<Venda> findVendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venda.class));
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

    public Venda findVenda(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venda.class, id);
        } finally {
            em.close();
        }
    }

    public int getVendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venda> rt = cq.from(Venda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
