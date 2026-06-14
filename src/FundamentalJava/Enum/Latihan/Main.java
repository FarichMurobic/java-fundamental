package FundamentalJava.Enum.Latihan;

enum Coin {
    HEAD, TAIL
}

class Main {
    public static void main(String[] args) {

        Coin coin = Math.random() > 0.5 ? Coin.HEAD : Coin.TAIL;

        switch (coin) {
            case HEAD:
                System.out.println("Kepala");
                break;
            case TAIL:
                System.out.println("Ekor");
                break;
            default:
                break;
        }
    }
}
