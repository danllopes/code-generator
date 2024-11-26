package br.com.danllopes.codegenerator.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;

@Service
public class QrCodeService {

    public void generateQrCode(String data, OutputStream outputStream) throws WriterException, IOException {
        BitMatrix bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, 200, 200);
        MatrixToImageWriter.writeToStream(bitMatrix, "png", outputStream);
    }
}
