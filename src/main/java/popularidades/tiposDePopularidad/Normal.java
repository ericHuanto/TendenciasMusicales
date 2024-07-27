package popularidades.tiposDePopularidad;

import canciones.Cancion;
import iconos.Icono;
import popularidades.Popularidad;
import popularidades.tiposDePopularidad.Auge;

public class Normal extends Popularidad {
  private Integer reproduccionesNecesarias = 1000;

  public Normal() {
    super();
    this.icono = Icono.MUSICAL_NOTE;
  }

  @Override
  protected String leyenda(Cancion cancion) {
    return "artista: " + cancion.getArtista() + "albun: " + cancion.getAlbum() + "titulo: " + cancion.getTitulo();
  }

  @Override
  public void reproducir(Cancion cancion) {
    if(getReproduccionesEnEstado() >= reproduccionesNecesarias) {
      cancion.setPopularidad(new Auge());
    }
  }

}
