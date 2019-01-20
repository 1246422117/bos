package cn.itcast.service;

import cn.itcast.domain.Standard;
import org.springframework.data.domain.Page;

public interface StandardService {

    public void save(Standard standard);

    Page<Standard> pageQuery(int page, int rows);
}
