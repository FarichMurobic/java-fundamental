package FundamentalJava.Package.Package1;

public class PackageSamaBukanSubclass {
    PackageSamaBukanSubclass() {

        Protection protection = new Protection();

        System.out.println(protection.defaultVariabel);
        // System.out.println(protection.privateVariabel); // private error
        System.out.println(protection.protectedVariabel);
        System.out.println(protection.publicVariabel);

        protection.methodeDefault();
        // protection.methodePrivate(); // error
        protection.methodeProtected();
        protection.methodePublic();

        /**
         * PACKAGE SAMA BUKAN SUBCLASS
         * DEFAULT BISA
         * PRIVATE TIDAK BISA
         * PROTECTED BISA
         * PUBLIC BISA
         */
    }
}
