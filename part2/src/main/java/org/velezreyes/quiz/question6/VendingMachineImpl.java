package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine {
  private Map<String, Drink> drinks;
  private int balance;

  private static VendingMachineImpl instance = new VendingMachineImpl();

  private VendingMachineImpl() {
    drinks = new HashMap<>();
    initializeDrinks();
  }

  public static VendingMachine getInstance() {
    return instance;
  }

  @Override
  public void insertQuarter() {
    balance += 25;
  }

  @Override
  public Drink pressButton(String drinkName) throws NotEnoughMoneyException, UnknownDrinkException {
    Drink drink = drinks.get(drinkName);

    if (drink == null) {
      throw new UnknownDrinkException("Unknown drink: " + drinkName);
    }

    if (balance < drink.getPrice()) {
      throw new NotEnoughMoneyException("Not enough money for " + drinkName);
    }
    balance -= drink.getPrice();

    return drink;
  }
  private void initializeDrinks() {
    drinks.put("ScottCola", new ConcreteDrink("ScottCola", 75, true));
    drinks.put("KarenTea", new ConcreteDrink("KarenTea", 100, false));

  }

}
