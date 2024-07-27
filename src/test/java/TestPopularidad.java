import canciones.Cancion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import popularidades.tiposDePopularidad.Auge;
import popularidades.tiposDePopularidad.Normal;
import popularidades.tiposDePopularidad.Tendencia;

public class TestPopularidad {

  @Test
  public void se_crea_una_cancion_y_esta_en_popularidad_normal() {
    Cancion cancion = new Cancion("palomita", "superMK2");

    Assertions.assertEquals(Normal.class, cancion.getPopularidad().getClass());
  }

  @Test
  public void una_cancion_se_vuelve_en_auge() {
    Cancion cancion = new Cancion("palomita", "superMK2");

    pasarApopularidadNormal(cancion);

    Assertions.assertEquals(Auge.class, cancion.getPopularidad().getClass());
  }

  @Test
  public void una_cancion_baja_del_auge_por_tener_muchos_dislikes() {
    Cancion cancion = new Cancion("palomita", "superMK2");

    pasarApopularidadNormal(cancion);

    darXcantidadDeDislikes(cancion, 5001);

    cancion.reproducir();//es al momento de reproducir donde se fija si debe o no cambiar de estado

    Assertions.assertEquals(Normal.class, cancion.getPopularidad().getClass());
  }

  @Test
  public void una_cancion_se_vuelve_tendencia() {
    Cancion cancion = new Cancion("palomita", "superMK2");

    pasarApopularidadNormal(cancion);
    pasarApopularidadTendencia(cancion);

    Assertions.assertEquals(Tendencia.class, cancion.getPopularidad().getClass());
  }

  @Test
  public void una_cancion_vuelve_a_popularidad_normal_despues_de_ser_tendencia() {
    Cancion cancion = new Cancion("palomita", "superMK2");
    Tendencia tendencia = spy(Tendencia.class);
    cancion.setPopularidad(tendencia);

    //el spy es mucho mejor que el mock
    //te permite tener lo mismo que instanciar una clase y definir una parte
    doReturn(99).when(tendencia).ultimaReproduccionFueXHs(cancion);

    cancion.reproducir();

    Assertions.assertEquals(Normal.class, cancion.getPopularidad().getClass());
  }






  //mensajes que facilitan el test
  public void pasarApopularidadNormal(Cancion cancion) {
    for(int i=0; i<=1001; i++)
      cancion.reproducir();
  }

  public void darXcantidadDeDislikes(Cancion cancion, Integer cantidad) {
    for(int i=0; i<=cantidad; i++)
      cancion.recibirDislike();
  }

  public void pasarApopularidadTendencia(Cancion cancion) {
    for(int i=0; i<=20000; i++)
      cancion.recibirLike();

    for(int i=0; i<=50001; i++)
      cancion.reproducir();
  }

  // interesante esto
  /*
    doAnswer(invocacion -> {
      Cancion cancion1 = invocacion.getArgument(0);
      cancion1.setPopularidad(new Normal());
      return null;})
    .when(tendencia).reproducir(cancion);

    cancion.reproducir();
  */

}
