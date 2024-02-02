import lombok.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;
import java.util.Scanner;

@Data
@EqualsAndHashCode(callSuper = true)


public class DiscoDuro extends DiscoBase implements Almacenamiento{

    private List<String> contenido;

    public DiscoDuro(int capacidad, String marca, int velocidad) {
        super(capacidad, marca, velocidad);
    }

    public DiscoDuro(int capacidad, String marca, int velocidad, List<String> contenido) {
        super(capacidad, marca, velocidad);
        this.contenido = contenido;
    }


    @Override
    public void girarDisco() {
        System.out.println("Disco duro girando...");
    }

    @Override
    public void almacenarDatosEnDisco() {
        Scanner scanner = new Scanner(System.in);
        String data;
        do {
            System.out.println("Introduce los datos a almacenar en el disco duro (escribe 'salir' para terminar):");
            data = scanner.nextLine();
            girarDisco();

            if (!data.equalsIgnoreCase("salir")) {
                System.out.printf("Añadiendo datos en el disco duro....");
                contenido.add(data);
            }
        } while (!data.equalsIgnoreCase("salir"));
    }

    @Override
    public void escribirDatosEnDisco() {
        Scanner scanner = new Scanner(System.in);
        String data;
        do {
            System.out.println("Introduce los datos a escribir en el disco duro (escribe 'salir' para terminar):");
            data = scanner.nextLine();
            girarDisco();

            if (!data.equalsIgnoreCase("salir")) {
                System.out.println("Escribiendo datos en el disco duro con un cabezal magnético...");
                contenido.add(data);
            }
        } while (!data.equalsIgnoreCase("salir"));
    }

    @Override
    public void leerDatosDelDisco() {
        System.out.println("Leyendo datos del disco duro con un cabezal magnético...");
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
