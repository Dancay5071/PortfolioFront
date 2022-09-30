package com.portfolio.dac.Dto;

import javax.validation.constraints.NotBlank;

public class dtobanner {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    public dtobanner() {
    }

    public dtobanner(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    
}

