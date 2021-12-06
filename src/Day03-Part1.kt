fun main() {
    fun getMostSignificantBit(indexToExamine:Int, inputMeasurements:List<String>):Int{
        var ones = 0
        var zeroes = 0
        for (item in inputMeasurements) {
            val bit = Integer.parseInt(item[indexToExamine].toString())
            if(bit == 1){
                ones += 1
                continue
            }
            if(bit == 0){
                zeroes += 1
                continue
            }
        }
        if(ones > zeroes) {
            return 1
        }else return 0
    }
    fun getLeastSignificantBit(indexToExamine:Int, inputMeasurements:List<String>):Int{
        var ones = 0
        var zeroes = 0
        for (item in inputMeasurements) {
            val bit = Integer.parseInt(item[indexToExamine].toString())
            if(bit == 1){
                ones += 1
                continue
            }
            if(bit == 0){
                zeroes += 1
                continue
            }
        }
        if(ones < zeroes) {
            return 1
        }else return 0
    }
    fun convertBinaryToDecimal(num: Long): Int {
        var num = num
        var decimalNumber = 0
        var i = 0
        var remainder: Long

        while (num.toInt() != 0) {
            remainder = num % 10
            num /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimalNumber
    }

    var gammaRateBinary = ""
    var epsilonRateBinary = ""

    var bitIndexToExamine = 0
    val inputMeasurements = readInput("Day03-Input")
//    val inputMeasurements = readInput("Day03-Input-Test")
    val inputSize = inputMeasurements[0].length
    for (i in 1..inputSize) {
        val mostSignificantBit = getMostSignificantBit(bitIndexToExamine, inputMeasurements)
        val leastSignificantBit = getLeastSignificantBit(bitIndexToExamine, inputMeasurements)
        bitIndexToExamine += 1
        gammaRateBinary += mostSignificantBit
        epsilonRateBinary += leastSignificantBit
    }

    val gammaRate = convertBinaryToDecimal(gammaRateBinary.toLong())
    val epsilonRate = convertBinaryToDecimal(epsilonRateBinary.toLong())
    val result = gammaRate * epsilonRate
    println("the end, result: $result, $gammaRate $gammaRateBinary, $epsilonRate $epsilonRateBinary")
}
