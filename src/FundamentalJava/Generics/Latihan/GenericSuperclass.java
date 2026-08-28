package FundamentalJava.Generics.Latihan;

// Latihan

class Parent<T, V> {

    private T objek1;
    private V objek2;

    public Parent(T objek1, V objek2) {
        this.objek1 = objek1;
        this.objek2 = objek2;
    }

    public T getT() {
        return objek1;
    }

    public V getV() {
        return objek2;
    }

    public void biodata() {
        System.out.println("Nama: " + objek1);
        System.out.println("Usia: " + objek2);
    }
}

class Child1<T, V, J> extends Parent<T, V> {

    private J objekChild;

    public Child1(T a, V b, J j) {
        super(a, b);
        objekChild = j;
    }

    public J getObjekChild() {
        return objekChild;
    }
}

public class GenericSuperclass {
    public static void main(String[] args) {

        Parent<String, Integer> biodata = new Parent<String, Integer>("Farich", 25);

        biodata.biodata();
        System.out.println(biodata.getT());
        System.out.println(biodata.getV());
        System.out.println(biodata.getClass().getName());

        System.out.println();

        Child1<String, Integer, Integer> biodata2 = new Child1("JANERA", 30, 88);

        biodata2.biodata();
        System.out.println(biodata2.getObjekChild());
    }

}
