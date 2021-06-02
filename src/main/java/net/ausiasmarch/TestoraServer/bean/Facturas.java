package net.ausiasmarch.TestoraServer.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public class Facturas {
//   @Expose
    private ArrayList<Factura> remesa;

    public Facturas() {
        this.remesa = new ArrayList<>();
    }

    public ArrayList<Factura> getRemesa() {
        return remesa;
    }

    public void setRemesa(ArrayList<Factura> remesa) {
        this.remesa = remesa;
    }


      
}
