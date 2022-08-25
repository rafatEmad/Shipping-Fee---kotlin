import kotlin.math.roundToInt

fun calc(amount :Double , international:Boolean):Double{
    // define var fee to hold to calculate value
    var fee  = 0.0
    // check for type of shipping if it is international on local
    when(international){
        true -> {
            // if shipping is international calculate fee with 15% of price amount
            val random = calcPorcentage(amount , 15)
            // the maximum fee for international shipping is 50
            // check if fee > 50
            if(random > 50.0)
                fee = 50.0
            else // checking if fee less than 50
                fee = (random * 10000).roundToInt().toDouble() / 10000

        }
        false ->{ // check if it not for international shipping calculate the fee base on the given percentage
            if(amount >= 75)
                fee = 0.0
            else if(amount < 75)
                fee = calcPorcentage(amount , 10)
        }
    }
    return fee // return the fee
}

// calculate percentage out of given price amount and fee percentage from formula (amount / 100) * percentage
// function return fee as a double number
fun calcPorcentage(price:Double , por:Int ) :Double{
    return (price /100 ) * por
}

// the main fun
fun main(){
    val caseTest = readLine()!!.toDouble() // get user input double
    val international = readLine().toBoolean()// get user input boolean
    print(calc(caseTest , international)) // print the result
}