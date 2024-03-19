fun main(){

    val index = readln().toInt()

    var ans = 1
    var min = 2
    for(i in 1..10000000){
        if(index<min){
            println(ans)
            return
        }
        else{
            min += i.times(6)
            ans += 1
        }
    }
}