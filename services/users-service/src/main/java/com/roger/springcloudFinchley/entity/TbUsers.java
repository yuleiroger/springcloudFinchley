package com.roger.springcloudFinchley.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class TbUsers implements Serializable {
    @NotNull(message = "工号不能为空")
    private String uuid;
    private String userName;
    private String password;
    private String status;

}
