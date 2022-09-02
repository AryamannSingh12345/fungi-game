package board;

import cards.*;
import java.util.*;
public class CardPile{

Stack<Card> cPile = new Stack<>();
public CardPile(){
}
public void addCard(Card a){
cPile.push(a);
}

public Card drawCard(){
return cPile.pop();
}

public void shufflePile(){
Collections.shuffle(cPile);
}

public int pileSize(){
return cPile.size();
}
public boolean isEmpty(){
return cPile.isEmpty();
}
}
