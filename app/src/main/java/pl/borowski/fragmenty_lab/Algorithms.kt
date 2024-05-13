package pl.borowski.fragmenty_lab

object Algorithms {
    fun bubbleSort(array: IntArray): IntArray {
        val n = array.size
        var wasSwapped: Boolean
        do {
            wasSwapped = false
            for (i in 1 until n) {
                if (array[i - 1] > array[i]) {
                    val temp = array[i]
                    array[i] = array[i - 1]
                    array[i - 1] = temp
                    wasSwapped = true
                }
            }
        } while (wasSwapped)
        return array
    }

    fun insertionSort(array: IntArray): IntArray {
        val size = array.size
        for (i in 1 until size) {
            val key = array[i]
            var j = i - 1
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]
                j -= 1
            }
            array[j + 1] = key
        }
        return array
    }
}
