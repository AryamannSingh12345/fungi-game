package cards;

import java.util.*;
public abstract class Card{
protected CardType type;
protected String cardName;

public Card(CardType type1, String cardName_){
type = type1;
cardName = cardName_;
}

public CardType getType(){
return type;
}

public String getName(){
return cardName;
}
}
