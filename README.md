# quick-product-import
Quick-Product-Import is a demonstration and first experiment with Kotlin, a modern JVM language.  The purpose is to import a flat, fixed length file format representing product addition/changes from a grocery supplier. Output is a standardized object format per a grocery content aggregator.  The exercise is focused on data transformation and assumes it will be used as part of a larger process of ingestion, process management and data CRUD+.  

## Author
Breanna Anderson

## Prerequisites
The project was built with these requisites.  Lower versions may work but have not been tested
* Java JDK 14
* Kotlin version 1.3.71-release-431 (JRE 14+36-1461)
* Intellij IDEA 2020.1 (Optional)

## Installation
* Clone the repo
* $>cd quick-product-import
* Use Editor IDE of choice. e.g. Intellij IDEA.


## Test/Demo
To perform a quick smoke test using the demo main provided:
```
$> cd quick-product-import
$> kotlinc src -include-runtime -d quick.jar
$> java -jar quick.jar data/input-sample.txt

Expect to see data output printing input data and output record content for inspection

e.g.
Input Data:
===================
productId:............. 80000001
productDescription:.... "Kimchi-flavored white rice"
regularSinglePrice:.... 5.67
promotionalSinglePrice: 0.0
regularSplitPrice:..... 0.0
promotionalSplitPrice:. 0.0
regularForX:........... 0
promotionalForX:....... 0
flags:................. FFFFFFFFF
productSize:........... "18oz"
------------------
...
Output Records:
===================
productId:................. 80000001
productDescription:........ "Kimchi-flavored white rice"
productSize:............... "18oz"
isPerWeight:............... false
isTaxable:................. false
unitOfMeasure:............. "Each"
taxRate:................... 0.0
regularDisplayPrice:....... "$5.67"
regularCalculatorPrice:.... 5.67
promotionalDisplayPrice:... ""
promotionalCalculatorPrice: 0.0
dateCreated:............... 04/21/2020 11:33:48
------------------

```

## License
MIT License
