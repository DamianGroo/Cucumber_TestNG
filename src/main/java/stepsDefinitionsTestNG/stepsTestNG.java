package stepsDefinitionsTestNG;

import Utliliti.PropertiesFileReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import java.util.Properties;

public class stepsTestNG {


    public void czas(int milisekundy) {
        try {
            Thread.sleep(milisekundy);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    WebDriver driver;

PropertiesFileReader obj = new PropertiesFileReader();


//// test nr 1 - poprawne dane logowania




    @Given("^Użytkownik uruchamia strone serwisu$")
    public void użytkownik_uruchamia_strone_serwisu() throws Throwable {

        Properties properties = obj.getProperty();

        System.setProperty("webdriver.chrome.driver", "E:\\mvnrepository.com\\chromeDriver_Wersja_83\\chromedriver.exe");


        driver = new ChromeDriver();
        String url = "https://www.mediaexpert.pl/";
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @When("^Strona główna serwisu Media Expert jest wyświetlona$")
    public void strona_główna_serwisu_Media_Expert_jest_wyświetlona() throws Throwable {
        String nazwaSerwisu = "Media Expert | Sklep internetowy RTV, AGD, komputery";
        String otrzymanaNazwaSerwisu = driver.getTitle();
        Assert.assertEquals(nazwaSerwisu, otrzymanaNazwaSerwisu);
    }

    @Then("^Użytkownik klika na przycisk Twoje konto$")
    public void użytkownik_klika_na_przycisk_Twoje_konto() throws Throwable {
        czas(3000);
        //driver.findElement(By.linkText("\n" +
        //       "Zaloguj/Zarejestruj")).click();
        //  driver.findElement(By.className("c-menu_linkName")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[5]/div/div/div[3]/div/ul/li[3]/div/a/span[1]")).click();
    }

    @Then("^Użytkownik czeka na załadowanie się strony$")
    public void użytkownik_czeka_na_załadowanie_się_strony() throws Throwable {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Logowanie")));
        czas(5000);
    }

    @Then("^użytkownik wprowadza w pole login swój login$")
    public void użytkownik_wprowadza_w_pole_login_swój_login() throws Throwable {
        String email = "ddd-ggg-ddd-ggg@wp.pl";
        driver.findElement(By.id("enp_customer_form_login_username")).click();
        driver.findElement(By.id("enp_customer_form_login_username")).sendKeys(email);
        czas(1000);
    }

    @Then("^użytkownik wprowadza w pole hasło swoje hasło$")
    public void użytkownik_wprowadza_w_pole_hasło_swoje_hasło() throws Throwable {
        String haslo = "5ontoTestowe";
        driver.findElement(By.id("enp_customer_form_login_password")).click();
        driver.findElement(By.id("enp_customer_form_login_password")).sendKeys(haslo);
        czas(1000);
    }

    @Then("^użytkownik klika na przycisk zaloguj$")
    public void użytkownik_klika_na_przycisk_zaloguj() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div[7]/div/div/div[1]/div[1]/div[2]/form/div[4]/div/input")).click();
        //    driver.findElement(By.linkText("Zaloguj się")).click();
    }

    @Then("^Strona powitalna jest wyświetlona$")
    public void strona_powitalna_jest_wyświetlona() throws Throwable {
        czas(5000);
        String wynikLogowania = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[5]/div/div/div[3]/div/ul/li[3]/p/span[1]")).getText();

        //driver.findElement(By.className("is-user")).getText();
        Assert.assertEquals("Witaj DDD", wynikLogowania);
    }

    @Then("^Test nr jeden zakonczony$")
    public void test_nr_jeden_zakonczony() throws Throwable {
        driver.close();
    }



// test nr 2 - niepoprawne dane logowania



    @Then("^użytkownik wprowadza w pole hasło błędne hasło$")
    public void użytkownik_wprowadza_w_pole_hasło_błędne_hasło() throws Throwable {
        String Zlehaslo = "invalidinvalidinvalid";
        driver.findElement(By.id("enp_customer_form_login_password")).click();
        driver.findElement(By.id("enp_customer_form_login_password")).sendKeys(Zlehaslo);
        czas(1000);
    }


    @Then("^Strona z komunikatem błędnego logowania jest widoczna$")
    public void strona_z_komunikatem_błędnego_logowania_jest_widoczna() throws Throwable {
        czas(5000);
        String wynikLogowania = driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/p")).getText();
        String spodziewanyKomunikat = "Nieprawidłowa nazwa użytkownika lub hasło";

        //driver.findElement(By.className("is-user")).getText();
        Assert.assertEquals(spodziewanyKomunikat, wynikLogowania);
    }


    @Then("^Test nr dwa zakonczony$")
    public void test_nr_dwa_zakonczony() throws Throwable {
        driver.close();
    }




// test nr 3 - wyszukiwanie produktu


    @Then("^Użytkownik wpisuje szukany produkt w wyszukiwarke$")
    public void użytkownik_wpisuje_szukany_produkt_w_wyszukiwarke() throws Throwable {
        String produkt = "Smartfon APPLE iPhone 11 Pro Max 64GB Srebrny";
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[5]/div/div/div[2]/div/div[1]/div[1]/form/input")).sendKeys(produkt);

    }

    @Then("^Użytkownik czeka na znalezienie produktu$")
    public void użytkownik_czeka_na_znalezienie_produktu() throws Throwable {
        czas(6000);
    }

    @Then("^Użytkownik klika na znaleziony produkt$")
    public void użytkownik_klika_na_znaleziony_produkt() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[5]/div/div/div[2]/div/div[2]/div[2]/div[1]/div")).click();
        czas(3000);
        //   String tytulTejStrony = driver.getTitle();
        //   System.out.println(tytulTejStrony);
        //   czas(2000);
    }


    @Then("^Weryfikacja tytulu strony z wyszukanym produktem$")
    public void Weryfikacja_tytulu_strony_z_wyszukanym_produktem() throws Throwable {
        String spodziewanyTytulStrony = "APPLE iPhone 11 Pro Max 64GB Srebrny Smartfon - ceny i opinie w Media Expert";
        String tytulTejStrony = driver.getTitle();
        Assert.assertEquals(spodziewanyTytulStrony, tytulTejStrony);
    }


    @Then("^Test nr trzy zakonczony$")
    public void test_nr_trzy_zakonczony() throws Throwable {
        driver.close();
    }


// test nr 4 - nieudana rejestracja


    @Then("^użytkownik klika przycisk Rejestracja$")
    public void użytkownik_klika_przycisk_Rejestracja() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div[7]/div/div/div[2]/div[3]/a")).click();
    }

