package Annotasi;

/*

Marker annotation adalah annotation khusus yang tidak punya member sama sekali.
Tujuannya hanya untuk menandai sesuatu.
Untuk ngecek apakah annotation ini ada, biasanya pakai:
isAnnotationPresent()

Karena marker annotation tidak punya isi, cukup cek:
ada → lakukan sesuatu
tidak ada → abaikan

Contoh kode (inti)
@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker { }

kosong, gak ada method

KESIMPULAN
Marker annotation = annotation tanpa isi
Dipakai untuk "menandai"

Dicek pakai:
isAnnotationPresent()
Tidak butuh ()
Sangat powerful untuk logic otomatis

*/

import java.lang.annotation.*;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Merker {} // tanpa isi

public class MerkerAnnotation {

    @Merker
    public static void myMeth() {
        MerkerAnnotation ma = new MerkerAnnotation();
        try {
            // Ambil method
            Method method = ma.getClass().getMethod("myMeth");
            // Cek apakah anotasi ada
            if (method.isAnnotationPresent(Merker.class)) 
                System.out.println("Merker is present");

            // Ambil value anotasi
            Merker merker = method.getClass().getAnnotation(Merker.class);
            System.out.println(merker); // null
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        myMeth(); 

    }
}
