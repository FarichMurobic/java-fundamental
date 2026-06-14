package FundamentalJava.Interface;

// CLASS ini "tanda tangan kontrak"
public class Client implements Callback {

    // IMPLEMENT DARI INTERFACE CALLBACK
    @Override
    public void callback(int param) {
        // wajib implementasi method dari interface
        System.out.println("Dipanggil dengan nilai: " + param); // implementasi
        // HARUS ada method ini (kalau gak → error)
        // implementasi bebas        
    }
}
