package popularidades;

import iconos.Icono;
import lombok.Getter;
import canciones.Cancion;

@Getter
public abstract class Popularidad {
  protected Icono icono;
  protected Integer reproduccionesEnEstado;
  protected Integer likesEnEstado;
  protected Integer dislikesEnEstado;

  protected Popularidad() {
    this.reproduccionesEnEstado = 0;
    this.likesEnEstado = 0;
    this.dislikesEnEstado = 0;
  }

  public void aumentarReproduccion() {
    reproduccionesEnEstado++;
  }

  public void aumentarLikes() {
    likesEnEstado++;
  }

  public void aumentarDislikes() {
    dislikesEnEstado++;
  }

  public String detalle(Cancion cancion) {
    return getIcono().texto() + leyenda(cancion);
  }

  protected abstract String leyenda(Cancion cancion);

  public abstract void reproducir(Cancion cancion);


}
