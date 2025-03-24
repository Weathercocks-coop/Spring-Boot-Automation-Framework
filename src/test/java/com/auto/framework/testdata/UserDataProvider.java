package com.auto.framework.testdata;

import org.junit.jupiter.params.provider.Arguments;
import org.springframework.stereotype.Component;
import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;

import java.util.stream.Stream;

@Component
public class UserDataProvider {

	@DataProvider(name = "User Data", parallel = true)
	public Object[][] userDataProvider() {
		Object[][] userDataSet = { { generateUserData() }, { generateUserData() } };

		return userDataSet;

	}

	public UserModal generateUserData() {
		Faker faker = new Faker();
		return UserModal.builder().firstName(faker.name().firstName()).email(faker.internet().emailAddress())
				.currAddress(faker.address().fullAddress()).permAddress(faker.address().fullAddress())
				.age(faker.number().digit()).salary(faker.number().digits(5)).department(faker.company().name())
				.build();
	}

	public Stream<Arguments> provideData() {
		return Stream.of(
				Arguments.of(generateUserData()),
				Arguments.of(generateUserData())
		);
	}

}
