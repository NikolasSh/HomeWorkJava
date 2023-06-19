package Seminar_4;

import java.util.LinkedList;
import java.util.Scanner;

public class SeminarFourHomeWorkOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();

        while (true) {
            System.out.println("Введите строку (print/revert/exit для выполнения команд):");
            String input = scanner.nextLine();

            if (input.equals("print")) {
                System.out.println("Строки в обратном порядке:");
                while (!list.isEmpty()) {
                    System.out.println(list.removeLast());
                }
            } else if (input.equals("revert")) {
                if (!list.isEmpty()) {
                    list.removeLast();
                    System.out.println("Последняя введенная строка удалена из памяти.");
                } else {
                    System.out.println("Нет сохраненных строк для удаления.");
                }

            } else if (input.equals("exit")) {
                System.exit(0);

            } else {
                list.addLast(input);
            }
        }
    }
}
