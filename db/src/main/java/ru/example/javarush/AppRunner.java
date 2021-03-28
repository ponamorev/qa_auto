package ru.example.javarush;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.example.javarush.models.Auto;
import ru.example.javarush.models.User;
import ru.example.javarush.services.UserService;
import ru.example.javarush.utils.HibernateSessionFactoryUtil;

import java.util.List;

@Slf4j
public class AppRunner {
    public static void main(String[] args) {
        UserService service = new UserService();

        // create a user with two cars
//        User user = new User(Names.MASHA.name, 26);
//        service.saveUser(user);
//        Auto ferrari = new Auto(Cars.FERRARI.name, Colors.RED.name);
//        addAutoToUser(ferrari, user);
//        Auto ford = new Auto(Cars.FORD.name, Colors.BLACK.name);
//        addAutoToUser(ford, user);
//        service.updateUser(user);
//        service.deleteUser(user);

        // get user by id and delete it
//        User gottenUser = service.findUser(4);
//        service.deleteUser(gottenUser);

        // create two users and get both of them from DB
//        User one = new User(Names.MASHA.name, 30);
//        User two = new User(Names.SASHA.name, 31);
//        service.saveUser(one);
//        service.saveUser(two);
        List<User> allUser = service.findAllUsers();
        allUser.forEach(u -> log.info(u.toString()));

        HibernateSessionFactoryUtil.getSessionFactory().close();
    }

    @AllArgsConstructor
    private enum Cars {
        FERRARI("Ferrari"),
        FORD("Ford");

        private final String name;
    }

    @AllArgsConstructor
    private enum Names {
        MASHA("Masha"),
        SASHA("Sasha");

        private final String name;
    }

    @AllArgsConstructor
    private enum Colors {
        RED("red"),
        BLACK("black");

        private final String name;
    }

    private static void addAutoToUser(Auto auto, User user) {
        auto.setUser(user);
        user.addAuto(auto);
    }
}
