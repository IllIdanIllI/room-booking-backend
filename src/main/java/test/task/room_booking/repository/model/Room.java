package test.task.room_booking.repository.model;

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
