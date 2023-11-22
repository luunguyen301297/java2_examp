package java2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : ad
 * @mailto : luunguyen301297@gmail.com
 * @created : 11/22/2023, Wednesday
 **/
public class DataManager {
  private static DataManager instance = null;
  Map<String, Customer> customerList;

  private DataManager() {
    customerList = new HashMap<>();
  }

  public synchronized static DataManager getInstance() {
    if (instance == null) {
      instance = new DataManager();
    }
    return instance;
  }

  public Map<String, Customer> getCustomerList() {
    return customerList;
  }
}
