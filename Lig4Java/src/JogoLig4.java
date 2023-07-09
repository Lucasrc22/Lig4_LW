public class JogoLig4 {
    public static void main(String[] args) throws Exception {
        try {
            boolean modoIA = true;
            Lig4 jogo = new Lig4();
            jogo.inicializar(modoIA);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a execução do jogo: " + e.getMessage());
        }
    }
}
