fun main() = with(System.`in`.bufferedReader()){

    val (x, y) = readln().split(" ").map{ it.toInt() }
    
    println(x.toDouble()/y.toDouble())
}