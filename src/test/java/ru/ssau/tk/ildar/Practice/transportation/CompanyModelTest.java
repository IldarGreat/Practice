package ru.ssau.tk.ildar.Practice.transportation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static ru.ssau.tk.ildar.Practice.Gender.*;
import static ru.ssau.tk.ildar.Practice.transportation.SettlementType.*;
import static ru.ssau.tk.ildar.Practice.transportation.WaypointType.*;


public class CompanyModelTest {
    Settlement settlementOne = new Settlement();
    Settlement settlementTwo = new Settlement();
    Settlement settlementThree = new Settlement();
    Settlement settlementFour = new Settlement();
    Settlement settlementFive = new Settlement();
    Settlement settlementSix = new Settlement();
    Settlement settlementSeven = new Settlement();
    Settlement settlementEight = new Settlement();
    Settlement settlementNine = new Settlement();
    Settlement settlementTen = new Settlement();
    Waypoint waypointOne = new Waypoint();
    Waypoint waypointTwo = new Waypoint();
    Waypoint waypointThree = new Waypoint();
    Waypoint waypointFour = new Waypoint();
    Waypoint waypointFive = new Waypoint();
    Waypoint waypointSix = new Waypoint();
    Waypoint waypointSeven = new Waypoint();
    Waypoint waypointEight = new Waypoint();
    Waypoint waypointNine = new Waypoint();
    Waypoint waypointTen = new Waypoint();
    Route routeOne = new Route();
    Route routeTwo = new Route();
    Route routeThree = new Route();
    Route routeFour = new Route();
    Route routeFive = new Route();
    Driver driverOne = new Driver();
    Driver driverTwo = new Driver();
    Driver driverThree = new Driver();
    Driver driverFour = new Driver();
    Driver driverFive = new Driver();
    Date dateOne = new Date(51278651L);
    Date dateTwo = new Date(51273578L);
    Date dateThree = new Date(51243256L);
    Date dateFour = new Date(51412234L);
    Date dateFive = new Date(51242141L);

