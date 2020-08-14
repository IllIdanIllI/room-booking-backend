package test.task.room_booking.service;

import org.springframework.data.domain.Page;

import java.io.Serializable;

public interface CrudService<T extends Serializable, K extends Serializable, N extends Integer> {
    T findModel(N id);

    Page<T> findAllModels(int currentPage, int recordAmount);

    N addModel(K dto);
}
