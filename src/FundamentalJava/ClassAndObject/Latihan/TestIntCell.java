package FundamentalJava.ClassAndObject.Latihan;

class IntCell {
    
    public int read() {
        return storedValue;
    }

    public void write(int x) {
        storedValue = x;
    }

    private int storedValue;
}

public class TestIntCell {
    public static void main(String[] args) {

        IntCell m = new IntCell();
        m.write(5);

        System.out.println("Cell contens: " + m.read());

    }
} 
