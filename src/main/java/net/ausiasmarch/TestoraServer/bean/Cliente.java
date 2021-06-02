/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.TestoraServer.bean;


import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public class Cliente {

//    @Expose
    private ArrayList<RemesaPendiente> remesasPendientes;

    public Cliente() {
        this.remesasPendientes = new ArrayList<>();
    }

    public ArrayList<RemesaPendiente> getRemesasPendientes() {
        return remesasPendientes;
    }

    public void setlremesasPendientes(ArrayList<RemesaPendiente> remesasPendientes) {
        this.remesasPendientes = remesasPendientes;
    }

//    @Expose
    private Integer id;
//    @Expose
    private String nombre;
//    @Expose
    private String primerApellido;
//    @Expose
    private String segundoApellido;
//    @Expose
    private String direccion;
//    @Expose
    private String poblacion;
//    @Expose
    private String codigoPostal;
//    @Expose
    private String telefono;

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
//    @Expose
    private String email;
//    @Expose
    private FormaDeCobro cobro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FormaDeCobro getCobro() {
        return cobro;
    }

    public void setCobro(FormaDeCobro cobro) {
        this.cobro = cobro;
    }

}
