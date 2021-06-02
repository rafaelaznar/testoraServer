package net.ausiasmarch.TestoraServer.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.ArrayList;
import java.util.Date;
import net.ausiasmarch.TestoraServer.helper.JsonDateDeserializer;
import net.ausiasmarch.TestoraServer.helper.JsonDateSerializer;

/**
 *
 * @author rafa
 */
public class Factura {

//    @Expose
    private Integer id;
//    @Expose
    private Cliente cliente;
//    @Expose
    private ArrayList<LineaDeFactura> lineasDeFactura;
//    @Expose
    //@JsonDeserialize(using = JsonDateDeserializer.class)
    //@JsonSerialize(using = JsonDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd", timezone = "GMT")
    private Date fecha;
//    @Expose
    private Integer iva;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Factura() {
        this.lineasDeFactura = new ArrayList<>();
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the lineasDeFactura
     */
    public ArrayList<LineaDeFactura> getLineasDeFactura() {
        return lineasDeFactura;
    }

    /**
     * @param lineasDeFactura the lineasDeFactura to set
     */
    public void setLineasDeFactura(ArrayList<LineaDeFactura> lineasDeFactura) {
        this.lineasDeFactura = lineasDeFactura;
    }

}
