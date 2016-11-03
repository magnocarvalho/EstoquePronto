/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdproduto", query = "SELECT p FROM Produto p WHERE p.idproduto = :idproduto"),
    @NamedQuery(name = "Produto.findByDescricaoproduto", query = "SELECT p FROM Produto p WHERE p.descricaoproduto = :descricaoproduto"),
    @NamedQuery(name = "Produto.findByCodigoproduto", query = "SELECT p FROM Produto p WHERE p.codigoproduto = :codigoproduto"),
    @NamedQuery(name = "Produto.findByCustoproduto", query = "SELECT p FROM Produto p WHERE p.custoproduto = :custoproduto"),
    @NamedQuery(name = "Produto.findByVendaproduto", query = "SELECT p FROM Produto p WHERE p.vendaproduto = :vendaproduto"),
    @NamedQuery(name = "Produto.findByMinimoproduto", query = "SELECT p FROM Produto p WHERE p.minimoproduto = :minimoproduto"),
    @NamedQuery(name = "Produto.findByMaximoproduto", query = "SELECT p FROM Produto p WHERE p.maximoproduto = :maximoproduto"),
    @NamedQuery(name = "Produto.findByEstoqueproduto", query = "SELECT p FROM Produto p WHERE p.estoqueproduto = :estoqueproduto"),
    @NamedQuery(name = "Produto.findByCriacaoproduto", query = "SELECT p FROM Produto p WHERE p.criacaoproduto = :criacaoproduto"),
    @NamedQuery(name = "Produto.findByAtualizacaoproduto", query = "SELECT p FROM Produto p WHERE p.atualizacaoproduto = :atualizacaoproduto")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproduto")
    private Integer idproduto;
    @Column(name = "descricaoproduto")
    private String descricaoproduto;
    @Column(name = "codigoproduto")
    private String codigoproduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "custoproduto")
    private BigDecimal custoproduto;
    @Column(name = "vendaproduto")
    private BigDecimal vendaproduto;
    @Column(name = "minimoproduto")
    private BigInteger minimoproduto;
    @Column(name = "maximoproduto")
    private BigInteger maximoproduto;
    @Column(name = "estoqueproduto")
    private String estoqueproduto;
    @Column(name = "criacaoproduto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacaoproduto;
    @Column(name = "atualizacaoproduto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date atualizacaoproduto;
    @OneToMany(mappedBy = "produtoitemvenda")
    private Collection<Itemvenda> itemvendaCollection;
    @JoinColumn(name = "categoriaproduto", referencedColumnName = "idcategoria")
    @ManyToOne
    private Categoria categoriaproduto;
    @JoinColumn(name = "fornecedorproduto", referencedColumnName = "idfornecedor")
    @ManyToOne
    private Fornecedor fornecedorproduto;
    @OneToMany(mappedBy = "produtoitemcompra")
    private Collection<Itemcompra> itemcompraCollection;

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

    public String getEstoqueproduto() {
        return estoqueproduto;
    }

    public void setEstoqueproduto(String estoqueproduto) {
        this.estoqueproduto = estoqueproduto;
    }

    public Date getCriacaoproduto() {
        return criacaoproduto;
    }

    public void setCriacaoproduto(Date criacaoproduto) {
        this.criacaoproduto = criacaoproduto;
    }

    public Date getAtualizacaoproduto() {
        return atualizacaoproduto;
    }

    public void setAtualizacaoproduto(Date atualizacaoproduto) {
        this.atualizacaoproduto = atualizacaoproduto;
    }

    @XmlTransient
    public Collection<Itemvenda> getItemvendaCollection() {
        return itemvendaCollection;
    }

    public void setItemvendaCollection(Collection<Itemvenda> itemvendaCollection) {
        this.itemvendaCollection = itemvendaCollection;
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
    public Collection<Itemcompra> getItemcompraCollection() {
        return itemcompraCollection;
    }

    public void setItemcompraCollection(Collection<Itemcompra> itemcompraCollection) {
        this.itemcompraCollection = itemcompraCollection;
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
        return "utfpr.edu.br.papelariafacil.dao.Produto[ idproduto=" + idproduto + " ]";
    }
    
}
