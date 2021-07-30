/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.covid19.dao;

import br.com.covid19.entidades.Funcionario;
import br.com.covid19.exception.ConexaoException;
import br.com.covid19.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class FuncionarioDao implements IFuncionarioDao {

    private Connection conn;

    public FuncionarioDao() throws ConexaoException {
        try {
            this.conn = Conexao.getConnection();

        } catch (ConexaoException e) {
            throw new ConexaoException("Erro: " + ":\n" + e.getMessage());
        }
    }

    @Override
    public void salvar(Funcionario funcionario) throws ConexaoException {

        String SQL = "insert into funcionario (matricula, nome, empresa, "
                + "endereco, numero, cidade, dtnascimento, sexo, telefone, cardiaco, "
                + "hipertensao, diabete, pulmonar, renal, imunidade, gestante, "
                + "anomalias, viagem, localidade, dtcadastro) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";

        try {

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = this.conn;

            ps = con.prepareStatement(SQL);
            ps.setString(1, funcionario.getMatricula());
            ps.setString(2, funcionario.getNome().toUpperCase());
            ps.setString(3, "COOPERATIVA AGROINDUSTRIAL COPAGRIL");
            ps.setString(4, funcionario.getEndereco().toUpperCase());
            ps.setString(5, funcionario.getNumero().toUpperCase());
            ps.setString(6, funcionario.getCidade().toUpperCase());
            ps.setString(7, funcionario.getDtNascimento().toUpperCase());
            ps.setString(8, funcionario.getSexo().toUpperCase());
            ps.setString(9, funcionario.getTelefone().toUpperCase());
            ps.setBoolean(10, funcionario.getCardiaco());
            ps.setBoolean(11, funcionario.getHipertensao());
            ps.setBoolean(12, funcionario.getDiabete());
            ps.setBoolean(13, funcionario.getPulmonar());
            ps.setBoolean(14, funcionario.getRenal());
            ps.setBoolean(15, funcionario.getImunidade());
            ps.setBoolean(16, funcionario.getGestante());
            ps.setBoolean(17, funcionario.getAnomalias());
            ps.setString(18, funcionario.getViagem());
            ps.setString(19, funcionario.getLocalidade().toUpperCase());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException sqle) {
            throw new ConexaoException("Erro ao inserir os dados " + sqle.getMessage());
        } catch (Exception sqle) {
            throw new ConexaoException("Erro ao inserir os dados " + sqle.getMessage());
        }
    }

    @Override
    public void atualizar(Funcionario funcionario) throws ConexaoException {

        String SQL = "update funcionario set nome = ?, empresa = ?, "
                + "endereco = ? , numero = ?, cidade = ?, dtnascimento = ?, sexo = ?, telefone = ?, cardiaco = ?, "
                + "hipertensao = ?, diabete = ?, pulmonar = ?, renal = ?, imunidade = ?, gestante = ?, "
                + "anomalias = ?, viagem = ?, localidade = ?, dtatualizado = NOW() where matricula = ?";

        try {

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = this.conn;

            ps = con.prepareStatement(SQL);
            ps.setString(1, funcionario.getNome().toUpperCase());
            ps.setString(2, funcionario.getEmpresa().toUpperCase());
            ps.setString(3, funcionario.getEndereco().toUpperCase());
            ps.setString(4, funcionario.getNumero().toUpperCase());
            ps.setString(5, funcionario.getCidade().toUpperCase());
            ps.setString(6, funcionario.getDtNascimento().toUpperCase());
            ps.setString(7, funcionario.getSexo().toUpperCase());
            ps.setString(8, funcionario.getTelefone().toUpperCase());
            ps.setBoolean(9, funcionario.getCardiaco());
            ps.setBoolean(10, funcionario.getHipertensao());
            ps.setBoolean(11, funcionario.getDiabete());
            ps.setBoolean(12, funcionario.getPulmonar());
            ps.setBoolean(13, funcionario.getRenal());
            ps.setBoolean(14, funcionario.getImunidade());
            ps.setBoolean(15, funcionario.getGestante());
            ps.setBoolean(16, funcionario.getAnomalias());
            ps.setString(17, funcionario.getViagem().toUpperCase());
            ps.setString(18, funcionario.getLocalidade().toUpperCase());
            ps.setString(19, funcionario.getMatricula());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException sqle) {
            throw new ConexaoException("Erro ao atualizar os dados " + sqle.getMessage());
        } catch (Exception sqle) {
            throw new ConexaoException("Erro ao atualizar os dados " + sqle.getMessage());
        }
    }

    @Override
    public Funcionario buscarMatricula(String matricula) throws ConexaoException {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = this.conn;
            pst = Conexao.getConnection().prepareStatement("select * from funcionario where matricula = ?");
            pst.setString(1, matricula);
            rs = pst.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return new Funcionario(rs.getString("matricula"), rs.getString("nome"), rs.getString("empresa"),
                    rs.getString("endereco"), rs.getString("numero"), rs.getString("cidade"), rs.getString("dtnascimento"),
                    rs.getString("sexo"), rs.getString("telefone"), rs.getBoolean("cardiaco"), rs.getBoolean("hipertensao"),
                    rs.getBoolean("diabete"), rs.getBoolean("pulmonar"), rs.getBoolean("renal"), rs.getBoolean("imunidade"),
                    rs.getBoolean("gestante"), rs.getBoolean("anomalias"), rs.getString("viagem"), rs.getString("localidade"));

        } catch (SQLException sqle) {
            throw new ConexaoException("Erro ao buscar dados " + sqle.getMessage());
        }
    }

    @Override
    public void excluir(Funcionario funcionario) throws ConexaoException {
    }

}
