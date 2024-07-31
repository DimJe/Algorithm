fun main() = with(System.`in`.bufferedReader()){

    val n = readln().toInt()
    var x = 5
    var ans = 0
    while (x <= n){
        ans += n / x
        x *= 5
    }
    println(ans)
}
