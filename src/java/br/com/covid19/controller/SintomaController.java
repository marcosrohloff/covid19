/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.covid19.controller;

import br.com.covid19.dao.ISintomaDao;
import br.com.covid19.dao.SintomaDao;
import br.com.covid19.entidades.Funcionario;
import br.com.covid19.entidades.Sintoma;
import br.com.covid19.exception.ConexaoException;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Administrador
 */
@ManagedBean
@SessionScoped
public class SintomaController implements Serializable {

    private Sintoma sintoma;
    private String matricula;
    private Funcionario funcionario;
    boolean sucesso = true;

    public SintomaController() {
        sintoma = new Sintoma();
    }

    public Sintoma getSintomas() {
        if (sintoma == null) {
            sintoma = new Sintoma();
        }
        return sintoma;
    }

    public String salvar() throws ConexaoException {

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ISintomaDao isd = new SintomaDao();
            isd.salvar(sintoma);
            if (sucesso) {               
                context.addMessage(null, new FacesMessage("Registro gravado com sucesso!")); 
                limpar();
            }
        } catch (ConexaoException ex) {
            context.addMessage(null, new FacesMessage("Erro ao gravar os dados!" + ex.getMessage()));
        }
        limpar();
        return "retorno.xhtml";
    }

    public void pesquisar(AjaxBehaviorEvent event) {

        FacesContext context = FacesContext.getCurrentInstance();
        if (matricula != null || matricula.length() != 0) {
            try {
                ISintomaDao isd = new SintomaDao();
                sintoma = isd.buscarDados(matricula);
            } catch (ConexaoException ex) {
                context.addMessage(null, new FacesMessage("Erro:" + ex.getMessage()));
            }
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void voltar() {
        limpar();
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(ec.getRequestContextPath() + "/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void limpar() {
        this.funcionario = new Funcionario();
        this.sintoma = new Sintoma();
        matricula = "";
        setMatricula("");
    }

}
