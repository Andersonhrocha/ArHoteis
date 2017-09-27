package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelProduto;

/**
 *
 * @author Anderson
 */
public class ControllerProduto extends ModuloConexao {

    public Connection conexao = getConectar();
    private String sql = "";
    public Integer totalRegistros = 0;

    
    //Método para mostrar consultas no banco de dados
    public DefaultTableModel mostrar(String buscar) {

        String[] titulos = {"ID", "Produtos", "Descrição", "Unidade de Medida", "Preço de Venda"};

        DefaultTableModel tabelaQuarto = new DefaultTableModel(null, titulos);

        String[] registro = new String[5];

        sql = "SELECT * FROM produto WHERE nome like '%" + buscar + "%' order by id_produto desc";

        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("id_produto");
                registro[1] = rs.getString("nome");
                registro[2] = rs.getString("descricao");
                registro[3] = rs.getString("unidad_medida");
                registro[4] = rs.getString("preco_venda");

                totalRegistros = totalRegistros + 1;
                tabelaQuarto.addRow(registro);
            }
            return tabelaQuarto;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    } //FIM DA CLASSE mostrar

    
    //Método para inserir na tabela produto
    public boolean inserir(ModelProduto pro) {
        sql = "INSERT INTO produto (nome,descricao,unidad_medida,preco_venda)"
                + "values (?,?,?,?)";

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getNome());
            pst.setString(2, pro.getDescricao());
            pst.setString(3, pro.getUnidad_medida());
            pst.setDouble(4, pro.getPreco_venda());

            // Atualiza a tabela produto com os dados do formulário
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    } //FIM DA CLASSE inserir

    
    //Método para editar na tabela produto
    public boolean editar(ModelProduto pro) {
        sql = "UPDATE produto SET nome=?, descricao=?, unidad_medida=?, preco_venda=?"
                + " where id_produto=?";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getNome());
            pst.setString(2, pro.getDescricao());
            pst.setString(3, pro.getUnidad_medida());
            pst.setDouble(4, pro.getPreco_venda());
            pst.setInt(5, pro.getId_produto());

            // Atualiza a tabela produto com os dados do formulário
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }// FIM DA CLASSE editar

    
    //Método para excluir na tabela produto
    public boolean excluir(ModelProduto pro) {
        sql = "DELETE FROM produto WHERE id_produto=?";

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getId_produto());

            // Atualiza a tabela produto com os dados do formulário
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }//FIM DA CLASSE excluir

}//FIM DA CLASSE ControllerProduto
