package supermarket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import static supermarket.Message.*;
import static supermarket.Stage.*;
import static supermarket.Price.*;

public class Application {
    public static void main(String[] args) throws IOException {
        double sum = 0;
        Stage stage = WELCOME;
        String input = null;
        Integer quentity = 0;


        System.out.println(welcome);
        do {BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            if (stage.equals(WELCOME)){
                System.out.println(departs);
                input = bufferedReader.readLine();
                switch(input){
                    case "f":
                        stage = SALE;
                        break;
                    case "n":
                        stage = SALE;
                        break;
                    case "r":
                        stage = SALE;
                        break;
                    case "q":
                        System.out.println(bay);
                        break;
                    default:
                        System.out.println(incorrect_welcome);
                        stage = WELCOME;
                        break;
                }
            }
            else if (stage.equals(SALE)){
                switch (input) {
                    case "f":
                        System.out.println(food_assortment);
                        input = bufferedReader.readLine();
                        stage = FOOD;
                        break;
                    case "n":
                        System.out.println(beverage_assortment);
                        input = bufferedReader.readLine();
                        stage = BEVERAGE;
                        break;
                    case "r":
                        System.out.println(electrics_assortment);
                        input = bufferedReader.readLine();
                        stage = ELECTRICS;
                        break;
                    default:
                        System.out.println(incorrect_welcome);
                        stage = WELCOME;
                        break;
                }

            }
            else if (stage.equals(FOOD)) {
                switch (input) {
                    case "b":
                        System.out.println(price_bread + bread_message);
                        try {
                            input = bufferedReader.readLine();
                            quentity = Integer.parseInt(input);
                            sum = sum + (quentity * price_bread);
                            stage = OTHER_PRODUCT;

                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            stage = FOOD;
                        }
                        break;

                    case "m":
                        System.out.println(price_majonez + majonez_message);
                        try {
                            input = bufferedReader.readLine();
                            quentity = Integer.parseInt(input);
                            sum = sum + (quentity * price_majonez);
                            stage = OTHER_PRODUCT;
                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            stage = SALE;
                        }
                        break;

                    case "w":
                        System.out.println(price_kreker + kreker_message);
                        try {
                            input = bufferedReader.readLine();
                            quentity = Integer.parseInt(input);
                            sum = sum + (quentity * price_kreker);
                            stage = OTHER_PRODUCT;
                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            stage = SALE;
                        }
                        break;

                    case "u":
                        System.out.println(price_sausage + sausage_message);
                        try {
                            input = bufferedReader.readLine();
                            quentity = Integer.parseInt(input);
                            sum = sum + (quentity * price_sausage);
                            stage = OTHER_PRODUCT;
                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            stage = SALE;
                        }
                        break;
                    case "q":
                        break;
                    default:
                        System.out.println(incorrect_welcome);
                        stage = SALE;
                        break;
                }
            }
            else if (stage.equals(OTHER_PRODUCT)){
              System.out.println(other_product);
              input = bufferedReader.readLine();
                switch (input) {
                    case "s":
                        System.out.println(food_assortment);
                        input = bufferedReader.readLine();
                        stage = FOOD;
                        break;
                    case "d":
                        System.out.println(departs);
                        input = bufferedReader.readLine();
                        stage = SALE;
                        break;
                    default:
                        System.out.println(incorrect_welcome);
                        stage = OTHER_PRODUCT;
                        break;}

//
//
//
//
//                        stage = FOOD;
//                        break;
//                    case "m":
//                        System.out.println(beverage_assortment);
//                        stage = BEVERAGE;
//                        break;
//                    case "w":
//                        System.out.println(electrics_assortment);
//                        stage = ELECTRICS;
//                        break;
//                    case "u":
//                        System.out.println(electrics_assortment);
//                        stage = ELECTRICS;
//                        break;
//                    default:
//                        stage = WELCOME;
//                        break;
                }

        } while (!input.equals("q"));
        System.out.println(order + sum + good_day);
    }
}
