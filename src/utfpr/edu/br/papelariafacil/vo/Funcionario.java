/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idfuncionario;
    @Column(length = 50)
    private String nomefuncionario;
    @Column(length = 20)
    private String cargofuncionario;
    @Column(length = 30)
    private String emailcontato;
    @Column(length = 20)
    private String telefone;
    @Column(length = 20)
    private String celular;
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacaofuncionario;
    @OneToMany(mappedBy = "funcionariocompra")
    private Set<Compra> compraSet;
    @OneToMany(mappedBy = "funcionariovenda")
    private Set<Venda> vendaSet;
    @OneToMany(mappedBy = "funcionariorecebimento")
    private Set<Recebimento> recebimentoSet;
    @OneToMany(mappedBy = "funcionariopagamento")
    private Set<Pagamento> pagamentoSet;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getCriacaofuncionario() {
        return criacaofuncionario;
    }

    public void setCriacaofuncionario(Date criacaofuncionario) {
        this.criacaofuncionario = criacaofuncionario;
    }

    @XmlTransient
    public Set<Compra> getCompraSet() {
        return compraSet;
    }

    public void setCompraSet(Set<Compra> compraSet) {
        this.compraSet = compraSet;
    }

    @XmlTransient
    public Set<Venda> getVendaSet() {
        return vendaSet;
    }

    public void setVendaSet(Set<Venda> vendaSet) {
        this.vendaSet = vendaSet;
    }

    @XmlTransient
    public Set<Recebimento> getRecebimentoSet() {
        return recebimentoSet;
    }

    public void setRecebimentoSet(Set<Recebimento> recebimentoSet) {
        this.recebimentoSet = recebimentoSet;
    }

    @XmlTransient
    public Set<Pagamento> getPagamentoSet() {
        return pagamentoSet;
    }

    public void setPagamentoSet(Set<Pagamento> pagamentoSet) {
        this.pagamentoSet = pagamentoSet;
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
        return "utfpr.edu.br.papelariafacil.vo.Funcionario[ idfuncionario=" + idfuncionario + " ]";
    }
    
}