    public CompanyModelTest() {
        settlementOne.setSettlementType(CITY);
        settlementTwo.setSettlementType(CITY);
        settlementThree.setSettlementType(CITY);
        settlementFour.setSettlementType(CITY);
        settlementFive.setSettlementType(CITY);
        settlementSix.setSettlementType(VILLAGE);
        settlementSeven.setSettlementType(VILLAGE);
        settlementEight.setSettlementType(VILLAGE);
        settlementNine.setSettlementType(VILLAGE);
        settlementTen.setSettlementType(VILLAGE);

        settlementOne.setSettlement(2345021);
        settlementTwo.setSettlement(234021);
        settlementThree.setSettlement(123574);
        settlementFour.setSettlement(1457831);
        settlementFive.setSettlement(2332421);
        settlementSix.setSettlement(367);
        settlementSeven.setSettlement(2332);
        settlementEight.setSettlement(1262);
        settlementNine.setSettlement(1523);
        settlementTen.setSettlement(158);

        settlementOne.setName("Kazan");
        settlementTwo.setName("Moscow");
        settlementThree.setName("Samara");
        settlementFour.setName("Leningrad");
        settlementFive.setName("Minsk");
        settlementSix.setName("Kinerma");
        settlementSeven.setName("Sabanche");
        settlementEight.setName("Kimja");
        settlementNine.setName("Viatskoe");
        settlementTen.setName("Desyatnikovo");

        settlementOne.setLatitude(55.7887400);
        settlementTwo.setLatitude(55.7522200);
        settlementThree.setLatitude(53.2000700);
        settlementFour.setLatitude(59.9386300);
        settlementFive.setLatitude(53.9000000);
        settlementSix.setLatitude(61.5266685);
        settlementSeven.setLatitude(54.9179655);
        settlementEight.setLatitude(65.3415);
        settlementNine.setLatitude(57.865556);
        settlementTen.setLatitude(51.2500);

        settlementOne.setLongitude(49.1221400);
        settlementTwo.setLongitude(37.6155600);
        settlementThree.setLongitude(50.1500000);
        settlementFour.setLongitude(30.3141300);
        settlementFive.setLongitude(27.5666700);
        settlementSix.setLongitude(32.8251877);
        settlementSeven.setLongitude(52.0887275);
        settlementEight.setLongitude(44.3616);
        settlementNine.setLongitude(40.263889);
        settlementTen.setLongitude(42.324889);

        settlementOne.setId(1);
        settlementTwo.setId(2);
        settlementThree.setId(3);
        settlementFour.setId(4);
        settlementFive.setId(5);
        settlementSix.setId(6);
        settlementSeven.setId(7);
        settlementEight.setId(8);
        settlementNine.setId(9);
        settlementTen.setId(10);

        waypointOne.setType(WAREHOUSE);
        waypointTwo.setType(WAREHOUSE);
        waypointThree.setType(WAREHOUSE);
        waypointFour.setType(DEPOT);
        waypointFive.setType(WAREHOUSE);
        waypointSix.setType(DEPOT);
        waypointSeven.setType(WAREHOUSE);
        waypointEight.setType(DEPOT);
        waypointNine.setType(WAREHOUSE);
        waypointTen.setType(EMPTY);

        waypointOne.setSettlement(settlementOne);
        waypointTwo.setSettlement(settlementTwo);
        waypointThree.setSettlement(settlementThree);
        waypointFour.setSettlement(settlementFour);
        waypointFive.setSettlement(settlementFive);
        waypointSix.setSettlement(settlementSix);
        waypointSeven.setSettlement(settlementSeven);
        waypointEight.setSettlement(settlementEight);
        waypointNine.setSettlement(settlementNine);
        waypointTen.setSettlement(settlementTen);

        waypointOne.setName("A boss");
        waypointTwo.setName("Rock");
        waypointThree.setName("Sick");
        waypointFour.setName("Cocks");
        waypointFive.setName("Papers");
        waypointSix.setName("Hugo");
        waypointSeven.setName("Lois");
        waypointEight.setName("A brand");
        waypointNine.setName("War");
        waypointTen.setName("Hero");

        waypointOne.setLatitude(55.793218);
        waypointTwo.setLatitude(55.6728172);
        waypointThree.setLatitude(53.8769);
        waypointFour.setLatitude(58.32189);
        waypointFive.setLatitude(53.7897899);
        waypointSix.setLatitude(61.4232132);
        waypointSeven.setLatitude(54.8732168);
        waypointEight.setLatitude(65.232141);
        waypointNine.setLatitude(57.7832718);
        waypointTen.setLatitude(51.4321);

        waypointOne.setLongitude(49.0321321);
        waypointTwo.setLongitude(37.5123128);
        waypointThree.setLongitude(50.892321);
        waypointFour.setLongitude(30.231232);
        waypointFive.setLongitude(27.6666666);
        waypointSix.setLongitude(32.7872312);
        waypointSeven.setLongitude(52.1432432);
        waypointEight.setLongitude(44.232414);
        waypointNine.setLongitude(40.123124);
        waypointTen.setLongitude(42.512312);

        waypointOne.setId(11);
        waypointTwo.setId(12);
        waypointThree.setId(13);
        waypointFour.setId(14);
        waypointFive.setId(15);
        waypointSix.setId(16);
        waypointSeven.setId(17);
        waypointEight.setId(18);
        waypointNine.setId(19);
        waypointTen.setId(20);

        routeOne.add(settlementOne);
        routeOne.add(waypointOne);
        routeOne.add(settlementNine);
        routeOne.add(waypointNine);

        routeTwo.add(settlementEight);
        routeTwo.add(settlementTwo);
        routeTwo.add(waypointTwo);

        routeThree.add(settlementFive);
        routeThree.add(waypointFive);
        routeThree.add(settlementTwo);
        routeThree.add(settlementSix);
        routeThree.add(waypointSix);
        routeThree.add(settlementNine);

        routeFour.add(settlementNine);
        routeFour.add(waypointNine);
        routeFour.add(settlementThree);
        routeFour.add(waypointThree);
        routeFour.add(settlementFive);

        routeFive.add(settlementEight);
        routeFive.add(waypointEight);
        routeFive.add(settlementFive);
        routeFive.add(settlementEight);
        routeFive.add(settlementFive);
        routeFive.add(settlementThree);
        routeFive.add(settlementSeven);
        routeFive.add(waypointSeven);

        driverOne.setName("Jake");
        driverTwo.setName("Tom");
        driverThree.setName("John");
        driverFour.setName("Clara");
        driverFive.setName("Miss");

        driverOne.setGender(MALE);
        driverTwo.setGender(MALE);
        driverThree.setGender(MALE);
        driverFour.setGender(FEMALE);
        driverFive.setGender(FEMALE);

        driverOne.setLicenseExpirationDate(dateOne);
        driverTwo.setLicenseExpirationDate(dateTwo);
        driverThree.setLicenseExpirationDate(dateThree);
        driverFour.setLicenseExpirationDate(dateFour);
        driverFive.setLicenseExpirationDate(dateFive);
    }

