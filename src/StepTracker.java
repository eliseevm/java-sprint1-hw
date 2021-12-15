import java.util.HashMap;


public class StepTracker {
    int purpose = 10000;
    HashMap<String, Integer[]> year;

    StepTracker() {
        year = new HashMap<>();
        Integer[] january = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        year.put("Янв", january);
        Integer[] february = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        year.put("Фев", february);
        Integer[] march = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        year.put("Март", march);
        Integer[] april = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        year.put("Апр", april);
        Integer[] may = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        year.put("Май", may);
        Integer[] june = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        year.put("Июнь", june);
        Integer[] jule = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        year.put("Июль", jule);
        Integer[] august = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        year.put("Авг", august);
        Integer[] september = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        year.put("Сент", september);
        Integer[] oktober = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        year.put("Окт", oktober);
        Integer[] november = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        year.put("Ноя", november);
        Integer[] december = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        year.put("Дек", december);
    }
    void changeZiel(int newPurpose){
        purpose = newPurpose;
        System.out.println("Цель изменена, новая цель " + purpose + " Шагов");
    }

    void inputStep(int day, int step, String month) {
        for (String key : year.keySet()) { // Последовательно извлекаем ключи из таблицы
            if (key.equals(month)) { // Сверяем ключ с запросом, если true, идем дальше
                    Integer[] dayStep = year.get(key); // Вынимаем из таблицы значения по ключу
                    dayStep[day - 1] = step; // Сохраняем в массив введеные пользователем данные
            }
        }
    }


    int printStat(String month) { // Объявляем метод с аргументом и возвратом значения
        int sumStep = 0; // Инициализируем переменную для подсчета шагов "всего"
            for (String key : year.keySet()) { // Последовательно извлекаем ключи из таблицы
                if (key.equals(month)) { // Сверяем ключ с запросом, если true, идем дальше
                    Integer[] stepDay = year.get(key); // Вынимаем из таблицы значения по ключу
                    double averageSumSteps = 0.0; // Инициализируем переменную для рассчета
                    // среднего количества шагов
                    int series = 0; // Инициализируем переменную для лучшей серии
                    int maxDay = 0; // Инициализируем переменную для промежуточного счетчика
                    for (int i = 0; i < 30; i++) { // Цикл для расчета суммы и вывода по дням
                        if(stepDay[i] > purpose){
                            maxDay++;
                        } else if (maxDay > series){
                            series = maxDay;
                            maxDay = 0;
                        }
                        sumStep = sumStep + stepDay[i]; // Рассчет общей суммы щагов
                        averageSumSteps = (sumStep / 30); // Рассчет средней суммы шагов
                        System.out.print((i + 1) + " День : " + stepDay[i] + ", ");
                    }   System.out.println(); // Возврат к переносу строк
                    System.out.println("Сумма шагов за " + month + " - " + sumStep + " шагов");
                    System.out.println("Среднее кол-во шагов в день за месяц " + averageSumSteps);
                    System.out.println("Лучшая серия дней за месяц, составила " + series + " дн.");
                }
            } return sumStep; // Возврат значения
        }
    }

