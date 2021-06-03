/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.TestoraServer.helper;

import java.util.ArrayList;
import net.ausiasmarch.TestoraServer.bean.Clientes;
import net.ausiasmarch.TestoraServer.bean.RemesaPendiente;

/**
 *
 * @author rafa
 */
public class RemesasMaker {

    public ArrayList<RemesaPendiente> getRemesas() throws Exception {
        ArrayList<RemesaPendiente> remesasPendientes = new ArrayList<>();
        int numlineas1 = Aleatorio.randInt(1, 6);
        for (int contador3 = 1; contador3 <= numlineas1; contador3++) {
            RemesaPendiente oRemPend = new RemesaPendiente();
            oRemPend.setId(Aleatorio.randInt(1, 1000000));
            oRemPend.setFecha(randomDate.getRandomDate(2004, 2015));
            oRemPend.setTotal(Aleatorio.randDbl(5, 5890));
            remesasPendientes.add(oRemPend);
        }
        return remesasPendientes;
    }
}
