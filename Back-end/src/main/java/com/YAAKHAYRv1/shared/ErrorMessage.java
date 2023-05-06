
package com.YAAKHAYRv1.shared;

import jdk.jfr.DataAmount;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ErrorMessage {
    private String message;
    private Date timestamp;
    private Integer code;
}
