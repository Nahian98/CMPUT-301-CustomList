package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Dhaka", "Lalbagh");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City city = new City("Barisal", "Potuakhali");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Dhaka", "Mirpur");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();

        City city = new City("Chittagong", "Rangamati");
        cityList.add(city);

        assertEquals(2, cityList.countCities());

        cityList.delete(mockCity());

        assertEquals(1, cityList.countCities());
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());
    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Dhaka", "Dhanmondi");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

}
