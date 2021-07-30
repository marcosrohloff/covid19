/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.covid19.controller;

import br.com.covid19.dao.FuncionarioDao;
import br.com.covid19.dao.IFuncionarioDao;
import br.com.covid19.entidades.Funcionario;
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
public class FuncionarioController implements Serializable {

    private Funcionario funcionario;
    boolean sucesso = true;
    private String matricula;
    private String empresa;

    public FuncionarioController() {
        funcionario = new Funcionario();
    }

    public Funcionario getFuncionario() {
        if (funcionario == null) {
            funcionario = new Funcionario();
        }
        return funcionario;
    }

    public void salvar() throws ConexaoException {

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            IFuncionarioDao ifd = new FuncionarioDao();
            ifd.salvar(funcionario);
            if (sucesso) {
                funcionario = new Funcionario();
                context.addMessage(null, new FacesMessage("Registro gravado com sucesso!"));
            }
        } catch (ConexaoException ex) {
            context.addMessage(null, new FacesMessage("Erro ao gravar os dados!" + ex.getMessage()));
        }
    }

    public void atualizar() throws ConexaoException {

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            IFuncionarioDao ifd = new FuncionarioDao();
            ifd.atualizar(funcionario);
            if (sucesso) {
                funcionario = new Funcionario();
                context.addMessage(null, new FacesMessage("Registro gravado com sucesso!"));
                limpar();
                redirecionarPagina("");
            }

        } catch (ConexaoException ex) {
            context.addMessage(null, new FacesMessage("Erro ao atualizar os dados!" + ex.getMessage()));
        }
    }

    public void pesquisar(AjaxBehaviorEvent event) {

        FacesContext context = FacesContext.getCurrentInstance();
        if (matricula != null || matricula.length() != 0) {
            try {
                IFuncionarioDao ifd = new FuncionarioDao();
                funcionario = ifd.buscarMatricula(matricula);
            } catch (ConexaoException ex) {
                context.addMessage(null, new FacesMessage("Erro:" + ex.getMessage()));
            }
        }
    }

    public String cadastrarNovo() {
        limpar();
        return "formNovo.xhtml?faces-redirect=true";
    }

    public String alterarDados() {
        limpar();
        return "formAlt.xhtml?faces-redirect=true";
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

    public void redirecionarPagina(String pagina) {
        FacesContext context = FacesContext.getCurrentInstance();
        String url = context.getExternalContext().getRequestContextPath();
        try {
            context.getExternalContext().redirect(url + "/" + pagina);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmpresa() {
        return empresa = "COOPERATIVA AGROINDUSTRIAL COPAGRIL";
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void limpar() {
        this.funcionario = new Funcionario();
        this.matricula = "";
    }

}
