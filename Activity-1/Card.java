/* Author: Gloria Ngan
 * Card.java
 *
 * <code>Card</code> represents a playing card.
 */

public class Card {
  
  private String suit;     //String value that holds the suit of the card
  private String rank;     //String value that holds the rank of the card
  private int pointValue;  //int value that holds the point value
  
  //Constructor.
  public Card(String cardRank, String cardSuit, int cardPointValue) {
    suit = cardSuit;
    rank = cardRank;
    pointValue = cardPointValue;
  }
  
//Accessor method to return suit.
  public String suit() {
    return suit;
  }
  
//Accessor method to return rank.
  public String rank() {
    return rank;
  }
  
//Accessor method to return point value.
  public int pointValue() {
    return pointValue;
  }
  
  /** Compare this card with the argument.
    * Return true if the rank, suit, and 
    * point value of this card are equal 
    * to those of the argument; false 
    * otherwise.
    */
  public boolean matches(Card otherCard) {
    if(otherCard.suit().equals(this.suit()) && otherCard.rank().equals(this.rank()) && otherCard.pointValue() == this.pointValue())
      return true;
    else
      return false;
  }
  
  /**
   * Converts the rank, suit, and point value into a string in the format
   *     "[Rank] of [Suit] (point value = [PointValue])".
   */
  @Override
  public String toString() {
    return rank + " of " + suit + " (point value = " + pointValue + ")";
  }
}
