import java.util.*;
class Main {
  public static void main(String[] args) {
    char board[][] = new char[3][3];
    for(int row=0;row<board.length;row++){
      for(int col=0;col<board[row].length;col++){
        board[row][col] = ' ';
      }
    }
    char player = 'X';
    boolean isnotwon = false;
    int moves = 0;
    while(!isnotwon){
      printboard(board);
      System.out.println("Player "+player+" : ");
      Scanner sc = new Scanner(System.in);
      int row = sc.nextInt();
      int col = sc.nextInt();
      System.out.println();
      if(board[row][col]==' '){
        board[row][col]=player;
        moves++;
        boolean check = checkforcondition(board,player);
        if(check){
          System.out.println("Player "+player+" Won");
          printboard(board);
          break;
        }else if(moves==9){
            System.out.println("Match is Drawn");
            printboard(board);
            break;
        }else{
          player=(player=='X')?'O':'X';
        }
     }else{
        System.out.println("invalid input please try again");
      }
    }
  }
  public static void printboard(char[][] board){
    for(int row=0;row<board.length;row++){
      for(int col=0;col<board[row].length;col++){
        System.out.print(board[row][col]+" | ");
      }
      System.out.println();
    }
  }
  public static boolean checkforcondition(char[][] board,char player){
    for(int row=0;row<board.length;row++){
      if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
        return true;
      }
    }
    for(int col=0;col<board.length;col++){
      if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
        return true;
      }
    }
    if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
      return true;
    }
    if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
      return true;
    }
    return false;
  }
}
