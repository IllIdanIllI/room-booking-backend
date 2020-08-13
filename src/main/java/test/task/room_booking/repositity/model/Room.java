package test.task.room_booking.repositity.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@Entity
@Table(name = "room")
public class Room implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomIdSequencer")
    @SequenceGenerator(name = "roomIdSequencer", sequenceName = "room_id_seq", allocationSize = 1)
    private Integer id;

    @Column
    private int number;

    @OneToOne
    @JoinColumn(name = "room_type_id", referencedColumnName = "id")
    private RoomType type;
}
