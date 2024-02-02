import java.util.List;
import java.util.Scanner;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data

public class Cd extends DiscoBase implements Almacenamiento {
    private List<String> contenido;

    public Cd(int capacidad, String marca, int velocidad) {
        super(capacidad, marca, velocidad);
    }

    public Cd(int capacidad, String marca, int velocidad, List<String> contenido) {
        super(capacidad, marca, velocidad);
        this.contenido = contenido;
    }
    @Override
    public void girarDisco() {
        System.out.println("CD girando...");
    }

    @Override
    public void almacenarDatosEnDisco() {
        Scanner scanner = new Scanner(System.in);
        String data;
        do {
            System.out.println("Introduce los datos a almacenar en el CD (escribe 'salir' para terminar):");
            data = scanner.nextLine();
            girarDisco();

            if (!data.equalsIgnoreCase("salir")) {
                System.out.printf("Añadiendo datos en el CD....");
                contenido.add(data);
            }
        } while (!data.equalsIgnoreCase("salir"));

    }

    @Override
    public void escribirDatosEnDisco() {
        Scanner scanner = new Scanner(System.in);
        String data;
        do {
            System.out.println("Introduce los datos a escribir en el CD (escribe 'salir' para terminar):");
            data = scanner.nextLine();
            girarDisco();

            if (!data.equalsIgnoreCase("salir")) {
                System.out.println("Escribiendo datos en el CD con un láser...");
                contenido.add(data);
            }
        } while (!data.equalsIgnoreCase("salir"));
    }

    @Override
    public void leerDatosDelDisco() {
        System.out.println("Leyendo datos del CD con un láser...");
        for (String data : contenido) {
            System.out.println(data);
        }
    }

    @Override
    public void reportarInformacionDelDisco() {
        String datos = toString();
        System.out.println(datos);
        System.out.println("Contenido:");
        for (String data : contenido) {
            System.out.println(data);
        }
    }
    @Override
    public String toString() {
        return "Marca = " + getMarca() + '\'' +
                "capacidad=" + getCapacidad() + " GB" + '\'' +
                ", velocidad=" + getVelocidad() + " RPM";
    }
}





