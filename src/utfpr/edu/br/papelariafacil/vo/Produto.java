/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "produto", catalog = "dbloja", schema = "public")
@XmlRootElement
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idproduto;
    @Column(length = 50)
    private String descricaoproduto;
    @Column(length = 20)
    private String codigoproduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 10, scale = 2)
    private BigDecimal custoproduto;
    @Column(precision = 10, scale = 2)
    private BigDecimal vendaproduto;
    private BigInteger minimoproduto;
    private BigInteger maximoproduto;
    private BigInteger quantidade;
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacaoproduto;
    @OneToMany(mappedBy = "produtoitemvenda")
    private Set<Itemvenda> itemvendaSet;
    @JoinColumn(name = "categoriaproduto", referencedColumnName = "idcategoria")
    @ManyToOne
    private Categoria categoriaproduto;
    @JoinColumn(name = "fornecedorproduto", referencedColumnName = "idfornecedor")
    @ManyToOne
    private Fornecedor fornecedorproduto;
    @OneToMany(mappedBy = "produtoitemcompra")
    private Set<Itemcompra> itemcompraSet;

    public Produto() {
    }

    public Produto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricaoproduto() {
        return descricaoproduto;
    }

    public void setDescricaoproduto(String descricaoproduto) {
        this.descricaoproduto = descricaoproduto;
    }

    public String getCodigoproduto() {
        return codigoproduto;
    }

    public void setCodigoproduto(String codigoproduto) {
        this.codigoproduto = codigoproduto;
    }

    public BigDecimal getCustoproduto() {
        return custoproduto;
    }

    public void setCustoproduto(BigDecimal custoproduto) {
        this.custoproduto = custoproduto;
    }

    public BigDecimal getVendaproduto() {
        return vendaproduto;
    }

    public void setVendaproduto(BigDecimal vendaproduto) {
        this.vendaproduto = vendaproduto;
    }

    public BigInteger getMinimoproduto() {
        return minimoproduto;
    }

    public void setMinimoproduto(BigInteger minimoproduto) {
        this.minimoproduto = minimoproduto;
    }

    public BigInteger getMaximoproduto() {
        return maximoproduto;
    }

    public void setMaximoproduto(BigInteger maximoproduto) {
        this.maximoproduto = maximoproduto;
    }

    public BigInteger getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigInteger quantidade) {
        this.quantidade = quantidade;
    }

    public Date getCriacaoproduto() {
        return criacaoproduto;
    }

    public void setCriacaoproduto(Date criacaoproduto) {
        this.criacaoproduto = criacaoproduto;
    }

    @XmlTransient
    public Set<Itemvenda> getItemvendaSet() {
        return itemvendaSet;
    }

    public void setItemvendaSet(Set<Itemvenda> itemvendaSet) {
        this.itemvendaSet = itemvendaSet;
    }

    public Categoria getCategoriaproduto() {
        return categoriaproduto;
    }

    public void setCategoriaproduto(Categoria categoriaproduto) {
        this.categoriaproduto = categoriaproduto;
    }

    public Fornecedor getFornecedorproduto() {
        return fornecedorproduto;
    }

    public void setFornecedorproduto(Fornecedor fornecedorproduto) {
        this.fornecedorproduto = fornecedorproduto;
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
        hash += (idproduto != null ? idproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idproduto == null && other.idproduto != null) || (this.idproduto != null && !this.idproduto.equals(other.idproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.papelariafacil.vo.ProdutoVO[ idproduto=" + idproduto + " ]";
    }
    
}
