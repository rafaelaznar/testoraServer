/*
 * Copyright (c) 2020
 *
 * by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com) & 2020 DAW students
 *
 * TROLLEYES: Free Open Source Shopping Site
 *
 *
 * Sources at:                https://github.com/rafaelaznar/trolleyesSBserver
 * Database at:               https://github.com/rafaelaznar/trolleyesSBserver
 * Client at:                 https://github.com/rafaelaznar/TrolleyesAngularJSClient
 *
 * TROLLEYES is distributed under the MIT License (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.ausiasmarch.TestoraServer.api;

import javax.servlet.http.HttpSession;
import net.ausiasmarch.TestoraServer.bean.Cliente;
import net.ausiasmarch.TestoraServer.bean.Clientes;

import net.ausiasmarch.TestoraServer.bean.UsuarioBean;
import net.ausiasmarch.TestoraServer.helper.ClienteMaker;
import net.ausiasmarch.TestoraServer.helper.RemesasMaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    HttpSession oHttpSession;

    // localhost:8082/cliente/all/100
    @GetMapping("/all/{number}")
    public ResponseEntity<?> all(@PathVariable(value = "number") Long number) throws Exception {
        UsuarioBean oUsuarioEntityFromSession = (UsuarioBean) oHttpSession.getAttribute("usuario");
        if (oUsuarioEntityFromSession == null) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        } else {
            if (oUsuarioEntityFromSession.getLogin().equalsIgnoreCase("admin")) {
                ClienteMaker oClienteMaker = new ClienteMaker();
                Clientes oClientes = oClienteMaker.getClientes(number);
                return ResponseEntity.status(HttpStatus.OK).body(oClientes);

            } else {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }
        }
    }

    // localhost:8082/cliente/
    @GetMapping("/")
    public ResponseEntity<?> one() throws Exception {
        UsuarioBean oUsuarioEntityFromSession = (UsuarioBean) oHttpSession.getAttribute("usuario");
        if (oUsuarioEntityFromSession == null) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        } else {
            if (oUsuarioEntityFromSession.getLogin().equalsIgnoreCase("admin")) {
                ClienteMaker oClienteMaker = new ClienteMaker();
                Cliente oCliente = oClienteMaker.getCliente();
                return ResponseEntity.status(HttpStatus.OK).body(oCliente);
            } else {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }
        }
    }

    // localhost:8082/cliente/      with json:
    // {
    //    "id": 625,
    //    "nombre": "Pepe",
    //    "primerApellido": "Serrano",
    //    "segundoApellido": "Alonso",
    //    "direccion": "Calle Simón Castillo, 1",
    //    "poblacion": "Valencia",
    //    "codigoPostal": "46013",
    //    "telefono": "85943546",
    //    "email": "exanderrranoonso@email.com"
    // }
    @PostMapping("/")
    public ResponseEntity<?> reflect(@RequestBody Cliente oClienteFromRequest) throws Exception {
        UsuarioBean oUsuarioEntityFromSession = (UsuarioBean) oHttpSession.getAttribute("usuario");
        if (oUsuarioEntityFromSession == null) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        } else {
            if (oUsuarioEntityFromSession.getLogin().equalsIgnoreCase("admin")) {
                if (oClienteFromRequest.getNombre() != null && oClienteFromRequest.getPrimerApellido() != null && oClienteFromRequest.getSegundoApellido() != null) {
                    if (oClienteFromRequest.getNombre().length() > 0 && oClienteFromRequest.getPrimerApellido().length() > 0 && oClienteFromRequest.getSegundoApellido().length() > 0) {
                        RemesasMaker oRemesasMaker = new RemesasMaker();
                        oClienteFromRequest.setlremesasPendientes(oRemesasMaker.getRemesas());
                        return ResponseEntity.status(HttpStatus.OK).body(oClienteFromRequest);
                    } else {
                        return new ResponseEntity<>(null, HttpStatus.LENGTH_REQUIRED);
                    }
                } else {
                    return new ResponseEntity<>(null, HttpStatus.LENGTH_REQUIRED);
                }
            } else {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }
        }
    }

}
