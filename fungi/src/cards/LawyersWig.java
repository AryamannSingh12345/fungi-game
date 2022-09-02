package cards;

public class LawyersWig extends Mushroom{
public LawyersWig(CardType card){
super(card, "lawyerswig");
flavourPoints = 2;
}
public int getSticksPerMushroom(){
sticksPerMushroom = 1;
return sticksPerMushroom;
}
}
