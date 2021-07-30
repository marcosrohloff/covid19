/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.covid19.dao;

import br.com.covid19.entidades.Funcionario;
import br.com.covid19.exception.ConexaoException;

/**
 *
 * @author Administrador
 */
public interface IFuncionarioDao {

    public void atualizar(Funcionario funcionario) throws ConexaoException;

    public void salvar(Funcionario funcionario) throws ConexaoException;

    public void excluir(Funcionario funcionario) throws ConexaoException;

    public Funcionario buscarMatricula(String matricula) throws ConexaoException;

    // public List<Funcionario> buscaMatricula(int matricula) throws ConexaoException;
}
