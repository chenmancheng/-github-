package soft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.mapper.ProductMapper;
import soft.pojo.Product;
import soft.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;


    @Override
    public Product getById(String name) {
        return productMapper.getById(name);
    }

    @Override
    public boolean insert(Product bean) {
        return productMapper.insert(bean);
    }

    @Override
    public boolean update(Product bean) {
        return productMapper.update(bean);
    }

    @Override
    public List<Product> getList() {
        return productMapper.getList();
    }

    @Override
    public boolean delete(String name) {
        return productMapper.delete(name);
    }
}
