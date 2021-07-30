/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.covid19.dao;

import br.com.covid19.entidades.Sintoma;
import br.com.covid19.exception.ConexaoException;

/**
 *
 * @author Administrador
 */
public interface ISintomaDao {

    public void salvar(Sintoma sintoma) throws ConexaoException;

    public Sintoma buscarDados(String matricula) throws ConexaoException;

}
