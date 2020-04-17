package com.smaboy.demo.mapper;

import com.smaboy.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类名: ProductMapper
 * <p>
 * 类作用描述: java类作用描述
 * <p>
 * 作者: liyongliang3
 * <p>
 * 创建时间: 2020/4/16 8:30 下午
 */
@Mapper
@Repository
public interface ProductMapper {
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
}
