package br.com.danllopes.codegenerator.controllers;

import br.com.danllopes.codegenerator.service.QrCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("v1/qr")
public class QrCodeController {

    private final QrCodeService service;

    public QrCodeController(QrCodeService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    public ResponseEntity<?> generateQr(@RequestParam("qrString") String qrString) {
        if (qrString == null || qrString.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "The field cannot be empty!"));
        }

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            service.generateQrCode(qrString, outputStream);

            String encodedQrCode  = "data:image/png;base64," +
                    Base64.getEncoder().encodeToString(outputStream.toByteArray());

            return ResponseEntity.ok(Map.of("qrCodeImage", encodedQrCode));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Error generating QR Code!"));
        }
    }
}
