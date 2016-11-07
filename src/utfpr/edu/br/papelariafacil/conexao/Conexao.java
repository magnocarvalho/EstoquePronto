/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.conexao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;




public class Conexao {

    private static java.sql.Connection conexao = null;
    private static org.postgresql.Driver mysqlDriver;
    private static Statement stm;
    public static java.sql.Connection getConnection() throws SQLException {
        String conecaoMysql = "jdbc:postgresql://localhost:5432/dbloja";
        if (conexao == null) {
            mysqlDriver = new org.postgresql.Driver();
            //conexao = DriverManager.getConnection(conecaoMysql);
            
            conexao = DriverManager.getConnection(conecaoMysql, HibernateUtil.getUser(), HibernateUtil.getPass());
        }
        return conexao;
    }
    public void up(String sql) throws SQLException
    {
        getConnection();
        stm = conexao.createStatement();
        stm.executeUpdate(sql);
        conexao.close();
    }
}
