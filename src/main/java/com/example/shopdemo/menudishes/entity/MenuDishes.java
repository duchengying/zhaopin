package com.example.shopdemo.menudishes.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dcy
 * @since 2020-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MenuDishes implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 菜品名称
     */
    private String name;

    /**
     * 价格
     */
    private Integer prcie;


}
