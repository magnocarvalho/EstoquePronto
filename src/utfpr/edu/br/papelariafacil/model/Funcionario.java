/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author magno
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIdfuncionario", query = "SELECT f FROM Funcionario f WHERE f.idfuncionario = :idfuncionario"),
    @NamedQuery(name = "Funcionario.findByNomefuncionario", query = "SELECT f FROM Funcionario f WHERE f.nomefuncionario = :nomefuncionario"),
    @NamedQuery(name = "Funcionario.findByCargofuncionario", query = "SELECT f FROM Funcionario f WHERE f.cargofuncionario = :cargofuncionario"),
    @NamedQuery(name = "Funcionario.findByEmailcontato", query = "SELECT f FROM Funcionario f WHERE f.emailcontato = :emailcontato"),
    @NamedQuery(name = "Funcionario.findByTelefonecontato", query = "SELECT f FROM Funcionario f WHERE f.telefonecontato = :telefonecontato"),
    @NamedQuery(name = "Funcionario.findByCelularcontato", query = "SELECT f FROM Funcionario f WHERE f.celularcontato = :celularcontato"),
    @NamedQuery(name = "Funcionario.findByCriacaofuncionario", query = "SELECT f FROM Funcionario f WHERE f.criacaofuncionario = :criacaofuncionario"),
    @NamedQuery(name = "Funcionario.findByAtualizacaofuncionario", query = "SELECT f FROM Funcionario f WHERE f.atualizacaofuncionario = :atualizacaofuncionario")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfuncionario")
    private Integer idfuncionario;
    @Column(name = "nomefuncionario")
    private String nomefuncionario;
    @Column(name = "cargofuncionario")
    private String cargofuncionario;
    @Column(name = "emailcontato")
    private String emailcontato;
    @Column(name = "telefonecontato")
    private String telefonecontato;
    @Column(name = "celularcontato")
    private String celularcontato;
    @Column(name = "criacaofuncionario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacaofuncionario;
    @Column(name = "atualizacaofuncionario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date atualizacaofuncionario;
    @OneToMany(mappedBy = "funcionariocompra")
    private Collection<Compra> compraCollection;
    @OneToMany(mappedBy = "funcionariovenda")
    private Collection<Venda> vendaCollection;
    @OneToMany(mappedBy = "funcionariorecebimento")
    private Collection<Recebimento> recebimentoCollection;
    @OneToMany(mappedBy = "funcionariopagamento")
    private Collection<Pagamento> pagamentoCollection;

    public Funcionario() {
    }

    public Funcionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNomefuncionario() {
        return nomefuncionario;
    }

    public void setNomefuncionario(String nomefuncionario) {
        this.nomefuncionario = nomefuncionario;
    }

    public String getCargofuncionario() {
        return cargofuncionario;
    }

    public void setCargofuncionario(String cargofuncionario) {
        this.cargofuncionario = cargofuncionario;
    }

    public String getEmailcontato() {
        return emailcontato;
    }

    public void setEmailcontato(String emailcontato) {
        this.emailcontato = emailcontato;
    }

    public String getTelefonecontato() {
        return telefonecontato;
    }

    public void setTelefonecontato(String telefonecontato) {
        this.telefonecontato = telefonecontato;
    }

    public String getCelularcontato() {
        return celularcontato;
    }

    public void setCelularcontato(String celularcontato) {
        this.celularcontato = celularcontato;
    }

    public Date getCriacaofuncionario() {
        return criacaofuncionario;
    }

    public void setCriacaofuncionario(Date criacaofuncionario) {
        this.criacaofuncionario = criacaofuncionario;
    }

    public Date getAtualizacaofuncionario() {
        return atualizacaofuncionario;
    }

    public void setAtualizacaofuncionario(Date atualizacaofuncionario) {
        this.atualizacaofuncionario = atualizacaofuncionario;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    @XmlTransient
    public Collection<Venda> getVendaCollection() {
        return vendaCollection;
    }

    public void setVendaCollection(Collection<Venda> vendaCollection) {
        this.vendaCollection = vendaCollection;
    }

    @XmlTransient
    public Collection<Recebimento> getRecebimentoCollection() {
        return recebimentoCollection;
    }

    public void setRecebimentoCollection(Collection<Recebimento> recebimentoCollection) {
        this.recebimentoCollection = recebimentoCollection;
    }

    @XmlTransient
    public Collection<Pagamento> getPagamentoCollection() {
        return pagamentoCollection;
    }

    public void setPagamentoCollection(Collection<Pagamento> pagamentoCollection) {
        this.pagamentoCollection = pagamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncionario != null ? idfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idfuncionario == null && other.idfuncionario != null) || (this.idfuncionario != null && !this.idfuncionario.equals(other.idfuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.papelariafacil.dao.Funcionario[ idfuncionario=" + idfuncionario + " ]";
    }
    
}
