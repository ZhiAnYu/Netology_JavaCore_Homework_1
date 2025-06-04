import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Phoenix", "Avery", "Casey", "Charlie", "Frankie", "Jesse");
        List<String> surnames = Arrays.asList("Brown", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>(); // создаем новую коллекцию персон
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),        //получаем рандомное имя из списка имен
                    surnames.get(new Random().nextInt(surnames.size())),         //получаем фамилию из списка
                    new Random().nextInt(90),        //любое число от 0 до 90
                    Sex.values()[new Random().nextInt(Sex.values().length)],      //получаем значение пола из enum
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        //Задача №1. Количество несовершеннолетних
        long streamAdult = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println(streamAdult);

        //Задача№2. Список фамилий призывников (М, 18-27)
        List<String> conscript = persons.stream()
                .filter(x -> x.getSex() == Sex.MAN)
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() < 28)
                .map(Person::getSurname)
                .collect(Collectors.toList());
        System.out.println(conscript.toString());

        //Задача№3. Получить отсортированный по фамилии список потенциально работоспособных людей
        // с высшим образованием в выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин
        // и до 65 лет для мужчин).

        List<Person> workers = persons.stream()
                .filter(x -> x.getAge() > 18)
                .filter(x -> x.getEducation() == Education.HIGHER || x.getEducation() == Education.FURTHER)
                .filter(x -> ((x.getSex() == Sex.WOMAN) && (x.getAge() < 60))
                        || ((x.getSex() == Sex.MAN) && (x.getAge() < 65)))
                .sorted(Comparator.comparing(Person::getSurname)
                        .thenComparing(Person::getName)
                        .thenComparing(Person::getAge))
                .collect(Collectors.toList());
        System.out.println(workers);
//        System.out.println(persons);
    }


}


class Person {
    private String name;
    private String surname;
    private Integer age;
    private Sex sex;
    private Education education;

    public Person(String name, String surname, int age, Sex sex, Education education) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }
}