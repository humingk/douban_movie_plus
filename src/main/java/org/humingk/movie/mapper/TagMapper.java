package org.humingk.movie.mapper;

import org.humingk.movie.entity.Tag;

import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(Tag record);

    Tag selectByPrimaryKey(Integer tagId);

    List<Tag> selectAll();

    int updateByPrimaryKey(Tag record);

    //    ------------

    int updateTagsByMovieAll(Tag tag);

    Tag selectByTagName(String tagName);

    List<Tag> selectTagsOfMovieById(Integer movieId);

}