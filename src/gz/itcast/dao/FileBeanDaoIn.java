package gz.itcast.dao;

import gz.itcast.entity.FileBean;

import java.util.List;

public interface FileBeanDaoIn {
    public void  saveFile(FileBean bean);//保存文件信息
    public FileBean finfById(int id);//根据ID查找文件
    public List<FileBean> findAll();
}
