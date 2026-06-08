package Array.Latihan;

public class CatatanPengeluaran {
    public static void main(String[] args) {
        
        // Deklarasi dan inisialisasi variabel dengan type yg berbeda
        String namaBarang1 = "Susu";
        double hargaBarang1 = 15500.0;
        int jumlahBarang1 = 2;

        String namaBarang2 = "Roti tawar";
        double hargaBarang2 = 9850.5;
        int jumlahBarang2 = 1;

        // Menggunakan array untuk menyimpan total harga setiap barang
        double[] totalHargaItem = new double[2];

        // Perhitungan dan promosi tipe otomatis
        // Jumlah (int) dikalikan dengan harga (double)
        totalHargaItem[0] = hargaBarang1 * jumlahBarang1;
        totalHargaItem[1] = hargaBarang2 * jumlahBarang2;

        // Menjumlahkan total semua harga barang
        double totalBelanja = totalHargaItem[0] + totalHargaItem[1];

        // Konversi tipe casting
        int totalBelanjaBulat = (int) totalBelanja;

        // Cetak struk 
        System.out.println("----- Struk Belanja -----");
        System.out.println(namaBarang1 + " (" + jumlahBarang1 + "x): Rp" + totalHargaItem[0]);
        System.out.println(namaBarang2 + " (" + jumlahBarang2 + "x): Rp" + totalHargaItem[1]);
        System.out.println("----------------------");
        System.out.println("Total akhir: Rp" + totalBelanja);
        System.out.println("Total (dibulatkan): Rp" + totalBelanjaBulat);

    }

}
