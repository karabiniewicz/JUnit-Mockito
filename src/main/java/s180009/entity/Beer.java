package s180009.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Beer implements Serializable {

    private String name;

    private float percent;

    @Override
    public String toString() {
        return "Beer{" +
                "name='" + name + '\'' +
                ", percent=" + percent +
                '}';
    }
}
