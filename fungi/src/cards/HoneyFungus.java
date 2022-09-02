package cards;

public class HoneyFungus extends Mushroom{
public HoneyFungus(CardType card){
super(card, "honeyfungus");
flavourPoints = 1;
}
public int getSticksPerMushroom(){
sticksPerMushroom = 1;
return sticksPerMushroom;
}
}
