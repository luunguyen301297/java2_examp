package java2;

import java2.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : ad
 * @mailto : luunguyen301297@gmail.com
 * @created : 11/21/2023, Tuesday
 **/
public class Main {
  public static void main(String[] args) {
    Map<String, Customer> customerList = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    int choose;

    do {
      showMenu();
      choose = Integer.parseInt(scanner.nextLine());
      switch (choose) {
        case 1:
          System.out.println("Enter number of customer need to add :");
          int n = Integer.parseInt(scanner.nextLine());
          int count = 0;
          for (int i = 0; i < n; i++) {
            Customer customer = new Customer();
            System.out.println("Enter customer " + (++count) + " info :");
            customer.inputInfo();

            Set<String> keys = customerList.keySet();
            for (String k : keys) {
              if (k.equalsIgnoreCase(customer.getName())) {
                System.err.println("Key exist");
                break;
              }
            }
            customerList.put(customer.getName(), customer);
          }
          break;
        case 2:
          Set<String> keys = customerList.keySet();
          System.out.println("Enter search key :");
          String findKeyStr = scanner.nextLine();
          count = 0;
          for (String k : keys) {
            if (findKeyStr.equalsIgnoreCase(k)) {
              if (customerList.get(k).getTell().isEmpty() && customerList.get(k).getTell() != null) {
                System.err.println("Customer nay k co so dien thoai");
              } else {
                System.out.println(customerList.get(k));
              }
              count++;
            }
          }
          if (count == 0) {
            System.err.println("Can't find customer with name : " + findKeyStr);
          }
          break;
        case 3:
          customerList.forEach((c, customer) -> System.out.println(customerList.get(c)));
          break;
        case 4:
          System.err.println("Exit !");
          break;
        default:
          System.err.println("Wrong key ! Try again !");
      }
    } while (choose != 4);
  }

  static void showMenu() {
    System.out.println("1. Add new customer");
    System.out.println("2. Find by name");
    System.out.println("3. Display all");
    System.out.println("4. Exit");
  }
}
