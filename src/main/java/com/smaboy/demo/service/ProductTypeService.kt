package com.smaboy.demo.service

import com.smaboy.demo.entity.ProductType

/**
 * 类名: ProductTypeService
 *
 * 类作用描述: java类作用描述
 *
 * 作者: liyongliang3
 *
 * 创建时间: 2021/1/4 10:13 上午
 *
 */
interface ProductTypeService {
    fun selectValidList(): List<ProductType>
}