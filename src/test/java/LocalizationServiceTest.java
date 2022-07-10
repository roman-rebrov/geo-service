import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;


public class LocalizationServiceTest {

    @Test
    public void getTextTest(){

        LocalizationService loc = new LocalizationServiceImpl();
        String greet = loc.locale(Country.USA);


        /*
                Tests
         */

        Assertions.assertNotNull(loc);
        Assertions.assertEquals("Welcome", greet);


    }
}
