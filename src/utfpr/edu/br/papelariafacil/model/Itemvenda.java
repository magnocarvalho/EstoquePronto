/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author magno
 */
@Entity
@Table(name = "itemvenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemvenda.findAll", query = "SELECT i FROM Itemvenda i"),
    @NamedQuery(name = "Itemvenda.findByIditemvenda", query = "SELECT i FROM Itemvenda i WHERE i.iditemvenda = :iditemvenda"),
    @NamedQuery(name = "Itemvenda.findByQuantidadeitemvenda", query = "SELECT i FROM Itemvenda i WHERE i.quantidadeitemvenda = :quantidadeitemvenda"),
    @NamedQuery(name = "Itemvenda.findByValoritemvenda", query = "SELECT i FROM Itemvenda i WHERE i.valoritemvenda = :valoritemvenda"),
    @NamedQuery(name = "Itemvenda.findByCriacaoitemvenda", query = "SELECT i FROM Itemvenda i WHERE i.criacaoitemvenda = :criacaoitemvenda"),
    @NamedQuery(name = "Itemvenda.findByAtualizacaoitemvenda", query = "SELECT i FROM Itemvenda i WHERE i.atualizacaoitemvenda = :atualizacaoitemvenda")})
public class Itemvenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iditemvenda")
    private Integer iditemvenda;
    @Column(name = "quantidadeitemvenda")
    private Integer quantidadeitemvenda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valoritemvenda")
    private BigDecimal valoritemvenda;
    @Column(name = "criacaoitemvenda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacaoitemvenda;
    @Column(name = "atualizacaoitemvenda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date atualizacaoitemvenda;
    @JoinColumn(name = "produtoitemvenda", referencedColumnName = "idproduto")
    @ManyToOne
    private Produto produtoitemvenda;
    @JoinColumn(name = "vendaitemvenda", referencedColumnName = "idvenda")
    @ManyToOne
    private Venda vendaitemvenda;

    public Itemvenda() {
    }

    public Itemvenda(Integer iditemvenda) {
        this.iditemvenda = iditemvenda;
    }

    public Integer getIditemvenda() {
        return iditemvenda;
    }

    public void setIditemvenda(Integer iditemvenda) {
        this.iditemvenda = iditemvenda;
    }

    public Integer getQuantidadeitemvenda() {
        return quantidadeitemvenda;
    }

    public void setQuantidadeitemvenda(Integer quantidadeitemvenda) {
        this.quantidadeitemvenda = quantidadeitemvenda;
    }

    public BigDecimal getValoritemvenda() {
        return valoritemvenda;
    }

    public void setValoritemvenda(BigDecimal valoritemvenda) {
        this.valoritemvenda = valoritemvenda;
    }

    public Date getCriacaoitemvenda() {
        return criacaoitemvenda;
    }

    public void setCriacaoitemvenda(Date criacaoitemvenda) {
        this.criacaoitemvenda = criacaoitemvenda;
    }

    public Date getAtualizacaoitemvenda() {
        return atualizacaoitemvenda;
    }

    public void setAtualizacaoitemvenda(Date atualizacaoitemvenda) {
        this.atualizacaoitemvenda = atualizacaoitemvenda;
    }

    public Produto getProdutoitemvenda() {
        return produtoitemvenda;
    }

    public void setProdutoitemvenda(Produto produtoitemvenda) {
        this.produtoitemvenda = produtoitemvenda;
    }

    public Venda getVendaitemvenda() {
        return vendaitemvenda;
    }

    public void setVendaitemvenda(Venda vendaitemvenda) {
        this.vendaitemvenda = vendaitemvenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditemvenda != null ? iditemvenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemvenda)) {
            return false;
        }
        Itemvenda other = (Itemvenda) object;
        if ((this.iditemvenda == null && other.iditemvenda != null) || (this.iditemvenda != null && !this.iditemvenda.equals(other.iditemvenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.papelariafacil.dao.Itemvenda[ iditemvenda=" + iditemvenda + " ]";
    }
    
}
