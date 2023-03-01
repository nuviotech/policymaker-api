package com.sellerPolicy.Api.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sellerPolicy.Api.entity.Categorys;
import com.sellerPolicy.Api.entity.MarketPlace;
import com.sellerPolicy.Api.entity.Product;
import com.sellerPolicy.Api.entity.ProductReviews;
import com.sellerPolicy.Api.entity.Seller;
import com.sellerPolicy.Api.entity.User;
import com.sellerPolicy.Api.jwtAuthentication.UserCustomConfigService;
import com.sellerPolicy.Api.jwtHelper.JwtUtil;
import com.sellerPolicy.Api.repo.CategorysRepository;
import com.sellerPolicy.Api.repo.MarketPlacerRepository;
import com.sellerPolicy.Api.repo.ProductRepository;
import com.sellerPolicy.Api.repo.ProductReviewRepository;
import com.sellerPolicy.Api.repo.SellerRepository;

import HelperClasses.Helper;

/**
 * @author Rohit kawade
 * 
 * **/

@CrossOrigin(origins = {"http://localhost:3000/","https://nuvio.in/","https://manageecom.com:8081/","https://manageecom.com:8083/","https://manageecom.com:8084/"}, maxAge = 3600)
@RestController
public class MainController {
	@Autowired
	private UserCustomConfigService userCustomConfigService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	SellerRepository sellerRepository;
	@Autowired
	MarketPlacerRepository marketPlacerRepository;
	@Autowired
	CategorysRepository  categorysRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductReviewRepository productReviewRepository;
	
