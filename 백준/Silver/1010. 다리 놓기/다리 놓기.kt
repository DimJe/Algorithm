fun main(){
    val n = readln().toInt()
    repeat(n){
        val (x,y) = readln().split(' ').map { it.toInt() }
        var ans = 1.toBigInteger()
        for (i in 1..x){
            ans = ans * (y.toBigInteger()-i.toBigInteger()+1.toBigInteger())/i.toBigInteger()
        }
        println(ans)
    }
}