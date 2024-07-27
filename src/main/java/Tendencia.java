import iconos.Icono;
import java.time.Duration;
import java.time.LocalDateTime;

public class Tendencia extends Popularidad {
  private Integer cantHorasNecesarias = 24;

  public Tendencia(Integer reproducciones, Integer likes, Integer dislikes) {
    this.cantReproduccionesInicial = reproducciones;
    this.cantLikesInicial = likes;
    this.cantDislikesInicial = dislikes;
    this.icono = Icono.FIRE;
  }

  @Override
  protected String leyenda(Cancion cancion) {
    return "titulo: " + cancion.getTitulo() + "artista: " + cancion.getArtista() + "album: " + cancion.getAlbum() + "anio: " + cancion.getAnioAlbum();
  }

  @Override
  public void reproducir(Cancion cancion) {
    if(ultimaReproduccionEnHs(cancion) >=  cantHorasNecesarias) {
      cancion.setPopularidad(new Normal(cancion.getCantReproducciones(), cancion.getCantLikes(), cancion.getCantDislikes()));
    }
  }

  private Integer ultimaReproduccionEnHs(Cancion cancion) {
    Duration duracion = Duration.between(cancion.getUltimaReproduccion(), LocalDateTime.now());
    return (int)duracion.toHours();
  }
}
