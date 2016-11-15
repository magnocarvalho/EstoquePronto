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
@Table(name = "recebimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recebimento.findAll", query = "SELECT r FROM Recebimento r")
    , @NamedQuery(name = "Recebimento.findByIdrecebimento", query = "SELECT r FROM Recebimento r WHERE r.idrecebimento = :idrecebimento")
    , @NamedQuery(name = "Recebimento.findByDescricao", query = "SELECT r FROM Recebimento r WHERE r.descricao = :descricao")
    , @NamedQuery(name = "Recebimento.findByValor", query = "SELECT r FROM Recebimento r WHERE r.valor = :valor")
    , @NamedQuery(name = "Recebimento.findByCriacaorecebimento", query = "SELECT r FROM Recebimento r WHERE r.criacaorecebimento = :criacaorecebimento")})
public class Recebimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrecebimento")
    private Integer idrecebimento;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "criacaorecebimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacaorecebimento;
    @JoinColumn(name = "funcionariorecebimento", referencedColumnName = "idfuncionario")
    @ManyToOne
    private Funcionario funcionariorecebimento;
    @JoinColumn(name = "vendarecebimento", referencedColumnName = "idvenda")
    @ManyToOne
    private Venda vendarecebimento;

    public Recebimento() {
    }

    public Recebimento(Integer idrecebimento) {
        this.idrecebimento = idrecebimento;
    }

    public Integer getIdrecebimento() {
        return idrecebimento;
    }

    public void setIdrecebimento(Integer idrecebimento) {
        this.idrecebimento = idrecebimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getCriacaorecebimento() {
        return criacaorecebimento;
    }

    public void setCriacaorecebimento(Date criacaorecebimento) {
        this.criacaorecebimento = criacaorecebimento;
    }

    public Funcionario getFuncionariorecebimento() {
        return funcionariorecebimento;
    }

    public void setFuncionariorecebimento(Funcionario funcionariorecebimento) {
        this.funcionariorecebimento = funcionariorecebimento;
    }

    public Venda getVendarecebimento() {
        return vendarecebimento;
    }

    public void setVendarecebimento(Venda vendarecebimento) {
        this.vendarecebimento = vendarecebimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecebimento != null ? idrecebimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recebimento)) {
            return false;
        }
        Recebimento other = (Recebimento) object;
        if ((this.idrecebimento == null && other.idrecebimento != null) || (this.idrecebimento != null && !this.idrecebimento.equals(other.idrecebimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.papelariafacil.model.Recebimento[ idrecebimento=" + idrecebimento + " ]";
    }
    
}
