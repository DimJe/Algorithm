fun main(){
    val (n,m) = readln().split(' ').map { it.toInt() }
    val noLook = arrayListOf<String>()
    //val noListen = arrayListOf<String>()
    val dupllication = mutableSetOf<String>()

    for (i in 1..n+m) noLook.add(readln())
    //for (i in 1..m) noListen.add(readln())

    val ans = noLook.filter { !dupllication.add(it) }.sorted()
    println(ans.size)
    ans.forEach {
        println(it)
    }
}