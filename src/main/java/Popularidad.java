import iconos.Icono;

public abstract class Popularidad {
  protected Icono icono;
  public Integer cantReproduccionesInicial;
  public Integer cantLikesInicial;
  public Integer cantDislikesInicial;

  public String detalle(Cancion cancion) {
    return getDetalleIcono() + leyenda(cancion);
  }

  protected Popularidad() {
    this.cantReproduccionesInicial = 0;
    this.cantLikesInicial = 0;
    this.cantDislikesInicial = 0;
  }

  protected String getDetalleIcono() {
    return icono.texto();
  }

  protected abstract String leyenda(Cancion cancion);

  public abstract void reproducir(Cancion cancion);

  protected Integer reproduccionesEnEsteEstado(Cancion cancion) {
    return cantReproduccionesInicial;
  }

  protected Integer dislikesEnEsteEstado(Cancion cancion) {
    return cantDislikesInicial;
  }

  protected Integer likesEnEsteEstado(Cancion cancion) {
    return cantLikesInicial;
  }

  public void aumentarReproduccion() {
    cantReproduccionesInicial++;
  }

  public void aumentarLikes() {
    cantLikesInicial++;
  }

  public void aumentarDislikes() {
    cantDislikesInicial++;
  }
}
