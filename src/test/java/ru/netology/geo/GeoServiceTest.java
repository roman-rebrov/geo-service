package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.GeoService;
import ru.netology.GeoServiceImpl;


public class GeoServiceTest {

    @Test
    public void defineLocationTest(){


        GeoService geo = new GeoServiceImpl();

        Location moscow = geo.byIp(GeoServiceImpl.MOSCOW_IP);
        Location nyc = geo.byIp(GeoServiceImpl.NEW_YORK_IP);


        /*
                Tests
         */

        Assertions.assertNotNull(moscow);
        Assertions.assertEquals(Country.RUSSIA, moscow.getCountry());

        Assertions.assertNotNull(nyc);
        Assertions.assertEquals(Country.USA, nyc.getCountry());

    }
}
