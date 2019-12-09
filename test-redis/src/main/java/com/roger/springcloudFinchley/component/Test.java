package com.roger.springcloudFinchley.component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by admin on 2019/12/9.
 */
public class Test {
    //验证代码
    public static void main(String[] args) {
        User user = new User();
        user.setId(100);
        user.setName("roger");
        user.setAge(20);
        validate(user);
    }

    private static void validate(Object o){
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> set = validator.validate(o);
        for (ConstraintViolation<Object> constraintViolation : set) {
            System.out.println(constraintViolation.getPropertyPath()+":"+constraintViolation.getMessage());
        }
    }
}

class User {

    @NotNull(message = "姓名不能为空")
    private String name;

    @Min(value = 25 ,message = "年龄不能小于0")
    @NotNull(message = "age不能为空")
    private Integer age;
    @NotNull(message = "id不能为空")
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
