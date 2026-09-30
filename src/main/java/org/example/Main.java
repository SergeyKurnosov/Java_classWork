package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import task_1.Book;
import task_2.Student;
import task_3.Address;
import task_3.User;

import java.lang.reflect.Type;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        /*
        1.Создай класс Book с полями title (String), author (String), year (int), price (double).
        Создай объект, преобразуй его в JSON-строку через Gson и выведи в консоль. Затем включи красивый вывод через
        GsonBuilder().setPrettyPrinting() и сравни результат.
         */
        Book book = new Book("book","author",2026,12.3);
        Gson gson = new Gson();
        String json = gson.toJson(book);
        System.out.println(json);// {"title":"book","author":"author","year":2026,"price":12.3}

        gson = new GsonBuilder().setPrettyPrinting().create();
        json = gson.toJson(book);
        System.out.println(json);
        /*
        {
  "title": "book",
  "author": "author",
  "year": 2026,
  "price": 12.3
}
         */
        //============================================================================
        /*
        2.Дана JSON-строка:
        [
        {"name": "Аня", "age": 19, "grade": 4.5},
        {"name": "Борис", "age": 21, "grade": 3.8},
        {"name": "Вера", "age": 20, "grade": 4.9}
        ]
        Создай класс Student, десериализуй строку в List<Student> ( нужен TypeToken), затем выведи имена студентов с оценкой
        выше 4.0 и средний балл всей группы.
         */
        String json2 = "[{\"name\": \"Аня\", \"age\": 19, \"grade\": 4.5}," +
                "{\"name\": \"Борис\", \"age\": 21, \"grade\": 3.8}," +
                "{\"name\": \"Вера\", \"age\": 20, \"grade\": 4.9}" +
                "]";

        Type studentList = new TypeToken<List<Student>>(){}.getType();
        List<Student> students = gson.fromJson(json2, studentList);
        students.stream().filter(s->s.grade()>4.0).forEach(System.out::println);
        double result= students.stream().mapToDouble(Student::grade).average().orElse(0.0);
        System.out.println(result);

        //============================================================================
        /*
        3.Вложенные объекты и скрытие поля
        Создай классы Address (city, street) и User (login, password, address, список List<String> hobbies).
        Сериализуй пользователя в JSON так, чтобы поле password в результат не попало
        (используй @Expose с excludeFieldsWithoutExposeAnnotation()). Затем десериализуй полученный JSON обратно и проверь,
        что password у нового объекта равен null.
         */
        User user = new User("user","password",new Address("city","street"),List.of("hobbie1","hobbie2","hobbie3"));
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        String json3 = gson.toJson(user);
        System.out.println(json3);

        User user2 = gson.fromJson(json3,User.class);
        System.out.println(user2); // User[login=user, password=null, address=Address[city=city, street=street], hobbies=[hobbie1, hobbie2, hobbie3]]


        //============================================================================












    }
}
