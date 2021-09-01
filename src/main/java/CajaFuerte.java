public class CajaFuerte {

    private Boolean abierta = true;
    private int codigo;
    private boolean bloqueada = false;
    private int intentosErroneos = 0;

    public boolean estaAbierta() {
        return abierta;
    }

    public void cerrar(int Codigo) {
        if (estaCerrada())
            abrir(codigo);
        else {
            this.codigo = codigo;
            abierta = true;
        }

    }

    public boolean estaCerrada() {
        return !estaAbierta();
    }

    public void abrir(int codigo) {
        if (codigo == this.codigo)
            abierta = true;
        else {
            intentosErroneos++;
            if (intentosErroneos == 3)
                bloqueada = true;
        }
    }

    public boolean estaBloqueada() {
        return bloqueada;
    }
}
