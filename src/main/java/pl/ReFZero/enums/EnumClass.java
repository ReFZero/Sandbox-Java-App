package pl.ReFZero.enums;

public class EnumClass {
    /*
    Klasy enum moga:
    - miec prywatny konstruktory
    - miec metody i pola
    - implementowac interfejsy
    Klasy enum nie moga:
    - rozszerzac innej klasy
    - nie moga miec setterow
    - miec publicznego konstruktora
    Są niemutowalne
    Zachwuja sie jak singletony
    */
    public static void main(String[] args) {

        System.out.println(Days.MONDAY.dayNumber);
        System.out.println(Days.MONDAY.getDayNumber());
    }
}
