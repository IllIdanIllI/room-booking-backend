package test.task.room_booking.service;

import java.io.Serializable;

public interface CrudService<T extends Serializable, K extends Serializable, N extends Integer> {
    T findModel(N id);

    N addModel(K dto);
}
