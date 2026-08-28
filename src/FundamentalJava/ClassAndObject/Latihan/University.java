package FundamentalJava.ClassAndObject.Latihan;

// Latihan

public class University {

    String nama;
    String usia;
    String kota;

    University(String nama, String usia, String kota) {
        this.nama = nama;
        this.usia = usia;
        this.kota = kota;
    }

    void infoMahasiswa() {
        System.out.println(nama + " " + usia + " " + kota);
        Mahasiswa mahasiswa = new Mahasiswa("J.E Murobic", 85.6);
        mahasiswa.state();
    }

    class Mahasiswa {
        String dataPrivasi;
        double nilai;

        Mahasiswa(String dataPrivasi, double nilai) {
            this.dataPrivasi = dataPrivasi;
            this.nilai = nilai;
        }

        void state() {
            System.out.println(dataPrivasi + " " + nilai);
        }
    }

    public static void main(String[] args) {

        University university = new University("University State of Burg", "120", "California");
        university.infoMahasiswa();

        // Akses Inner class
        University.Mahasiswa innerMahasiswa = university.new Mahasiswa("-", 0);
        innerMahasiswa.state();

    }
}
