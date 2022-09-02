package cards;

public class Chanterelle extends Mushroom{
public Chanterelle(CardType card){
super(card, "chanterelle");
flavourPoints = 4;
}
public int getSticksPerMushroom(){
sticksPerMushroom = 2;
return sticksPerMushroom;
}
}
