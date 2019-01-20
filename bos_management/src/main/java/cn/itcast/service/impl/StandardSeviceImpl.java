package cn.itcast.service.impl;

import cn.itcast.dao.StandardDao;
import cn.itcast.domain.Standard;
import cn.itcast.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StandardSeviceImpl implements StandardService {

    @Autowired
    private StandardDao standardDao;

    @Override
    public void save(Standard standard) {
        standardDao.save(standard);
    }

    @Override
    public Page<Standard> pageQuery(int page, int rows) {
        PageRequest pageable = PageRequest.of(page - 1, rows);
        return standardDao.findAll(pageable);
    }
}
