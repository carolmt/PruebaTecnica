import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscoBase {
    private int capacidad;
    private String marca;
    private int velocidad;

    @Override
    public String toString() {
        return "capacidad=" + capacidad + " GB" +
                ", marca='" + marca + '\'' +
                ", velocidad=" + velocidad + " RPM";
    }
}
