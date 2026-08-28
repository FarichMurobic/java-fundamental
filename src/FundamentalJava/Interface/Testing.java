package FundamentalJava.Interface;

// Farich Murobic...

public class Testing {
    public static void main(String[] args) {

        Callback client;
        client = new Client();
        client.callback(56);

        client = new AnotherClass();
        client.callback(25);
    }

}
