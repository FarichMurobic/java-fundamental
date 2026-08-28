package FundamentalJava.Enum.Latihan;

// Latihan

enum Bulan {
    January, February, March, April, Mei, June,
    July, August, September, October, November, Desember
}

public class MainAPP {
    public static void main(String[] args) {

        Bulan bulan;
        bulan = Bulan.June;

        switch (bulan) {
            case January -> System.out.println("Bulan 01");
            case February -> System.out.println("Bulan 02");
            case March -> System.out.println("Bulan 03");
            case April -> System.out.println("Bulan 04");
            case Mei -> System.out.println("Bulan 05");
            case June -> System.out.println("Bulan 06");
            case July -> System.out.println("Bulan 07");
            case August -> System.out.println("Bulan 08");
            case September -> System.out.println("Bulan 09");
            case October -> System.out.println("Bulan 10");
            case November -> System.out.println("Bulan 11");
            case Desember -> System.out.println("Bulan 12");
        }

        System.out.println("------------------------------");

        // Cetak semua
        for (Bulan x : Bulan.values()) {
            System.out.println(x);
        }
    }
}
