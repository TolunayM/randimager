const fetchImage = () => {
    // API isteği gönder
    fetch("http://localhost:8080/image",{method: "GET"}) // API endpointini doğru şekilde ayarlayın
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.blob(); // Gelen veriyi bir Blob nesnesi olarak al
        })
        .then(imageBlob => {
            // Blob nesnesini bir URL'ye dönüştür
            const imageUrl = URL.createObjectURL(imageBlob);

            // Resmi göster
            const imageElement = document.getElementById("imageElement");
            imageElement.src = imageUrl;
        })
        .catch(error => {
            console.error("API isteği sırasında hata oluştu:", error);
        });
};

// "Yeni Resim Getir" düğmesine tıklama olayını dinle
document.getElementById("fetchImageButton").addEventListener("click", fetchImage);