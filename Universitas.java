import java.util.Scanner;

// Program ini mengelola informasi mahasiswa di sebuah universitas.
// Program ini menunjukkan penggunaan class, object, constructor, method overloading, method overriding, setter dan getter.

public class Universitas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta masukan dari pengguna untuk membuat objek Mahasiswa
        System.out.println("Masukkan nama mahasiswa:");
        String nama = scanner.nextLine();
        System.out.println("Masukkan usia mahasiswa:");
        int usia = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer
        System.out.println("Masukkan jurusan mahasiswa:");
        String jurusan = scanner.nextLine();

        // Membuat objek Mahasiswa dengan constructor yang berbeda
        Mahasiswa mahasiswa1 = new Mahasiswa(nama, usia, jurusan);
        Mahasiswa mahasiswa2 = new Mahasiswa(nama, usia);

        // Menampilkan informasi mahasiswa
        mahasiswa1.displayInfo();
        mahasiswa2.displayInfo();

        // Menggunakan setter untuk mengubah jurusan mahasiswa
        System.out.println("Masukkan jurusan baru untuk mahasiswa kedua:");
        String jurusanBaru = scanner.nextLine();
        mahasiswa2.setJurusan(jurusanBaru);
        System.out.println("Jurusan baru untuk mahasiswa kedua: " + mahasiswa2.getJurusan());

        // Membuat objek MahasiswaInternasional, subclass dari Mahasiswa
        System.out.println("Masukkan negara asal mahasiswa internasional:");
        String negaraAsal = scanner.nextLine();
        MahasiswaInternasional mahasiswaInternasional1 = new MahasiswaInternasional(nama, usia, jurusan, negaraAsal);
        mahasiswaInternasional1.displayInfo();

        scanner.close();
    }
}

// Kelas Mahasiswa yang memiliki atribut nama, usia, dan jurusan
class Mahasiswa {
    private String nama;
    private int usia;
    private String jurusan;

    // Constructor dengan tiga parameter
    public Mahasiswa(String nama, int usia, String jurusan) {
        this.nama = nama;
        this.usia = usia;
        this.jurusan = jurusan;
    }

    // Constructor dengan dua parameter (overloading)
    public Mahasiswa(String nama, int usia) {
        this.nama = nama;
        this.usia = usia;
        this.jurusan = "Belum Ditentukan";
    }

    // Method untuk menampilkan informasi mahasiswa
    public void displayInfo() {
        System.out.println("Nama: " + nama + ", Usia: " + usia + ", Jurusan: " + jurusan);
    }

    // Getter dan Setter untuk atribut jurusan
    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}

// Subclass dari Mahasiswa yang menambahkan atribut negaraAsal
class MahasiswaInternasional extends Mahasiswa {
    private String negaraAsal;

    // Constructor untuk MahasiswaInternasional yang memanggil constructor dari superclass (Mahasiswa)
    public MahasiswaInternasional(String nama, int usia, String jurusan, String negaraAsal) {
        super(nama, usia, jurusan);
        this.negaraAsal = negaraAsal;
    }

    // Overriding method displayInfo untuk menambahkan informasi negara asal
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Negara Asal: " + negaraAsal);
    }
}
