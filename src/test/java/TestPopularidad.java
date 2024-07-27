import canciones.Cancion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import popularidades.tiposDePopularidad.Auge;
import popularidades.tiposDePopularidad.Normal;
import popularidades.tiposDePopularidad.Tendencia;

public class TestPopularidad {

  @Test
  public void se_crea_una_cancion() {
    Cancion cancion = new Cancion("palomita", "superMK2");

    Assertions.assertEquals(Normal.class, cancion.getPopularidad().getClass());
    Assertions.assertNotEquals(Auge.class, cancion.getPopularidad().getClass());
    Assertions.assertNotEquals(Tendencia.class, cancion.getPopularidad().getClass());
  }

  
}
