val bw = System.`out`.bufferedWriter()
lateinit var vistied: BooleanArray
lateinit var arr: IntArray
var n = 0
var m = 0
fun main() = with(System.`in`.bufferedReader()){
    val (x,y) = readln().split(" ").map { it.toInt() }
    n = x
    m = y

    arr = IntArray(m)
    vistied = BooleanArray(n){false}

    solution(0,0)

    bw.flush()
    bw.close()
}
fun solution(count: Int,start: Int){

    if(count == m) {
        arr.forEach {
            bw.write("$it ")
        }
        bw.newLine()
        return
    }
    for(i in start until n){
        if(vistied[i] == false){
            vistied[i] = true
            arr[count] = i+1
            solution(count+1,i+1)
            vistied[i] = false
        }
    }
}