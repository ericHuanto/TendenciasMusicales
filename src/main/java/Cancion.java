import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Cancion {
  private String titulo;
  private Album album;
  private String artista;
  @Setter
  private Popularidad popularidad;
  private Integer cantReproducciones;
  private Integer cantLikes;
  private Integer cantDislikes;
  private LocalDateTime ultimaReproduccion;

  public Cancion(String titulo, String artista) {
    this.titulo = titulo;
    this.artista = artista;
    this.popularidad = new Normal(0, 0, 0);
    this.cantReproducciones = 0;
    this.cantLikes = 0;
    this.cantDislikes = 0;
  }

  public void recibirLike() {
    this.cantLikes++;
  }

  public void recibirDislike() {
    this.cantDislikes++;
  }

  public String detalle() {
    return popularidad.detalle(this);
  }

  public String reproducir() {
    cantReproducciones++;
    ultimaReproduccion = LocalDateTime.now();
    //reproducir es la accion que puede hacer que la cancion cambie de estado
    popularidad.reproducir(this);
    return detalle();
  }

  public String getAlbum() {
    return album.getNombre();
  }

  public LocalDate getAnioAlbum() {
    return album.getAnio();
  }
}
