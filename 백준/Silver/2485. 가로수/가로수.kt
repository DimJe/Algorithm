
fun main() = with(System.`in`.bufferedReader()){
    val n = readln().toInt()
    val arr = IntArray(n) { readln().toInt() }
    val deviation = IntArray(n-1){arr[it + 1] - arr[it]}
    var result = 0
    val ans = deviation.reduce { acc, i -> gcd(acc,i)  }
    for (i in deviation) {
        if(i/ans > 1){
            result += (i/ans) - 1
        }
    }
    println(result)
}
fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
