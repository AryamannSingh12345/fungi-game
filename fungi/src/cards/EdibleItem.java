package cards;

import java.util.*;
public abstract class EdibleItem extends Card{
protected int flavourPoints;

public EdibleItem(CardType c1, String name){
super(c1, name);
}
public int getFlavourPoints(){
return flavourPoints;
}
}
