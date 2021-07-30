package br.com.covid19.dao;

import br.com.covid19.entidades.Funcionario;
import br.com.covid19.entidades.Sintoma;
import br.com.covid19.exception.ConexaoException;
import br.com.covid19.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class SintomaDao implements ISintomaDao {

    private Connection conn;

    public SintomaDao() throws ConexaoException {
        try {
            this.conn = Conexao.getConnection();

        } catch (ConexaoException e) {
            throw new ConexaoException("Erro: " + ":\n" + e.getMessage());
        }
    }

    @Override
    public void salvar(Sintoma sintoma) throws ConexaoException {

        String SQL = "insert into sintoma (matricula, data, turno, febre, coriza, espirro, tosse, diarreia, dtcadastro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW())";

        try {

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = this.conn;

            ps = con.prepareStatement(SQL);
            ps.setString(1, sintoma.getFuncionario().getMatricula());
            ps.setDate(2, new Date(sintoma.getData().getTime()));
            ps.setString(3, sintoma.getTurno());
            ps.setString(4, sintoma.getFebre());
            ps.setBoolean(5, sintoma.getCoriza());
            ps.setBoolean(6, sintoma.getEspirro());
            ps.setBoolean(7, sintoma.getTosse());
            ps.setBoolean(8, sintoma.getDiarreia());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException sqle) {
            throw new ConexaoException("Erro ao inserir os dados\n " + sqle);
        } catch (Exception sqle) {
            throw new ConexaoException("Erro ao inserir os dados\n " + sqle);
        }
    }

    @Override
    public Sintoma buscarDados(String matricula) throws ConexaoException {

        String SQL = "select f.matricula, f.nome, f.cardiaco, f.hipertensao, "
                + "f.diabete, f.pulmonar, f.renal, f.imunidade, f.gestante, "
                + "f.anomalias, s.matricula "
                + "from funcionario as f left join sintoma as s on f.matricula = s.idsintoma "
                + "where f.matricula = ?";

        try {

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = this.conn;

            ps = con.prepareStatement(SQL);
            ps.setString(1, matricula);
            rs = ps.executeQuery();

            Funcionario funcionario = new Funcionario();

            if (rs.next()) {
                funcionario.setMatricula(rs.getString("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCardiaco(rs.getBoolean("cardiaco"));
                funcionario.setHipertensao(rs.getBoolean("hipertensao"));
                funcionario.setDiabete(rs.getBoolean("diabete"));
                funcionario.setPulmonar(rs.getBoolean("pulmonar"));
                funcionario.setRenal(rs.getBoolean("renal"));
                funcionario.setImunidade(rs.getBoolean("imunidade"));
                funcionario.setGestante(rs.getBoolean("gestante"));
                funcionario.setAnomalias(rs.getBoolean("anomalias"));
            } else {
                funcionario = null;
            }
            return new Sintoma(funcionario);

        } catch (SQLException sqle) {
            throw new ConexaoException("Erro ao buscar os dados " + sqle.getMessage());
        } catch (Exception sqle) {
            throw new ConexaoException("Erro ao buscar os dados " + sqle.getMessage());
        }

    }

}
