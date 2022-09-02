package cards;

public class TreeEar extends Mushroom{
public TreeEar(CardType card){
super(card, "treeear");
flavourPoints = 1;
}
public int getSticksPerMushroom(){
sticksPerMushroom = 2;
return sticksPerMushroom;
}
}
