package FundamentalJava.Interface;

// Farich Murobic.

public class AnotherClass implements Callback {

    @Override
    public void callback(int param) {
        System.out.println("Another class" + param);
    }

}