    public List<Location> allLocation(){
        List<Location> locations = new ArrayList<>();
        locations.add(settlementOne);
        locations.add(settlementTwo);
        locations.add(settlementThree);
        locations.add(settlementFour);
        locations.add(settlementFive);
        locations.add(settlementSix);
        locations.add(settlementSeven);
        locations.add(settlementEight);
        locations.add(settlementNine);
        locations.add(settlementTen);
        locations.add(waypointOne);
        locations.add(waypointTwo);
        locations.add(waypointThree);
        locations.add(waypointFour);
        locations.add(waypointFive);
        locations.add(waypointSix);
        locations.add(waypointSeven);
        locations.add(waypointEight);
        locations.add(waypointNine);
        locations.add(waypointTen);
        return locations;
    }

    // Отсюда тесты делались до создания огромной модели данных компании по грузоперевозке(Внизу комментарий,показывающий где они закончились)

    @Test
    public void testGetAllLocations() {
        CompanyModel companyModel = new CompanyModel();
        Location locationOne = new Location();
        Location locationTwo = new Location();
        Location locationThree = new Location();
        Location locationFour = new Location();
        Location locationFive = new Location();
        locationOne.setId(1);
        locationTwo.setId(0);
        locationThree.setId(1);
        locationFour.setId(2);
        locationFive.setId(0);
        Assert.assertTrue(companyModel.allLocations.add(locationOne));
        Assert.assertTrue(companyModel.allLocations.add(locationTwo));
        Assert.assertFalse(companyModel.allLocations.add(locationThree));
        Assert.assertTrue(companyModel.allLocations.add(locationFour));
        Assert.assertFalse(companyModel.allLocations.add(locationFive));
    }

    @Test
    public void testGetAllRoutes() {
        CompanyModel companyModel = new CompanyModel();
        Location locationOne = new Location();
        locationOne.setId(1);
        Location locationTwo = new Location();
        locationTwo.setId(0);
        Location locationThree = new Location();
        locationThree.setId(1);
        Location locationFour = new Location();
        locationFour.setId(2);
        Location locationFive = new Location();
        locationFive.setId(0);
        Route routeOne = new Route();
        routeOne.add(locationOne);
        routeOne.add(locationFive);
        Route routeTwo = new Route();
        routeTwo.add(locationThree);
        routeTwo.add(locationTwo);
        Route routeThree = new Route();
        routeThree.add(locationFive);
        routeThree.add(locationFour);
        Assert.assertTrue(companyModel.allRoutes.add(routeOne));
        Assert.assertFalse(companyModel.allRoutes.add(routeTwo));
        Assert.assertTrue(companyModel.allRoutes.add(routeThree));
    }

    @Test
    public void testGetAllDrivers() {
        CompanyModel companyModel = new CompanyModel();
        Driver driverOne = new Driver();
        driverOne.setId(1);
        Driver driverTwo = new Driver();
        driverTwo.setId(0);
        Driver driverThree = new Driver();
        driverThree.setId(1);
        Driver driverFour = new Driver();
        driverFour.setId(0);
        Assert.assertTrue(companyModel.allDrivers.add(driverOne));
        Assert.assertTrue(companyModel.allDrivers.add(driverTwo));
        Assert.assertFalse(companyModel.allDrivers.add(driverThree));
        Assert.assertFalse(companyModel.allDrivers.add(driverFour));
    }

