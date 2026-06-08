package Enum;
public class Enum {
    public static void main(String[] args) {
        
        // Deklarasi variabel enum
        // Inget enum gak bisa pake new
        Enumerations enumerations;

        // Assign nilai enum
        enumerations = Enumerations.RedDel;

        // Cetak nilai enum
        System.out.println("Value of Enum: " + enumerations);

        System.out.println();

        // Ganti nilai enum
        enumerations = Enumerations.Goldendel;
        // Bandingkan enum
        if (enumerations == Enumerations.Goldendel)
            System.out.println("Enumerations contains GoldenDel.\n");

        // Ganti nilai enum
        enumerations = Enumerations.RedDel;
        // Switch pakai enum
        switch (enumerations) {
            case Jonathan -> System.out.println("Jonathan is Red.");
            case Goldendel -> System.out.println("Golden delicious is yellow.");
            case RedDel -> System.out.println("RedDel delicious is Red.");
            case Winesap -> System.out.println("Winesap is Red.");
            case Cortland -> System.out.println("Cortland is Red.");
        }

        System.out.println();

        // Deklarasi enum Status
        Status state = Status.Online;
        if (state == Status.Online)
            System.out.println("User sedang online...");

        System.out.println();

        Enumerations enumerations1;
        // Cetak semua isi enum
        System.out.println("Here are all Enumerations constants");

        // Ambil semua nilai enum dalam bentuk array
        Enumerations[] allEnum = Enumerations.values();
        // Looping pakai for-each
        for (Enumerations x : allEnum) {
            System.out.println(x);
        }

        System.out.println();

        // Versi lebih simple tanpa variabel array
        for (Enumerations x : Enumerations.values()) {
            System.out.println(x);
        }

        System.out.println();

        // Ambil enum dari string
        enumerations1 = Enumerations.valueOf("Winesap");
        // Cetak
        System.out.println(enumerations1);

        /**
         * ALUR PROGRAM
         * 
         * Enum Enumerations dibuat
         * Program jalan ke main
         * values() dipanggil:
         * hasil: array isi semua enum
         * Loop:
         * print satu per satu
         * 
         * valueOf("Winesap"):
         * cari enum dengan nama "Winesap"
         * Disimpan ke enumerations1
         * Dicetak
         *
         * OUTPUT
         * Here are all Apple constants:
         * Jonathan
         * GoldenDel
         * RedDel
         * Winesap
         * Cortland
         *
         * Winesap
         */

        System.out.println();

        // Deklarasi
        Status status;
        // Cetak semua isi enum di Status
        for (Status x : Status.values()) {
            System.out.println(x);
        }
    }
}
