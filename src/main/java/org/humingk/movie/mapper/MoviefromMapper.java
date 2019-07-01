package org.humingk.movie.mapper;

import java.util.List;
import org.humingk.movie.entity.Moviefrom;

public interface MoviefromMapper {
    int deleteByPrimaryKey(String moviefromUrl);

    int insert(Moviefrom record);

    Moviefrom selectByPrimaryKey(String moviefromUrl);

    List<Moviefrom> selectAll();

    int updateByPrimaryKey(Moviefrom record);
}