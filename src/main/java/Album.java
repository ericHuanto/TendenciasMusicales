import java.time.LocalDate;
import lombok.Getter;

@Getter
public class Album {
  private String nombre;
  private LocalDate anio;

  public Album(String nombre, LocalDate anio) {
    this.nombre = nombre;
    this.anio = anio;
  }

}
