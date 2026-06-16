package ExploringJavaUtil;

/**
 * java.util Bagian 1 — Collections Framework
 *
 * Bab ini memulai pembahasan kita tentang package java.util.
 * Package penting ini berisi banyak sekali class dan interface yang mendukung berbagai macam fungsi.
 *
 * Sebagai contoh, java.util memiliki class untuk:
 * Membuat angka acak (pseudorandom)
 * Mengelola tanggal dan waktu
 * Mengamati event
 * Mengelola kumpulan bit
 * Memecah string (tokenizing)
 * Mengolah data dengan format tertentu
 *
 * Package java.util juga memiliki salah satu subsistem paling kuat di Java:
 * Collections Framework
 *
 * Collections Framework adalah struktur hierarki kompleks dari interface dan class yang menyediakan teknologi
 * modern untuk mengelola kumpulan objek.
 *
 * Semua programmer wajib memahami ini dengan serius.
 *
 * Karena java.util sangat besar, berikut adalah daftar class utamanya:
 * Class-Class di java.util
 * Class	                                            Penjelasan
 * AbstractCollection	                                Kelas dasar untuk collection
 * AbstractList	                                        Dasar untuk List
 * AbstractMap	                                        Dasar untuk Map
 * AbstractQueue	                                    Dasar untuk Queue
 * AbstractSequentialList	                            List berbasis akses berurutan
 * AbstractSet	                                        Dasar untuk Set
 * ArrayDeque	                                        Implementasi deque berbasis array
 * ArrayList	                                        List berbasis array (paling sering dipakai)
 * Arrays	                                            Utility untuk array
 * Base64 (JDK 8)	                                    Encoding/decoding Base64
 * BitSet	                                            Manipulasi bit
 * Calendar	                                            Manipulasi tanggal
 * Collections	                                        Utility untuk collection
 * Currency	                                            Mata uang
 * Date	                                                Tanggal (lama, sebagian deprecated) 
 * Dictionary	                                        Class lama deprecated
 * DoubleSummaryStatistics (JDK 8)	                    Statistik angka double
 * EnumMap	                                            Map khusus enum
 * EnumSet	                                            Set khusus enum
 * EventListenerProxy	                                Proxy event listener
 * EventObject	                                        Representasi event
 * FormattableFlags	                                    Flag formatting
 * Formatter	                                        Format string
 * GregorianCalendar	                                Calendar modern
 * HashMap	                                            Map berbasis hash (sangat populer)
 * HashSet	                                            Set berbasis hash
 * Hashtable	                                        Versi lama dari HashMap 
 * IdentityHashMap	                                    Map berdasarkan reference
 * IntSummaryStatistics (JDK 8)	                        Statistik integer
 * LinkedHashMap	                                    Map dengan urutan
 * LinkedHashSet	                                    Set dengan urutan
 * LinkedList	                                        List berbasis linked list
 * ListResourceBundle	                                Resource bundle
 * Locale	                                            Lokasi / bahasa
 * LongSummaryStatistics (JDK 8)	                    Statistik long
 * Objects	                                            Utility object
 * Optional (JDK 8)	                                    Wrapper nilai nullable
 * OptionalDouble (JDK 8)	                            Optional double
 * OptionalInt (JDK 8)	                                Optional int
 * OptionalLong (JDK 8)	                                Optional long
 * PriorityQueue	                                    Queue prioritas
 * Properties	                                        Konfigurasi
 * PropertyPermission	                                Permission
 * PropertyResourceBundle	                            Resource
 * Random	                                            Random number
 * ResourceBundle	                                    Resource
 * Scanner	                                            Input parsing
 * ServiceLoader	                                    Load service
 * SimpleTimeZone	                                    Time zone
 * Spliterators (JDK 8)	                                Iterator khusus
 * SplittableRandom (JDK 8)	                            Random lebih efisien
 * Stack	                                            Stack (LIFO)
 * StringJoiner (JDK 8)	                                Gabung string
 * StringTokenizer	                                    Token string jarang dipakai
 * Timer	                                            Timer task
 * TimerTask	                                        Task untuk timer
 * TimeZone	                                            Zona waktu
 * TreeMap	                                            Map terurut
 * TreeSet	                                            Set terurut
 * UUID	                                                Unique ID
 * Vector	                                            List lama deprecated style
 * WeakHashMap	                                        Map dengan GC
 *
 *
 * Interface di java.util
 * Interface	                                        Penjelasan
 * Collection	                                        Interface utama collection
 * Comparator	                                        Membandingkan object
 * Deque	                                            Double-ended queue
 * Enumeration	                                        Iterator lama 
 * EventListener	                                    Listener event
 * Formattable	                                        Format custom
 * Iterator	                                            Traversal collection
 * List	                                                Collection berurutan
 * ListIterator	                                        Iterator khusus List
 * Map	                                                Key-value
 * Map.Entry	                                        Entry dalam Map
 * NavigableMap	                                        Map dengan navigasi
 * NavigableSet	                                        Set navigasi
 * Observer	                                            Observer pattern deprecated
 * PrimitiveIterator (JDK 8)	                        Iterator primitive
 * Queue	                                            Antrian
 * RandomAccess	                                        Marker untuk akses cepat
 * Set	Collection                                      tanpa duplikat
 * SortedMap	                                        Map terurut
 * SortedSet	                                        Set terurut
 * Spliterator (JDK 8)	                                Iterator untuk parallel
 * Spliterator.OfDouble	                                Versi double
 * Spliterator.OfInt	                                Versi int
 * Spliterator.OfLong	                                Versi long
 * Spliterator.OfPrimitive	                            Versi generic primitive
 *
 * Terakhir:
 * Karena java.util sangat besar, pembahasannya dibagi jadi 2:
 *
 * Bab ini → fokus ke Collections Framework
 * Bab berikutnya → class lain di java.util
 *
 * Inti Besarnya Apa?
 *
 * Bayangin lo bikin backend:
 *
 * Lo pasti butuh:
 *
 * nyimpen data user
 * nyimpen list produk
 * nyimpen transaksi
 *
 * Nah semua itu = kumpulan object
 *
 * Dan di sinilah:
 * Collections Framework masuk
 *
 * Collections Framework = Alat Ngatur Data
 *
 * Ini ibarat:
 *
 * ArrayList → kayak rak
 * HashMap → kayak kamus (key-value)
 * Set → kumpulan tanpa duplikat
 *
 * Kenapa Penting Banget?
 *
 * Karena di backend:
 * 80% kerjaan = ngolah data
 * bukan UI
 * bukan design
 *
 * Struktur Besarnya
 * Collection (root)
 *  ├── List (berurutan, boleh duplikat)
 *  │    ├── ArrayList
 *  │    ├── LinkedList
 *  │
 *  ├── Set (unik, no duplikat)
 *  │    ├── HashSet
 *  │    ├── TreeSet
 *  │
 *  └── Queue (antrian)
 *       ├── PriorityQueue
 *
 * Dan:
 *
 * Map (beda jalur)
 *  ├── HashMap
 *  ├── TreeMap
 *
 *  Class Lama (Wajib Lo Tau)
 *
 * Beberapa class di list tadi:
 *
 * Class	    Status
 * Vector	    deprecated style
 * Hashtable	legacy
 * Dictionary	deprecated
 * Observer	    deprecated
 *
 * Artinya:
 * Jangan dipakai di project modern
 *
 * ------------------------------------------------------------
 * 
 * Insight Penting
 * Java itu gak nyuruh lo bikin struktur data dari nol
 *
 * Dia bilang:
 * “Nih gue kasih tools lengkap, tinggal lo pake dengan benar”
 *
 * KESIMPULAN (VERSI SANTAI)
 * Yang Harus Lo Tangkep
 * java.util = package super penting
 * Isinya = tools untuk:
 * data
 * waktu
 * random
 * dll
 *
 * Yang PALING PENTING
 * Collections Framework
 *
 * Ini:
 * alat utama backend
 * wajib dikuasai
 *
 * Mindset yang Harus Lo Pegang
 *
 * Jangan mikir:
 * “Ini class banyak banget”
 *
 * Tapi:
 * “Ini toolbox, gue pake sesuai kebutuhan”
 */

