/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.covid19.entidades;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Administrador
 */
public class Funcionario implements Serializable {

    private String matricula;
    private String nome;
    private String empresa;
    private String endereco;
    private String numero;
    private String cidade;
    private String dtNascimento;
    private String sexo;
    private String telefone;
    private Boolean cardiaco;
    private Boolean hipertensao;
    private Boolean diabete;
    private Boolean pulmonar;
    private Boolean renal;
    private Boolean imunidade;
    private Boolean gestante;
    private Boolean anomalias;
    private String viagem;
    private String localidade;

    public Funcionario() {
        super();
    }

    public Funcionario(String matricula, String nome, String empresa, String endereco, String numero, String cidade, String dtNascimento, String sexo, String telefone, Boolean cardiaco, Boolean hipertensao, Boolean diabete, Boolean pulmonar, Boolean renal, Boolean imunidade, Boolean gestante, Boolean anomalias, String viagem, String localidade) {
        this.matricula = matricula;
        this.nome = nome;
        this.empresa = empresa;
        this.endereco = endereco;
        this.numero = numero;
        this.cidade = cidade;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.cardiaco = cardiaco;
        this.hipertensao = hipertensao;
        this.diabete = diabete;
        this.pulmonar = pulmonar;
        this.renal = renal;
        this.imunidade = imunidade;
        this.gestante = gestante;
        this.anomalias = anomalias;
        this.viagem = viagem;
        this.localidade = localidade;
    }

    public Funcionario(String matricula, String nome, Boolean cardiaco, Boolean hipertensao, Boolean diabete, Boolean pulmonar, Boolean renal, Boolean imunidade, Boolean gestante, Boolean anomalias) {
        this.matricula = matricula;
        this.nome = nome;
        this.cardiaco = cardiaco;
        this.hipertensao = hipertensao;
        this.diabete = diabete;
        this.pulmonar = pulmonar;
        this.renal = renal;
        this.imunidade = imunidade;
        this.gestante = gestante;
        this.anomalias = anomalias;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getCardiaco() {
        return cardiaco;
    }

    public void setCardiaco(Boolean cardiaco) {
        this.cardiaco = cardiaco;
    }

    public Boolean getHipertensao() {
        return hipertensao;
    }

    public void setHipertensao(Boolean hipertensao) {
        this.hipertensao = hipertensao;
    }

    public Boolean getDiabete() {
        return diabete;
    }

    public void setDiabete(Boolean diabete) {
        this.diabete = diabete;
    }

    public Boolean getPulmonar() {
        return pulmonar;
    }

    public void setPulmonar(Boolean pulmonar) {
        this.pulmonar = pulmonar;
    }

    public Boolean getRenal() {
        return renal;
    }

    public void setRenal(Boolean renal) {
        this.renal = renal;
    }

    public Boolean getImunidade() {
        return imunidade;
    }

    public void setImunidade(Boolean imunidade) {
        this.imunidade = imunidade;
    }

    public Boolean getGestante() {
        return gestante;
    }

    public void setGestante(Boolean gestante) {
        this.gestante = gestante;
    }

    public Boolean getAnomalias() {
        return anomalias;
    }

    public void setAnomalias(Boolean anomalias) {
        this.anomalias = anomalias;
    }

    public String getViagem() {
        return viagem;
    }

    public void setViagem(String viagem) {
        this.viagem = viagem;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "matricula=" + matricula + ", nome=" + nome + ", empresa=" + empresa + ", endereco=" + endereco + ", numero=" + numero + ", cidade=" + cidade + ", dtNascimento=" + dtNascimento + ", sexo=" + sexo + ", telefone=" + telefone + ", cardiaco=" + cardiaco + ", hipertensao=" + hipertensao + ", diabete=" + diabete + ", pulmonar=" + pulmonar + ", renal=" + renal + ", imunidade=" + imunidade + ", gestante=" + gestante + ", anomalias=" + anomalias + ", viagem=" + viagem + ", localidade=" + localidade + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

}
