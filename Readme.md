# Тестовое задание

## Модель данных

    IBankAccount
    BankAccount
    CreditBankAccount
    DebitBankAccount
    
    void debit(BigDecimal sum); //пополнение счета
    void credit(BigDecimal sum); //списание со счета
    
* Необходиом создать **Hibernate Entity** использовать **Inheritance**

* Использую паттерн **Visitor** разработать интерефес вывода информации о BankAccount
    * Для **BankAccount** выводить номер счета
    * Для **DebitBankAccount** - выводить amount и признак, что счет debit
    * Для **CreditBankAccount** - выводить minAmount и признак, что счет credit
    
* Использую паттерн **Visitor** разработать интерефес капитализации счета    
    * Для **DebitBankAccount** - пополнять счет на 10 единиц
    * Для **CreditBankAccount** -уменьшать счет на 10 единиц    

* Использую паттерн **Decorator** разработать интерфейс пополнения
    * **BonusBankAccountDecorator** - при пополнении счета начислять бонус 100 единиц
    * **SuperBonusBankAccountDecorator** - при пополнении счета увеличить сумму в два раза
    
* Использую паттерн **Abstract Factory** разработать фабрики создания **BankAccount**
    * **AbstractBankAccountFactory**
    * **CreditBankAccountFactory** - для создания **CreditBankAccount**
    * **DebitBankAccountFactory** - для создания **DebitBankAccount**
    
* Для создания **BankAccount** использовать паттерн **Prototype**

#Замечания по реализации
1. Использована БД postgres, работа проверена на версиях 9.4 и 9.5. Бэкап базы в формат "каталог" находится в ac.backup.zip. 
База должна называться accounts, расположена на localhost на порту 5432, в противном случае надо менять создание источника данных в tryout.middle.Repository.java
2. Temporary поля изменены на тип Date, т к LocalDate не сериализуется
3. Имя поля end изменено на enddate, т к postgres'у не нравится использование ключевого слова в качестве имени столбца.
4. Добавлено поле bonus
5. Добавлено поле isDebt как дискриминатор для Inheritance
6. Под пополнением счета подразумевается дебет для дебетовых счетов и кредит - для кредитовых.
 
Логика тестирования : создаются два счета, затем они клонируются и над ними проводятся описанные в задании операции