	@GetMapping("/seller/{category}")
	public String searchSeller(@PathVariable String category) {
		
		Categorys categorys=categorysRepository.findByName(category);
	
		ObjectMapper om=new ObjectMapper();
		String str="Nan";
		List<Seller> sl=new ArrayList<>();
		try {
			for(Seller s:categorys.getSellerList()) {
				Seller sd=new Seller();
				sd.setNameOfCompany(s.getNameOfCompany());
				sd.setComponyUrl(s.getComponyUrl());
				sd.setFirstName(s.getFirstName());
				sd.setLastName(s.getLastName());
				sd.setBussinessAddr(s.getBussinessAddr());
				sd.setEmailAddr(s.getEmailAddr());
				sd.setTypeOfCompany(s.getTypeOfCompany());
				sd.setGstNo(s.getGstNo());
				sd.setPhoneNumber(s.getPhoneNumber());
				sd.setPincode(s.getPincode());
				sd.setCountry(s.getCountry());
				sd.setState(s.getState());
				
				sl.add(sd);
			}
		
			System.out.println(sl);
			str = om.writeValueAsString(sl);
			System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
		
	}
	
	@GetMapping("/marketplace/{category}")
	public String searchMarketplace(@PathVariable String category) {
		
		System.out.println("Hello i am on.. "+category);
		Categorys categorys=categorysRepository.findByName(category);
		

		ObjectMapper om=new ObjectMapper();
		String str="Nan";
		List<MarketPlace> sl=new ArrayList<>();
		try {
			for(MarketPlace s:categorys.getMarketplaceList()) {
				MarketPlace sd=new MarketPlace();
				sd.setNameOfCompany(s.getNameOfCompany());
				sd.setComponyUrl(s.getComponyUrl());
				sd.setFirstName(s.getFirstName());
				sd.setLastName(s.getLastName());
				sd.setBussinessAddr(s.getBussinessAddr());
				sd.setEmailAddr(s.getEmailAddr());
				sd.setTypeOfCompany(s.getTypeOfCompany());
				sd.setGstNo(s.getGstNo());
				sd.setPhoneNumber(s.getPhoneNumber());
				sd.setPincode(s.getPincode());
				sd.setCountry(s.getCountry());
				sd.setState(s.getState());
				
				sl.add(sd);
			}
		
			System.out.println(sl);
			str = om.writeValueAsString(sl);
			System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	@GetMapping("/getProductRefId/{catId}/{title}/{hsnId}")
	public String getProductRefId(@PathVariable String catId,@PathVariable String title,@PathVariable String hsnId) {
		String productRefId="none";
		System.out.println(catId+" " +title+" "+hsnId);
		try {
			Product p=new Product();
			productRefId="PRD_RF_ID_"+Helper.getRandomNumber();
			p.setProduct_ref_id(productRefId);
			p.setCategoryId(catId);
			p.setCreatedDateTime(new Date());
			p.setHsnNo(hsnId);
			p.setTitle(title);
			productRepository.save(p);
		}catch(Exception e) {
			productRefId="none";
			e.printStackTrace();
		}
		return productRefId;
	}
	
	@GetMapping("products/{pid}")
	public String getProduct(@PathVariable Integer pid){
		System.out.println("hello "+pid);
		if(pid==100)
			return "{\"id\":100,\"title\":\"This is my first product\",\"is_featured\":false,\"is_hot\":false,\"price\":316.38,\"sale_price\":null,\"vendor\":\"Young Shop\",\"review\":4,\"is_out_of_stock\":false,\"depot\":60,\"inventory\":80,\"is_active\":true,\"is_sale\":false,\"slug\":\"asus-chromebook-flip-10.2-inch\",\"created_at\":\"2020-03-15T06:40:02.790Z\",\"updated_at\":\"2020-07-31T09:22:29.924Z\",\"variants\":[],\"images\":[{\"id\":70,\"name\":\"16a.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"4ef330f9bd3a4bb1ba9c2b23f70772df\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":29.52,\"url\":\"/uploads/4ef330f9bd3a4bb1ba9c2b23f70772df.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-15T06:40:02.823Z\",\"updated_at\":\"2020-03-15T06:40:02.823Z\"},{\"id\":71,\"name\":\"16b.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"1eff5ff12c48444dac8ba28ac12c0790\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":14.26,\"url\":\"/uploads/1eff5ff12c48444dac8ba28ac12c0790.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-15T06:40:02.833Z\",\"updated_at\":\"2020-03-15T06:40:02.833Z\"},{\"id\":72,\"name\":\"16c.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"a25ae077a45444528b12b13c7c7c2b1e\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":13.58,\"url\":\"/uploads/a25ae077a45444528b12b13c7c7c2b1e.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-15T06:40:02.843Z\",\"updated_at\":\"2020-03-15T06:40:02.843Z\"},{\"id\":73,\"name\":\"16d.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"f71d017b2b3d46ebbacec60d7b63f9ff\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":14.61,\"url\":\"/uploads/f71d017b2b3d46ebbacec60d7b63f9ff.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-15T06:40:02.852Z\",\"updated_at\":\"2020-03-15T06:40:02.852Z\"}],\"thumbnail\":{\"id\":69,\"name\":\"15.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"6b2dca15a8f14f3f9b4f95cd6b3a6711\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":6,\"url\":\"/uploads/6b2dca15a8f14f3f9b4f95cd6b3a6711.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-15T06:40:02.813Z\",\"updated_at\":\"2020-03-15T06:40:02.813Z\"},\"product_categories\":[{\"id\":5,\"name\":\"Computers & Technologies\",\"slug\":\"computers-and-technologies\",\"created_at\":\"2020-03-14T10:26:11.462Z\",\"updated_at\":\"2020-03-14T10:26:11.462Z\"}],\"brands\":[{\"id\":9,\"name\":\"Asus\",\"slug\":\"asus\",\"created_at\":\"2020-03-14T10:32:37.085Z\",\"updated_at\":\"2020-03-14T10:32:37.085Z\"}],\"collections\":[{\"id\":6,\"name\":\"Shop Recommend Items\",\"slug\":\"shop-recommend-items\",\"created_at\":\"2020-04-05T05:37:37.071Z\",\"updated_at\":\"2020-04-05T05:37:49.638Z\"},{\"id\":2,\"name\":\"Consumer Electronics\",\"slug\":\"consumer-electronics\",\"created_at\":\"2020-04-01T05:57:39.568Z\",\"updated_at\":\"2020-07-31T09:10:21.541Z\"},{\"id\":14,\"name\":\"Electronics Best Sellers\",\"slug\":\"electronics-best-sellers\",\"created_at\":\"2020-04-18T07:07:18.660Z\",\"updated_at\":\"2020-08-05T09:00:43.663Z\"},{\"id\":15,\"name\":\"Electronics Computer & Technology\",\"slug\":\"electronic_computer_technology\",\"created_at\":\"2020-04-18T07:23:51.233Z\",\"updated_at\":\"2020-04-18T07:23:51.233Z\"}],\"stores\":[{\"id\":1,\"name\":\"Global Office\",\"slug\":\"global-office\",\"address\":\"325 Orchard Str, New York, United States (US)\",\"phone\":\" (+053) 77-637-3300\",\"created_at\":\"2021-02-15T16:10:34.972Z\",\"updated_at\":\"2021-02-15T16:13:24.951Z\",\"thumbnail\":{\"id\":369,\"name\":\"vendor-150x150.jpg\",\"alternativeText\":\"\",\"caption\":\"\",\"width\":150,\"height\":150,\"formats\":null,\"hash\":\"vendor_150x150_e7c381334d\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":4.22,\"url\":\"/uploads/vendor_150x150_e7c381334d.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2021-02-15T16:13:22.005Z\",\"updated_at\":\"2021-02-15T16:13:22.020Z\"}}]}";
		else if(pid==101)
			return "{\"id\":101,\"title\":\"This is my second product\",\"is_featured\":false,\"is_hot\":false,\"price\":1032.38,\"sale_price\":null,\"vendor\":\"Rohit Shop\",\"review\":4,\"is_out_of_stock\":false,\"depot\":60,\"inventory\":80,\"is_active\":true,\"is_sale\":false,\"slug\":\"asus-chromebook-flip-10.2-inch\",\"created_at\":\"2020-03-15T06:40:02.790Z\",\"updated_at\":\"2020-07-31T09:22:29.924Z\",\"variants\":[],\"images\":[{\"id\":70,\"name\":\"16a.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"4ef330f9bd3a4bb1ba9c2b23f70772df\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":29.52,\"url\":\"/uploads/4ef330f9bd3a4bb1ba9c2b23f70772df.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-15T06:40:02.823Z\",\"updated_at\":\"2020-03-15T06:40:02.823Z\"},{\"id\":71,\"name\":\"16b.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"1eff5ff12c48444dac8ba28ac12c0790\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":14.26,\"url\":\"/uploads/1eff5ff12c48444dac8ba28ac12c0790.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-15T06:40:02.833Z\",\"updated_at\":\"2020-03-15T06:40:02.833Z\"},{\"id\":72,\"name\":\"16c.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"a25ae077a45444528b12b13c7c7c2b1e\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":13.58,\"url\":\"/uploads/a25ae077a45444528b12b13c7c7c2b1e.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-15T06:40:02.843Z\",\"updated_at\":\"2020-03-15T06:40:02.843Z\"},{\"id\":73,\"name\":\"16d.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"f71d017b2b3d46ebbacec60d7b63f9ff\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":14.61,\"url\":\"/uploads/f71d017b2b3d46ebbacec60d7b63f9ff.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-15T06:40:02.852Z\",\"updated_at\":\"2020-03-15T06:40:02.852Z\"}],\"thumbnail\":{\"id\":69,\"name\":\"15.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"6b2dca15a8f14f3f9b4f95cd6b3a6711\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":6,\"url\":\"/uploads/6b2dca15a8f14f3f9b4f95cd6b3a6711.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-15T06:40:02.813Z\",\"updated_at\":\"2020-03-15T06:40:02.813Z\"},\"product_categories\":[{\"id\":5,\"name\":\"Computers & Technologies\",\"slug\":\"computers-and-technologies\",\"created_at\":\"2020-03-14T10:26:11.462Z\",\"updated_at\":\"2020-03-14T10:26:11.462Z\"}],\"brands\":[{\"id\":9,\"name\":\"Asus\",\"slug\":\"asus\",\"created_at\":\"2020-03-14T10:32:37.085Z\",\"updated_at\":\"2020-03-14T10:32:37.085Z\"}],\"collections\":[{\"id\":6,\"name\":\"Shop Recommend Items\",\"slug\":\"shop-recommend-items\",\"created_at\":\"2020-04-05T05:37:37.071Z\",\"updated_at\":\"2020-04-05T05:37:49.638Z\"},{\"id\":2,\"name\":\"Consumer Electronics\",\"slug\":\"consumer-electronics\",\"created_at\":\"2020-04-01T05:57:39.568Z\",\"updated_at\":\"2020-07-31T09:10:21.541Z\"},{\"id\":14,\"name\":\"Electronics Best Sellers\",\"slug\":\"electronics-best-sellers\",\"created_at\":\"2020-04-18T07:07:18.660Z\",\"updated_at\":\"2020-08-05T09:00:43.663Z\"},{\"id\":15,\"name\":\"Electronics Computer & Technology\",\"slug\":\"electronic_computer_technology\",\"created_at\":\"2020-04-18T07:23:51.233Z\",\"updated_at\":\"2020-04-18T07:23:51.233Z\"}],\"stores\":[{\"id\":1,\"name\":\"Global Office\",\"slug\":\"global-office\",\"address\":\"325 Orchard Str, New York, United States (US)\",\"phone\":\" (+053) 77-637-3300\",\"created_at\":\"2021-02-15T16:10:34.972Z\",\"updated_at\":\"2021-02-15T16:13:24.951Z\",\"thumbnail\":{\"id\":369,\"name\":\"vendor-150x150.jpg\",\"alternativeText\":\"\",\"caption\":\"\",\"width\":150,\"height\":150,\"formats\":null,\"hash\":\"vendor_150x150_e7c381334d\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":4.22,\"url\":\"/uploads/vendor_150x150_e7c381334d.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2021-02-15T16:13:22.005Z\",\"updated_at\":\"2021-02-15T16:13:22.020Z\"}}]}";
		else
			return "";
	}
	@GetMapping("products")
	public String getAllProducts() {
		return "[{\"id\":100,\"title\":\"This is my first product\",\"is_featured\":null,\"is_hot\":null,\"price\":640.5,\"sale_price\":null,\"vendor\":\"ROBERT’S STORE\",\"review\":5,\"is_out_of_stock\":null,\"depot\":80,\"inventory\":100,\"is_active\":true,\"is_sale\":false,\"slug\":null,\"created_at\":\"2020-03-14T10:34:56.811Z\",\"updated_at\":\"2020-03-14T10:39:05.919Z\",\"variants\":[],\"images\":[{\"id\":1,\"name\":\"1a.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"114071762b454d09aca0e0a95ad3885d\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":8.78,\"url\":\"/uploads/114071762b454d09aca0e0a95ad3885d.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-14T10:39:17.429Z\",\"updated_at\":\"2020-03-14T10:39:17.429Z\"},{\"id\":2,\"name\":\"1c.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"f73c23a548694e8fb0435aa0644cc570\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":10.88,\"url\":\"/uploads/f73c23a548694e8fb0435aa0644cc570.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-14T10:39:17.444Z\",\"updated_at\":\"2020-03-14T10:39:17.444Z\"},{\"id\":3,\"name\":\"1b.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"af86c8d6136b4bb8805354995c3e6ed8\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":4.5,\"url\":\"/uploads/af86c8d6136b4bb8805354995c3e6ed8.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-14T10:39:17.458Z\",\"updated_at\":\"2020-03-14T10:39:17.458Z\"}],\"thumbnail\":{\"id\":4,\"name\":\"1a.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"5a1586c7d04646fda4575e5af5c16c30\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":8.78,\"url\":\"/uploads/5a1586c7d04646fda4575e5af5c16c30.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-14T10:41:20.970Z\",\"updated_at\":\"2020-03-14T10:41:20.970Z\"},\"product_categories\":[{\"id\":7,\"name\":\"Phones & Accessories\",\"slug\":\"phones-and-accessories\",\"created_at\":\"2020-03-14T10:26:54.185Z\",\"updated_at\":\"2020-03-14T10:26:54.185Z\"}],\"brands\":[{\"id\":1,\"name\":\"Apple\",\"slug\":\"apple\",\"created_at\":\"2020-03-14T10:30:03.468Z\",\"updated_at\":\"2020-03-14T10:30:31.584Z\"}],\"collections\":[{\"id\":7,\"name\":\"Shop Top Deals Super Hot Today\",\"slug\":\"shop-top-deals-super-hot-today\",\"created_at\":\"2020-04-12T06:34:11.408Z\",\"updated_at\":\"2020-08-05T09:09:03.737Z\"},{\"id\":13,\"name\":\"Technology Good Price\",\"slug\":\"technology-good-price\",\"created_at\":\"2020-04-18T06:46:54.898Z\",\"updated_at\":\"2020-08-05T10:41:39.751Z\"},{\"id\":9,\"name\":\"New Arrivals Products\",\"slug\":\"new-arrivals-products\",\"created_at\":\"2020-04-12T06:36:23.687Z\",\"updated_at\":\"2020-08-05T08:25:55.008Z\"},{\"id\":20,\"name\":\"Customer Bought Products\",\"slug\":\"customer-bought-products\",\"created_at\":\"2020-04-19T08:37:10.179Z\",\"updated_at\":\"2020-07-31T09:10:17.080Z\"}],\"stores\":[{\"id\":1,\"name\":\"Global Office\",\"slug\":\"global-office\",\"address\":\"325 Orchard Str, New York, United States (US)\",\"phone\":\" (+053) 77-637-3300\",\"created_at\":\"2021-02-15T16:10:34.972Z\",\"updated_at\":\"2021-02-15T16:13:24.951Z\",\"thumbnail\":{\"id\":369,\"name\":\"vendor-150x150.jpg\",\"alternativeText\":\"\",\"caption\":\"\",\"width\":150,\"height\":150,\"formats\":null,\"hash\":\"vendor_150x150_e7c381334d\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":4.22,\"url\":\"/uploads/vendor_150x150_e7c381334d.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2021-02-15T16:13:22.005Z\",\"updated_at\":\"2021-02-15T16:13:22.020Z\"}}]},{\"id\":101,\"title\":\"This is my second product\",\"is_featured\":false,\"is_hot\":false,\"price\":150,\"sale_price\":null,\"vendor\":\"Young Shop\",\"review\":4,\"is_out_of_stock\":false,\"depot\":80,\"inventory\":100,\"is_active\":true,\"is_sale\":false,\"slug\":null,\"created_at\":\"2020-03-15T05:47:28.790Z\",\"updated_at\":\"2020-03-15T06:03:15.417Z\",\"variants\":[],\"images\":[{\"id\":6,\"name\":\"1a.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"0e9b9750228b421aafe324f6f9b36304\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":8.78,\"url\":\"/uploads/0e9b9750228b421aafe324f6f9b36304.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-15T05:47:28.833Z\",\"updated_at\":\"2020-03-15T05:47:28.833Z\"},{\"id\":7,\"name\":\"1b.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"99cdb1e5a2874365bab8f49ea1fc7070\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":4.5,\"url\":\"/uploads/99cdb1e5a2874365bab8f49ea1fc7070.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-15T05:47:28.857Z\",\"updated_at\":\"2020-03-15T05:47:28.857Z\"},{\"id\":8,\"name\":\"1c.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"2ed1134b99b146feb6245f8e07201ec8\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":10.88,\"url\":\"/uploads/2ed1134b99b146feb6245f8e07201ec8.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-15T05:47:28.869Z\",\"updated_at\":\"2020-03-15T05:47:28.869Z\"}],\"thumbnail\":{\"id\":5,\"name\":\"1.jpg\",\"alternativeText\":null,\"caption\":null,\"width\":null,\"height\":null,\"formats\":null,\"hash\":\"4c07bca3f13444688823a1c099410884\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":9.04,\"url\":\"/uploads/4c07bca3f13444688823a1c099410884.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2020-03-15T05:47:28.819Z\",\"updated_at\":\"2020-03-15T05:47:28.819Z\"},\"product_categories\":[{\"id\":7,\"name\":\"Phones & Accessories\",\"slug\":\"phones-and-accessories\",\"created_at\":\"2020-03-14T10:26:54.185Z\",\"updated_at\":\"2020-03-14T10:26:54.185Z\"}],\"brands\":[{\"id\":1,\"name\":\"Apple\",\"slug\":\"apple\",\"created_at\":\"2020-03-14T10:30:03.468Z\",\"updated_at\":\"2020-03-14T10:30:31.584Z\"}],\"collections\":[{\"id\":7,\"name\":\"Shop Top Deals Super Hot Today\",\"slug\":\"shop-top-deals-super-hot-today\",\"created_at\":\"2020-04-12T06:34:11.408Z\",\"updated_at\":\"2020-08-05T09:09:03.737Z\"},{\"id\":9,\"name\":\"New Arrivals Products\",\"slug\":\"new-arrivals-products\",\"created_at\":\"2020-04-12T06:36:23.687Z\",\"updated_at\":\"2020-08-05T08:25:55.008Z\"}],\"stores\":[{\"id\":1,\"name\":\"Global Office\",\"slug\":\"global-office\",\"address\":\"325 Orchard Str, New York, United States (US)\",\"phone\":\" (+053) 77-637-3300\",\"created_at\":\"2021-02-15T16:10:34.972Z\",\"updated_at\":\"2021-02-15T16:13:24.951Z\",\"thumbnail\":{\"id\":369,\"name\":\"vendor-150x150.jpg\",\"alternativeText\":\"\",\"caption\":\"\",\"width\":150,\"height\":150,\"formats\":null,\"hash\":\"vendor_150x150_e7c381334d\",\"ext\":\".jpg\",\"mime\":\"image/jpeg\",\"size\":4.22,\"url\":\"/uploads/vendor_150x150_e7c381334d.jpg\",\"previewUrl\":null,\"provider\":\"local\",\"provider_metadata\":null,\"created_at\":\"2021-02-15T16:13:22.005Z\",\"updated_at\":\"2021-02-15T16:13:22.020Z\"}}]}]";
	}
	
	@GetMapping("products/count")
	public int getCount(){
		return 2;
	}
	
	@GetMapping("/getReviews/{prd_ref_id}")
	public String  getProductReviews(@PathVariable String prd_ref_id){
		ObjectMapper om=new ObjectMapper();
		String str="wrong product ref id !!!";
		try {
		List<ProductReviews> prList=new ArrayList<>();
		Product p=productRepository.getById(prd_ref_id);
		for(ProductReviews pr:p.getProductReviews()) {
			ProductReviews productReview=new ProductReviews();
			productReview.setReviewId(pr.getReviewId());
			productReview.setReviwerId(pr.getReviwerId());
			productReview.setFeedback(pr.getFeedback());
			productReview.setImagUrls(pr.getImagUrls());
			productReview.setDate((Date)pr.getDate());
			productReview.setRating(pr.getRating());
			prList.add(productReview);
		}
		str= om.writeValueAsString(prList);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	@PostMapping("/addReviews/{product_ref_id}")
	public String addProductReviews(@RequestBody ProductReviews productReviews,@PathVariable String product_ref_id) {
		
		Product p= productRepository.getById(product_ref_id);
		if(p==null) {
			return "none";
		}else {
			productReviews.setDate(new Date());
			productReviews.setProduct(p);
			List<ProductReviews> prList=p.getProductReviews();
			prList.add(productReviews);
			p.setProductReviews(prList);
			productReviewRepository.save(productReviews);
			return "done";
		}
	}
	
	@GetMapping("/getSellers")
	public List getAllSellersDetails(@RequestParam("page") int page) {
		Pageable pageble = PageRequest.of(page, 5);
		List<Seller> sellers=new ArrayList<>();
		for(Seller s: sellerRepository.findAll(pageble)) {
			s.setPassword("NONE");
			sellers.add(s);
		}
		return sellers;
	}
	
	@GetMapping("/getTotalCountOfSeller")
	public String getTotalCountOfSeller() {
		int num=sellerRepository.findAll().size();
		return ""+num;
	}
	
	@GetMapping("/activeDeactiveSeller")
	public String activeDeactiveSeller(@RequestParam("idsr") int id,@RequestParam("action") String action) {
		Seller seller=sellerRepository.findById(id).get();
		if(action.equals("Active")) {
			seller.setIs_active(1);
		}else if(action.equals("Deactive")) {
			seller.setIs_active(0);
		}
		sellerRepository.save(seller);
		return "done";
	}
	
	@GetMapping("/activeDeactiveSellerByMarketplace")
	public String activeDeactiveSellerByMarketplace(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,@RequestParam("idsr") int id,@RequestParam("action") String action) {
		System.out.println("I am here");
		MarketPlace marketplace=marketPlacerRepository.findByEmailAddr(jwtUtil.getUsernameFromToken(token.substring(7)));
		Seller seller=sellerRepository.findById(id).get();
		if(action.equals("Active")) {
			if(marketplace.getActiveSellers().contains(seller)) {
				System.out.println("return 1");
				return "1";
			}else {
				marketplace.getActiveSellers().add(seller);
			}
		}else if(action.equals("Deactive")) {
			marketplace.getActiveSellers().remove(seller);
		}
		marketPlacerRepository.save(marketplace);
		System.out.println("return 0");
		return "0";
	}
	
	
	
	//login process for get the token for authentication api
			@PostMapping("/login")
			public String generateToken(@RequestBody User u) throws Exception{
				MarketPlace user=new MarketPlace();
				user.setPassword(u.getPassword());
				user.setEmailAddr(u.getEmail());
				System.out.println("I am here");
				try {
					System.out.println("Marketplace login details "+user.getEmailAddr()+" | "+user.getPassword());
					this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmailAddr() , user.getPassword()));
					
				}catch(UsernameNotFoundException e) {
					e.printStackTrace();
					throw new Exception("### Invalid username!!");
				}catch(BadCredentialsException e){
					e.printStackTrace();
					return "{\"message\" : \"Invalid email or password..\",\"status\":1}";
					//throw new Exception("### Bad credentials!!");
				}
				//generate the token
				UserDetails userDetails= this.userCustomConfigService.loadUserByUsername(user.getEmailAddr());
				String token=this.jwtUtil.generateToken(userDetails);
				System.out.println("Login success");
				return "{ \"Token\" : \""+token+"\", \"status\":0}";

			}
			
			
			@GetMapping("/getMarketplaceDetails")
			public String getUserDatails(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
				String email=jwtUtil.getUsernameFromToken(jwtToken.substring(7));
				System.out.println("User m email : "+email);
				MarketPlace user=marketPlacerRepository.findByEmailAddr(email);
				System.out.println("Marketplace "+user.getFirstName() +" "+user.getLastName());
				user.setPassword(null);
				
				ObjectMapper mapper=new ObjectMapper();
				try {
				    String json=mapper.writeValueAsString(user);
				//    String json2=mapper.writeValueAsString(orders);
					return json;

				}catch(Exception e) {
					System.out.println("error : "+e.getMessage());
					return e.getMessage();
				}
			}
}
