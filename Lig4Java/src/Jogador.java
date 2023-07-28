public abstract class Jogador {
    private String nome;
    private char peca;
    private Cor cor;

    public Jogador(String nome, char peca) {
        this.nome = nome;
        this.peca = peca;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) throws IllegalArgumentException{
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do jogador não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public char getPeca() {
        return peca;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) throws ValorAtributoInvalido {
        if (cor == null) {
            throw new ValorAtributoInvalido("A cor do jogador não pode ser nula.");
        }
        this.cor = cor;
    }

    public abstract void fazerJogada(TabuleiroInterface tabuleiro, int coluna);
    public abstract String obterTipoJogador();
}
