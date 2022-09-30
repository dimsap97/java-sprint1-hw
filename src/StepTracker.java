import java.util.Scanner;
public class StepTracker {
    int steps[][] = new int[12][30];
    int theStartGoal = 10000;

    void changeGoal(int newGoal) {

        theStartGoal = newGoal;
    }
    void writeDownSteps(int month, int day) {
        Scanner scanner = new Scanner(System.in);
                        System.out.println("Сколько вы прошли за этот день?");
                        steps[month - 1][day - 1] = scanner.nextInt();
            }
    void resetActivity() {

        for(int i = 0; i < 12; i++ ) {
            for(int j = 0; j < 30; j++) {
                steps[i][j] = 0;
            }
        }
    }

    void printStatsForDay(int month, int day) {

        System.out.println("Вы прошли " + steps[month - 1][day - 1] + " шагов");
    }
    void printStatsForMonth(int month) {
        int max = 0;
      for (int i = 0; i < 30; i++) {
          System.out.println((i + 1) + " день: " + steps[month - 1][i] + ",");
          } int sum = 0;
      for (int i = 0; i < 30; i++) {
        sum = sum + steps[month - 1][i];
      } System.out.println("Всего за месяц пройдено: " + sum);
      System.out.println("Среднее число шагов в день: " + (sum/30));
      for (int i = 0; i <30; i++) {
          if (steps[month - 1][i] > max) {
             max = steps[month - 1][i];
          }
      }
      System.out.println("Ваш рекорд за месяц - " + max + " шагов.");
      int score1 = 0;
      int maxScore = 0;
        for (int i = 0; i < 30; i++) {

                if (steps[month - 1][i] >= theStartGoal) {
                    score1 = score1 + 1;
                    if (score1 > maxScore) {
                        maxScore = score1;
                    }
                } else {
                    score1 = 0;
                }

                    }

        System.out.println("Лучшая серия: " + maxScore + " дней подряд.");
    }

        }




