package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка
 * @author Yury Grichkov
 * @version 1.0
 */
public class User {
    /**
     * Хранение номера паспорта пользователя осуществляется в поле строкового типа
     */
    private String passport;
    /**
     * Хранение имени пользователя осуществляется в поле строкового типа
     */
    private String username;

    /**
     * Конструктор принимает на вход номер паспорта и имя пользователя и создаёт нового пользователя
     * @param passport номер паспорта пользователя
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить номер паспорта пользователя.
     * @return номер паспорта пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод принимает на вход значение и устанавливает его номеру паспорта пользователя
     * @param passport значение для установки его номеру паспорта пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить имя пользователя.
     * @return возвращает имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод принимает на вход значение и устанавливает его имени пользователя
     * @param username значение для установки его имени пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод класса Object принимает на вход значение и проверяет его на равенство текущему объекту
     * по значению номера паспорта пользователя
     * @param o значение, которое проверяется на равенство текущему объекту
     * @return возвращает true если объекты равны и false если нет
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенный метод класса Object возвращает хэш-код текущего объекта по значению номера паспорта пользователя.
     * @return возвращает хэш-код текущего объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