    @Then("^użytkownik czeka na wyświetlenie się formularza rejestracji$")
    public void użytkownik_czeka_na_wyświetlenie_się_formularza_rejestracji() throws Throwable {
        czas(3000);
    }

    @Then("^użytkownik wprowadza dane bez adresu email$")
    public void użytkownik_wprowadza_dane_bez_adresu_email() throws Throwable {
        String imie = "Elon";
        String nazwisko = "Forest";
        String fakeHaslo = "123456789";

        driver.findElement(By.xpath("//*[@id=\"enp_customer_registration_form_type_address_firstName\"]")).sendKeys(imie);
        driver.findElement(By.xpath("//*[@id=\"enp_customer_registration_form_type_address_lastName\"]")).sendKeys(nazwisko);
        driver.findElement(By.xpath("//*[@id=\"enp_customer_registration_form_type_plainPassword\"]")).sendKeys(fakeHaslo);
        czas(1500);
    }

    @Then("^uzytkownik klika przycisk zapoznania sie z regulaminem$")
    public void uzytkownik_klika_przycisk_zapoznania_sie_z_regulaminem() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div[7]/div/div[1]/div[1]/div/div[2]/form/div[5]/div/label[3]/div[1]/p")).click();
        czas(1500);
    }

    @Then("^użytkownik klika przycisk Zalóż Konto$")
    public void użytkownik_klika_przycisk_Zalóż_Konto() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div[7]/div/div[1]/div[1]/div/div[2]/form/div[6]/div/input")).click();
    }

    @Then("^Użytkownik czeka na przetworzenie sie formularza$")
    public void użytkownik_czeka_na_przetworzenie_sie_formularza() throws Throwable {
        czas(2000);
    }

    @Then("^Pojawia się komunikat o błędzie$")
    public void pojawia_się_komunikat_o_błędzie() throws Throwable {
        String oczekiwanyBladEmail = "To pole jest wymagane";
        String aktualnyBlad = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div/div[1]/div[1]/div/div[2]/form/div[3]/div/div[2]")).getText();
        Assert.assertEquals(oczekiwanyBladEmail, aktualnyBlad);

    }

    @Then("^Test nr cztery zakonczony$")
    public void test_nr_cztery_zakonczony() throws Throwable {
        driver.close();
    }



    // test nr 5 - dodanie produktu do koszyka


    @Then("^Użytkownik dodaje produkt do koszyka$")
    public void Użytkownik_dodaje_produkt_do_koszyka() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[2]/div[15]/div[1]/div/div[2]/div/div/div[3]/div[4]/div[1]/div[2]/a")).click();
        czas(6000);
        driver.findElement(By.xpath("//*[@id=\"preCart\"]/div/div/div/div/div[2]/div[3]/div/a[1]")).click();
        czas(2000);
        driver.findElement(By.xpath("//*[@id=\"preCart\"]/div/div/div/div/div[2]/div[3]/div/a[1]")).click();
        czas(10000);
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div[1]/div/div/div[1]/p/a/picture/img")).click();
        czas(9000);

        //     WebDriverWait waiter = new WebDriverWait(driver, 15000);
        //     waiter.until( ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[5]/div/div/div[3]/div/ul/li[5]/div/div[1]/span[3]")) );
        //   driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[5]/div/div/div[3]/div/ul/li[5]/div/div[1]/span[3]")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[5]/div/div/div[3]/div/ul/li[5]/div/div[1]/span[2]")).click();
        czas(6000);

        String jakiProdukt = driver.findElement(By.xpath("/html/body/div[1]/div[9]/div/form/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/a")).getText();
        String spodziewanyProdukt = "Smartfon APPLE iPhone 11 Pro Max 64GB Srebrny";
        Assert.assertEquals(spodziewanyProdukt, jakiProdukt);
    }


    @Then("^Test nr piec zakonczony$")
    public void test_nr_piec_zakonczony() throws Throwable {
        driver.close();
    }



