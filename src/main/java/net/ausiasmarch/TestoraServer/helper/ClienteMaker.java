package net.ausiasmarch.TestoraServer.helper;

import net.ausiasmarch.TestoraServer.bean.Cliente;
import net.ausiasmarch.TestoraServer.bean.Clientes;
import net.ausiasmarch.TestoraServer.bean.FormaDeCobro;
import net.ausiasmarch.TestoraServer.bean.RemesaPendiente;

public class ClienteMaker {

    public Cliente getCliente() throws Exception {
        Cliente oCliente = new Cliente();

        oCliente.setId(Aleatorio.randInt(1, 1000));
        oCliente.setNombre(Aleatorio.dameNombre());
        oCliente.setPrimerApellido(Aleatorio.dameApellido());
        oCliente.setSegundoApellido(Aleatorio.dameApellido());
        oCliente.setTelefono(Aleatorio.randStr(0, 9) + Aleatorio.randStr(0, 9) + Aleatorio.randStr(0, 9) + Aleatorio.randStr(0, 9) + Aleatorio.randStr(0, 9) + Aleatorio.randStr(0, 9) + Aleatorio.randStr(0, 9) + Aleatorio.randStr(0, 9));
        oCliente.setDireccion("Calle " + Aleatorio.dameNombre() + " " + Aleatorio.dameApellido() + ", " + Aleatorio.randStr(0, 9));
        oCliente.setPoblacion("Valencia");
        oCliente.setCodigoPostal(Integer.toString(46000 + (Aleatorio.randInt(0, 99))));
        oCliente.setEmail(EliminaAcentos.remove(oCliente.getNombre().substring(2) + oCliente.getPrimerApellido().substring(2) + oCliente.getSegundoApellido().substring(2)) + "@email.com");

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

        return oCliente;
    }

    public Clientes getClientes(long number) throws Exception {
        Clientes oClientes = new Clientes();
        for (int i = 1; i <= number; i++) {
            Cliente oCliente = (new ClienteMaker()).getCliente();
            oClientes.getClientes().add(oCliente);
        }
        return oClientes;
    }

}
