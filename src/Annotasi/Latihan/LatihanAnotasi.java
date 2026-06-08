package Annotasi.Latihan;

import java.lang.annotation.*;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Anot {
    String name() default "Farich Murobic";
    int val() default 22;
}

@Retention(RetentionPolicy.RUNTIME)
@interface Annot1 {
    String value();
}

@Annot1("Anotasi di kelas")
public class LatihanAnotasi {

    @Annot1("Anotasi di method")
    public void demo() throws Exception {

        // BAUT OBJEK
        LatihanAnotasi latihan = new LatihanAnotasi();
        
        // Value anotasi di kelas
        Annot1 ano = latihan.getClass().getAnnotation(Annot1.class);
        System.out.println(ano.value());

        // Cek anotasi di kelas
        Class clas = this.getClass();
        if (clas.isAnnotationPresent(Annot1.class)) {
            System.out.println(clas.getAnnotation(Annot1.class));
        }

        // Cek anotasi di method
        Method method = this.getClass().getMethod("demo");
        if (method.isAnnotationPresent(Annot1.class)) {
            System.out.println("Anotasi ada");
        }

        // Value anotasi di method
        Annot1 annot1 = method.getAnnotation(Annot1.class);
        System.out.println(annot1.value());

        // Cetak semua anotasi (method)
        Annotation[] annotations = method.getDeclaredAnnotations();
        for (Annotation x : annotations) {
            System.out.println(x);
        }
    }

    @Anot()
    public static void myMethod() {

        LatihanAnotasi lAnotasi = new LatihanAnotasi();

        try {
            Class<?> c = lAnotasi.getClass();
            Method method = c.getMethod("myMethod");
            Anot anot = method.getAnnotation(Anot.class);
            System.out.println(anot.name() + " " + anot.val());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        
        new LatihanAnotasi().demo();
        System.out.println();
        myMethod();
    }
}
