package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета
 * @author Yury Grichkov
 * @version 1.0
 */
public class Account {
    /**
     * Хранение реквизита банковского счета осуществляется в поле строкового типа
     */
    private String requisite;
    /**
     * Хранение баланса банковского счета осуществляется в поле числового типа
     */
    private double balance;

    /**
     * Конструктор принимает на вход реквизит и баланс банковского счета и создаёт новый банковский счет
     * @param requisite реквизит банковского счета
     * @param balance баланс банковского счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизит банковского счета
     * @return возвращает реквизит банковского счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод принимает на вход значение и устанавливает его реквизиту банковского счета
     * @param requisite значение для установки реквизита банковского счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс банковского счета
     * @return возвращает баланс банковского счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод принимает на вход значение и устанавливает его балансу банковского счета
     * @param balance значение для установки баланса банковского счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод класса Object принимает на вход значение и проверяет его на равенство текущему объекту
     * по значению реквизита банковского счета.
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод класса Object возвращает хэш-код текущего объекта по значению реквизита банковского счета.
     * @return возвращает хэш-код текущего объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
