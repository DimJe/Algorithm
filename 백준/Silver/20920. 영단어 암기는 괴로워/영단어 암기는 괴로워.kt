fun main() = with(System.`in`.bufferedReader()){
    val bw = System.`out`.bufferedWriter()
    val (n,m) = readLine().split(' ').map { it.toInt() }
    val words = arrayListOf<Pair<Int,String>>()
    val wordSet = mutableSetOf<String>()
    val wordCount = HashMap<String,Int>()
    for(i in 1..n){
        val word = readLine()
        if(word.length >= m) {
            wordCount.merge(word,1,Integer::sum)
        }
    }
    val ans = wordCount.entries
    val result = ans.sortedWith(Comparator { o1, o2 ->
        when {
            o1.value != o2.value -> {
                o2.value.compareTo(o1.value)
            }
            o1.key.length != o2.key.length ->{
                o2.key.length.compareTo(o1.key.length)
            }
            else -> {
                o1.key.compareTo(o2.key)
            }
        }
    })
    result.forEach {
        bw.write("${it.key}\n")
    }
//    ans.sortedWith(compareBy( { it.value.times(-1) },{it.key.length.times(-1)},{it.key}) ).forEach {
//        bw.write("${it.key}\n")
//    }

    bw.flush()
    bw.close()
}