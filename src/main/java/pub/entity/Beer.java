package pub.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Beer {
    private int id;
    private String name;
    private String country;
    private LocalDate producedTime;
    private int price;
    private boolean visible;

    public Beer(int id, String name, String country, LocalDate producedTime, int price, boolean visible) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.producedTime = producedTime;
        this.price = price;
        this.visible = visible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getProducedTime() {
        return producedTime;
    }

    public void setProducedTime(LocalDate producedTime) {
        this.producedTime = producedTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("id: ").append(id).append(";").append("\n");
        out.append("  name: ").append(name).append(";").append("\n");
        out.append("  country: ").append(country).append(";").append("\n");
        out.append("  produced: ").append(producedTime).append(";").append("\n");
        out.append("  price: ").append(price).append(";").append("\n");
        out.append("  visible ").append(visible).append(";").append("\n\n");
        return out.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return id == beer.id &&
                Objects.equals(name, beer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}