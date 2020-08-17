package test.task.room_booking.service;

import test.task.room_booking.service.dto.pagination.PaginationDto;

import java.io.Serializable;

public interface CrudService<T extends Serializable, K extends Serializable, N extends Integer> {
    T findModel(N id);

    PaginationDto<T> findAllModels(int currentPage, int recordAmount);

    N addModel(K dto);
}
