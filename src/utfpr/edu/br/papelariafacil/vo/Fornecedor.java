/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.vo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author magno
 */
@MappedSuperclass
@Table(catalog = "dbloja", schema = "public")
@XmlRootElement
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idfornecedor;
    @Column(length = 50)
    private String nomefornecedor;
    @Column(length = 50)
    private String razaosocialpessoajuridica;
    @Column(length = 20)
    private String cnpjpessoajuridica;
    @Column(length = 50)
    private String endereco;
    @Column(length = 10)
    private String cep;
    @Column(length = 20)
    private String complemento;
    @Column(length = 10)
    private String numeroendereco;
    @Column(length = 20)
    private String cidade;
    @Column(length = 20)
    private String bairro;
    @Column(length = 20)
    private String estado;
    @Column(length = 30)
    private String emailcontato;
    @Column(length = 20)
    private String telefonecontato;
    @Column(length = 20)
    private String celularcontato;
    @OneToMany(mappedBy = "fornecedorcompra")
    private Set<Compra> compraSet;
    @OneToMany(mappedBy = "fornecedorproduto")
    private Set<Produto> produtoVOSet;

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

    @XmlTransient
    public Set<Compra> getCompraSet() {
        return compraSet;
    }

    public void setCompraSet(Set<Compra> compraSet) {
        this.compraSet = compraSet;
    }

    @XmlTransient
    public Set<Produto> getProdutoVOSet() {
        return produtoVOSet;
    }

    public void setProdutoVOSet(Set<Produto> produtoVOSet) {
        this.produtoVOSet = produtoVOSet;
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
        return "utfpr.edu.br.papelariafacil.vo.Fornecedor[ idfornecedor=" + idfornecedor + " ]";
    }
    
}
