public enum Cor {
    VERMELHO('X'),
    AMARELO('O'),
    AZUL('B'),
    VERDE('G');

    private char valor;

    Cor(char valor) {
        this.valor = valor;
    }

    public char getValor() {
        return valor;
    }
}
