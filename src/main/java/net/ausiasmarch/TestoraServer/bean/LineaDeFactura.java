package net.ausiasmarch.TestoraServer.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rafa
 */
public class LineaDeFactura {

//    @Expose
    private Integer id;
//    @Expose
    private Producto producto;
//    @Expose
    private Integer cantidad;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Producto getProducto() {
        return producto;
    }

 
    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    public Integer getCantidad() {
        return cantidad;
    }

 
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
