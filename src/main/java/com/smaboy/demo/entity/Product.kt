package com.smaboy.demo.entity

/**
 * 产品实体类
 */
data class Product @JvmOverloads constructor(var productId : Int = 0 ,var productName : String , var productPrice : Double , var productType : Int , var productImg : String? = "", var productDes : String? = "")