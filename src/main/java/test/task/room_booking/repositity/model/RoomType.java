package test.task.room_booking.repositity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "room_type")
public class RoomType implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_typeIdSequencer")
    @SequenceGenerator(name = "room_typeIdSequencer", sequenceName = "room_type_id_seq", allocationSize = 1)
    private Integer id;

    @Column
    private String name;
}
