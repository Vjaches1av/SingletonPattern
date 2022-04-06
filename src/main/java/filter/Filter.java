package filter;

import logging.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    private final int f;

    public Filter(int f) {
        this.f = f;
    }

    public List<Integer> filterOut(@NotNull List<Integer> list) {
        Logger logger = Logger.getInstance();
        logger.log("Запуск фильтрации");
        return list.stream()
                .filter(integer -> {
                    if (integer < f) {
                        logger.log("Число \"" + integer + "\" удовлетворяет условию");
                        return true;
                    } else {
                        logger.log("Число \"" + integer + "\" превышает установленный порог");
                        return false;
                    }

                })
                .collect(Collectors.toList());
    }
}
