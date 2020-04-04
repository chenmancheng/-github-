package soft.service;

import soft.pojo.Product;

import java.util.List;

public interface ProductService {
    Product getById(String name);
    //    Admin getBytel(String aName);
    boolean insert(Product bean);
    boolean update(Product bean);
    List<Product> getList();
    boolean delete(String name);
}
