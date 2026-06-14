package FundamentalJava.Array.Latihan;

public class ManajemenGudang {
    public static void main(String[] args) {
        
        System.out.println("----- Laporan Stock Gudang -----");

        // Bagian 1 
        // Array 1 dimensi - untuk menyimpan total stock satu jenis produk
        // Misalnya 3 stok buku di 3 gudang berbeda
        int[] stokTotalBuku = {150, 200, 180};

        System.out.println("\n[ID Array] Total stok buku di setiap gudang; ");
        System.out.println("Gudang 1: " + stokTotalBuku[0] + " unit.");
        System.out.println("Gudang 2: " + stokTotalBuku[1] + " unit.");
        System.out.println("Gudang 3: " + stokTotalBuku[2] + " unit.");

        // Bagian 2
        // Array 2 dimensi untuk menyimpan data stok 3 jenis produk (baris) di 3 gudang berbeda (kolom)
        String[] namaProduk = {"Pensil", "Pulpen", "Buku"};
        int[][] stokSemuaProduk = {
            {100, 120, 90},   // stok pensil digudang 1,2,3
            {250, 180, 220},  // stok pulpen di gudang 1,2,3
            {150, 200, 180}   // stok buku di gudang 1,2,3
        };

        System.out.println("\n[2D Array] stok setiap produk di setiap gudang:");
        System.out.println("Produk:\t\tGudang 1\tGudang 2\tGudang 3\n");
        System.out.println("---------------------------------------");

        for (int i = 0; i < namaProduk.length; i++) {
            System.out.print(namaProduk[i] + "\t");
            for (int j = 0; j < stokSemuaProduk[i].length; j++) {
                System.out.print("\t" + stokSemuaProduk[i][j] + "\t");
            }
            System.out.println();
        }

        // Bagian 3
        // Array tidak beraturan
        // Kita pakai array ini untuk detail produk, dimana setiap kategori punya jumlah barang yang berbeda. ini nunjukin fleksibilitas java
        String[][] detailKategori = new String[3][];

        // Alokasi baris pertama: 2 barang
        detailKategori[0] = new String[2];
        
        detailKategori[0][0] = "Laptop X";
        detailKategori[0][0] = "Monitor Y";

        // Alokasi baris kedua: 3 barang
        detailKategori[1] = new String[3];

        detailKategori[1][0] = "Mouse Z";
        detailKategori[1][1] = "Keyboard K";
        detailKategori[1][2] = "Webcam W";

        // Alokasi baris ketiga: 1 barang
        detailKategori[2] = new String[1];
        detailKategori[2][0] = "Router R";

        System.out.println("\n[Array of Arrays] Detail kategori Produk:");
        System.out.println("Kategori Komputer: " + detailKategori[0][0] + ", " + detailKategori[0][1]);
        System.out.println("Kategori Periferal: " + detailKategori[1][0] + ", " + detailKategori[1][1] + ", " + detailKategori[1][2]);
        System.out.println("Kategori Jaringan: " + detailKategori[2][0]);
    }
}
