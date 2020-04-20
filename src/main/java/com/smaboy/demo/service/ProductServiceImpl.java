package com.smaboy.demo.service;

import com.smaboy.demo.entity.Product;
import com.smaboy.demo.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名: ProductServiceImpl
 * <p>
 * 类作用描述: java类作用描述
 * <p>
 * 作者: liyongliang3
 * <p>
 * 创建时间: 2020/4/16 8:29 下午
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public List<Product> getProductList() {
        return productMapper.getProductList();
    }

    @Override
    public List<Product> getProductByKey(String productName) {
        return productMapper.getProductListByKey(productName);
    }

    @Override
    public List<Product> getProductByCondition(String productName, int productType) {
        return productMapper.getProductByCondition(productName,productType);
    }

    @Override
    public int updateProduct(Product product) {

        return productMapper.updateProduct(product);
    }
}
