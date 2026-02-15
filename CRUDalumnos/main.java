package CRUDalumnos;

import java.util.Scanner;

public class main {
    private static final int REGISTRY_CAPACITY = 25;
    
    public static void main(String[] args) {
        Alumno[] alumnos = new Alumno[REGISTRY_CAPACITY];
        Scanner inputReader = new Scanner(System.in);
        
        displayWelcomeMessage();
        
        while (true) {
            displayMainMenu();
            int menuSelection = InputDataValidator.getValidatedInteger(inputReader, 
                "Selecciona una opcion", 0, 6);
            
            processMenuSelection(alumnos, inputReader, menuSelection);
        }
    }
    
    private static void displayWelcomeMessage() {
        System.out.println("\nSISTEMA DE GESTIÓN DE ALUMNOS\n");
    }
    
    private static void displayMainMenu() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Alta alumno");
        System.out.println("2. Buscar por ID");
        System.out.println("3. Actualizar promedio por ID");
        System.out.println("4. Baja lógica por ID");
        System.out.println("5. Listar activos");
        System.out.println("6. Reportes");
        System.out.println("0. Salir");
    }
    
    private static void processMenuSelection(Alumno[] alumnos, Scanner inputReader, int selection) {
        switch (selection) {
            case 1:
                addNewAlumno(alumnos, inputReader);
                break;
            case 2:
                searchAlumno(alumnos, inputReader);
                break;
            case 3:
                updatePromedio(alumnos, inputReader);
                break;
            case 4:
                bajaLogica(alumnos, inputReader);
                break;
            case 5:
                displayActiveAlumnos(alumnos);
                break;
            case 6:
                displayReports(alumnos);
                break;
            case 0:
                exitApplication(inputReader);
                break;
            default:
                System.out.println("\nSeleccion no reconocida");
        }
    }
    
    private static void addNewAlumno(Alumno[] alumnos, Scanner inputReader) {
        System.out.println("\n=== ALTA ALUMNO ===");
        
        int id = InputDataValidator.getIntegerGreaterThan(inputReader, 
            "Ingresa el ID del alumno", 0);
        
       
        if (idExists(alumnos, id)) {
            System.out.println("Error: Este ID ya esta en uso.");
            return;
        }
        
        String nombre = InputDataValidator.captureNonEmptyString(inputReader, 
            "Ingresa el nombre del alumno: ");
        
        double promedio = InputDataValidator.getValidatedDouble(inputReader, 
            "Ingresa el promedio", 0.0, 10.0);
        
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                Alumno nuevoAlumno = new Alumno(id, nombre, promedio);
                alumnos[i] = nuevoAlumno;
                System.out.println("\nAlumno registrado exitosamente");
                System.out.println("   " + alumnos[i]);
                return;
            }
        }
        System.out.println("Error no hay espacio disponible en el sistema.");
    }
    
    private static void searchAlumno(Alumno[] alumnos, Scanner inputReader) {
        System.out.println("\n=== BUSCAR ALUMNO ===");
        
        int id = InputDataValidator.getIntegerGreaterThan(inputReader, 
            "¿Cuál es el ID a buscar?", 0);
        
        Alumno alumno = findAlumnoById(alumnos, id);
        if (alumno != null && alumno.isActivo()) {
            System.out.println("\nAlumno encontrado:");
            System.out.println("   " + alumno);
        } else {
            System.out.println("\nError: No existe un alumno activo con ese ID.");
        }
    }
    
    private static void updatePromedio(Alumno[] alumnos, Scanner inputReader) {
        System.out.println("\n=== ACTUALIZAR PROMEDIO ===");
        
        int id = InputDataValidator.getIntegerGreaterThan(inputReader, 
            "¿Cuál es el ID a actualizar?", 0);
        
        Alumno alumno = findAlumnoById(alumnos, id);
        if (alumno == null || !alumno.isActivo()) {
            System.out.println("\nError: Alumno no encontrado o inactivo.");
            return;
        }
        
        System.out.println("\nAlumno actual:");
        System.out.println("   " + alumno);
        
        double nuevoPromedio = InputDataValidator.getValidatedDouble(inputReader, 
            "Ingresa el nuevo promedio", 0.0, 10.0);
        
        alumno.setPromedio(nuevoPromedio);
        System.out.println("\nPromedio actualizado correctamente");
        System.out.println("   " + alumno);
    }
    
    private static void bajaLogica(Alumno[] alumnos, Scanner inputReader) {
        System.out.println("\n=== BAJA LÓGICA ===");
        
        int id = InputDataValidator.getIntegerGreaterThan(inputReader, 
            "¿Cuál es el ID a dar de baja?", 0);
        
        Alumno alumno = findAlumnoById(alumnos, id);
        if (alumno == null || !alumno.isActivo()) {
            System.out.println("\nError: Alumno no encontrado o ya está inactivo.");
            return;
        }
        
        System.out.println("\nAlumno a dar de baja:");
        System.out.println("   " + alumno);
        
        String confirmation = InputDataValidator.captureNonEmptyString(inputReader, 
            "¿Si deseas hacer una baja escribe confirmar: ");
        
        if (confirmation.toLowerCase().equals("confirmar")) {
            alumno.setActivo(false);
            System.out.println("\nAlumno dado de baja exitosamente");
        } else {
            System.out.println("\nOperacion cancelada");
        }
    }
    
    private static void displayActiveAlumnos(Alumno[] alumnos) {
        System.out.println("\n=== ALUMNOS ACTIVOS ===");
        
        boolean hasAlumnos = false;
        int count = 0;
        
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].isActivo()) {
                System.out.println((++count) + ". " + alumnos[i]);
                hasAlumnos = true;
            }
        }
        
        if (!hasAlumnos) {
            System.out.println("No hay alumnos activos en el sistema.");
        } else {
            System.out.println("\nTotal de alumnos activos: " + count);
        }
    }
    
    private static void displayReports(Alumno[] alumnos) {
        System.out.println("\n===== REPORTES =====");
        System.out.println("1. Promedio general de alumnos activos");
        System.out.println("2. Alumno activo con mayor promedio");
        System.out.println("3. Alumno activo con menor promedio");
        System.out.println("4. Cantidad de activos con promedio >= 8.0");
        
        Scanner sc = new Scanner(System.in);
        int opcion = InputDataValidator.getValidatedInteger(sc, "Selecciona un reporte", 1, 4);
        
        switch (opcion) {
            case 1:
                reportPromediGeneral(alumnos);
                break;
            case 2:
                reportMayorPromedio(alumnos);
                break;
            case 3:
                reportMenorPromedio(alumnos);
                break;
            case 4:
                reportPromedioAlto(alumnos);
                break;
        }
    }
    
    private static void reportPromediGeneral(Alumno[] alumnos) {
        System.out.println("\n--- PROMEDIO GENERAL ---");
        double suma = 0;
        int count = 0;
        
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].isActivo()) {
                suma += alumnos[i].getPromedio();
                count++;
            }
        }
        
        if (count == 0) {
            System.out.println("No hay alumnos activos para calcular promedio.");
        } else {
            double promedio = suma / count;
            System.out.println("Promedio de " + count + " alumnos activos: " + String.format("%.2f", promedio));
        }
    }
    
    private static void reportMayorPromedio(Alumno[] alumnos) {
        System.out.println("\n--- ALUMNO CON MAYOR PROMEDIO ---");
        Alumno mejor = null;
        
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].isActivo()) {
                if (mejor == null || alumnos[i].getPromedio() > mejor.getPromedio()) {
                    mejor = alumnos[i];
                }
            }
        }
        
        if (mejor == null) {
            System.out.println("No hay alumnos activos.");
        } else {
            System.out.println("ID: " + mejor.getId());
            System.out.println("Nombre: " + mejor.getNombre());
            System.out.println("Promedio: " + String.format("%.2f", mejor.getPromedio()));
        }
    }
    
    private static void reportMenorPromedio(Alumno[] alumnos) {
        System.out.println("\n--- ALUMNO CON MENOR PROMEDIO ---");
        Alumno peor = null;
        
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].isActivo()) {
                if (peor == null || alumnos[i].getPromedio() < peor.getPromedio()) {
                    peor = alumnos[i];
                }
            }
        }
        
        if (peor == null) {
            System.out.println("No hay alumnos activos.");
        } else {
            System.out.println("ID: " + peor.getId());
            System.out.println("Nombre: " + peor.getNombre());
            System.out.println("Promedio: " + String.format("%.2f", peor.getPromedio()));
        }
    }
    
    private static void reportPromedioAlto(Alumno[] alumnos) {
        System.out.println("\n--- ALUMNOS CON PROMEDIO >= 8.0 ---");
        int count = 0;
        
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].isActivo() && alumnos[i].getPromedio() >= 8.0) {
                count++;
            }
        }
        
        System.out.println("Cantidad de alumnos activos con promedio >= 8.0: " + count);
    }
    
    private static void exitApplication(Scanner inputReader) {
        System.out.println("\nGracias por usar el sistema de gestión de alumnos");
        System.out.println("¡Que tengas un excelente día!\n");
        inputReader.close();
        System.exit(0);
    }
    
    private static Alumno findAlumnoById(Alumno[] alumnos, int id) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getId() == id) {
                return alumnos[i];
            }
        }
        return null;
    }
    
    private static boolean idExists(Alumno[] alumnos, int id) {
        return findAlumnoById(alumnos, id) != null;
    }
}
