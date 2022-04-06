package base;

import filter.Filter;
import logging.Logger;

import java.util.*;

public class Main {

    public static void fill(List<Integer> list, int size, int bound) {
        Logger.getInstance().log("Заполнение списка случайными числами");
        Random random = new Random(new Date().getTime());
        while (size-- > 0) {
            list.add(random.nextInt(bound));
        }
    }

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запуск программы");

        System.out.println("Здравствуйте!");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Укажите количество элементов в списке: ");
            int n = scanner.nextInt();
            logger.log("Установка размера списка: " + n);

            System.out.print("Укажите верхнюю границу для значений: ");
            int m = scanner.nextInt();
            logger.log("Установка верхней границы: " + m);

            System.out.print("Укажите порог для фильтра: ");
            int f = scanner.nextInt();
            logger.log("Установка порога для фильтра: " + f);

            List<Integer> originalList = new ArrayList<>(n);
            logger.log("Создание пустого списка с начальной емкостью: " + n);

            fill(originalList, n, m);

            System.out.println(originalList);
            logger.log("Вывод первоначального списка: " + originalList);

            List<Integer> filteredList = new Filter(f).filterOut(originalList);
            System.out.println(filteredList);
            logger.log("Вывод отфильтрованного списка: " + filteredList);

            logger.log("Завершение работы программы");
        }
    }
}
