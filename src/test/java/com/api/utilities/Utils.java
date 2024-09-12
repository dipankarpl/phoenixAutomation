package com.api.utilities;

import com.api.objects.CreateJobObject;
import com.api.objects.Customer;
import com.api.objects.CustomerAddress;
import com.api.objects.CustomerProduct;
import com.api.objects.Problem;
import com.github.javafaker.Faker;
import com.google.gson.Gson;

public class Utils {

	public static String getJsonObject(Object pojo) {
		Gson gson = new Gson();
		return gson.toJson(pojo);
	}
	
	public static CreateJobObject getCreatJobPOJO() {
		Faker faker = new Faker();
		String fName = faker.name().name();
		System.out.println(fName);
		String emailAddress = faker.internet().emailAddress();
		String contactNumber = faker.numerify("98########");
		Customer customer = new Customer(fName, "N", contactNumber, null, emailAddress, null);
		CustomerAddress address = new CustomerAddress("101", "ABC Apt", "XYZ street", "PQR", "area", "410042", "India",
				"maharashtra");

		String imei = faker.numerify("124############");
		CustomerProduct product = new CustomerProduct("2023-06-10T18:30:00.000Z", imei, imei, imei,
				"2023-06-10T18:30:00.000Z", 1, 1);
		Problem[] problems = new Problem[2];
		problems[0] = new Problem(1, "test");
		problems[1] = new Problem(2, "test 233245");

		CreateJobObject createJobPOJO = new CreateJobObject(0, 2, 1, 1, customer, address, product, problems);
		return createJobPOJO;
	}

}
