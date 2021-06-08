Feature: Dodanie nowego adresu zalogowanego użytkownika

  Scenario Outline: Dodanie nowego adresu zalogowanego użytkownika
    Given Użytkownik jest zalogowany
    When Użytkownik jest na stronie <page>
    And kliknij na Create new address
    And w polu Alias wpisz <alias>
    And w polu Company wpisz <company>
    And w polu VAT number wpisz <vat>
    And w polu Address wpisz <address1>
    And w polu Address Complement wpisz <address2>
    And w polu City wpisz <city>
    And w polu Zip/Postal Code wpisz <postcode>
    And z listy Country wybiesz <country>
    And w polu Phone wpisz <phone>
    And zapisz nowy adres
    And sprawdź poprawność zapisanego adresu
    Then zamknij strone


    Examples:
      | alias    | company  | vat   | address1 | address2 | postcode    | city   | country        | phone  | page                                                          |
      | Nowy2 | company1 | vat23 | Adres1   | Adres2   | kod | Miasto | United Kingdom | 123123 | https://prod-kurs.coderslab.pl/index.php?controller=addresses |