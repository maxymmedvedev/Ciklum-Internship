package controller;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import com.oracle.wls.shaded.org.apache.xalan.xsltc.cmdline.getopt.GetOpt;

import implementation.ConnectionManager;
import implementation.JDBCDataAccessor;
import interfaces.DBAcessor;
import interfaces.ProductStatus;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
	DBAcessor dao;
	String propertiesFileName = "local.properties";

	public void init(ServletConfig config) throws ServletException {
		ConnectionManager.setConnectionProps(getPropertiesFromContext());
		dao = new JDBCDataAccessor(ConnectionManager.getConnection());
	}

	public void destroy() {
		ConnectionManager.releaseConnection();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<String[]> dataOutput = null;

		String method = request.getParameter("method");
		// simple null check
		if (method == null) {
			response.getWriter().append("Please use method parameter");
		}

		RequestDispatcher dispatcher;
		switch (method) {
		case "getProductsView":
			dataOutput = dao.getProductsView();
			dispatcher = request.getRequestDispatcher("View/GetProductsView.jsp");
			break;
		case "getOrdersView":
			dataOutput = dao.getOrdersView();
			dispatcher = request.getRequestDispatcher("View/GetOrdersView.jsp");
			break;
		case "getOrderedProductsView":
			dataOutput = dao.getOrderedProductsView();
			dispatcher = request.getRequestDispatcher("View/GetOrderedProductsView.jsp");
			break;
		default:
			dispatcher = request.getRequestDispatcher("Error.jsp");
		};

		request.setAttribute("dataOutput", dataOutput);
		dispatcher.include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));

		String pageName;
		switch (request.getParameter("action")) {
		case "createOrder": {
			int productId = Integer.parseInt(request.getParameter("product_id"));
			dao.createOrder(new int[]{productId});
			pageName = "Post/createOrder/CreateOrderResult.jsp";
			break;
		}
		case "createProduct": {
			String name = request.getParameter("product_name");  
			int price = Integer.parseInt(request.getParameter("product_price"));
			ProductStatus status;
			
			status = switch (request.getParameter("product_status")) {
			case "out_of_stock" : {
				yield ProductStatus.OUT_OF_STOCK;
			}
			case "in_stock" : {
				yield ProductStatus.IN_STOCK;
			}
			case "running_low" : {
				yield ProductStatus.RUNNING_LOW;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + request.getParameter("product_status"));
			};
			
			dao.createProduct(name, price, status);
			
			pageName = "Post/createProduct/CreateProductResult.jsp";
			break;
		}

		case "updateOrderQuantities": {
			int orderId = Integer.parseInt(request.getParameter("order_id"));
			int productId = Integer.parseInt(request.getParameter("product_id"));
			int productQuantity = Integer.parseInt(request.getParameter("product_quantity"));
			
			Map<Integer, Integer> pairs = new LinkedHashMap<Integer, Integer>();
			pairs.put(productId, productQuantity);
			
			dao.updateOrderQuantities(orderId, pairs);
			pageName = "Post/updateOrderQuantities/updateOrderQuantitiesResult.jsp";
			break;
		}

		case "removeProductById": {
			int productId = Integer.parseInt(request.getParameter("product_id"));
			String password = request.getParameter("password");
			
			dao.removeProductById(productId, password);
			pageName = "Post/removeProductById/removeProductByIdResult.jsp";
			break;
		}

		case "removeAllProducts": {
			String password = request.getParameter("password");
			
			dao.removeAllProducts(password);
			pageName = "Post/removeAllProducts/removeAllProductsResult.jsp";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + request.getParameter("action"));
		}

		baos.flush();
		String message = baos.toString().replace(System.lineSeparator(), "<br/>");
		request.getSession().setAttribute("message", message);
		response.sendRedirect(pageName);
	}


}
