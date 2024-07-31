fun main() = with(System.`in`.bufferedReader()){

    val m : Map<String,Double> = mapOf("A+" to 4.5, "A0" to 4.0, "B+" to 3.5, "B0" to 3.0, "C+" to 2.5, "C0" to 2.0, "D+" to 1.5, "D0" to 1.0, "F" to 0.0)
    var total = 0.0
    var sum = 0.0
    for (i in 1..20){
        
        val (name,score,level) = readLine().split(" ")
        if(level == "P") continue
        total += m[level]!! * score.toDouble()
        sum += score.toDouble()
    }
    println(total/sum)
}