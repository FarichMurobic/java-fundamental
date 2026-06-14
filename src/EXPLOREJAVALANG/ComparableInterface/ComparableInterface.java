package ExploreJavaLang.ComparableInterface;


/**
 * The Comparable Interface
 *
 * Object dari class yang mengimplementasikan Comparable dapat diurutkan (ordered).
 *
 * Artinya:
 * Object tersebut bisa dibandingkan dengan cara yang bermakna.
 *
 * Deklarasi
 * interface Comparable<T>
 *
 * Penjelasan:
 * T = tipe object yang dibandingkan
 *
 * Method utama
 * int compareTo(T obj)
 *
 * Penjelasan:
 *
 * Return 0 → sama
 * Return negatif → lebih kecil
 * Return positif → lebih besar
 *
 * Class yang sudah implement Comparable:
 * Byte
 * Character
 * Double
 * Float
 * Long
 * Short
 * String
 * Integer
 * Enum
 *
 * Inti konsep
 * Comparable =
 * cara object menentukan urutan alaminya (natural order)
 *
 * Contoh simpel
 * 5 < 10
 * "A" < "B"
 *
 * Itu natural order
 *
 * Di Java object?
 *
 * Java butuh aturan:
 * compareTo()
 *
 * Analogi
 * Comparable = aturan ranking
 *
 * misal:
 * nilai siswa
 * umur
 * harga
 *
 * PENJELASAN DALAM
 * compareTo RULE
 * this.compareTo(other)
 * Kondisi	        Return
 * sama	            0
 * this < other	    negatif
 * this > other	    positif
 *
 * Cara paling aman
 * Jangan:
 * return this.age - other.age;
 *
 * Lebih aman:
 * return Integer.compare(this.age, other.age);
 * Menghindari overflow
 *
 * Kenapa bisa sort?
 *
 * Karena:
 * Integer implement Comparable
 *
 * PERBEDAAN Comparable vs Comparator
 * Comparable
 * class A implements Comparable<A>
 *
 * logic di dalam class
 *
 * Comparator
 * Comparator<A>
 *
 * logic di luar clas
 *
 * Intinya:
 * Comparable	        Comparator
 * Natural order	    Custom order
 * Dalam class	        Luar class
 *
 * USE CASE DI BACKEND
 * Dipakai di:
 * Sorting data
 * Ranking system
 * Priority queue
 * Database ordering
 *
 * Contoh real:
 * sorting user by age
 * sorting product by price
 * sorting order by date
 *
 * Jangan compare null sembarangan
 *
 * KESIMPULAN
 * Inti:
 * Comparable = menentukan urutan object
 * Method utama: compareTo()
 *
 * Return:
 * 0 → sama
 * negatif → lebih kecil
 * positif → lebih besar
 *
 * Insight penting:
 *
 * Comparable = natural order
 * Dipakai otomatis di:
 *
 * sort
 * TreeSet
 * TreeMap
 */

// Class custom yang implement Comparable
class Student implements Comparable<Student> {
    
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Override dari class Comparable
    @Override
    public int compareTo(Student o) {
        
        // BANDINGKAN BERDASARKAN UMUR
        return this.age - o.age;
    }
}

public class ComparableInterface {
    public static void main(String[] args) {
        
        Student student1 = new Student("JanEra", 20);
        Student student2 = new Student("Farich Murobic", 25);

        // Membandingkan
        int hasil = student1.compareTo(student2); 

        if (hasil < 0) {
            System.out.println("Student 1 lebih muda!");
        } else if (hasil > 0)
            System.out.println("Student 1 lebih tua!");
            else {
                System.out.println("Student 1 dan Student 2 Sama");
            }
    }

    /**
     * OUTPUT
     * 
     * Student 1 lebih muda!
     */

}
