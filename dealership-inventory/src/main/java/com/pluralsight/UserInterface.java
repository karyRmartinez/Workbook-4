package com.pluralsight;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Dealership dealership;

    // <---Constructor--->
    public UserInterface() {
    }

    private void init() {
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership();
    }

    public void display() {
        init();
        displayMenu();
    }

    // <---displayMenu() helper method--->
    public void displayMenu() {
        boolean done = false;

        // 1) display the menu
        while (!done) {
            System.out.println("""
                    Make A Choice:
                        1. Vehicle By Price
                        2. Vehicle By Make Model
                        3. Vehicle By Year
                        4. Vehicle By Color
                        5. Vehicle By Mileage
                        6. Vehicle By Type
                        7. All Vehicles
                        8. Add Vehicle
                        9. Remove Vehicle
                        0. Exit
                    """);

            // 2) read the user's command
            int input = scanner.nextInt();
            scanner.nextLine();

            // 3) switch statement that calls the correct process() method
            // that matches the user request.
            switch (input) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                case 0:
                    done = true;
                    break;
                default:
                    System.out.println("Please enter a correct number between 0 - 10: ");
            }
        }
    }

    // <---displayVehicles() helper method--->
    private void displayVehicles(List<Vehicle> vehicles) {
        System.out.println("Displaying all the vehicles");

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getVin() + "|" + vehicle.getYear() + "|" +
                    vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" +
                    vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice()
            );
        }
        System.out.println();
    }

    // <---Process Methods--->
    private void processGetByPriceRequest() {
        // enter Price
        System.out.println("Please enter the min Price");
        Double minPrice = scanner.nextDouble();

        System.out.println("Please enter the max Price");
        Double maxPrice = scanner.nextDouble();

        // get Vehicle from Dealership
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest() {
        // enter Make
        System.out.println("Please enter the Make");
        String make = scanner.nextLine();

        // enter Model
        System.out.println("Please enter the Model");
        String model = scanner.nextLine();

        // get Vehicle from Dealership
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);

        // loop through return vehicles
        // print out each vehicle
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }

    }

    private void processGetByYearRequest() {
        System.out.println("enter min year: ");
        int minYear = scanner.nextInt();
        System.out.println("enter max year: ");
        int maxYear = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehicles);
    }

    private void processGetByColorRequest() {
        System.out.println("Enter color");
        String color = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);

    }

    private void processGetByMileageRequest() {
        System.out.println("enter the min Mileage:");
        int minMileage = scanner.nextInt();

        System.out.println("enter the max Mileage:");
        int maxMileage = scanner.nextInt();

    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("Enter the Vehicle Type:");
        String vehicleType = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);

    }

    private void processGetAllVehiclesRequest() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    private void processAddVehicleRequest() {
        System.out.println("Enter VIN:");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Year:");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Make:");
        String make = scanner.nextLine();

        System.out.println("Enter Model:");
        String model = scanner.nextLine();

        System.out.println("Enter Vehicle Type:");
        String vehicleType = scanner.nextLine();

        System.out.println("Enter Color:");
        String color = scanner.nextLine();

        System.out.println("Enter Odometer Reading:");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Price:");
        double price = scanner.nextDouble();
        scanner.nextLine();

        // Vehicle object
        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        //  new vehicle to the Dealership
        dealership.addVehicle(newVehicle);

    }

    private void processRemoveVehicleRequest() {
        System.out.println("Enter VIN of the vehicle to remove:");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle removedVehicle = dealership.removeVehicle(vin);

        if (removedVehicle != null) {
            System.out.println("Vehicle with VIN " + vin + " has been removed.");
        } else {
            System.out.println("No vehicle found with VIN " + vin + ".");
        }

    }

    //<---READ FROM CSV--->
//    private ArrayList<Vehicle> readFromCsv() {
//        ArrayList<Vehicle> vehicles = new ArrayList<>();
//        try {
//            FileReader fileReader = new FileReader("inventory.csv");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String input;
//
//            bufferedReader.readLine();
//        } catch () {
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return vehicles;
//    }

}
