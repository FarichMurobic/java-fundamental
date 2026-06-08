package Array;

/*

Array di Java sebenarnya adalah object

Karena itu, array punya atribut khusus yang sangat berguna.
Atribut tersebut adalah:
length

length adalah instance variable yang menyimpan ukuran array (jumlah elemen yang bisa ditampung).
Semua array memiliki variable ini, dan nilainya selalu menunjukkan ukuran array.

Penjelasan Penting
Nilai length:
TIDAK menunjukkan jumlah elemen yang sedang digunakan
HANYA menunjukkan kapasitas array

Array adalah Object
Ini penting banget 
array = object

Artinya:
array punya property
salah satunya .length

Apa itu .length?
.length = jumlah kapasitas array
Contoh:
int a[] = new int[5];
Maka:
a.length = 5

Perbedaan Kapasitas vs Isi
Misalnya:
int a[] = new int[5];
a[0] = 10;
a[1] = 20;
Isi:
[10, 20, 0, 0, 0]

Tapi:
a.length = 5
bukan 2, tapi tetap 5

------------------------------------------------------

Istilah Penting
Array
Struktur data untuk menyimpan banyak nilai dalam satu variabel
length
Property dari array yang menunjukkan ukuran array
Overflow
Kondisi ketika data melebihi kapasitas
Underflow
Kondisi ketika mengambil data dari struktur kosong

*/

public class ArrayLength {
    public static void main(String[] args) {
        
        int number[] = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(number.length);

        // Tampilkan nilai array pake for biasa
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i]);
        }

        System.out.println();

        // Tampilkan nilai array pake for each
        // For each gak perlu pake .length
        for (int i : number) { 
            System.out.print(i);
        }
    }
}
