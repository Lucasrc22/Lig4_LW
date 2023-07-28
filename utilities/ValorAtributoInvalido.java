public class ValorAtributoInvalido extends RuntimeException {
    public ValorAtributoInvalido() {
        super();
    }

    public ValorAtributoInvalido(String message) {
        super(message);
    }

    public ValorAtributoInvalido(String message, Throwable cause) {
        super(message, cause);
    }

    public ValorAtributoInvalido(Throwable cause) {
        super(cause);
    }
}
