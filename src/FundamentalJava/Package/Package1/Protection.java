package FundamentalJava.Package.Package1;

public class Protection {

    int defaultVariabel = 10; // default
    private int privateVariabel = 20; // private
    protected int protectedVariabel = 30; // protected
    public int publicVariabel = 40; // public

    public Protection() { // konstraktor public.
        System.out.println("Akses dikelas yang sama.");
        System.out.println("Default: " + defaultVariabel);
        System.out.println("Private: " + privateVariabel);
        System.out.println("Protected: " + protectedVariabel);
        System.out.println("Public: " + publicVariabel);

        System.out.println();

        methodeDefault();
        methodePrivate();
        methodeProtected();
        methodePublic();
    }

    // methode default
    void methodeDefault() {
        System.out.println("Methode default");
    }

    // methode private
    private void methodePrivate() {
        System.out.println("Methode private");
    }

    // methode protected
    protected void methodeProtected() {
        System.out.println("Methode protected");
    }

    // methode public
    public void methodePublic() {
        System.out.println("Methode public");
    }

}
