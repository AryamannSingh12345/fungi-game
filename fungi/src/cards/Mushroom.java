package cards;

import java.util.*;
public abstract class Mushroom extends EdibleItem{
protected int sticksPerMushroom;

public Mushroom(CardType c1, String name){
super(c1, name);
}

public int getSticksPerMushroom(){
return sticksPerMushroom;
}
}
