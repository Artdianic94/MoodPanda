package utilities;

import com.github.javafaker.Faker;

public class GenerateFakeMessage {

    public static String getFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }
    public static String getSomeText(){
        Faker faker = new Faker();
        return faker.howIMetYourMother().catchPhrase();
    }

}
