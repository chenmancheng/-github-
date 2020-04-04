package soft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soft.mapper.VideoMapper;
import soft.pojo.Product;
import soft.pojo.Video;
import soft.service.ProductService;
import soft.service.VideoService;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoMapper videoMapper;


    @Override
    public Video getById(String name) {
        return videoMapper.getById(name);
    }

    @Override
    public boolean insert(Video bean) {
        return videoMapper.insert(bean);
    }

    @Override
    public boolean update(Video bean) {
        return videoMapper.update(bean);
    }

    @Override
    public List<Video> getList() {
        return videoMapper.getList();
    }

    @Override
    public boolean delete(String name) {
        return videoMapper.delete(name);
    }
}
