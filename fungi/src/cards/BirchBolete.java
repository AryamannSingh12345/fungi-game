package cards;

public class BirchBolete extends Mushroom{
public BirchBolete(CardType card){
super(card, "birchbolete");
flavourPoints = 3;
}
public int getSticksPerMushroom(){
sticksPerMushroom = 2;
return sticksPerMushroom;
}
}
