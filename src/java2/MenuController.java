package java2;

import java.util.Scanner;
import java.util.Set;

/**
 * @author : ad
 * @mailto : luunguyen301297@gmail.com
 * @created : 11/22/2023, Wednesday
 **/
public class MenuController {
  private static MenuController instance = null;

  private MenuController() {

  }

  public synchronized static MenuController getInstance() {
    if (instance == null) {
      instance = new MenuController();
    }
    return instance;
  }

  public void showMenu() {
    System.out.println("1. Add new customer");
    System.out.println("2. Find by name");
    System.out.println("3. Display all");
    System.out.println("4. Exit");
  }

  public void addNewCustomer() {
    while (true) {
      Customer customer = new Customer();
      customer.inputInfo();
      DataManager.getInstance().getCustomerList().put(customer.getName(), customer);
      if (!hasNext()) break;
    }
  }

  public void findByName() {
    Scanner scanner = new Scanner(System.in);
    Set<String> keys = DataManager.getInstance().getCustomerList().keySet();
    System.out.println("Enter search keyword :");
    String findKeywordStr = scanner.nextLine();
    int count = 0;
    for (String k : keys) {
      if (findKeywordStr.equalsIgnoreCase(k)) {
        if (DataManager.getInstance().getCustomerList().get(k).getTell().isEmpty() && DataManager.getInstance().getCustomerList().get(k).getTell() != null) {
          System.err.println("Found the customer but their phone number is not found !");
        } else {
          System.out.println(DataManager.getInstance().getCustomerList().get(k));
        }
        count++;
      }
    }
    if (count == 0) {
      System.err.println("Can't find customer with name : " + findKeywordStr);
    }
  }

  public void displayAll() {
    DataManager.getInstance().getCustomerList().forEach((c, customer)
      -> System.out.println(DataManager.getInstance().getCustomerList().get(c)));
  }

  public boolean hasNext() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Continue ? (Y/N) :");
    String option = scanner.nextLine();
    return !option.equalsIgnoreCase("N");
  }

  public boolean checkExist(Set<String> keys, String keyValue) {
    for (String k : keys) {
      if (keyValue.equalsIgnoreCase(k)) {
        return true;
      }
    }
    return false;
  }
}
