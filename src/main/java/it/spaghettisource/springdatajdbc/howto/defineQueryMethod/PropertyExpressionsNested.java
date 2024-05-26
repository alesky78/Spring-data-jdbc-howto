package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class PropertyExpressionsNested {

    private @Id Long id;
    private String address;

    public PropertyExpressionsNested(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyExpressionsNested that = (PropertyExpressionsNested) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PropertyExpressionsNested{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
