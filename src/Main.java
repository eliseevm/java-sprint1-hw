import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создаем объекты
        StepTracker tracker = new StepTracker();
        Converter converter = new Converter();
        System.out.println("Давайте познакомимся!"); // Знакомимся
        System.out.println("Как Ваше имя?");
        String name = scanner.next(); // Считываем имя пользователя


        while (true) { // Запускаем бесконечный цикл
            printMenu(name); // Печатаем меню
            String command = scanner.next(); // Считываем команду в формате строки
                if (command.equals("1")) { // Cверяем введенное значение со значением строки
                    System.out.println("За какой месяц?");
                    System.out.println("Янв;Фев;Март;Апр;Май;Июнь;Июль;Авг;Сен;Окт;Ноя;Дек");
                    String month = scanner.next(); // Считываем команду в формате строки
                    if (tracker.year.containsKey(month)) { // Проверяем наличие месяца (ключа)
                        System.out.println("За какое число?");
                        String dayStr = scanner.next(); // Считываем команду в формате строки
                        boolean day = converter.isNumeric(dayStr); // Отправляем значение в метод
                        if (day == false){
                            System.out.println("Такого значения нет повторите ввод");
                        } else {
                            Integer dayInt = Integer.parseInt(dayStr);
                            System.out.println("Сколько шагов Вы прошли?");
                            String stepStr = scanner.next();
                            boolean step = converter.isNumeric(stepStr);
                                if (step == false) {
                                    System.out.println("Такого значения нет повторите ввод");
                                } else {
                                    Integer stepInt = Integer.parseInt(stepStr);
                                    if (stepInt < 0) {
                                        System.out.println("Число шагов не может быть меньше 0");
                                    } else {
                                        tracker.inputStep(dayInt, stepInt, month); // Вызываем
                                        // метод для ввода данных
                                        }
                                }
                        }
                    } else {
                            System.out.println("Такого месяца нет");
                    }
                } else if (command.equals("2")) {
                    System.out.println("За какой месяц ?");
                    System.out.println("Янв;Фев;Март;Апр;Май;Июнь;Июль;Авг;Сен;Окт;Ноя;Дек");
                    String month = scanner.next();
                    if (tracker.year.containsKey(month)) { // Проверяем наличие месяца (ключа)
                        int sumStep = (tracker.printStat(month)); // Вызываем метод вывода
                        // статистики, возвращаем сумму шагов
                        converter.convert(sumStep); // Передаем сумму шагов для конвертации
                    } else {
                        System.out.println("Такого месяца не бывает");
                    }
                } else if (command.equals("3")) {
                        System.out.println("Введите новую цель");
                        String newPurpose = scanner.next(); // Меняем значение цели
                        boolean purposeStr = converter.isNumeric(newPurpose );
                        if (purposeStr == false) {
                            System.out.println("Это не достижимая цель, повторите ввод");
                            } else {
                                Integer newPurpose1 = Integer.parseInt(newPurpose);
                                if (newPurpose1 < 0) {
                                    System.out.println("Значение должно быть больше 0");
                                } else {
                                    tracker.changeZiel(newPurpose1);
                                }
                        }
                } else if (command.equals("0")) {
                    break; // Прерываем работу цикла
                } else {
                    System.out.println("Такой команды пока нет, введите команду из списка!");
                }
            }
        }



        public static void printMenu (String name){
            System.out.println(name + "! Сделайте Ваш выбор");
            System.out.println("1 - Ввести количество пройденых шагов за день");
            System.out.println("2 - Напечатать статистику за месяц");
            System.out.println("3 - Изменить цель по количеству шагов в день");
            System.out.println("0 - Выйти из приложения");
        }
    }

