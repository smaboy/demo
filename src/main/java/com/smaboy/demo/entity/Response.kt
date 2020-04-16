package com.smaboy.demo.entity

/**
 * 类名: Response
 *
 * 类作用描述: java类作用描述
 *
 * 作者: liyongliang3
 *
 * 创建时间: 2020/4/16 7:04 下午
 *
 */
data class Response @JvmOverloads constructor(var code : Int = 0, var msg : String = "", var data : Any? = null)