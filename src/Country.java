import javafx.util.Builder;

import java.nio.file.attribute.AclEntry;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 27.11.13
 * Time: 23:55
 * To change this template use File | Settings | File Templates.
 */
public class Country {

    private final String ShortCode;
    private final String Name;

        private Country(Builder builder){
        this.ShortCode=builder.ShortCode;
        this.Name=builder.Name;

    }

    public String getShortCode() {
        return ShortCode;
    }

    public String getName() {
        return Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (!Name.equals(country.Name)) return false;
        if (!ShortCode.equals(country.ShortCode)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Country{" +
                "ShortCode='" + ShortCode + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    public static class Builder{

        private String ShortCode;
        private String Name;

        private Builder(){};

        public Builder(Country country){
            this.Name=country.Name;
            this.ShortCode=country.ShortCode;
        }
        public Builder ShortCode(String ShortCode){
            this.ShortCode=ShortCode;
            return this;
        }
        public Builder Name(String Name){
            this.Name=Name;
            return this;
        }
    }
}

