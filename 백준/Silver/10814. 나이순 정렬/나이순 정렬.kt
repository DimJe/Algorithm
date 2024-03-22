fun main(){
    val n = readln().toInt()
    val array = arrayListOf<Pair<Int,Int>>()
    val m = mutableMapOf<Int,String>()
    for(i in 1..n){
        val (age,name) = readln().split(' ')
        m[i] = name
        array.add((age.toInt() to i))
    }
    val sorted = array.sortedWith(compareBy({it.first},{it.second}))
    sorted.forEach {
        println("${it.first} ${m[it.second]}")
    }
}