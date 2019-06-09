package mn.tuugii.eLibrary.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private Long bookId;

    @Column(name="title")
    @NotEmpty(message = "This title field must be value")
    private String title;

    @Column(name="fee")
    @NotNull(message = "This fee field must be value")
    private float fee;

    @Column(name="date_published")
    @DateTimeFormat(pattern = "MM/DD/YYYY")
    private LocalDate datePublished;

}
