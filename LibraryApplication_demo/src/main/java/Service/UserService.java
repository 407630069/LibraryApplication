package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Dao.UserRepository;
import model.Book;
import model.User;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UserService {
    
	@Autowired
    private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	public ResponseEntity<String> registerUser(String phoneNumber, String password, String userName) {

        User existingUser = userRepository.findByPhoneNumber(phoneNumber);
        if (existingUser != null) {
            return ResponseEntity.badRequest().body("手機號碼已被註冊");
        }

        //hash
        String salt = generateSalt();
        String hashedPassword = hashPassword(password);

       
        User newUser = new User();
        newUser.setPhoneNumber(phoneNumber);
        newUser.setPassword(hashedPassword);
        newUser.setUserName(userName);
        newUser.setRegistrationTime(LocalDateTime.now());

        
        userRepository.save(newUser);

        return ResponseEntity.ok("註冊成功");
    }

    
    private String generateSalt() {
		return null;
        
    }

    private String hashPassword(String password) {
		return password;
        
    }

    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    
    public User getUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }
    
    
    public boolean authenticateUser(String phoneNumber, String password) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            user.setLastLoginTime(LocalDateTime.now());
            userRepository.save(user);
            return true;
        }
        return false;
    }


	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return new User();
	}


	public Book getBookByIsbn(String isbn) {
		
		return new Book();
	}


	public void returnBook(User user, Book book) {
		
		
	}


	public void borrowBook(User user, Book book) {
		
		
	}

    
}
