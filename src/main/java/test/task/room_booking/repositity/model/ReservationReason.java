package test.task.room_booking.repositity.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@Entity
@Table(name = "reservation_reason_reason")
public class ReservationReason implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_reasonIdSequencer")
    @SequenceGenerator(name = "reservation_reasonIdSequencer", sequenceName = "reservation_reason_id_seq", allocationSize = 1)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;
}
