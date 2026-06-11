package PROJECTSEDERHANA.SistemKasirSederhana;

import java.util.ArrayList;

// class barang
class Barang {
    String nama;
    double harga;
    int jumlah;

    // konstruktor
    Barang(String nama, double harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    // hitung subtotal barang
    double getSubtotal() {
        return harga * jumlah;
    }
}

// clas transaksi
class Transaksi {
    ArrayList<Barang> daftarBarang = new ArrayList<>();

    // tambah barang
    void tambahBarang(Barang b) {
        daftarBarang.add(b);
    }

    // hitung total semua barang
    double hitungTotal() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += b.getSubtotal();
        }
        return total;
    }
}

// abstract class pembayaran
abstract class Pembayaran {

    // method final (tidak boleh diubah)
    final void proses(double total) {
        System.out.println("Memproses pembayaran...");
        bayar(total); // panggil methode abstract
        // method final (tidak boleh diubah)
    }

    // methode abstract
    abstract void bayar(double total);

}

// Cash
class Cash extends Pembayaran {

    @Override
    void bayar(double total) {
        System.out.println("Bayar dengan cash: " + total);
    }
}

// QRIS
class QRIS extends Pembayaran {

    @Override
    void bayar(double total) {
        System.out.println("Scan QRIS untuk bayar: " + total);
    }
}

// E-wallet
class EWallet extends Pembayaran {

    @Override
    void bayar(double total) {
        System.out.println("Bayar dengan E-Wallet: " + total);
    }
}

// main
public class KasirDemo {
    public static void main(String[] args) {

        // buat transaksi
        Transaksi trx = new Transaksi();

        trx.tambahBarang(new Barang("Indomie", 3000, 2));
        trx.tambahBarang(new Barang("Teh botol", 5000, 1));

        double total = trx.hitungTotal();
        System.out.println("Total belanja: " + total);

        // polymorpisme
        Pembayaran p;

        p = new Cash();
        p.proses(total);

        p = new QRIS();
        p.proses(total);

        p = new EWallet();
        p.proses(total);

    }
}
