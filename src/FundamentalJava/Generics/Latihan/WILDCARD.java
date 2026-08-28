package FundamentalJava.Generics.Latihan;

// Latihan

class ObjekNilai<T extends Number> {
    T[] dataNilai;

    ObjekNilai(T[] dataNilai) {
        this.dataNilai = dataNilai;
    }

    // Hitung rata-rata nyaa
    double nilaiAverage() {
        double jumlah = 0.0;
        for (int i = 0; i < dataNilai.length; i++) {
            jumlah += dataNilai[i].doubleValue();
        }
        return jumlah / dataNilai.length;
    }

    // Bandingkan nilai rata-rata dari setiap objek
    // Baik Integer, Double, maupun Float
    // Kuncinya pake wildcacrd
    boolean bandingkan(ObjekNilai<?> objekNilai) {
        if (nilaiAverage() == objekNilai.nilaiAverage()) {
            return true;
        } else {
            return false;
        }
    }
}

public class WILDCARD {
    public static void main(String[] args) {

        Integer dataInteger[] = { 45, 58, 85, 57, 97, 48, 57, 65 };
        ObjekNilai<Integer> objekInteger = new ObjekNilai<>(dataInteger);

        Double dataDouble[] = { 1.5, 4.8, 7.5, 7.9, 7.7, 8.7, 9.5 };
        ObjekNilai<Double> objekDouble = new ObjekNilai<>(dataDouble);

        Float dataFloat[] = { 45.0f, 58.0f, 85.0f, 57.0f, 97.0f, 48.0f, 57.0f, 65.0f };
        ObjekNilai<Float> objekFloat = new ObjekNilai<>(dataFloat);

        double nilaiInteger = objekInteger.nilaiAverage();
        System.out.println("Nilai Objek Integer: " + nilaiInteger);

        double nilaiDouble = objekDouble.nilaiAverage();
        System.out.println("Nilai Objek Integer: " + nilaiDouble);

        double nilaiFloat = objekFloat.nilaiAverage();
        System.out.println("Nilai Objek Integer: " + nilaiFloat);

        System.out.println();

        // SEKARANG KITA BANDINGKAN SEMUANYA
        System.out.print("Apakah nilai rata-rata Objek Integer sama dengan Objek Double: ");
        if (objekInteger.bandingkan(objekDouble)) {
            System.out.println("Nilai rata-rata nya sama.");
        } else {
            System.out.println("Nilainya berbeda.");
        }

        System.out.print("Apakah nilai rata-rata Objek Integer sama dengan Objek Float: ");
        if (objekInteger.bandingkan(objekFloat)) {
            System.out.println("Nilai rata-rata nya sama.");
        } else {
            System.out.println("Nilainya berbeda.");
        }
    }
}
