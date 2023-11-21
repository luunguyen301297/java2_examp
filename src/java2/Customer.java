package java2;

import java.util.Scanner;

/**
 * @author : ad
 * @mailto : luunguyen301297@gmail.com
 * @created : 11/21/2023, Tuesday
 **/
public class Customer {
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
      if (setName(scanner.nextLine()))
        break;
    }
    System.out.println("Enter email :");
    email = scanner.nextLine();
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
    if (name != "" && name.matches("^[a-zA-Z]*$")) {
      this.name = name;
      return true;
    } else {
      System.err.println("Incorrect name format");
      System.out.println("Try again :");
      return false;
    }
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTell() {
    // TODO: đoạn này e comment để lúc nhập null vẫn nhận ạ :))
//    if (phoneNumber != null && phoneNumber.length() == 7 && phoneNumber.matches("[0-9]+")) {
//      this.phoneNumber = phoneNumber;
//      return true;
//    } else {
//      System.err.println("The phone number must have 7 digits !");
//      System.out.println("Try again :");
//      return false;
//    }
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
}
