import kotlin.math.pow

val bw = System.`out`.bufferedWriter()
fun main() = with(System.`in`.bufferedReader()){
    val n = readln().toInt()
    bw.write("${((2.0).pow(n)-1).toInt()}\n")
    move(1,2,3,n)
    bw.flush()
    bw.close()
}
fun move(from: Int,via:Int,to: Int,n: Int){

    if(n == 1){
        bw.write("$from $to\n")
        return
    }
    move(from,to,via,n-1)
    bw.write("$from $to\n")
    move(via, from, to, n-1)
}