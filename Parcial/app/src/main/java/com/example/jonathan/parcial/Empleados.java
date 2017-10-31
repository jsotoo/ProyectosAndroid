package com.example.jonathan.parcial;

import android.widget.ImageView;

/**
 * Created by Jonathan on 10/10/2017.
 */

public class Empleados {



    private String nombres;
    private String cargo;
    private String empresa;


    public String getNombres() { return nombres;}
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }


}
