package com.smaboy.demo.controller

import com.smaboy.demo.entity.Product
import com.smaboy.demo.entity.Response
import com.smaboy.demo.service.ProductService
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import tk.mybatis.mapper.entity.Example

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
            val productTemp = Product(productName = productName,productPrice = productPrice,productType = productType,productImg = productImg,productDes = productDes)
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

    /**
     * 模糊查询，获取产品列表
     */
    @RequestMapping(value = ["/getProductListByKey"] , method = [RequestMethod.POST])
    fun getProductListByKey(@RequestParam(value = "productName" , required = false) productName: String): Response {
        val response = Response()
        if (productName.isEmpty()){
            response.code = 202
            response.msg = "查询的产品名称不能为空，请设置后重新查询"
            response.data = null
            return response
        }
        val productList : List<Product>? = productService?.getProductByKey(productName)
        setResultData(productList, response)
        return response
    }

    /**
     * 模糊查询，获取产品列表
     */
    @RequestMapping(value = ["/getProductByCondition"] , method = [RequestMethod.POST])
    fun getProductByCondition(@RequestParam(value = "productName" , required = false) productName: String? ,
                              @RequestParam productType: Int): Response {
        val response = Response()
        val productList : List<Product>? = productService?.getProductByCondition(productName , productType)
        setResultData(productList, response)

        return response
    }

    /**
     * 处理列表数据
     */
    private fun setResultData(productList: List<Product>?, response: Response) {
        if (productList.isNullOrEmpty()) {
            response.code = 201
            response.msg = "获取数据失败"
            response.data = productList
        } else {
            response.code = 0
            response.msg = "获取数据成功"
            response.data = productList
        }
    }

    /**
     * 更新产品
     */
    @RequestMapping(value = ["/updateProduct"], method = [RequestMethod.POST])
    fun updateProduct(@RequestBody product: Product): Response? {
        val response = Response()
        val productId = product.productId
        val count = productService?.updateProduct(product)?:0
        if (productId != 0){
            if (count >0){
                response.code = 0
                response.msg = "产品数据更新成功"
                response.data = product
            }else{
                response.code = 201
                response.msg = "产品数据更新失败"
                response.data = null
            }
        }else{
            response.code = 202
            response.msg = "请输入产品id"
            response.data = null
        }


        return response
    }

    /**
     * 删除产品
     */
    @RequestMapping(value = ["/deleteProduct"] , method = [RequestMethod.POST])
    fun deleteProduct(productId: Int): Response {
        val response = Response()
        val count = productService?.deleteProduct(productId)?:0
        if (productId != 0){
            if (count >0){
                response.code = 0
                response.msg = "删除产品数据成功"
                response.data = null
            }else{
                response.code = 201
                response.msg = "删除产品数据失败"
                response.data = null
            }
        }else{
            response.code = 202
            response.msg = "请输入产品id"
            response.data = null
        }
        return response
    }

    @RequestMapping(value = ["/getProductDetailById"] , method = [RequestMethod.POST])
    fun getProductDetailById(@RequestParam productId: Int) = Response().apply {
        val product = productService?.getProductDetailById(productId)
        if(product == null){
            code = 201
            msg = "获取产品信息失败"
            data = null
        }else{
            code = 0
            msg = "获取产品信息成功"
            data = product
        }
        
    }


    @RequestMapping(value = ["/statisticProductNum"],method = [RequestMethod.GET])
    fun statisticProductNum() = Response().apply {
        val resList = productService?.statisticProductNum()
        if(resList == null){
            code = 201
            msg = "获取产品信息失败"
            data = null
        }else{
            code = 0
            msg = "获取产品信息成功"
            data = resList
        }
    }

}