/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author magno
 */
@MappedSuperclass
@Table(catalog = "dbloja", schema = "public")
@XmlRootElement
public class Itemvenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer iditemvenda;
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 10, scale = 2)
    private BigDecimal valor;
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacaoitemvenda;
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getCriacaoitemvenda() {
        return criacaoitemvenda;
    }

    public void setCriacaoitemvenda(Date criacaoitemvenda) {
        this.criacaoitemvenda = criacaoitemvenda;
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
        return "utfpr.edu.br.papelariafacil.vo.Itemvenda[ iditemvenda=" + iditemvenda + " ]";
    }
    
}
