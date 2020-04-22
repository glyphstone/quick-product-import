package net.glyphstone.quick

import net.glyphstone.quick.importer.ProductLoader
import net.glyphstone.quick.types.product.ProductConverter
import kotlin.system.exitProcess

fun main(args: Array<String>){  
    println("Test import grocery products flat file and output List of standard ProductRecords. V1")

    var inputFileName: String
    if( args.size >= 1 ) {
        inputFileName = args[args.size-1]
        println("Input File: ${inputFileName}")
    } else {
        println("Input file required:  Ex: java -jar main.jar data/input.txt")
        exitProcess(1)
    }

    var loader = ProductLoader()
    var sourceProducts = loader.load( inputFileName )

    println("\n\nInput Data:\n===================")
    sourceProducts.forEach{ println("${it.toString()}\n------------------\n")}

    var converter = ProductConverter()
    var records = converter.convertAll(sourceProducts)

    println("\n\nOutput Records:\n===================")
    records.forEach{ println("${it.toString()}\n------------------\n")}

    println("\nDone.")
}
