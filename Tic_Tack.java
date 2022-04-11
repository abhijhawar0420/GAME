package JAVA_PROJECTS;
import java.util.*;
import java.util.List;
import java.lang.*;
import java.io.*;
import java.lang.Runtime;
public class Tic_Tack {

   static ArrayList<Integer>player_pos=new ArrayList<Integer>();
   static ArrayList<Integer>cpu_pos=new ArrayList<Integer>();
   public static void main(String[] args) {
      char [][]board={  {' ','|',' ','|',' '},{'-','+','-','+','-'},
                        {' ','|',' ','|',' '},{'-','+','-','+','-'},
                        {' ','|',' ','|',' '},{'-','+','-','+','-'}};
      int c_pos,p_pos;
      while(true){
      Scanner S=new Scanner(System.in);
      System.out.println("Enter your Next Move (1-9) :");
      p_pos=S.nextInt();
      while(player_pos.contains(p_pos)||cpu_pos.contains(p_pos))
      {
         System.out.println(" Position taken ! Enter any Correct position ");
         p_pos=S.nextInt();
      }
      place(board,p_pos,"Player");
      String res = Winner();
      while(res.length()>0)
      {
         System.out.println(res);
         break;
      }
      Random r=new Random();
      c_pos=r.nextInt(9)+1;
      while(player_pos.contains(c_pos)||cpu_pos.contains(c_pos))
      {
         c_pos=r.nextInt(9)+1;
      }
      place(board,c_pos,"cpu");
      res=Winner();
      while(res.length()>0)
      {
         System.out.println(res);
         break;
      }
      display_board(board);
 /*     try  
{  
final String os = System.getProperty("os.name");  
if (os.contains("Windows"))  
{  
Runtime.getRuntime().exec("cls");  
}  
else  
{  
Runtime.getRuntime().exec("clear");  
}  
}  
catch (final Exception e)  
{  
   System.out.println("Taking Some Time");
}*/  
}  
}
   public static void display_board(char board[][])
   {
      for(int i=0;i<board.length-1;i++)
      { 
         for(int j=0;j<board.length-1;j++)
         {
            System.out.print(" "+board[i][j]+" ");
         }
         System.out.println();
      }
   }
   public static void place(char board[][],int n,String user)
   {
      char symbol=' ';
      if(user.equals("player")||user.equals("Player")||user.equals("PLAYER")||user.equals("players")||user.equals("PLAYERS"))
      {
         symbol='X';
         player_pos.add(n);
      }
      else if(user.equals("CPU")||user.equals("cpu")||user.equals("Cpu"))
      {
         symbol='O';
         cpu_pos.add(n);
      }
      switch(n)
      {
         case 1:
         board[0][0]=symbol;
         break;

         case 2:
         board[0][2]=symbol;
         break;

         case 3:
         board[0][4]=symbol;
         break;

         case 4:
         board[2][0]=symbol;
         break;

         case 5:
         board[2][2]=symbol;
         break;

         case 6:
         board[2][4]=symbol;
         break;

         case 7:
         board[4][0]=symbol;
         break;

         case 8:
         board[4][2]=symbol;
         break;

         case 9:
         board[4][4]=symbol;
         break;
         default:
         System.out.println("* INVALID INPUT * \n");
      }
   }
public static String Winner()
{
   List First_Row=Arrays.asList(1,2,3);
   List Mid_Row=Arrays.asList(4,5,6);
   List Last_Row=Arrays.asList(7,8,9);

   List First_col=Arrays.asList(1,4,7);
   List Mid_col=Arrays.asList(2,5,8);
   List Last_col=Arrays.asList(3,6,9);

   List Cross_1=Arrays.asList(1,5,9);
   List Cross_2=Arrays.asList(3,5,7);

   List<List> Win_cond=new ArrayList<List>();

   Win_cond.add(First_Row);
   Win_cond.add(Mid_Row);
   Win_cond.add(Last_Row);

   Win_cond.add(First_col);
   Win_cond.add(Mid_col);
   Win_cond.add(Last_col);

   Win_cond.add(Cross_1);
   Win_cond.add(Cross_2);

   for(List L : Win_cond)
   {
      if(player_pos.containsAll(L))
      {
         return " Congratulations You Win !! ";
      }
      else if(cpu_pos.containsAll(L))
      {
         return " Sorry You Lost !! ";
      }
      else if(player_pos.size() + cpu_pos.size()==9)
      {
         return " It's a Tie ! ";
      }
   }
   return " ";
}

}