function generateQRCode(qrString) {
    const qrCodeContainer = document.getElementById('qr-code-container');
    const img = qrCodeContainer.querySelector('img');

    fetch('http://localhost:8080/v1/qr/generate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: new URLSearchParams({ qrString })
    })
    .then(response => response.json())
    .then(data => {
        if (data.error) {
            errorMessage.textContent = data.error;
        } else {
                img.style.opacity = '1';
                img.src = data.qrCodeImage;
        }
    })
    .catch(error => {
        errorMessage.textContent = 'Houve um erro ao gerar o QR Code. Tente novamente.';
    });
}

document.getElementById('qr-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const qrString = document.getElementById('input-url').value;
    generateQRCode(qrString);
});