
public class Card {
    public Card(int val, String s, String r)
    {
     value = val;
     suit = s;
     rank = r;
     name = makeName();
     
    }
    public boolean oneOff(Card c){
     if(c.suit==suit&&(c.value-1==value))
      return true;
     return false;
    }
    public boolean compareNums(Card c){
    if(c.value==value)
    return true; 
    return false;
    }
    private String makeName(){
    return ""+rank+" of "+suit;
    }
    public String toString(){
    return name;
    }
    
    public int value;
    public String suit, rank, name;
}
