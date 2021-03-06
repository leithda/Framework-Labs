package cn.leithda.mapper;

import cn.leithda.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/8
 * Description: 文章 Mapper
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {
}
