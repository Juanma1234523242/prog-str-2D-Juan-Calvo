public class GradeService {

    public double calcularPromedio(double firstGrade, double secondGrade, double thirdGrade) {
        return (firstGrade + secondGrade + thirdGrade) / 3.0;
    }

    public double calcularFinal(double averageGrade, int attendancePercentage) {
        return (averageGrade * 0.7) + (attendancePercentage * 0.3);
    }

    public String determinarEstado(
            double finalGrade,
            int attendancePercentage,
            boolean projectSubmitted) {

        if (attendancePercentage < 80) {
            return "REPROBADO por asistencia...";
        }

        if (!projectSubmitted) {
            return "REPROBADO no entregó proyecto!!";
        }

        if (finalGrade >= 70) {
            return "APROBADO muy bien";
        } else {
            return "REPROBADO por calificación";
        }
    }
}