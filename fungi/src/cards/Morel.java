package cards;

public class Morel extends Mushroom{
public Morel(CardType card){
super(card, "morel");
flavourPoints = 6;
}
public int getSticksPerMushroom(){
sticksPerMushroom = 4;
return sticksPerMushroom;
}
}
