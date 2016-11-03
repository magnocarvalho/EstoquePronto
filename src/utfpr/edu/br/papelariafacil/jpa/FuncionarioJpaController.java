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
import utfpr.edu.br.papelariafacil.model.Funcionario;
import utfpr.edu.br.papelariafacil.model.Venda;
import utfpr.edu.br.papelariafacil.model.Recebimento;
import utfpr.edu.br.papelariafacil.model.Pagamento;

/**
 *
 * @author magno
 */
public class FuncionarioJpaController implements Serializable {

    public FuncionarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Funcionario funcionario) {
        if (funcionario.getCompraCollection() == null) {
            funcionario.setCompraCollection(new ArrayList<Compra>());
        }
        if (funcionario.getVendaCollection() == null) {
            funcionario.setVendaCollection(new ArrayList<Venda>());
        }
        if (funcionario.getRecebimentoCollection() == null) {
            funcionario.setRecebimentoCollection(new ArrayList<Recebimento>());
        }
        if (funcionario.getPagamentoCollection() == null) {
            funcionario.setPagamentoCollection(new ArrayList<Pagamento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Compra> attachedCompraCollection = new ArrayList<Compra>();
            for (Compra compraCollectionCompraToAttach : funcionario.getCompraCollection()) {
                compraCollectionCompraToAttach = em.getReference(compraCollectionCompraToAttach.getClass(), compraCollectionCompraToAttach.getIdcompra());
                attachedCompraCollection.add(compraCollectionCompraToAttach);
            }
            funcionario.setCompraCollection(attachedCompraCollection);
            Collection<Venda> attachedVendaCollection = new ArrayList<Venda>();
            for (Venda vendaCollectionVendaToAttach : funcionario.getVendaCollection()) {
                vendaCollectionVendaToAttach = em.getReference(vendaCollectionVendaToAttach.getClass(), vendaCollectionVendaToAttach.getIdvenda());
                attachedVendaCollection.add(vendaCollectionVendaToAttach);
            }
            funcionario.setVendaCollection(attachedVendaCollection);
            Collection<Recebimento> attachedRecebimentoCollection = new ArrayList<Recebimento>();
            for (Recebimento recebimentoCollectionRecebimentoToAttach : funcionario.getRecebimentoCollection()) {
                recebimentoCollectionRecebimentoToAttach = em.getReference(recebimentoCollectionRecebimentoToAttach.getClass(), recebimentoCollectionRecebimentoToAttach.getIdrecebimento());
                attachedRecebimentoCollection.add(recebimentoCollectionRecebimentoToAttach);
            }
            funcionario.setRecebimentoCollection(attachedRecebimentoCollection);
            Collection<Pagamento> attachedPagamentoCollection = new ArrayList<Pagamento>();
            for (Pagamento pagamentoCollectionPagamentoToAttach : funcionario.getPagamentoCollection()) {
                pagamentoCollectionPagamentoToAttach = em.getReference(pagamentoCollectionPagamentoToAttach.getClass(), pagamentoCollectionPagamentoToAttach.getIdpagamento());
                attachedPagamentoCollection.add(pagamentoCollectionPagamentoToAttach);
            }
            funcionario.setPagamentoCollection(attachedPagamentoCollection);
            em.persist(funcionario);
            for (Compra compraCollectionCompra : funcionario.getCompraCollection()) {
                Funcionario oldFuncionariocompraOfCompraCollectionCompra = compraCollectionCompra.getFuncionariocompra();
                compraCollectionCompra.setFuncionariocompra(funcionario);
                compraCollectionCompra = em.merge(compraCollectionCompra);
                if (oldFuncionariocompraOfCompraCollectionCompra != null) {
                    oldFuncionariocompraOfCompraCollectionCompra.getCompraCollection().remove(compraCollectionCompra);
                    oldFuncionariocompraOfCompraCollectionCompra = em.merge(oldFuncionariocompraOfCompraCollectionCompra);
                }
            }
            for (Venda vendaCollectionVenda : funcionario.getVendaCollection()) {
                Funcionario oldFuncionariovendaOfVendaCollectionVenda = vendaCollectionVenda.getFuncionariovenda();
                vendaCollectionVenda.setFuncionariovenda(funcionario);
                vendaCollectionVenda = em.merge(vendaCollectionVenda);
                if (oldFuncionariovendaOfVendaCollectionVenda != null) {
                    oldFuncionariovendaOfVendaCollectionVenda.getVendaCollection().remove(vendaCollectionVenda);
                    oldFuncionariovendaOfVendaCollectionVenda = em.merge(oldFuncionariovendaOfVendaCollectionVenda);
                }
            }
            for (Recebimento recebimentoCollectionRecebimento : funcionario.getRecebimentoCollection()) {
                Funcionario oldFuncionariorecebimentoOfRecebimentoCollectionRecebimento = recebimentoCollectionRecebimento.getFuncionariorecebimento();
                recebimentoCollectionRecebimento.setFuncionariorecebimento(funcionario);
                recebimentoCollectionRecebimento = em.merge(recebimentoCollectionRecebimento);
                if (oldFuncionariorecebimentoOfRecebimentoCollectionRecebimento != null) {
                    oldFuncionariorecebimentoOfRecebimentoCollectionRecebimento.getRecebimentoCollection().remove(recebimentoCollectionRecebimento);
                    oldFuncionariorecebimentoOfRecebimentoCollectionRecebimento = em.merge(oldFuncionariorecebimentoOfRecebimentoCollectionRecebimento);
                }
            }
            for (Pagamento pagamentoCollectionPagamento : funcionario.getPagamentoCollection()) {
                Funcionario oldFuncionariopagamentoOfPagamentoCollectionPagamento = pagamentoCollectionPagamento.getFuncionariopagamento();
                pagamentoCollectionPagamento.setFuncionariopagamento(funcionario);
                pagamentoCollectionPagamento = em.merge(pagamentoCollectionPagamento);
                if (oldFuncionariopagamentoOfPagamentoCollectionPagamento != null) {
                    oldFuncionariopagamentoOfPagamentoCollectionPagamento.getPagamentoCollection().remove(pagamentoCollectionPagamento);
                    oldFuncionariopagamentoOfPagamentoCollectionPagamento = em.merge(oldFuncionariopagamentoOfPagamentoCollectionPagamento);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Funcionario funcionario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario persistentFuncionario = em.find(Funcionario.class, funcionario.getIdfuncionario());
            Collection<Compra> compraCollectionOld = persistentFuncionario.getCompraCollection();
            Collection<Compra> compraCollectionNew = funcionario.getCompraCollection();
            Collection<Venda> vendaCollectionOld = persistentFuncionario.getVendaCollection();
            Collection<Venda> vendaCollectionNew = funcionario.getVendaCollection();
            Collection<Recebimento> recebimentoCollectionOld = persistentFuncionario.getRecebimentoCollection();
            Collection<Recebimento> recebimentoCollectionNew = funcionario.getRecebimentoCollection();
            Collection<Pagamento> pagamentoCollectionOld = persistentFuncionario.getPagamentoCollection();
            Collection<Pagamento> pagamentoCollectionNew = funcionario.getPagamentoCollection();
            Collection<Compra> attachedCompraCollectionNew = new ArrayList<Compra>();
            for (Compra compraCollectionNewCompraToAttach : compraCollectionNew) {
                compraCollectionNewCompraToAttach = em.getReference(compraCollectionNewCompraToAttach.getClass(), compraCollectionNewCompraToAttach.getIdcompra());
                attachedCompraCollectionNew.add(compraCollectionNewCompraToAttach);
            }
            compraCollectionNew = attachedCompraCollectionNew;
            funcionario.setCompraCollection(compraCollectionNew);
            Collection<Venda> attachedVendaCollectionNew = new ArrayList<Venda>();
            for (Venda vendaCollectionNewVendaToAttach : vendaCollectionNew) {
                vendaCollectionNewVendaToAttach = em.getReference(vendaCollectionNewVendaToAttach.getClass(), vendaCollectionNewVendaToAttach.getIdvenda());
                attachedVendaCollectionNew.add(vendaCollectionNewVendaToAttach);
            }
            vendaCollectionNew = attachedVendaCollectionNew;
            funcionario.setVendaCollection(vendaCollectionNew);
            Collection<Recebimento> attachedRecebimentoCollectionNew = new ArrayList<Recebimento>();
            for (Recebimento recebimentoCollectionNewRecebimentoToAttach : recebimentoCollectionNew) {
                recebimentoCollectionNewRecebimentoToAttach = em.getReference(recebimentoCollectionNewRecebimentoToAttach.getClass(), recebimentoCollectionNewRecebimentoToAttach.getIdrecebimento());
                attachedRecebimentoCollectionNew.add(recebimentoCollectionNewRecebimentoToAttach);
            }
            recebimentoCollectionNew = attachedRecebimentoCollectionNew;
            funcionario.setRecebimentoCollection(recebimentoCollectionNew);
            Collection<Pagamento> attachedPagamentoCollectionNew = new ArrayList<Pagamento>();
            for (Pagamento pagamentoCollectionNewPagamentoToAttach : pagamentoCollectionNew) {
                pagamentoCollectionNewPagamentoToAttach = em.getReference(pagamentoCollectionNewPagamentoToAttach.getClass(), pagamentoCollectionNewPagamentoToAttach.getIdpagamento());
                attachedPagamentoCollectionNew.add(pagamentoCollectionNewPagamentoToAttach);
            }
            pagamentoCollectionNew = attachedPagamentoCollectionNew;
            funcionario.setPagamentoCollection(pagamentoCollectionNew);
            funcionario = em.merge(funcionario);
            for (Compra compraCollectionOldCompra : compraCollectionOld) {
                if (!compraCollectionNew.contains(compraCollectionOldCompra)) {
                    compraCollectionOldCompra.setFuncionariocompra(null);
                    compraCollectionOldCompra = em.merge(compraCollectionOldCompra);
                }
            }
            for (Compra compraCollectionNewCompra : compraCollectionNew) {
                if (!compraCollectionOld.contains(compraCollectionNewCompra)) {
                    Funcionario oldFuncionariocompraOfCompraCollectionNewCompra = compraCollectionNewCompra.getFuncionariocompra();
                    compraCollectionNewCompra.setFuncionariocompra(funcionario);
                    compraCollectionNewCompra = em.merge(compraCollectionNewCompra);
                    if (oldFuncionariocompraOfCompraCollectionNewCompra != null && !oldFuncionariocompraOfCompraCollectionNewCompra.equals(funcionario)) {
                        oldFuncionariocompraOfCompraCollectionNewCompra.getCompraCollection().remove(compraCollectionNewCompra);
                        oldFuncionariocompraOfCompraCollectionNewCompra = em.merge(oldFuncionariocompraOfCompraCollectionNewCompra);
                    }
                }
            }
            for (Venda vendaCollectionOldVenda : vendaCollectionOld) {
                if (!vendaCollectionNew.contains(vendaCollectionOldVenda)) {
                    vendaCollectionOldVenda.setFuncionariovenda(null);
                    vendaCollectionOldVenda = em.merge(vendaCollectionOldVenda);
                }
            }
            for (Venda vendaCollectionNewVenda : vendaCollectionNew) {
                if (!vendaCollectionOld.contains(vendaCollectionNewVenda)) {
                    Funcionario oldFuncionariovendaOfVendaCollectionNewVenda = vendaCollectionNewVenda.getFuncionariovenda();
                    vendaCollectionNewVenda.setFuncionariovenda(funcionario);
                    vendaCollectionNewVenda = em.merge(vendaCollectionNewVenda);
                    if (oldFuncionariovendaOfVendaCollectionNewVenda != null && !oldFuncionariovendaOfVendaCollectionNewVenda.equals(funcionario)) {
                        oldFuncionariovendaOfVendaCollectionNewVenda.getVendaCollection().remove(vendaCollectionNewVenda);
                        oldFuncionariovendaOfVendaCollectionNewVenda = em.merge(oldFuncionariovendaOfVendaCollectionNewVenda);
                    }
                }
            }
            for (Recebimento recebimentoCollectionOldRecebimento : recebimentoCollectionOld) {
                if (!recebimentoCollectionNew.contains(recebimentoCollectionOldRecebimento)) {
                    recebimentoCollectionOldRecebimento.setFuncionariorecebimento(null);
                    recebimentoCollectionOldRecebimento = em.merge(recebimentoCollectionOldRecebimento);
                }
            }
            for (Recebimento recebimentoCollectionNewRecebimento : recebimentoCollectionNew) {
                if (!recebimentoCollectionOld.contains(recebimentoCollectionNewRecebimento)) {
                    Funcionario oldFuncionariorecebimentoOfRecebimentoCollectionNewRecebimento = recebimentoCollectionNewRecebimento.getFuncionariorecebimento();
                    recebimentoCollectionNewRecebimento.setFuncionariorecebimento(funcionario);
                    recebimentoCollectionNewRecebimento = em.merge(recebimentoCollectionNewRecebimento);
                    if (oldFuncionariorecebimentoOfRecebimentoCollectionNewRecebimento != null && !oldFuncionariorecebimentoOfRecebimentoCollectionNewRecebimento.equals(funcionario)) {
                        oldFuncionariorecebimentoOfRecebimentoCollectionNewRecebimento.getRecebimentoCollection().remove(recebimentoCollectionNewRecebimento);
                        oldFuncionariorecebimentoOfRecebimentoCollectionNewRecebimento = em.merge(oldFuncionariorecebimentoOfRecebimentoCollectionNewRecebimento);
                    }
                }
            }
            for (Pagamento pagamentoCollectionOldPagamento : pagamentoCollectionOld) {
                if (!pagamentoCollectionNew.contains(pagamentoCollectionOldPagamento)) {
                    pagamentoCollectionOldPagamento.setFuncionariopagamento(null);
                    pagamentoCollectionOldPagamento = em.merge(pagamentoCollectionOldPagamento);
                }
            }
            for (Pagamento pagamentoCollectionNewPagamento : pagamentoCollectionNew) {
                if (!pagamentoCollectionOld.contains(pagamentoCollectionNewPagamento)) {
                    Funcionario oldFuncionariopagamentoOfPagamentoCollectionNewPagamento = pagamentoCollectionNewPagamento.getFuncionariopagamento();
                    pagamentoCollectionNewPagamento.setFuncionariopagamento(funcionario);
                    pagamentoCollectionNewPagamento = em.merge(pagamentoCollectionNewPagamento);
                    if (oldFuncionariopagamentoOfPagamentoCollectionNewPagamento != null && !oldFuncionariopagamentoOfPagamentoCollectionNewPagamento.equals(funcionario)) {
                        oldFuncionariopagamentoOfPagamentoCollectionNewPagamento.getPagamentoCollection().remove(pagamentoCollectionNewPagamento);
                        oldFuncionariopagamentoOfPagamentoCollectionNewPagamento = em.merge(oldFuncionariopagamentoOfPagamentoCollectionNewPagamento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = funcionario.getIdfuncionario();
                if (findFuncionario(id) == null) {
                    throw new NonexistentEntityException("The funcionario with id " + id + " no longer exists.");
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
            Funcionario funcionario;
            try {
                funcionario = em.getReference(Funcionario.class, id);
                funcionario.getIdfuncionario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcionario with id " + id + " no longer exists.", enfe);
            }
            Collection<Compra> compraCollection = funcionario.getCompraCollection();
            for (Compra compraCollectionCompra : compraCollection) {
                compraCollectionCompra.setFuncionariocompra(null);
                compraCollectionCompra = em.merge(compraCollectionCompra);
            }
            Collection<Venda> vendaCollection = funcionario.getVendaCollection();
            for (Venda vendaCollectionVenda : vendaCollection) {
                vendaCollectionVenda.setFuncionariovenda(null);
                vendaCollectionVenda = em.merge(vendaCollectionVenda);
            }
            Collection<Recebimento> recebimentoCollection = funcionario.getRecebimentoCollection();
            for (Recebimento recebimentoCollectionRecebimento : recebimentoCollection) {
                recebimentoCollectionRecebimento.setFuncionariorecebimento(null);
                recebimentoCollectionRecebimento = em.merge(recebimentoCollectionRecebimento);
            }
            Collection<Pagamento> pagamentoCollection = funcionario.getPagamentoCollection();
            for (Pagamento pagamentoCollectionPagamento : pagamentoCollection) {
                pagamentoCollectionPagamento.setFuncionariopagamento(null);
                pagamentoCollectionPagamento = em.merge(pagamentoCollectionPagamento);
            }
            em.remove(funcionario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Funcionario> findFuncionarioEntities() {
        return findFuncionarioEntities(true, -1, -1);
    }

    public List<Funcionario> findFuncionarioEntities(int maxResults, int firstResult) {
        return findFuncionarioEntities(false, maxResults, firstResult);
    }

    private List<Funcionario> findFuncionarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Funcionario.class));
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

    public Funcionario findFuncionario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Funcionario.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Funcionario> rt = cq.from(Funcionario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
