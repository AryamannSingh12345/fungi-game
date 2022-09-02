package cards;

public class HenOfWoods extends Mushroom{
public HenOfWoods(CardType card){
super(card, "henofwoods");
flavourPoints = 3;
}
public int getSticksPerMushroom(){
sticksPerMushroom = 1;
return sticksPerMushroom;
}
}
