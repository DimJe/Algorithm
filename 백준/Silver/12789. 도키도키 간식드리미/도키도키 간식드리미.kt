import java.util.Stack

fun main(){
    val n = readln().toInt()
    val arr = readln().split(' ').map { it.toInt() }
    val stack = Stack<Int>()
    var num = 1
    arr.forEach {
        if(it == num){
            num++
            while (stack.isNotEmpty() && stack.peek() == num){
                stack.pop()
                num++
            }
        }
        else stack.push(it)
    }
    while (!stack.isEmpty()){
        if(stack.peek() == num){
            stack.pop()
            num++
        }
        else{
            println("Sad")
            return
        }
    }
    println("Nice")
}