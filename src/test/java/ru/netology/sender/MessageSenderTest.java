package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.GeoService;
import ru.netology.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;


public class MessageSenderTest {

    @Test
    public void russianTextSendTest(){
        /*
                Mocking
         */

        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry()).thenReturn(Country.RUSSIA);


        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(GeoServiceImpl.MOSCOW_IP)).thenReturn(location);

        LocalizationService locService = Mockito.mock(LocalizationService.class);
        Mockito.when(locService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        // **** Implementation

        MessageSender messageSender = new MessageSenderImpl(geoService, locService);


        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.MOSCOW_IP);
        String expected = locService.locale(Country.RUSSIA);

        /*
                Tests
         */
        Assertions.assertEquals(expected, messageSender.send(headers));
        Assertions.assertNotNull(messageSender.send(headers));


    }

    @Test
    public void englishTextSendTest(){
        /*
                Mocking
         */
        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry()).thenReturn(Country.USA);


        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(GeoServiceImpl.NEW_YORK_IP)).thenReturn(location);

        LocalizationService locService = Mockito.mock(LocalizationService.class);
        Mockito.when(locService.locale(Country.USA)).thenReturn("Welcome");

        // **** Implementation
        MessageSender messageSender = new MessageSenderImpl(geoService, locService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.NEW_YORK_IP);
        String expected = locService.locale(Country.USA);

        /*
                Tests
         */
        Assertions.assertEquals(expected, messageSender.send(headers));
        Assertions.assertNotNull(messageSender.send(headers));

    }

}
