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
        return if(ones >= zeroes) {
            1
        }else 0
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
        return if(ones < zeroes) {
            1
        }else 0
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
    fun filterSubArray(indexToExamine:Int, inputArray:List<String>, mostSignificantBit:Int):List<String>{
        val newArray : MutableList<String> = arrayListOf()
        for (item in inputArray) {
            val bit = Integer.parseInt(item[indexToExamine].toString())
            if(bit == mostSignificantBit){
                newArray.add(item)
            }
        }
        return newArray
    }

    var oxygenGeneratorRating = "";
    var co2ScrubberRating = "";
    var subArrayOxygen: List<String>
    var subArrayCO2: List<String>

    var bitIndexToExamine = 0
    val inputMeasurements = readInput("Day03-Input")
//    val inputMeasurements = readInput("Day03-Input-Test")
    val inputSize = inputMeasurements[0].length
    subArrayOxygen = inputMeasurements
    subArrayCO2 = inputMeasurements
    for (i in 1..inputSize) {
        val mostSignificantBit = getMostSignificantBit(bitIndexToExamine, subArrayOxygen)
        subArrayOxygen = filterSubArray(bitIndexToExamine, subArrayOxygen, mostSignificantBit)
        bitIndexToExamine+=1
        if(subArrayOxygen.size == 1){
            break;
        }
    }
    bitIndexToExamine = 0 // Reset
    for (i in 1..inputSize) {
        val leastSignificantBit = getLeastSignificantBit(bitIndexToExamine, subArrayCO2)
        subArrayCO2 = filterSubArray(bitIndexToExamine, subArrayCO2, leastSignificantBit)
        bitIndexToExamine+=1
        if(subArrayCO2.size == 1){
            break;
        }
    }

    oxygenGeneratorRating = subArrayOxygen[0]
    val oxygenRating = convertBinaryToDecimal(oxygenGeneratorRating.toLong())
    co2ScrubberRating = subArrayCO2[0]
    val co2Rating = convertBinaryToDecimal(co2ScrubberRating.toLong())
    val result = co2Rating * oxygenRating
    println("the end result: $result, $subArrayOxygen $oxygenRating $subArrayCO2 $co2Rating")
}
