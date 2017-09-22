package model;

/**
 *
 * @author Anderson
 */
public class ModelQuarto {

    // Variável da minha tabela quarto do banco de dados.
    private int idQuarto;
    private String numero;
    private String andar;
    private String descricao;
    private String caracteristicas;
    private Double preco_diario;
    private String estado;
    private String tipoQuarto;

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Double getPreco_diario() {
        return preco_diario;
    }

    public void setPreco_diario(Double preco_diario) {
        this.preco_diario = preco_diario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public ModelQuarto() {
    }
}
