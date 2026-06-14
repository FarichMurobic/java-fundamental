package ExploringJavaLang.SubPackageJavaLang;

/**
 * The java.lang Subpackages
 *
 * Java memiliki beberapa subpackage di dalam java.lang:
 *
 * java.lang.annotation
 * java.lang.instrument
 * java.lang.invoke
 * java.lang.management
 * java.lang.ref
 * java.lang.reflect
 *
 * Setiap subpackage ini punya fungsi khusus.
 *
 * 1. java.lang.annotation
 * Digunakan untuk mendukung fitur annotation di Java.
 *
 * Inti:
 * Annotation = metadata pada kode
 *
 * Contoh:
 * @Override
 * public String toString() {
 *     return "Hello";
 * }
 *
 * Isi penting:
 * Annotation interface
 * ElementType
 * RetentionPolicy
 *
 * Use case backend:
 * Spring Boot (@RestController, @Service)
 * Validation (@NotNull)
 *
 * Insight:
 * Ini fondasi framework modern
 *
 * 2. java.lang.instrument
 * Digunakan untuk menambahkan instrumentasi ke program saat runtime
 *
 * Inti:
 * Bisa “menyusup” ke program
 *
 * Use case:
 * profiling
 * monitoring
 * APM tools (New Relic, dll)
 *
 * Catatan:
 * Jarang dipakai langsung oleh developer biasa
 *
 * 3. java.lang.invoke
 * Mendukung dynamic language dan method invocation yang fleksibel
 *
 * Inti:
 * Alternatif lebih cepat dari reflection
 *
 * Class penting:
 * MethodHandle
 * CallSite
 * MethodType
 *
 * Use case:
 * JVM internals
 * Lambda expression
 * Functional programming
 *
 * 4. java.lang.management
 * Digunakan untuk monitoring dan manajemen JVM
 *
 * Inti:
 * Melihat kondisi aplikasi
 *
 * Bisa monitor:
 * memory
 * thread
 * CPU
 * GC
 *
 * Contoh:
 * import java.lang.management.ManagementFactory;
 * import java.lang.management.MemoryMXBean;
 *
 * public class ManagementExample {
 *     public static void main(String[] args) {
 *         MemoryMXBean memory = ManagementFactory.getMemoryMXBean();
 *         System.out.println(memory.getHeapMemoryUsage());
 *     }
 * }
 *
 * Use case backend:
 * monitoring server
 * observability
 *
 * 5. java.lang.ref
 * Memberikan kontrol lebih fleksibel terhadap garbage collection
 *
 * Inti:
 *
 * Reference level:
 *
 * Strong reference
 * Soft reference
 * Weak reference
 * Phantom reference
 *
 * Use case:
 * caching system
 * memory-sensitive apps
 *
 * Catatan:
 * Advanced banget
 *
 * 6. java.lang.reflect
 * Reflection = kemampuan program untuk menganalisis dirinya sendiri saat runtime
 * Inti:
 *
 * Bisa:
 *
 * lihat field
 * method
 * constructor
 * annotation
 *
 * Contoh:
 * import java.lang.reflect.Method;
 *
 * public class ReflectionExample {
 *
 *     public static void main(String[] args) {
 *
 *         Class<?> cls = String.class;
 *
 *         Method[] methods = cls.getMethods();
 *
 *         for (Method m : methods) {
 *             System.out.println(m.getName());
 *         }
 *     }
 * }
 *
 * Class penting:
 * Method
 * Field
 * Constructor
 *
 * Use case backend:
 * Spring Boot
 * Hibernate
 * Dependency Injection
 *
 * RINGKASAN SUPER PADAT
 * Package	                        Fungsi
 * annotation	                    metadata
 * instrument	                    monitoring runtime
 * invoke	                        dynamic call
 * management	                    monitor JVM
 * ref	                            kontrol GC
 * reflect	                        introspection runtime
 *
 * Ini semua dipakai di:
 * Spring Boot
 * Hibernate
 * Logging system
 * Monitoring tools
 *
 * Tapi:
 * Lo jarang pakai langsung
 * Tapi harus ngerti konsepnya
 *
 * PRIORITAS BELAJAR (JUJUR BRO)
 * WAJIB BANGET:
 * annotation 
 * reflect 
 *
 * MENENGAH:
 * management
 *
 * ADVANCED:
 * invoke
 * instrument
 * ref
 *
 * KESIMPULAN
 * Inti:
 * java.lang punya banyak subpackage powerful
 * Digunakan untuk:
 * metadata
 * monitoring
 * runtime analysis
 *
 * Insight penting:
 * Ini adalah pondasi framework Java modern
 * Kalau lo ngerti ini → lo ngerti cara kerja Spring
 */

public class SubPackageJavaLang {

}
