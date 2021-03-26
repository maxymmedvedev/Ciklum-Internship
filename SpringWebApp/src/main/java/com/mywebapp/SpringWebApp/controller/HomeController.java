package com.mywebapp.SpringWebApp.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.mywebapp.SpringWebApp.interfaces.DBAcessor;

import com.mywebapp.SpringWebApp.interfaces.ProductStatus;

@Controller
public class HomeController {
	@Autowired
	@Qualifier("JDBCAccessor")
	private DBAcessor dao;
	
	@GetMapping(value="/hello")
	public String doGet(Model model, WebRequest request) throws IOException{
		ArrayList<String[]> dataOutput = null;
		String page;
		String method = request.getParameter("method");
		
		System.out.println("Inside doGet");
		
		if(method == null) return "Error";
		
		switch (method) {
		case "getProductsView":
			dataOutput = dao.getProductsView();
			page = "View/GetProductsView";
			break;
		case "getOrdersView":
			dataOutput = dao.getOrdersView();
			page = "View/GetOrdersView";
			break;
		case "getOrderedProductsView":
			dataOutput = dao.getOrderedProductsView();
			page = "View/GetOrderedProductsView";
			break;
		default:
			page = "Error";
		};
		
		model.addAttribute("dataOutput", dataOutput);
		return page;
	}
	
	@PostMapping(value="/hello")
	public RedirectView doPost(WebRequest request, RedirectAttributes attributes) throws IOException{
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		System.setOut(new PrintStream(baos));
		System.out.println("Inside doPost");
		String page;
		String action = request.getParameter("action");
		if(action == null) return new RedirectView("Error" + ".jsp");
		
		switch (action) {
		case "createOrder": {
			int productId = Integer.parseInt(request.getParameter("product_id"));
			dao.createOrder(new int[]{productId});
			page = "Post/createOrder/CreateOrderResult";
			break;
		}
		case "createProduct": {
			String name = request.getParameter("product_name");  
			int price = Integer.parseInt(request.getParameter("product_price"));
			ProductStatus status;
			
			switch (request.getParameter("product_status")) {
				case "out_of_stock" : {
					status =  ProductStatus.OUT_OF_STOCK;
					break;
				}
				case "in_stock" : {
					status =  ProductStatus.IN_STOCK;
					break;
				}
				case "running_low" : {
					status =  ProductStatus.RUNNING_LOW;
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + request.getParameter("product_status"));
				};
		
			
			dao.createProduct(name, price, status);
			
			page = "Post/createProduct/CreateProductResult";
			break;
		}

		case "updateOrderQuantities": {
			int orderId = Integer.parseInt(request.getParameter("order_id"));
			int productId = Integer.parseInt(request.getParameter("product_id"));
			int productQuantity = Integer.parseInt(request.getParameter("product_quantity"));
			
			Map<Integer, Integer> pairs = new LinkedHashMap<Integer, Integer>();
			pairs.put(productId, productQuantity);
			
			dao.updateOrderQuantities(orderId, pairs);
			page = "Post/updateOrderQuantities/updateOrderQuantitiesResult";
			break;
		}

		case "removeProductById": {
			int productId = Integer.parseInt(request.getParameter("product_id"));
			String password = request.getParameter("password");
			System.out.println("Deleting product #" + productId );
			System.out.println("With password" + password );
			dao.removeProductById(productId, password);
			page = "Post/removeProductById/removeProductByIdResult";
			break;
		}

		case "removeAllProducts": {
			String password = request.getParameter("password");
			
			dao.removeAllProducts(password);
			page = "Post/removeAllProducts/removeAllProductsResult";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + request.getParameter("action"));
		}
		
//		baos.flush();
//		String message = baos.toString().replace(System.lineSeparator(), "<br/>");
//		attributes.addFlashAttribute("message", message);
		return new RedirectView(page + ".jsp");
	}
	
}
