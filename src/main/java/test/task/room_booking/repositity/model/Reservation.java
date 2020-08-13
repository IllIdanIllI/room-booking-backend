package test.task.room_booking.repositity.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservationIdSequencer")
    @SequenceGenerator(name = "reservationIdSequencer", sequenceName = "reservation_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "date_in")
    private LocalDateTime dateIn;

    @Column(name = "date_out")
    private LocalDateTime dateOut;

    @Column
    private boolean reserved;

    @OneToOne
    @JoinColumn(name = "reservation_reason_id")
    private ReservationReason reservationReason;

    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
