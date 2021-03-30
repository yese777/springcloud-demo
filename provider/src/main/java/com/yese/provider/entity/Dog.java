package com.yese.provider.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * 狗(Dog)表实体类
 *
 * @author 张庆福
 * @since 2021-03-28 18:48:32
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("狗")
public class Dog implements Serializable {

    private static final long serialVersionUID = 212207257666580461L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer num;

    /**
     * 删除标志:0=未删除,1=已删除
     */
    @ApiModelProperty(value = "删除标志:0=未删除,1=已删除")
    private Integer deleted;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
