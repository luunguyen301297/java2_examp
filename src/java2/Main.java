package java2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : ad
 * @mailto : luunguyen301297@gmail.com
 * @created : 11/21/2023, Tuesday
 **/
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choose;

    do {
      MenuController.getInstance().showMenu();
      choose = Integer.parseInt(scanner.nextLine());
      switch (choose) {
        case 1:
          MenuController.getInstance().addNewCustomer();
          break;
        case 2:
          MenuController.getInstance().findByName();
          break;
        case 3:
          MenuController.getInstance().displayAll();
          break;
        case 4:
          System.err.println("Exit !");
          break;
        default:
          System.err.println("Wrong key ! Try again !");
      }
    } while (choose != 4);
  }
}
