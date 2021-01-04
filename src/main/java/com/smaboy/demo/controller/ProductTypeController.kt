package com.smaboy.demo.controller

import com.smaboy.demo.entity.Response
import com.smaboy.demo.service.ProductTypeService
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
class ProductTypeController {
    @Autowired
    lateinit var productTypeService: ProductTypeService

    @RequestMapping(value = ["/getProductTypeList"] , method = [RequestMethod.GET])
    fun getProductTypeList() = Response().apply {
        val list = productTypeService.selectValidList()
        if(list.isNullOrEmpty()){
            code = 201
            msg = "获取产品信息失败"
            data = null
        }else{
            code = 0
            msg = "获取产品信息成功"
            data = list
        }

    }


}