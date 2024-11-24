package longest_common_prefix.longest_common_prefix

// https://leetcode.com/problems/longest-common-prefix/description/

fun main() {

    val array1 = arrayOf("flower", "flow", "flight")
    val array2 = arrayOf("family", "pop", "neck")
    val array3 = arrayOf("dog", "racecar", "car")

    val array4 = arrayOf("ab", "a")

    val solution = Solution()

    println(solution.longestCommonPrefix(array4))

}

class Solution {

    fun longestCommonPrefix(strs: Array<String>): String {

        var result = StringBuilder()
        var isOver = false

        for (sequenceNumber in 0..<strs[0].length) { // берем буквы из первого слова в массиве

            if (isOver) break

            val currentLetter = (strs[0])[sequenceNumber] // буква, с которой мы работаем

            for (str in strs.indices) { // проходим по индексам слов в массиве

                val length = strs[str].length - 1 // количество индексов в текущем слове

                if (sequenceNumber <= length &&
                    currentLetter == strs[str][sequenceNumber]
                ) {
                    // если текущий индекс в слове меньше количества индексов И
                    // если буква, с которой мы работаем равна порядковой букве слова, с которым мы работаем

                    if (str == (strs.size - 1)) {
                        result.append(currentLetter)
                        break
                    }
                    // если индекс слова равен последнему индексу в массиве. Т.е. тут мы пришли к последнему слову.
                    // После его проверки уже можем добавлять букву

                    continue
                } else {
                    isOver = true
                    // в этом случае выходим из всех вложенных циклов
                    break
                }

            }
        }

        return result.toString()
    }

}

