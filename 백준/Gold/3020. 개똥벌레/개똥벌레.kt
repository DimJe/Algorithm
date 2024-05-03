

val bw = System.`out`.bufferedWriter()
fun main() = with(System.`in`.bufferedReader()) {

    val (n,h) = readln().split(" ").map { it.toInt() }
    val up = IntArray(n/2)
    val down = IntArray(n/2)
    var ans = n
    var count = 0
    for (i in 0 until n/2){
        val d = readln().toInt()
        val u = readln().toInt()
        up[i] = u
        down[i] = d
    }
    up.sort()
    down.sort()
    for (i in 1..h){
        val conflict = binarySearch(0,n/2,i,down) + binarySearch(0,n/2,h-i+1,up)
        if(ans == conflict) {
            count++
            continue
        }
        if(ans > conflict){
            count = 1
            ans = conflict
        }
    }
    println("$ans $count")
}
fun binarySearch(l: Int,r: Int,h: Int,arr: IntArray): Int {
    var left = l
    var right = r
    while (left < right){
        val mid = (left + right)/2

        if(arr[mid] >= h) right = mid
        else left = mid + 1
    }
    return arr.size - right
}