package net.glyphstone.quick

import net.glyphstone.quick.importer.ProductLoader
import net.glyphstone.quick.types.product.ProductConverter

fun main(args: Array<String>){  
    println("Test import grocery products flat file and output List of standard ProductRecords.")

    var inputFileName: String = ""
    if( args.size >= 1 ) {
        inputFileName = args[args.size-1]
    } else {
        println("Input file required:  Ex: java -jar main.jar data/input.txt")
    }

    println("Input File: ${inputFileName}")
    var loader = ProductLoader()
    var sourceProducts = loader.load( inputFileName )

    sourceProducts.forEach{ println("${it.toString()}\n--------------------------")}

    var converter = ProductConverter()
    var records = converter.convertAll(sourceProducts)

    println("\n\nRecords")
    println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
    records.forEach{ println("${it.toString()}\n--------------------------")}

    println("\nDone.")
}