/**
 * Collections Overview
 *
 * Java Collections Framework menstandarkan cara program menangani kumpulan objek.
 * Collections tidak ada di versi awal Java, tapi ditambahkan di:
 * J2SE 1.2
 *
 * Sebelum Ada Collections Framework
 *
 * Java punya class seperti:
 * Dictionary
 * Vector
 * Stack
 * Properties
 *
 * Masalahnya:
 * Cara pakainya beda-beda
 * Tidak punya konsep yang menyatukan
 * Sulit dikembangkan (extend/adapt)
 *
 * Contoh:
 * Cara pakai Vector ≠ cara pakai Properties
 *
 * Collections Framework = Solusi
 * Collections dibuat untuk menyelesaikan masalah itu.
 *
 * Tujuan Collections Framework
 * 1. High Performance
 * Struktur data seperti:
 * dynamic array
 * linked list
 * tree
 * hash table
 * sudah dibuat sangat efisien
 *
 * Jadi lo gak perlu bikin dari nol
 *
 * 2. Konsistensi (Interoperability)
 * Semua collection punya cara pakai yang mirip
 * Bisa saling bekerja sama
 *
 * 3. Mudah Dikembangkan
 * Dibangun dari interface standar
 * Ada implementasi siap pakai:
 * LinkedList
 * HashSet
 * TreeSet
 *
 * Lo juga bisa bikin collection sendiri
 *
 * 4. Integrasi dengan Array
 * Array bisa masuk ke dalam sistem collection
 *
 * Algorithms dalam Collections
 * Collections punya algoritma bawaan
 *
 * Disimpan di class:
 * Collections
 *
 * Bentuknya:
 * method static
 *
 * Contoh:
 * sorting
 * searching
 * reversing
 *
 * Jadi:
 * Setiap class gak perlu bikin algoritma sendiri
 *
 * Iterator
 * Iterator = cara standar untuk ambil data satu per satu dari collection
 *
 * Fungsi:
 * akses elemen
 * looping
 * enumerasi isi collection
 *
 * Kelebihan Iterator
 *
 * Kode ini:
 * bisa dipakai di Set
 * bisa dipakai di List
 *
 * karena pakai standar yang sama
 *
 * Spliterator (JDK 8)
 * Iterator versi modern:
 * support parallel processing
 *
 * Interface:
 * Spliterator
 * Spliterator.OfInt
 * dll
 *
 * Primitive Iterator (JDK 8)
 * Iterator khusus tipe primitive:
 * PrimitiveIterator
 * PrimitiveIterator.OfDouble
 *
 * Lebih efisien (hindari boxing/unboxing)
 *
 * Map dalam Collections
 * Map:
 * menyimpan key-value
 *
 * Contoh:
 * nama -> Farich
 * umur -> 20
 *
 * Penting:
 * Map bukan collection murni
 * Tapi tetap bagian dari framework
 *
 * Bisa diubah jadi "collection view"
 *
 * Integrasi Class Lama
 *
 * Class lama seperti:
 * Vector
 * Hashtable
 *
 * diadaptasi supaya masuk ke sistem baru
 *
 * Tapi:
 * tidak di-deprecate
 * hanya kalah modern
 *
 * Inti Besarnya
 *
 * Dulu Java itu:
 * “punya banyak alat, tapi gak ada sistem”
 *
 * Sekarang:
 * “punya sistem terpadu buat ngatur data”
 *
 * Analogi Dunia Nyata
 *
 * Bayangin:
 *
 * Dulu:
 * Rak buku beda-beda
 * Cara ambil buku beda-beda
 * Ribet
 *
 * Sekarang:
 * Semua rak pakai sistem yang sama
 * Cara ambil = sama
 *
 * Ini Collections Framework
 *
 * 3 Pilar Utama
 * 1. Interface
 *
 * blueprint
 *
 * Contoh:
 * List
 * Set
 * Map
 *
 * 2. Implementation
 *
 * class nyata
 *
 * Contoh:
 * ArrayList
 * HashSet
 * HashMap
 * 3. Algorithms
 *
 * logic siap pakai
 *
 * Contoh:
 * sorting
 * searching
 *
 * Iterator = Kunci Fleksibilitas
 *
 * Tanpa iterator:
 * tiap collection beda cara looping
 *
 * Dengan iterator:
 * semua jadi satu cara
 *
 * Insight Penting (Level Backend)
 *
 * Di backend:
 * Ambil data DB → jadi List
 * Filter → pakai algorithm
 * Loop → pakai iterator
 *
 * Semua pakai konsep ini
 *
 * ---------------------------------------
 * 
 * KESIMPULAN (VERSI SIMPLE)
 *
 * 1. Collections Framework = sistem ngatur data
 * bukan cuma class random
 *
 * 2. Tujuannya:
 * Cepat 
 * Konsisten 
 * Mudah dikembangkan 
 *
 * 3. Komponen penting:
 * Interface → aturan
 * Class → implementasi
 * Algorithm → logic siap pakai
 *
 * 4. Iterator = standar akses data
 * penting banget buat backend
 *
 * 5. Map:
 * key-value
 * bukan collection murni
 * tapi tetap penting banget
 */

