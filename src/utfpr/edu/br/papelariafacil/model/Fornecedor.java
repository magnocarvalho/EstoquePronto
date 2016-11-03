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
@Table(name = "fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByIdfornecedor", query = "SELECT f FROM Fornecedor f WHERE f.idfornecedor = :idfornecedor"),
    @NamedQuery(name = "Fornecedor.findByNomefornecedor", query = "SELECT f FROM Fornecedor f WHERE f.nomefornecedor = :nomefornecedor"),
    @NamedQuery(name = "Fornecedor.findByRazaosocialpessoajuridica", query = "SELECT f FROM Fornecedor f WHERE f.razaosocialpessoajuridica = :razaosocialpessoajuridica"),
    @NamedQuery(name = "Fornecedor.findByNomefantasiapessoajuridica", query = "SELECT f FROM Fornecedor f WHERE f.nomefantasiapessoajuridica = :nomefantasiapessoajuridica"),
    @NamedQuery(name = "Fornecedor.findByCnpjpessoajuridica", query = "SELECT f FROM Fornecedor f WHERE f.cnpjpessoajuridica = :cnpjpessoajuridica"),
    @NamedQuery(name = "Fornecedor.findByEndereco", query = "SELECT f FROM Fornecedor f WHERE f.endereco = :endereco"),
    @NamedQuery(name = "Fornecedor.findByCep", query = "SELECT f FROM Fornecedor f WHERE f.cep = :cep"),
    @NamedQuery(name = "Fornecedor.findByComplemento", query = "SELECT f FROM Fornecedor f WHERE f.complemento = :complemento"),
    @NamedQuery(name = "Fornecedor.findByNumeroendereco", query = "SELECT f FROM Fornecedor f WHERE f.numeroendereco = :numeroendereco"),
    @NamedQuery(name = "Fornecedor.findByCidade", query = "SELECT f FROM Fornecedor f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "Fornecedor.findByBairro", query = "SELECT f FROM Fornecedor f WHERE f.bairro = :bairro"),
    @NamedQuery(name = "Fornecedor.findByEstado", query = "SELECT f FROM Fornecedor f WHERE f.estado = :estado"),
    @NamedQuery(name = "Fornecedor.findByEmailcontato", query = "SELECT f FROM Fornecedor f WHERE f.emailcontato = :emailcontato"),
    @NamedQuery(name = "Fornecedor.findByTelefonecontato", query = "SELECT f FROM Fornecedor f WHERE f.telefonecontato = :telefonecontato"),
    @NamedQuery(name = "Fornecedor.findByCelularcontato", query = "SELECT f FROM Fornecedor f WHERE f.celularcontato = :celularcontato"),
    @NamedQuery(name = "Fornecedor.findByCriacaofornecedor", query = "SELECT f FROM Fornecedor f WHERE f.criacaofornecedor = :criacaofornecedor"),
    @NamedQuery(name = "Fornecedor.findByAtualizacaofornecedor", query = "SELECT f FROM Fornecedor f WHERE f.atualizacaofornecedor = :atualizacaofornecedor")})
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfornecedor")
    private Integer idfornecedor;
    @Column(name = "nomefornecedor")
    private String nomefornecedor;
    @Column(name = "razaosocialpessoajuridica")
    private String razaosocialpessoajuridica;
    @Column(name = "nomefantasiapessoajuridica")
    private String nomefantasiapessoajuridica;
    @Column(name = "cnpjpessoajuridica")
    private String cnpjpessoajuridica;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "cep")
    private String cep;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "numeroendereco")
    private String numeroendereco;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "estado")
    private String estado;
    @Column(name = "emailcontato")
    private String emailcontato;
    @Column(name = "telefonecontato")
    private String telefonecontato;
    @Column(name = "celularcontato")
    private String celularcontato;
    @Column(name = "criacaofornecedor")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacaofornecedor;
    @Column(name = "atualizacaofornecedor")
    @Temporal(TemporalType.TIMESTAMP)
    private Date atualizacaofornecedor;
    @OneToMany(mappedBy = "fornecedorcompra")
    private Collection<Compra> compraCollection;
    @OneToMany(mappedBy = "fornecedorproduto")
    private Collection<Produto> produtoCollection;

    public Fornecedor() {
    }

    public Fornecedor(Integer idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public Integer getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(Integer idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public String getNomefornecedor() {
        return nomefornecedor;
    }

    public void setNomefornecedor(String nomefornecedor) {
        this.nomefornecedor = nomefornecedor;
    }

    public String getRazaosocialpessoajuridica() {
        return razaosocialpessoajuridica;
    }

    public void setRazaosocialpessoajuridica(String razaosocialpessoajuridica) {
        this.razaosocialpessoajuridica = razaosocialpessoajuridica;
    }

    public String getNomefantasiapessoajuridica() {
        return nomefantasiapessoajuridica;
    }

    public void setNomefantasiapessoajuridica(String nomefantasiapessoajuridica) {
        this.nomefantasiapessoajuridica = nomefantasiapessoajuridica;
    }

    public String getCnpjpessoajuridica() {
        return cnpjpessoajuridica;
    }

    public void setCnpjpessoajuridica(String cnpjpessoajuridica) {
        this.cnpjpessoajuridica = cnpjpessoajuridica;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumeroendereco() {
        return numeroendereco;
    }

    public void setNumeroendereco(String numeroendereco) {
        this.numeroendereco = numeroendereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Date getCriacaofornecedor() {
        return criacaofornecedor;
    }

    public void setCriacaofornecedor(Date criacaofornecedor) {
        this.criacaofornecedor = criacaofornecedor;
    }

    public Date getAtualizacaofornecedor() {
        return atualizacaofornecedor;
    }

    public void setAtualizacaofornecedor(Date atualizacaofornecedor) {
        this.atualizacaofornecedor = atualizacaofornecedor;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfornecedor != null ? idfornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.idfornecedor == null && other.idfornecedor != null) || (this.idfornecedor != null && !this.idfornecedor.equals(other.idfornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.papelariafacil.dao.Fornecedor[ idfornecedor=" + idfornecedor + " ]";
    }
    
}
