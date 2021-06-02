package net.ausiasmarch.TestoraServer.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 *
 * @author rafa
 */
public class RemesaPendiente {

//    @Expose
    private Integer id;
//    @Expose
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd", timezone = "GMT")
    private Date fecha;
//    @Expose
     @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="%.2f")
    private Double total; 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

   
    
    
}
