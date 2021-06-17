package shiyun.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "common_sense_basis")
public class Common_sense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_common_sense")
    private int id_common_sense;

    @Column(name = "id_theme")
    private int id_theme;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "simple_description")
    private String simple_description;

}
