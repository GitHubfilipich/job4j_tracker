package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("postbox177@yandex.ru", "Pushkin Aleksandr Sergeevich");
        map.put("mail@yandex.ru", "Mailov Yandex Ruevich");
        map.put("yandex@mail.ru", "Yandexov Mail Ruevich");
        map.put("postbox177@yandex.ru", "Aleksandrov Sergey Pushkinovich");
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
