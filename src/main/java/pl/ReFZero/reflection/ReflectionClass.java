package pl.ReFZero.reflection;

import java.lang.reflect.*;

public class ReflectionClass {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        //Pola obiektu
        Person person1 = new Person("Rafal", 45);
        Field[] personFields = person1.getClass().getDeclaredFields();
        // Zamiana wartosci pola pomimo tego ze jest private final
        for (Field field : personFields) {
            if (field.getName().equals("name")) {
                // Ustawienie dostepu do pola
                field.setAccessible(true);
                field.set(person1, "David");
            }
        }
        System.out.println(person1);

        //Metody
        Person person2 = new Person("Rafal", 45);
        Method[] personMethods = person2.getClass().getDeclaredMethods();
        //publiczna metoda bez parametrow
        for (Method method : personMethods) {
            if (method.getName().equals("publicMethod")) {
                method.invoke(person2);
            }
        }
        //publiczna metoda z parametrami
        for (Method method : personMethods) {
            if (method.getName().equals("publicMethodWithParameters")) {
                method.invoke(person2, 1, 2);
            }
        }
        //prywatna metoda
        for (Method method : personMethods) {
            if (method.getName().equals("privateMethod")) {
                // Ustawienie dostepu do pola
                method.setAccessible(true);
                method.invoke(person2);
            }
        }
        //statyczna publiczna metoda
        for (Method method: personMethods){
            if (method.getName().equals("publicAndStaticMethod")){
                //metoda statyczna dlatego null
                method.invoke(null);
            }
        }
        //statyczna prywatna metoda
        for (Method method: personMethods){
            if (method.getName().equals("privateAndStaticMethod")){
                method.setAccessible(true);
                method.invoke(null);
            }
        }
        //Pobieranie nazwy klasy z obiektu
        Class<?> clazz = person2.getClass();
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getCanonicalName());

        //Sprawdzenie modyfikatorów klasy z obiektu
        String className = person2.getClass().getCanonicalName();
        Class<?> personClass1 = Class.forName(className);

        // (modifiers1) Liczba całkowita, która jest sumą wartości stałych definiowanych w klasie Modifier.
        // Dlatego używamy metod takich jak isPublic() w klasie Modifier, aby sprawdzić,
        // czy dany modyfikator jest obecny w liczbie całkowitej zwróconej przez getModifiers().
        int modifiers1 = personClass1.getModifiers();
        System.out.println((Modifier.isPublic(modifiers1)));
        System.out.println((Modifier.isPrivate(modifiers1)));
        System.out.println((Modifier.isAbstract(modifiers1)));
        System.out.println((Modifier.isFinal(modifiers1)));
        //Mozna rowniez inne modyfikatory...

        //Sprawdzenie modyfikatorów klasy z bezposrednio z klasy
        Class<?> personClass2 = Person.class;
        int modifiers2 = personClass2.getModifiers();
        System.out.println((Modifier.isPublic(modifiers2)));
        System.out.println((Modifier.isPrivate(modifiers2)));
        System.out.println((Modifier.isAbstract(modifiers2)));
        System.out.println((Modifier.isFinal(modifiers2)));
        //Mozna rowniez inne modyfikatory...

        //Sprawdzanie package klasy
        Package personPackage = personClass2.getPackage();
        System.out.println(personPackage.getName());

        //Sprawdzanie interfejsow
        Class<?>[] interfacesPerson = personClass2.getInterfaces();
        for (Class<?> interfaceName: interfacesPerson) {
            System.out.println(interfaceName.getName());
        }

        //Sprawdzanie konstruktorow z ich paramtrami
        Constructor<?>[] constructors = personClass2.getConstructors();
        for (Constructor<?> constructor :constructors) {
            Parameter[] parameters = constructor.getParameters();
            System.out.println(constructor.getName());

            for (Parameter parameter : parameters) {
                System.out.println("nazwa: " + parameter.getName() + " typ: " + parameter.getType());
            }
        }
    }
}
