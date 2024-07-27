import iconos.Icono;

public abstract class Popularidad {
  protected Icono icono;
  public Integer cantReproduccionesInicial;
  public Integer cantLikesInicial;
  public Integer cantDislikesInicial;

  public String detalle(Cancion cancion) {
    return getDetalleIcono() + leyenda(cancion);
  }

  protected String getDetalleIcono() {
    return icono.texto();
  }

  protected abstract String leyenda(Cancion cancion);

  public abstract void reproducir(Cancion cancion);

  protected Integer reproduccionesEnEsteEstado(Cancion cancion) {
    return cancion.getCantReproducciones() - cantReproduccionesInicial;
  }

  protected Integer dislikesEnEsteEstado(Cancion cancion) {
    return cancion.getCantDislikes() - cantDislikesInicial;
  }

  protected Integer likesEnEsteEstado(Cancion cancion) {
    return cancion.getCantLikes() - cantLikesInicial;
  }

}
