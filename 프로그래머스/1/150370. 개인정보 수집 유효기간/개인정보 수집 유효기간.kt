class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer = arrayListOf<Int>()
        var deadLine = mutableMapOf<String,Int>()
        terms.forEach { it ->
            it.split(" ").apply {
                deadLine[this[0]] = this[1].toInt()
            }
        }
        for(i in privacies.indices){
            var date = ""
            var type = ""
            privacies[i].split(" ").apply{
                date = this[0]
                type = this[1]
            }
            val dateList = date.split(".")
            var day = 0
            var month = 0
            var year = dateList[0].toInt()
            if(dateList[1].toInt()+deadLine[type]!! > 12){
                if((dateList[1].toInt()+deadLine[type]!!)%12 == 0){
                    year += ((dateList[1].toInt()+deadLine[type]!!.toInt())/12) - 1
                    month = 12
                }
                else {
                    year += (dateList[1].toInt()+deadLine[type]!!.toInt())/12
                    month = ((dateList[1].toInt()+deadLine[type]!!.toInt())%12)
                }
            }
            else{
                month = dateList[1].toInt()+deadLine[type]!!.toInt()
            }
            if(dateList[2].toInt()==1){
                month -= 1
                if(month==0){
                    month = 12
                    year -= 1
                }
                day = 28
            }
            else day = dateList[2].toInt() - 1
            val check = "${year}.${"%02d".format(month)}.${"%02d".format(day)}"
            if(check<today) answer.add(i+1)
        }
        return answer.toIntArray()
    }
}