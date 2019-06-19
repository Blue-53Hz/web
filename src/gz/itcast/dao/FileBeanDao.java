package gz.itcast.dao;

import gz.itcast.entity.FileBean;
import gz.itcast.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

public class FileBeanDao implements FileBeanDaoIn {


    @Override
    public void saveFile(FileBean bean) {
        QueryRunner qr =new QueryRunner(JdbcUtil.getDataSource());
        try {
            qr.update("insert into file_list(name,size,type,addtime,file_path,info) values(?,?,?,?,?,?)",new Object[]{bean.getName(),bean.getSize(),bean.getType(),bean.getAddTime(),
                            bean.getFile_path(),bean.getInfo()});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public FileBean finfById(int id) {
       QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        try {
            return(FileBean) qr.query("select * from file_list where id=?",new BeanHandler(FileBean.class),new Object[]{id});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<FileBean> findAll(){
        try {
            QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
            return (List<FileBean>)qr.query("select * from file_list",
                    new BeanListHandler(FileBean.class),
                    new Object[]{});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        FileBeanDao dao=new FileBeanDao();
//        FileBean bean=new FileBean();
//        bean.setInfo("描述");
//        bean.setName("aaaaa.jpg");
//        bean.setSize("23KB");
//        bean.setType("image/jpg");
//        bean.setAddTime("2015-06-30 17:23:32");
//        bean.setFile_path("/upload/10/3/aaaaa.jpg");
//        dao.saveFile(bean);
         FileBean fileBean=dao.finfById(1);
         System.out.println(fileBean);



    }
}
