package board;

import cards.*;
import java.util.*;
public class Hand implements Displayable{
private ArrayList<Card> handList = new ArrayList<>();
public void add(Card c){
handList.add(c);
}
public int size(){
return handList.size();
}
public Card getElementAt(int i){
return (Card)handList.get(i);
}
public Card removeElement(int i){
return handList.remove(i);
}
}
