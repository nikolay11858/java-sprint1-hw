import java.sql.Array;

public class StepTracker {
    int steps[][] = new int[12][30];
    int goalSteps = 10000;


    void saveCountStep(int month, int day, int countStep) {
        if ((month < 1) || (month > 12)) {
            System.out.println("Вы ввели недопустимый номер месяца");
            return;
        }

        if ((day < 1) || (day > 30)) {
            System.out.println("Вы ввели недопустимый номер дня");
            return;
        }

        if (countStep < 0) {
            System.out.println("Вы ввели недопустимое количество шагов");
            return;
        }
        steps[month - 1][day - 1] = countStep;
    }

    void showStaticPerMonth(int month) {
        if ((month < 1) || (month > 12)) {
            System.out.println("Вы ввели недопустимый номер месяца");
            return;
        }

        int[] stepsPerMonth = steps[month - 1];

        Converter converter = new Converter(calcSumCountStepPerMonth(stepsPerMonth));

        for (int i = 0; i < steps[month - 1].length; i++) {
            System.out.println((i + 1) + " День: " + steps[month - 1][i]);
        }
        System.out.println("Общее количество шагов за месяц: " + calcSumCountStepPerMonth(stepsPerMonth));
        System.out.println("Макисмальное количество шагов за месяц: " + calcMaxCountStepsPerMonth(stepsPerMonth));
        System.out.println("Среднее количество шагов за месяц: " + calcAvgCountStepsPerMonth(stepsPerMonth));
        System.out.println("Пройденная дистанция в километрах: " + converter.convertStepsToDistance());
        System.out.println("Было сожено каллориев: " + converter.convertStepsToKilocalories());
        System.out.println("Ваша цель по шагам: " + goalSteps);
        System.out.println("Лучшая серия: " + getBestSeries(stepsPerMonth));
    }

    int calcSumCountStepPerMonth(int[] stepsPerMonth) {
        int sumStepPerMonth = 0;

        for (int i = 0; i < stepsPerMonth.length; i++) {
            sumStepPerMonth += stepsPerMonth[i];
        }
        return sumStepPerMonth;
    }

    int calcMaxCountStepsPerMonth(int[] stepsPerMonth) {
        int maxStepPerMonth = 0;
        for (int i = 0; i < stepsPerMonth.length; i++) {
            if (maxStepPerMonth < stepsPerMonth[i]) {
                maxStepPerMonth = stepsPerMonth[i];
            }
        }
        return maxStepPerMonth;
    }

    int calcAvgCountStepsPerMonth(int[] stepsPerMonth) {
        int avgStepPerMonth = 0;

        for (int i = 0; i < stepsPerMonth.length; i++) {
            avgStepPerMonth += stepsPerMonth[i];
        }
        avgStepPerMonth /= 30;
        return avgStepPerMonth;
    }

    void saveGoalSteps(int goalSteps) {
        if (goalSteps < 0) {
            System.out.println("Введено отрицательное количество шагов. Значение не изменено.");
        } else {
            this.goalSteps = goalSteps;
        }
    }

    int getBestSeries(int[] stepsPerMonth) {
        int countDay = 0;
        int bestCountDay = 0;

        for (int i = 0; i < stepsPerMonth.length; i++) {
            if (stepsPerMonth[i] >= goalSteps) {
                countDay += 1;
            } else if (countDay > bestCountDay) {
                bestCountDay = countDay;
                countDay = 0;
            } else {
                countDay = 0;
            }
        }

        if (countDay > bestCountDay) {
            bestCountDay = countDay;
        }

        return bestCountDay;
    }
}
