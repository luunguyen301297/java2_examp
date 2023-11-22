package java2;

import java.util.Scanner;

/**
 * @author : ad
 * @mailto : luunguyen301297@gmail.com
 * @created : 11/21/2023, Tuesday
 **/
public class Customer implements IKeyMap{
  private int autoIncrement;
  private int id;
  private String name, email, tell;

  public Customer() {
  }

  public Customer(String name, String email, String tell) {
    this.name = name;
    this.email = email;
    this.tell = tell;
    this.id = ++autoIncrement;
  }

  public void inputInfo() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter name :");
    while (true) {
      if (setName(scanner.nextLine())) {
        break;
      }
    }

    System.out.println("Enter email :");
    while (true) {
      if (setEmail(scanner.nextLine()))
        break;
    }

    System.out.println("Enter tell :");
    while (true) {
      if (setTell(scanner.nextLine()))
        break;
    }
  }

  public String getName() {
    return name;
  }

  public boolean setName(String name) {
    if (name != "" && name.matches("^[a-zA-Z]")) {
      this.name = name;
      boolean isExist = MenuController.getInstance().checkExist(
        DataManager.getInstance().getCustomerList().keySet(), getName());
      if(isExist) {
        System.err.println("Key name already exists, try again !");
        return false;
      } else {
        return true;
      }
    } else {
      System.err.println("Incorrect name format");
      System.out.println("Try again :");
      return false;
    }
  }

  public String getEmail() {
    return email;
  }

  public boolean setEmail(String email) {
    if (email != "" && email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
      this.email = email;
      return true;
    } else {
      System.err.println("Incorrect email format");
      System.out.println("Try again :");
      return false;
    }
  }

  public String getTell() {
    return tell;
  }

  public boolean setTell(String tell) {
    if (tell != null && tell.length() == 7 && tell.matches("[0-9]+")) {
      this.tell = tell;
      return true;
    } else {
      System.err.println("The phone number must have 7 digits !");
      System.out.println("Try again :");
      return false;
    }
  }

  @Override
  public String toString() {
    return "Customer{" +
      "name='" + name + '\'' +
      ", email='" + email + '\'' +
      ", tell='" + tell + '\'' +
      '}';
  }

  @Override
  public String getKeyValue() {
    return name;
  }
}
