/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.dao;

/**
 *
 * @author rodrigo
 * dao clase de persistencia de dados no framework 
 * 
 * 
 */
import java.util.List;

interface Dao<T> {

    public void persistir(T entidade);

    public void remover(T entidade);

    public T obterPorId(int id);

    public List<T> listar(String filtro);
    
    public void atualizar(T entidade);
    
    
}