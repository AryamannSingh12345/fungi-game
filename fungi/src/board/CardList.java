package board;

import cards.*;
import java.util.*;
public class CardList{
ArrayList<Card> cList = new ArrayList<>();

public CardList(){}

public void add(Card c1){
cList.add(0, c1);
}

public int size(){
return cList.size();
}

public Card getElementAt(int i){
return cList.get(i);
}

public Card removeCardAt(int i){
return cList.remove(8 - i);
}
}
