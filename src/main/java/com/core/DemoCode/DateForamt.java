package com.core.DemoCode;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author jq
 * @date 2022/8/8 11:55
 * <p></p>
 **/
@Data
@Builder
public class DateForamt {

//    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss")
    private Date now;
}
