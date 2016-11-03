/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil;
import utfpr.edu.br.papelariafacil.form.FrmLogin;
import utfpr.edu.br.papelariafacil.form.FrmPrincipal;

/**
 *
 * @author magno
 */
public class UtfprEduBrPapelariaFacil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       FrmPrincipal fp = new FrmPrincipal();
       FrmLogin l = new FrmLogin(fp, true);
       l.setVisible(true);
           
       
        
    }
    
}
