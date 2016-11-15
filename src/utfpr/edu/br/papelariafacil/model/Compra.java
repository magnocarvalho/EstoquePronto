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
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")
    , @NamedQuery(name = "Compra.findByIdcompra", query = "SELECT c FROM Compra c WHERE c.idcompra = :idcompra")
    , @NamedQuery(name = "Compra.findByValorcompra", query = "SELECT c FROM Compra c WHERE c.valorcompra = :valorcompra")
    , @NamedQuery(name = "Compra.findByCriacaocompra", query = "SELECT c FROM Compra c WHERE c.criacaocompra = :criacaocompra")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcompra")
    private Integer idcompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorcompra")
    private BigDecimal valorcompra;
    @Column(name = "criacaocompra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacaocompra;
    @JoinColumn(name = "fornecedorcompra", referencedColumnName = "idfornecedor")
    @ManyToOne
    private Fornecedor fornecedorcompra;
    @JoinColumn(name = "funcionariocompra", referencedColumnName = "idfuncionario")
    @ManyToOne
    private Funcionario funcionariocompra;
    @OneToMany(mappedBy = "comprapagamento")
    private Collection<Pagamento> pagamentoCollection;
    @OneToMany(mappedBy = "compraitemcompra")
    private Collection<Itemcompra> itemcompraCollection;

    public Compra() {
    }

    public Compra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public BigDecimal getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(BigDecimal valorcompra) {
        this.valorcompra = valorcompra;
    }

    public Date getCriacaocompra() {
        return criacaocompra;
    }

    public void setCriacaocompra(Date criacaocompra) {
        this.criacaocompra = criacaocompra;
    }

    public Fornecedor getFornecedorcompra() {
        return fornecedorcompra;
    }

    public void setFornecedorcompra(Fornecedor fornecedorcompra) {
        this.fornecedorcompra = fornecedorcompra;
    }

    public Funcionario getFuncionariocompra() {
        return funcionariocompra;
    }

    public void setFuncionariocompra(Funcionario funcionariocompra) {
        this.funcionariocompra = funcionariocompra;
    }

    @XmlTransient
    public Collection<Pagamento> getPagamentoCollection() {
        return pagamentoCollection;
    }

    public void setPagamentoCollection(Collection<Pagamento> pagamentoCollection) {
        this.pagamentoCollection = pagamentoCollection;
    }

    @XmlTransient
    public Collection<Itemcompra> getItemcompraCollection() {
        return itemcompraCollection;
    }

    public void setItemcompraCollection(Collection<Itemcompra> itemcompraCollection) {
        this.itemcompraCollection = itemcompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompra != null ? idcompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idcompra == null && other.idcompra != null) || (this.idcompra != null && !this.idcompra.equals(other.idcompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.papelariafacil.model.Compra[ idcompra=" + idcompra + " ]";
    }
    
}
