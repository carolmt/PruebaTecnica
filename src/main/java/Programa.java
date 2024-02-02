import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int capacidad;
        List<String> contenido;
        String marca;
        int velocidad;
        int opcion = 9;

        System.out.println("Introduce los datos del disco duro");
        marca = solicitarDatos(reader, "Marca: ");
        capacidad = Integer.parseInt(solicitarDatos(reader, "Capacidad(GB): "));
        velocidad = Integer.parseInt(solicitarDatos(reader, "Velocidad(RPM): "));
        DiscoDuro discoDuro = new DiscoDuro(capacidad, marca, velocidad);

        System.out.println("Introduce los datos del CD");
        marca = solicitarDatos(reader, "Marca: ");
        capacidad = Integer.parseInt(solicitarDatos(reader, "Capacidad(GB): "));
        velocidad = Integer.parseInt(solicitarDatos(reader, "Velocidad(RPM): "));
        Cd cd = new Cd(capacidad, marca, velocidad);

        do {
            opcion = menu(reader);
            switch (opcion) {
                case 1:
                    discoDuro.almacenarDatosEnDisco();
                    break;
                case 2:
                    discoDuro.escribirDatosEnDisco();
                    break;
                case 3:
                    discoDuro.leerDatosDelDisco();
                    break;
                case 4:
                    discoDuro.reportarInformacionDelDisco();
                    break;
                case 5:
                    cd.almacenarDatosEnDisco();
                    break;
                case 6:
                    cd.escribirDatosEnDisco();
                    break;
                case 7:
                    cd.leerDatosDelDisco();
                    break;
                case 8:
                    cd.reportarInformacionDelDisco();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 0);
    }

    public static String solicitarDatos(Scanner scanner, String mensaje) {
        String input;
        do {
            System.out.println(mensaje);
            input = scanner.nextLine();
            if (!isNumeric(input)) {
                System.out.println("Por favor, introduce un número válido.");
            }
        } while (!isNumeric(input));
        return input;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int menu(Scanner reader) {
        int opcion;
        do {
            System.out.println("1. Almacenar datos en disco duro");
            System.out.println("2. Escribir datos en disco duro");
            System.out.println("3. Leer datos del disco duro");
            System.out.println("4. Reportar información del disco duro");
            System.out.println("5. Almacenar datos en CD");
            System.out.println("6. Escribir datos en CD");
            System.out.println("7. Leer datos del CD");
            System.out.println("8. Reportar información del CD");
            System.out.println("0. Salir");
            System.out.println("Introduce una opción: ");
            try {
                opcion = reader.nextInt();
                reader.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número válido.");
                reader.nextLine();
                opcion = -1;
            }
        } while (opcion < 0 || opcion > 8);
        return opcion;
    }

}
