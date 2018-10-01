import java.util.ArrayList; 
public class Deck
{
    public ArrayList<Card> cards = new ArrayList();
    private int[] values={14,2,3,4,5,6,7,8,9,10,11,12,13};
    private String[] suits={"hearts","diamonds","clubs","spades"};
    private String[] ranks={"Ace","two","three","four","five","six","seven","eight","nine","ten","jack","queen","king"};
    public Deck()
    {
        for(int x=0;x<13;x++)
        for(String y:suits)
         cards.add(new Card(values[x],y,ranks[x]));
    }
    public void shuffle(){
    for(int x=0;x<cards.size();x++){
     int c= cards.size()-1- (int)(Math.random()*(cards.size()-x));
     Card temp = cards.set(x,cards.get(c));
     cards.set(c,temp);
    }
    }
    public Card deal(){
     return cards.remove(cards.size()-1);
    }
    public void reset(ArrayList<Card> l){
    for(Card c:l)
     cards.add(c);
     shuffle();
    }
   
}
