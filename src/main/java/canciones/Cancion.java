package canciones;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import popularidades.Popularidad;
import popularidades.tiposDePopularidad.Normal;

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
    this.popularidad = new Normal();
    this.cantReproducciones = 0;
    this.cantLikes = 0;
    this.cantDislikes = 0;
  }

  public void recibirLike() {
    this.cantLikes++;
    popularidad.aumentarLikes();
  }

  public void recibirDislike() {
    this.cantDislikes++;
    popularidad.aumentarDislikes();
  }

  public void actualizarReproduccion() {
    cantReproducciones++;
    ultimaReproduccion = LocalDateTime.now();
    popularidad.aumentarReproduccion();
  }

  public String detalle() {
    return popularidad.detalle(this);
  }

  public String reproducir() {
    actualizarReproduccion();
    popularidad.reproducir(this); //reproducir es la accion que puede hacer que la cancion cambie de estado
    return detalle();
  }

  public String getAlbum() {
    return album.getNombre();
  }

  public LocalDate getAnioAlbum() {
    return album.getAnio();
  }
}
