package soft.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import soft.pojo.Product;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper {
    Product getById(String name);
//    Admin getBytel(String aName);
    boolean insert(Product bean);
    boolean update(Product bean);
    List<Product> getList();
    boolean delete(String name);
}
