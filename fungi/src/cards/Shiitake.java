package cards;

public class Shiitake extends Mushroom{
public Shiitake(CardType card){
super(card, "shiitake");
flavourPoints = 2;
}
public int getSticksPerMushroom(){
sticksPerMushroom = 2;
return sticksPerMushroom;
}
}
