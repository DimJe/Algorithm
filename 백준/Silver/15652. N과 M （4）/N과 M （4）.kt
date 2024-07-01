lateinit var vistied: BooleanArray
lateinit var array: IntArray
var n = 0
var m = 0
val bw = System.`out`.bufferedWriter()
fun main() = with(System.`in`.bufferedReader()){

    val (x, y) = readln().split(" ").map{ it.toInt() }
    n = x
    m = y
    vistied = BooleanArray(n){false}
    array = IntArray(m)

    solution(0)

    bw.flush()
    bw.close()
}
fun solution(count: Int){
    if(count == m) {
        array.forEach {
            bw.write("$it ")
        }
        bw.newLine()
        return
    }
    for(i in 0 until n){

        if(count == 0) array[count] = i+1
        else{
            if(array[count-1] <= i+1) array[count] = i+1
            else continue
        }
        solution(count+1)
    }
}