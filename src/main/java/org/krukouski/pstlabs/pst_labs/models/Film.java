package org.krukouski.pstlabs.pst_labs.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "films")
public class Film {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    @OneToMany
    private List<Genre> genres;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", genres=" + genres +
                ", director=" + director +
                '}';
    }
}
