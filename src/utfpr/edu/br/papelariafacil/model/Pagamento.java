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
@Table(name = "pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p"),
    @NamedQuery(name = "Pagamento.findByIdpagamento", query = "SELECT p FROM Pagamento p WHERE p.idpagamento = :idpagamento"),
    @NamedQuery(name = "Pagamento.findByDescricaopagamento", query = "SELECT p FROM Pagamento p WHERE p.descricaopagamento = :descricaopagamento"),
    @NamedQuery(name = "Pagamento.findByValorpagamento", query = "SELECT p FROM Pagamento p WHERE p.valorpagamento = :valorpagamento"),
    @NamedQuery(name = "Pagamento.findByDatapagamento", query = "SELECT p FROM Pagamento p WHERE p.datapagamento = :datapagamento"),
    @NamedQuery(name = "Pagamento.findByStatuspagamento", query = "SELECT p FROM Pagamento p WHERE p.statuspagamento = :statuspagamento"),
    @NamedQuery(name = "Pagamento.findByCriacaopagamento", query = "SELECT p FROM Pagamento p WHERE p.criacaopagamento = :criacaopagamento"),
    @NamedQuery(name = "Pagamento.findByAtualizacaopagamento", query = "SELECT p FROM Pagamento p WHERE p.atualizacaopagamento = :atualizacaopagamento")})
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpagamento")
    private Integer idpagamento;
    @Column(name = "descricaopagamento")
    private String descricaopagamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorpagamento")
    private BigDecimal valorpagamento;
    @Column(name = "datapagamento")
    @Temporal(TemporalType.DATE)
    private Date datapagamento;
    @Column(name = "statuspagamento")
    private Short statuspagamento;
    @Column(name = "criacaopagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacaopagamento;
    @Column(name = "atualizacaopagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date atualizacaopagamento;
    @JoinColumn(name = "comprapagamento", referencedColumnName = "idcompra")
    @ManyToOne
    private Compra comprapagamento;
    @JoinColumn(name = "funcionariopagamento", referencedColumnName = "idfuncionario")
    @ManyToOne
    private Funcionario funcionariopagamento;

    public Pagamento() {
    }

    public Pagamento(Integer idpagamento) {
        this.idpagamento = idpagamento;
    }

    public Integer getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(Integer idpagamento) {
        this.idpagamento = idpagamento;
    }

    public String getDescricaopagamento() {
        return descricaopagamento;
    }

    public void setDescricaopagamento(String descricaopagamento) {
        this.descricaopagamento = descricaopagamento;
    }

    public BigDecimal getValorpagamento() {
        return valorpagamento;
    }

    public void setValorpagamento(BigDecimal valorpagamento) {
        this.valorpagamento = valorpagamento;
    }

    public Date getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(Date datapagamento) {
        this.datapagamento = datapagamento;
    }

    public Short getStatuspagamento() {
        return statuspagamento;
    }

    public void setStatuspagamento(Short statuspagamento) {
        this.statuspagamento = statuspagamento;
    }

    public Date getCriacaopagamento() {
        return criacaopagamento;
    }

    public void setCriacaopagamento(Date criacaopagamento) {
        this.criacaopagamento = criacaopagamento;
    }

    public Date getAtualizacaopagamento() {
        return atualizacaopagamento;
    }

    public void setAtualizacaopagamento(Date atualizacaopagamento) {
        this.atualizacaopagamento = atualizacaopagamento;
    }

    public Compra getComprapagamento() {
        return comprapagamento;
    }

    public void setComprapagamento(Compra comprapagamento) {
        this.comprapagamento = comprapagamento;
    }

    public Funcionario getFuncionariopagamento() {
        return funcionariopagamento;
    }

    public void setFuncionariopagamento(Funcionario funcionariopagamento) {
        this.funcionariopagamento = funcionariopagamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpagamento != null ? idpagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.idpagamento == null && other.idpagamento != null) || (this.idpagamento != null && !this.idpagamento.equals(other.idpagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.papelariafacil.dao.Pagamento[ idpagamento=" + idpagamento + " ]";
    }
    
}
