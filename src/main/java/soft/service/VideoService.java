package soft.service;

import soft.pojo.Product;
import soft.pojo.Video;

import java.util.List;

public interface VideoService {
    Video getById(String name);
    //    Admin getBytel(String aName);
    boolean insert(Video bean);
    boolean update(Video bean);
    List<Video> getList();
    boolean delete(String name);
}
