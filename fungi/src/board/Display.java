package board;

import java.util.*;
import cards.*;
public class Display implements Displayable{
private ArrayList<Card> displayList = new ArrayList<>();

public void add(Card c){
displayList.add(c);
}
public int size(){
return displayList.size();
}
public Card getElementAt(int i){
return (Card)displayList.get(i);
}
public Card removeElement(int i){
return displayList.remove(i);
}
}
