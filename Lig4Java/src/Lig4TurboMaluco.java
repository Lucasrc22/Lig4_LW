public class Lig4TurboMaluco extends Lig4{
    public enum Cor {
        AZUL, VERDE, VERMELHO, AMARELO, ROSA, LARANJA
    }

    private int nivelMaluquice;

    public Lig4TurboMaluco(boolean modoIA, int nivelMaluquice) {
        super(modoIA);
        this.nivelMaluquice = nivelMaluquice;
        
    }
    
}
