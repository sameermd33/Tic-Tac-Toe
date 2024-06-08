import java.util.*;

class Game{
    int position;
    int [] visited = {0,0,0,0,0,0,0,0,0};
    int [] game = {0,0,0,0,0,0,0,0,0};
    int [][] P = {{0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
               };
                
    char user,user2,comp;
    String userName,user2Name;
    Scanner sc = new Scanner(System.in);
    
    public void setP(){
        P[1][0] = game[0];P[1][3] = game[1];P[1][6] = game[2];
        P[3][0] = game[3];P[3][3] = game[4];P[3][6] = game[5];
        P[5][0] = game[6];P[5][3] = game[7];P[5][6] = game[8];
        
    }
    
    public void aboutGame(){
        System.out.println("");
        System.out.println("ABOUT GAME & IT'S RULES: ");
        System.out.println("");
        System.out.println("Sameer's tic-tac-toe was designed by Mohammad Sameer");
        System.out.println("on 27th September 2022 using Java and its features.");
        System.out.println("");
        System.out.print("Tic-Tac-Toe is a simple and fun game for 2 players, X and O. It is played on a 3x3 grid. Each player's goal is to make 3 in a row.");
        System.out.println("Typically, X starts first, but in Gametable's Tabletop Tic Tac Toe, Player 1 starts first on the first game and Player 2 (or the computer) starts first on the next game. The starting player continues to alternate from game to game. This helps keep gameplay fair over time.");
        System.out.println("");
        System.out.print("Players take turns placing their Mark, X or O, on an open square in the grid. The first player to make 3 of their own mark in a row vertically, horizontally, or diagonally wins the game.");
        System.out.println("If all 9 squares are filled and neither player has 3 in a row, the game is considered a Tie.");
        System.out.println("");
    }
    
    public void takeInput(){
        System.out.print("Enter Player position: ");
        position = sc.nextInt();
            if(visited[position-1]==1){
                while(visited[position-1]==1){
                System.out.print("Enter Player position: ");
                position = sc.nextInt();
                }
            }
        visited[position-1] = 1;
        if(user=='X')game[position-1] = 1;
        else game[position-1] = 2;
    }
    
    public void takeInput2(){
        System.out.print("Enter Player2 position: ");
        position = sc.nextInt();
            if(visited[position-1]==1){
                while(visited[position-1]==1){
                System.out.print("Enter Player2 position: ");
                position = sc.nextInt();
                }
            }
        visited[position-1] = 1;
        if(user2=='X')game[position-1] = 1;
        else game[position-1] = 2;
    }    
    
    public void setUserName(){
        System.out.print("Enter Player name: ");
        userName = sc.nextLine();
    }
    
    public void setUser2Name(){
        System.out.print("Enter Player2 name: ");
        user2Name = sc.nextLine();
    }
    public void printScoreCard(String name){
        Random n = new Random();
        int a = n.nextInt(300);
        a+=1;
        System.out.println( " ________________________________________________");
        System.out.println("|"+name+"|"+a+"|"+new Date()+"|");
        System.out.println(" ________________________________________________");
    }
    
    public boolean isFilled(){
        for(int i=0;i<9;i++){
            if(visited[i]==0){
                return false;
            }
        }
        return true;
    }
    
    public void welcomeToGame(){
        System.out.println("--------------------WELCOME TO SAMEER'S TIC-TAC-TOE---------------------");
        try{
            System.out.print("Please wait");
            for(int i=0;i<3;i++){
                Thread.sleep(700);
                System.out.print(".");
            }
            System.out.println("");
            System.out.printf("Game is Loading");
            for(int i=0;i<10;i++){
                Thread.sleep(1000);
                System.out.print(".");
            }
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("");
    }
    
    public void itsCompTurn(){
        try{
            System.out.print("please wait");
            for(int i=0;i<3;i++){
                Thread.sleep(700);
                System.out.print(".");
            }
            System.out.println("");
            System.out.print("It is Computer's turn");
            for(int i=0;i<5;i++){
                Thread.sleep(900);
                System.out.print(".");
            }
            System.out.println("");
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("");
    }
    
    public void setUserSymbol(){
        System.out.print("Select Player Symbol: ");
        user = sc.next().charAt(0);
    }
    public void setUser2Symbol(){
        if(user=='X'){
            user2= 'O';
        }
        else{
            user2='X';
        }
    }
    
    public void setCompSymbol(){
        if(user == 'X'){
            comp = 'O';
        }
        else{
            comp = 'X';
        }
    }
    
    public void generateComp(){
        if( !isFilled()){
            Random rand = new Random();
            int num = 1 + rand.nextInt(9);
            if(visited[num-1]==1){
                while(visited[num-1]==1){
                num = 1 + rand.nextInt(9);
                }
            }
            visited[num-1]=1;
            if(user=='X')game[num-1] = 2;
            else game[num-1] = 1;
            System.out.println("Computer Selected position "+num+".");
        }
    }
    
     public boolean isGameOver()
     {
         if(isFilled()){
             System.out.println("DRAW");
             return true;
         }
         return false;
     }
     
     public int winOrLoose(){
        if(user=='X'){
         if((game[0]==1 && game[1]==1 &&game[2]==1) || (game[3]==1 && game[4]==1 && game[5]==1)|| (game[6]==1 && game[7]==1 && game[8]==1) || (game[0]==1 && game[4]==1 && game[8]==1)|| (game[2]==1 && game[4]==1 && game[6]==1) || (game[0]==1 && game[3]==1 && game[6]==1) || (game[1]==1 && game[4]==1 && game[7]==1) || (game[2]==1 && game[5]==1 && game[8]==1) ){
            return 1; 
         }
         else if((game[0]==2 && game[1]==2 &&game[2]==2) || (game[3]==2 && game[4]==2 && game[5]==2)|| (game[6]==2 && game[7]==2 && game[8]==2) || (game[0]==2 && game[4]==2 && game[8]==2)|| (game[2]==2 && game[4]==2 && game[6]==2) || (game[0]==2 && game[3]==2 && game[6]==2) || (game[1]==2 && game[4]==2 && game[7]==2) || (game[2]==2 && game[5]==2 && game[8]==2) ){
            return 2; 
         }
        }
       else{
          if((game[0]==2 && game[1]==2 &&game[2]==2) || (game[3]==2 && game[4]==2 && game[5]==2)|| (game[6]==2 && game[7]==2 && game[8]==2) || (game[0]==2 && game[4]==2 && game[8]==2)|| (game[2]==2 && game[4]==2 && game[6]==2) || (game[0]==2 && game[3]==2 && game[6]==2) || (game[1]==2 && game[4]==2 && game[7]==2) || (game[2]==2 && game[5]==2 && game[8]==2) ){
            return 1; 
         }
         else if((game[0]==1 && game[1]==1 &&game[2]==1) || (game[3]==1 && game[4]==1 && game[5]==1)|| (game[6]==1 && game[7]==1 && game[8]==1) || (game[0]==1 && game[4]==1 && game[8]==1)|| (game[2]==1 && game[4]==1 && game[6]==1) || (game[0]==1 && game[3]==1 && game[6]==1) || (game[1]==1 && game[4]==1 && game[7]==1) || (game[2]==1 && game[5]==1 && game[8]==1) ){
            return 2; 
         }
         
       }
      return 0;
     }
    
    public void printBox(){
        for(int i=0;i<7;i++){
            for(int j=0;j<10;j++){
                if(i%2==1 && j%3==0 && P[i][j]==1){
                    System.out.print("| X");
                }
                else if(i%2==1 && j%3==0 && P[i][j]==2){
                    System.out.print("| O");
                }
                else if(i%2==1 && j%3==0){
                    System.out.print("|  ");
                }
                else if(i%2==0 && j%3==0){
                    System.out.print("+");
                }
                else if(i%2==0){
                    System.out.print("-");
                }
            }
               System.out.println("");
        }
        System.out.println("");
    }
    
}

public class Main{
    void playWithComp(){
        Game player = new Game();
        player.setUserName();
        player.setUserSymbol();
        player.setCompSymbol();
        System.out.println("YOUR SYMBOL: "+player.user+"\nCOMPUTER'S SYMBOL: "+player.comp);
        player.printBox();
        while(!player.isGameOver()){
            player.takeInput();
            player.setP();
            player.printBox();
            if(player.winOrLoose()==1){
                System.out.println("You win!!");
                player.printScoreCard(player.userName);
                System.exit(0);
            }
            else if(player.winOrLoose()==2){
                System.out.println("You Loose!!");
                System.exit(0);
            }
            player.itsCompTurn();
            player.generateComp();
            player.setP();
            player.printBox();
            if(player.winOrLoose()==1){
                System.out.println("You win!!");
                player.printScoreCard(player.userName);
                System.exit(0);
            }
            else if(player.winOrLoose()==2){
                System.out.println("You Loose!!");
                System.exit(0);
            }
            
        }
    }
    
    void playWithUser2(){   
        Game player = new Game();
        player.setUserName();
        player.setUser2Name();
        player.setUserSymbol();
        player.setUser2Symbol();
        System.out.println("Player1 SYMBOL: "+player.user+"\nPlayer2 SYMBOL: "+player.user2);
        player.printBox();
        while(!player.isGameOver()){
            player.takeInput();
            player.setP();
            player.printBox();
            if(player.winOrLoose()==1){
                System.out.println("Player1 wins!!");
                player.printScoreCard(player.userName);
                System.exit(0);
            }
            else if(player.winOrLoose()==2){
                System.out.println("Player2 wins!!");
                player.printScoreCard(player.user2Name);
                System.exit(0);
            }
            player.takeInput2();
            player.setP();
            player.printBox();
            if(player.winOrLoose()==1){
                System.out.println("Player1 wins!!");
                player.printScoreCard(player.userName);
                System.exit(0);
            }
            else if(player.winOrLoose()==2){
                System.out.println("Player2 wins!!");
                player.printScoreCard(player.user2Name);
                System.exit(0);
            }
        
        }
    }
    public static void main(String[] args){
        Game g = new Game();
        g.welcomeToGame();
        g.aboutGame();
        Scanner sc = new Scanner(System.in);
        System.out.printf("Choose your game mode: \n1.play with computer\n2.player1 vs player2 \n>>");
        int choice = sc.nextInt();
        Main m = new Main();
        switch(choice){
            case 1: m.playWithComp();
                    break;
                        
            case 2: m.playWithUser2();
                    break;
        }
    }
}
