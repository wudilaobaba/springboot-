package com.whj.springbootcode.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * PagingDozer继承了Paging
 * PagingDozer多了一步属性拷贝的步骤
 * T是实际查询出来的item的类型
 * K是经过属性拷贝后，返回到前端的目标类型
 * @param <T,K>
 */
public class PagingDozer<T,K> extends Paging{ //继承泛型类
    /**
     *
     * @param pageT 数据库查询到的真实数据，以Page类型返回
     * @param classK 返回到前端的目标类型的原类
     */
    public PagingDozer(Page<T> pageT, Class<K> classK){//参数为controller中的查询结果
        //初始化total、count、page、totalPage的属性值
        this.initPageParameters(pageT);

        //属性拷贝
        List<T> tList = pageT.getContent();//获取原数据
        //定义转换为vo的对象，固定写法
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> voList = new ArrayList<>();//目标类型
        //循环遍历转换vo并追加到vos中
        tList.forEach(t->{//s就是每一个spu
            K vo = mapper.map(t,classK);//第二个参数是目标对象的原类,由外面传入
            voList.add(vo);
        });
        this.setItems(voList);
    }
}
