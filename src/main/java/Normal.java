import iconos.Icono;

public class Normal extends Popularidad{
  private Integer cantReproduccionesNecesarios = 1000;

  public Normal(Integer reproducciones, Integer likes, Integer dislikes) {
    this.cantReproduccionesInicial = reproducciones;
    this.cantLikesInicial = likes;
    this.cantDislikesInicial = dislikes;
    this.icono = Icono.MUSICAL_NOTE;
  }

  @Override
  protected String leyenda(Cancion cancion) {
    return "artista: " + cancion.getArtista() + "albun: " + cancion.getAlbum() + "titulo: " + cancion.getTitulo();
  }

  @Override
  public void reproducir(Cancion cancion) {
    if(reproduccionesEnEsteEstado(cancion) >= cantReproduccionesNecesarios) {
      cancion.setPopularidad(new Auge(cancion.getCantReproducciones(), cancion.getCantLikes(), cancion.getCantDislikes()));
    }
  }

}
