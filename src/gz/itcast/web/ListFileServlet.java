package gz.itcast.web;

import gz.itcast.entity.FileBean;
import gz.itcast.service.FileBeanService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 所有文件的servlet
 * @author APPle
 *
 */
public class ListFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileBeanService service = new FileBeanService();

		List<FileBean> list = service.findAll();

		request.setAttribute("list", list);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
