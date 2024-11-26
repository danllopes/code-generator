package br.com.danllopes.codegenerator.controllers;

import br.com.danllopes.codegenerator.service.QrCodeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/qr")
public class QrCodeController {

    private final QrCodeService service;

    public QrCodeController(QrCodeService service) {
        this.service = service;
    }
}