    @Test
    public static void testAddSettlement() {
        Collection<Settlement> allSettlement = new LinkedHashSet<>();
        CompanyModel companyModel = new CompanyModel();
        allSettlement.add(companyModel.addSettlement("Kazan", 54.3, 48.9, CITY, 1534392));
        Assert.assertEquals(companyModel.getAllLocations().size(), 1);
        allSettlement.add(companyModel.addSettlement("Samara", 48.9, 53.2, CITY, 1024392));
        Assert.assertEquals(companyModel.getAllLocations().size(), 2);
        allSettlement.add(companyModel.addSettlement("Moscow", 57.2, 54.2, CITY, 9224392));
        Assert.assertEquals(companyModel.getAllLocations().size(), 3);
        int id = 0;
        for (Settlement settlement : allSettlement) {
            Assert.assertEquals(settlement.getId(), ++id);
        }
        Assert.assertEquals(allSettlement, companyModel.getAllLocations());
        System.out.println(companyModel.getAllLocations().toString());
    }

    @Test
    public static void testAddWaypoint() {
        Collection<Waypoint> allWaypoint = new LinkedHashSet<>();
        CompanyModel companyModel = new CompanyModel();
        allWaypoint.add(companyModel.addWaypoint("UNKNOWN", 0, 0, EMPTY, null));
        Assert.assertEquals(companyModel.getAllLocations().size(), 1);
        Settlement settlement = new Settlement();
        settlement.setSettlementType(CITY);
        settlement.setName("New-York");
        settlement.setLongitude(43.2);
        settlement.setLatitude(53.2);
        allWaypoint.add(companyModel.addWaypoint("Boss", 43.24, 53.25, DEPOT, settlement));
        Assert.assertEquals(companyModel.getAllLocations().size(), 2);
        allWaypoint.add(companyModel.addWaypoint("Winston", 43.431, 53.54, DEPOT, settlement));
        Assert.assertEquals(companyModel.getAllLocations().size(), 3);
        int id = 0;
        for (Location waypoint : allWaypoint) {
            Assert.assertEquals(waypoint.getId(), ++id);
        }
        Assert.assertEquals(allWaypoint, companyModel.getAllLocations());
        System.out.println(companyModel.getAllLocations().toString());
    }

    @Test
    public static void testAddDriver() {
        Collection<Driver> allDrivers = new LinkedHashSet<>();
        CompanyModel companyModel = new CompanyModel();
        allDrivers.add(companyModel.addDriver("Ildar", MALE, new Date(468376429863482L)));
        Assert.assertEquals(companyModel.getAllDrivers().size(), 1);
        allDrivers.add(companyModel.addDriver("Tom Hawk", MALE, new Date(468376429863482L)));
        Assert.assertEquals(companyModel.getAllDrivers().size(), 2);
        allDrivers.add(companyModel.addDriver("Kate", FEMALE, new Date(468376421263482L)));
        Assert.assertEquals(companyModel.getAllDrivers().size(), 3);
        int id = 0;
        for (Driver driver : allDrivers) {
            Assert.assertEquals(driver.getId(), ++id);
        }
        Assert.assertEquals(allDrivers, companyModel.getAllDrivers());
        System.out.println(companyModel.getAllDrivers().toString());
    }

    @Test
    public static void testAddRoute() {
        CompanyModel companyModel = new CompanyModel();
        Location locationOne = new Location();
        locationOne.setId(0);
        Location locationTwo = new Location();
        locationTwo.setId(1);
        Location locationThree = new Location();
        locationThree.setId(2);
        Location locationFour = new Location();
        locationFour.setId(3);
        List<Location> locations = new ArrayList<>();
        locations.add(locationOne);
        locations.add(locationTwo);
        Route routeOne = companyModel.addRoute(locations);
        locations.remove(0);
        locations.remove(0);
        locations.add(locationThree);
        locations.add(locationFour);
        Route routeTwo = companyModel.addRoute(locations);
        Assert.assertEquals(companyModel.getAllRoutes().size(), 2);
        Assert.assertTrue(companyModel.getAllRoutes().contains(routeOne));
        Assert.assertTrue(companyModel.getAllRoutes().contains(routeTwo));
        System.out.println(locationOne);
    }

    @Test
    public static void testAssignRoute() {
        CompanyModel companyModel = new CompanyModel();
        Waypoint waypoint = new Waypoint();
        waypoint.setId(41241);
        Settlement settlement = new Settlement();
        settlement.setId(314523);
        Route route = new Route();
        route.add(waypoint);
        route.add(settlement);
        Driver driver = new Driver();
        driver.setId(54364);
        companyModel.assignRoute(driver, route);
        Assert.assertEquals(companyModel.getDriverRouteMap().get(driver), route);
    }

