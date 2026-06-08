package Abstract.Latihan;

public abstract class BangunDatar {

    double dimensi1;
    double dimensi2;

    BangunDatar(double a, double b) {
        this.dimensi1 = a;
        this.dimensi2 = b;
    }

    abstract double luas();

}

class PersegiPanjang extends BangunDatar {

    PersegiPanjang(double a, double b) {
        super(a, b);
    }

    @Override
    double luas() {
        System.out.println("Menghitung luas persegi panjang");
        return dimensi1 * dimensi2;
    }
}

class Segitiga extends BangunDatar {

    Segitiga(double a, double b) {
        super(a, b);
    }

    @Override
    double luas() {
        System.out.println("Menghitung luas segitiga");
        return dimensi1 * dimensi2 / 2;
    }
}

class MainBangunDatar {
    public static void main(String[] args) {
        
        PersegiPanjang persegiPanjang = new PersegiPanjang(10, 10);
        System.out.println(persegiPanjang.luas());

        Segitiga segitiga = new Segitiga(15, 70);
        System.out.println(segitiga.luas());
    }

}
