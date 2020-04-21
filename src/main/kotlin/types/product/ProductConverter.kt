package net.glyphstone.quick.types.product
import net.glyphstone.quick.importer.SourceProduct

class ProductConverter {
    val FLAGS_ISPERWEIGHT = 2
    val FLAGS_ISTAXABLE = 4
    val DEFAULT_TAX = 0.07775f

    fun convertAll( inputs: List<SourceProduct>): List<ProductRecord> {
        var records: MutableList<ProductRecord> = ArrayList()
        inputs.forEach{ records.add(convert(it))}
        return records
    }

    fun convert( input: SourceProduct ) : ProductRecord {
        var record = ProductRecord()
        record.productId = input.productId
        record.productDescription = input.productDescription
        record.productSize = input.productSize
        record.isPerWeight = input.flags[FLAGS_ISPERWEIGHT]
        record.isTaxable = input.flags[FLAGS_ISTAXABLE]
        record.unitOfMeasure = if( record.isPerWeight) { "Pound" } else { "Each" }
        record.taxRate = if( record.isTaxable){ DEFAULT_TAX } else { 0.0f }
        var regularPrice: Float = input.regularSinglePrice
        var calcRegularPrice = regularPrice
        var regularPricePrefix = ""
        if( input.regularForX > 0 && input.regularSplitPrice > 0.0f ) {
            regularPrice = input.regularSplitPrice
            calcRegularPrice = input.regularSplitPrice / input.regularForX
            regularPricePrefix = "${input.regularForX} for "
        }
        record.regularDisplayPrice = "$regularPricePrefix\$${"%.2f".format(regularPrice)}"
        record.regularCalculatorPrice = calcRegularPrice

        var promotionalPrice: Float = input.promotionalSinglePrice
        var calcPromotionalPrice = promotionalPrice
        if( promotionalPrice > 0.0f ) {
            var promotionalPricePrefix = ""
            if( input.promotionalForX > 0 && input.promotionalSplitPrice > 0.0f ) {
                promotionalPrice = input.promotionalSplitPrice
                calcPromotionalPrice = input.promotionalSplitPrice / input.promotionalForX
                promotionalPricePrefix = "${input.promotionalForX} for "
            }

            record.promotionalDisplayPrice = "$promotionalPricePrefix\$${"%.2f".format(promotionalPrice)}"
            record.promotionalCalculatorPrice = calcPromotionalPrice
        }
        return record
    }
}