package Seminar_03;

import java.util.Arrays;
import java.util.Scanner;

public class SeminarThreeHomeWorkOne {
    public static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        //уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        //слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }


    public static void main(String args[]) {
        int[] sortArr = {132, 21, 56, 13, -52, 105, 0, 115, -16, 28, 99};
        int[] result = mergeSort(sortArr);
        int[] filterArr = Arrays.stream(result).filter(i -> i%2 != 0).toArray();
        System.out.println("Исходный список: " + Arrays.toString(sortArr));
        System.out.println("Минимальное значение: " + result[0]);
        System.out.println("Максимальное значение: " + result[result.length - 1]);
        System.out.println("Среднее значение: " + (double) Arrays.stream(result).sum() / result.length);
        System.out.println("Нечетные цифры массива: " + Arrays.toString(filterArr));
    }
}
