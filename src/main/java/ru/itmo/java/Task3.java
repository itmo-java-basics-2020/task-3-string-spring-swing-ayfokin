package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new int[0];
        }
        int now = inputArray[0];
        int length = inputArray.length;
        for (int i = 0; i < length; i++) {
            now = now + inputArray[(i + 1) % length];
            inputArray[(i + 1) % length] = now - inputArray[(i + 1) % length];
            now = now - inputArray[(i + 1) % length];
        }
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }
        if (inputArray.length == 1) {
            return inputArray[0];
        }

        int max1 = 0;
        int max2 = 1;
        for (int i = 3; i < inputArray.length; i++) {
            if (inputArray[i] > inputArray[max1]) {
                max1 = i;
            } else {
                if (inputArray[i] > inputArray[max2]) {
                    max2 = i;
                }
            }
        }
        return inputArray[max1] * inputArray[max2] ;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' ||  input.charAt(i) == 'A' || input.charAt(i) == 'b' || input.charAt(i) == 'B') {
                count++;
            }
        }
        return count * 100 / input.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }
        for (int i = 0; i < input.length() / 2 + input.length() % 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.equals("")) {
            return "";
        }
        char now = input.charAt(0);
        int count = 1;
        String ans = Character.toString(now);
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == now) {
                count++;
            } else {
                ans += count;
                now = input.charAt(i);
                count = 1;
                ans += now;
            }
        }
        ans += count;
        return ans;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() == 0 || two.length() == 0) {
            return false;
        }
        char[] sortOne = one.toCharArray();
        char[] sortTwo = two.toCharArray();
        Arrays.sort(sortOne);
        Arrays.sort(sortTwo);
        String sortedOne = new String (sortOne);
        String sortedTwo = new String (sortTwo);
        return sortedOne.equals(sortedTwo);
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean[] uniq = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            if (uniq[s.charAt(i)]) {
                return false;
            }
            uniq[s.charAt(i)] = true;
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        int[][] matrix = new int[][] {};
        if (m == null) {
            return matrix;
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m.length; j++) {
                int swap = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = swap;
            }
        }
        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0) {
            return "";
        }
        if (separator == null) {
            separator = ' ';
        }
        String ans = inputStrings[0];
        for (int i = 1; i < inputStrings.length; i++) {
            ans += separator;
            ans += inputStrings[i];
        }
        return ans;
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (prefix == null || inputStrings == null) {
            return 0;
        }
        int count = 0;
        for (String inputString : inputStrings) {
            boolean isPrefix = true;
            for (int j = 0; j < prefix.length(); j++) {
                if (prefix.charAt(j) != inputString.charAt(j)) {
                    isPrefix = false;
                    break;
                }
            }
            if (isPrefix) {
                count++;
            }
        }
        return count;
    }
}
