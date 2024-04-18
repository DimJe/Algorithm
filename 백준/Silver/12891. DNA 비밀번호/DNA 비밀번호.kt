
val bw = System.`out`.bufferedWriter()
fun main() = with(System.`in`.bufferedReader()){
    val (x,y) = readln().split(" ").map { it.toInt() }
    val str = readln()
    val passWord = readln().split(" ").map { it.toInt() }
    val passWordCheck = List(4) { 0 }.toMutableList()
    val map = mapOf('A' to 0,'C' to 1,'G' to 2,'T' to 3)
    var first = 0
    var last = y-1
    var ans = 0
    for(i in 0 until y){
        when(str[i]){
            'A' -> passWordCheck[0]++
            'C' -> passWordCheck[1]++
            'G' -> passWordCheck[2]++
            'T' -> passWordCheck[3]++
        }
    }
    if(
        passWord[0] <= passWordCheck[0] &&
        passWord[1] <= passWordCheck[1] &&
        passWord[2] <= passWordCheck[2] &&
        passWord[3] <= passWordCheck[3]){
        ans++
        //passWordCheck.forEach { print(it) }
    }
    while (last<x-1){
        //println("last = $last")
        passWordCheck[map[str[first]]!!]--
        //passWordCheck[map[str[last]]!!]--
        first++
        last++
        //passWordCheck[map[str[first]]!!]++
        passWordCheck[map[str[last]]!!]++
        //passWordCheck.forEach { print(it) }
        if(
            passWord[0] <= passWordCheck[0] &&
            passWord[1] <= passWordCheck[1] &&
            passWord[2] <= passWordCheck[2] &&
            passWord[3] <= passWordCheck[3]){
            ans++
            //passWordCheck.forEach { print(it) }
        }
    }
    bw.write("$ans")
    bw.flush()
    bw.close()
}