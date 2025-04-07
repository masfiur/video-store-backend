// package com.movieapp.repository;

// import com.movieapp.model.User;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

// import static org.assertj.core.api.Assertions.assertThat;

// @DataMongoTest
// public class UserRepositoryTest {

//     @Autowired
//     private UserRepository userRepository;

//     @Test
//     public void testFindByEmail() {
//         // Create and save a user
//         User user = new User("test@example.com", "password");
//         userRepository.save(user);

//         // Test findByEmail method
//         User foundUser = userRepository.findByEmail("test@example.com");
//         assertThat(foundUser).isNotNull();
//         assertThat(foundUser.getEmail()).isEqualTo("test@example.com");
//     }
// }
