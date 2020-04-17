package com.smaboy.demo.controller

import com.smaboy.demo.entity.Product
import com.smaboy.demo.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * 类名: ProductController
 *
 * 类作用描述: java类作用描述
 *
 * 作者: liyongliang3
 *
 * 创建时间: 2020/4/17 3:50 下午
 *
 */
@RestController
@RequestMapping(value = ["/product/"])
class ProductController {
    @Autowired
    var productService: ProductService? = null

    /**
     *添加产品
     */
    @RequestMapping(value = ["addProduct"], method = [RequestMethod.POST])
    fun addProduct(product: Product): Int {
        return productService?.addProduct(product) ?: 0
    }

    /**
     *获取产品列表
     */
    @RequestMapping(value = ["getProductList"], method = [RequestMethod.POST])
    fun getProductList(): List<Product>? {
        return productService?.productList
    }
}