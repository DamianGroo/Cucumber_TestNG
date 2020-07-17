
@grupaScenariuszy
Feature: TestNG + Cucumber



  @test1_poprawneLogowanie
  Scenario: Użytkownik wprowadza poprawne dane logowania
    Given Użytkownik uruchamia strone serwisu
    Then Strona główna serwisu Media Expert jest wyświetlona
    And Użytkownik klika na przycisk Twoje konto
    And Użytkownik czeka na załadowanie się strony
    And użytkownik wprowadza w pole login swój login
    And użytkownik wprowadza w pole hasło swoje hasło
    And użytkownik klika na przycisk zaloguj
    And Strona powitalna jest wyświetlona
    And Test nr jeden zakonczony


  @test2_NiePoprawneLogowanie
  Scenario: Użytkownik wprowadza nie poprawne dane logowania
    Given Użytkownik uruchamia strone serwisu
    Then Strona główna serwisu Media Expert jest wyświetlona
    And Użytkownik klika na przycisk Twoje konto
    And Użytkownik czeka na załadowanie się strony
    And użytkownik wprowadza w pole login swój login
    And użytkownik wprowadza w pole hasło błędne hasło
    And użytkownik klika na przycisk zaloguj
    And Strona z komunikatem błędnego logowania jest widoczna
    And Test nr dwa zakonczony



  @test3_WyszukanieProduktu
  Scenario: Użytkownik wyszukuje konkretny produkt
    Given Użytkownik uruchamia strone serwisu
    Then Strona główna serwisu Media Expert jest wyświetlona
    And Użytkownik klika na przycisk Twoje konto
    And Użytkownik czeka na załadowanie się strony
    And użytkownik wprowadza w pole login swój login
    And użytkownik wprowadza w pole hasło swoje hasło
    And użytkownik klika na przycisk zaloguj
    And Strona powitalna jest wyświetlona
    And Użytkownik wpisuje szukany produkt w wyszukiwarke
    And Użytkownik czeka na znalezienie produktu
    And Użytkownik klika na znaleziony produkt
    And Weryfikacja tytulu strony z wyszukanym produktem
    And Test nr trzy zakonczony



  @test4_NieudanaRejestracja
  Scenario: Użytkownik błędnie wypełnia formularz rejestracji
    Given Użytkownik uruchamia strone serwisu
    Then Strona główna serwisu Media Expert jest wyświetlona
    And Użytkownik klika na przycisk Twoje konto
    And Użytkownik czeka na załadowanie się strony
    And użytkownik klika przycisk Rejestracja
    And użytkownik czeka na wyświetlenie się formularza rejestracji
    And użytkownik wprowadza dane bez adresu email
    And uzytkownik klika przycisk zapoznania sie z regulaminem
    And użytkownik klika przycisk Zalóż Konto
    And Użytkownik czeka na przetworzenie sie formularza
    And Pojawia się komunikat o błędzie
    And Test nr cztery zakonczony


  @test5_DodaniePrzedmiotuDoKoszyka
  Scenario: Użytkownik dodaje produkt do koszyka
    Given Użytkownik uruchamia strone serwisu
    Then Strona główna serwisu Media Expert jest wyświetlona
    And Użytkownik klika na przycisk Twoje konto
    And Użytkownik czeka na załadowanie się strony
    And użytkownik wprowadza w pole login swój login
    And użytkownik wprowadza w pole hasło swoje hasło
    And użytkownik klika na przycisk zaloguj
    And Strona powitalna jest wyświetlona
    And Użytkownik wpisuje szukany produkt w wyszukiwarke
    And Użytkownik czeka na znalezienie produktu
    And Użytkownik klika na znaleziony produkt
    And Weryfikacja tytulu strony z wyszukanym produktem
    And Użytkownik dodaje produkt do koszyka
    And Test nr piec zakonczony


  @test6_sprawdzenieKoloru
  Scenario: Weryfikacja koloru czcionki
    Given Użytkownik uruchamia strone serwisu
    Then Strona główna serwisu Media Expert jest wyświetlona
    And Pobranie koloru
    And Test nr szesc zakonczony


  @test7_TestKtoryKonczySieNiepowodzeniem
  Scenario: Demonstracja negatywnego wyniku testu
    Given Użytkownik uruchamia strone serwisu
    Then Strona główna serwisu Media Expert jest wyświetlona
    And Użytkownik klika na przycisk Twoje konto
    And Użytkownik czeka na załadowanie się strony
    And Tytuł sekcji jest inny niż oczekiwany
    And Test nr siedem zakonczony


  @test_z_waiterem
  Scenario: WAITERWAITERWAITER
    Given WAITER Użytkownik uruchamia strone serwisu
    Then WAITER Strona główna serwisu Media Expert jest wyświetlona
    And WAITER Użytkownik klika na przycisk Twoje konto
    And WAITER Użytkownik czeka na załadowanie się strony
    And WAITER użytkownik wprowadza w pole login swój login
    And WAITER użytkownik wprowadza w pole hasło swoje hasło
    And WAITER użytkownik klika na przycisk zaloguj
    And WAITER Strona powitalna jest wyświetlona
    And WAITER Użytkownik wpisuje szukany produkt w wyszukiwarke
    And WAITER Użytkownik czeka na znalezienie produktu
    And WAITER Użytkownik klika na znaleziony produkt
    And WAITER Weryfikacja tytulu strony z wyszukanym produktem
    And WAITER Użytkownik dodaje produkt do koszyka
    And WAITER Test nr piec zakonczony
    