package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Anderson
 */
public class ModuloConexao {

    // Armazenando informações Referente ao banco de dados
    private final String base = "db_hoteis";
    private final String usuarios = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection conexao = null;

    //Método que requer um retorno, e estabelece conexão com o banco de dados
    public Connection getConectar() {

        try {
            //Responsável por as configurações do BD MySql.
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(this.url, this.usuarios, this.password);
            return conexao;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "ERRO", JOptionPane.ERROR_MESSAGE);
            return conexao;
        }
    }

    public void fecharConexao() {
        try {
            //verifica se existe conexao aberta para poder fechar
            if (conexao != null) {
                conexao.close();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}//FIM DO COGIDO

