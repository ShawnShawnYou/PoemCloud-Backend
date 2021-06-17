package shiyun.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "poem_basis")
public class Poem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poem")
    private int id_poem;

    @Column(name = "id_theme")
    private int id_theme;

    @Column(name = "id_author")
    private int id_author;

    @Column(name = "title")
    private String title;

    @Column(name = "paragraphs")
    private String paragraphs;

    public List<String> getSentenceList() {
        return Arrays.asList(this.getParagraphs().split("\r\n"));
    }


}
