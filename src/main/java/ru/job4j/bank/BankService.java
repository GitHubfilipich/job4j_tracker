package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает главный сервис обработки банковских счетов
 * @author Yury Grichkov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение счетов пользователей осуществляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в коллекцию.
     * Если пользователь уже есть в коллекции, то добавления не происходит
     * @param user пользователь, который добавляется в коллекцию
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход номер паспорта пользователя и удаляет из коллекции соответствующего пользователя.
     * Если такого пользователя нет в коллекции, то удаления не происходит.
     * @param passport номер паспорта пользователя, который должен быть удален
     * @return возвращает true если пользователь был удален или false если пользователя нет в коллекции
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод принимает на вход номер паспорта пользователя и банковский счет и добавляет в коллекцию.
     * Если пользователя нет в коллекции или для пользователя в коллекции уже имеется такой
     * банковский счет, то добавление не выполняется.
     * @param passport номер паспорта пользователя, который должен быть добавлен
     * @param account банковский счет, который должен быть добавлен
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод принимает на вход номер паспорта пользователя и осуществляет поиск
     * соответствующего пользователя в коллекции.
     * @param passport номер паспорта пользователя, по которому будет осуществляться поиск
     * @return возвращает найденного пользователя или null если он не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход номер паспорта пользователя и значение реквизита банковского счета и осуществляет
     * поиск соответствующего счета в коллекции.
     * @param passport номер паспорта пользователя для поиска
     * @param requisite значение реквизита банковского счета для поиска
     * @return возвращает найденный банковский счет или null если он не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход номер паспорта пользователя отправителя, значение реквизита банковского счета
     * отправителя, номер паспорта пользователя получателя, значение реквизита банковского счета получателя
     * и сумму перечисления и осуществляет перечисление денег с одного счета на другой.
     * Если счет отправителя или счет получателя не найден или баланс счета отправителя меньше, чем сумма
     * перечисления, то перечисление не производится.
     * @param srcPassport номер паспорта пользователя отправителя перечисления
     * @param srcRequisite реквизит банковского счета отправителя перечисления
     * @param destPassport номер паспорта пользователя получателя перечисления
     * @param destRequisite реквизит банковского счета получателя перечисления
     * @param amount сумма перечисления
     * @return возвращает true если перечисление денег выполнено или false если не выполнено
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null || srcAccount.getBalance() < amount || destAccount == null) {
            return false;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return true;
    }

    /**
     * Метод принимает на вход пользователя и возвращает коллекцию соответствующих ему банковских счетов в виде
     * коллекции типа List.
     * @param user пользователь счета которого требуется получить
     * @return возвращает коллекцию соответствующих ему банковских счетов в виде коллекции типа List или null
     * если пользователь не найден
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
