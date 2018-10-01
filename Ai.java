import java.util.*;
public class Ai
{
    public Hand hnd= new Hand();
    public ArrayList<Card> ready = new ArrayList();
    private int x,y;
    public boolean haspairs=false;
    public Ai(Hand h)
    {
        hnd=h;
    }
    public void findready(){
        System.out.println(hnd);
        boolean b=true;
        //System.out.println(hnd.findRun());
    for(Card c:hnd.find3())
     ready.add(c);
    for(Card c:hnd.findRun()){
     for(Card d:ready)
      if(c==d)
      b=false;
     if(b)   
     ready.add(c);
     
    }
     
    }
     public Card findDiscard(){
         boolean pair=false;
         haspairs=false;
        for(Card c:hnd.cards){
            pair = false;
         for(Card d:hnd.cards){
            if((c.oneOff(d)||d.oneOff(c)||c.compareNums(d))&&!c.equals(d))
             pair=true;
            }
            if(!pair)
            return c;
        }
        ArrayList<Card> l = new ArrayList();
        haspairs=true;
        for(Card c:hnd.cards)
          l.add(c);
          for(Card c:hnd.find3())
           l.remove(c);
        for(Card c:hnd.findRun())
         l.remove(c);
         return l.get(0);
        }
        public boolean takeDiscard(Card top){
            int z=0;
          for(Card c:hnd.cards)
          if(c.oneOff(top)||top.oneOff(c)||c.compareNums(top))
           z++;
           if(z<2||(z==2&&!haspairs))
           return true;
           return false;
        }
        
}
