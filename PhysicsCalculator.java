import java.util.Scanner;

// Class utama yang berisi metode main
public class PhysicsCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Physics Calculator!");
        System.out.println("Pilih operasi yang ingin dihitung:");
        System.out.println("1. Kecepatan (v = s / t)");
        System.out.println("2. Jarak (s = v * t)");
        System.out.println("3. Waktu (t = s / v)");
        System.out.println("4. Percepatan (a = (v - u) / t)");
        System.out.println("5. Gaya (F = m * a)");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Masukkan jarak (s) dalam meter: ");
                double distance = scanner.nextDouble();
                System.out.print("Masukkan waktu (t) dalam detik: ");
                double time = scanner.nextDouble();
                SpeedCalculator speedCalculator = new SpeedCalculator(distance, time);
                System.out.println("Kecepatan: " + speedCalculator.calculateSpeed() + " m/s");
                break;

            case 2:
                System.out.print("Masukkan kecepatan (v) dalam m/s: ");
                double velocity = scanner.nextDouble();
                System.out.print("Masukkan waktu (t) dalam detik: ");
                time = scanner.nextDouble();
                DistanceCalculator distanceCalculator = new DistanceCalculator(velocity, time);
                System.out.println("Jarak: " + distanceCalculator.calculateDistance() + " meter");
                break;

            case 3:
                System.out.print("Masukkan jarak (s) dalam meter: ");
                distance = scanner.nextDouble();
                System.out.print("Masukkan kecepatan (v) dalam m/s: ");
                velocity = scanner.nextDouble();
                TimeCalculator timeCalculator = new TimeCalculator(distance, velocity);
                System.out.println("Waktu: " + timeCalculator.calculateTime() + " detik");
                break;

            case 4:
                System.out.print("Masukkan kecepatan awal (u) dalam m/s: ");
                double initialVelocity = scanner.nextDouble();
                System.out.print("Masukkan kecepatan akhir (v) dalam m/s: ");
                velocity = scanner.nextDouble();
                System.out.print("Masukkan waktu (t) dalam detik: ");
                time = scanner.nextDouble();
                AccelerationCalculator accelerationCalculator = new AccelerationCalculator(initialVelocity, velocity, time);
                System.out.println("Percepatan: " + accelerationCalculator.calculateAcceleration() + " m/s^2");
                break;

            case 5:
                System.out.print("Masukkan massa (m) dalam kg: ");
                double mass = scanner.nextDouble();
                System.out.print("Masukkan percepatan (a) dalam m/s^2: ");
                double acceleration = scanner.nextDouble();
                ForceCalculator forceCalculator = new ForceCalculator(mass, acceleration);
                System.out.println("Gaya: " + forceCalculator.calculateForce() + " Newton");
                break;

            default:
                System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}

// Class untuk menghitung kecepatan
class SpeedCalculator {
    private double distance;
    private double time;

    public SpeedCalculator(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public double calculateSpeed() {
        return distance / time;
    }
}

// Class untuk menghitung jarak
class DistanceCalculator {
    private double velocity;
    private double time;

    public DistanceCalculator(double velocity, double time) {
        this.velocity = velocity;
        this.time = time;
    }

    public double calculateDistance() {
        return velocity * time;
    }
}

// Class untuk menghitung waktu
class TimeCalculator {
    private double distance;
    private double velocity;

    public TimeCalculator(double distance, double velocity) {
        this.distance = distance;
        this.velocity = velocity;
    }

    public double calculateTime() {
        return distance / velocity;
    }
}

// Class untuk menghitung percepatan
class AccelerationCalculator {
    private double initialVelocity;
    private double velocity;
    private double time;

    public AccelerationCalculator(double initialVelocity, double velocity, double time) {
        this.initialVelocity = initialVelocity;
        this.velocity = velocity;
        this.time = time;
    }

    public double calculateAcceleration() {
        return (velocity - initialVelocity) / time;
    }
}

// Class untuk menghitung gaya
class ForceCalculator {
    private double mass;
    private double acceleration;

    public ForceCalculator(double mass, double acceleration) {
        this.mass = mass;
        this.acceleration = acceleration;
    }

    public double calculateForce() {
        return mass * acceleration;
    }
}