/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.dao;

import utfpr.edu.br.papelariafacil.vo.Compra;

/**
 *
 * @author magno
 */
public class DaoCompra extends DaoGenerics<Compra>{
    
    public DaoCompra()
    {
        super.alvo = Compra.class;
    }
    
}