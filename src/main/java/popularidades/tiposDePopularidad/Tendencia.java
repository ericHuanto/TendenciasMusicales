package popularidades.tiposDePopularidad;

import canciones.Cancion;
import iconos.Icono;
import java.time.Duration;
import java.time.LocalDateTime;
import popularidades.Popularidad;
import popularidades.tiposDePopularidad.Normal;

public class Tendencia extends Popularidad {
  private Integer horasNecesarias = 24;

  public Tendencia() {
    super();
    this.icono = Icono.FIRE;
  }

  @Override
  protected String leyenda(Cancion cancion) {
    return "titulo: " + cancion.getTitulo() + "artista: " + cancion.getArtista() + "album: " + cancion.getAlbum() + "anio: " + cancion.getAnioAlbum();
  }

  @Override
  public void reproducir(Cancion cancion) {
    if(ultimaReproduccionEnHs(cancion) >= horasNecesarias) {
      cancion.setPopularidad(new Normal());
    }
  }

  private Integer ultimaReproduccionEnHs(Cancion cancion) {
    Duration duracion = Duration.between(cancion.getUltimaReproduccion(), LocalDateTime.now());
    return (int)duracion.toHours();
  }
}
