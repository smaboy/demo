package com.smaboy.demo.service

import com.smaboy.demo.entity.ProductType
import com.smaboy.demo.mapper.ProductTypeMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import tk.mybatis.mapper.entity.Example

/**
 * 类名: ProductTypeServiceImpl
 *
 * 类作用描述: java类作用描述
 *
 * 作者: liyongliang3
 *
 * 创建时间: 2021/1/4 10:14 上午
 *
 */
@Service
class ProductTypeServiceImpl : ProductTypeService {

    @Autowired
    lateinit var mapper : ProductTypeMapper
    override fun selectValidList(): List<ProductType> {
        return mapper.getProductTypeList()
    }

}