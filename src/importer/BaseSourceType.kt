package net.glyphstone.quick.importer

import kotlin.reflect.KMutableProperty0

abstract class BaseSourceType {
    fun loadString( prop: KMutableProperty0<String>, data: String, startIndex: Int, endIndexIncl: Int, trim: Boolean = false) {
        var strValue: String = data.subSequence(startIndex, endIndexIncl + 1).toString()
        if( trim) {
            strValue = strValue.trim()
        }
        prop.set(strValue)
    }

    fun loadNumber( prop: KMutableProperty0<Int>,  data: String, startIndex: Int, endIndexIncl: Int) {
        var strValue: String = data.subSequence(startIndex, endIndexIncl + 1).toString()
        val intValue: Int = strValue.toInt()
        prop.set(intValue)
    }

    fun loadCurrency( prop: KMutableProperty0<Float>, data: String, startIndex: Int, endIndexIncl: Int) {
        var strValue: String = data.subSequence(startIndex, endIndexIncl + 1).toString()
        var currencyValue: Float = strValue.toInt() / 100.0f
        prop.set(currencyValue)
    }

    fun loadFlags( prop: KMutableProperty0<BooleanArray>, data: String, startIndex: Int, endIndexIncl: Int) {
        var strValue: String = data.subSequence(startIndex, endIndexIncl + 1).toString()
      
        var bval: BooleanArray = BooleanArray(9)
        strValue.forEachIndexed{ ix, it ->
            bval.set(ix, (it == 'Y'))
        }
        prop.set(bval)
    }
}