    @Test
    public void testSort() {
        List<Settlement> settlements = new ArrayList<>();
        settlements.add(settlementTen);
        settlements.add(settlementTwo);
        settlements.add(settlementSix);
        settlements.add(settlementEight);
        settlements.add(settlementNine);
        settlements.add(settlementOne);
        settlements.add(settlementThree);
        settlements.add(settlementFive);
        settlements.add(settlementFour);
        settlements.add(settlementSeven);
        CompanyModel.sort(settlements, Comparator.comparingInt(Settlement::getSettlement));
        for (Settlement settlement : settlements) {
            System.out.println(settlement.getSettlement());
        }
        System.out.println();
        CompanyModel.sort(settlements, new EquatorComparator());
        for (Settlement settlement : settlements) {
            System.out.println(settlement.getLatitude());
        }
    }

    @Test
    public void testSortByName() {
        List<Location> locations = new ArrayList<>();
        locations.add(settlementFour);
        locations.add(settlementTen);
        locations.add(settlementFive);
        locations.add(settlementThree);
        locations.add(settlementTwo);
        locations.add(settlementOne);
        locations.add(waypointFive);
        locations.add(waypointThree);
        locations.add(waypointTen);
        locations.add(waypointOne);
        CompanyModel.sortByName(locations);
        for (Location location : locations) {
            System.out.println(location.getName());
        }
        System.out.println();
        List<Settlement> settlements = new ArrayList<>();
        settlements.add(settlementFour);
        settlements.add(settlementTen);
        settlements.add(settlementFive);
        settlements.add(settlementThree);
        settlements.add(settlementTwo);
        settlements.add(settlementOne);
        CompanyModel.sortByName(settlements);
        for (Settlement settlement : settlements) {
            System.out.println(settlement.getName());
        }
    }

    @Test
    public void testSortedMap() {
        List<Driver> drivers = new ArrayList<>();
        CompanyModel someCompany = new CompanyModel();
        someCompany.assignRoute(driverOne, routeFive);
        someCompany.assignRoute(driverTwo, routeOne);
        someCompany.assignRoute(driverThree, routeTwo);
        someCompany.assignRoute(driverFive, routeThree);
        someCompany.assignRoute(driverFour, routeFour);
        drivers.add(driverOne);
        drivers.add(driverThree);
        drivers.add(driverFive);
        drivers.add(driverTwo);
        drivers.add(driverFour);
        Map<Driver, Route> sortedDrivers = someCompany.sortedMap(drivers);
        for (Driver driver : sortedDrivers.keySet()) {
            System.out.println(driver.getName());
        }
    }

    @Test
    public void testSortedSettlement() {
        List<Location> locations = new ArrayList<>();
        CompanyModel someCompany = new CompanyModel();
        locations.add(settlementFour);
        locations.add(settlementNine);
        locations.add(settlementEight);
        locations.add(settlementSix);
        locations.add(waypointThree);
        locations.add(waypointTen);
        locations.add(waypointNine);
        locations.add(waypointTwo);
        Map<Settlement, SettlementType> sortedSettlement = someCompany.sortedSettlement(locations);
        for (Settlement settlement : sortedSettlement.keySet()) {
            System.out.println(settlement.getSettlement());
        }
    }

    @Test
    public void testSortedWaypoints() {
        List<Location> locations = new ArrayList<>();
        CompanyModel someCompany = new CompanyModel();
        locations.add(waypointOne);
        locations.add(waypointTwo);
        locations.add(waypointThree);
        locations.add(waypointFour);
        locations.add(waypointFive);
        locations.add(waypointSix);
        locations.add(waypointSeven);
        locations.add(waypointEight);
        locations.add(waypointNine);
        locations.add(waypointTen);
        Map<WaypointType, List<Waypoint>> sortedWaypoints = someCompany.sortedWaypoints(locations);
        for (List<Waypoint> waypoints : sortedWaypoints.values()) {
            System.out.println(waypoints);
        }
    }

    // Здесь закончились тесты без использования огромной модели данных

}