import java.util.Scanner;


public class Jogo {
    private Tabuleiro board;
    boolean terminar = false;
    boolean ganhou = false;
    int[] jogada;
    int rodada=0;
    
    public Jogo(){
        board = new Tabuleiro();
        Jogar(board);
        jogada = new int[2];
    }
    
    public void Jogar(Tabuleiro board){
    	int x;
    	Scanner ler = new Scanner(System.in);
        do{
            rodada++;
            System.out.println("Rodada "+rodada);
            board.exibe();
            terminar = board.setPosicao();
            
            if(!terminar){
                board.abrirVizinhas();
                terminar = board.ganhou();
            }
            
        }while(!terminar);
        
        if(!board.ganhou()){
            System.out.println("Havia uma mina ! Voc� perdeu!");
            board.exibeMinas();
            System.out.println("deseja continuar 1 (sim) / 2 (n�o)");
            x = ler.nextInt();
            
            while((x < 1) || (x > 2)){
            System.out.println("fora do padr�o digite de novo:");
            System.out.println("deseja continuar 1 (sim) / 2 (n�o)");
            x = ler.nextInt();
            
            }
            
            if(x == 1 ){
            Jogo jogo = new Jogo();
            }
            else{
            	board.exibeMinas();
            	System.out.println("<<<<<<<<<<<<<<<<fim de jogo>>>>>>>>>>>>");}
            }
            else {
            System.out.println("Parab�ns, voc� deixou os 8 campos de minas livres em "+rodada+" rodadas");
            board.exibeMinas();
        }
    }
}