package org.humingk.movie.api.common.util;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * VO转换工具类
 * <p>
 * 调用方式：    @Mapping(qualifiedByName=Named
 *
 * @author humingk
 */
@Component
public class VoConverterUtil {
    /**
     * Unix时间戳转换为yyyy-MM-dd
     *
     * @param unixTimestamp
     * @return
     */
    @Named("unixTimestampToDate")
    public String unixTimestampToDate(Long unixTimestamp) {
        return Instant.ofEpochSecond(unixTimestamp)
                .atZone(ZoneId.of("CTT"))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
