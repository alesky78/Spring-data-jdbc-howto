package it.spaghettisource.springdatajdbc.howto.createRepository;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.util.Objects;

public class Custom {

    private @Id Long id;
    private String data;
    public Custom() {
    }

    public Custom(String data) {
        this.data = data;
    }

    public Custom(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    public Custom(Long id, String data, Long version) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Custom custom = (Custom) o;

        if (Objects.equals(id, custom.id)) return false;
        return Objects.equals(data, custom.data);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Custom{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
