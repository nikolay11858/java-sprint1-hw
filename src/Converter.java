public class Converter {
    int sumStepPerMonth = 0;

    double stepToKilocalories = 0.05;
    double stepToKm = 0.075;


    Converter(int sumStepPerMonth) {
        this.sumStepPerMonth = sumStepPerMonth;
    }

    double convertStepsToDistance() {
        return sumStepPerMonth * stepToKm;
    }

    double convertStepsToKilocalories() {
        return sumStepPerMonth * stepToKilocalories;
    }
}
