package cards;

public class Porcini extends Mushroom{
public Porcini(CardType card){
super(card, "porcini");
flavourPoints = 3;
}
public int getSticksPerMushroom(){
sticksPerMushroom = 3;
return sticksPerMushroom;
}
}
