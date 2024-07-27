package popularidades.tiposDePopularidad;

import canciones.Cancion;
import iconos.Icono;
import popularidades.Popularidad;

public class Auge extends Popularidad {
  private Integer reproduccionesNecesarias = 50000;
  private Integer likesNecesarios = 20000;
  private Integer dislikesNecesarios = 5000;

  public Auge() {
    super();
    this.icono = Icono.ROCKET;
  }

  @Override
  protected String leyenda(Cancion cancion) {
    return "artista: " + cancion.getArtista() + "cancion: " + cancion.getTitulo() + "album: " + cancion.getAlbum() + "anio del album: " + cancion.getAnioAlbum();
  }

  @Override
  public void reproducir(Cancion cancion) {
    if (getReproduccionesEnEstado() >= reproduccionesNecesarias && getLikesEnEstado() >= likesNecesarios) {
      cancion.setPopularidad(new Tendencia());
    }

    if (getDislikesEnEstado() >= dislikesNecesarios) {
      cancion.setPopularidad(new Normal());
    }
  }

}
