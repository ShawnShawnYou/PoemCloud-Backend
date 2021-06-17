package shiyun.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "author_basis")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author")
    private int id_author;

    @Column(name = "name")
    private String name;

    @Column(name = "period")
    private String period;

    @Column(name = "description")
    private String description;
}
