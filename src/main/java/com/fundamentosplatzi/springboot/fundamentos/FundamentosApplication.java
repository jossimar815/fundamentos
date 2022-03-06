package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.componet.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  MyBean myBean, MyBeanWithDependency myBeanWithDependency,
								  MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args){
//		ejemplosAnteriores();
		save();
		getUserInfoPorEmail();
	}

	private void getUserInfoPorEmail(){
		LOGGER.info("usuario con el email " + userRepository.buscarPorEmail("joss@email.com")
				.orElseThrow(()->new RuntimeException("No se encontro")));

		userRepository.buscarYOrdenar("user", Sort.by("id").descending()).forEach(user -> LOGGER.info(user.getName()));

		userRepository.findByName("Cathe").forEach(user -> LOGGER.info("QueryMethods " + user.getName()));
	}

	private void save(){
		User user1 = new User("Jossi", "joss@email.com", LocalDate.of(1987, 8, 15));
		User user2 = new User("Cathe", "cathe@email.com", LocalDate.of(1988, 3, 28));
		User user3 = new User("Maxi", "maxi@email.com", LocalDate.of(2016, 3, 31));
		User user4 = new User("user4", "user4@email.com", LocalDate.of(1987, 8, 15));
		User user5 = new User("user5", "user5@email.com", LocalDate.of(1988, 3, 28));
		User user6 = new User("user6", "user6@email.com", LocalDate.of(2016, 3, 31));
		User user7 = new User("user7", "user7@email.com", LocalDate.of(1987, 8, 15));
		User user8 = new User("user8", "user8@email.com", LocalDate.of(1988, 3, 28));
		User user9 = new User("user9", "user9@email.com", LocalDate.of(2016, 3, 31));
		User user10 = new User("user10", "user10@email.com", LocalDate.of(1987, 8, 15));
		User user11 = new User("user11", "user11@email.com", LocalDate.of(1988, 3, 28));
		User user12 = new User("user12", "user12@email.com", LocalDate.of(2016, 3, 31));
		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9,user10, user11, user12);
		list.stream().forEach(userRepository::save);
	}

	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printBeanWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" +userPojo.getPassword());
		try{
			int value = 10/0;
			LOGGER.debug("value: " + value);
		} catch (Exception e){
			LOGGER.error("prueba error");
		}
	}
}
