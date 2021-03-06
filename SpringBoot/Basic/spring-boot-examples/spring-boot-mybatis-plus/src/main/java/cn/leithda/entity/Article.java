package cn.leithda.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class Article {
    /**
     *
     */

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    private String title;

    /**
     *
     */
    private String content;

    /**
     * 逻辑删除字段 0-正常,1-删除
     */
    @TableLogic
    private Integer status;
}

