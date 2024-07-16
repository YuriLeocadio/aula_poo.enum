package com.poo.aula_enum;

public enum UF {

    AC("Acre"),
    AL("Alagoas"),
    AP("Amapá"),
    AM("Amazonas"),
    BA("Bahia"),
    CE("Ceará"),
    DF("Distrito Federal"),
    ES("Espírito Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    MG("Minas Gerais"),
    PA("Pará"),
    PB("Paraíba"),
    PR("Paraná"),
    PE("Pernambuco"),
    PI("Piauí"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RS("Rio Grande do Sul"),
    RO("Rondônia"),
    RR("Roraima"),
    SC("Santa Catarina"),
    SP("São Paulo"),
    SE("Sergipe"),
    TO("Tocantins");

    private final String nomePorExtenso;

    UF(String nomePorExtenso) {
        this.nomePorExtenso = nomePorExtenso;
    }

    public String getNomePorExtenso() {
        return nomePorExtenso;
    }

    public static boolean validarSigla(String sigla) {
        for (UF uf : values()) {
            if (uf.name().equals(sigla)) {
                return true;
            }
        }
        return false;
    }
}