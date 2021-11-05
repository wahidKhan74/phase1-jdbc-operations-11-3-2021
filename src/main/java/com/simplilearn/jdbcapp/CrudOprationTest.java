package com.simplilearn.jdbcapp;

import java.util.Scanner;

import com.simplilearn.jdbcapp.dao.ProductDAO;

public class CrudOprationTest {

	public static void main(String[] args) {

		initApp();
		selectOptions();

	}

	private static void selectOptions() {

		ProductDAO productDAO = new ProductDAO();

		Scanner input = new Scanner(System.in);

		System.out.println("1 . Read products");
		System.out.println("2 . Add Product");
		System.out.println("3 . Update Product");
		System.out.println("4 . Delete Product");
		System.out.println("5 . Get One Product");
		System.out.println("6 . Get All & Total Products count");
		int option = input.nextInt();
		switch (option) {
		case 1:
			productDAO.getProducts();
			break;
		case 2:
			addProduct(productDAO);
			break;
		case 3:
			updateProduct(productDAO);
			break;
		case 4:
			deleteProduct(productDAO);
			break;
		case 5:
			getOneProduct(productDAO);
			break;
		case 6:
			productDAO.getProductsAndCount();
			break;
		default:
			System.out.println("Please select correct option");
			break;
		}
		input.close();
	}

	private static void getOneProduct(ProductDAO productDAO) {
		
		Scanner input = new Scanner(System.in);

		System.out.println("Enter product id:");
		int id = input.nextInt();
		
		productDAO.getProduct(id);
		
	}

	private static void deleteProduct(ProductDAO productDAO) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter product id:");
		int id = input.nextInt();
		
		productDAO.deleteProduct(id);
	}

	private static void updateProduct(ProductDAO productDAO) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter product name:");
		String name = input.nextLine();

		System.out.println("Enter product price:");
		double price = input.nextDouble();
		
		System.out.println("Enter product id:");
		int id = input.nextInt();

		productDAO.updateProduct(name, price, id);
		
		input.close();

	}

	private static void initApp() {
		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*   Welcome To Product Management	*");
		System.out.println("*   Perform Cruds on products table	*");
		System.out.println("*					*");
		System.out.println("==========================================");
	}

	private static void addProduct(ProductDAO productDAO) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter product name:");
		String name = input.nextLine();

		System.out.println("Enter product price:");
		double price = input.nextDouble();

		productDAO.addProduct(name, price);
	}

}
