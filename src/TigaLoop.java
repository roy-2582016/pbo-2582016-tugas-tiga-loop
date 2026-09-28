import java.util.Scanner;

public class TigaLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Batas deret (n) : ");
        int n = input.nextInt();

        System.out.println();
        System.out.println("===== SATU DERET, TIGA LOOP =====");

        // 1) Versi for (variabel pencacah: a)
        System.out.print("for      :");
        for (int a = 1; a <= n; a++) {
            System.out.print(" " + a);
        }
        System.out.println();

        // 2) Versi while (variabel pencacah: b)
        System.out.print("while    :");
        int b = 1;
        while (b <= n) {
            System.out.print(" " + b);
            b++;
        }
        System.out.println();

        // 3) Versi do-while (variabel pencacah: c)
        System.out.print("do-while :");
        int c = 1;
        do {
            System.out.print(" " + c);
            c++;
        } while (c <= n);
        System.out.println();
        // 4) Bukti off-by-one dengan dua penghitung terpisah
        System.out.println();
        int kurang = 0;
        for (int i = 1; i < n; i++) {
            kurang++;
        }
        int kurangSama = 0;
        for (int i = 1; i <= n; i++) {
            kurangSama++;
        }
        System.out.println("i <  n berputar : " + kurang + " kali");
        System.out.println("i <= n berputar : " + kurangSama + " kali");

        // 5) Saring deret 1-10 dengan continue dan break (angka tetap 1-10, tidak ikut n)
        int hitung = 0;
        System.out.print("Disaring :");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;   // angka genap dilewati
            }
            if (i > 7) {
                break;      // berhenti kalau i lebih dari 7
            }
            System.out.print(" " + i);
            hitung++;
        }
        System.out.println();
        System.out.println("Sampai println  : " + hitung + " kali");
    }
}

/*
 * ===== HASIL RUN 1 (n = 5) =====
 * Batas deret (n) : 5
 *
 * ===== SATU DERET, TIGA LOOP =====
 * for      : 1 2 3 4 5
 * while    : 1 2 3 4 5
 * do-while : 1 2 3 4 5
 *
 * i <  n berputar : 4 kali
 * i <= n berputar : 5 kali
 * Disaring : 1 3 5 7
 * Sampai println  : 4 kali
 *
 * ===== HASIL RUN 2 (n = 0) =====
 * Batas deret (n) : 0
 *
 * ===== SATU DERET, TIGA LOOP =====
 * for      :
 * while    :
 * do-while : 1
 *
 * i <  n berputar : 0 kali
 * i <= n berputar : 0 kali
 * Disaring : 1 3 5 7
 * Sampai println  : 4 kali
 *
 * KESIMPULAN: do-while mengecek kondisi SESUDAH badan loop dijalankan,
 * jadi badannya pasti jalan minimal sekali.
 * (Karena itu untuk n = 0, for dan while kosong, tetapi do-while tetap mencetak 1.)
 *
 * KENAPA LOOP TIDAK BERHENTI DI i = 8 PADAHAL 8 > 7?
 * Di dalam badan loop, urutan pengecekannya: continue (genap) dulu, baru break (i > 7).
 * Saat i = 8, angka itu genap sehingga continue langsung dijalankan dan loncat ke
 * iterasi berikutnya, sebelum sempat sampai ke baris break. Jadi break tidak pernah
 * dicek untuk i = 8. Baru saat i = 9 (ganjil, lolos continue) kondisi i > 7 terpenuhi
 * dan break jalan. Karena itu println hanya tercapai untuk 1, 3, 5, 7 = 4 kali.
 */