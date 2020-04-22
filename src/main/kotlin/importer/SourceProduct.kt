package net.glyphstone.quick.importer


class SourceProduct : BaseSourceType() {

    var productId: Int = 0

    var productDescription: String = ""

    var regularSinglePrice: Float = 0.0f

    var promotionalSinglePrice: Float = 0.0f

    var regularSplitPrice: Float = 0.0f
    
    var promotionalSplitPrice: Float = 0.0f

    var regularForX: Int = 0

    var promotionalForX: Int = 0

    var flags: BooleanArray = booleanArrayOf()

    var productSize: String = ""

   override fun toString(): String {
       return (
       "productId:............. ${productId}\n" +
       "productDescription:.... \"${productDescription}\" \n" +
       "regularSinglePrice:.... ${regularSinglePrice} \n" +
       "promotionalSinglePrice: ${promotionalSinglePrice}\n" +
       "regularSplitPrice:..... ${regularSplitPrice}\n" +
       "promotionalSplitPrice:. ${promotionalSplitPrice}\n" +
       "regularForX:........... ${regularForX}\n" +
       "promotionalForX:....... ${promotionalForX}\n" +
       "flags:................. ${booleanArrayToString(flags)}\n" ) +
       "productSize:........... \"${productSize}\""
   }

   fun booleanArrayToString( barray: BooleanArray): String {
       var strout: String = ""
       barray.forEach{ strout += if( it) "T" else "F" }
       return strout
   }

}