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
            int command = scanner.nextInt(); // Считываем команду
            if (command == 1) {
                System.out.println("За какой месяц?");
                System.out.println("Янв; Фев; Март; Апр; Май; Июнь; Июль; Авг; Сен; Окт; Ноя; Дек");
                String mont = scanner.next();
                if (tracker.year.containsKey(mont)) { // Проверяем наличие введенного месяца (ключа)
                    System.out.println("За какое число?");
                    int day = scanner.nextInt();
                    System.out.println("Сколько шагов Вы прошли?");
                    int step = scanner.nextInt();
                    if (step < 0) {
                        System.out.println("Число шагов не может быть меньше 0");
                    } else {
                        tracker.inputStep(day, step, mont); // Вызываем метод для ввода данных
                    }
                } else {
                    System.out.println("Такого месяца нет");
                }
            } else if (command == 2) {
                System.out.println("За какой месяц ?");
                System.out.println("Янв; Фев; Март; Апр; Май; Июнь; Июль; Авг; Сен; Окт; Ноя; Дек");
                String mont = scanner.next();
                if (tracker.year.containsKey(mont)) { // Проверяем наличие введенного месяца (ключа)
                    int sumStep = (tracker.printStat(mont)); // Вызываем метод вывода статистики, возвращаем сумму шагов
                    converter.convert(sumStep); // Передаем сумму шагов для конвертации
                } else {
                    System.out.println("Такого месяца нет");
                }
                } else if (command == 3) {
                    System.out.println("Введите новую цель");
                    int newPurpose = scanner.nextInt(); // Меняем значение цели
                    if (newPurpose < 0) {
                        System.out.println("Значение должно быть больше 0, попробуйте еще раз");
                    } else {
                        tracker.changeZiel(newPurpose);
                    }
                } else if (command == 0) {
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

