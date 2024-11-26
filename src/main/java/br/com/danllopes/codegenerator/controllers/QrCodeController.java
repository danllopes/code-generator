package br.com.danllopes.codegenerator.controllers;

import br.com.danllopes.codegenerator.service.QrCodeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/qr")
public class QrCodeController {

    private final QrCodeService serivice;

    public QrCodeController(QrCodeService service) {
        this.serivice = service;
    }
}