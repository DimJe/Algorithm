import kotlin.math.max
import kotlin.math.min


val bw = System.`out`.bufferedWriter()
fun main() = with(System.`in`.bufferedReader()) {

    val (h,w) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }
    var ans = 0
    for (i in 1 until w-1){
        val left = arr.subList(0,i).max()
        val right = arr.subList(i+1,w).max()
        val M = min(left,right)
        if(arr[i] < M){
            ans += M - arr[i]
        }
    }
    println(ans)

}