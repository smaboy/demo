package com.smaboy.demo.mapper


import com.smaboy.demo.entity.ProductType
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository


/**
 * 类名: ProductTypeMapper
 *
 * 类作用描述: java类作用描述
 *
 * 作者: liyongliang3
 *
 * 创建时间: 2021/1/4 10:06 上午
 *
 */
@Mapper
@Repository
interface ProductTypeMapper {
    fun getProductTypeList():List<ProductType>
}