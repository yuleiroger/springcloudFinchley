package com.roger.springcloudFinchley.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by admin on 2019/9/12.
 */
@Document(collection = "tb_users")
@Data
public class MongoUsers implements Serializable{
    private static final long serialVersionUID = 2782017425617935173L;
    @NotNull(message = "")
    @Field("user_no")
    private String userNo;

    @NotNull
    @Field("user_name")
    private String userName;
}
