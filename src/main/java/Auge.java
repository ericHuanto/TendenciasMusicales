import iconos.Icono;

public class Auge extends Popularidad {
  private Integer cantReproduccionesNecesarios = 50000;
  private Integer cantlikesNecesarios = 20000;
  private Integer cantDislikesNecesarios = 5000;

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
    if (getReproduccionesEnEstado() >= cantReproduccionesNecesarios && getLikesEnEstado() >= cantlikesNecesarios) {
      cancion.setPopularidad(new Tendencia());
    }

    if (getDislikesEnEstado() >= cantDislikesNecesarios) {
      cancion.setPopularidad(new Normal());
    }
  }

}
