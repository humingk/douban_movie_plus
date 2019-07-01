package org.humingk.movie.mapper;

import java.util.List;
import org.humingk.movie.entity.Moviefrom;

public interface MoviefromMapper {
    int deleteByPrimaryKey(Integer moviefromId);

    int insert(Moviefrom record);

    Moviefrom selectByPrimaryKey(Integer moviefromId);

    List<Moviefrom> selectAll();

    int updateByPrimaryKey(Moviefrom record);
}