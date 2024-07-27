import iconos.Icono;

public class Normal extends Popularidad{
  private Integer cantReproduccionesNecesarios = 1000;

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
    if(getReproduccionesEnEstado() >= cantReproduccionesNecesarios) {
      cancion.setPopularidad(new Auge());
    }
  }

}
