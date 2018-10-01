import java.util.*;
public class Hand
{
    public ArrayList<Card> cards=new ArrayList();
   // public ArrayList<Card> ready= new ArrayList();
    public Hand()
    {
        
    }
   
    public ArrayList<Card> findRun(){
     ArrayList<Card> inrun= new ArrayList();
     int y=1;
     for(int x=0;x<cards.size()-3;x++){
         y=1;
        while(x+y<cards.size()&&cards.get(x+(y-1)).oneOff(cards.get(x+y))){
            System.out.println(x);
          y++;
         System.out.println(y);
          if(y==3){
          inrun.add(cards.get(x));
          
          inrun.add(cards.get(x+1));
          inrun.add(cards.get(x+2));
         }
         if(y>3){
             System.out.println(x+y);
          inrun.add(cards.get(x+y-1));
        
        }
          
        }
    }
    //System.out.println(inrun);
        for(int x=0;x<inrun.size();x++){
            
     for(int z=x+1;z<inrun.size();z++){
         //boolean b=true;
      if(inrun.get(x)==inrun.get(z)) {
      inrun.remove(z);
      z--;
     }
     }

    }
    return inrun;
  }
    public ArrayList<Card> find3(){
        ArrayList<Card> c= new ArrayList();
        int y=1;
        int a=-1,b=-1;
    for(int x=0;x<cards.size();x++){
        y=1;
    for(int z=x+1;z<cards.size();z++){
        if(cards.get(x).compareNums(cards.get(z))&&cards.get(x).value!=a){
        y++;
        if(y==3){
        c.add(cards.get(x));
        //System.out.println(c.size());
        c.add(cards.get(b));
        //System.out.println(c.size());
        c.add(cards.get(z));
        cards.get(x).value=a;
        //System.out.println(c.size());
        } 
        b=z;
        if(y>=4)
        c.add(cards.get(z));
     }
    }
    }
    //System.out.println(c.size());
    
    return c;
   }
  
   public void sort(){
      // Card temp= new Card(500,"z","z");
      Card temp2;
       int t=0;
    for(int x=0;x<cards.size();x++){
        Card temp= new Card(500,"z","z");
    for(int y=x;y<cards.size();y++){
     if(cards.get(y).suit.compareTo(temp.suit)<0){
         temp=cards.get(y);
        t=y;
     }
     if(cards.get(y).suit.compareTo(temp.suit)==0&&cards.get(y).value<temp.value){
      temp=cards.get(y);
      t=y;
     }
    }
     temp2=cards.get(x);
     cards.set(x,temp);
     cards.set(t,temp2);
    }
    }
    public String toString(){
     String s="";
     for(int x=0;x<cards.size();x++)
      s+=" [" +x+"] " +cards.get(x).name+ "\n";
      return s;
    }
    public boolean checkWin(){
        Ai art = new Ai(this);
       art.findready();
       System.out.println(art.ready);
       if(art.ready.size()==10)
        return true;
       return false;
    }
}