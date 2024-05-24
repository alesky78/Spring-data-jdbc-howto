package it.spaghettisource.springdatajdbc.howto.createRepository;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class PageableAndSortable {

    private @Id Long id;
    private String discriminator;
    @Column("NUMBER")
    private Integer order;

    public PageableAndSortable() {
    }

    public PageableAndSortable(String discriminator, Integer order) {
        this.discriminator = discriminator;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageableAndSortable that = (PageableAndSortable) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "PagingAndSorting{" +
                "id=" + id +
                ", discriminator='" + discriminator + '\'' +
                ", value='" + order + '\'' +
                '}';
    }

}
