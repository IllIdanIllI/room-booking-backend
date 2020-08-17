package test.task.room_booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.task.room_booking.repository.RoomRepository;
import test.task.room_booking.repository.model.Room;
import test.task.room_booking.service.RoomService;
import test.task.room_booking.service.dto.request.RoomRequestDto;
import test.task.room_booking.service.dto.response.RoomResponseDto;
import test.task.room_booking.service.exception.NoSuchRecordException;
import test.task.room_booking.service.mapper.EntityMapper;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository repository;
    @Autowired
    private EntityMapper<RoomResponseDto, Room> responseMapper;
    @Autowired
    private EntityMapper<Room, RoomRequestDto> requestMapper;

    @Override
    public RoomResponseDto findModel(Integer id) {
        Optional<Room> room = repository.findById(id);
        return responseMapper.map(room.orElseThrow(() -> new NoSuchRecordException("No such room")));
    }

    @Override
    public Page<RoomResponseDto> findAllModels(int currentPage, int recordAmount) {
        Pageable pageable = PageRequest.of(currentPage, recordAmount);
        Page<Integer> allRoomsWithRelevantDate = repository.findAllRoomsWithRelevantDate(LocalDateTime.now(), pageable);
        return repository.findAllRoomsWithRelevantDate(LocalDateTime.now(), pageable)
                .map(roomId -> responseMapper
                        .map(repository.findById(roomId).orElse(new Room())));
    }

    @Override
    public Integer addModel(RoomRequestDto dto) {
        Room room = requestMapper.map(dto);
        repository.save(room);
        return Optional.ofNullable(room.getId()).orElseThrow();
    }
}