// test nr 6 - weryfikacja koloru ikonki



    @Then("^Pobranie koloru$")
    public void Pobranie_koloru() throws Throwable {

        String color = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[6]/div/div/div[1]/div/ul/li")).getCssValue("color");
        String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

        int hexValue1=Integer.parseInt(hexValue[0]);
        hexValue[1] = hexValue[1].trim();
        int hexValue2=Integer.parseInt(hexValue[1]);
        hexValue[2] = hexValue[2].trim();
        int hexValue3=Integer.parseInt(hexValue[2]);

        String kolorZeStrony = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);

        //   Assert.assertEquals("#fff200", kolorZeStrony);

        Assert.assertEquals("#333333", kolorZeStrony);

        czas(4000);
    }




    @Then("^Test nr szesc zakonczony$")
    public void test_nr_szesc_zakonczony() throws Throwable {
        driver.close();
    }



// Test nr 7 - test ktory konczy sie niepowodzeniem


    @Then("^Tytuł sekcji jest inny niż oczekiwany$")
    public void Tytuł_sekcji_jest_inny_niż_oczekiwany() throws Throwable {
        String nazwaSekcji = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div/div/div[1]/div[1]/div[1]/p")).getText();
        String docelowaNazwaSekcji = "Strefa Logowania";
        Assert.assertEquals(docelowaNazwaSekcji, nazwaSekcji);
    }

    @Then("^Test nr siedem zakonczony$")
    public void test_nr_siedem_zakonczony() throws Throwable {
        driver.close();
    }











}
