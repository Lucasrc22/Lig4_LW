import java.util.Random;

public class Lig4TurboMaluco extends Lig4{
    public enum Cor {
        AZUL, VERDE, VERMELHO, AMARELO, ROSA, LARANJA
    }

    private int nivelMaluquice;

    public Lig4TurboMaluco(boolean modoIA, int nivelMaluquice) {
        super(modoIA);
        this.nivelMaluquice = nivelMaluquice;
        
    }
    private Cor obterCorRandom(){
        Random random = new Random();
        int prob = random.nextInt(100);

        if(prob < nivelMaluquice){
            Cor[] cores = Cor.values();
            return cores[random.nextInt(cores.length)];
        }else{
            return Cor.valueOf(" " + jogadorAtual.getPeca());

        }
    }
    
}
