
package net.glyphstone.quick.types.product

import java.text.SimpleDateFormat
import java.util.*


class ProductRecord {

    var productId: Int = 0

    var productDescription: String = ""

    var regularDisplayPrice: String = ""

    var regularCalculatorPrice: Float = 0.0f

    var promotionalDisplayPrice: String = ""

    var promotionalCalculatorPrice: Float = 0.0f

    var unitOfMeasure: String = ""

    var productSize: String = ""

    var taxRate: Float = 0.0f

    var isTaxable: Boolean = false

    var isPerWeight: Boolean = false

    var dateCreated: Date = Date()


    override fun toString(): String {
        var sdf = SimpleDateFormat("MM/dd/yyyy hh:mm:ss")

        return (
                "productId:................. ${productId}\n" +
                "productDescription:........ \"${productDescription}\" \n" +
                "productSize:............... \"${productSize}\" \n" ) +
                "isPerWeight:............... ${isPerWeight}\n" +
                "isTaxable:................. ${isTaxable}\n" +
                "unitOfMeasure:............. \"${unitOfMeasure}\"\n" +
                "taxRate:................... ${taxRate}\n" +
                "regularDisplayPrice:....... \"${regularDisplayPrice}\"\n" +
                "regularCalculatorPrice:.... ${regularCalculatorPrice}\n" +
                "promotionalDisplayPrice:... \"${promotionalDisplayPrice}\"\n" +
                "promotionalCalculatorPrice: ${promotionalCalculatorPrice}\n" +
                "dateCreated:............... ${sdf.format(dateCreated)}"


    }

}