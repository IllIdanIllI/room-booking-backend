package test.task.room_booking.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import test.task.room_booking.repository.model.type.RoomTypeName;

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
    @Enumerated(EnumType.STRING)
    @Type(type = "test.task.room_booking.repository.converter.RoomTypeNameConverter")
    private RoomTypeName name;
}
