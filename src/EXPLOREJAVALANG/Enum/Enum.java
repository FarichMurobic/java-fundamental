package ExploreJavaLang.Enum;

/**
 * Enum
 *
 * Seperti dijelaskan di sebelumnya, enumeration (enum) adalah daftar konstanta yang memiliki nama.
 * 
 * (Enum dibuat menggunakan keyword enum.)
 * Semua enum di Java secara otomatis mewarisi class Enum.
 *
 * Deklarasi Enum
 * class Enum<E extends Enum<E>>
 *
 * Penjelasan:
 * E = tipe enum itu sendiri (generic)
 * Enum tidak punya constructor public
 *
 * Method pada Enum
 * Enum memiliki beberapa method yang bisa digunakan oleh semua enum (lihat tabel di bawah).
 *
 * ---------------------------------------
 * 
 * Enum itu apa sih sebenarnya?
 *
 * Enum =
 * kumpulan nilai tetap (konstanta)
 *
 * Contoh sederhana
 * enum Status {
 *     ACTIVE,
 *     INACTIVE,
 *     PENDING
 * }
 *
 * Kenapa pakai enum?
 *
 * Dibanding:
 * String status = "ACTIVE";
 *
 * Risky:
 *
 * typo → "ACTVE"
 * tidak aman
 *
 * Pakai enum:
 * Status status = Status.ACTIVE;
 *
 * Aman, type-safe
 *
 * TABEL METHOD ENUM (LENGKAP + PENJELASAN)
 * Method	                        Deskripsi
 * clone()	                        Tidak bisa clone enum (akan error)
 * compareTo(E e)	                Membandingkan berdasarkan urutan
 * equals(Object obj)	            Cek apakah sama
 * getDeclaringClass()	            Ambil class enum
 * hashCode()	                    Hash code
 * name()	                        Nama asli enum
 * ordinal()	                    Posisi enum
 * toString()	                    Nama enum (bisa di-override)
 * valueOf(Class, String)	        Ambil enum dari string
 *
 * -----------------------------------------------------------
 * 
 * PENJELASAN DALAM
 * 1. ordinal() (HATI-HATI)
 * Status.ACTIVE.ordinal() // 0
 *
 * Jangan dipakai untuk logic penting
 *
 * Kenapa?
 * Urutan bisa berubah
 *
 * 2. valueOf()
 * Status s = Status.valueOf("ACTIVE");
 *
 * Convert string ke enum
 *
 * 3. compareTo()
 * Status.ACTIVE.compareTo(Status.INACTIVE);
 *
 * Bandingkan posisi
 *
 * -----------------------------------------------
 * 
 * ENUM LEVEL PRO (REAL BACKEND)
 *
 * Enum bisa punya:
 * field
 * constructor
 * method
 *
 * USE CASE DI BACKEND (REAL BANGET)
 * 
 * 1. Status API
 * enum OrderStatus {
 *     CREATED,
 *     PAID,
 *     SHIPPED,
 *     DELIVERED
 * }
 *
 * 2. Role User
 * enum Role {
 *     ADMIN,
 *     USER
 * }
 *
 * 3. HTTP Method
 * enum HttpMethod {
 *     GET,
 *     POST,
 *     PUT,
 *     DELETE
 * }
 *
 * ---------------------------------------
 * 
 * BEST PRACTICE
 * Jangan:
 * if(status == 1)
 *
 * Gunakan:
 * if(status == Status.ACTIVE)
 *
 * KESIMPULAN
 * Inti:
 * Enum = kumpulan konstanta
 * Type-safe
 * Lebih aman dari string/int
 *
 * Method penting:
 * name()
 * ordinal() hati-hati
 * valueOf()
 * compareTo()
 *
 * Insight backend
 *
 * Enum itu:
 * sangat sering dipakai di:
 *
 * database mapping
 * API response
 * business logic
 */

enum Role {

    ADMIN("Full Access"),
    USER("Limited Access");

    // Field
    private String description;

    // Constructor (private default)
    Role(String description) {
        this.description = description;
    }

    // Method
    public String getDescription() {
        return description;
    }
}

public class Enum {
    public static void main(String[] args) {
        
        Role role = Role.ADMIN;

        System.out.println(role); // ADMIN
        System.out.println(role.getDescription()); // Full Access
    }

}
