import org.junit.*;
import static org.junit.Assert.*;


public class CajaFuerteTest {

    public static final int CODIGO = 3434;
    private static final int CODIGO_INCORRECTO = 8787;

    @Test
    public void testQueSeCreeUnaCajaFuerteAbierta(){
        // Preparación / Given / Dado
        //En este caso no hay given porque hay que crear la caja

        // Ejecución / When / Cuando
        CajaFuerte caja = whenCreoUnaCajaFuerte();

        //Comprobación / Then / Entonces
        thenLaCajaFuerteEstaAbierta(caja);
    }

    @Test
    public void testAlCerrarConCodigoLaCajaFuerteDebeEstarCerrada(){
        CajaFuerte caja = givenCreoUnaCajaFuerte();

        caja.cerrar(CODIGO);

        thenLaCajaFuerteEstaCerrada(caja);
    }

    @Test
    public void testAlIngresarElCodigoCorrectoLaCajaSeAbre(){
        CajaFuerte caja = givenCreoUnaCajaFuerte();
        caja.cerrar(CODIGO);

        whenAbroLaCajaFuerteConElMismoCodigoSeAbre(CODIGO, caja, 3);

        thenLaCajaFuerteEstaAbierta(caja);
    }

    @Test
    public void testAlIngresarElCodigoIncorrectoLaCajaNoSeAbre(){
        CajaFuerte caja = givenCreoUnaCajaFuerte();
        caja.cerrar(CODIGO);

        whenAbroLaCajaFuerteConElMismoCodigoSeAbre(CODIGO_INCORRECTO, caja, 3);

        thenLaCajaFuerteEstaCerrada(caja);
    }

    @Test
    public void testQueCuandoSeintenteAbrirMasDeTresVecesSeBloquee(){
        CajaFuerte caja = givenCreoUnaCajaFuerte();
        caja.cerrar(CODIGO);

        whenAbroLaCajaFuerteConElMismoCodigoSeAbre(CODIGO_INCORRECTO, caja, 2);
        whenAbroLaCajaFuerteConElMismoCodigoSeAbre(CODIGO, caja);

        caja.cerrar(CODIGO);

        whenAbroLaCajaFuerteConElMismoCodigoSeAbre(CODIGO_INCORRECTO, caja, 1);

        thenLaCajaFuerteEstaCerrada(caja);
        thenLaCajaFuerteEstaNoBloqueada(caja);

    }

    private void thenLaCajaFuerteEstaNoBloqueada(CajaFuerte caja) {
        assertFalse(caja.estaBloqueada());
    }

    private void whenAbroLaCajaFuerteConElMismoCodigoSeAbre(int codigo, CajaFuerte caja) {
        caja.abrir(codigo);
    }

    private void thenLaCajaFuerteEstaBloqueada(CajaFuerte caja) {
        assertTrue(caja.estaBloqueada());
    }

    private void whenAbroLaCajaFuerteConElMismoCodigoSeAbre(int codigo, CajaFuerte caja, int intentos) {
        for (int i = 0; i < intentos; i++){
            caja.abrir(codigo);
        }
    }

    private void thenLaCajaFuerteEstaCerrada(CajaFuerte caja) {
        assertTrue(caja.estaCerrada());
    }

    private CajaFuerte givenCreoUnaCajaFuerte() {
        return crearCaja();
    }

    private CajaFuerte whenCreoUnaCajaFuerte() {
        return crearCaja();
    }

    private void thenLaCajaFuerteEstaAbierta(CajaFuerte caja) {
        assertTrue(caja.estaAbierta());
    }

    private CajaFuerte crearCaja() {
        return new CajaFuerte();
    }
}
