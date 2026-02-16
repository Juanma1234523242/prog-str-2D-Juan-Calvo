import java.util.Scanner;

public class main {
    private static final int REGISTRY_CAPACITY = 25;
    
    public static void main(String[] args) {
        Persona[] registry = new Persona[REGISTRY_CAPACITY];
        Scanner inputReader = new Scanner(System.in);
        
        displayWelcomeMessage();
        
        while (true) {
            displayMainMenu();
            int menuSelection = InputDataValidator.getValidatedInteger(inputReader, 
                "Elige una opcion", 0, 6);
            
            processMenuSelection(registry, inputReader, menuSelection);
        }
    }
    
    private static void displayWelcomeMessage() {
        System.out.println("\nSISTEMA DE GESTIÓN DE REGISTROS\n");
    }
    
    private static void displayMainMenu() {
        System.out.println("\n----MENU----?");
        System.out.println("1. Alta de un alumno");
        System.out.println("2. Buscar IDo");
        System.out.println("3. Actualizar promedio por ID");
        System.out.println("4. Baja logica por ID");
        System.out.println("5. Listar archivos");
        System.out.println("0. salir");

    }
    
    private static void processMenuSelection(Persona[] registry, Scanner inputReader, int selection) {
        switch (selection) {
            case 1:
                addNewRecord(registry, inputReader);
                break;
            case 2:
                searchRecord(registry, inputReader);
                break;
            case 3:
                removeRecord(registry, inputReader);
                break;
            case 4:
                displayAllRecords(registry);
                break;
            case 5:
                modifyRecord(registry, inputReader);
                break;
            case 6:
                exitApplication(inputReader);
                break;
            default:
                System.out.println("\nSeleccion no reconocida");
        }
    }
    
    private static void addNewRecord(Persona[] registry, Scanner inputReader) {
        System.out.println("\nAGREGAR NUEVO REGISTRO");
        
        int registryId = InputDataValidator.getIntegerGreaterThan(inputReader, 
            "Ingresa el identificador del registro", 0);
        
        // Validar disponibilidad del ID
        while (isIdOccupied(registry, registryId)) {
            System.out.println("Error: Este identificador ya esta en uso.");
            registryId = InputDataValidator.getIntegerGreaterThan(inputReader, 
                "Ingresa un identificador diferente", 0);
        }
        
        String fullName = InputDataValidator.captureNonEmptyString(inputReader, 
            "Ingresa el nombre completo: ");
        
        Persona newRecord = new Persona();
        newRecord.setRegistryId(registryId);
        newRecord.setFullName(fullName);
        newRecord.setEnabled(true);
        registry[registryId] = newRecord;
        
        System.out.println("\nRegistro guardado correctamente");
        System.out.println("   " + registry[registryId]);
    }
    
    private static void searchRecord(Persona[] registry, Scanner inputReader) {
        System.out.println("\nCONSULTAR REGISTRO");
        
        int registryId = InputDataValidator.getIntegerGreaterThan(inputReader, 
            "¿Cuál es el identificador a buscar?", 0);
        
        if (recordExists(registry, registryId)) {
            System.out.println("\nRegistro encontrado:");
            System.out.println("   " + registry[registryId]);
        } else {
            System.out.println("\nError: No existe un registro con ese identificador.");
        }
    }
    
    private static void removeRecord(Persona[] registry, Scanner inputReader) {
        System.out.println("\nREMOVER REGISTRO");
        
        int registryId = InputDataValidator.getIntegerGreaterThan(inputReader, 
            "¿Cuál es el identificador a eliminar?", 0);
        
        if (!recordExists(registry, registryId)) {
            System.out.println("\nError: Registro no encontrado.");
            return;
        }
        
        System.out.println("\nRegistro a eliminar:");
        System.out.println("   " + registry[registryId]);
        
        String confirmation = InputDataValidator.captureNonEmptyString(inputReader, 
            "¿Confirmar eliminación? (escribe 'confirmar'): ");
        
        if (confirmation.toLowerCase().equals("confirmar")) {
            registry[registryId].setEnabled(false);
            System.out.println("\nRegistro eliminado exitosamente");
        } else {
            System.out.println("\nOperacion cancelada");
        }
    }
    
    private static void displayAllRecords(Persona[] registry) {
        System.out.println("\nREGISTROS ACTIVOS");
        
        boolean hasRecords = false;
        int count = 0;
        
        for (int i = 0; i < registry.length; i++) {
            if (registry[i] != null && registry[i].isEnabled()) {
                System.out.println((++count) + ". " + registry[i]);
                hasRecords = true;
            }
        }
        
        if (!hasRecords) {
            System.out.println("No hay registros activos en el sistema.");
        } else {
            System.out.println("Total de registros: " + count);
        }
    }
    
    private static void modifyRecord(Persona[] registry, Scanner inputReader) {
        System.out.println("\nMODIFICAR REGISTRO");
        
        int registryId = InputDataValidator.getIntegerGreaterThan(inputReader, 
            "¿Cuál es el identificador a modificar?", 0);
        
        if (!recordExists(registry, registryId)) {
            System.out.println("\nError: Registro no encontrado.");
            return;
        }
        
        System.out.println("\nRegistro actual:");
        System.out.println("   " + registry[registryId]);
        
        String newName = InputDataValidator.captureNonEmptyString(inputReader, 
            "Ingresa el nuevo nombre (actual: " + registry[registryId].getFullName() + "): ");
        
        registry[registryId].setFullName(newName);
        
        System.out.println("\nRegistro actualizado correctamente");
        System.out.println("   " + registry[registryId]);
    }
    
    private static void exitApplication(Scanner inputReader) {
        System.out.println("\nMuchas gracias");
        System.out.println("Que tengas un buen dia\n");
        inputReader.close();
        System.exit(0);
    }
    
    private static boolean recordExists(Persona[] registry, int registryId) {
        return registryId < registry.length && registry[registryId] != null && registry[registryId].isEnabled();
    }
    
    private static boolean isIdOccupied(Persona[] registry, int registryId) {
        return registryId < registry.length && registry[registryId] != null && registry[registryId].isEnabled();
    }
}
