package board;

import cards.Card;
import cards.CardType;
import cards.EdibleItem;
import cards.*;
import java.util.*;
public class Player {
  private Hand h = new Hand();
  private Display d = new Display();
  private int score, handlimit, sticks;

  public Player() {
    score = 0;
    handlimit = 8;
    sticks = 0;
    d.add(new Pan());
  }
  public int getScore() {
    return score;
  }
  public int getHandLimit() {
    return handlimit;
  }
  public int getStickNumber() {
    return sticks;
  }
  public void addSticks(int i) {
    sticks = sticks + i;
for(int i1 = 0; i1<i; i1++){
addCardtoDisplay(new Stick());
}
  }
  public void removeSticks(int i) {
    sticks = sticks - i;
for(int i1 = 0; i1<i; i1++){
if(d.getElementAt(i1).getName().equals("stick")){
d.removeElement(i1);
}
}
  }
  public Hand getHand() {
    return h;
  }
  public Display getDisplay() {
    return d;
  }
  public void addCardtoHand(Card c) {
if(c.getType() == CardType.BASKET){
addCardtoDisplay(c);
handlimit += 2;
}else{
    h.add(c);
  }}
  public void addCardtoDisplay(Card c) {
    d.add(c);
  }
  public boolean takeCardFromTheForest(int i) {
    CardList forest = Board.getForest();
    int sticksUsed = 0;
    int check = 0;
for(int i1 = 0; i1<d.size(); i1++){
if(d.getElementAt(i1).getType() == CardType.STICK){
++check;
}
}
for(int i2 = 0; i2<sticks - check ; i2++){
d.add(new Stick());
}
check = sticks;
//System.out.println("Hello");
      if (forest.getElementAt(i-1).getType() != CardType.BASKET) {
//System.out.println("Hello");
if(getHand().size() < handlimit && i >= 1 && i <= 8 ){
//System.out.println("Hello");
        if (i > 2 && i <= 8) {
          if (sticks >= i - 2) {
            addCardtoHand(forest.getElementAt(i-1));
            forest.removeCardAt(i);
            sticks = sticks - (i - 2);
            sticksUsed = (i - 2);
//System.out.println(sticks);
            while (sticksUsed > 0) {
//System.out.println(d.size());
              for (int j = 0; j < d.size(); j++) {
//System.out.println(d.getElementAt(j).getName());
                if (d.getElementAt(j).getName() == "stick") {
                  d.removeElement(j);
                  sticksUsed = sticksUsed - 1;
//System.out.println(sticksUsed
//);
                  break;
                }
              }
            }
            return true;
          } else {
            return false;
          }
        } else {
          addCardtoHand(forest.getElementAt(i-1));
          forest.removeCardAt(i);
          return true;
        }}else {return false;}
      } else if(getHand().size() < handlimit + 2 && i >=1  && i <= 8 && forest.getElementAt(i-1).getType() == CardType.BASKET){
        if (i > 2 && i <= 8) {
          if (sticks >= i - 2) {
            addCardtoDisplay(forest.getElementAt(i-1));
    handlimit = handlimit + 2;
            forest.removeCardAt(i);
            sticks = sticks - (i - 2);
            sticksUsed = (i - 2);
//System.out.println(sticks);
            while (sticksUsed > 0) {
//System.out.println(d.size());
              for (int j = 0; j < d.size(); j++) {
//System.out.println(d.getElementAt(j).getName());
                if (d.getElementAt(j).getName() == "stick") {
                  d.removeElement(j);
                  sticksUsed = sticksUsed - 1;
//System.out.println(sticksUsed
//);
                  break;
                }
              }
            }
            return true;
          } else {
            return false;
          }
        } else {
          addCardtoDisplay(forest.getElementAt(i-1));
handlimit = handlimit + 2;
          forest.removeCardAt(i);
          return true;
        }}else {return false;}





}
  public boolean takeFromDecay() {
    int cardBasket = 0;
    ArrayList < Card > decayPile = Board.getDecayPile();
    for (int i = 0; i < decayPile.size(); i++) {
      if (decayPile.get(i).getType() == CardType.BASKET) {
        ++cardBasket;
      }
    }
    if (h.size() + decayPile.size() - cardBasket <= handlimit + cardBasket * 2) {
      for (Card c: decayPile) {
        if (c.getType() == CardType.BASKET) {
          addCardtoDisplay(c);
          handlimit = handlimit + 2;

        } else {
          addCardtoHand(c);

        }
      } decayPile.clear();
      return true;
    } else {
      return false;
    }
  }
  public boolean cookMushrooms(ArrayList < Card > c1) {
    ArrayList < Mushroom > mushrooms = new ArrayList < > ();
    ArrayList < Mushroom > similarMushrooms = new ArrayList < > ();
    ArrayList < Mushroom > dayMushrooms = new ArrayList < > ();
    ArrayList < Mushroom > nightMushrooms = new ArrayList < > ();
    ArrayList < Mushroom > similarDayMushrooms = new ArrayList < > ();
    ArrayList < Mushroom > similarNightMushrooms = new ArrayList < > ();
    ArrayList < Butter > butter = new ArrayList < > ();
    ArrayList < Cider > cider = new ArrayList < > ();
int c_ = 0;

    boolean inDisplayList = false, pan = false;
    for (Card card: c1) {
      if (card.getType() == CardType.DAYMUSHROOM || card.getType() == CardType.NIGHTMUSHROOM) {
++c_;
        if (card.getType() == CardType.NIGHTMUSHROOM) {
          mushrooms.add((Mushroom) card);
          nightMushrooms.add((Mushroom) card);
        } else {
          mushrooms.add((Mushroom) card);
          dayMushrooms.add((Mushroom) card);
        }
      } else if (card.getType() == CardType.BUTTER) {
++c_;
        butter.add((Butter) card);
      } else if (card.getType() == CardType.CIDER) {
++c_;
        cider.add((Cider) card);
      } else if (card.getType() == CardType.PAN) {
++c_;
        pan = true;
      } else if(card.getType() == CardType.BASKET){
++c_;
/*addCardtoDisplay(card);
handlimit = handlimit + 2;*/
return false;
} 
else {
        return false;
      }
    }

for(Mushroom c__ : mushrooms){
for(Mushroom c___ : mushrooms){
if(!c__.getName().equals(c___.getName())){return false;}
}
}
//System.out.println("Here");
    if (pan == false) {
      for (int i = 0; i < d.size(); i++) {
        if (d.getElementAt(i).getType() == CardType.PAN) {
          pan = true;
          inDisplayList = true;
          break;
        }
      }
    }
    if (pan == false) {
      return false;
    }
    for (Mushroom c: mushrooms) {
      for (Mushroom c_dash: mushrooms) {
        if (c.getName().equals(c_dash.getName())) {
          similarMushrooms.add((Mushroom) c_dash);
          if (c_dash.getType() == CardType.NIGHTMUSHROOM) {
            similarNightMushrooms.add((Mushroom) c_dash);
          } else {
            similarDayMushrooms.add((Mushroom) c_dash);
          }
        }
      }
      if (similarMushrooms.size() + similarNightMushrooms.size() > 2 && (similarMushrooms.size() + similarNightMushrooms.size() >= 5 * cider.size() + 4 * butter.size()) && pan) {
        Mushroom c11 = similarMushrooms.get(0);
        CardType test = c11.getType();
        score = c11.getFlavourPoints() * (similarMushrooms.size() + similarNightMushrooms.size()) + 5 * cider.size() + 3 * butter.size();
        for (int i = 0; i < similarNightMushrooms.size(); i++) {
          Card c_dash = similarNightMushrooms.get(0);
          for (int j = 0; i < h.size(); i++) {
            if (h.getElementAt(i).getName().equals(c_dash.getName()) && h.getElementAt(i).getType() == CardType.NIGHTMUSHROOM) {
              h.removeElement(i);
              break;
            }
          }
        }
        for (int i = 0; i < similarDayMushrooms.size(); i++) {
          Card c_dash = similarDayMushrooms.get(0);
          for (int j = 0; i < h.size(); i++) {
            if (h.getElementAt(i).getName().equals(c_dash.getName()) && h.getElementAt(i).getType() == CardType.DAYMUSHROOM) {
              h.removeElement(i);
              break;
            }
          }
        }
        for (int i = 0; i < cider.size(); i++) {
          for (int j = 0; i < h.size(); i++) {
            if (h.getElementAt(i).getName().equals("cider") && h.getElementAt(i).getType() == CardType.CIDER) {
              h.removeElement(i);
              break;
            }
          }
        }
        for (int i = 0; i < butter.size(); i++) {
          for (int j = 0; i < h.size(); i++) {
            if (h.getElementAt(i).getName().equals("butter") && h.getElementAt(i).getType() == CardType.BUTTER) {
              h.removeElement(i);
              break;
            }
          }
        }
        if (pan && inDisplayList) {
          for (int i = 0; i < d.size(); i++) {
            if (d.getElementAt(i).getType() == CardType.PAN) {
              d.removeElement(i);
              return true;
            }
          }
        } else if (pan && !inDisplayList) {
          for (int i = 0; i < c1.size(); i++) {
            if (c1.get(i).getType() == CardType.PAN) {
              c1.remove(i);
              return true;
            }
          }
        } else {
          return false;
        }
      } else {
        return false;
      }
    }
    return false;
  }
  public boolean sellMushrooms(String s, int i) {
    String updatedString = "";
    int counter = 0;
    int sticksToBeUpdated = 0;
    int sameDayMushroom = 0;
    int sameNightMushroom = 0;
    s = s.trim();
    s = s.toLowerCase();
if(i<2){

return false;
}
    for (int i1 = 0; i1 < s.length(); i1++) {
      char c = s.charAt(i1);
      if (Character.isLetter(c)) {
        updatedString += Character.toString(c);
      }
    }
//System.out.println(h.size());
    for (int j = 0; j < h.size(); j++) {
//System.out.println(h.getElementAt(j).getName());
//System.out.println(updatedString);
//System.out.println(h.getElementAt(j).getName().equals(updatedString));


      if (h.getElementAt(j).getName().equals(updatedString)) {
        //System.out.println(10000);
        if (h.getElementAt(j).getType() == CardType.DAYMUSHROOM) {
          //System.out.println(20);
          ++counter;
        } else {
          counter += 2;
//System.out.println(534);

        }
        sticksToBeUpdated = ((Mushroom) h.getElementAt(j)).getSticksPerMushroom();
        //System.out.println(counter);
      }
    }
    for (int k = 0; k < h.size(); k++) {
      if (h.getElementAt(k).getName().equals(updatedString)) {
        if (h.getElementAt(k).getType() == CardType.NIGHTMUSHROOM) {
          sameNightMushroom = sameNightMushroom + 1;
        } else {
          sameDayMushroom = sameDayMushroom + 1;
        }
      }
    }
//System.out.println(sameNightMushroom);

    if (counter > 1 && counter >= i) {
      sticks = i * sticksToBeUpdated;
//System.out.println(sameNightMushroom);
      while (i > 0) {
//System.out.println(sticks);

        while (sameNightMushroom > 0 && i > 1 && i > 0) {
          for (int k = 0; k < h.size(); k++) {
            if (h.getElementAt(k).getName().equals(updatedString)) {
              if (h.getElementAt(k).getType() == CardType.NIGHTMUSHROOM) {

                //System.out.println(4);
                sameNightMushroom = sameNightMushroom - 1;
                h.removeElement(k);
                i -= 2;
                break;
              }
            }
          }
        } //System.out.println("Balle Balle");
//System.out.println(i);


        while (sameDayMushroom > 0 && i > 0) {
          for (int k = 0; k < h.size(); k++) {
            if (h.getElementAt(k).getName().equals(updatedString)) {
              if (h.getElementAt(k).getType() == CardType.DAYMUSHROOM) {

                //System.out.println(4);
                sameDayMushroom = sameDayMushroom - 1;
                h.removeElement(k);
                i -= 1;
                break;
              }
            }
          }

        }
      }

      for (int j = 0; j < sticks; j++) {
        addCardtoDisplay(new Stick());
      }
      return true;
    } else {
      return false;
    }
  }
  public boolean putPanDown() {
    for (int i = 0; i < h.size(); i++) {
      if (h.getElementAt(i).getType() == CardType.PAN) {
        addCardtoDisplay(h.getElementAt(i));
       // System.out.println(h.getElementAt(i).getType() == CardType.PAN);
        h.removeElement(i);
        return true;
      }
    }
    return false;
  }
}

