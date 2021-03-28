package ru.example.javarush.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Setter
    private String name;
    @Setter
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<Auto> autos = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addAuto(Auto auto) {
        auto.setUser(this);
        autos.add(auto);
    }

    public void removeAuto(Auto auto) {
        autos.remove(auto);
    }

    @Override
    public String toString() {
        String autosStr;
        if (Objects.isNull(autos) || autos.isEmpty()) {
            autosStr = "[]";
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            for (Auto a : autos) {
                builder.append(a);
            }
            builder.append("]");
            autosStr = builder.toString();
        }
        return String.format("User(id=%d, name=%s, age=%d, autos=%s)",
                id, name, age, autosStr);
    }
}
