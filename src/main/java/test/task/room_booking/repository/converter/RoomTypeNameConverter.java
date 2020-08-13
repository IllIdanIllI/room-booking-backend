package test.task.room_booking.repository.converter;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.EnumType;
import test.task.room_booking.repository.model.type.RoomTypeName;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class RoomTypeNameConverter extends EnumType {
    public class EmployeeTypeConverter extends EnumType {
        @Override
        public void nullSafeSet(PreparedStatement preparedStatement, Object value, int index,
                                SharedSessionContractImplementor session)
                throws SQLException {
            preparedStatement.setObject(index, value != null ? ((RoomTypeName) value).get() : null, Types.OTHER);
        }
    }
}
