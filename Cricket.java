
import java.util.*;
public class Main{
  public static void main (String [] args){
  Scanner sc = new Scanner(System.in);
  int playedMatches = 0;
  int wonMatches = 0;
  int lostMatches = 0;
  int target = 23;
  String Container [] = {"Dot Ball","1","2","3","4","5","6","7","Bowled Out","LBW","Catch Out","Stamped Out"};
  String outGen = "Bowled Out, LBW, Catch Out, Stamped Out";
  System.out.println("Please, write down your name.");
  String Player1 = sc.nextLine();
  System.out.println("\nPress 1 to play.\nPress 2 to exit");
  while(sc.nextInt()!=2){
    playedMatches++;
    System.out.println("Welcome, you are gonna have a great experience of cricket. :D");
    System.out.println("Congratulations, you are ready for playing the game!");
    target = TargetGenerate(target);
    System.out.println("You have to chase "+target+" runs within 8 overs.");
    int wicket = 0;
    int runs = 0;
    int balls = 0;
    double overs = 0.0;
    int mem = target-1;
    while(wicket !=10 && runs <= target && overs <= 8.0){
        System.out.println("Enter any Integer from 1-1000");
        int a = sc.nextInt();
        String batting = Container[IndexModifier(++a,++mem)];
        if(outGen.contains(batting)) {
          System.out.println(batting+"!!!!!\nYou have lost one more wicket!!! :(");
          wicket++;
        }
        else if(batting.compareTo("Dot Ball")==0) {
          System.out.println("Its a dot ball!!!!");
        }
        else{
          System.out.println(batting+" run(s) have been added on the score board!!!!");
           runs+=Integer.parseInt(batting);
        }
        balls++;
        overs+=.1;
        if(balls==6){
           overs+=.4;
           balls=0;
        }
        System.out.printf("Scoreboard : %d/%d %.1f overs!!!\n\n",runs,wicket,overs);
    }
    if(runs > target) {
      System.out.println("Match No. "+playedMatches+"\n Won by "+(10-wicket)+" wickets!!");
      wonMatches++;
    }
    else if(runs==target) System.out.println("Match No. "+playedMatches+" Its a Tie.");
    else {
      System.out.println("Match No. "+playedMatches+"\n Lost by "+(target-runs)+" runs!!");
      lostMatches++;
  }
    System.out.println("\nPress 1 to play.\nPress 2 to exit");
}

System.out.println("Congratulations "+Player1+" !!!");
System.out.println("You have played "+playedMatches+" mathces.");
System.out.println("You have won "+wonMatches+" match(es) and lost "+lostMatches+" match(es).");
}

static int TargetGenerate(int sum){
  for(int i=1;i<97;i++) sum+=7;
  sum=sum%100;
  if(sum<50) sum+=50;
  return sum;
}

static int IndexModifier(int t,int target){
  int m=13;
  for(int i=1;i<=97;i++) t=t+m+++m+++m++;
  t=(target+t+++m+++3*4+7*8+9*7+6*t+5*7)%12;
  return t;
}
}
