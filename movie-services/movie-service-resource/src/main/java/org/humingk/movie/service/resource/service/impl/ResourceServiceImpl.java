package org.humingk.movie.service.resource.service.impl;

import com.github.pagehelper.PageHelper;
import org.humingk.movie.common.annotation.RedisCache;
import org.humingk.movie.common.enumeration.CodeAndMsg;
import org.humingk.movie.common.exception.MyException;
import org.humingk.movie.dal.entity.ResourceMovie;
import org.humingk.movie.dal.entity.ResourceMovieExample;
import org.humingk.movie.dal.mapper.auto.ResourceMovieMapper;
import org.humingk.movie.service.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/** @author humingk */
@Service
@RedisCache
public class ResourceServiceImpl implements ResourceService {
  @Autowired private ResourceMovieMapper resourceMovieMapper;
  @Autowired private ResourceMovieExample resourceMovieExample;

  /** 每种类型最多个数 */
  private static final int TYPE_MAX = 6;

  /** 每个网站最多个数 */
  private static final int WEBSITE_MAX = 5;

  /** 资源类型优先Map */
  private static HashMap<Short, Integer> typePriorityMap() {
    return new HashMap<Short, Integer>() {
      {
        put((short) 1, 0);
        put((short) 2, 0);
        put((short) 3, 0);
        put((short) 4, 0);
        put((short) 5, 0);
        put((short) 101, 0);
        put((short) 111, 0);
        put((short) 112, 0);
        put((short) 113, 0);
        put((short) 114, 0);
        put((short) 115, 0);
        put((short) 116, 0);
        put((short) 117, 0);
      }
    };
  }

  /** 资源网站优先Map */
  private static HashMap<Short, Integer> websitePriorityMap() {
    return new HashMap<Short, Integer>() {
      {
        put((short) 2, 0);
        put((short) 3, 0);
        put((short) 4, 0);
        put((short) 5, 0);
        put((short) 6, 0);
        put((short) 7, 0);
        put((short) 8, 0);
        put((short) 9, 0);
        put((short) 10, 0);
        put((short) 11, 0);
        put((short) 12, 0);
        put((short) 13, 0);
        put((short) 130, 0);
        put((short) 160, 0);
        put((short) 170, 0);
      }
    };
  }

  /** 资源网站优先Map2 */
  private static HashMap<Short, Integer> websitePriority2Map() {
    return new HashMap<Short, Integer>() {
      {
        put((short) 110, 0);
        put((short) 120, 0);
        put((short) 130, 0);
        put((short) 140, 0);
        put((short) 150, 0);
      }
    };
  }

  @Override
  public List<ResourceMovie> getResourceListByMovieDoubanId(Long id, int limit) {
    resourceMovieExample.start().andIdMovieDoubanEqualTo(id);
    resourceMovieExample.setOrderByClause("id_website_resource,id_type_resource");
    List<ResourceMovie> resourceMovieList =
        resourceMovieMapper.selectByExample(resourceMovieExample);
    if (resourceMovieList.isEmpty()) {
      throw new MyException(CodeAndMsg.NO_RESOURCE);
    } else {
      if (resourceMovieList.size() <= limit + 5) {
        return new ArrayList<>(
            resourceMovieList.subList(0, Math.min(limit, resourceMovieList.size() - 1)));
      }
      // 资源网站和资源种类优先列表
      List<ResourceMovie> resultList = new ArrayList<>();
      int total = 0;
      HashMap<Short, Integer> typeMap = typePriorityMap();
      HashMap<Short, Integer> websiteMap = websitePriorityMap();
      Iterator<ResourceMovie> iterator = resourceMovieList.iterator();
      while (iterator.hasNext()) {
        ResourceMovie resourceMovie = iterator.next();
        Short typeKey = resourceMovie.getIdTypeResource();
        Short websiteKey = resourceMovie.getIdWebsiteResource();
        // 属于优先队列 且限制网站和种类
        if (websiteMap.containsKey(websiteKey)
            && websiteMap.get(websiteKey) <= WEBSITE_MAX
            && typeMap.containsKey(typeKey)
            && typeMap.get(typeKey) <= TYPE_MAX) {
          if (total++ > limit) {
            break;
          }
          typeMap.merge(typeKey, 1, Integer::sum);
          websiteMap.merge(websiteKey, 1, Integer::sum);
          resultList.add(resourceMovie);
          iterator.remove();
        }
      }
      // 网站优先 且限制网站
      HashMap<Short, Integer> website2Map = websitePriorityMap();
      iterator = resourceMovieList.iterator();
      while (iterator.hasNext()) {
        ResourceMovie resourceMovie = iterator.next();
        Short websiteKey = resourceMovie.getIdWebsiteResource();
        if (website2Map.containsKey(websiteKey) && website2Map.get(websiteKey) <= WEBSITE_MAX) {
          if (total++ > limit) {
            break;
          }
          website2Map.merge(websiteKey, 1, Integer::sum);
          resultList.add(resourceMovie);
          iterator.remove();
        }
      }
      // 补上剩余资源
      resultList.addAll(resourceMovieList.subList(0, Math.max(limit - resultList.size(), 0)));
      return resultList;
    }
  }

  @Override
  public List<ResourceMovie> getResourceListByKeyword(String keyword, int offset, int limit) {
    resourceMovieExample.start().andNameZhLike("%" + keyword + "%");
    resourceMovieExample.or().andNameOriginLike("%" + keyword + "%");
    resourceMovieExample.setOrderByClause("id_website_resource,id_type_resource");
    PageHelper.offsetPage(offset, limit);
    List<ResourceMovie> resultList = resourceMovieMapper.selectByExample(resourceMovieExample);
    if (resultList.isEmpty()) {
      throw new MyException(CodeAndMsg.NO_RESOURCE);
    } else {
      return resultList;
    }
  }
}
