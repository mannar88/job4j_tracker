package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс эмулирует банковский процесс: добавление клиента, привязка счетов, перевод денег счета на счет
 * @author Viktor Burdin
 * @version1.0
 */
public class BankService {
    /**
     * Хранение учетных записей клиента в  коллекции - тип
     HashMap, приведенный в List     */

    private final Map <User, List<Account>> users = new HashMap<>();

    /**
     * Метод проверяет наличие клиента в коллекции и если запись отсутсутсвует - добавляет в коллекцию
     * @param user - пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод привязывает счета к клиенту и добавляет их в коллекцию
     * @param passport - номер паспорта для поиска клиента
     * @param account - счет клиента
     */
    public void addAccount(String passport, Account account) {
Optional <User>  key = findByPassport(passport);
if (key.isPresent() &&!users.get(key.get()).contains(account)) {
users.get(key.get()).add(account);
}
    }

    /**
     * Метод исчет в коллекции конкретного юзера по паспорту
     * @param passport - данные паспорта
     * @return - на выходе учетная запись клиента
     */
    public Optional <User> findByPassport(String passport) {
        return  users.keySet()
        .stream()
        .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод исчет список счетов по , у конкретного пользователя
      * @param passport - данные паспорта
     * @param requisite - счет
     * @return- ссписок счетов, если такие найдутся
     */
    public Optional <Account> findByRequisite(String passport, String requisite) {
Optional <User> user = findByPassport(passport);
if (user.isPresent()) {
return  users.get(user.get())
        .stream()
        .filter(a -> a.getRequisite().equals(requisite))
        .findFirst();

}
        return Optional.empty();
    }

    /**
     * метод переводит деньги из одного счета, на другой.
     * @param srcPassport - данные паспорта, от куда перевод.
     * @param srcRequisite - счет, от куда перевод.
     * @param destPassport - данные пасорта, куда перевод
     * @param destRequisite -счет, куда перевод
     * @param amount - сумма перевод
     * @return - true, если перевод совершен, false, если нет
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional <Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional <Account> deftAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && deftAccount.isPresent()&& srcAccount.get().getBalance() >= amount) {
srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
deftAccount.get().setBalance(deftAccount.get().getBalance() + amount);
rsl = true;
        }
            return rsl;
    }
}