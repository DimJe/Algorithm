fun main() = with(System.`in`.bufferedReader()){

    val bw = System.`out`.bufferedWriter()
    val n = readLine().toInt()
    val array = readLine().split(' ').map { it.toInt() }
    val m = HashMap<Int,Int>()
    val distinctArray = array.distinct().sorted()

    for (i in distinctArray.indices){
        m[distinctArray[i]] = i
    }
    array.forEach {
        bw.write("${m[it]} ")
    }
    bw.close()
}