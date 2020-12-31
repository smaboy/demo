package com.smaboy.demo.service;

import com.smaboy.demo.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类名: ProductService
 * <p>
 * 类作用描述: java类作用描述
 * <p>
 * 作者: liyongliang3
 * <p>
 * 创建时间: 2020/4/16 8:26 下午
 */
public interface ProductService {
    /**
     * 添加产品
     * @param product 产品
     * @return 返回值 >o 成功
     */
    int addProduct(Product product);

    /**
     * 获取所有产品列表
     * @return 产品列表
     */
    List<Product> getProductList();

    List<Product> getProductByKey(String productName);
    List<Product> getProductByCondition(String productName,int productType);
    int updateProduct(Product product);

    /**
     * 删除产品
     * @param productId 产品id
     * @return 返回值 >o 成功
     */
    int deleteProduct(int productId);

    /**
     * 通过产品号获取产品信息
     * @param productId 产品id
     * @return 产品信息
     */
    Product getProductDetailById(int productId);
}
