/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.covid19.util;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Administrador
 */
public class FacesUtil {

    public static void addInfoMessage(String msg) {
        addInfoMessage(null, msg);
    }

    /**
     * Adiciona mensagem de informacao(FacesMessage.SEVERITY_INFO) no request
     *
     * @param clientId id do componente no cliente ou <code>null</code> para
     * mensagens globais
     * @param msg mensagem
     */
    public static void addInfoMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
    }

    /**
     * Adiciona mensagem global de erro(FacesMessage.SEVERITY_ERROR) no request
     *
     * @param msg mensagem
     * @see FacesUtils#addErrorMessage(String, String)
     */
    public static void addErrorMessage(String msg) {
        addErrorMessage(null, msg);
    }

    /**
     * Adiciona mensagem de erro(FacesMessage.SEVERITY_ERROR) no request
     *
     * @param clientId id do componente no cliente ou <code>null</code> para
     * mensagens globais
     * @param msg mensagem
     */
    public static void addErrorMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
    }

    /**
     * Apresenta a mensagem na UI.
     *
     * @param title o titulo da mensagem.
     * @param message a mensagem que ser apresentada.
     * @param severity o tipo de mensagem.
     * @see FacesMessage
     */
    public static void mensagem(String title, String message, FacesMessage.Severity severity) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, title, message));
    }

    public static String get(String param) {
        return (String) FacesContext.getCurrentInstance().
                getExternalContext().
                getRequestParameterMap().get(param);
    }

    /**
     * Obtem as mensagens do arquivo de propriedades.
     *
     * @param key a chave da mensagem no arquivo de propriedades.
     * @return a mensagem referente a chave.
     */
    public static final String getMessage(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot viewRoot = context.getViewRoot();
        ResourceBundle bundle = ResourceBundle.getBundle("ui.Messages", viewRoot.getLocale());
        return bundle.getString(key);
    }

    /**
     * Redireciona para a pagina informada pelo parametro.
     *
     * @param originalViewId a pagina que ser redirecionada.
     */
    public static final void redirectPage(String originalViewId) {
        FacesContext context = FacesContext.getCurrentInstance();
        ViewHandler viewHandler = context.getApplication().getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, originalViewId);
        context.setViewRoot(viewRoot);
    }

    // remove objeto da sessao
    public static void removeSessionMapValue(String key) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(key);
    }

    // Getters
    // -----------------------------------------------------------------------------------
    public static Object getRequestMapValue(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(key);
    }

    // Setters
    // -----------------------------------------------------------------------------------
    public static void setRequestMapValue(String key, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(key, value);
    }

    // Getters
    // -----------------------------------------------------------------------------------
    public static Object getSessionMapValue(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
    }

    // Setters
    // -----------------------------------------------------------------------------------
    public static void setSessionMapValue(String key, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
    }

    public static String getAsConvertedString(Object object, Converter converter) {
        return converter.getAsString(FacesContext.getCurrentInstance(), null, object);
    }

}
