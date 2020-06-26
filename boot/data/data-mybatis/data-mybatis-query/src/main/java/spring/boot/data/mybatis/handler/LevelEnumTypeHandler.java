package spring.boot.data.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import spring.boot.data.mybatis.enums.LevelEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LevelEnumTypeHandler extends BaseTypeHandler<LevelEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, LevelEnum levelEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, levelEnum.getCode());
    }

    @Override
    public LevelEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return LevelEnum.valueOf(resultSet.getInt(s));
    }

    @Override
    public LevelEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return LevelEnum.valueOf(resultSet.getInt(i));
    }

    @Override
    public LevelEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return LevelEnum.valueOf(callableStatement.getInt(i));
    }
}
