package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelQuarto;

/**
 *
 * @author Anderson
 */
public class ControllerQuarto extends ModuloConexao {

    public Connection conexao = getConectar();
    private String sql = "";
    public Integer totalRegistros = 0;

    
    //Método para mostrar consultas no banco de dados
    public DefaultTableModel mostrar(String buscar) {

        String[] titulos = {"ID", "Número", "Andar", "Descrição", "Características", "Preço", "Situação", "Tipo"};
        
        DefaultTableModel tabelaQuarto = new DefaultTableModel(null, titulos);

        String[] registro = new String[8];

        sql = "SELECT * FROM quarto WHERE andar like '%" + buscar + "%' order by id_quarto";

        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("id_quarto");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("andar");
                registro[3] = rs.getString("descricao");
                registro[4] = rs.getString("caracteristicas");
                registro[5] = rs.getString("preco_diario");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("tipo_quarto");

                totalRegistros = totalRegistros + 1;
                tabelaQuarto.addRow(registro);
            }
            return tabelaQuarto;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    } //FIM DA CLASSE mostrar

    
    //Método para inserir na tabela quarto
    public boolean inserir(ModelQuarto pro) {
        sql = "INSERT INTO quarto (numero,andar,descricao,caracteristicas,preco_diario,estado,tipo_quarto)"
                + "values (?,?,?,?,?,?,?)";
        
        try {

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getNumero());
            pst.setString(2, pro.getAndar());
            pst.setString(3, pro.getDescricao());
            pst.setString(4, pro.getCaracteristicas());
            pst.setDouble(5, pro.getPreco_diario());
            pst.setString(6, pro.getEstado());
            pst.setString(7, pro.getTipoQuarto());

            // Atualiza a tabela quarto com os dados do formulário
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
    

    //Método para editar na tabela quarto
    public boolean editar(ModelQuarto pro) {
        sql = "UPDATE quarto SET numero=?, andar=?, descricao=?, caracteristicas=?, preco_diario=?, estado=?,tipo_quarto=?"
                + " where id_quarto=?";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getNumero());
            pst.setString(2, pro.getAndar());
            pst.setString(3, pro.getDescricao());
            pst.setString(4, pro.getCaracteristicas());
            pst.setDouble(5, pro.getPreco_diario());
            pst.setString(6, pro.getEstado());
            pst.setString(7, pro.getTipoQuarto());
            pst.setInt(8, pro.getIdQuarto());

            // Atualiza a tabela quarto com os dados do formulário
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
    

    //Método 
    public boolean desocupar(ModelQuarto pro) {
        sql = "UPDATE quarto SET estado='Disponível' WHERE id_quarto=?";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getIdQuarto());

            // Atualiza a tabela quarto com os dados do formulário
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
    }

    //Método
    public boolean ocupar(ModelQuarto pro) {
        sql = "UPDATE quarto SET estado='Ocupado' WHERE id_quarto=?";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getIdQuarto());

            // Atualiza a tabela quarto com os dados do formulário
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
    }

    //Método para excluir na tabela quarto
    public boolean excluir(ModelQuarto pro) {
        sql = "DELETE FROM quarto WHERE id_quarto=?";

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getIdQuarto());

            // Atualiza a tabela quarto com os dados do formulário
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
    
}//FIM DA CLASSE ControllerQuarto
