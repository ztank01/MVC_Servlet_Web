package vn.VietTech.controller.web;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.VietTech.model.ProductModel;
import vn.VietTech.service.ProductService;
import vn.VietTech.service.Impl.ProductServiceImpl;
@WebServlet(name = "LoadMoreController", urlPatterns = {"/load"})
public class LoadMoreController extends HttpServlet {

	private static final long serialVersionUID = -2003030682123843617L;
	ProductService productSerive  = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
         //tam thoi load ra 3 san pham truoc 
         String amount = request.getParameter("exits");
         int iamount = Integer.parseInt(amount);
         List<ProductModel> list = productSerive.getNext3Product(iamount);
         PrintWriter out = response.getWriter();
         for (ProductModel o : list) {
             out.println("<div class=\"col-md-4 col-sm-4 col-xs-10\">\r\n" + 
             		"								<div class=\"product product-item\">\r\n" + 
             		"									<div class=\"pi-img-wrapper\">\r\n" + 
             		"										<c:url value=\"/image?fname="+o.getImage()+"\" var=\"imgUrl\"></c:url>\r\n" + 
             		"										<td><img src=\"/DoAnCuoiKy/image?fname="+o.getImage()+"\" class=\"img-responsive\"\r\n" + 
             		"											alt=\"Berry Lace Dress\" /></td>\r\n" + 
             		"										<div>\r\n" + 
             		"											<div class=\"card-body\">\r\n" + 
             		"												<a href=\"\" data-toggle=\"modal\" data-target=\"#productModal\">\r\n" + 
             		"													<img class=\"img-fluid\" src=\"${imgUrl}\" />\r\n" + 
             		"													<p class=\"btn btn-default fancybox-button\">Zoom</p>\r\n" + 
             		"												</a>\r\n" + 
             		"											</div>\r\n" + 
             		"											<a href=\"productdetail?pid="+o.getId()+"\"\r\n" + 
             		"												class=\"btn btn-default fancybox-fast-view\">XEM CHI TIẾT</a>\r\n" + 
             		"										</div>\r\n" + 
             		"									</div>\r\n" + 
             		"									<h3>\r\n" + 
             		"										<a href=\"shop-item.html\">"+o.getName()+"</a>\r\n" + 
             		"									</h3>\r\n" + 
             		"									<div class=\"pi-price\">$ "+o.getPrice()+"</div>\r\n" + 
             		"									<a href=\"#\" class=\"btn btn-default add2cart\">THÊM VÀO GIỎ HÀNG\r\n" + 
             		"										</a>\r\n" + 
             		"								</div>\r\n" + 
             		"\r\n" + 
             		"							</div>");
         }
    }
}
