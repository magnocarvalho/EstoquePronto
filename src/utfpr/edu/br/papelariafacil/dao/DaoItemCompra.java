/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.dao;

import utfpr.edu.br.papelariafacil.vo.Itemcompra;

/**
 *
 * @author magno
 */
public class DaoItemCompra extends DaoGenerics<Itemcompra> {
     
    public DaoItemCompra()
    {
        super.alvo = Itemcompra.class;
    }
    
}