import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker tracker = new StepTracker();

        while (true) /*Реализуем бесконечный цикл для удобного меню*/ {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            if (command == 0) {
                break;
            } else if(command == 3) {
              System.out.println("Какой цели вы желаете достичь?");
                int newGoal = scanner.nextInt();
                tracker.changeGoal(newGoal);
            } else if (command == 2) {
                   System.out.println("За какой месяц вы желаете просмотреть активность?");
                   int month = scanner.nextInt();
                   tracker.printStatsForMonth(month);
        } else if (command == 4) {
                rememberSteps(scanner, tracker);
            } else if (command == 1) {


                    printResultsForDay(scanner, tracker);

            }

        }
    }
 public static void printMenu() {
     System.out.println("Приветствуем в нашем календаре активности.");
     System.out.println("Здесь вы можете следить за качеством и количеством своих прогулок в течение года");
     System.out.println("Наш календарь умеет:");
     System.out.println("1 - Выводить число шагов за день");
     System.out.println("2 - Приводить статисткику прогулок в течение выбранного месяца");
     System.out.println("3 - Менять желаемое количесвто шагов в день");
     System.out.println("4 - Запоминать число пройденных за день шагов");
     System.out.println("В случае, если календарь вам надоест, достаточно ввести 0 и выйти из программы");
 }
 public static void printResultsForDay(Scanner scanner, StepTracker tracker) {
     System.out.println("Укажите месяц. Для выхода введите 0.");
     int month = scanner.nextInt();
    while(true) {
     if (month < 0) {
         System.out.println("Такого месяца не существует!");
     } else if (month > 12) {
         System.out.println("Такого месяца не существует!");
     } else if (month == 0) {
         break;
     } else {
         while (true) {
             System.out.println("За какой день вы хотите увидеть свою активность? Для выхода введите 0.");
             int day = scanner.nextInt();
             if (day == 0) {
                 break;
             } else if (day > 30) {
                 System.out.println("Такого дня не существует!");
             } else if (day < 0) {
                 System.out.println("Такого дня не существует!");
             } else {
                 tracker.printStatsForDay(day, month);
             }
         }
     }
 }
 }
 public static void rememberSteps (Scanner scanner, StepTracker tracker) {
     System.out.println("Обнулить значения активностей? Да - 0, любое другое значение - нет");
     System.out.println("(В случае, если вы ещё не заполняли активности за год, мы рекоммендуем вам обнулить их значения.)");
     int zero = scanner.nextInt();
     if (zero == 0) {
         tracker.resetActivity();
     } else {
         while (true) {
             System.out.println("Введите, пожалуйста, номер месяца, за который вы хотите изменить активность.");
             System.out.println("Чтобы вернуться в предыдущее меню, ввекдите 0.");
             int month = scanner.nextInt();
             if (month == 0) {
                 break;
             } else if (month < 0) {
                 System.out.println("Номер месяца не может выпадать из отрезка 1-12 :-(");
             } else if (month > 12) {
                 System.out.println("Номер месяца не может выпадать из отрезка 1-12 :-(");
             } else {
                 System.out.println("За какой день вы желаете изменить активность? Для выхода из меню введите 0.");
                 int day = scanner.nextInt();
                 if (day < 0) {
                     System.out.println("Значение дня не может быть отрицательным!");
                 } else if (day > 30) {
                     System.out.println("В нашем юном приложении в месяце не более 30 дней :-(");
                 } else {
                     tracker.writeDownSteps(month, day);
                 }
             }

         }
     }
 }

}