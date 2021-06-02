/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.TestoraServer.helper;

import java.text.SimpleDateFormat;
import net.ausiasmarch.TestoraServer.bean.Cliente;
import net.ausiasmarch.TestoraServer.bean.Factura;
import net.ausiasmarch.TestoraServer.bean.Facturas;
import net.ausiasmarch.TestoraServer.bean.FormaDeCobro;
import net.ausiasmarch.TestoraServer.bean.LineaDeFactura;
import net.ausiasmarch.TestoraServer.bean.Producto;
import net.ausiasmarch.TestoraServer.bean.RemesaPendiente;
import net.ausiasmarch.TestoraServer.bean.TipoProducto;


/**
 *
 * @author rafa
 *
 */
public class FacturaMaker {

    public Facturas getFacturas() throws Exception {
        Facturas oFacturas = new Facturas();
        int numfacts = Aleatorio.randInt(1, 9);
        for (int contador1 = 1; contador1 <= numfacts; contador1++) {
            Factura oFactura = new Factura();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            oFactura.setFecha(randomDate.getRandomDate(2004, 2015));

            oFactura.setId(Aleatorio.randInt(1, 10000));

            oFactura.setIva(Aleatorio.randInt(1, 21));
            
            Cliente oCliente = (new ClienteMaker()).getCliente();
            
//            Cliente oCliente = new Cliente();
//
//            oCliente.setId(Aleatorio.randInt(1, 1000));
//
//            oCliente.setNombre(Aleatorio.dameNombre());
//            oCliente.setPrimerApellido(Aleatorio.dameApellido());
//            oCliente.setSegundoApellido(Aleatorio.dameApellido());
//            oCliente.setTelefono(Aleatorio.randStr(0, 9) + Aleatorio.randStr(0, 9) + Aleatorio.randStr(0, 9) + Aleatorio.randStr(0, 9) + Aleatorio.randStr(0, 9) + Aleatorio.randStr(0, 9) + Aleatorio.randStr(0, 9) + Aleatorio.randStr(0, 9));
//            oCliente.setDireccion("Calle " + Aleatorio.dameNombre() + " " + Aleatorio.dameApellido() + ", " + Aleatorio.randStr(0, 9));
//            oCliente.setPoblacion("Valencia");
//            oCliente.setEmail(EliminaAcentos.remove(oCliente.getNombre().substring(2) + oCliente.getPrimerApellido().substring(2) + oCliente.getSegundoApellido().substring(2)) + "@email.com");
            
            int numlineas1 = Aleatorio.randInt(1, 6);
            for (int contador3 = 1; contador3 <= numlineas1; contador3++) {
                RemesaPendiente oRemPend = new RemesaPendiente();
                oRemPend.setId(Aleatorio.randInt(1, 1000000));
                oRemPend.setFecha(randomDate.getRandomDate(2004, 2015));
                oRemPend.setTotal(Aleatorio.randDbl(5, 5890));
                oCliente.getRemesasPendientes().add(oRemPend);
            }

            FormaDeCobro oForma = new FormaDeCobro();
            oForma.setId(Aleatorio.randInt(1, 1000));
            oForma.setDescripcion("Cheque Bancario a " + Aleatorio.randInt(20, 90) + " días");

            oCliente.setCobro(oForma);

            oFactura.setCliente(oCliente);

            int numlineas = Aleatorio.randInt(1, 13);

            for (int contador2 = 1; contador2 <= numlineas; contador2++) {
                LineaDeFactura oLinea = new LineaDeFactura();
                Producto oProducto = new Producto();
                oProducto.setId(Aleatorio.randInt(1, 1000));
                oProducto.setDescripcion(Aleatorio.dameHerramienta());
                oProducto.setPrecioUnitario(Aleatorio.randDbl(5, 590));
                TipoProducto oTipoProducto = new TipoProducto();
                oTipoProducto.setId(Aleatorio.randInt(1, 1000));
                oTipoProducto.setDescripcion(Aleatorio.dameTipoProducto() + " tipo " + Aleatorio.randInt(1, 100));
                oProducto.setTipoProducto(oTipoProducto);

                oLinea.setId(contador2);
                oLinea.setProducto(oProducto);
                oLinea.setCantidad(Aleatorio.randInt(1, 10));
                oFactura.getLineasDeFactura().add(oLinea);

            }

            oFacturas.getRemesa().add(oFactura);
        }
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setDateFormat("yyyy/MM/dd");
//        Gson gson = gsonBuilder.create();
//        String resultado = gson.toJson(oFacturas);
        return oFacturas;

    }
}
