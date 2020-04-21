package net.glyphstone.quick.importer

import java.io.File

class ProductLoader {

    fun load( inputFile: String ): List<SourceProduct> {
        var products: MutableList<SourceProduct> = ArrayList()
        File(inputFile).forEachLine { products.add( loadOne(it)) }
        return products

    }
    fun loadOne( data: String ) : SourceProduct {
        var product = SourceProduct()
        product.loadNumber( product::productId, data, 0, 7)
        product.loadString( product::productDescription, data, 9, 67, true)
        product.loadCurrency( product::regularSinglePrice, data, 69, 76)
        product.loadCurrency( product::promotionalSinglePrice, data, 78, 85)
        product.loadCurrency( product::regularSplitPrice, data, 87, 94 )
        product.loadCurrency( product::promotionalSplitPrice, data, 96, 103)
        product.loadNumber( product::regularForX, data, 105, 112)
        product.loadNumber( product::promotionalForX, data, 114, 121)
        product.loadFlags( product::flags, data, 123, 131 )
        product.loadString( product::productSize, data, 133, 141, true)
        return product
    }
}
