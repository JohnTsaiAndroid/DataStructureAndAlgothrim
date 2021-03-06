package xyz.johntsai.dsaa.sort;

/**
 * Created by JohnTsai on 16/3/21.
 */
public class HeapSort <T extends Comparable<T>>{
    /**
     * 堆排序
     *
     * 学习链接:
     * http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Sorting/heapSort.htm
     * https://en.wikipedia.org/wiki/Heapsort
     * https://en.wikipedia.org/wiki/Heap_(data_structure)
     * http://blog.csdn.net/morewindows/article/details/6709644
     * https://zh.wikipedia.org/wiki/%E4%BA%8C%E5%8F%89%E5%A0%86
     * http://dongxicheng.org/structure/heap/
     * https://zh.wikipedia.org/wiki/%E4%BA%8C%E5%8F%89%E6%A0%91
     * https://www.cs.usfca.edu/~galles/visualization/HeapSort.html
     * http://ind.ntou.edu.tw/~litsnow/al98/pdf/Algorithm-Ch6-Heapsort.pdf
     *
     *
     * 堆(heap)
     *
     *
     *
     *
     * @param array
     */

    private static int length;

    public  void heapSort(T[]array){
         buildHeap(array);
         for(int i = length;i>0;i--){
             exchange(array, 0, i);
             length--;
             maxHeap(array,0);
         }
    }

    public  void maxHeap(T[] array, int i) {
        int left = 2*i,right = 2*i+1;
        int largest;
        if(left<=length&&array[left].compareTo(array[i])>0){
            largest = left;
        }else{
            largest = i;
        }

        if(right<=length&&array[right].compareTo(array[largest])>0){
            largest = right;
        }
        if(largest!=i){
            exchange(array, i, largest);
            maxHeap(array,largest);
        }
    }

    private  void exchange(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public  void buildHeap(T[] array) {
        length = array.length -1;
        for(int i = length/2;i>=0;i--){
            maxHeap(array,i);
        }
    }

    public static void main(String[] args) {
        Integer [] array = {3,2,5,1,4,6,3,8,3,5,6,5,4,9};
        HeapSort<Integer> sort = new HeapSort<>();
        sort.heapSort(array);
        Utlis.printArray(array);
    }

}