/**
 * JDK 5 Mengubah Collections Framework
 *
 * Saat JDK 5 dirilis, ada perubahan besar pada Collections Framework yang membuatnya jauh lebih kuat dan mudah digunakan.
 *
 * Perubahan itu meliputi:
 * Generics
 * Autoboxing / Unboxing
 * For-each loop
 *
 * Walaupun sekarang sudah ada JDK 8 (dan lebih baru), perubahan dari JDK 5 ini sangat penting dan masih relevan sampai sekarang.
 *
 * Kenapa?
 * Karena lo bisa ketemu kode lama (pre-JDK 5)
 *
 * Generics Mengubah Collections Secara Fundamental
 *
 * Generics membuat perubahan besar karena:
 * seluruh Collections Framework diubah untuk mendukung generics
 *
 * Sekarang:
 * Semua collection = generic
 * Banyak method pakai parameter tipe
 *
 * Sebelum Generics
 *
 * Semua collection menyimpan:
 *
 * Object
 *
 * Artinya:
 * Bisa masukin apa saja
 * Bahaya 
 *
 * Contoh masalah:
 * Masukin String
 * Tapi diambil sebagai Integer
 *
 * ERROR saat runtime
 *
 * Setelah Generics
 * Lo bisa tentuin tipe data:
 *
 * ArrayList<String>
 *
 * Jadi:
 * Lebih aman
 * Error dicegah sejak compile time
 *
 * Penting
 * Walaupun berubah:
 * Cara kerja collection tetap sama
 * Tapi deklarasinya berubah
 *
 * Kode Lama
 *
 * Kalau lo pakai kode lama:
 * Akan muncul warning
 * Harus ditambah type (generics)
 *
 * Autoboxing / Unboxing
 * Collection tidak bisa menyimpan primitive
 *
 * hanya bisa:
 * Object (reference)
 *
 * Dulu (Manual)
 * int → Integer (manual)
 * Integer → int (cast manual)
 *
 * Sekarang (Auto)
 *
 * Java otomatis:
 * boxing
 * unboxing
 *
 * For-Each Loop
 * Semua collection sekarang implement:
 * Iterable
 *
 * artinya bisa pakai:
 * for (String data : list)
 *
 * Dulu
 *
 * Harus pakai:
 * Iterator
 * loop manual
 * Sekarang
 *
 * Lebih simple:
 * for-each loop
 *
 * Tapi:
 * Iterator masih dipakai untuk kasus tertentu
 *
 * Generics = TYPE SAFETY
 * Masalah Besar Dulu
 *
 * Java itu terlalu fleksibel:
 * “Semua boleh masuk”
 *
 * Tapi itu bahaya
 *
 * Contoh Masalah Nyata
 * ArrayList list = new ArrayList();
 * list.add("Farich");
 * list.add(123);
 *
 * Campur aduk 
 *
 * Error muncul saat runtime
 * ini yang paling bahaya di backend
 *
 * Solusi Generics
 * ArrayList<String>
 *
 * Java bilang:
 * “Cuma String yang boleh masuk”
 *
 * Insight
 *
 * Generics itu:
 * bukan cuma fitur, tapi pelindung error
 *
 * Autoboxing = Kemudahan
 * Masalah Dulu
 *
 * Collection gak bisa simpan:
 * int
 * double
 *
 * Ribet banget
 * Integer obj = Integer.valueOf(10);
 * int x = obj.intValue();
 *
 * Sekarang otomatis
 * list.add(10); // otomatis jadi Integer
 * int x = list.get(0); // otomatis balik ke int
 *
 * Insight
 * Autoboxing:
 * bikin kode lebih clean + readable
 *
 * For-Each Loop = Simpel
 * Dulu
 * Iterator it = list.iterator();
 * while(it.hasNext()) {
 *     System.out.println(it.next());
 * }
 *
 * Sekarang
 * for(String s : list)
 *
 * Insight
 * For-each:
 * 80% kasus cukup ini
 *
 * KESIMPULAN (VERSI SIMPLE)
 * 3 Hal Besar dari JDK 5
 * 1. Generics
 *
 * bikin collection:
 *
 * aman
 * gak gampang error
 * 2. Autoboxing
 *
 * primitive jadi gampang dipakai di collection
 *
 * 3. For-each
 * looping jadi simpel
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class JavaUtil {
    public static void main(String[] args) {

        // Membuat list untuk menyimpan data nama
        ArrayList<String> arrayList = new ArrayList<>();

        // Menambahkan data ke dalam list
        arrayList.add("Farich");
        arrayList.add("Janera");
        arrayList.add("JM Janera");

        System.out.println("Isi list:");

        // Loop semua data
        for (String x : arrayList) {
            System.out.println(x);
        }

        /**
         * Penjelasan:
         * ArrayList = implementasi dari List
         * add() = nambah data
         * for-each = ambil data
         */

        System.out.println();

        // Iterator Example
        // Membuat ArrayList untuk menyimpan data
        ArrayList<String> namaList = new ArrayList<>();

        // Menambahkan data
        namaList.add("Janera");
        namaList.add("Farich Murobic");
        namaList.add("Jm Janera");

        // Membuat iterator dari list
        Iterator<String> iterator = namaList.iterator();

        // Loop menggunakan iterator
        while (iterator.hasNext()) {
            // Mengambil elemen satu per satu
            String nama = iterator.next();
            // Menampilkan data
            System.out.println(nama);
        }

        System.out.println();

        // Algorithms Example
        // Membuat list
        ArrayList<Integer> angka = new ArrayList<>();

        // Menambahkan data
        angka.add(30);
        angka.add(20);
        angka.add(10);

        // Sorting menggunakan Collections
        Collections.sort(angka);

        System.out.println(angka);
    
    }
}
