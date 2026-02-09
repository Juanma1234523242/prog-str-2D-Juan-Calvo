import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeService gradeCalculator = new GradeService();

        // Entrada de datos
        String studentName = ImputDataValidator.readNonEmptyText(
                scanner, "Introduce el nombre del alumno: ");

        double firstGrade = ImputDataValidator.readDoubleInRange(
                scanner, "Ingrese la primera calificación", 0, 100);
        double secondGrade = ImputDataValidator.readDoubleInRange(
                scanner, "Ingrese la segunda calificación", 0, 100);
        double thirdGrade = ImputDataValidator.readDoubleInRange(
                scanner, "Ingrese la tercera calificación", 0, 100);

        int attendancePercentage = ImputDataValidator.readIntInRange(
                scanner, "Ingrese el total de asistencias", 0, 100);

        boolean projectSubmitted = ImputDataValidator.readBoolean(
                scanner, "¿Entregó el proyecto? (true/false): ");

        // Proceso
        double averageGrade = gradeCalculator.calculateAverage(
                firstGrade, secondGrade, thirdGrade);
        double finalGrade = gradeCalculator.calculateFinalGrade(
                averageGrade, attendancePercentage);
        String studentStatus = gradeCalculator.determineStudentStatus(
                finalGrade, attendancePercentage, projectSubmitted);

        printGradeReport(
                studentName,
                firstGrade,
                secondGrade,
                thirdGrade,
                averageGrade,
                attendancePercentage,
                projectSubmitted,
                finalGrade,
                studentStatus
        );

        scanner.close();
    }

    public static void printGradeReport(
            String studentName,
            double firstGrade,
            double secondGrade,
            double thirdGrade,
            double averageGrade,
            int attendancePercentage,
            boolean projectSubmitted,
            double finalGrade,
            String studentStatus) {

        System.out.println("\n=== REPORTE DE CALIFICACIONES ===");
        System.out.println("Nombre: " + studentName);
        System.out.println("Parciales: " +
                String.format("%.2f, %.2f, %.2f", firstGrade, secondGrade, thirdGrade));
        System.out.println("Promedio de parciales: " +
                String.format("%.2f", averageGrade));
        System.out.println("Asistencia: " + attendancePercentage + "%");
        System.out.println("Entregó proyecto: " + (projectSubmitted ? "Sí" : "No"));
        System.out.println("Calificación final: " +
                String.format("%.2f", finalGrade));
        System.out.println("Estado: " + studentStatus);
    }
}