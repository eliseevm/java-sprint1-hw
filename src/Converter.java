public class Converter {
    double lengthStep = 0.75;
    int stepKal = 50;
    int kKal = 1000;
    void convert(int step){
        double distanc = step * lengthStep;
        int sumKal = step * stepKal;
        System.out.println("Пройдя дистанцию " + distanc / 1000 + " Километра, " +
                "Вы сожгли " + (step * stepKal) / 1000 + " Килокалорий");
    }
}
