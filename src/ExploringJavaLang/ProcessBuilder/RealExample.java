package ExploringJavaLang.ProcessBuilder;

import java.io.File;

public class RealExample {
    public static void main(String[] args) {

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "dir");
            processBuilder.redirectOutput(new File("output.txt"));
            processBuilder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * Gabung error + output
         * pb.redirectErrorStream(true);
         *
         * biar error masuk ke output stream
         *
         * Set working directory
         * pb.directory(new File("C:/"));
         *
         * jalan di folder tertentu
         *
         * Insight Penting (REAL WORLD)
         * Ini dipakai di:
         * automation script
         * CI/CD
         * Docker integration
         * running shell command dari backend
         * microservices orchestration
         *
         * Kesalahan umum
         * lupa handle output → bisa nge-hang
         * salah command OS
         * gak set working directory
         *
         * Best Practice
         * pakai ProcessBuilder daripada Runtime.exec()
         * selalu handle stream
         * gunakan environment config
         */
    }
}
