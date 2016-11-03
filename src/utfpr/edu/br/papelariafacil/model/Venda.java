/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByIdvenda", query = "SELECT v FROM Venda v WHERE v.idvenda = :idvenda"),
    @NamedQuery(name = "Venda.findByValorvenda", query = "SELECT v FROM Venda v WHERE v.valorvenda = :valorvenda"),
    @NamedQuery(name = "Venda.findByCriacaovenda", query = "SELECT v FROM Venda v WHERE v.criacaovenda = :criacaovenda"),
    @NamedQuery(name = "Venda.findByAtualizacaovenda", query = "SELECT v FROM Venda v WHERE v.atualizacaovenda = :atualizacaovenda")})
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvenda")
    private Integer idvenda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorvenda")
    private BigDecimal valorvenda;
    @Column(name = "criacaovenda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacaovenda;
    @Column(name = "atualizacaovenda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date atualizacaovenda;
    @JoinColumn(name = "funcionariovenda", referencedColumnName = "idfuncionario")
    @ManyToOne
    private Funcionario funcionariovenda;
    @OneToMany(mappedBy = "vendaitemvenda")
    private Collection<Itemvenda> itemvendaCollection;
    @OneToMany(mappedBy = "vendarecebimento")
    private Collection<Recebimento> recebimentoCollection;

    public Venda() {
    }

    public Venda(Integer idvenda) {
        this.idvenda = idvenda;
    }

    public Integer getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Integer idvenda) {
        this.idvenda = idvenda;
    }

    public BigDecimal getValorvenda() {
        return valorvenda;
    }

    public void setValorvenda(BigDecimal valorvenda) {
        this.valorvenda = valorvenda;
    }

    public Date getCriacaovenda() {
        return criacaovenda;
    }

    public void setCriacaovenda(Date criacaovenda) {
        this.criacaovenda = criacaovenda;
    }

    public Date getAtualizacaovenda() {
        return atualizacaovenda;
    }

    public void setAtualizacaovenda(Date atualizacaovenda) {
        this.atualizacaovenda = atualizacaovenda;
    }

    public Funcionario getFuncionariovenda() {
        return funcionariovenda;
    }

    public void setFuncionariovenda(Funcionario funcionariovenda) {
        this.funcionariovenda = funcionariovenda;
    }

    @XmlTransient
    public Collection<Itemvenda> getItemvendaCollection() {
        return itemvendaCollection;
    }

    public void setItemvendaCollection(Collection<Itemvenda> itemvendaCollection) {
        this.itemvendaCollection = itemvendaCollection;
    }

    @XmlTransient
    public Collection<Recebimento> getRecebimentoCollection() {
        return recebimentoCollection;
    }

    public void setRecebimentoCollection(Collection<Recebimento> recebimentoCollection) {
        this.recebimentoCollection = recebimentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvenda != null ? idvenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idvenda == null && other.idvenda != null) || (this.idvenda != null && !this.idvenda.equals(other.idvenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.papelariafacil.dao.Venda[ idvenda=" + idvenda + " ]";
    }
    
}
