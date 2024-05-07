import kotlin.math.max


val bw = System.`out`.bufferedWriter()
fun main() = with(System.`in`.bufferedReader()) {

    val n = readln().toInt()
    val sum = LongArray(n){0}
    val honey = readln().split(" ").map { it.toLong() }
    sum[0] = honey[0]
    for (i in 1 until n){
        sum[i] = sum[i-1] + honey[i]
    }
    var ans = 0L
    for (i in 1 until n-1){ // 벌벌꿀
        ans = max(ans,(sum[n-1] - honey[0] + sum[n-1] - sum[i] - honey[i]))
    }
    for (i in 1 until n-1){ // 벌꿀벌
        ans = max(ans,(sum[i] - honey[0] + sum[n-2] - sum[i-1]))
    }
    for (i in 1 until n-1){ // 꿀벌벌
        ans = max(ans, (sum[n-2] + sum[i-1] - honey[i]))
    }
    println(ans)
}