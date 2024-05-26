package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.Objects;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_EMPTY;
import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_NULL;

public class PropertyExpressionsRoot {

    private @Id Long id;
    private String name;

    @Embedded(onEmpty = USE_EMPTY) // you could use USE_NULL
    private PropertyExpressionsEmbedded embedded;

    private PropertyExpressionsNested nested;

    public PropertyExpressionsRoot() {
    }

    public PropertyExpressionsRoot(String name, PropertyExpressionsEmbedded embedded, PropertyExpressionsNested nested) {
        this.name = name;
        this.embedded = embedded;
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

    public PropertyExpressionsEmbedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(PropertyExpressionsEmbedded embedded) {
        this.embedded = embedded;
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
                ", embedded=" + embedded +
                ", nested=" + nested +
                '}';
    }
}
