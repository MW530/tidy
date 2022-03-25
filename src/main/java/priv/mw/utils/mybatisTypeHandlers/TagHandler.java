package priv.mw.utils.mybatisTypeHandlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import priv.mw.domain.Tag;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TagHandler extends BaseTypeHandler<Tag[]> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Tag[] tags, JdbcType jdbcType) throws SQLException {
        StringBuilder stringBuilder = new StringBuilder();
        for (Tag tag : tags) {
            stringBuilder.append(tag.getId());
            stringBuilder.append(";");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        preparedStatement.setString(i, stringBuilder.toString());
    }

    @Override
    public Tag[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getObject(s, Tag[].class);
    }

    @Override
    public Tag[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getObject(i, Tag[].class);
    }

    @Override
    public Tag[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getObject(i, Tag[].class);
    }
}
