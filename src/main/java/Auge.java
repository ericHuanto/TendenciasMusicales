import iconos.Icono;

public class Auge extends Popularidad {
  private Integer cantReproduccionesNecesarios = 50000;
  private Integer cantlikesNecesarios = 20000;
  private Integer cantDislikesNecesarios = 5000;

  public Auge(Integer reproducciones, Integer likes, Integer dislikes) {
    super();
    this.icono = Icono.ROCKET;
  }

  @Override
  protected String leyenda(Cancion cancion) {
    return "artista: " + cancion.getArtista() + "cancion: " + cancion.getTitulo() + "album: " + cancion.getAlbum() + "anio del album: " + cancion.getAnioAlbum();
  }

  @Override
  public void reproducir(Cancion cancion) {
    if (reproduccionesEnEsteEstado(cancion) >= cantReproduccionesNecesarios && likesEnEsteEstado(cancion) >= cantlikesNecesarios) {
      cancion.setPopularidad(new Tendencia());
    }

    if (dislikesEnEsteEstado(cancion) >= cantDislikesNecesarios) {
      cancion.setPopularidad(new Normal());
    }
  }

}
