package main.java.com;


import java.util.LinkedHashMap;

public class Student {
    private String firstName,lastName,country;
    private LinkedHashMap<String,String>countryOptions;
    private String favoriteProgrammingLanguage;
    private String[]operatingSystems;
    public Student(){
        //aici se pot citi datele din database
        countryOptions=new LinkedHashMap<>();
        countryOptions.put("ROU","Romania");
        countryOptions.put("FR","France");
        countryOptions.put("DE","Germany");
        countryOptions.put("ES","Spain");
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFavoriteProgrammingLanguage() {
        return favoriteProgrammingLanguage;
    }

    public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public void setFavoriteProgrammingLanguage(String favoriteProgrammingLanguage) {
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}
