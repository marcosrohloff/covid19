/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.covid19.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Sintoma implements Serializable {

    private int idSintoma;
    private String matricula;
    private Funcionario funcionario;
    private Date data;
    private String turno;
    private String febre;
    private Boolean coriza;
    private Boolean espirro;
    private Boolean tosse;
    private Boolean diarreia;

    public Sintoma() {
    }

    public Sintoma(String matricula, Date data, String turno, String febre, Boolean coriza, Boolean espirro, Boolean tosse, Boolean diarreia) {
        this.matricula = matricula;
        this.data = data;
        this.turno = turno;
        this.febre = febre;
        this.coriza = coriza;
        this.espirro = espirro;
        this.tosse = tosse;
        this.diarreia = diarreia;
    }

    public Sintoma(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(int idSintoma) {
        this.idSintoma = idSintoma;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getFebre() {
        return febre;
    }

    public void setFebre(String febre) {
        this.febre = febre;
    }

    public Boolean getCoriza() {
        return coriza;
    }

    public void setCoriza(Boolean coriza) {
        this.coriza = coriza;
    }

    public Boolean getEspirro() {
        return espirro;
    }

    public void setEspirro(Boolean espirro) {
        this.espirro = espirro;
    }

    public Boolean getTosse() {
        return tosse;
    }

    public void setTosse(Boolean tosse) {
        this.tosse = tosse;
    }

    public Boolean getDiarreia() {
        return diarreia;
    }

    public void setDiarreia(Boolean diarreia) {
        this.diarreia = diarreia;
    }

    @Override
    public String toString() {
        return "Sintoma{" + "idSintoma=" + idSintoma + ", matricula=" + matricula + ", data=" + data + ", turno=" + turno + ", febre=" + febre + ", coriza=" + coriza + ", espirro=" + espirro + ", tosse=" + tosse + ", diarreia=" + diarreia + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idSintoma;
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
        final Sintoma other = (Sintoma) obj;
        if (this.idSintoma != other.idSintoma) {
            return false;
        }
        return true;
    }

}
