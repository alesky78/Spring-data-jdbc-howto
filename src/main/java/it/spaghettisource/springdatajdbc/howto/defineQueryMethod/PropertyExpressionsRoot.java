package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class PropertyExpressionsRoot {

    private @Id Long id;
    private String name;
    private PropertyExpressionsNested nested;

    public PropertyExpressionsRoot(String name, PropertyExpressionsNested nested) {
        this.name = name;
        this.nested = nested;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PropertyExpressionsNested getNested() {
        return nested;
    }

    public void setNested(PropertyExpressionsNested nested) {
        this.nested = nested;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyExpressionsRoot that = (PropertyExpressionsRoot) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PropertyExpressionsRoot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nested=" + nested +
                '}';
    }
}
