import java.io.*;
import java.util.*;

public class Main
{
    static int x,y;
    static ArrayList<Card> discard=new ArrayList();
    static Deck d = new Deck();
   public static void main(String args[]){
    d.shuffle();
    Scanner io = new Scanner(System.in);
    System.out.println("how many players?");
    int players =10;
    while(players>4)
    players = io.nextInt();
    Hand[] hands = new Hand[players];
    for(x=0;x<players;x++){
        hands[x]=new Hand();
    for(y=0;y<10;y++)
     hands[x].cards.add(d.deal());
    }
     for(x=0;x<players;x++)
      hands[x].sort();
    boolean winner = false;
    discard.add(d.deal());
    Ai[] ais=new Ai[players-1];
    for(x=0;x<players-1;x++){
     ais[x] = new Ai(hands[x+1]);
    }
    
    while(!winner){
        System.out.println(hands[0].toString());
        System.out.println("top discard:"+ discard.get(discard.size()-1));
    System.out.println("would you like to draw[1] or take the discard[2]");
    int choice = 3;
    while(!(choice==1||choice==2))
     choice =io.nextInt();
     
     if(choice==1)
      hands[0].cards.add(d.deal());
     else{
     hands[0].cards.add(discard.remove(discard.size()-1));
    }
    System.out.println(hands[0].toString());  
    choice=20;
    System.out.println("which card would you like to discard?");
    while(choice>hands[0].cards.size())
     choice=io.nextInt();
     discard.add(hands[0].cards.remove(choice));
     winner = hands[0].checkWin();
     if(winner){
        System.out.println("You win");
        break;
        }
     for(int q=0;x<players-1;x++){
        aiPlay(ais[q]);
        System.out.println(q);
        winner=ais[q].hnd.checkWin();
        if(winner){
         System.out.println("you lose");
         break;
        }
        }
        
    }
    
    
  }
  public static void aiPlay(Ai art){
    if(art.takeDiscard(discard.get(discard.size()-1)))
     art.hnd.cards.add(discard.get(discard.size()-1));
    else
     art.hnd.cards.add(d.deal());
    Card c = art.findDiscard();
    discard.add(c);
    for( x=0;x<art.hnd.cards.size();x++)
    if(art.hnd.cards.get(x).equals(c))
     art.hnd.cards.remove(art.hnd.cards.get(x));
    }
}
