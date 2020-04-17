package com.smaboy.demo.controller

import com.smaboy.demo.entity.Product
import com.smaboy.demo.entity.Response
import com.smaboy.demo.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

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
    fun addProduct(@RequestBody product: Map<String,String>): Response {
        val response = Response()
        //处理传过来的数据
        val productName : String? = product["productName"]
        val productPrice : Double = product["productPrice"]?.toDouble() ?: 0.0
        val productType : Int = product["productType"]?.toInt() ?: 0
        val productImg : String? = product["productImg"]
        val productDes : String? = product["productDes"]
        if (productName.isNullOrBlank()){
            response.code = 201
            response.msg = "添加产品失败，产品名不能为空！！"
            response.data = null
        }else{
            val productTemp = Product(productName,productPrice,productType,productImg,productDes)
            val code = productService?.addProduct(productTemp) ?: 0
            if (code > 0){
                response.code = 0
                response.msg = "添加产品成功"
                response.data = productTemp
            }else{
                response.code = 202
                response.msg = "添加产品失败"
                response.data = null
            }
        }

        return response

    }

    /**
     *获取产品列表
     */
    @RequestMapping(value = ["getProductList"], method = [RequestMethod.POST])
    fun getProductList(): Response {
        val response = Response()
        val productList : List<Product>? = productService?.productList
        if (productList.isNullOrEmpty()){
            //没有查询到数据
            response.code = 201
            response.msg = "没有查询到产品数据"
            response.data = null

        }else{
            response.code = 0
            response.msg = "产品列表查询成功"
            response.data = productList
        }
        return response
    }
}