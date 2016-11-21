/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
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
@MappedSuperclass
@Table(catalog = "dbloja", schema = "public")
@XmlRootElement
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idcompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 10, scale = 2)
    private BigDecimal valorcompra;
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacaocompra;
    @JoinColumn(name = "fornecedorcompra", referencedColumnName = "idfornecedor")
    @ManyToOne
    private Fornecedor fornecedorcompra;
    @JoinColumn(name = "funcionariocompra", referencedColumnName = "idfuncionario")
    @ManyToOne
    private Funcionario funcionariocompra;
    @OneToMany(mappedBy = "comprapagamento")
    private Set<Pagamento> pagamentoSet;
    @OneToMany(mappedBy = "compraitemcompra")
    private Set<Itemcompra> itemcompraSet;

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
    public Set<Pagamento> getPagamentoSet() {
        return pagamentoSet;
    }

    public void setPagamentoSet(Set<Pagamento> pagamentoSet) {
        this.pagamentoSet = pagamentoSet;
    }

    @XmlTransient
    public Set<Itemcompra> getItemcompraSet() {
        return itemcompraSet;
    }

    public void setItemcompraSet(Set<Itemcompra> itemcompraSet) {
        this.itemcompraSet = itemcompraSet;
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
        return "utfpr.edu.br.papelariafacil.vo.Compra[ idcompra=" + idcompra + " ]";
    }
    
}
