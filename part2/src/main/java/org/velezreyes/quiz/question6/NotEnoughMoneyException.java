package org.velezreyes.quiz.question6;

public class NotEnoughMoneyException extends Exception {

  public NotEnoughMoneyException(String s) {
    super("Not enough money inserted.");
  }
  
}
