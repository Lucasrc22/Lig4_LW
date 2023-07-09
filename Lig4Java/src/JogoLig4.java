public class JogoLig4 {
    public static void main(String[] args) throws Exception {
        try {
            Lig4 jogo = new Lig4();
            boolean modoIA = true; // Set the desired mode (true for jogador1 vs IA, false for jogador1 vs jogador2)
            jogo.inicializar(modoIA);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a execução do jogo: " + e.getMessage());
        }
    }
}
