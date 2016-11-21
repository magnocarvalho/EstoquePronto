/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil;
import utfpr.edu.br.papelariafacil.form.FrmAcessoLogin;


import utfpr.edu.br.papelariafacil.util.Util;

/**
 *
 * @author magno
 */
public class Index {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         
      
        //primeiro formulario a ser carregado pelo software.
        FrmAcessoLogin fr = new FrmAcessoLogin();
        //função de centralização do formulario
        Util.abrirJFrameCentralizado(fr);
        fr.setVisible(true);
     
    }
    
}
