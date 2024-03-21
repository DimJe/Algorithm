fun main(){
    val (a,b,v) = readln().split(' ').map { it.toInt() }
    val x = a-b
    val answer = if((v-a) % x !=0) ((v-a)/x) + 2 else (v-a)/x + 1
    println(answer)
}