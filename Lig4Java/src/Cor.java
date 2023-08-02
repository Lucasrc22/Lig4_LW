public enum Cor {
    VAZIO(' '),  
    VERMELHO('V'),
    AMARELO('A'),
    AZUL('Z'),
    VERDE('G'),
    ROSA('R'),
    LARANJA('L');

    private char valor;

    Cor(char valor) {
        this.valor = valor;
    }

    public char getValor() {
        return valor;
    }

    public static Cor fromChar(char valor) throws IllegalArgumentException {
        for (Cor cor : Cor.values()) {
            if (cor.valor == valor) {
                return cor;
            }
        }
        throw new IllegalArgumentException("Cor inválida: " + valor);
    }
}
